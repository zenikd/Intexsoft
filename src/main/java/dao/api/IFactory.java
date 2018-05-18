package dao.api;

public interface IFactory {
	ILibDao getLibDao();
	
	IBookDao getBookDao();
}
