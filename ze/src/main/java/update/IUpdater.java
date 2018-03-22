package update;

import java.io.IOException;

import entity.Book;

public interface IUpdater {
	void update(Book book) throws IOException;
}
