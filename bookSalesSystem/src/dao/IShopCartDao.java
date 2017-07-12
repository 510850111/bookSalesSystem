package dao;

import java.util.List;

import vo.Book;
import vo.shopCar;

public interface IShopCartDao extends IDAO<Integer,shopCar> {
	/**
	 * 
	 * @param num
	 * @return 返回购物车的数量
	 * @throws Exception
	 */
	 public List<shopCar> shopCart(int num) throws Exception;
	 public List<shopCar> shopCart() throws Exception;
	 /**
	  * 
	  * @param sid
	  * @return true/false
	  * @throws Exception
	  */
	 public Boolean DeleteArticle(Integer sid) throws Exception;
	 /** 
	  * 
	  * @param sid
	  * @return true/false
	  * @throws Exception
	  */
	 public Boolean AddshopCart(shopCar vo) throws Exception;
}
