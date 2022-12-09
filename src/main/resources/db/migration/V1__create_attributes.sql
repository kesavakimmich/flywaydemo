CREATE TABLE IF NOT EXISTS `attributes` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` varchar(20),
    `value` varchar(50),
    `is_active` tinyint
);