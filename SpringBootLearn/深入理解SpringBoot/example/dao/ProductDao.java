package com.springboot.example.dao;

/***Mapperӳ��ӿ�***/
@Mapper
public interface ProductDao{
	public ProductPo getProduct(Long id);
	public int decreaseProduct(Long id, Integer quantity);
}