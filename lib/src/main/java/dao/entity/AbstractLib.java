package dao.entity;

public abstract class AbstractLib {	
	private String name;
	private String adress;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
