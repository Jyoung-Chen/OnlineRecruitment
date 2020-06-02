package com.net.javatest;

public class testMap {
    private String name;
    private String path;
    public testMap(){
    }
    public testMap(String name,String path){
        this.name=name;
        this.path=path;
    }
    public String getName() {
        return name;
    }
    public String getPath() {
        return path;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "testMap{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
