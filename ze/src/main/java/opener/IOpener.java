package opener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import entity.Book;

public interface IOpener{
	
	void open(List<Book> books) throws IOException;
	
	
}
