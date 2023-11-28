package com.respo.respo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.respo.respo.Entity.LocalDepartmentsEntity;

@Repository
public interface LocalDepartmentsRepository extends JpaRepository<LocalDepartmentsEntity, Integer> {

}
