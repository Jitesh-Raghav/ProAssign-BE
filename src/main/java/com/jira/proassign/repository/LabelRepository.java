package com.jira.proassign.repository;

import com.jira.proassign.entity.Label;
import com.jira.proassign.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LabelRepository extends JpaRepository<Label, Long> {
    Optional<Label> findByName(String labelName);

    List<Label> findByCreator(User user);
//    Optional<Label> findByName(String name);
//    List<Label> findByCreator(User creator);
}