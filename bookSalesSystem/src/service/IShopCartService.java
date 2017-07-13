package service;

import java.util.List;

import vo.shopCar;

public interface IShopCartService {
	/**
	 * 
	 * @return 返回购物车属性
	 * @throws Exception
	 */
	public List<shopCar> shopCart(int num) throws Exception;
	
	/**
	 * 
	 * @return 返回购物车所有信息
	 * @throws Exception
	 */
	public List<shopCar> shopCart() throws Exception;
}