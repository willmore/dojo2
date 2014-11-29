package dojo.birth;

import dojo.data.Finder;

public class YearWithGreatestPercentageOfBoysFinder implements Finder<BirthRecord> {

    private float greatestPercentageSoFar = 0.0f;
    private BirthRecord locatedEntry = null;

    @Override
    public void visit(BirthRecord entry) {
        if (locatedEntry == null) {
            locatedEntry = entry;
            greatestPercentageSoFar = percentageOfBoys(entry);
        } else {
            if (percentageOfBoys(entry) > greatestPercentageSoFar) {
                locatedEntry = entry;
                greatestPercentageSoFar = percentageOfBoys(entry);
            }
        }
    }

    private float percentageOfBoys(BirthRecord entry) {
        return (float)entry.getNumberOfBoyBirths() / (float)totalBirths(entry);
    }

    private int totalBirths(BirthRecord entry) {
        return entry.getNumberOfBoyBirths() + entry.getNumberOfGirlBirths();
    }

    @Override
    public BirthRecord result() {
        return locatedEntry;
    }
}
