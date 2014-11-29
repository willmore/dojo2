package dojo.birth

import dojo.birth.BirthDataSet
import dojo.birth.BirthRecord
import spock.lang.Specification

class BirthDataLoaderSpec extends Specification {

    def "Loads single file entry" () {
        def births = singleEntrySet()

        List<BirthRecord> records = births.entries()
        expect:
        records.size() == 1
        records.get(0) != null
    }

    def "Loads single file entry with expected fields" () {
        def births = new BirthDataSet("src/test/resources/dojo/birthsOneEntry.dat")

        List<BirthRecord> records = births.entries()
        BirthRecord record = records.get(0)
        expect:
        record.getYear() == 1945;
        record.getNumberOfGirlBirths() == 7375;
        record.getNumberOfBoyBirths() == 7593;
    }

    def "Loads multi line file entries with expected data" () {
        def births = new BirthDataSet("src/test/resources/dojo/birthsTwoEntries.dat")

        List<BirthRecord> records = births.entries()
        BirthRecord firstRecord = records.get(0)
        BirthRecord secondRecord = records.get(1)

        expect:
        firstRecord.getYear() == 1945;
        firstRecord.getNumberOfGirlBirths() == 7375;
        firstRecord.getNumberOfBoyBirths() == 7593;
        secondRecord.getYear() == 1946;
        secondRecord.getNumberOfGirlBirths() == 9554;
        secondRecord.getNumberOfBoyBirths() == 9854;
    }

    private BirthDataSet singleEntrySet() {
        new BirthDataSet("src/test/resources/dojo/birthsOneEntry.dat")
    }

}
