package dojo.soccer;

import com.google.common.base.Function;
import dojo.data.FileDataSetLoader;
import dojo.data.MappingFileDataSetLoader;

import java.io.File;
import java.util.List;

import static java.lang.Integer.parseInt;

public class SoccerDataSetLoader implements FileDataSetLoader<TeamRecord> {

    private static final String FIELD_DELIMITER = "\t";
    private static final int POSITION_FIELD = 0;
    private static int NAME_FIELD = 1;
    private static int PLAYS_FIELD = 2;
    private static final int WINS_FIELD = 3;
    private static int DRAWS_FIELD = 4;
    private static int LOSSES_FIELD = 5;
    private static int GOALS_FOR_FIELD = 6;
    private static int GOALS_AGAINST_FIELD = 7;

    public List<TeamRecord> load(File data) {
        return new MappingFileDataSetLoader<TeamRecord>(toTeamRecord()).load(data);
    }

    private static Function<String, TeamRecord> toTeamRecord() {
        return new Function<String, TeamRecord>() {

            public TeamRecord apply(String lineEntry) {

                String[] parts = lineEntry.split(FIELD_DELIMITER);

                return TeamRecord.Builder.teamRecord()
                        .withPosition(parseInt(parts[POSITION_FIELD]))
                        .withName(parts[NAME_FIELD])
                        .withPlays(parseInt(parts[PLAYS_FIELD]))
                        .withWins(parseInt(parts[WINS_FIELD]))
                        .withDraws(parseInt(parts[DRAWS_FIELD]))
                        .withLosses(parseInt(parts[LOSSES_FIELD]))
                        .withGoalsFor(parseInt(parts[GOALS_FOR_FIELD]))
                        .withGoalsAgainst(parseInt(parts[GOALS_AGAINST_FIELD]))
                        .build();
            }
        };
    }

}
