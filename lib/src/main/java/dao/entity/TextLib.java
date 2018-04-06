package dao.entity;

import java.util.List;

public class TextLib extends AbstractLib{	
	private List<String> directories;
	
	public TextLib(){
		super.setType("Text");
	}

	public List<String> getDirectories() {
		return directories;
	}

	public void setDirectories(List<String> directories) {
		this.directories = directories;
	}
	
	
	
}
