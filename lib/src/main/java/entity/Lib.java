package entity;

import java.io.IOException;
import java.util.List;

import opener.IOpener;

public class Lib {
	private IOpener opener;
	private List<String> directories;
	private String name;

	public IOpener getOpener() {
		return opener;
	}

	public void setOpener(IOpener opener) {
		this.opener = opener;
	}

	public List<String> getDirectories() {
		return directories;
	}

	public void setDirectories(List<String> directories) {
		this.directories = directories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void open(List<Book> books) throws IOException {
		opener.open(books);
	}

}
