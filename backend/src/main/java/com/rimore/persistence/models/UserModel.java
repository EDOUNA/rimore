package com.rimore.persistence.models;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserModel {

    public UserModel() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    public String name;

    @Column
    @Email
    @NotNull
    @NotBlank
    public String email;

    @Column(name = "email_verified_at")
    public Timestamp emailVerifiedAt;

    @Column(nullable = false, name = "created_at")
    public Timestamp createdAt;

    @Column(nullable = false, name = "updated_at")
    public Timestamp updatedAt;

    @Column(name = "agenda_password")
    @NotNull
    @NotEmpty
    private String password;

    @Column(nullable = true, name = "agenda_auth_token")
    public String authToken;

    public UserModel(long id, String name, String email, Timestamp emailVerifiedAt, Timestamp createdAt,
            Timestamp updatedAt, String password, String authToken) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.emailVerifiedAt = emailVerifiedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.password = password;
        this.authToken = authToken;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getEmailVerifiedAt() {
        return this.emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Timestamp emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public UserModel id(long id) {
        this.id = id;
        return this;
    }

    public UserModel name(String name) {
        this.name = name;
        return this;
    }

    public UserModel email(String email) {
        this.email = email;
        return this;
    }

    public UserModel emailVerifiedAt(Timestamp emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
        return this;
    }

    public UserModel createdAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UserModel updatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public UserModel password(String password) {
        this.password = password;
        return this;
    }

    public UserModel authToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return id == userModel.id && Objects.equals(name, userModel.name) && Objects.equals(email, userModel.email)
                && Objects.equals(emailVerifiedAt, userModel.emailVerifiedAt)
                && Objects.equals(createdAt, userModel.createdAt) && Objects.equals(updatedAt, userModel.updatedAt)
                && Objects.equals(password, userModel.password) && Objects.equals(authToken, userModel.authToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, emailVerifiedAt, createdAt, updatedAt, password, authToken);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", email='" + getEmail() + "'"
                + ", emailVerifiedAt='" + getEmailVerifiedAt() + "'" + ", createdAt='" + getCreatedAt() + "'"
                + ", updatedAt='" + getUpdatedAt() + "'" + ", password='" + getPassword() + "'" + ", authToken='"
                + getAuthToken() + "'" + "}";
    }
}