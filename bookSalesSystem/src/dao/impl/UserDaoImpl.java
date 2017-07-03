package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.IShopCartDao;
import dao.IUserDao;
import vo.Book;
import vo.User;
import vo.shopCar;

public  class UserDaoImpl extends AbstractDaoImpl implements IUserDao{

	public UserDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCreate(User vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(User vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean changePassword(String userName, String oldPassword, String newPassword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public List<User> validMessage(String phoneNumber,String validCode) throws Exception{
		List<User> data= new ArrayList<>();
		User user=new User();
		return data;
	}
	public Boolean register(String userName,String phoneNumber,String password) throws Exception{
		return null;
		
	}
	public Boolean login(String userName,String password) throws Exception{
		return null;
	}

	
	
}
