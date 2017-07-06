package site.longz.note.dao;

import java.util.*;

/**
 * Created by longz on 17-7-4.
 */
public interface IRedisDao<T> {
	  void save(String key,T t);
	  void update(String key,T t);
	  void delete(String key,int id);
	  T findById(String key,int id);
	  List<T> findAll(String key);
	  List<T> findPage(String key,int page,int pagesize);
	  void saveAll(String key,List<T> tList);
	  String EncoderByMd5(String str);
}
