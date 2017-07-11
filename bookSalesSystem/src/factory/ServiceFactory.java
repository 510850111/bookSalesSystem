package factory;

import service.IBookService;
import service.ICategoryService;
import service.IShopCartService;
import service.IUserService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.ShopCartServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceFactory {
	public static IBookService getIBookServiceInstance(){return  new BookServiceImpl();}
	public static IShopCartService getIShopCartServiceInstance(){return new ShopCartServiceImpl();}
	public static IUserService getIUserServiceInstance(){return new UserServiceImpl();}
	public static ICategoryService getICategoryServiceInstance(){return new CategoryServiceImpl();}
}
