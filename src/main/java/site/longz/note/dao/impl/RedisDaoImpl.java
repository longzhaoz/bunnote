package site.longz.note.dao.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import site.longz.note.dao.IRedisDao;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by longz on 17-7-4.
 */
@Repository("redisDao")
public class RedisDaoImpl<T> implements IRedisDao<T> {
	  @Resource
	  private RedisTemplate<String, T> redisTemplate;

	  public void save(String key, T t) {
			redisTemplate.opsForList().rightPush(key, t);
	  }

	  public void update(String key, T t) {
			Long size = redisTemplate.opsForList().size(key);
			T tmp;
			for (int i = 0; i < size; i++) {
				  tmp = redisTemplate.opsForList().index(key,i);
				  if (tmp.toString().equals(t.toString())){
				  	  redisTemplate.opsForList().set(key,i,t);
				  }
			}
	  }

	  public void delete(String key, int id) {
			Long size = redisTemplate.opsForList().size(key);
			T tmp;
			for (int i = 0; i < size; i++) {
				  tmp = redisTemplate.opsForList().index(key,i);
				  if (tmp.toString().equals(id+"")){
						redisTemplate.opsForList().remove(key,1,tmp);
						break;
				  }
			}
	  }

	  public T findById(String key, int id) {
			List<T> ts = findAll(key);
			for (T ti : ts) {
				  if (ti.toString().equals(id + "")) {
						return ti;
				  }
			}
			return null;
	  }

	  public List<T> findAll(String key) {
			return redisTemplate.opsForList().range(key, 0, -1);
	  }

	  public List<T> findPage(String key, int page, int pagesize) {
			return null;
	  }

	  public void saveAll(String key, List<T> tList) {
			for (T t : tList) {
				  redisTemplate.opsForList().rightPush(key, t);
			}
	  }

	  /**
	   * 利用MD5进行加密
	   *
	   * @param str 待加密的字符串
	   * @return 加密后的字符串
	   */
	  public String EncoderByMd5(String str) {
			//确定计算方法
			MessageDigest md5 = null;
			try {
				  md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				  e.printStackTrace();
			}
			BASE64Encoder base64en = new BASE64Encoder();
			//加密后的字符串
			try {
				  return base64en.encode(md5.digest(str.getBytes("utf-8")));
			} catch (UnsupportedEncodingException e) {
				  e.printStackTrace();
			}
			return null;
	  }
}
