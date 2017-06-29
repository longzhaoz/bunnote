package site.longz.note.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by longz on 17-6-25.
 */
@Entity
@Table(name = "draft",schema = "bunnote")
public class Draft {
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

	  @Override
	  public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Draft)) return false;

			Draft draft = (Draft) o;

			if (getId() != draft.getId()) return false;
			if (getUid() != draft.getUid()) return false;
			if (!getTitle().equals(draft.getTitle())) return false;
			if (!getNote().equals(draft.getNote())) return false;
			return getTime().equals(draft.getTime());
	  }

	  @Override
	  public int hashCode() {
			int result = getId();
			result = 31 * result + getUid();
			result = 31 * result + getTitle().hashCode();
			result = 31 * result + getNote().hashCode();
			result = 31 * result + getTime().hashCode();
			return result;
	  }
}
