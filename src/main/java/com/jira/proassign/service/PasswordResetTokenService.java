package com.jira.proassign.service;

import com.jira.proassign.entity.PasswordResetToken;

public interface PasswordResetTokenService {

    public PasswordResetToken findByToken(String token);

    public void delete(PasswordResetToken resetToken);

}
