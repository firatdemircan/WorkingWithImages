package com.tmo.repository;

import com.tmo.entity.SoruEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoruRepo extends JpaRepository<SoruEntity,Long> {
}
