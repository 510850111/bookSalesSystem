package service;

import java.util.List;

import vo.User;

public interface IUserService {
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
	/**
	 * 
	 * @param userName
	 * @param phoneNumber
	 * @param password
	 * @return true/false
	 * @throws Exception
	 */
	public Boolean register(String userName,String phoneNumber,String password) throws Exception;
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return true/flase
	 * @throws Exception
	 */
	public Boolean login(String userName,String password) throws Exception;
	
}
