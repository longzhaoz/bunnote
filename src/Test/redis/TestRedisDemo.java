package redis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.*;
import site.longz.note.entity.Note;

import java.util.*;

/**
 * Created by longz on 17-7-4.
 */
public class TestRedisDemo {
	  private ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml", "spring-redis.xml", "spring-hibernate.xml");
	  private final RedisTemplate redisTemplate = context.getBean("redisTemplate", RedisTemplate.class);

	  @Test
	  public void test1() {
			ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
//			valueOperations.set("lp", "hello word");

			System.out.println(valueOperations.get("lp"));
	  }

	  @Test
	  public void test2() {
			HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "1p");
			map.put("age", "26");
			hash.putAll("lpMap", map);
			System.out.println(hash.entries("lpMap"));
	  }

	  @Test
	  public void test3() {
			ListOperations<String, Object> listOperations = redisTemplate.opsForList();
			listOperations.rightPush("lplist", "lp");
			listOperations.rightPush("lplist", "26");
			List list = listOperations.range("dplist",0,999);
			System.out.println(list.isEmpty());
			System.out.println(listOperations.range("dplist", 0, 99999999));
	  }

	  @Test
	  public void test4() {
			SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
			setOperations.add("lpSet", "lp");
			setOperations.add("lpset", "26");
			setOperations.add("lpSet", "178cm");
			System.out.println(setOperations.members("lpset"));
	  }

	  @Test
	  public void test5() {
			ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
			zSetOperations.add("lpZest", "lp", 0);
			zSetOperations.add("lpZest", "26", 2);
			zSetOperations.add("lpZest", "178", 1);
			zSetOperations.add("lpZest", "25", 2);
			System.out.println(zSetOperations.rangeByScore("lpZest", 0, 2));
	  }

	  @Test
	  public void test6() {
			RedisOperations<String, Object> redisOperations = redisTemplate;
			redisOperations.delete("lp");
	  }

	  @Test
	  public void test7() {
			Note note = new Note();
			System.out.println(note.getClass());
			showC(note);
	  }

	  private void showC(Object o) {
			System.out.println(o.getClass());
	  }

	  @Test
	  public void test8() {
			List<Integer> is = new ArrayList<Integer>();
			for (int i = 0; i < 10; i++) {
				  is.add(i);
			}

			for (Integer i : is) {
				  if (i == 6) {
				  	 is.set(6,7);
				  }
			}
			System.out.println(is);
	  }
}
