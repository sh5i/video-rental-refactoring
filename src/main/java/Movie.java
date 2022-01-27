public class Movie {
    public static final int CHILDRENS = 2;

    public static final int REGULAR = 0;

    public static final int NEW_RELEASE = 1;

    private final String title;

    Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
        case REGULAR:
            this.price = new Price.RegularPrice();
            break;
        case CHILDRENS:
            this.price = new Price.ChildrensPrice();
            break;
        case NEW_RELEASE:
            this.price = new Price.NewReleasePrice();
            break;
        default:
            throw new IllegalArgumentException("Incorrect price code");
        }
    }

    public String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
