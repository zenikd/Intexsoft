package dao.entity.csv;

import dao.entity.AbstractBook;

public class CsvBook extends AbstractBook {
	private String directory;
	private String numberString;

	public String getNumberString() {
		return numberString;
	}

	public void setNumberString(String numberString) {
		this.numberString = numberString;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	

}
