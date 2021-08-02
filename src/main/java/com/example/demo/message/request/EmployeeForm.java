package com.example.demo.message.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class EmployeeForm {
    @NotBlank
    @Size(min = 3, max = 255)
    String firstname, lastname, middlename;

    @NotBlank
    @Size(min = 3, max = 255)
    String userName;

    @NotBlank
    @Size(min = 3, max = 255)
    String password;

    @NotBlank
    @Size(min = 3, max = 255)
    String role;


    @NotBlank
    Date dob;

    @NotBlank
    boolean gender;

    @NotBlank
    String phone;

    @NotBlank
    @Email
    String email;

    @NotBlank
    String address;

    @NotBlank
    String education;

    @NotBlank
    String school;

    @NotBlank
    String faculty;

    @NotBlank
    String course;

    @NotBlank
    Date timejoin;

    @NotBlank
    boolean status;

    @NotBlank
    String type;

    @NotBlank
    String personalID;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public EmployeeForm(String userName) {
        this.userName = userName;
    }

    public EmployeeForm() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getTimejoin() {
        return timejoin;
    }

    public void setTimejoin(Date timejoin) {
        this.timejoin = timejoin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }
}
