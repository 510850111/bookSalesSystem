package factory;

import service.IBookService;
import service.impl.BookServiceImpl;

public class ServiceFactory {
	public static IBookService getIBookServiceInstance(){return (IBookService) new BookServiceImpl();}

}
