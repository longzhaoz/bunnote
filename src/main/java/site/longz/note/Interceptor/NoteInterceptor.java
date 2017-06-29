package site.longz.note.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.*;

/**
 * Created by longz on 17-6-29.
 */
public class NoteInterceptor  implements Interceptor{
	  public void destroy() {

	  }

	  public void init() {

	  }

	  public String intercept(ActionInvocation actionInvocation) throws Exception {
			Map<String, Object> parameters = actionInvocation.getInvocationContext().getParameters();
			if (parameters.get("note.id")!=null){
				  return actionInvocation.invoke();
			}else {
				  actionInvocation.getStack().setValue("title","非法请求");
				  actionInvocation.getStack().setValue("message","页面错误,请重新尝试！");
				  actionInvocation.getStack().setValue("url","/note/index.jsp");
				  return "error";
			}
	  }
}
