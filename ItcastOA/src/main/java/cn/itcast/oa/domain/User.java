package cn.itcast.oa.domain;

import java.util.Set;

/**
 * Created by lkk on 2014/11/5.
 */
public class User {
    private Long id;
    private String loginName;
    private String password;
    private String name;
    private String gender;
    private String phoneNumber;
    private String email;
    private String description;
    private Department department;
    private Set<Role> roles;

    public boolean findPrivilegeByName(String name) {
        if (getLoginName().equals("admin"))
            return true;
        for (Role role : getRoles()) {
            for (Privilege privilege : role.getPrivileges()) {
                if (privilege.getName().equals(name))
                    return true;
            }
        }
        return false;
    }

    public boolean findPrivilegeByUrl(String url) {
        if (getLoginName().equals("admin"))
            return true;
        for (Role role : getRoles()) {
            for (Privilege privilege : role.getPrivileges()) {
                if (url.equals(privilege.getUrl()))
                    return true;
            }
        }
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
