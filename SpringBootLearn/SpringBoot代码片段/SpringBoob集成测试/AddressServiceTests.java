/**
*	Spring�Ļ������ɲ�������
* @RunWith(SpringJUnit4ClassRunner.class) ����Spring���ɲ���֧��
* @ContextConfiguration ָ������μ���Ӧ�ó���������
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AddressBookConfiguration.class)
@SpringApplicationTest
public class AddressServiceTests{
	// ע���ַ����
	@Autowired
	private AddressService addressService;
	
	public void testService(){
		// ���Ե�ַ����
		Address addr = addService.findByLastName("Sheman");
		assertEquals("P", addr.getFirstName());
		assertEquals("Sherman", addr.getLastName());
		assertEquals("42 Wallaby Way", addr.getAddressLine1());
		assertEquals("Sydney", addr.getCity());
		assertEquals("New South Wales", addr.getState());
		assertEquals("2000", addr.getPostCode());
	}
}