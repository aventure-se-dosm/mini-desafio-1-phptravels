package dataProviders.workbookFiles;

public abstract class WorkBookWriter {

	public abstract String readLine();
	public abstract String readCell();
	public abstract String readWholeSheet();
	
	public abstract void writeLine();
	public abstract void writeCell();
	public abstract void writeWholeSheet();
	
	/**
	 * WholeSheet ¬¬/ 
	 */
	
}
