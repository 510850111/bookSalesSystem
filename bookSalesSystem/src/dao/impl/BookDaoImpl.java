package dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mysql.jdbc.Connection;

import dao.IBookDao;
import vo.Book;

public class BookDaoImpl extends AbstractDaoImpl implements IBookDao {
    public BookDaoImpl(Connection conn) {
        super(conn);
    }

	@Override
	public boolean doCreate(Book vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean purchaseByBid(Book vo, String aid) throws Exception {
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
		book.setBid(0);
		book.setBookName("ABC");
		data.add(book);
		// TODO Auto-generated method stub
		return data;
	}

}
