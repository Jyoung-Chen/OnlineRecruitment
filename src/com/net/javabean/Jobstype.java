package com.net.javabean;


public class Jobstype {

  private int jobTypeId;
  private String jobTypeName;

  public Jobstype(){
    super();
  }

  public Jobstype(int jobTypeId, String jobTypeName) {
    this.jobTypeId = jobTypeId;
    this.jobTypeName = jobTypeName;
  }

  public int getJobTypeId() {
    return jobTypeId;
  }

  public void setJobTypeId(int jobTypeId) {
    this.jobTypeId = jobTypeId;
  }


  public String getJobTypeName() {
    return jobTypeName;
  }

  public void setJobTypeName(String jobTypeName) {
    this.jobTypeName = jobTypeName;
  }

  @Override
  public String toString() {
    return "Jobstype{" +
            "jobTypeId=" + jobTypeId +
            ", jobTypeName='" + jobTypeName + '\'' +
            '}';
  }
}
