package dojo.data;

import java.io.File;
import java.util.List;

public interface FileDataSetLoader<RECORD_TYPE> {

    List<RECORD_TYPE> load(File data);

}
