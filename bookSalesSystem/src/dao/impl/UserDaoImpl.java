package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
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
		Boolean flag=false;
		String sql="UPDATE User SET password=? WHERE uid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		
		return super.pstmt.executeUpdate()>0;
	}
	public List<User> validMessage(String phoneNumber,String validCode) throws Exception{
		List<User> data= new ArrayList<>();
		User user=new User();
		return data;
	}
	public Boolean register(String userName,String phoneNumber,String password) throws Exception{
		User vo=new User();
		Boolean blag=false;
		String sql="INSERT INTO Persons VALUES ('"+userName+"', '"+password+"', '"+phoneNumber+"')";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getUserName());
		super.pstmt.setString(2, vo.getPassword());
		super.pstmt.setString(3, vo.getPhoneNumber());
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()){
			blag=true;
		}
		return blag;
		
	}
	public Boolean login(String userName,String password) throws Exception{
		User vo= new User();
		boolean flag=false;
		String sql="SELECT * FROM User WHERE uid=? AND password=? AND flag=1";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getUserName());
		super.pstmt.setString(2, vo.getPassword());
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()){
			flag=true;
			
		}
		return flag;
	}

	
	
}
