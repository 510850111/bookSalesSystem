package service;

import java.util.List;

import vo.Book;
import vo.Category;

public interface ICategoryService {
	/**
	 * 
	 * @param categoryName
	 * @return 搜索结果
	 * @throws Exception
	 */
	public List<Category> search(String categoryName) throws Exception;
	 /**
	  * 
	  * @param categoryName	分类名
	  * @return 所要求的分类
	  * @throws Exception
	  */
	 public List<Category> getCategory(String categoryName) throws Exception;
}
