package com.springboot.example.service.impl;

/***����ҵ��ʵ��***/
@Service
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	private PurchaseRecodeDao purchaseDao;
	@Autowired
	private ProductDao productDao;
	
	@Override
	@Transactional
	public boolean purchase(Long userId, Long productId, Integer quantity){
		// ��ȡ��Ʒ
		ProductPo product = productDao.getProduct(productId);
		// �鿴����Ƿ��㹻
		if(product.getStock() < quantity){
			return false;
		}
		
		// �ۼ����
		productDao.decreaseProduct(productId, quantity);
		
		// ���빺���¼
		PurchaseRecodePo prp = this.initPurchaseRecodePo(userId, product, quantity);
		purchaseDao.insertPurchaseRecode(prp);
		
		// ����
		return true;
	}
	
	private PurchaseRecodePo initPurchaseRecodePo(Long userId, ProductPo product, Integer quantity){
		PurchaseRecodePo result = new PurchaseRecodePo();
		result.setUserId(userId);
		result.setProductId(product.getId());
		result.setQuantity(quantity);
		result.setPrice(product.getPrice());
		result.setSum(product.getPrice() * quantity);
		result.setNote("������־��ʱ�䣺" + System.currentTimeMillis());
		return result;
	}
}