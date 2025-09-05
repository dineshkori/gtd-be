package com.vt.virtual.service;

import com.vt.virtual.model.TaskDetail;
import com.vt.virtual.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskDetailService {
    private static final Logger logger = LoggerFactory.getLogger(TaskDetailService.class);
    private final TaskRepository taskRepository;

    @Autowired
    public TaskDetailService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDetail> getAllCountries() {
        List<TaskDetail> countries = taskRepository.findAll();
        List<TaskDetail> sortedCountries = countries.stream()
              //  .sorted(Comparator.comparing(TaskDetail::getSharedDate))
                .collect(Collectors.toList());
        return sortedCountries;
    }
}
