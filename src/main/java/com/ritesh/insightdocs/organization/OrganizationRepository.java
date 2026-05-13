package com.ritesh.insightdocs.organization;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,UUID> {
        List<Organization> findByOwnerId(UUID ownerId);
        List<Organization> findByPlan(OrgPlan plan);
        boolean existsByName(String name);
} 