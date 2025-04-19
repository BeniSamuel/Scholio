package com.rcamis.smis.repository;

import com.rcamis.smis.model.Project;
import com.rcamis.smis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Optional<Project> getProjectById (int id);
    Optional<Project> getProjectByUser (User user);
    Optional<List<Project>> getProjectsByUser (User user);
}
