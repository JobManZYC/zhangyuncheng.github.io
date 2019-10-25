package com.zyc.springcloud.entity;

public class MerchantInfo {	
		private int id;
		private String merchant;
		private float money;		
		public MerchantInfo() {
			super();
			// TODO Auto-generated constructor stub
		}
		public MerchantInfo(int id, String merchant, float money) {
			super();
			this.id = id;
			this.merchant = merchant;
			this.money = money;
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
		 * @return the money
		 */
		public float getMoney() {
			return money;
		}
		/**
		 * @param money the money to set
		 */
		public void setMoney(float money) {
			this.money = money;
		}
		@Override
		public String toString() {
			return "MerchantInfo [id=" + id + ", merchant=" + merchant + ", money=" + money + "]";
		}
		

}
