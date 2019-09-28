package com.cg.testmanagement.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	@NotNull(message = "User Id cannot be empty!")
	private Long userId;
	@Column(name = "user_name")
	@NotEmpty(message = "Username cannot be empty!")
	@Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters long!")
	@Pattern(regexp = "^[A-Z][A-Za-z 0-9_-]*$", message = "Username must start with a capital letter!")
	private String userName;
	@Column(name = "user_password")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]{8,}$", message = "Password should contain at least one upper case character, one lower case character, one numeric character and one special character!")
	@Size(min = 8, message = "Password should be atleast 8 characters long!")
	private String userPassword;
	@OneToOne
	@JoinColumn(name="test_id")
	private OnlineTest userTest;
	@Column(name = "is_admin")
	private Boolean isAdmin;
	@Column(name = "is_deleted")
	private Boolean isDeleted;

	public User() {
		super();
	}

	public User(Long userId, String userName, String userPassword, OnlineTest userTest, Boolean isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTest = userTest;
		this.isAdmin = isAdmin;
		this.isDeleted = false;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public OnlineTest getUserTest() {
		return userTest;
	}

	public void setUserTest(OnlineTest userTest) {
		this.userTest = userTest;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userTest="
				+ userTest + ", isAdmin=" + isAdmin + "]";
	}

	@Override
	public int hashCode() {
		return this.userId.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			return this.hashCode() == obj.hashCode();
		}
		return false;
	}

}
