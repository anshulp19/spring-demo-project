package com.springboottutorial.topic.service;

import com.springboottutorial.topic.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
}
