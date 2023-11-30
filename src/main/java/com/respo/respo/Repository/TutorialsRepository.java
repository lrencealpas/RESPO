package com.respo.respo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.respo.respo.Entity.TutorialsEntity;

@Repository
public interface TutorialsRepository extends JpaRepository<TutorialsEntity, Integer>{

}
