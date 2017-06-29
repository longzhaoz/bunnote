package site.longz.note.service;

import site.longz.note.entity.User;

import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-22.
 */
public interface IUserService {
	  Serializable save(User u);
	  void update(User u);
	  void delete(int id);
	  List<User> findAll();
	  User findById(int id);
	  User findByName(String name);
	  User findByNamePassword(User u);
}
