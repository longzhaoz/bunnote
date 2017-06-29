package site.longz.note.dao;

import site.longz.note.entity.Note;

import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 */
public interface INoteDao {
	  Serializable save(Note n);
	  void update(Note n);
	  void delete(int id);
	  List<Note> findAll();
	  Note findById(int id);
	  List<Note> findByUidStatus(int uid,int status);
}
