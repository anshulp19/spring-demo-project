package com.springboottutorial.course.model;

import com.springboottutorial.topic.model.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

    @Id
    private String id;
    private String name;
    private String descriptipn;

    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(String id, String name, String descriptipn, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.descriptipn = descriptipn;
        this.topic = new Topic(topicId, "", "");
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
