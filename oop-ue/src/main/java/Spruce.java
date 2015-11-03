/**
 * The Spruce is one of the most common evergreen trees in Austria.
 * It grows slower then most trees but uses little space and can be used to a big percentage.
 *
 * more common in energy wood
 *
 * @author Ines
 *
 */
public class Spruce extends AbstractTree {

    /**
     * A new Spruce is created and variables are set.
     */
	public Spruce(){
		super();
		// initial values for functions
		this.setHeight(0.2);
		this.setDiameter(0.02);
	}

    /**
     * Every year a tree grows or rots depending on it's state (see AbstractTree)
     *
     * @param weather
     *            the current <code>WeatherConditions</code> influences the grow of the tree
     *              (if bad it can slow down the growth or even kill the tree)
     * @param spaceAvailable
     *            the space (in square meters) by which this tree can grow
     *            before touching another tree. If zero, the tree cannot grow in
     *            width anymore (but may still grow in height.
     */
    public void grow(WeatherConditions weather, double spaceAvailable) {
		this.setAge(this.getAge() + 1);
		// Influence weather conditions
		double temp = weather.getAvgTemperature();
		double rain = weather.getRainfall();
		double inf = 1.0;

		if (temp < -4) {
			double help = -4.0 - temp;
			inf -= help / 10.0;
		} else if (temp > 9) {
			double help = temp - 9.0;
			inf -= help / 10.0;
		} 
		if (rain < 400) {
			double help = 400.0 - rain;
			inf -= help / 1000.0;
		} else if (rain > 1100) {
			double help = rain - 1100.0;
			inf -= help / 1000.0;
		}

		if (inf < 0) {
			this.setDeathwood(this.getWood());
			this.setState(TreeState.DEAD);
			return;
		}

		// height growth
		this.setHeight(this.getHeight() + 0.02
				* Math.pow(this.getAge(), 2)
				* Math.pow(Math.E, (-0.1 * this.getAge())) * inf);

		// diameter growth
		if (spaceAvailable > 0.1) {
			this.setDiameter(1 / (1 + Math.pow(Math.E,
					(-0.05 * (this.getAge() - 60)))));
		}

		// usable from the age of 9
		if (this.getAge() < 9) {
			this.setUseablePercentage(0);
		} else if (this.getAge() == 9) {
			this.setUseablePercentage(0.84);
		}

		// wood growth
		double useableWood = Math.pow(this.getDiameter() / 2, 2) * Math.PI
				* (double) this.getHeight();
		this.setWood(useableWood);

		// change of used space
		double r = 0.0466 * Math.pow(this.getDiameter() * 100, 1.1778);
		this.setUsedSpace(Math.pow(r, 2) * Math.PI);
	}

    /**
     * needed String for output in console
     * @return german name of the tree
     */
    public String toString(){
		return "Fichte";
	}
}
