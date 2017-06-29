package site.longz.note.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by longz on 17-6-25.
 */
@Entity
@Table(name = "backup", schema = "bunnote")
public class Backup {
	  @Id
	  @Column(nullable = false)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  @Column(nullable = false, unique = true)
	  private int nid;
	  @Column(length = 65533, columnDefinition = "TEXT", nullable = false)
	  private String note1;
	  @Column(length = 65533, columnDefinition = "TEXT")
	  private String note2;
	  @Column(length = 65533, columnDefinition = "TEXT")
	  private String note3;
	  @Column(length = 65533, columnDefinition = "TEXT")
	  private String note4;
	  @Column(length = 65533, columnDefinition = "TEXT")
	  private String note5;
	  @Column(nullable = false)
	  private Date time1;
	  @Column
	  private Date time2;
	  @Column
	  private Date time3;
	  @Column
	  private Date time4;
	  @Column
	  private Date time5;

	  public int getId() {
			return id;
	  }

	  public void setId(int id) {
			this.id = id;
	  }

	  public int getNid() {
			return nid;
	  }

	  public void setNid(int nid) {
			this.nid = nid;
	  }

	  public String getNote1() {
			return note1;
	  }

	  public void setNote1(String note1) {
			this.note1 = note1;
	  }

	  public String getNote2() {
			return note2;
	  }

	  public void setNote2(String note2) {
			this.note2 = note2;
	  }

	  public String getNote3() {
			return note3;
	  }

	  public void setNote3(String note3) {
			this.note3 = note3;
	  }

	  public String getNote4() {
			return note4;
	  }

	  public void setNote4(String note4) {
			this.note4 = note4;
	  }

	  public Date getTime1() {
			return time1;
	  }

	  public void setTime1(Date time1) {
			this.time1 = time1;
	  }

	  public Date getTime2() {
			return time2;
	  }

	  public void setTime2(Date time2) {
			this.time2 = time2;
	  }

	  public Date getTime3() {
			return time3;
	  }

	  public void setTime3(Date time3) {
			this.time3 = time3;
	  }

	  public Date getTime4() {
			return time4;
	  }

	  public void setTime4(Date time4) {
			this.time4 = time4;
	  }

	  public String getNote5() {
			return note5;
	  }

	  public void setNote5(String note5) {
			this.note5 = note5;
	  }

	  public Date getTime5() {
			return time5;
	  }

	  public void setTime5(Date time5) {
			this.time5 = time5;
	  }

	  @Override
	  public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Backup)) return false;

			Backup backup = (Backup) o;

			if (getId() != backup.getId()) return false;
			if (getNid() != backup.getNid()) return false;
			if (!getNote1().equals(backup.getNote1())) return false;
			if (getNote2() != null ? !getNote2().equals(backup.getNote2()) : backup.getNote2() != null) return false;
			if (getNote3() != null ? !getNote3().equals(backup.getNote3()) : backup.getNote3() != null) return false;
			if (getNote4() != null ? !getNote4().equals(backup.getNote4()) : backup.getNote4() != null) return false;
			if (!getTime1().equals(backup.getTime1())) return false;
			if (getTime2() != null ? !getTime2().equals(backup.getTime2()) : backup.getTime2() != null) return false;
			if (getTime3() != null ? !getTime3().equals(backup.getTime3()) : backup.getTime3() != null) return false;
			return getTime4() != null ? getTime4().equals(backup.getTime4()) : backup.getTime4() == null;
	  }

	  @Override
	  public int hashCode() {
			int result = getId();
			result = 31 * result + getNid();
			result = 31 * result + getNote1().hashCode();
			result = 31 * result + (getNote2() != null ? getNote2().hashCode() : 0);
			result = 31 * result + (getNote3() != null ? getNote3().hashCode() : 0);
			result = 31 * result + (getNote4() != null ? getNote4().hashCode() : 0);
			result = 31 * result + getTime1().hashCode();
			result = 31 * result + (getTime2() != null ? getTime2().hashCode() : 0);
			result = 31 * result + (getTime3() != null ? getTime3().hashCode() : 0);
			result = 31 * result + (getTime4() != null ? getTime4().hashCode() : 0);
			return result;
	  }

	  public Note getNote(int num) {
			Note n = new Note();
			n.setId(nid);
			switch (num) {
				  case 1:
						n.setNote(getNote1());
						n.setTime(getTime1());
						setNote1(null);
						setTime1(null);
						break;
				  case 2:
						n.setNote(getNote2());
						n.setTime(getTime2());
						setNote2(null);
						setTime2(null);
						break;
				  case 3:
						n.setNote(getNote3());
						n.setTime(getTime3());
						setNote3(null);
						setTime3(null);
						break;
				  case 4:
						n.setNote(getNote4());
						n.setTime(getTime4());
						setNote4(null);
						setTime4(null);
						break;
				  case 5:
						n.setNote(getNote5());
						n.setTime(getTime5());
						setNote5(null);
						setTime5(null);
						break;
			}
			return n;
	  }

	  public void rank() {
			if (note1 == null && note2 != null) {
				  note1 = note2;
				  time1 = time2;
				  note2 = null;
				  time2 = null;
			}
			if (note2 == null && note3 != null) {
				  note2 = note3;
				  time2 = time3;
				  note3 = null;
				  time3 = null;
			}
			if (note3 == null && note4 != null) {
				  note3 = note4;
				  time3 = time4;
				  note4 = null;
				  time4 = null;
			}
			if (note4 == null && note5 != null) {
				  note4 = note5;
				  time4 = time5;
				  note5 = null;
				  time5 = null;
			}
	  }
	  public List<Note> toNotes(){
	  	  List<Note> notes = new ArrayList<Note>();
			if (note1 != null) {
				  notes.add(getNote(1));
			}
			if (note2 != null) {
				  notes.add(getNote(2));
			}
			if (note3 != null) {
				  notes.add(getNote(3));
			}
			if (note4 != null) {
				  notes.add(getNote(4));
			}
			if (note5 != null) {
				  notes.add(getNote(5));
			}
			return notes;
	  }
}
