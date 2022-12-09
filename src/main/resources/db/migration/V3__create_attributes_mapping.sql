CREATE TABLE IF NOT EXISTS `attributes_mapping` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` varchar(20),
    `is_active` tinyint,
    `attribute_id` int,
    `attribute_group_id` int,
    CONSTRAINT `fk_attribute_mapping` FOREIGN KEY (attribute_id) REFERENCES attributes(id),
    CONSTRAINT `fk_attribute_group_mapping` FOREIGN KEY (attribute_group_id) REFERENCES attributes_group(id)
);