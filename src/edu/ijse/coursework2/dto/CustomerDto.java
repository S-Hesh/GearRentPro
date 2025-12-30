/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dto;

/**
 *
 * @author USER
 */
public class CustomerDto {
    private String customerId;
    private String fullName;
    private String nicPassport;  // Added nic_passport
    private String contactNo;
    private String email;
    private String address;
    private String membershipLevelCode;

    // Getters and setters for all fields

    public CustomerDto() {}

    public CustomerDto(String customerId, String fullName, String nicPassport, String contactNo, String email, String address, String membershipLevelCode) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.nicPassport = nicPassport;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
        this.membershipLevelCode = membershipLevelCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNicPassport() {
        return nicPassport;
    }

    public void setNicPassport(String nicPassport) {
        this.nicPassport = nicPassport;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMembershipLevelCode() {
        return membershipLevelCode;
    }

    public void setMembershipLevelCode(String membershipLevelCode) {
        this.membershipLevelCode = membershipLevelCode;
    }

    @Override
    public String toString() {
        return "CustomerDto{" + "customerId=" + customerId + ", fullName=" + fullName + ", nicPassport=" + nicPassport + ", contactNo=" + contactNo + ", email=" + email + ", address=" + address + ", membershipLevelCode=" + membershipLevelCode + '}';
    }

   
    
}
