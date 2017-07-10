package dao;

import java.sql.SQLException;
import java.util.List;

import vo.Book;

public interface IBookDao extends IDAO<Integer,Book> {
    /**
     * 根据bid删除书籍
     * @param bid
     * @return
     */
    public boolean deleteByBid(Integer bid) throws SQLException;

    /**
     * 通过bid购买书籍,同时需要知道是谁买的
     * @param vo,aid
     * @return
     * @throws Exception
     */
    public boolean purchaseByBid(Book vo,String uid) throws Exception;

    /**
     * 通过uid查询购买清单
     * @param aid
     * @return
     * @throws Exception
     */
    public List<Book> purchaseList(String bid) throws Exception;
    
    /**
     * 获取所有图书
     * @return List
     * @throws Exception
     */
    public List<Book> getAllBooks() throws Exception;
    
    /**
     * 
     * @param index,num
     * @return List
     * @throws Exception
     */
    public List<Book> getBooksBySplite(int index,int num) throws Exception;
    /**
     * 
     * @return List
     * @throws Exception
     */
    public List<Book> getAD() throws Exception;
    /**
     * 
     * @return List返回热门书籍
     * @throws Exception
     */
    public List<Book> getHotBook() throws Exception;


}
