    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.entity;

/**
 *
 * @author USER
 */
public class UserEntity {
    private String userId;
    private String fullName;
    private String username;
    private String passwordHash;
    private String role;
    private String branchId;
    private boolean active;

    public UserEntity() {}

    public UserEntity(String userId, String fullName, String username, String passwordHash, String role, String branchId, boolean active) {
        this.userId = userId;
        this.fullName = fullName;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.branchId = branchId;
        this.active = active;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "userId=" + userId + ", fullName=" + fullName + ", username=" + username + ", passwordHash=" + passwordHash + ", role=" + role + ", branchId=" + branchId + ", active=" + active + '}';
    }
    
    
    
}
