package factory;

import com.mysql.jdbc.Connection;

import dao.IBookDao;
import dao.ICategoryDao;
import dao.IShopCartDao;
import dao.IUserDao;
import dao.impl.BookDaoImpl;
import dao.impl.CategoryDaoImpl;
import dao.impl.ShopCartDaoImpl;
import dao.impl.UserDaoImpl;

public class DAOFactory {
	public static IBookDao getIBookDAOInstance(Connection conn){return  new BookDaoImpl(conn);} 
	public static IShopCartDao getIShopCartDAOInstance(Connection conn){return new ShopCartDaoImpl(conn);} 
	public static IUserDao getIUserDAOInstance(Connection conn){return new UserDaoImpl(conn);}
	public static ICategoryDao getICategoryDaoInstance(Connection conn){return new CategoryDaoImpl(conn);}
		

}
