package com.nuri.bikesolution.repository;

import com.nuri.bikesolution.model.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Integer> {
}
