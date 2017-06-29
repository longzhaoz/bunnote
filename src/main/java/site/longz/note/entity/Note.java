package site.longz.note.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by longz on 17-6-25.
 */
@Entity
@Table(name = "note",schema = "bunnote")
public class Note {
	  @Id
	  @Column(nullable = false)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  @Column(nullable = false)
	  private int uid;
	  @Column(nullable = false)
	  private String title;
	  @Column(length = 65533,columnDefinition = "TEXT",nullable = false)
	  private String note;
	  @Column(nullable = false)
	  private Date time;
	  @Column(nullable = false)
	  private int status;

	  public static final int USING = 0;
	  public static final int TRASH = 1;
	  public static final int OTHER = 2;
	  public int getId() {
			return id;
	  }

	  public void setId(int id) {
			this.id = id;
	  }

	  public int getUid() {
			return uid;
	  }

	  public void setUid(int uid) {
			this.uid = uid;
	  }

	  public String getTitle() {
			return title;
	  }

	  public void setTitle(String title) {
			this.title = title;
	  }

	  public String getNote() {
			return note;
	  }

	  public void setNote(String note) {
			this.note = note;
	  }

	  public Date getTime() {
			return time;
	  }

	  public void setTime(Date time) {
			this.time = time;
	  }

	  public int getStatus() {
			return status;
	  }

	  public void setStatus(int status) {
			this.status = status;
	  }

	  @Override
	  public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Note)) return false;

			Note note1 = (Note) o;

			if (getId() != note1.getId()) return false;
			if (getUid() != note1.getUid()) return false;
			if (getStatus() != note1.getStatus()) return false;
			if (!getTitle().equals(note1.getTitle())) return false;
			if (!getNote().equals(note1.getNote())) return false;
			return getTime().equals(note1.getTime());
	  }

	  @Override
	  public int hashCode() {
			int result = getId();
			result = 31 * result + getUid();
			result = 31 * result + getTitle().hashCode();
			result = 31 * result + getNote().hashCode();
			result = 31 * result + getTime().hashCode();
			result = 31 * result + getStatus();
			return result;
	  }
}
