package com.springboot.example.service;

/***ҵ������***/
pubilc interface PurchaseService{
	/**
	*	������ҵ��
	*	@param userId �û����
	* @param productId ��Ʒ���
	* @param quantity  ��������
	* @return �ɹ�orʧ��
	*/
	public boolean purchase(Long userId, Long productId, Integer quantity);
}