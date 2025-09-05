package com.vt.virtual.controller;

import com.vt.virtual.model.TaskDetail;
import com.vt.virtual.service.TaskDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskDetailService taskDetailService;

    @Autowired
    public TaskController(TaskDetailService taskDetailService) {
        this.taskDetailService = taskDetailService;
    }

    @GetMapping("getAllTasks")
    public List<TaskDetail> getAllTasks() {
        return taskDetailService.getAllCountries();
    }
}
