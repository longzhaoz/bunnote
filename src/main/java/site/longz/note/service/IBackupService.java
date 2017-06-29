package site.longz.note.service;

import site.longz.note.entity.Backup;
import site.longz.note.entity.Note;

import java.io.Serializable;

/**
 * Created by longz on 17-6-27.
 */
public interface IBackupService {
	  Serializable save(Backup b);
	  void updateOrSave(Note n);
	  void delete(int id);
	  Backup findByNid(int nid);
	  Note rollback(Note n,int num);
}
