package com.encora.CustomerService;

public class OrderRequestDTO {

	 private Long productId;
	    private Long customerId;
	    private int quantity;
	    private String orderdate;
		public Long getProductId() {
			return productId;
		}
		public void setProductId(Long productId) {
			this.productId = productId;
		}
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getOrderdate() {
			return orderdate;
		}
		public void setOrderdate(String orderdate) {
			this.orderdate = orderdate;
		}
	    
	    
	    
}
