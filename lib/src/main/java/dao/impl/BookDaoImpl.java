package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.api.IBookDao;
import dao.entity.AbstractBook;
import service.impl.AbstarctLiBService;
import service.impl.AbstractBookService;

public class BookDaoImpl{

	public List<AbstractBookService> getBookById(String id, List<AbstarctLiBService> libServices) {
		List<AbstractBookService> bookServices = new ArrayList();
		for(AbstarctLiBService libService: libServices) {
			IBookDao bookDao = libService.getBookDao();
			bookDao.getBookById(id, libService, bookServices);
		}
		
		return bookServices;
		
	}
	
	public List<AbstractBook> findCommand(String author, String nameBook , List<AbstarctLiBService> libServices) {
		List<AbstractBook> foundBooks = new ArrayList();
		for(AbstarctLiBService libService: libServices) {
			IBookDao bookDao = libService.getBookDao();
			bookDao.findCommand(author, nameBook, libService, foundBooks);
		}
		
}
	
	private void update(List<AbstractBookService> bookServices) {
		for(AbstractBookService service: bookServices) {
			IBookDao bookDao = service.getBookDao();			
			for(AbstractBook book: service.getBooks()) {
				bookDao.update(book);
			}
		}
	
	

}
