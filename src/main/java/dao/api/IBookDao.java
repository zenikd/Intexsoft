package dao.api;

import java.io.IOException;
import java.util.List;

public interface IBookDao {
	
	IBookType getById(String id, List<ILib> libs);

	List<IBook> findCommand(String author, String nameBook, List<ILib> libs);

	void update(List<IBook> books) throws IOException;

}
