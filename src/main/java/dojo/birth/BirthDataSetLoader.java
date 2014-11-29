package dojo.birth;

import com.google.common.base.Function;
import dojo.data.FileDataSetLoader;
import dojo.data.MappingFileDataSetLoader;

import java.io.File;
import java.util.List;

import static java.lang.Integer.parseInt;

public class BirthDataSetLoader implements FileDataSetLoader<BirthRecord> {

    private static final int YEAR_FIELD = 0;
    private static final int BOY_BIRTHS_FIELD = 1;
    private static final int GIRL_BIRTHS_FIELD = 2;
    private static final String FIELD_DELIMITER = ";";

    public List<BirthRecord> load(File birthsFile) {
        return new MappingFileDataSetLoader<BirthRecord>(toBirthYearRecord()).load(birthsFile);
    }

    private static Function<String, BirthRecord> toBirthYearRecord() {
        return new Function<String, BirthRecord>() {

            public BirthRecord apply(String lineEntry) {

                String[] parts = lineEntry.split(FIELD_DELIMITER);

                return BirthRecord.Builder.birthYearRecord()
                        .withYear(parseInt(parts[YEAR_FIELD]))
                        .withNumberOfBoyBirths(parseInt(parts[BOY_BIRTHS_FIELD]))
                        .withNumberOfGirlBirths(parseInt(parts[GIRL_BIRTHS_FIELD]))
                        .build();
            }
        };
    }

}
