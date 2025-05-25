package com.springboot_for_beginner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<customer,Integer> {
}
