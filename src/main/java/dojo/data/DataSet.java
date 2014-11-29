package dojo.data;

import java.util.List;

public abstract class DataSet<RECORD_TYPE> {

    public abstract List<RECORD_TYPE> entries();

    public Finder<RECORD_TYPE> find(Finder<RECORD_TYPE> finder) {
        for (RECORD_TYPE entry : entries()) {
            finder.visit(entry);
        }
        return finder;
    }

}
