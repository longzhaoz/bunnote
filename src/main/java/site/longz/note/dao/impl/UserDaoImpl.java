package site.longz.note.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import site.longz.note.dao.IUserDao;
import site.longz.note.entity.User;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-24.
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	  @Resource
	  private SessionFactory sessionFactory;

	  public Serializable save(User u) {
			return sessionFactory.getCurrentSession().save(u);
	  }

	  public void update(User u) {
			sessionFactory.getCurrentSession().update(u);
	  }

	  public void delete(int id) {
			Session session = sessionFactory.getCurrentSession();
			User u = (User) session.get(User.class, id);
			session.delete(u);
	  }

	  public List<User> findAll() {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from User";
			Query query = session.createQuery(sql);
			return query.list();
	  }

	  public User findById(int id) {
	  	  Session session = sessionFactory.getCurrentSession();
	  	  String sql = "from User where id=:id";
	  	  Query query = session.createQuery(sql);
	  	  query.setParameter("id",id);
			return (User) query.uniqueResult();
	  }

	  public User findByName(String name) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from User where name=:name";
			Query query = session.createQuery(sql);
			query.setParameter("name",name);
			return (User) query.uniqueResult();
	  }

	  public User findByNamePassword(User u) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from User where name=:name and password=:password";
			Query query = session.createQuery(sql);
			query.setParameter("name",u.getName());
			query.setParameter("password",u.getPassword());
			return (User) query.uniqueResult();

	  }
}
