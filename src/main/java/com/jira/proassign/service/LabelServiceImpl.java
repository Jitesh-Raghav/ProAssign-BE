package com.jira.proassign.service;

import com.jira.proassign.entity.Label;
import com.jira.proassign.entity.User;
import com.jira.proassign.exception.LabelNotFoundException;
import com.jira.proassign.exception.UserException;
import com.jira.proassign.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private UserService userService;  // Assuming you have a UserService

    @Override
    public Label getOrCreateLabel(String labelName) {
        return labelRepository.findByName(labelName)
                .orElseGet(() -> {
                    Label label = new Label();
                    label.setName(labelName);
                    label.setCreationDate(LocalDateTime.now());
                    label.setUsageCount(0);
                    label.setVisible(true);
                    // Set other default values or associations
                    return labelRepository.save(label);
                });
    }

    @Override
    public Optional<Label> getLabelById(Long labelId) {
        return labelRepository.findById(labelId);
    }

    @Override
    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    @Override
    public List<Label> getLabelsCreatedByUser(Long userId) throws UserException {
        User user = userService.findUserById(userId);
        return labelRepository.findByCreator(user);
    }

    @Override
    public void updateLabel(Long labelId, Label updatedLabel) throws LabelNotFoundException {
        Label existingLabel = labelRepository.findById(labelId)
                .orElseThrow(() -> new LabelNotFoundException("Label not found with id: " + labelId));

        // Update the fields as needed
        existingLabel.setName(updatedLabel.getName());
        existingLabel.setColor(updatedLabel.getColor());
        existingLabel.setDescription(updatedLabel.getDescription());
        existingLabel.setUsageCount(updatedLabel.getUsageCount());
        existingLabel.setVisible(updatedLabel.isVisible());

        labelRepository.save(existingLabel);
    }

    @Override
    public void deleteLabel(Long labelId) {
        labelRepository.deleteById(labelId);
    }


}


