package service.impl;

import java.util.List;

import com.mysql.jdbc.Connection;

import dbc.DatabaseConnection;
import factory.DAOFactory;
import service.ICategoryService;
import vo.Category;

public class CategoryServiceImpl implements ICategoryService {
	public class ShopCartServiceImpl {
		private DatabaseConnection dbc = new DatabaseConnection();
		
		public List<Category> search(String categoryName) throws Exception{
			try{
				return DAOFactory.getICategoryDaoInstance((Connection) this.dbc.getConn()).search(categoryName);
			}catch(Exception e){
				throw e;
			}finally{
				this.dbc.close();
			}
		}
	}

	@Override
	public List<Category> search(String categoryName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategory(String categoryName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
