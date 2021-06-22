package cybersoft.backend.java11.gira.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;
import cybersoft.backend.java11.gira.user.model.User;

@Entity
public class RoleGroup extends AbstractEntity {
	@NotBlank(message = "Role name can't be blank.")
	@Length(min = 4, max = 50, message = "Role name length is between {0} and {1}.")
	private String groupName;
	
	@NotBlank(message = "Role description can't be blank.")
	private String description;
	
	/*
	 * Quan hệ Many to Many
	 * - sử dụng Set, không sử dụng List
	 * - không sử dụng cascade REMOVE và ALL
	 * - tạo bảng join table ở đối tượng chính
	 */
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "group_role_link",
				joinColumns = @JoinColumn(name = "group_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "gira_role-group_user_link", 
				joinColumns = @JoinColumn(name = "group_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();
	
	/*
	 * Helper methods
	 * để đảm bảo dữ liệu luôn được thống nhất giữa các đối tượng
	 * 
	 */
	public RoleGroup addRole(Role role) {
		this.roles.add(role);
		role.getGroups().add(this);
		return this;
	}
	
	public RoleGroup removeRole(Role role) {
		System.out.println("Role Group: " + this.getRoles());
		System.out.println("Role: " + role);
		System.out.println("listRole before: " + roles);
		try {
			this.roles.remove(role);
			role.getGroups().remove(this);
			System.out.println("listRole Remove: " + this.roles);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	
	 public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof RoleGroup)) return false;
	        return id != null && id.equals(((RoleGroup) o).getId());
	    }
	 
	    @Override
	    public int hashCode() {
	        return getClass().hashCode();
	    }
	
}
