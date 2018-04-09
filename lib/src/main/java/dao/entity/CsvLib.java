package dao.entity;

public class CsvLib extends AbstractLib {
	public CsvLib(String name, String adress, String type) {
		super(name, adress, type);
		// TODO Auto-generated constructor stub
	}

	public CsvLib() {

	}

	private String directory;

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

}
