package core.dataReaders.excelReaders;

import core.dataReaders.AbstractReader;

public abstract class ExcelReader extends AbstractReader {
    protected static final int FIRST_SHEET_INDEX = 0;

    public ExcelReader(String xlsDataSourcePath) {
	super(xlsDataSourcePath);
    }

//    @Override
//    protected abstract void setupReading() {
//	// TODO Auto-generated method stub
//
//    }
//
//    @Override
//    protected void closeReader() {
//	// TODO Auto-generated method stub
//
// }

}
