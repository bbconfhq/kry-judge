CREATE DATABASE kry
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
USE kry;

CREATE TABLE problem (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(191) NOT NULL DEFAULT "",
    content TEXT NOT NULL DEFAULT "",
    created DATETIME(6) NOT NULL DEFAULT NOW(),
    modified DATETIME(6) NOT NULL DEFAULT NOW(),
    input TEXT NOT NULL DEFAULT "",
    output TEXT NOT NULL DEFAULT "",
    note TEXT NOT NULL DEFAULT "",
    time_limit DECIMAL(7, 5) NOT NULL DEFAULT 1.0,
    memory_limit INTEGER NOT NULL DEFAULT 128,
    submit_count INTEGER NOT NULL DEFAULT 0,
    accept_count INTEGER NOT NULL DEFAULT 0,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT UNIQUE KEY (title)
) ENGINE = InnoDB;

ALTER TABLE problem AUTO_INCREMENT = 1000;

CREATE TABLE testcase (
    id BIGINT NOT NULL AUTO_INCREMENT,
    visible BOOLEAN NOT NULL DEFAULT false,
    input TEXT NOT NULL DEFAULT "",
    output TEXT NOT NULL DEFAULT "",
    problem_id BIGINT NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (problem_id) REFERENCES problem (id)
) ENGINE = InnoDB;

CREATE TABLE tag (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(191) NOT NULL DEFAULT "",
    CONSTRAINT PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE problem_tag (
    problem_id BIGINT NOT NULL,
    tag_id BIGINT NOT NULL,
    CONSTRAINT PRIMARY KEY (problem_id, tag_id),
    CONSTRAINT FOREIGN KEY (problem_id) REFERENCES problem (id),
    CONSTRAINT FOREIGN KEY (tag_id) REFERENCES tag (id)
) ENGINE = InnoDB;

CREATE TABLE `board` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(191) NOT NULL DEFAULT "",
    `seq` BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT PRIMARY KEY (`id`),
    CONSTRAINT UNIQUE KEY (`name`),
    CONSTRAINT UNIQUE KEY (`seq`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `article` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `board_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `title` VARCHAR(191) NOT NULL DEFAULT "",
    `content` TEXT NOT NULL DEFAULT "",
    `created` datetime(6) NOT NULL DEFAULT NOW(),
    `modified` datetime(6) NOT NULL DEFAULT NOW(),
    `upvote` BIGINT NOT NULL DEFAULT 0,
    `downvote` BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT PRIMARY KEY (`id`),
    CONSTRAINT FOREIGN KEY (`board_id`) REFERENCES `board` (`id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `comment` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `article_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `content` TEXT NOT NULL DEFAULT "",
    `created` DATETIME(6) NOT NULL DEFAULT NOW(),
    `modified` DATETIME(6) NOT NULL DEFAULT NOW(),
    `upvote` BIGINT NOT NULL DEFAULT 0,
    `downvote` BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT PRIMARY KEY (`id`),
    CONSTRAINT FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `article_vote` (
    `article_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `updown` TINYINT NOT NULL DEFAULT 0,
    CONSTRAINT PRIMARY KEY (`article_id`, `user_id`, `updown`),
    CONSTRAINT FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `comment_vote` (
    `comment_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `updown` TINYINT NOT NULL DEFAULT 0,
    CONSTRAINT PRIMARY KEY (`comment_id`, `user_id`, `updown`),
    CONSTRAINT FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO problem (title, content, input, output)
    VALUES ("A+B", "두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.", "첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)", "첫째 줄에 A+B를 출력한다."),
           ("A-B", "두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.", "첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)", "첫째 줄에 A-B를 출력한다."),
           ("감소하는 수", "음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.", "첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.", "첫째 줄에 N번째 감소하는 수를 출력한다."),
           ("소트", "크기가 N인 배열 A가 있다. 배열에 있는 모든 수는 서로 다르다. 이 배열을 소트할 때, 연속된 두 개의 원소만 교환할 수 있다. 그리고, 교환은 많아봐야 S번 할 수 있다. 이때, 소트한 결과가 사전순으로 가장 뒷서는 것을 출력한다.", "첫째 줄에 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 각 원소가 차례대로 주어진다. 이 값은 1000000보다 작거나 같은 자연수이다. 마지막 줄에는 S가 주어진다. S는 1000000보다 작거나 같은 음이 아닌 정수이다.", "첫째 줄에 문제의 정답을 출력한다."),
           ("동전 1", "n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다. 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.", "첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.", "첫째 줄에 경우의 수를 출력한다. 경우의 수는 2^31보다 작다.");

INSERT INTO testcase (problem_id, visible, input, output)
    VALUES (1000, true, "1 2", "3"),
           (1000, false, "3 8", "11"),
           (1000, false, "9 9", "18");

INSERT INTO tag (name)
    VALUES ("수학"),
           ("구현");

INSERT INTO problem_tag (problem_id, tag_id)
    VALUES (1000, 1),
           (1000, 2),
           (1001, 1),
           (1001, 2);
