package dao;

import java.util.List;

import vo.User;


public interface IUserDao extends IDAO<Integer,User> {
	/**
	 * 
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 * @return true/false
	 * @throws Exception
	 */
	 public Boolean changePassword(String userName,String oldPassword,String newPassword) throws Exception;
	 /**
	  * 
	  * @param phoneNumber
	  * @param validCode
	  * @return 返回一个结果
	  * @throws Exception
	  */
	 public List<User> validMessage(String phoneNumber,String validCode) throws Exception;

}
