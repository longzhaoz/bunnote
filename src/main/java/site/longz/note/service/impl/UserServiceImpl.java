package site.longz.note.service.impl;

import org.springframework.stereotype.Service;
import site.longz.note.dao.IUserDao;
import site.longz.note.entity.User;
import site.longz.note.service.IUserService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-22.
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	  @Resource
	  private IUserDao userDao;

	  public Serializable save(User u) {
			return userDao.save(u);
	  }

	  public void update(User u) {
			userDao.update(u);
	  }

	  public void delete(int id) {
	  	  userDao.delete(id);
	  }

	  public List<User> findAll() {
			return userDao.findAll();
	  }

	  public User findById(int id) {
			return userDao.findById(id);
	  }

	  public User findByName(String name) {
			return userDao.findByName(name);
	  }

	  public User findByNamePassword(User u) {
			return userDao.findByNamePassword(u);
	  }
}
