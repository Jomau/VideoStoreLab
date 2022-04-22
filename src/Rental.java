public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		movie = movie;
		daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Object getTitle() {
		return movie.getTitle();
	}

	double determineAmount() {
		return movie.determineAmount(daysRented);
	}

	int determineFrequentRenterPoints() {
		return movie.determineFrequentRenterPoints(daysRented);
	}
}