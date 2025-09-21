package com.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    @Column(name="project_name")
    private String projectName;
    @ManyToMany(mappedBy = "project")
    private List<Emp> emp;

    public Project(int pid, String projectName, List<Emp> emp) {
        this.pid = pid;
        this.projectName = projectName;
        this.emp = emp;
    }

    public Project(){

    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmp() {
        return emp;
    }

    public void setEmp(List<Emp> emp) {
        this.emp = emp;
    }
}
