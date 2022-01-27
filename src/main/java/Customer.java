import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;

    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        for (final Rental each : rentals) {
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>\n";
        result += "<ul>\n";
        for (Rental each : rentals) {
            // show figures for this rental
            result += "<li>" + each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "</li>\n";
        }
        result += "</ul>\n";

        // add footer lines
        result += "<p>Amount owed is <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "<p>You earned <em>" + String.valueOf(getFrequentRenterPoints()) + "</em> frequent renter points</p>";

        return result;
    }

    double getTotalCharge() {
        double result = 0;
        for (final Rental each : rentals) {
            result += each.getCharge();
        }
        return result;
    }

    int getFrequentRenterPoints() {
        int result = 0;
        for (final Rental each : rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
