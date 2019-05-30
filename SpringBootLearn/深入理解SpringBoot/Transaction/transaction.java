package org.springframework.transaction.annotation;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Ingerited
@Documentd
public @interface Transactional{
	// ͨ��bean nameָ�����������
	@AliasFor("transcationManager")
	String value() default "";
	
	// ͬvalue����
	@AliasFor("value")
	String transactionManager() default "";
	
	// ָ��������Ϊ
	Propagation propagation() default Propagation.REQUIRED;
	
	// ָ�����뼶��
	Isolation isolation() default Isolation.DEFAULT;
	
	// ָ����ʱʱ�䣨��λ�룩
	int timeout() default TransactionDefinition.TIMEOUT_DEFAULT;
	
	// �Ƿ�ֻ������
	boolean readOnly() default fasle;
	
	// �����ڷ���ָ���쳣����ʱ�ع���Ĭ���������쳣���ع�
	String[] rollbackForClassName() default {};
	
	// �����ڷ���ָ���쳣��ʱ���ع���Ĭ���������쳣���ع�
	Class<? extends Throwable>[] noRollbackFor() default {};
	
	// �����ڷ���ָ���쳣����ʱ���ع���Ĭ���������쳣���ع�
	String[] noRollbackForClassName() default {};
}