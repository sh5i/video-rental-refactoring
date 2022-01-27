public abstract class Price {
    abstract int getPriceCode();

    static class ChildrensPrice extends Price {
        int getPriceCode() {
            return Movie.CHILDRENS;
        }
    }

    static class NewReleasePrice extends Price {
        int getPriceCode() {
            return Movie.NEW_RELEASE;
        }
    }

    static class RegularPrice extends Price {
        int getPriceCode() {
            return Movie.REGULAR;
        }
    }
}
