package com.respo.respo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.respo.respo.Entity.RespoEntity;

@Repository
public interface RespoRepository extends JpaRepository<RespoEntity, Integer>{

}
