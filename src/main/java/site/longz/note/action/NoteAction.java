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

	  private int page;

	  private List<Note> notes;

	  private Note note;

	  public int getPage() {
			return page;
	  }

	  public void setPage(int page) {
			this.page = page;
	  }

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
			int max = noteService.countByIdStatus(user.getId(), Note.USING);
			int pageSize =10;
			int maxPage = (int) Math.ceil(1.0 * max / pageSize);
			if (page<1){
				  page=1;
			}
			if (page>maxPage){
				  page=maxPage;
			}
			setAttribute("maxPage",maxPage);
			setAttribute("page",page);
			notes = noteService.pageByIdStatus(user.getId(),Note.USING,page,pageSize);
			return "success";
	  }

	  /**
	   * 添加笔记
	   */
	  public String add() {
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
			note = noteService.findById(note.getId(),user.getId());
			if (note == null) {
				  setInfo("页面错误", "没找到对应的笔记", "/note/index.jsp");
				  return "error";
			}
			if (note.getUid() != user.getId()) {
				  setInfo("权限错误", "您无权对此笔记就行修改", "/note/index.jsp");
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
				  backupService.updateOrSave(noteService.findById(note.getId(),user.getId()));
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
			note = noteService.findById(note.getId(),user.getId());
			if (note.getUid() != user.getId()) {
				  setInfo("权限错误", "您无权对此笔记就行修改", "/note/index.jsp");
				  return "error";
			}
			note.setStatus(Note.TRASH);
			noteService.update(note);
			return "success";
	  }

	  public String viewtrash() {
			User user = (User) getSession("userLogined");
			int max = noteService.countByIdStatus(user.getId(), Note.TRASH);
			System.out.println("max"+max);
			int pageSize =10;
			int maxPage = (int) Math.ceil(1.0 * max / pageSize);
			if (page<1){
				  page=1;
			}
			if (page>maxPage){
				  page=maxPage;
			}
			setAttribute("maxPage",maxPage);
			setAttribute("page",page);
			notes = noteService.pageByIdStatus(user.getId(),Note.TRASH,page,pageSize);
			return "success";
	  }

	  public String del() {
			User user = (User) getSession("userLogined");
			if (noteService.findById(note.getId(),user.getId()).getUid() != user.getId()) {
				  setInfo("权限错误", "您无权对此笔记就行修改", "/note/index.jsp");
				  return "error";
			}
			Backup b = backupService.findByNid(note.getId());
			if (b != null) {
				  backupService.delete(b.getId());
			}
			noteService.delete(note.getId(),user.getId());
			return "success";
	  }

	  public String goback() {
			User user = (User) getSession("userLogined");
			note = noteService.findById(note.getId(),user.getId());
			if (note.getUid() != user.getId()) {
				  setInfo("权限错误", "您无权对此笔记就行修改", "/note/index.jsp");
				  return "error";
			}
			note.setStatus(Note.USING);
			noteService.update(note);
			return "success";
	  }

	  public String rollback() {
			User user = (User) getSession("userLogined");
			if (type == 0) {
				  setInfo("权限错误", "您输入的网址有误", "/note/index.jsp");
				  return "error";
			}
			note = noteService.findById(note.getId(),user.getId());
			note = backupService.rollback(note, type);
			noteService.update(note);
			return "success";
	  }

	  public String viewbackup() {
			Backup b = backupService.findByNid(note.getId());
			if (b == null) {
				  setInfo("备份错误", "没有找到备份", "/note/index.jsp");
				  return "error";
			}
			notes = b.toNotes();

			return "success";
	  }

	  public String preview() {
			User user = (User) getSession("userLogined");
			note = noteService.findById(note.getId(),user.getId());
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

	  public String deleteDraft() {
			draftService.delete(note.getId());
			return "success";
	  }
}
