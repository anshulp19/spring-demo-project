package com.springboottutorial.topic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

    @Id
    private String id;
    private String name;
    private String descriptipn;

    public Topic() {
    }

    public Topic(String id, String name, String descriptipn) {
        this.id = id;
        this.name = name;
        this.descriptipn = descriptipn;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesscriptipn() {
        return descriptipn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesscriptipn(String descriptipn) {
        this.descriptipn = descriptipn;
    }
}
