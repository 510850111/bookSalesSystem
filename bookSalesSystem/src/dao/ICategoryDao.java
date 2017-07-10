package dao;

import java.util.List;

import vo.Category;
import vo.shopCar;

public interface ICategoryDao extends IDAO<Integer,Category> {
	/**
	 * 
	 * @param categoryName
	 * @return 搜索结果
	 * @throws Exception
	 */
	public List<Category> search(String categoryName) throws Exception;
	public List<Category> getCategory() throws Exception;
}
