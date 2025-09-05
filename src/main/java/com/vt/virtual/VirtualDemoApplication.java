package com.vt.virtual;

import com.vt.virtual.model.TaskDetail;
import com.vt.virtual.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.config.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaRepositories
public class VirtualDemoApplication implements CommandLineRunner {
    @Autowired
    TaskRepository taskRepository;

    private static final Logger logger = LoggerFactory.getLogger(VirtualDemoApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(VirtualDemoApplication.class, args);
    }


    public static List<TaskDetail> readTasks() throws IOException {
        String currentPath = System.getProperty("user.dir");
        logger.info("Current working directory: " + currentPath);
        String filePath = currentPath + File.separator + "Sample.csv";
        logger.info("Current working filePath: " + filePath);
        return Files.lines(Paths.get(filePath))
                .skip(1) // Skip header
                .map(line -> line.split(";"))
                .map(fields -> {
                    return TaskDetail.builder()
                            .sharedDate(getField(fields, 0))
                            .jobDescription(getField(fields, 1))
                            .accountName(getField(fields, 2))
                            .taskName(getField(fields, 3))
                            .taskCity(getField(fields, 4))
                            .taskCode(getField(fields, 5))
                            .taskStartDate(getField(fields, 6))
                            .taskEndDate(getField(fields, 7))
                            .taskSkills(getField(fields, 8))
                            .taskFulfillmentStep(getField(fields, 9))
                            .build();
                })
                .collect(Collectors.toList());
    }


    private static String getField(String[] fields, int index) {
        return index < fields.length ? fields[index].trim() : "";
    }


    @Override
    public void run(String... args) throws Exception {

        List<TaskDetail> tasks = readTasks();
        taskRepository.saveAll(tasks);
    }
}



