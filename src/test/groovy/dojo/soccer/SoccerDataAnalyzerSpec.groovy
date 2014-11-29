package dojo.soccer

import dojo.data.Finder
import spock.lang.Specification

class SoccerDataAnalyzerSpec extends Specification {

    def "Finds team with worst goal difference single record data set"() {
        def teamRecords = new SoccerDataSet("src/test/resources/dojo/soccerOneEntry.dat")

        Finder<TeamRecord> locator = new TeamWithWorstGoalDifferenceFinder()

        expect:
        teamRecords.find(locator).result().getName() == "Chelsea"
    }

    def "Finds team with worst goal difference multi-record data set"() {
        def teamRecords = new SoccerDataSet("src/test/resources/dojo/soccer.dat")

        Finder<TeamRecord> locator = new TeamWithWorstGoalDifferenceFinder()

        expect:
        teamRecords.find(locator).result().getName() == "Queens Park Rangers"
    }

}
