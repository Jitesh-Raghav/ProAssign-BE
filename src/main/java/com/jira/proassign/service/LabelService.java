package com.jira.proassign.service;

import com.jira.proassign.entity.Label;
import com.jira.proassign.exception.LabelNotFoundException;
import com.jira.proassign.exception.UserException;

import java.util.List;
import java.util.Optional;

public interface LabelService {

    Label getOrCreateLabel(String labelName);

    Optional<Label> getLabelById(Long labelId);

    List<Label> getAllLabels();

    List<Label> getLabelsCreatedByUser(Long userId) throws UserException;

    void updateLabel(Long labelId, Label updatedLabel) throws LabelNotFoundException;

    void deleteLabel(Long labelId);
}
