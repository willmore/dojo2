package dojo.birth

import dojo.data.Finder
import spock.lang.Specification

class BirthDataAnalyzerSpec extends Specification {

    def "Calculates year with greatest percentage of boys for single record data set"() {
        def births = new BirthDataSet("src/test/resources/dojo/birthsOneEntry.dat")

        Finder<BirthRecord> locator = new YearWithGreatestPercentageOfBoysFinder()

        expect:
        births.find(locator).result().getYear() == 1945
    }

    def "Calculates year with greatest percentage of boys for multi record data set"() {
        def births = new BirthDataSet("src/test/resources/dojo/birthsTwoEntries.dat")

        Finder<BirthRecord> locator = new YearWithGreatestPercentageOfBoysFinder()

        expect:
        births.find(locator).result().getYear() == 1946
    }

}
