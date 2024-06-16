package com.jira.proassign.service;

import com.jira.proassign.domain.PlanType;
import com.jira.proassign.entity.Subscription;
import com.jira.proassign.entity.User;

public interface SubscriptionService {
    Subscription createSubscription(User user);
    Subscription getUserSubscription(Long userId) throws Exception;
    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}

