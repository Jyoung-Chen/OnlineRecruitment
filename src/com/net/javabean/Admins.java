package com.net.javabean;


public class Admins {

  private long adminId;
  private String adminNumber;
  private String adminPassword;
  private long adminStatus;

  public Admins(){
    super();
  }

  public Admins(long adminId, String adminNumber, String adminPassword, long adminStatus) {
    this.adminId = adminId;
    this.adminNumber = adminNumber;
    this.adminPassword = adminPassword;
    this.adminStatus = adminStatus;
  }

  public long getAdminId() {
    return adminId;
  }

  public void setAdminId(long adminId) {
    this.adminId = adminId;
  }


  public String getAdminNumber() {
    return adminNumber;
  }

  public void setAdminNumber(String adminNumber) {
    this.adminNumber = adminNumber;
  }


  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }


  public long getAdminStatus() {
    return adminStatus;
  }

  public void setAdminStatus(long adminStatus) {
    this.adminStatus = adminStatus;
  }

  @Override
  public String toString() {
    return "Administrators{" +
            "adminId=" + adminId +
            ", adminNumber='" + adminNumber + '\'' +
            ", adminPassword='" + adminPassword + '\'' +
            ", adminStatus=" + adminStatus +
            '}';
  }
}
