package site.longz.note.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by longz on 17-6-24.
 */
@Entity
@Table(name = "user",schema = "bunnote")
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(nullable = false)
	  private int id;
	  @Column(nullable = false,unique=true)
	  private String name;
	  @Column(nullable = false)
	  private String alias;
	  @Column(nullable = false)
	  private String password;
	  @Column(nullable = false)
	  private Date time;
	  @Column(nullable = false)
	  private Date regTime;

	  public int getId() {
			return id;
	  }

	  public void setId(int id) {
			this.id = id;
	  }

	  public String getName() {
			return name;
	  }

	  public void setName(String name) {
			this.name = name;
	  }

	  public String getAlias() {
			return alias;
	  }

	  public void setAlias(String alias) {
			this.alias = alias;
	  }

	  public String getPassword() {
			return password;
	  }

	  public void setPassword(String password) {
			this.password = password;
	  }

	  public Date getTime() {
			return time;
	  }

	  public void setTime(Date time) {
			this.time = time;
	  }

	  public Date getRegTime() {
			return regTime;
	  }

	  public void setRegTime(Date regTime) {
			this.regTime = regTime;
	  }

	  @Override
	  public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof User)) return false;

			User user = (User) o;

			if (getId() != user.getId()) return false;
			if (!getName().equals(user.getName())) return false;
			if (getAlias() != null ? !getAlias().equals(user.getAlias()) : user.getAlias() != null) return false;
			if (!getPassword().equals(user.getPassword())) return false;
			if (!getTime().equals(user.getTime())) return false;
			return getRegTime().equals(user.getRegTime());
	  }

	  @Override
	  public int hashCode() {
			int result = getId();
			result = 31 * result + getName().hashCode();
			result = 31 * result + (getAlias() != null ? getAlias().hashCode() : 0);
			result = 31 * result + getPassword().hashCode();
			result = 31 * result + getTime().hashCode();
			result = 31 * result + getRegTime().hashCode();
			return result;
	  }

	  @Override
	  public String toString() {
			return "User{" +
					"id=" + id +
					", name='" + name + '\'' +
					", alias='" + alias + '\'' +
					", password='" + password + '\'' +
					", time=" + time +
					", regTime=" + regTime +
					'}';
	  }
}
