/**
 * Created by ines on 27.10.2015.
 */
public class Spruce extends AbstractTree {

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
		} else if (rain < 400) {
			double help = 400.0 - rain;
			inf -= help / 1000.0;
		} else if (rain > 800) {
			double help = rain - 800.0;
			inf -= help / 1000.0;
		}

		if (inf < 0) {
			this.setDeathwood(this.getWood());
			this.setState(TreeState.DEAD);
			return;
		}

		// height grow
		this.setHeight(this.getHeight() + 0.02
				* Math.pow(this.getAge(), 2)
				* Math.pow(Math.E, (-0.1 * this.getAge())) * inf);

		// diameter grow
		if (spaceAvailable > 0.1) {
			this.setDiameter(1 / (1 + Math.pow(Math.E,
					(-0.05 * (this.getAge() - 60)))));
		}

		// usable from the age of 9
		if (this.getAge() < 9) {
			this.setUseablePercentage(0);
		} else if (this.getAge() == 9) {
			this.setUseablePercentage(84);
		}

		// wood grow
		double useableWood = Math.pow(this.getDiameter() / 2, 2) * Math.PI
				* (double) this.getHeight();
		this.setWood(useableWood * 100.0 / 75.0);

		// change of used space
		double r = 0.0466 * Math.pow(this.getDiameter() * 100, 1.1778);
		this.setUsedSpace(Math.pow(r, 2) * Math.PI);
	}

	public void rot() {
		this.setWood(this.getDeathwood()
				* Math.pow(Math.E, -0.1 * this.getAge()));
	}
	public String toString(){
		return "Fichte";
	}
}
