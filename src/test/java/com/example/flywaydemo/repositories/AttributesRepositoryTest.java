package com.example.flywaydemo.repositories;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttributesRepositoryTest {

    @Autowired
    private AttributesRepository attributesRepository;

    @Test
    void testInjection(){
        assertNotNull(attributesRepository);
    }

    @Test
    void testRead(){
        final var attributes = attributesRepository.findById(1);
        assertTrue(attributes.isPresent());
        final var attribute = attributes.get();
        log.info(String.valueOf(attribute.getTitle()));
    }
}
