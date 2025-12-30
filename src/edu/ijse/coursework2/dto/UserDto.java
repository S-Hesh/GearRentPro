/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dto;

/**
 *
 * @author USER
 */
public class UserDto {
    private String userId;
    private String fullName;
    private String role;
    private String branchId;

    public UserDto() {}

    public UserDto(String userId, String fullName, String role, String branchId) {
        this.userId = userId;
        this.fullName = fullName;
        this.role = role;
        this.branchId = branchId;
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

    @Override
    public String toString() {
        return "UserDto{" + "userId=" + userId + ", fullName=" + fullName + ", role=" + role + ", branchId=" + branchId + '}';
    }
    
    
    
}
