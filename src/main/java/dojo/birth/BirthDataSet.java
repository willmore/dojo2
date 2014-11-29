package dojo.birth;

import dojo.data.DataSet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BirthDataSet extends DataSet<BirthRecord> {

    private List<BirthRecord> records;

    public BirthDataSet(String dataFileName) {
        File birthsFile = new File(dataFileName);
        records  = new BirthDataSetLoader().load(birthsFile);
    }

    @Override
    public List<BirthRecord> entries() {
        return new ArrayList<BirthRecord>(records);
    }

}
