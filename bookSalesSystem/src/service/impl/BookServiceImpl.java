package service.impl;

import java.util.List;
import java.sql.Connection;

import dbc.DatabaseConnection;
import factory.DAOFactory;
import service.IBookService;
import vo.Book;

public class BookServiceImpl implements IBookService {
	private DatabaseConnection dbc = new DatabaseConnection();

    public boolean insert(Book vo) throws Exception {
        try {
            return DAOFactory.getIBookDAOInstance(this.dbc.getConn()).doCreate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
    
    
    public List<Book> getAllBooks() throws Exception {
        try {
            return DAOFactory.getIBookDAOInstance((Connection) this.dbc.getConn()).getAllBooks();
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
    
    public List<Book> getBooksBySplite(int index,int num) throws Exception{
    	try {
            return DAOFactory.getIBookDAOInstance((Connection) this.dbc.getConn()).getBooksBySplite(index,num);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
    public List<Book> getAD() throws Exception{
    	try{
    		return DAOFactory.getIBookDAOInstance((Connection) this.dbc.getConn()).getAD();
    	}catch(Exception e){
    		throw e;
    	}finally{
    		this.dbc.close();
    	}
    }
    public List<Book> getHotBook() throws Exception{
    	try{
    		return DAOFactory.getIBookDAOInstance((Connection) this.dbc.getConn()).getHotBook();
    	}catch(Exception e){
    		throw e;
    	}finally{
    		this.dbc.close();
    	}
    }
    
    public boolean insertBook(Book vo) {
    	try{
    		return DAOFactory.getIBookDAOInstance((Connection) this.dbc.getConn()).insertBook(vo);
    	}catch(Exception e){
    		throw e;
    	}finally{
    		this.dbc.close();
    	}
	}
    
}
