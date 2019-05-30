// ���������е�Ӧ�ó���
// ʹ��ע��@WebIntegrationTest�����У��������һ��Ƕ��ʽ��Servlet����������һ����Ϳ��Խ�����ʵHTTP���󣬶��Խ����

// ʵ���� ����@WebIntegrationTest���ڷ�������������Ӧ�ó�����Spring��RestTemplate��Ӧ�ó�����HTTP����
@RunWith(SpringJUint4ClassRunner.class)
@SpringAppclistionConfiguration(classes=ReadingListApplication.class)
@WebIntegrationTest
public class SimpleWebIntegrationTest{
	@Test(expected=HttpClientErrorException.class)
	public void pageNotFound(){
		try{
			RestTemplate rest = new RestTemplate();
			rest.getForObject("http://localhost:8080/bogusPage", String.class);
			fail("Should result in HTTP 404");
		} catch(HttpClientErrorException e){
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
			throw e;
		}
	}
}