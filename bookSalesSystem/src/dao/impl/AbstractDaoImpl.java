package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 实现dao接口中的一些公共方法
 */
public abstract class AbstractDaoImpl {
	protected Connection conn;
	protected PreparedStatement pstat;
	public PreparedStatement pstmt;

//	public static Configuration config = new Configuration().configure("hibernate.cfg.xml");
//
//	@SuppressWarnings("deprecation")
//	public static SessionFactory factory = config.buildSessionFactory();
//
//	public static Session session = factory.openSession();
//
//	public static Transaction transaction = session.beginTransaction();

	public AbstractDaoImpl(Connection conn) {
		this.conn = conn;
	}
}