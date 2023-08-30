package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblOrang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrangRepository extends JpaRepository<TblOrang,Long> {
}
