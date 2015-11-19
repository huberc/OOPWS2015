/**
 * Created by Christoph on 18.11.2015.
 */
public abstract class Holzvollernter {

	private static Integer idSequence = 1;

	/**
	 * Ensure uniqueness of IDs by making it only accessible through this method
	 * 
	 * @return the current value of the id sequence, i.e. the next id to assign
	 *         to a new "Vollernter" (1-based). After the current id value was
	 *         fetched, the sequence is incremented. This method is thread-safe
	 */
	protected final int fetchId() {
		int retVal;
		synchronized (Holzvollernter.idSequence) {
			retVal = Holzvollernter.idSequence++;
		}
		return retVal;
	}

	private int id;
	private AbstractArbeitskopf arbeitskopf;
	private Number distanceMoved;

	public AbstractArbeitskopf getArbeitskopf() {
		return arbeitskopf;
	}

	public void setArbeitskopf(AbstractArbeitskopf arbeitskopf) {
		this.arbeitskopf = arbeitskopf;
	}

	public Number getDistanceMoved() {
		return distanceMoved;
	}

	/**
	 * Implementation-defined method to add a distance value to the total
	 * distance this <code>Holzvollernter</code> moved. Depending on the manner
	 * of moving of this vollernter, implementations my treat the passed-in
	 * number differently.
	 * 
	 * @param distanceMoved
	 *            a <code>Number</code> describing the distance this vollernter
	 *            moved during its time in service. Depending on the actual
	 *            distance unit used by the implementation loss of precision in
	 *            input number is possible. The value passed here is added to
	 *            the current total distance the vollernter moved
	 */
	public abstract void addDistanceMoved(Number distanceMoved);

	public int getId() {
		return id;
	}
}
