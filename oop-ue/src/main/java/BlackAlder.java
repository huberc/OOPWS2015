/**
 * Created by ines on 26.10.2015.
 */
public class BlackAlder extends AbstractTree {
	public void grow(WeatherConditions weather, double spaceAvailable) {
		this.setAge(this.getAge() + 1);

		// Influence weather conditions
		double temp = weather.getAvgTemperature();
		double rain = weather.getRainfall();
		int inf = 1;

		if (temp < 3) {
			double help = -4 - temp;
			inf -= help / 10;
		} else if (temp > 14) {
			double help = temp - 9;
			inf -= help / 10;
		} else if (rain < 450) {
			double help = 400 - rain;
			inf -= help / 1000;
		} else if (rain > 1300) {
			double help = rain - 800;
			inf -= help / 1000;
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
				this.setDiameter(this.getDiameter() + this.getAge() / 10 * inf);
			} else if ((this.getAge() > 10) && (this.getAge() <= 100)) {
				this.setDiameter(this.getDiameter()
						+ (5.98 * Math.pow(10, -4) * Math.pow(this.getAge(), 2)
								- 0.13 * this.getAge() + 7.29) * inf);
			} else {
				this.setDiameter(this.getDiameter()
						+ (0.2 / (this.getAge() / 100)) * inf);
			}
		}

		// usable from the age of 4
		if (this.getAge() < 4) {
			this.setUseablePercentage(0);
		} else if (this.getAge() == 4) {
			this.setUseablePercentage(75);
		}

		// wood grow
		double useableWood = (Math.pow(this.getDiameter() * 100, 2) / 1000)
				+ (Math.pow(this.getDiameter() * 100, 2) / 1000)
				* (this.getHeight() - 27) * 0.03;
		this.setWood(useableWood * 100.0 / 75.0);

		// change of used space
		double r = 0.1675 * Math.pow(this.getDiameter() * 100, 0.97);
		this.setUsedSpace(Math.pow(r, 2) * Math.PI);
	}

	public void rot() {
		this.setWood(this.getDeathwood()
				* Math.pow(Math.E, -0.1 * this.getAge()));
	}
}
