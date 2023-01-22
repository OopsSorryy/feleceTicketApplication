package com.felece.ticketapplication.repository;

import com.felece.ticketapplication.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
