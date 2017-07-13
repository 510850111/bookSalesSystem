package service;

import java.util.List;

import vo.Book;

public interface IBookService {
	
	/**
	 * 
	 * @return	所有Book
	 * @throws Exception
	 */
	 public List<Book> getAllBooks() throws Exception;
	 /**
	  * 
	  * @param index 頁數
	  * @param num 請求的數量
	  * @return 符合要求的書籍
	  * @throws Exception
	  */
	 public List<Book> getBooksBySplite(int index,int num) throws Exception;
	 /**
	  * 
	  * @return 所请求的广告
	  * @throws Exception
	  */
	 public List<Book> getAD() throws Exception;
	 /**
	  * 
	  * @return 所请求的热门书籍
	  * @throws Exception
	  */
	 public List<Book> getHotBook() throws Exception;
	 
	 public boolean insertBook(Book vo);
	public boolean delByBid(int bid) throws Exception;

}
