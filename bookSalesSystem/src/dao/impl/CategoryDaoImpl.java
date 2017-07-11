package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.ICategoryDao;
import vo.Book;
import vo.Category;
import vo.shopCart;

public class CategoryDaoImpl extends AbstractDaoImpl implements ICategoryDao{

	public CategoryDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCreate(Category vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Category vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Category> search(String categoryName) throws Exception {
		List<Category> data= new ArrayList<>();
		Category cate=new Category();
		//返回请求热门书籍
		return data;
	}
	public List<Category> getCategory() throws Exception{
		List<Category> data= new ArrayList<>();
		Category categoryTest0 = new Category();
		categoryTest0.setCategoryName("123");
		
		Category categoryTest1 = new Category();
		categoryTest1.setCategoryName("456");
		
		data.add(categoryTest0);
		data.add(categoryTest1);
		
		
		//返回分类
		return data;
	}

}
