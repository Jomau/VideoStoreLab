
public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title, Movie.NEW_RELEASE);
	}

	double determineAmount(int daysRented) {
		return daysRented * 3;
	}

	int determineFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}

}
