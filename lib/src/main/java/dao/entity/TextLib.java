package dao.entity;

import java.util.List;

public class TextLib extends AbstractLib {
	private List<String> directories;

	public TextLib() {

	}

	public TextLib(String name, String adress, String type) {
		super(name, adress, type);
		// TODO Auto-generated constructor stub
	}

	public List<String> getDirectories() {
		return directories;
	}

	public void setDirectories(List<String> directories) {
		this.directories = directories;
	}

}
