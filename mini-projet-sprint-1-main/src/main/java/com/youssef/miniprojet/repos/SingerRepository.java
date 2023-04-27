package com.youssef.miniprojet.repos;

import com.youssef.miniprojet.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> {
}
