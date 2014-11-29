package dojo.soccer

import dojo.soccer.SoccerDataSet
import dojo.soccer.TeamRecord
import spock.lang.Specification

class SoccerDataLoaderSpec extends Specification {

    def "Loads single file entry" () {
        def teamRecords = new SoccerDataSet("src/test/resources/dojo/soccerOneEntry.dat")

        List<TeamRecord> records = teamRecords.entries()
        expect:
        records.size() == 1
        records.get(0) != null
    }

    def "Loads single file entry with expected fields" () {
        def teamRecords = new SoccerDataSet("src/test/resources/dojo/soccerOneEntry.dat")

        List<TeamRecord> records = teamRecords.entries()
        TeamRecord record = records.get(0)
        expect:
        record.getName() == "Chelsea"
    }

    def "Loads multi line file entries with expected data" () {
        def teamRecords = new SoccerDataSet("src/test/resources/dojo/soccer.dat")

        List<TeamRecord> records = teamRecords.entries()
        TeamRecord firstRecord = records.get(0);
        TeamRecord lastRecord = records.get(19)

        expect:
        firstRecord.getName() == "Chelsea"
        lastRecord.getName() == "Queens Park Rangers";
    }

}
