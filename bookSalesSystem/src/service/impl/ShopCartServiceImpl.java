package service.impl;

import java.util.List;

import com.mysql.jdbc.Connection;

import dbc.DatabaseConnection;
import factory.DAOFactory;
import service.IShopCartService;
import vo.shopCar;

public class ShopCartServiceImpl implements IShopCartService {
	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public List<shopCar> shopCart() throws Exception {
		try{
			return DAOFactory.getIShopCartDAOInstance((Connection) this.dbc.getConn()).shopCart();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public Boolean AddshopCart(shopCar vo) throws Exception {
		try{
			return DAOFactory.getIShopCartDAOInstance((Connection) this.dbc.getConn()).AddshopCart(vo);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
	}

	@Override
	public List<shopCar> shopCart(int num) throws Exception {
		try{
			return DAOFactory.getIShopCartDAOInstance((Connection) this.dbc.getConn()).shopCart(num);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}

	}


}
