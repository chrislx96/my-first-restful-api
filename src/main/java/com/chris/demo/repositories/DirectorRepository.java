package com.chris.demo.repositories;

import com.chris.demo.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director,Long> {
}
