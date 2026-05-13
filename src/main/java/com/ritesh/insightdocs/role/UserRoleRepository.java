package com.ritesh.insightdocs.role;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,UUID> {
    List<UserRole> findByUserIdAndOrgId(UUID userId, UUID orgId);
    boolean existsByUserIdAndRoleId(UUID userId, UUID roleId);
}
