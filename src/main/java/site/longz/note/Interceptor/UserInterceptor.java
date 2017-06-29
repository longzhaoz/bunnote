package site.longz.note.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 * Created by longz on 17-6-29.
 */
public class UserInterceptor implements Interceptor{

	  public void destroy() {

	  }

	  public void init() {

	  }

	  public String intercept(ActionInvocation actionInvocation) throws Exception {
			Map<String, Object> session= actionInvocation.getInvocationContext().getSession();
			if (session.get("userLogined")!=null){
				  return actionInvocation.invoke();
			}else {
				  actionInvocation.getStack().setValue("title","权限错误");
				  actionInvocation.getStack().setValue("message","您没有登录,返回登录界面");
				  actionInvocation.getStack().setValue("url","/user/loginx.jsp");
				  return "error";
			}

	  }
}
