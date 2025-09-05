package com.vt.virtual.repository;

import com.vt.virtual.model.TaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskDetail, Long> {

}
