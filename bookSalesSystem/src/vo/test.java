package vo;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.impl.AbstractDaoImpl;

public class test extends AbstractDaoImpl {
	public test(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		
		User user=new User();
		user.setUserName("zhangsan");
		user.setPassword("asdda");
		session.save(user);
		
		Book book=new Book();
		book.setBookName("mamaipi");
		book.setPrice(34);
		session.save(book);
		
		
		//Query query = session.createQuery("from student");
		//List list = query.list();
		
		//System.out.println(list);
		
		
		
		
		transaction.commit();
		session.close();
	}

}
