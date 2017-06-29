package site.longz.note.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import site.longz.note.dao.IBackupDao;
import site.longz.note.entity.Backup;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by longz on 17-6-27.
 */
@Repository("backupDao")
public class BackupDaoImpl implements IBackupDao{
	  @Resource
	  private SessionFactory sessionFactory;

	  public Serializable save(Backup b) {
			return sessionFactory.getCurrentSession().save(b);
	  }

	  public void update(Backup b) {
	  	  sessionFactory.getCurrentSession().update(b);
	  }

	  public void delete(int id) {
			Session session = sessionFactory.getCurrentSession();
			Backup b = (Backup)session.get(Backup.class,id);
			session.delete(b);
	  }

	  public Backup findByNid(int nid) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from Backup where nid=:nid";
			Query query = session.createQuery(sql);
			query.setParameter("nid",nid);
			return (Backup)query.uniqueResult();
	  }
}
