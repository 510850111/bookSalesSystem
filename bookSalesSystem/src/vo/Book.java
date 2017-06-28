package vo;

import java.io.Serializable;

public class Book implements Serializable{
	private int bid;
	private int price;
	private String img;
	private String author;
	private int salesNumber;
	private String score;
	private String _abstract;
	private String detail;
	private int surplus;
	private String categoryName;
	private String bookName;
	/**
	 * @return the bid
	 */
	public int getBid() {
		return bid;
	}
	/**
	 * @param bid the bid to set
	 */
	public void setBid(int bid) {
		this.bid = bid;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the salesNumber
	 */
	public int getSalesNumber() {
		return salesNumber;
	}
	/**
	 * @param salesNumber the salesNumber to set
	 */
	public void setSalesNumber(int salesNumber) {
		this.salesNumber = salesNumber;
	}
	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * @return the _abstract
	 */
	public String get_abstract() {
		return _abstract;
	}
	/**
	 * @param _abstract the _abstract to set
	 */
	public void set_abstract(String _abstract) {
		this._abstract = _abstract;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the surplus
	 */
	public int getSurplus() {
		return surplus;
	}
	/**
	 * @param surplus the surplus to set
	 */
	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
