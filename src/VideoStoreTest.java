import junit.framework.*;

public class VideoStoreTest extends TestCase {

	private Statement statement;
	private final double DELTA = .001;
	private Movie newReleaseMovie1;
	private Movie newReleaseMovie2;
	private Movie childrensMovie;
	private Movie regular1;
	private Movie regular2;
	private Movie regular3;

	public VideoStoreTest(String name) {
		super(name);
	}

	protected void setUp() {
		statement = new Statement("Fred");
		newReleaseMovie1 = new Movie("New Release 1", Movie.NEW_RELEASE);
		newReleaseMovie2 = new Movie("New Release 2", Movie.NEW_RELEASE);
		childrensMovie = new Movie("Childrens", Movie.CHILDRENS);
		regular1 = new Movie("Regular 1", Movie.REGULAR);
		regular2 = new Movie("Regular 2", Movie.REGULAR);
		regular3 = new Movie("Regular 2", Movie.REGULAR);
	}

	public void testSingleNewReleaseStatementTotals() {
		statement.addRental(new Rental(newReleaseMovie1, 3));
		statement.generate();
		assertEquals(9.0, statement.getTotalAmount(), DELTA);
		assertEquals(2, statement.getFrequentRenterPoints());
	}

	public void testDualNewReleaseStatementTotals() {
		statement.addRental(new Rental(newReleaseMovie1, 3));
		statement.addRental(new Rental(newReleaseMovie2, 3));
		statement.generate();
		assertEquals(18.0, statement.getTotalAmount(), DELTA);
		assertEquals(4, statement.getFrequentRenterPoints());
	}

	public void testSingleChildrensStatementTotals() {
		statement.addRental(new Rental(childrensMovie, 3));
		statement.generate();
		assertEquals(1.5, statement.getTotalAmount(), DELTA);
		assertEquals(1, statement.getFrequentRenterPoints());
	}

	public void testMultipleRegularStatementTotals() {
		statement.addRental(new Rental(regular1, 1));
		statement.addRental(new Rental(regular2, 2));
		statement.addRental(new Rental(regular3, 3));
		statement.generate();
		assertEquals(7.5, statement.getTotalAmount(), DELTA);
		assertEquals(3, statement.getFrequentRenterPoints());
	}

	public void testMultipleRegularStatementFormat() {
		statement.addRental(new Rental(regular1, 1));
		statement.addRental(new Rental(regular2, 2));
		statement.addRental(new Rental(regular3, 3));

		assertEquals(
				"Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n",
				statement.generate());
	}
}
