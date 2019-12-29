package com.springboottutorial.topic.api;

import com.springboottutorial.topic.model.Topic;
import com.springboottutorial.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/v1/topics")
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping(path = "{id}")
    public Topic getTopic(@PathVariable @NonNull String id) {
        return topicService.getTopicById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @PostMapping
    public void addTopic(@RequestBody @Valid @NonNull Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping(value = "{id}")
    public void updateTopic(@PathVariable @NonNull String id, @RequestBody @NonNull @Valid Topic topic) {
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping(value = "{id}")
    public void deleteTopic(@PathVariable @NonNull String id) {
        topicService.deleteTopic(id);
    }
}
