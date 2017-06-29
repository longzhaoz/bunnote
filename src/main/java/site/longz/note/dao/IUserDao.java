package site.longz.note.dao;

import site.longz.note.entity.User;

import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-21.
 */
public interface IUserDao {
	  Serializable save(User u);
	  void update(User u);
	  void delete(int id);
	  List<User> findAll();
	  User findById(int id);
	  User findByName(String name);
	  User findByNamePassword(User u);
}
