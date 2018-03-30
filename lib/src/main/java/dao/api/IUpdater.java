package dao.api;

import java.io.IOException;

import dao.entity.Book;

public interface IUpdater {
	void update(Book book) throws IOException;
}
