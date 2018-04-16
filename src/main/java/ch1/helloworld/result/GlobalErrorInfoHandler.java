package ch1.helloworld.result;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorInfoHandler {
	/**
	 * 应用到所有@RequestMapping注解方法,在其执行之前初始化数据绑定器
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		
	}
	
	/**
	 * 把值绑定到Model中,使全局@RequestMapping可以获取该值
	 * @param model
	 */
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("author", "Leeguoping");
	}
	
	/**
	 * 统一错误码异常处理
	 * @param request
	 */
	@ExceptionHandler(value=GlobalErrorInfoException.class)
	public ResultBody errorHandlerOverJson(HttpServletRequest request,GlobalErrorInfoException exception){
		ErrorInfoInterface errorInfo = exception.getErrorInfo();
		ResultBody result = new ResultBody(errorInfo);
		return result;
	}
}
