package br.com.pacdev.enums;

public enum OrderStatus {
	AWAITING_PAYMENT("AWAITING_PAYMENT"),
	CANCELLED("CANCELLED"),
	DELIVERED("DELIVERED"),
	INVOICED("INVOICED"),
	PAYMENT_APPROVED("PAYMENT_APPROVED"),
	PAYMENT_DECLINED("PAYMENT_DECLINED"),
	SHIPPED("SHIPPED");
	
	
	private final String value;

	private OrderStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}


	
	
}
