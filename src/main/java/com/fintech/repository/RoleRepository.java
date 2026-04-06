package com.fintech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fintech.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
