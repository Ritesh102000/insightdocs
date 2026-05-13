package com.ritesh.insightdocs.role;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,UUID> {

    List<Role> findByOrganizationId(UUID orgId);
    
}
