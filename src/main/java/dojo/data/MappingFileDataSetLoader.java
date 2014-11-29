package dojo.data;

import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.transform;

public class MappingFileDataSetLoader<RECORD_TYPE> implements FileDataSetLoader<RECORD_TYPE> {

    private Function<String, RECORD_TYPE> mapper;

    public MappingFileDataSetLoader(Function<String, RECORD_TYPE> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<RECORD_TYPE> load(File data) {
        try {
            List<String> rawEntries = FileUtils.readLines(data, "UTF-8");
            List<String> dataEntries = rawEntries.subList(1, rawEntries.size());
            List<RECORD_TYPE> records = transform(dataEntries, mapper);
            return records;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
