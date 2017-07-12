package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.sql.ResultSet;

import dao.IShopCartDao;
import vo.Book;
import vo.shopCar;

public  class ShopCartDaoImpl extends AbstractDaoImpl implements IShopCartDao{

	public ShopCartDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCreate(shopCar vo) throws SQLException {
		String sql = "INSERT INTO shopcart(sid,uid,bid,price,isOrder,isPurchase) VALUES(?,?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setInt(0, vo.getSid());
		super.pstmt.setInt(1, vo.getUid());
		super.pstmt.setInt(2, vo.getPrice());
		super.pstmt.setInt(3, vo.getIsOrder());
		super.pstmt.setInt(4, vo.getIsPurchase());
		
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(shopCar vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public shopCar findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<shopCar> findAll() throws SQLException {
		List<shopCar> all = new ArrayList<shopCar>();
		String sql="SELECT sid,price,isOrder,isPurchase FROM shopcart";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()){
			shopCar vo=new shopCar();
			vo.setSid(rs.getInt(1));
			vo.setPrice(rs.getInt(2));
			vo.setIsOrder(rs.getInt(3));
			vo.setIsPurchase(rs.getInt(4));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<shopCar> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return -1;
	} 

	@Override
	public Boolean DeleteArticle(Integer sid) throws Exception {
		Boolean flag=false;
		shopCar vo=new shopCar();
		String sql="DELETE FROM shopcart WHERE sid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, vo.getUid());
		ResultSet rs=(ResultSet) super.pstmt.executeQuery();
		if(rs.next()){
			flag=true;
		}
		return flag;
	}

	@Override
	public Boolean AddshopCart(shopCar vo) throws Exception {
		Boolean flag=false;
		String sql="INSERT INTO shopcart(uid,bid,price,isOrder,isPurchase) VALUES(?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, vo.getBid());
		super.pstmt.setInt(2, vo.getUid());
		super.pstmt.setInt(3, vo.getPrice());
		super.pstmt.setInt(4, vo.getIsOrder());
		super.pstmt.setInt(5, vo.getIsPurchase());
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()){
			flag=true;
		}
		return flag;
	}

	@Override
	public List<shopCar> shopCart(int num) throws Exception {
		List<shopCar> data= new ArrayList<>();
		Book book=new Book();
		
		return this.findAll();
	}

	@Override
	public List<shopCar> shopCart() throws Exception {
		List<shopCar> data= new ArrayList<>();
		Book book=new Book();
		
		return this.findAll();	}

}
