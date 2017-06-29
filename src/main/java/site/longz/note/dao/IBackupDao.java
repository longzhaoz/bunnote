package site.longz.note.dao;

import site.longz.note.entity.Backup;

import java.io.Serializable;

/**
 * Created by longz on 17-6-27.
 */
public interface IBackupDao {
	  Serializable save(Backup b);
	  void update(Backup b);
	  void delete(int id);
	  Backup findByNid(int nid);
}
