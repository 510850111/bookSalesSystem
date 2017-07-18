package service.impl;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import dbc.DatabaseConnection;
import factory.DAOFactory;
import service.IUserService;
import vo.User;

public class UserServiceImpl implements IUserService {
private DatabaseConnection dbc = new DatabaseConnection();
	
	public Boolean changePassword(String userName,String oldPassword,String newPassword) throws Exception{
		try {
            return DAOFactory.getIUserDAOInstance((Connection) this.dbc.getConn()).changePassword(userName, oldPassword, newPassword);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
		
	}
	public List<User> validMessage(String phoneNumber,String validCode) throws Exception{
		try{
			return DAOFactory.getIUserDAOInstance((Connection) this.dbc.getConn()).validMessage(phoneNumber, validCode);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	public Boolean register(String userName,String phoneNumber,String password) throws Exception{
		try{
			return DAOFactory.getIUserDAOInstance((Connection) this.dbc.getConn()).register(userName, phoneNumber, password);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	public Boolean login(String userName,String password) throws Exception{
		try{
			return DAOFactory.getIUserDAOInstance((Connection) this.dbc.getConn()).login(userName, password);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	@Override
	public Boolean isAdmin(String userName) throws SQLException {
		try{
			return DAOFactory.getIUserDAOInstance((Connection) this.dbc.getConn()).isAdmin(userName);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	@Override
	public List<User> getpersonInformation(int uid) throws Exception {
		try{
			return DAOFactory.getIUserDAOInstance((Connection) this.dbc.getConn()).getpersonInformation(uid);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
	}

}
