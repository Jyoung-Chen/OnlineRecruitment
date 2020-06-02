package com.net.javabean;

public class Resumes {

  private int resumeId;
  private int userId;
  private String resumeName;
  private int resumeSex;
  private String resumeAddress;
  private String resumePhone;
  private String graduateInstitutions;
  private String profession;
  private String workExperience;
  private String careerObjective;
  private String resumeExplain1;
  private String resumeExplain2;
  private int resumeStatus;
  public Resumes(){
    super();
  }

  public Resumes(int resumeId, int userId, String resumeName, int resumeSex, String resumeAddress, String resumePhone, String graduateInstitutions, String profession, String workExperience, String careerObjective, String resumeExplain1, String resumeExplain2, int resumeStatus) {
    this.resumeId = resumeId;
    this.userId = userId;
    this.resumeName = resumeName;
    this.resumeSex = resumeSex;
    this.resumeAddress = resumeAddress;
    this.resumePhone = resumePhone;
    this.graduateInstitutions = graduateInstitutions;
    this.profession = profession;
    this.workExperience = workExperience;
    this.careerObjective = careerObjective;
    this.resumeExplain1 = resumeExplain1;
    this.resumeExplain2 = resumeExplain2;
    this.resumeStatus = resumeStatus;
  }

  public int getResumeId() {
    return resumeId;
  }

  public void setResumeId(int resumeId) {
    this.resumeId = resumeId;
  }


  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public String getResumeName() {
    return resumeName;
  }

  public void setResumeName(String resumeName) {
    this.resumeName = resumeName;
  }


  public int getResumeSex() {
    return resumeSex;
  }

  public void setResumeSex(int resumeSex) {
    this.resumeSex = resumeSex;
  }


  public String getResumeAddress() {
    return resumeAddress;
  }

  public void setResumeAddress(String resumeAddress) {
    this.resumeAddress = resumeAddress;
  }


  public String getResumePhone() {
    return resumePhone;
  }

  public void setResumePhone(String resumePhone) {
    this.resumePhone = resumePhone;
  }


  public String getGraduateInstitutions() {
    return graduateInstitutions;
  }

  public void setGraduateInstitutions(String graduateInstitutions) {
    this.graduateInstitutions = graduateInstitutions;
  }


  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }


  public String getWorkExperience() {
    return workExperience;
  }

  public void setWorkExperience(String workExperience) {
    this.workExperience = workExperience;
  }


  public String getCareerObjective() {
    return careerObjective;
  }

  public void setCareerObjective(String careerObjective) {
    this.careerObjective = careerObjective;
  }


  public String getResumeExplain1() {
    return resumeExplain1;
  }

  public void setResumeExplain1(String resumeExplain1) {
    this.resumeExplain1 = resumeExplain1;
  }


  public String getResumeExplain2() {
    return resumeExplain2;
  }

  public void setResumeExplain2(String resumeExplain2) {
    this.resumeExplain2 = resumeExplain2;
  }


  public int getResumeStatus() {
    return resumeStatus;
  }

  public void setResumeStatus(int resumeStatus) {
    this.resumeStatus = resumeStatus;
  }

  @Override
  public String toString() {
    return "Resumes{" +
            "resumeId=" + resumeId +
            ", userId=" + userId +
            ", resumeName='" + resumeName + '\'' +
            ", resumeSex=" + resumeSex +
            ", resumeAddress='" + resumeAddress + '\'' +
            ", resumePhone=" + resumePhone +
            ", graduateInstitutions='" + graduateInstitutions + '\'' +
            ", profession='" + profession + '\'' +
            ", workExperience='" + workExperience + '\'' +
            ", careerObjective='" + careerObjective + '\'' +
            ", resumeExplain1='" + resumeExplain1 + '\'' +
            ", resumeExplain2='" + resumeExplain2 + '\'' +
            ", resumeStatus=" + resumeStatus +
            '}';
  }
}
