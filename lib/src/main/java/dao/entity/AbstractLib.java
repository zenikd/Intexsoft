package dao.entity;

public abstract class AbstractLib {
	private String name;
	private String address;
	private String type;

	public AbstractLib() {

	}

	/**
	 * 
	 * @param name
	 *            the library name
	 * @param adress
	 *            the library address
	 * @param type
	 *            the type of the library
	 */
	public AbstractLib(String name, String adress, String type) {
		this.name = name;
		this.address = adress;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdress() {
		return address;
	}

	public void setAdress(String adress) {
		this.address = adress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
