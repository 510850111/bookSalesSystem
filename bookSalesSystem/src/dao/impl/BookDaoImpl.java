package dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import dao.IBookDao;
import vo.Book;


public class BookDaoImpl extends AbstractDaoImpl implements IBookDao {
    public BookDaoImpl(Connection conn) {
        super(conn);
    }

	@Override
	public boolean doCreate(Book vo) throws SQLException {
		String sql = "INSERT INTO book(bid,bookName,price,img,author,salesNumber,score,abstract,detail,surplus) VALUES(?,?,?,?,?,?,?,?,?,?)";
		
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getBid());
        super.pstmt.setString(2, vo.getBookName());
        super.pstmt.setInt(3,vo.getPrice());
        super.pstmt.setString(4, vo.getImg());
        super.pstmt.setString(5,vo.getAuthor());
        super.pstmt.setInt(6,vo.getSalesNumber());
        super.pstmt.setString(7,vo.getScore());
        super.pstmt.setString(8, vo.get_abstract());
        super.pstmt.setString(9, vo.getDetail());
        super.pstat.setInt(10, vo.getSurplus());

        return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Book vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAll() throws SQLException {
		List<Book> all = new ArrayList<Book>();
		String sql = "SELECT bid,bookName,price,img,author,salesNumber,score,abstract,detail,surplus FROM book";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = (ResultSet) super.pstmt.executeQuery();
		while(rs.next()){
			Book vo = new Book();
			vo.setBid(rs.getInt(1));
			vo.setBookName(rs.getString(2));
			vo.setPrice(rs.getInt(3));
			vo.setImg(rs.getString(4));
			vo.setAuthor(rs.getString(5));
			vo.setSalesNumber(rs.getInt(6));
			vo.setScore(rs.getString(7));
			vo.set_abstract(rs.getString(8));
			vo.setDetail(rs.getString(9));
			vo.setSurplus(rs.getInt(10));
			
		}
		return null;
	}

	@Override
	public List<Book> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public boolean deleteByBid(Integer bid) throws SQLException {
		
		String sql = "DELETE FROM book WHERE bid = ?";
        super.pstat = super.conn.prepareStatement(sql);
        super.pstat.setInt(1,bid);
        return super.pstat.executeUpdate() > 0;
        
	}

	@Override
	public boolean purchaseByBid(Book vo, String bid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> purchaseList(String aid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() throws Exception {
		List<Book> data=new ArrayList<>();
		Book book=new Book();
		//通過數據庫返回bid,bookName,price,img,author,salesNumber,score,abstract,surplus,categoryName
		return data;
	}
	public List<Book> getBooksBySplite(int index,int num) throws Exception {
		List<Book> data=new ArrayList<>();
		Book book=new Book();
		//通過數據庫返回bid,bookName,price,img,author,salesNumber,score,abstract,surplus,categoryName
		return data;
	}
	public List<Book> getAD() throws Exception{
		List<Book> data= new ArrayList<>();
		Book book=new Book();
		//返回请求的广告
		return data;
	}
	public List<Book> getHotBook() throws Exception{
		List<Book> data= new ArrayList<>();
		Book book=new Book();
		//返回请求热门书籍
		return data;
	}

}
