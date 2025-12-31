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
    private String username;     // New
    private String password;     // New (for handling edits)
    private String email;        // New
    private String role;
    private String branchId;
    private boolean active;      // New

    public UserDto() { }

    // --- EXISTING CONSTRUCTOR (Keeps Login Working) ---
    public UserDto(String userId, String fullName, String role, String branchId) {
        this.userId = userId;
        this.fullName = fullName;
        this.role = role;
        this.branchId = branchId;
        this.active = true; // Default to true for login success objects
    }

    // --- NEW CONSTRUCTOR (For User Management Table/Save) ---
    public UserDto(String userId, String fullName, String username, String password, String email, String role, String branchId, boolean active) {
        this.userId = userId;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.branchId = branchId;
        this.active = active;
    }

    // --- GETTERS & SETTERS (Add missing ones) ---
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getBranchId() { return branchId; }
    public void setBranchId(String branchId) { this.branchId = branchId; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    
    @Override
    public String toString() {
        return "UserDto{" + "userId=" + userId + ", role=" + role + '}';
    }
}