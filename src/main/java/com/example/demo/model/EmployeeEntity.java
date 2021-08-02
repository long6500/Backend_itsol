package com.example.demo.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE", schema = "ITSOL")
public class EmployeeEntity {
    private long id;
    private String firstname;
    private String lastname;
    private String middlename;
    private String userName;
    private String password;
    private String role;
    private Date dob;
    private Boolean gender;
    private String phone;
    private String email;
    private String type;
    private String personalid;
    private String address;
    private String education;
    private String school;
    private String faculty;
    private String course;
    private Date timejoin;
    private Boolean status;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIRSTNAME", nullable = true, length = 50)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "LASTNAME", nullable = true, length = 50)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "MIDDLENAME", nullable = true, length = 50)
    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ROLE", nullable = true, length = 50)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "DOB", nullable = true)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "GENDER", nullable = true, precision = 0)
    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "TYPE", nullable = true, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "PERSONALID", nullable = true, length = 50)
    public String getPersonalid() {
        return personalid;
    }

    public void setPersonalid(String personalid) {
        this.personalid = personalid;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "EDUCATION", nullable = true, length = 50)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "SCHOOL", nullable = true, length = 50)
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "FACULTY", nullable = true, length = 50)
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Basic
    @Column(name = "COURSE", nullable = true, length = 10)
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Basic
    @Column(name = "TIMEJOIN", nullable = true)
    public Date getTimejoin() {
        return timejoin;
    }

    public void setTimejoin(Date timejoin) {
        this.timejoin = timejoin;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public EmployeeEntity() {
    }

    public EmployeeEntity(String firstname, String lastname, String middlename, String userName, String password, String role, Date dob, Boolean gender, String phone, String email, String type, String personalid, String address, String education, String school, String faculty, String course, Date timejoin, Boolean status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.personalid = personalid;
        this.address = address;
        this.education = education;
        this.school = school;
        this.faculty = faculty;
        this.course = course;
        this.timejoin = timejoin;
        this.status = status;
    }
}
