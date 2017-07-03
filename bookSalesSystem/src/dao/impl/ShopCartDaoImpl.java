package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return null;
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
		return null;
	} 
	public List<shopCar> shopCart(int num,String number){
		List<shopCar> data= new ArrayList<>();
		Book book=new Book();
		//返回请求热门书籍
		return data;
	}

}
