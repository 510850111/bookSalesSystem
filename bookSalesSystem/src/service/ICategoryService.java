package service;

import java.util.List;

import vo.Category;

public interface ICategoryService {
	/**
	 * 
	 * @param categoryName
	 * @return 搜索结果
	 * @throws Exception
	 */
	public List<Category> search(String categoryName) throws Exception;
}
