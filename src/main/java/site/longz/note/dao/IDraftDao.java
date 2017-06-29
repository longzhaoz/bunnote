package site.longz.note.dao;

import site.longz.note.entity.Draft;

import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 */
public interface IDraftDao {
	  Serializable save(Draft d);
	  void update(Draft d);
	  void delete(int id);
	  Draft findById(int id);
	  List<Draft> findByUid(int uid);
	  void change(int id);
}
