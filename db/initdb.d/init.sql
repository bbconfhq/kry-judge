CREATE DATABASE kry
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
USE kry;

CREATE TABLE problem (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(191) NOT NULL,
    content TEXT NOT NULL,
    created DATETIME(6) NOT NULL,
    modified DATETIME(6) NOT NULL,
    input TEXT NOT NULL,
    output TEXT NOT NULL,
    note TEXT NOT NULL,
    time_limit DECIMAL(7, 5) NOT NULL,
    memory_limit INTEGER NOT NULL,
    submit_count INTEGER NOT NULL,
    accept_count INTEGER NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (title)
) ENGINE = InnoDB;

ALTER TABLE problem AUTO_INCREMENT = 1000;

CREATE TABLE testcase (
    id BIGINT NOT NULL AUTO_INCREMENT,
    visible BOOLEAN NOT NULL,
    input TEXT NOT NULL,
    output TEXT NOT NULL,
    problem_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (problem_id) REFERENCES problem (id)
) ENGINE = InnoDB;

CREATE TABLE tag (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(191) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE problem_tag (
    problem_id BIGINT NOT NULL,
    tag_id BIGINT NOT NULL,
    PRIMARY KEY (problem_id, tag_id),
    FOREIGN KEY (problem_id) REFERENCES problem (id),
    FOREIGN KEY (tag_id) REFERENCES tag (id)
) ENGINE = InnoDB;

CREATE TABLE `board` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(191) NOT NULL,
    `seq` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`name`),
    UNIQUE KEY (`seq`)
) ENGINE=INNODB;

CREATE TABLE `article` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `board_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `title` VARCHAR(191) NOT NULL,
    `content` MEDIUMTEXT NOT NULL,
    `created` datetime(6) NOT NULL,
    `modified` datetime(6) NOT NULL,
    `upvote` BIGINT NOT NULL,
    `downvote` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`board_id`) REFERENCES `board` (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=INNODB;

CREATE TABLE `comment` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `article_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `content` TEXT NOT NULL,
    `created` DATETIME(6) NOT NULL,
    `modified` DATETIME(6) NOT NULL,
    `upvote` BIGINT NOT NULL,
    `downvote` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=INNODB;

CREATE TABLE `article_vote` (
    `article_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `updown` TINYINT NOT NULL,
    PRIMARY KEY (`article_id`, `user_id`, `updown`),
    FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=INNODB;

CREATE TABLE `comment_vote` (
    `comment_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `updown` TINYINT NOT NULL,
    PRIMARY KEY (`comment_id`, `user_id`, `updown`),
    FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=INNODB;
