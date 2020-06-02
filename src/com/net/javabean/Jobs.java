package com.net.javabean;


public class Jobs {

  private int jobId;
  private int enterpriseId;
  private int jobTypeId;
  private String jobName;
  private String jobDescription;
  private String jobDemand;
  private String jobSalary;
  private String jobExplain1;
  private String jobExplain2;
  private int jobHot;
  private int jobStatus;
  public Jobs(){
    super();
  }
  public Jobs(int jobId, int enterpriseId, int jobTypeId, String jobName, String jobDescription, String jobDemand, String jobSalary, String jobExplain1, String jobExplain2, int jobHot, int jobStatus) {
    this.jobId = jobId;
    this.enterpriseId = enterpriseId;
    this.jobTypeId = jobTypeId;
    this.jobName = jobName;
    this.jobDescription = jobDescription;
    this.jobDemand = jobDemand;
    this.jobSalary = jobSalary;
    this.jobExplain1 = jobExplain1;
    this.jobExplain2 = jobExplain2;
    this.jobHot = jobHot;
    this.jobStatus = jobStatus;
  }

  public int getJobId() {
    return jobId;
  }

  public void setJobId(int jobId) {
    this.jobId = jobId;
  }


  public int getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(int enterpriseId) {
    this.enterpriseId = enterpriseId;
  }


  public int getJobTypeId() {
    return jobTypeId;
  }

  public void setJobTypeId(int jobTypeId) {
    this.jobTypeId = jobTypeId;
  }


  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }


  public String getJobDescription() {
    return jobDescription;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }


  public String getJobDemand() {
    return jobDemand;
  }

  public void setJobDemand(String jobDemand) {
    this.jobDemand = jobDemand;
  }


  public String getJobSalary() {
    return jobSalary;
  }

  public void setJobSalary(String jobSalary) {
    this.jobSalary = jobSalary;
  }


  public String getJobExplain1() {
    return jobExplain1;
  }

  public void setJobExplain1(String jobExplain1) {
    this.jobExplain1 = jobExplain1;
  }


  public String getJobExplain2() {
    return jobExplain2;
  }

  public void setJobExplain2(String jobExplain2) {
    this.jobExplain2 = jobExplain2;
  }


  public int getJobHot() {
    return jobHot;
  }

  public void setJobHot(int jobHot) {
    this.jobHot = jobHot;
  }


  public int getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(int jobStatus) {
    this.jobStatus = jobStatus;
  }

  @Override
  public String toString() {
    return "Jobs{" +
            "jobId=" + jobId +
            ", enterpriseId=" + enterpriseId +
            ", jobTypeId=" + jobTypeId +
            ", jobName='" + jobName + '\'' +
            ", jobDescription='" + jobDescription + '\'' +
            ", jobDemand='" + jobDemand + '\'' +
            ", jobSalary='" + jobSalary + '\'' +
            ", jobExplain1='" + jobExplain1 + '\'' +
            ", jobExplain2='" + jobExplain2 + '\'' +
            ", jobHot=" + jobHot +
            ", jobStatus=" + jobStatus +
            '}';
  }
}
