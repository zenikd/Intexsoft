package dao.api;

import java.io.IOException;

import dao.entity.AbstractBook;

public interface IUpdater {
	void update(AbstractBook book) throws IOException;
}
