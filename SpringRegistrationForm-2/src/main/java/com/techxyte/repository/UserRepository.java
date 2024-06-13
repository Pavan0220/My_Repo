package com.techxyte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techxyte.entity.Employee;

public interface UserRepository extends JpaRepository<Employee, Long> {
Employee findByEmail(String email);
}
