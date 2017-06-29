package site.longz.note.service.impl;

import org.springframework.stereotype.Service;
import site.longz.note.dao.IBackupDao;
import site.longz.note.entity.Backup;
import site.longz.note.entity.Note;
import site.longz.note.service.IBackupService;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by longz on 17-6-27.
 */
@Service("backupService")
public class BackupServiceImpl implements IBackupService {
	  @Resource
	  private IBackupDao backupDao;


	  public Serializable save(Backup b) {
			return backupDao.save(b);
	  }

	  public void updateOrSave(Note n) {
			Backup b = backupDao.findByNid(n.getId());
			if (b == null) {
				  b = new Backup();
				  b.setNid(n.getId());
				  b.setNote1(n.getNote());
				  b.setTime1(n.getTime());
				  backupDao.save(b);
			} else {
				  b.setTime5(b.getTime4());
				  b.setTime4(b.getTime3());
				  b.setTime3(b.getTime2());
				  b.setTime2(b.getTime1());
				  b.setNote5(b.getNote4());
				  b.setNote4(b.getNote3());
				  b.setNote3(b.getNote2());
				  b.setNote2(b.getNote1());
				  b.setNote1(n.getNote());
				  b.setTime1(n.getTime());
				  backupDao.update(b);
			}
	  }

	  public void delete(int id) {
			backupDao.delete(id);
	  }

	  public Backup findByNid(int nid) {
			return backupDao.findByNid(nid);
	  }

	  public Note rollback(Note n, int num) {
			Backup b = findByNid(n.getId());
			Note note = b.getNote(num);
			n.setNote(note.getNote());
			n.setTime(note.getTime());
			b.rank();
			if (b.getNote1()==null){
				  backupDao.delete(b.getId());
			}else {
				  backupDao.update(b);
			}
			return n;
	  }
}
