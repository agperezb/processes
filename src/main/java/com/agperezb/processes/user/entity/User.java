package com.agperezb.processes.user.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    private UUID Userid;

    @Column(name = "user_name")
    private String UserName;

    @Column(name = "user_document_number")
    private String UserDocumentNumber;

    @Column(name = "user_lastname")
    private String UserLastname;

    @Column(name = "user_direction")
    private String UserDirection;

    @Column(name = "user_birthdate")
    private LocalDate UserBirthdate;

    @Column(name = "user_phone")
    private String UserPhone;

    public UUID getUserid() {
        return Userid;
    }

    public void setUserid(UUID userid) {
        Userid = userid;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserDocumentNumber() {
        return UserDocumentNumber;
    }

    public void setUserDocumentNumber(String userDocumentNumber) {
        UserDocumentNumber = userDocumentNumber;
    }

    public String getUserLastname() {
        return UserLastname;
    }

    public void setUserLastname(String userLastname) {
        UserLastname = userLastname;
    }

    public String getUserDirection() {
        return UserDirection;
    }

    public void setUserDirection(String userDirection) {
        UserDirection = userDirection;
    }

    public LocalDate getUserBirthdate() {
        return UserBirthdate;
    }

    public void setUserBirthdate(LocalDate userBirthdate) {
        UserBirthdate = userBirthdate;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }
}
