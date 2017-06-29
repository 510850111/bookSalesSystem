package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 实现dao接口中的一些公共方法
 */
public abstract class AbstractDaoImpl {
    protected Connection conn;
    protected PreparedStatement pstat;
    public PreparedStatement pstmt;

    public AbstractDaoImpl(Connection conn){
        this.conn = conn;
    }
}