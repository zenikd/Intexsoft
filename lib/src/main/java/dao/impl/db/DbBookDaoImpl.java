package dao.impl.db;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.api.IBookDao;
import dao.entity.AbstractBook;
import dao.entity.DbBook;
import dao.entity.DbLib;
import service.impl.AbstractLiBService;
import service.impl.AbstractBookService;
import service.impl.DbBookService;

public class DbBookDaoImpl<ENTITY> extends AbstractDaoImpl<AbstractBook> implements IBookDao {

	@Override
	protected AbstractBook parseRow(ResultSet resultSet) throws SQLException {
		AbstractBook entity = new AbstractBook();
		entity.setIndex(resultSet.getString("id"));
		entity.setAuthor(resultSet.getString("author"));
		entity.setNameBook(resultSet.getString("name_book"));
		entity.setIssued(resultSet.getString("issued"));
		entity.setIssuedto(resultSet.getString("issuedto"));

		DbLib lib = new DbLib();
		lib.setId(resultSet.getInt("lib_id"));
		entity.setLib(lib);
		return entity;

	}

	@Override
	protected String getTableName() {
		return "book";
	}

	public void getBookById(String id, AbstractLiBService libService, List<AbstractBookService> bookServices) {
		DbBookService dbBookService = new DbBookService();
		dbBookService.addBook(getById(Integer.parseInt(id)));
		bookServices.add(dbBookService);

	}

	public void findCommand(String author, String nameBook, AbstractLiBService libService,
			List<AbstractBook> foundBooks) {
		executeStatement((statement) -> {

			statement.executeQuery("select * from " + getTableName() + " where author LIKE '" + author + "%'"
					+ " and name_book LIKE '" + nameBook + "%'");

			final ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				AbstractBook book = parseRow(resultSet);
				int idLib = ((DbLib) book.getLib()).getId();
				DbLibDaoImpl dbLibDaoImpl = new DbLibDaoImpl();
				book.setLib(dbLibDaoImpl.getById(idLib));
				foundBooks.add(book);

			}

			resultSet.close();
			// Добавли return, чтобы работал executeStatement<T>
			return foundBooks;
		});

	}

	@Override
	public void update(AbstractBook book) throws IOException {
		executeStatement(new PreparedStatemenAction<AbstractBook>(
				"update book SET author = ? , name_book = ? , issued = ? , issuedto = ? Where id = ? ;", true) {

			@Override
			public AbstractBook doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {

				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
				pStmt.setString(1, book.getAuthor());
				pStmt.setString(2, book.getNameBook());
				try {
					pStmt.setObject(3, df.parse(book.getIssued()), Types.TIMESTAMP);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pStmt.setString(4, book.getIssuedto());
				pStmt.setInt(5, Integer.parseInt(book.getIndex()));

				pStmt.executeUpdate();

				return book;
			}
		});
	}
}
