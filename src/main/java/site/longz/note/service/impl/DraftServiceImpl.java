package site.longz.note.service.impl;

import org.springframework.stereotype.Service;
import site.longz.note.dao.IDraftDao;
import site.longz.note.entity.Draft;
import site.longz.note.entity.Note;
import site.longz.note.service.IDraftService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 */
@Service("draftService")
public class DraftServiceImpl implements IDraftService {
	  @Resource
	  private IDraftDao draftDao;

	  public Serializable save(Note n) {
			Draft d = toDraft(n);
			return draftDao.save(d);
	  }

	  public void update(Note n) {
			Draft d = toDraft(n);
			draftDao.update(d);
	  }

	  public void delete(int id) {
	  	  draftDao.delete(id);
	  }

	  public Draft findById(int id) {
			return draftDao.findById(id);
	  }

	  public List<Note> findByUid(int uid) {
			List<Draft> drafts = draftDao.findByUid(uid);
			List<Note> notes = new ArrayList<Note>();
			for (Draft d:drafts){
				  notes.add(toNote(d));
			}
			return notes;
	  }

	  public Note toNote(Draft d) {
	  	  Note n = new Note();
			n.setNote(d.getNote());
			n.setTime(d.getTime());
			n.setTitle(d.getTitle());
			n.setUid(d.getUid());
			n.setId(d.getId());
			return n;
	  }

	  public Draft toDraft(Note n) {
			Draft d = new Draft();
			d.setNote(n.getNote());
			d.setTime(n.getTime());
			d.setTitle(n.getTitle());
			d.setUid(n.getUid());
			return d;
	  }

	  public void change(int id) {
			draftDao.change(id);
	  }
}
