import junit.framework.*;

public class VideoStoreTest extends TestCase
{

    private Statement statement;
    
    public VideoStoreTest(String name) {
        super (name);
    }

    protected void setUp ()  {
        statement = new Statement ("Fred");
    }

    public void testSingleNewReleaseStatement () {
        statement.addRental (new Rental (new Movie ("The Cell", Movie.NEW_RELEASE), 3));
        statement.statement();
        assertEquals(9.0, statement.getTotalAmount());
        assertEquals(2, statement.getFrequentRenterPoints());
    }

    public void testDualNewReleaseStatement () {
        statement.addRental (new Rental (new Movie ("The Cell", Movie.NEW_RELEASE), 3));
        statement.addRental (new Rental (new Movie ("The Tigger Movie", Movie.NEW_RELEASE), 3));
        statement.statement();
        assertEquals(18.0, statement.getTotalAmount());
        assertEquals(4, statement.getFrequentRenterPoints());
    }

    public void testSingleChildrensStatement () {
        statement.addRental (new Rental (new Movie ("The Tigger Movie", Movie.CHILDRENS), 3));
        statement.statement();
        assertEquals(1.5, statement.getTotalAmount());
        assertEquals(1, statement.getFrequentRenterPoints());
    }

    public void testMultipleRegularStatement () {
        statement.addRental (new Rental (new Movie ("Plan 9 from Outer Space", Movie.REGULAR), 1));
        statement.addRental (new Rental (new Movie ("8 1/2", Movie.REGULAR), 2));
        statement.addRental (new Rental (new Movie ("Eraserhead", Movie.REGULAR), 3));

        assertEquals ("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", statement.statement ());
    }
}

