package site.longz.note.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by longz on 17-6-26.
 * 基本功能action
 */
public class BaseActionSupport  extends ActionSupport{
	  String message;
	  String title;
	  String url;

	  public String getUrl() {
			return url;
	  }

	  public void setUrl(String url) {
			this.url = url;
	  }

	  public String getMessage() {
			return message;
	  }

	  public void setMessage(String message) {
			this.message = message;
	  }

	  public String getTitle() {
			return title;
	  }

	  public void setTitle(String title) {
			this.title = title;
	  }

	  /**
	   * @return 获取request
	   */
	  public HttpServletRequest getRequest(){
	  	  return ServletActionContext.getRequest();
	  }
	  /**
	   * @return 获取response
	   */
	  public HttpServletResponse getResponse(){
	  	  return ServletActionContext.getResponse();
	  }

	  public String getParameter(String param){
	  	  return getRequest().getParameter(param);
	  }
	  public int getParameterInt(String param){
	  	  String s = getParameter(param);
	  	  try {
				return s==null?0:Integer.parseInt(s);
		  }catch (NumberFormatException e){
	  	  	  return 0;
		  }
	  }
	  public void setAttribute(String key,Object value){
	  	  getRequest().setAttribute(key, value);
	  }
	  public Object getAttribute(String name){
	  	  return getRequest().getAttribute(name);
	  }
	  public HttpSession getSession(){
			return getRequest().getSession();
	  }
	  public Object getSession(String name){
	  	  return getSession().getAttribute(name);
	  }
	  public void setSession(String key,Object value){
	  	  getSession().setAttribute(key, value);
	  }

	  public void writeJson(Object object) {

			try {
				  String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
				  ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
				  ServletActionContext.getResponse().getWriter().write(json);
				  ServletActionContext.getResponse().getWriter().flush();
				  ServletActionContext.getResponse().getWriter().close();
				  System.out.println(json);
			} catch (IOException e) {
				  e.printStackTrace();
			}
	  }
	  public void setInfo(String title,String message,String url){
	  	  this.title = title;
	  	  this.message = message;
	  	  this.url = url;
	  }
}
