package com.net.javabean;
public class Enterprises {

  private int enterpriseId;
  private String enterpriseName;
  private String enterpriseMessage;
  private String enterpriseAddress;
  private String enterprisePhone;
  private String enterprisePassword;
  private String enterpriseExplain1;
  private String enterpriseExplain2;
  private int enterpriseStatus;

  public Enterprises(){
    super();
  }

  public Enterprises(int enterpriseId, String enterpriseName, String enterpriseMessage, String enterpriseAddress, String enterprisePhone, String enterprisePassword, String enterpriseExplain1, String enterpriseExplain2, int enterpriseStatus) {
    this.enterpriseId = enterpriseId;
    this.enterpriseName = enterpriseName;
    this.enterpriseMessage = enterpriseMessage;
    this.enterpriseAddress = enterpriseAddress;
    this.enterprisePhone = enterprisePhone;
    this.enterprisePassword = enterprisePassword;
    this.enterpriseExplain1 = enterpriseExplain1;
    this.enterpriseExplain2 = enterpriseExplain2;
    this.enterpriseStatus = enterpriseStatus;
  }

  public int getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(int enterpriseId) {
    this.enterpriseId = enterpriseId;
  }


  public String getEnterpriseName() {
    return enterpriseName;
  }

  public void setEnterpriseName(String enterpriseName) {
    this.enterpriseName = enterpriseName;
  }


  public String getEnterpriseMessage() {
    return enterpriseMessage;
  }

  public void setEnterpriseMessage(String enterpriseMessage) {
    this.enterpriseMessage = enterpriseMessage;
  }


  public String getEnterpriseAddress() {
    return enterpriseAddress;
  }

  public void setEnterpriseAddress(String enterpriseAddress) {
    this.enterpriseAddress = enterpriseAddress;
  }


  public String getEnterprisePhone() {
    return enterprisePhone;
  }

  public void setEnterprisePhone(String enterprisePhone) {
    this.enterprisePhone = enterprisePhone;
  }


  public String getEnterprisePassword() {
    return enterprisePassword;
  }

  public void setEnterprisePassword(String enterprisePassword) {
    this.enterprisePassword = enterprisePassword;
  }


  public String getEnterpriseExplain1() {
    return enterpriseExplain1;
  }

  public void setEnterpriseExplain1(String enterpriseExplain1) {
    this.enterpriseExplain1 = enterpriseExplain1;
  }


  public String getEnterpriseExplain2() {
    return enterpriseExplain2;
  }

  public void setEnterpriseExplain2(String enterpriseExplain2) {
    this.enterpriseExplain2 = enterpriseExplain2;
  }


  public int getEnterpriseStatus() {
    return enterpriseStatus;
  }

  public void setEnterpriseStatus(int enterpriseStatus) {
    this.enterpriseStatus = enterpriseStatus;
  }

  @Override
  public String toString() {
    return "Enterprises{" +
            "enterpriseId=" + enterpriseId +
            ", enterpriseName='" + enterpriseName + '\'' +
            ", enterpriseMessage='" + enterpriseMessage + '\'' +
            ", enterpriseAddress='" + enterpriseAddress + '\'' +
            ", enterprisePhone='" + enterprisePhone + '\'' +
            ", enterprisePassword='" + enterprisePassword + '\'' +
            ", enterpriseExplain1='" + enterpriseExplain1 + '\'' +
            ", enterpriseExplain2='" + enterpriseExplain2 + '\'' +
            ", enterpriseStatus=" + enterpriseStatus +
            '}';
  }
}
