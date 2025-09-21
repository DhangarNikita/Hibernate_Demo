package com.manytomany;


import javax.persistence.*;
import java.util.List;

@Entity
public class Emp {
    @Id
    private int eid;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "emp_learn",
            joinColumns = {@JoinColumn(name = "eid")},
            inverseJoinColumns = {@JoinColumn(name = "pid")}
    )
    private List<Project> project;

    public Emp() {

    }

    public Emp(int eid, String name, List<Project> project) {
        this.eid = eid;
        this.name = name;
        this.project = project;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
}
