/**
	ͨ��@ControllerAdvice�����ǿ��Խ���������ȫ�����÷���ͬһ��λ��
	ע����@Controller����ķ�������ʹ��@ExceptionHandler��@InitBinder��@ModelAttribute
		1. @ExceptionHandler������ȫ�ִ������������쳣
		2. @InitBinder����������WebDataBinder,WebDataBinder�������Զ���ǰ̨���������Model��
		3. @ModelAttribute�������������ǰ󶨼�ֵ�Ե�Model��
*/

// ����ControllerAdivce

@ControllerAdvice
public class ExceptionHandlerAdvice(){
	@ExceptionHandler(value=Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request){
		ModelAndView mv = new ModelAndView("error"); // errorҳ��
		mv.addObject("errorMessage", exception.getMessgae());
		return mv;
	}
	
	
	// ����ֵ����ӵ�ȫ�֣�����ע���@RequestMapping�ķ��������Ի�ô˼�ֵ��
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("msg", "������Ϣ");
	}
	
	// ����WebDataBinder
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFieds("id"); // ����request������id
	}
}