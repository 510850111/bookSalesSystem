package service.impl;

import java.util.List;

import com.mysql.jdbc.Connection;

import dbc.DatabaseConnection;
import factory.DAOFactory;
import service.ICategoryService;
import vo.Category;

public class CategoryServiceImpl implements ICategoryService {
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


	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategory() throws Exception {
		try{
			return (List<Category>) DAOFactory.getICategoryDaoInstance(this.dbc.getConn()).getCategory();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
}
