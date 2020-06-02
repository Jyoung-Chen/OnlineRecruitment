package com.net.javabean;

public class Menu {
  private long menuId;
  private long parentId;
  private String menuName;
  private String menuPath;
  private String parentTitle;
  private String thisTitle;
  public Menu(){
    super();
  }

  public Menu(long menuId, long parentId, String menuName, String menuPath) {
    this.menuId = menuId;
    this.parentId = parentId;
    this.menuName = menuName;
    this.menuPath = menuPath;
  }

  public long getMenuId() {
    return menuId;
  }

  public void setMenuId(long menuId) {
    this.menuId = menuId;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }


  public String getMenuPath() {
    return menuPath;
  }

  public void setMenuPath(String menuPath) {
    this.menuPath = menuPath;
  }


  public String getParentTitle() { return parentTitle;  }

  public void setParentTitle(String parentTitle) { this.parentTitle = parentTitle; }


  public String getThisTitle() { return thisTitle; }

  public void setThisTitle(String thisTitle) { this.thisTitle = thisTitle; }


  @Override
  public String toString() {
    return "Menu{" +
            "menuId=" + menuId +
            ", parentId=" + parentId +
            ", menuName='" + menuName + '\'' +
            ", menuPath='" + menuPath + '\'' +
            ", thisTitle='" + thisTitle + '\'' +
            ", parentTitle='" + parentTitle + '\'' +
            '}';
  }
}
