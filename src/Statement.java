import java.util.ArrayList;
import java.util.List;

public class Statement {
	private String customerName;
	private List<Rental> rentals = new ArrayList<Rental>();
	private double totalAmount;
	private int frequentRenterPoints;

	public Statement(String name) {
		this.customerName = name;
	}

	public void addRental(Rental rental) {
		this.rentals.add(rental);
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public int getFrequentRenterPoints() {
		return frequentRenterPoints;
	}

	public String generate() {
		initialize();
		String statementText = header();
		statementText += rentalLines();
		statementText += footer();
		return statementText;
	}

	private void initialize() {
		totalAmount = 0;
		frequentRenterPoints = 0;
	}

	private String header() {
		return String.format("Rental Record for %s\n", customerName);
	}

	private String footer() {
		return String.format("You owed %.1f\nYou earned %d frequent renter points\n", totalAmount,
				frequentRenterPoints);
	}

	private String rentalLines() {
		String rentallines = "";
		for (Rental rental : this.rentals) {
			rentallines += rentalLine(rental);
		}
		return rentallines;
	}

	private String rentalLine(Rental rental) {
		String rentallines = "";
		double rentalAmount = rental.determineAmount();
		frequentRenterPoints += rental.determineFrequentRenterPoints();
		totalAmount += rentalAmount;
		rentallines = formatRenatlLine(rental, rentalAmount);
		return rentallines;
	}
	
	private String formatRenatlLine(Rental rental, double rentalAmount) {
		return String.format("\t%s\t%.1f\n", rental.getTitle(), rentalAmount);
	}

	
}
