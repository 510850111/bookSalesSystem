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
		String sql = "INSERT INTO user(uid,username,phoneNumber,password,isAdmin,address) VALUES(?,?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setInt(0,vo.getUid());
		super.pstmt.setString(1, vo.getUserName());
		super.pstmt.setString(2, vo.getPhoneNumber());
		super.pstmt.setString(3, vo.getPassword());
		super.pstmt.setBoolean(4, vo.getIsAdmin());
		super.pstmt.setString(5, vo.getAddress());
		
		return super.pstmt.executeUpdate() > 0;
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
		List<User> all= new ArrayList<User>();
		String sql="SELECT uid,username,phoneNumber,address FROM user";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()){
			User vo=new User();
			vo.setUid(rs.getInt(1));
			vo.setUserName(rs.getString(2));
			vo.setPhoneNumber(rs.getString(3));
			vo.setAddress(rs.getString(4));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<User> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return -1;
	}

	@Override
	public List<User> validMessage(String phoneNumber,String validCode) throws Exception{
		List<User> data= new ArrayList<>();
		User user=new User();
		return data;
	}
	@Override
	public Boolean register(String userName,String phoneNumber,String password) throws Exception{
		Boolean blag=false;
		String sql="INSERT INTO user VALUES ('"+userName+"', '"+password+"', '"+phoneNumber+"')";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()){
			blag=true;
		}
		return blag;
		
	}
	@Override
	public Boolean login(String userName,String password) throws Exception{
		boolean flag=false;
		String sql="SELECT * FROM user WHERE uid=? AND password=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, userName);
		super.pstmt.setString(2, password);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()){
			flag=true;
			
		}
		return flag;
	}

	@Override
	public Boolean DeleteUser(String userName) throws Exception {
		Boolean flag=false;
		String sql="DELETE FROM user WHERE username=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, userName);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()){
			flag=true;
		}
		return flag;
	}

	@Override
	public Boolean isAdmin(Integer uid) throws Exception {
		boolean flag=false;
		String sql="SELECT isAdmin FROM user WHERE uid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setInt(0, uid);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()){
			flag=true;
		}
		return flag;
	}

	@Override
	public Boolean changePassword(int uid, String newPassword) throws Exception {
		Boolean flag=false;
		String sql="UPDATE user SET password=? WHERE uid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, newPassword);
		super.pstmt.setInt(2, uid);
		
		return super.pstmt.executeUpdate()>0;
	}

	
	
}
