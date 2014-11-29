package dojo.soccer;

import dojo.data.Finder;

public class TeamWithWorstGoalDifferenceFinder implements Finder<TeamRecord> {

    private int worstSoFar = 0;
    private TeamRecord locatedEntry = null;

    @Override
    public void visit(TeamRecord entry) {
        if (locatedEntry == null) {
            locatedEntry = entry;
            worstSoFar = goalDifference(entry);
        } else {
            if (goalDifference(entry) <= worstSoFar) {
                locatedEntry = entry;
                worstSoFar = goalDifference(entry);
            }
        }
    }

    private int goalDifference(TeamRecord entry) {
        return entry.getGoalsFor() - entry.getGoalsAgainst();
    }

    @Override
    public TeamRecord result() {
        return locatedEntry;
    }
}
