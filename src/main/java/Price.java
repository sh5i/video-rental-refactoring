public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }

    static class ChildrensPrice extends Price {
        int getPriceCode() {
            return Movie.CHILDRENS;
        }

        public double getCharge(int daysRented) {
            double result = 1.5;
            if (daysRented > 3) {
                result += (daysRented - 3) * 1.5;
            }
            return result;
        }

    }

    static class NewReleasePrice extends Price {
        int getPriceCode() {
            return Movie.NEW_RELEASE;
        }

        public double getCharge(int daysRented) {
            return daysRented * 3;
        }

    }

    static class RegularPrice extends Price {
        int getPriceCode() {
            return Movie.REGULAR;
        }

        public double getCharge(int daysRented) {
            double result = 2;
            if (daysRented > 2) {
                result += (daysRented - 2) * 1.5;
            }
            return result;
        }
    }
}
