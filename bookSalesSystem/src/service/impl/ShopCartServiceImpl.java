package service.impl;

import java.util.List;

import com.mysql.jdbc.Connection;

import dbc.DatabaseConnection;
import factory.DAOFactory;
import service.IShopCartService;
import vo.shopCar;

public class ShopCartServiceImpl implements IShopCartService {
	private DatabaseConnection dbc = new DatabaseConnection();
	
	public List<shopCar> shopCart(int num) throws Exception{
		try {
            return DAOFactory.getIShopCartDAOInstance((Connection) this.dbc.getConn()).shopCart(num);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
		
	}

	@Override
	public List<shopCar> shopCart() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
