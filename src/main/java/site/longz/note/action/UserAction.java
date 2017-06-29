package site.longz.note.action;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import site.longz.note.entity.User;
import site.longz.note.service.IUserService;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by longz on 17-6-22.
 * 用户相关操作
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseActionSupport {
	  @Resource
	  private IUserService userService;

	  private User user;

	  public User getUser() {
			return user;
	  }

	  public void setUser(User user) {
			this.user = user;
	  }

	  public String reg() {
			if (userService.findByName(user.getName()) != null) {
				  title = "注册时错误";
				  message = "用户名已存在";
				  url = "/user/regx.jsp";
				  return "error";
			}
			user.setRegTime(new Date());
			user.setTime(new Date());
			int id = (Integer) userService.save(user);
			user.setId(id);
			setSession("userLogined", user);
			return "success";
	  }

	  public String login() {
			user = userService.findByNamePassword(user);
			if (user != null) {
				  setSession("userLogined", user);
				  user.setTime(new Date());
				  userService.update(user);
				  return "success";
			}
			title = "登录时错误";
			message = "用户名不存在或密码不匹配";
			url = "/user/loginx.jsp";
			return "error";
	  }

	  public String index() {
			if (getSession("userLogined") == null) {
				  title = "信息错误";
				  message = "您还没有登录";
				  url = "/user/loginx.jsp";
				  return "error";
			}
			return "success";
	  }

	  public String logout() {
			getSession().removeAttribute("userLogined");
			return "success";
	  }

	  public String check() {
	  	  user = userService.findByName(user.getName());
			Map<String, Object> data = new HashMap<String, Object>();
	  	  if (user!=null) {
				data.put("flag", true);
				data.put("msg", "存在");
				writeJson(data);
		  } else {
				data.put("flag", false);
				data.put("msg", "不存在");
				writeJson(data);
		  }
			return null;
	  }
}
