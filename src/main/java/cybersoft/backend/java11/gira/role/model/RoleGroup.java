package cybersoft.backend.java11.gira.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;

@Entity
@Table(name = "role_group")
public class RoleGroup extends AbstractEntity {
	@NotBlank(message = "Role name can't be blank")
	@Length(min = 4, max = 50, message = "Role name length is between {0} and {1}.")
	private String groupName;
	@NotBlank(message = "Role description can't be blank")
	private String description;
	
	// Quan hệ many to many
	// sử dụng S, không sử dụng List
	// không sử dụng cascade REMOVE và ALL
	// tạo bảng  join table ở dối tượng chính
	
	@JoinTable(name = "group_role_link", joinColumns = @JoinColumn(name = "group_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	@ManyToMany( cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Set<Role> roles = new HashSet<Role>();
	
	
	// Helper methods để đảm bảo dữ liệu luôn đc thống nhất các đối tượng
	
	public RoleGroup addRole(Role role) {
		this.roles.add(role);
		role.getGroups().add(this);
		return this;
	}
	
	public RoleGroup name(String name) {
		this.groupName = name;
		return this;
	}
	
	public RoleGroup description(String description) {
		this.description = description;
		return this;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
