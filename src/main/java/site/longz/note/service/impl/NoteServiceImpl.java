package site.longz.note.service.impl;

import org.springframework.stereotype.Service;
import site.longz.note.dao.INoteDao;
import site.longz.note.entity.Note;
import site.longz.note.service.INoteService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 *
 */
@Service("noteService")
public class NoteServiceImpl implements INoteService {
	  @Resource
	  private INoteDao noteDao;

	  public Serializable save(Note n) {
			return noteDao.save(n);
	  }

	  public void update(Note n) {
	  	  noteDao.update(n);
	  }

	  public void delete(int id) {
	  	  noteDao.delete(id);
	  }

	  public List<Note> findAll() {
			return noteDao.findAll();
	  }

	  public Note findById(int id) {
			return noteDao.findById(id);
	  }

	  public List<Note> findByUidStatus(int uid, int status) {
			return noteDao.findByUidStatus(uid,status);
	  }

	  public int countByIdStatus(int uid,int status){
			return noteDao.countByIdStatus(uid,status);
	  }

	  public List<Note> pageByIdStatus(int uid, int status, int page,int pageSize) {

			return noteDao.pageByIdStatus(uid,status,page,pageSize);
	  }
}
