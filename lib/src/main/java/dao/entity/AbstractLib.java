package dao.entity;

public class AbstractLib {
	private String name;
	private String address;
	private String type;
	private String directory;

	public AbstractLib(String name, String directory) {
		super();
		this.name = name;
		this.directory=directory;
	}

	public String getName() {
		return name;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
