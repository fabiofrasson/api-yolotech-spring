package com.yolotech.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yolotech.api.entities.enums.AccRole;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String fullName;
  private String title;
  private String contato;
  private String username;
  private String bio;
  private String github;
  private String linkedIn;
  private String passwd;
  private Integer accRole;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
      timezone = "GMT")
  private Instant regDate;

  private boolean isActive;

  public Account() {}

  public Account(
      Long id,
      String fullName,
      String title,
      String contato,
      String username,
      String bio,
      String github,
      String linkedIn,
      String passwd,
      AccRole accRole,
      Instant regDate,
      boolean isActive) {
    this.id = id;
    this.fullName = fullName;
    this.title = title;
    this.contato = contato;
    this.username = username;
    this.bio = bio;
    this.github = github;
    this.linkedIn = linkedIn;
    this.passwd = passwd;
    setAccRole(accRole);
    this.regDate = regDate;
    this.isActive = isActive;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContato() {
    return contato;
  }

  public void setContato(String contato) {
    this.contato = contato;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getGithub() {
    return github;
  }

  public void setGithub(String github) {
    this.github = github;
  }

  public String getLinkedIn() {
    return linkedIn;
  }

  public void setLinkedIn(String linkedIn) {
    this.linkedIn = linkedIn;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public AccRole getAccRole() {
    return AccRole.valueOf(accRole);
  }

  public void setAccRole(AccRole accRole) {
    if (accRole != null) {
      this.accRole = accRole.getCode();
    }
  }

  public Instant getRegDate() {
    return regDate;
  }

  public void setRegDate(Instant regDate) {
    this.regDate = regDate;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }
}
