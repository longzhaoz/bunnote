package site.longz.note.action;

import org.markdown4j.Markdown4jProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import site.longz.note.entity.Backup;
import site.longz.note.entity.Draft;
import site.longz.note.entity.Note;
import site.longz.note.entity.User;
import site.longz.note.service.IBackupService;
import site.longz.note.service.IDraftService;
import site.longz.note.service.INoteService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by longz on 17-6-27.
 * 笔记相关操作
 */
@Controller
@Scope("prototype")
public class NoteAction extends BaseActionSupport {
	  @Resource
	  private INoteService noteService;
	  @Resource
	  private IDraftService draftService;
	  @Resource
	  private IBackupService backupService;

	  private int type;

	  private List<Note> notes;

	  private Note note;

	  public List<Note> getNotes() {
			return notes;
	  }

	  public void setNotes(List<Note> notes) {
			this.notes = notes;
	  }

	  public Note getNote() {
			return note;
	  }

	  public void setNote(Note note) {
			this.note = note;
	  }

	  public int getType() {
			return type;
	  }

	  public void setType(int type) {
			this.type = type;
	  }

	  public String index() {
			User user = (User) getSession("userLogined");
			if (user == null) {
				  setInfo("地址错误", "您还没有登录", "/user/loginx.jsp");
				  return "error";
			}
			notes = noteService.findByUidStatus(user.getId(), Note.USING);
			return "success";
	  }

	  /**
	   * 添加笔记
	   */
	  public String add() {
			if (note == null) {
				  title = "添加错误";
				  message = "您没有正常输入笔记";
				  url = "/note/index.jsp";
				  return "error";
			}
			User user = (User) getSession("userLogined");
			note.setUid(user.getId());
			note.setStatus(Note.USING);
			note.setTime(new Date());
			Map<String, Object> data = new HashMap<String, Object>();
			try {
				  noteService.save(note);
				  data.put("flag", true);
				  writeJson(data);
			} catch (Exception e) {
				  data.put("flag", false);
				  writeJson(data);
			}
			return null;
	  }

	  /**
	   * 获取已有内容发布到编辑器
	   */
	  public String modifyx() {
			User user = (User) getSession("userLogined");
			note = noteService.findById(note.getId());
			if (note == null) {
				  return "error";
			}
			if (note.getUid() != user.getId()) {
				  return "error";
			}
			return "success";
	  }


	  public String modify() {
			User user = (User) getSession("userLogined");
			note.setUid(user.getId());
			note.setStatus(Note.USING);
			note.setTime(new Date());
			Map<String, Object> data = new HashMap<String, Object>();
			try {
				  backupService.updateOrSave(noteService.findById(note.getId()));
				  noteService.update(note);
				  data.put("flag", true);
				  writeJson(data);
			} catch (Exception e) {
				  data.put("flag", false);
				  writeJson(data);
			}
			return "success";
	  }

	  public String delete() {
			User user = (User) getSession("userLogined");
			note = noteService.findById(note.getId());
			if (note.getUid() != user.getId()) {
				  return "error";
			}
			note.setStatus(Note.TRASH);
			noteService.update(note);
			return "success";
	  }

	  public String viewtrash() {
			User user = (User) getSession("userLogined");
			notes = noteService.findByUidStatus(user.getId(), Note.TRASH);
			return "success";
	  }

	  public String del() {
			User user = (User) getSession("userLogined");
			if (noteService.findById(note.getId()).getUid() != user.getId()) {
				  return "error";
			}
			Backup b = backupService.findByNid(note.getId());
			if (b != null) {
				  backupService.delete(b.getId());
			}
			noteService.delete(note.getId());
			return "success";
	  }

	  public String goback() {
			note = noteService.findById(note.getId());
			User user = (User) getSession("userLogined");
			if (note.getUid() != user.getId()) {
				  return "error";
			}
			note.setStatus(Note.USING);
			noteService.update(note);
			return "success";
	  }

	  public String rollback() {
			if (type == 0) {
				  return "error";
			}
			note = noteService.findById(note.getId());
			note = backupService.rollback(note, type);
			noteService.update(note);
			return "success";
	  }

	  public String viewbackup() {
			Backup b = backupService.findByNid(note.getId());
			if (b==null){
				  setInfo("备份错误","没有找到备份","/note/index.jsp");
				  return "error";
			}
			notes = b.toNotes();

			return "success";
	  }

	  public String preview() {
			note = noteService.findById(note.getId());
			try {
				  note.setNote(new Markdown4jProcessor().process(note.getNote()));
			} catch (IOException e) {
				  return "error";
			}
			return "success";
	  }

	  public String viewDraft() {
			User user = (User) getSession("userLogined");
			notes = draftService.findByUid(user.getId());
			return "success";
	  }

	  public String saveDraft() {
			User user = (User) getSession("userLogined");
			note.setUid(user.getId());
			note.setStatus(Note.USING);
			note.setTime(new Date());
			Map<String, Object> data = new HashMap<String, Object>();
			try {
				  draftService.save(note);
				  data.put("flag", true);
				  writeJson(data);
			} catch (Exception e) {
				  data.put("flag", false);
				  writeJson(data);
			}
			return null;
	  }

	  public String changeDraft() {
			draftService.change(note.getId());
			return "success";
	  }

	  public String deleteDraft(){
			draftService.delete(note.getId());
			return "success";
	  }
}
