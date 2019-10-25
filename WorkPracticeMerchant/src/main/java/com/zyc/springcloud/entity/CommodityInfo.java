package com.zyc.springcloud.entity;
public class CommodityInfo{
	private int id;
	private String merchant;
	private String commodity;
	private float price;
	private int acount;
	
	public CommodityInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommodityInfo(int id, String merchant, String commodity, float price, int acount) {
		super();
		this.id = id;
		this.merchant = merchant;
		this.commodity = commodity;
		this.price = price;
		this.acount = acount;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the merchant
	 */
	public String getMerchant() {
		return merchant;
	}
	/**
	 * @param merchant the merchant to set
	 */
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	/**
	 * @return the commodity
	 */
	public String getCommodity() {
		return commodity;
	}
	/**
	 * @param commodity the commodity to set
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the acount
	 */
	public int getAcount() {
		return acount;
	}
	/**
	 * @param acount the acount to set
	 */
	public void setAcount(int acount) {
		this.acount = acount;
	}
	@Override
	public String toString() {
		return "MerchantInfo [id=" + id + ", merchant=" + merchant + ", commodity=" + commodity + ", price=" + price
				+ ", acount=" + acount + "]";
	}
	

}
