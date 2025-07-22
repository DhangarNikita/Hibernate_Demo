package com.first;

import jakarta.persistence.Embeddable;

@Embeddable
public class Certificate {

    private String cource;
    private int duration;

    public Certificate() {
        super();
    }

    public Certificate(int duration, String cource) {
        this.duration = duration;
        this.cource = cource;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
