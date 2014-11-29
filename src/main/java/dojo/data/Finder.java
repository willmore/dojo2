package dojo.data;

public interface Finder<RECORD_TYPE> {

    void visit(RECORD_TYPE entry);

    RECORD_TYPE result();

}
