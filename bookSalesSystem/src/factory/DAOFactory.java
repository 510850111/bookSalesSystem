package factory;

import com.mysql.jdbc.Connection;

import dao.IBookDao;
import dao.impl.BookDaoImpl;

public class DAOFactory {
	public static IBookDao getIBookDAOInstance(Connection conn){return  new BookDaoImpl(conn);}
}
