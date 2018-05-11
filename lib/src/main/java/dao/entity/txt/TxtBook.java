package dao.entity.txt;

import dao.entity.AbstractBook;

public class TxtBook extends AbstractBook{
	private String directory;

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
}
