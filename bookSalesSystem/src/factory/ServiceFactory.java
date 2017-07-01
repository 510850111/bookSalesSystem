package factory;

import service.IBookService;
import service.IShopCartService;
import service.IUserService;
import service.impl.BookServiceImpl;
import service.impl.ShopCartServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceFactory {
	public static IBookService getIBookServiceInstance(){return (IBookService) new BookServiceImpl();}
	public static IShopCartService getIShopCartServiceInstance(){return (IShopCartService) new ShopCartServiceImpl();}
	public static IUserService getIUserServiceInstance(){return (IUserService) new UserServiceImpl();}
}
