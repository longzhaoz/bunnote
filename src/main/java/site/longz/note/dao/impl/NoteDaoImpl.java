package site.longz.note.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import site.longz.note.dao.INoteDao;
import site.longz.note.entity.Note;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 */
@Repository("noteDao")
public class NoteDaoImpl implements INoteDao{
	  @Resource
	  private SessionFactory sessionFactory;

	  public Serializable save(Note n) {
			return sessionFactory.getCurrentSession().save(n);
	  }

	  public void update(Note n) {
	  	  sessionFactory.getCurrentSession().update(n);
	  }

	  public void delete(int id) {
			Session session = sessionFactory.getCurrentSession();
			Note n = (Note) session.get(Note.class,id);
			session.delete(n);
	  }

	  public List<Note> findAll(int uid) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from Note where uid=:uid";
			Query query = session.createQuery(sql);
			query.setParameter("uid",uid);
			return query.list();
	  }

	  public Note findById(int id) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from Note where id=:id";
			Query query = session.createQuery(sql);
			query.setParameter("id",id);
			return (Note) query.uniqueResult();
	  }

	  public List<Note> findByUidStatus(int uid,int status) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from Note where uid=:uid and status=:status";
			Query query = session.createQuery(sql);
			query.setParameter("uid",uid);
			query.setParameter("status",status);
			return query.list();
	  }
	  public int countByIdStatus(int uid,int status){
	  	  Session session = sessionFactory.getCurrentSession();
	  	  String sql ="select count(*) from Note where uid=:uid and status=:status";
	  	  Query query = session.createQuery(sql);
	  	  query.setParameter("uid",uid);
	  	  query.setParameter("status",status);
	  	  return   ((Number) query.uniqueResult()).intValue();
	  }
	  public List<Note> pageByIdStatus(int uid,int status,int page,int pagesize){
	  	  Session session = sessionFactory.getCurrentSession();
	  	  String sql = "from Note where uid=:uid and status=:status";
	  	  Query query = session.createQuery(sql);
	  	  query.setParameter("uid",uid);
	  	  query.setParameter("status",status);
	  	  query.setFirstResult((page-1)*pagesize);
	  	  query.setMaxResults(pagesize);
	  	  return  query.list();
	  }
}
