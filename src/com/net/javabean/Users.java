package com.net.javabean;


public class Users {

  private int userId;
  private String userNumber;
  private String userPassword;
  private int userStatus;
  public Users(){
    super();
  }
  public Users(int userId, String userNumber, String userPassword, int userStatus) {
    this.userId = userId;
    this.userNumber = userNumber;
    this.userPassword = userPassword;
    this.userStatus = userStatus;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public String getUserNumber() {
    return userNumber;
  }

  public void setUserNumber(String userNumber) {
    this.userNumber = userNumber;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public int getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(int userStatus) {
    this.userStatus = userStatus;
  }

  @Override
  public String toString() {
    return "Users{" +
            "userId=" + userId +
            ", userNumber='" + userNumber + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userStatus=" + userStatus +
            '}';
  }
}
