package com.example.flywaydemo.repositories;

import com.example.flywaydemo.models.AttributesGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesGroupRepository extends JpaRepository<AttributesGroup, Integer> {
}
