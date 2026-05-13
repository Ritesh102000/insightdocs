package com.ritesh.insightdocs.role;

import java.util.UUID;

import com.ritesh.insightdocs.organization.Organization;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "roles")
public class Role {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization; 

    @Column(nullable = false,unique = false,length = 100)
    private String roleName;
    
    @Column(nullable = false)
    private long perm;

    @Column(nullable = false)
    private boolean isDefaultRole;

    @Column(nullable = false)
    private boolean isSystemRole;

    @Column(nullable = false)
    private int position;

}
