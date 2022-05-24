package com.axinalis.learningKuber.dao;

import com.axinalis.learningKuber.entity.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<NumberEntity, Long> {
}
