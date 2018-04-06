package dao.entity;

public class CsvLib extends AbstractLib{
	private String directory;
	
	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public CsvLib(){
		super.setType("csv");
	}
}
