package site.longz.note.service.impl;

import org.springframework.stereotype.Service;
import site.longz.note.dao.INoteDao;
import site.longz.note.dao.IRedisDao;
import site.longz.note.entity.Note;
import site.longz.note.service.INoteService;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 */
@Service("noteService")
public class NoteServiceImpl implements INoteService {
	  @Resource
	  private INoteDao noteDao;
	  @Resource
	  private IRedisDao<Note> redisDao;

	  public Serializable save(Note n) {
			String key = redisDao.EncoderByMd5(n.getUid() + "");
			noteDao.save(n);
			if (redisDao.findAll(key).isEmpty()) {
				  findAll(n.getUid());
			} else {
				  redisDao.save(key, n);
			}
			return n.getId();
	  }

	  public void update(Note n) {
			String key = redisDao.EncoderByMd5(n.getUid() + "");
			redisDao.update(key, n);
			noteDao.update(n);
	  }

	  public void delete(int id, int uid) {
			String key = redisDao.EncoderByMd5(uid + "");
			noteDao.delete(id);
			redisDao.delete(key, id);
	  }

	  public List<Note> findAll(int uid) {
			String key = redisDao.EncoderByMd5(uid + "");
			List<Note> notes = redisDao.findAll(key);
			if (notes.isEmpty()) {
				  notes = noteDao.findAll(uid);
				  redisDao.saveAll(key, notes);
			}
			return notes;
	  }

	  public Note findById(int id, int uid) {
			String key = redisDao.EncoderByMd5(uid + "");
			Note n = redisDao.findById(key, id);
			if (n == null) {
				  n = noteDao.findById(id);
			}
			return n;
	  }

	  public List<Note> findByUidStatus(int uid, int status) {
			List<Note> notes = findAll(uid);
			List<Note> check = new ArrayList<Note>();
			for (Note n : notes) {
				  if (n.getStatus() == status) {
						check.add(n);
				  }
			}
			if (check.isEmpty()) {
				  check = noteDao.findByUidStatus(uid, status);
			}
			return check;
	  }

	  public int countByIdStatus(int uid, int status) {
			int num = findByUidStatus(uid, status).size();
			if (num == 0) {
				  num = noteDao.countByIdStatus(uid, status);
			}
			return num;

	  }

	  public List<Note> pageByIdStatus(int uid, int status, int page, int pageSize) {

			List<Note> notes = findByUidStatus(uid, status);
			if (notes.isEmpty()) {
				  notes = findAll(uid);
			}
			if (pageSize * page < notes.size()) {
				  notes = notes.subList((page - 1) * pageSize, page * pageSize);
			}else {
				  notes = notes.subList((page - 1) * pageSize,notes.size());
			}
			if (notes.isEmpty()) {
				  notes = noteDao.pageByIdStatus(uid, status, page, pageSize);
			}
			return notes;
	  }
}
