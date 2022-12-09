package com.example.flywaydemo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttributesGroupRepositoryTest {

    @Autowired
    private AttributesGroupRepository attributesGroupRepository;

    @Test
    void testRead() {
        final var attributesGroup = attributesGroupRepository.findById(1);
        assertTrue(attributesGroup.isPresent());
    }
}
