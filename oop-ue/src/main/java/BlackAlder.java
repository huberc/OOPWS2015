/**
 * Created by ines on 26.10.2015.
 */
public class BlackAlder extends AbstractTree {
	
	public BlackAlder(){
		super();
		// initial values for functions
		this.setHeight(0.2);
		this.setDiameter(0.02);
	}
	
	public void grow(WeatherConditions weather, double spaceAvailable) {
		this.setAge(this.getAge() + 1);

		// Influence weather conditions
		double temp = weather.getAvgTemperature();
		double rain = weather.getRainfall();
		double inf = 1.0;

		if (temp < 3) {
			double help = 3.0 - temp;
			inf -= help / 10.0;
		} else if (temp > 14) {
			double help = temp - 14.0;
			inf -= help / 10.0;
		} 
		if (rain < 450) {
			double help = 450.0 - rain;
			inf -= help / 1000.0;
		} else if (rain > 1300.0) {
			double help = rain - 1300.0;
			inf -= help / 1000.0;
		}

		if (inf < 0) {
			this.setState(TreeState.DEAD);
			this.setDeathwood(this.getWood());
			return;
		}

		// height grow
		if (this.getAge() <= 10) {
			this.setHeight(this.getHeight() + 1 * inf);
		} else {
			this.setHeight(this.getHeight()
					+ ((12 - this.getAge() / 15) / this.getAge()) * inf);
		}

		// diameter grow
		if (spaceAvailable > 0.1) {
			if (this.getAge() <= 10) {
				this.setDiameter(this.getDiameter()
						+ (((double) this.getAge() / 10.0) * inf) / 100.0);
			} else if ((this.getAge() > 10) && (this.getAge() <= 100)) {
				this.setDiameter(this.getDiameter()
						+ ((5.98 * Math.pow(10, -4)
								* Math.pow(this.getAge(), 2) - 0.13
								* this.getAge() + 7.29) * inf) / 1000.0);
			} else {
				this.setDiameter(this.getDiameter()
						+ (0.2 / (this.getAge() / 100)) * inf);
			}
		}

		// usable from the age of 4
		if (this.getAge() < 4) {
			this.setUseablePercentage(0);
		} else if (this.getAge() == 4) {
			this.setUseablePercentage(0.75);
		}

		// wood grow
		this.setWood(Math.pow(this.getDiameter() / 2, 2) * Math.PI
				* (double) this.getHeight());

		// change of used space
		double r = 0.1675 * Math.pow(this.getDiameter() * 100, 0.97);
		this.setUsedSpace(Math.pow(r, 2) * Math.PI);
	}

	public String toString() {
		return "Schwarzerle";
	}
}
