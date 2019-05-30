package com.springboot.example.pojo;

/****������Ϣpojo***/
@AliasFor("purchaseRecode")
public class PurchaseRecodePo implement Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long userId;
	private Long productId;
	private Double price;
	private Integer quantity;
	private Double sum;
	private Timestamp purchaseDate;
	private String note;
	
	/***setter and getter***/
}