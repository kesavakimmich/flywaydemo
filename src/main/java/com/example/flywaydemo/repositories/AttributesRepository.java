package com.example.flywaydemo.repositories;

import com.example.flywaydemo.models.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Integer> {
}
