package site.longz.note.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import site.longz.note.dao.IDraftDao;
import site.longz.note.entity.Draft;
import site.longz.note.entity.Note;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 */
@Repository("draftDao")
public class DraftDaoImpl implements IDraftDao{
	  @Resource
	  private SessionFactory sessionFactory;

	  public Serializable save(Draft d) {
			return sessionFactory.getCurrentSession().save(d);
	  }

	  public void update(Draft d) {
	  	  sessionFactory.getCurrentSession().update(d);
	  }

	  public void delete(int id) {
	  	  Session session = sessionFactory.getCurrentSession();
	  	  Draft d = (Draft) session.get(Draft.class,id);
	  	  session.delete(d);
	  }

	  public Draft findById(int id) {
			return  (Draft) sessionFactory.getCurrentSession().get(Draft.class,id);
	  }

	  public List<Draft> findByUid(int uid) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from Draft where uid=:uid";
			Query query = session.createQuery(sql);
			query.setParameter("uid",uid);
			return query.list();
	  }

	  public void change(int id){
			Session session = sessionFactory.getCurrentSession();
			Draft d = (Draft) session.get(Draft.class,id);
			Note n = new Note();
			n.setNote(d.getNote());
			n.setTime(d.getTime());
			n.setTitle(d.getTitle());
			n.setUid(d.getUid());
			n.setStatus(Note.USING);
			session.save(n);
			session.delete(d);
	  }
}
