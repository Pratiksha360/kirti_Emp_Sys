package com.becoder.employee.model;

public class TaskInfo {
    private String nameTask;
    private String descTask;
    private String status;
    public TaskInfo(){

    }
    public TaskInfo(String nameTask, String descTask, String status) {
        this.nameTask = nameTask;
        this.descTask = descTask;
        this.status = status;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescTask() {
        return descTask;
    }

    public void setDescTask(String descTask) {
        this.descTask = descTask;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}