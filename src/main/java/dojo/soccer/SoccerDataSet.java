package dojo.soccer;

import dojo.data.DataSet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SoccerDataSet extends DataSet<TeamRecord> {

    private List<TeamRecord> records;

    public SoccerDataSet(String dataFileName) {
        records  = new SoccerDataSetLoader().load(new File(dataFileName));
    }

    @Override
    public List<TeamRecord> entries() {
        return new ArrayList<TeamRecord>(records);
    }

}
