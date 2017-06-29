package service.impl;

import com.mysql.jdbc.Connection;

import dbc.DatabaseConnection;
import factory.DAOFactory;
import vo.Book;

public class BookServiceImpl {
	private DatabaseConnection dbc = new DatabaseConnection();

    public boolean insert(Book vo) throws Exception {
        try {
            return DAOFactory.getIBookDAOInstance((Connection) this.dbc.getConn()).doCreate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
