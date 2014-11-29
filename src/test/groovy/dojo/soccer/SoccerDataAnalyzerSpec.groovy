package dojo.soccer

import dojo.data.Finder
import spock.lang.Specification

class SoccerDataAnalyzerSpec extends Specification {

    def "Finds team with worst goal difference in single record data set"() {

        def teamRecords = new SoccerDataSet("src/test/resources/dojo/soccerOneEntry.dat")

        Finder<TeamRecord> worstTeam = new TeamWithWorstGoalDifferenceFinder()

        expect:
        teamRecords.find(worstTeam)
                   .result()
                   .getName() == "Chelsea"
    }

    def "Finds team with worst goal difference in multi-record data set"() {

        def teamRecords = new SoccerDataSet("src/test/resources/dojo/soccer.dat")

        Finder<TeamRecord> worstTeam = new TeamWithWorstGoalDifferenceFinder()

        expect:
        teamRecords.find(worstTeam)
                   .result()
                   .getName() == "Queens Park Rangers"
    }

}
