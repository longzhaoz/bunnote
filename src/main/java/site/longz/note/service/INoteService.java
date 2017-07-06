package site.longz.note.service;

import site.longz.note.entity.Note;

import java.io.Serializable;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 */
public interface INoteService {
	  Serializable save(Note n);
	  void update(Note n);
	  void delete(int id,int uid);
	  List<Note> findAll(int uid);
	  Note findById(int id,int uid);
	  List<Note> findByUidStatus(int uid,int status);
	  int countByIdStatus(int uid,int status);
	  List<Note> pageByIdStatus(int uid,int status,int page,int pageSize);
}
