package com.raducatalinahomework6.raducatalinahomework6.repository;

import com.raducatalinahomework6.raducatalinahomework6.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAll();
    Visit getById(Integer id);
}
