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
		double rentalAmount = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			rentalAmount += 2;
			if (getDaysRented() > 2)
				rentalAmount += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			rentalAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			rentalAmount += 1.5;
			if (getDaysRented() > 3)
				rentalAmount += (getDaysRented() - 3) * 1.5;
			break;
		}
		return rentalAmount;
	}

	int determineFrequentRenterPoints() {
		boolean bonusIsEarned = (getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1;
		if (bonusIsEarned)
			return 2;
		return 1;
	}
}