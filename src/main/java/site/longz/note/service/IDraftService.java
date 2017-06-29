package site.longz.note.service;

import site.longz.note.entity.Draft;
import site.longz.note.entity.Note;

import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 */
public interface IDraftService {
	  Serializable save(Note n);
	  void update(Note n);
	  void delete(int id);
	  Draft findById(int id);
	  List<Note> findByUid(int uid);
	  Note toNote(Draft d);
	  Draft toDraft(Note n);
	  void change(int id);
}
