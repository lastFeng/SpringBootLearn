// Condition�ӿڵĲ���˵����
// 	ConditionContext��
				BeanDefinitionRegistry getRegistry();
				ConfigurableListableBeanFactory getBeanFactory();   --> ���bean�Ƿ���ڣ�����̽��bean������
				Environment getEnvironment();
				ResourceLoader getResourceLoader();
				ClassLoader getClassLoader();
				
//  AnnotatedTypeMetadata��
				boolean isAnnotated(String annotationType);
				Map<String, Object> getAnnotationAttributes(String annotationType);
				Map<String, Object> getAnnotationAttributes(String annotationType, boolean classValuesAsString);
				MultiValueMap(String, Object) getAllAnnotationAttributes(String annotationType);
				MultiValueMap(String, Object) getAllAnnotationAttributes(String annotationType, boolean classValuesAsString);