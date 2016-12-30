package cn.techouse.ims.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="user")
public class User  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private Integer salt;
	@Column(nullable=false)
	private String nickname;
	private Date lastLoginTime;
	private Integer errorInputTimes;
	private Date unfreezeTime;
	
	private String validFlag;
	@Column(updatable=false,insertable=true)
	private Date insertTimeForHis;
	
	@Column(updatable=true,insertable=false)
	private Date operateTimeForHis;

	/*****************************关系 BEGIN****************************/
	/**用户所属用户组集合***/
	@OneToMany(fetch=FetchType.LAZY)
	@Cascade({CascadeType.SAVE_UPDATE,CascadeType.PERSIST})
	@JoinTable(
			name="user_group_relation",//中间表
			joinColumns = {@JoinColumn(name = "user_id")},//JoinColumns定义本方在中间表的主键映射
			inverseJoinColumns = {@JoinColumn(name = "group_id")}//inverseJoinColumns定义另一在中间表的主键映射
			
			)
	private Set<UserGroup> groups;
	
	
	
	/*****************************关系 END******************************/
	
	/***/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSalt() {
		return salt;
	}

	public void setSalt(Integer salt) {
		this.salt = salt;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getErrorInputTimes() {
		return errorInputTimes;
	}

	public void setErrorInputTimes(Integer errorInputTimes) {
		this.errorInputTimes = errorInputTimes;
	}

	public Date getUnfreezeTime() {
		return unfreezeTime;
	}

	public void setUnfreezeTime(Date unfreezeTime) {
		this.unfreezeTime = unfreezeTime;
	}

	public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public Date getInsertTimeForHis() {
		return insertTimeForHis;
	}

	public void setInsertTimeForHis(Date insertTimeForHis) {
		this.insertTimeForHis = insertTimeForHis;
	}

	public Date getOperateTimeForHis() {
		return operateTimeForHis;
	}

	public void setOperateTimeForHis(Date operateTimeForHis) {
		this.operateTimeForHis = operateTimeForHis;
	}

	public Set<UserGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<UserGroup> groups) {
		this.groups = groups;
	}
}
