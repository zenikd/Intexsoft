package dao.entity;

public class DbLib extends AbstractLib {
	public DbLib() {

	}

	public DbLib(String name, String adress, String type) {
		super(name, adress, type);
		// TODO Auto-generated constructor stub
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
