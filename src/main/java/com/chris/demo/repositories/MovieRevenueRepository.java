package com.chris.demo.repositories;

import com.chris.demo.entities.MovieRevenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRevenueRepository extends JpaRepository<MovieRevenue,Long> {
}
