package dojo.birth;

public class BirthRecord {

    private int year;
    private int numberOfBoyBirths;
    private int numberOfGirlBirths;

    public int getNumberOfGirlBirths() {
        return numberOfGirlBirths;
    }

    public int getNumberOfBoyBirths() {
        return numberOfBoyBirths;
    }

    public int getYear() {
        return year;
    }

    private BirthRecord(Builder builder) {
        this.year = builder.year;
        this.numberOfBoyBirths = builder.numberOfBoyBirths;
        this.numberOfGirlBirths = builder.numberOfGirlBirths;
    }

    public static class Builder {
        private int year;
        private int numberOfBoyBirths;
        private int numberOfGirlBirths;

        public static Builder birthYearRecord() {
            return new Builder();
        }

        public Builder withYear(int year) {
            this.year = year;
            return this;
        }

        public Builder withNumberOfBoyBirths(int numberOfBoyBirths) {
            this.numberOfBoyBirths = numberOfBoyBirths;
            return this;
        }

        public Builder withNumberOfGirlBirths(int numberOfGirlBirths) {
            this.numberOfGirlBirths = numberOfGirlBirths;
            return this;
        }

        public BirthRecord build() {
            return new BirthRecord(this);
        }
    }

}
