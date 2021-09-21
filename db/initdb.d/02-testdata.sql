USE `kry`;

INSERT INTO problem (`title`, `content`, `input`, `output`, `note`, `time_limit`, `memory_limit`, `submit_count`, `accept_count`, `created`, `modified`)
VALUES ('A+B', '두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.', '첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)', '첫째 줄에 A+B를 출력한다.', 'note testdata', 2, 256, 0, 0, NOW(), NOW()),
       ('A-B', '두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.', '첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)', '첫째 줄에 A-B를 출력한다.', 'note testdata', 2, 256, 0, 0, NOW(), NOW()),
       ('감소하는 수', '음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.', '첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.', '첫째 줄에 N번째 감소하는 수를 출력한다.', 'note testdata', 2, 256, 0, 0, NOW(), NOW()),
       ('소트', '크기가 N인 배열 A가 있다. 배열에 있는 모든 수는 서로 다르다. 이 배열을 소트할 때, 연속된 두 개의 원소만 교환할 수 있다. 그리고, 교환은 많아봐야 S번 할 수 있다. 이때, 소트한 결과가 사전순으로 가장 뒷서는 것을 출력한다.', '첫째 줄에 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 각 원소가 차례대로 주어진다. 이 값은 1000000보다 작거나 같은 자연수이다. 마지막 줄에는 S가 주어진다. S는 1000000보다 작거나 같은 음이 아닌 정수이다.', '첫째 줄에 문제의 정답을 출력한다.', 'note testdata', 2, 256, 0, 0, NOW(), NOW()),
       ('동전 1', 'n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다. 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.', '첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.', '첫째 줄에 경우의 수를 출력한다. 경우의 수는 2^31보다 작다.', 'note testdata', 2, 256, 0, 0, NOW(), NOW());

INSERT INTO `testcase` (`problem_id`, `visible`, `input`, `output`)
VALUES (1000, true, '1 2', '3'),
       (1000, false, '3 8', '11'),
       (1000, false, '9 9', '18');

INSERT INTO `tag` (`name`)
VALUES ('수학'),
       ('구현');

INSERT INTO problem_tag (`problem_id`, `tag_id`)
VALUES (1000, 1),
       (1000, 2),
       (1001, 1),
       (1001, 2);

INSERT INTO `user` (`name`, `pw`, `nick`, `bio`, `email`)
VALUES ('user01', 'PaSsWoRd01', 'nick01', 'Hello Wolrd!', 'user01@email.com'),
       ('user02', 'PaSsWoRd02', 'nick02', 'In the end, we all felt like we ate too much.', 'user02@email.com'),
       ('user03', 'PaSsWoRd03', 'nick03', '헬로우 월드!', 'user03@email.com'),
       ('user04', 'PaSsWoRd04', 'nick04', '한글 바이오 Example 입니다.', 'user04@email.com');

INSERT INTO `permgroup` (`name`)
VALUES ('staff'),
       ('admin'),
       ('guest'),
       ('user'),
       ('moderator');

INSERT INTO `permission` (`name`)
VALUES ('post_read'),
       ('post_write'),
       ('problem_read'),
       ('problem_write'),
       ('comment_read'),
       ('comment_write'),
       ('board_read'),
       ('board_write');

INSERT INTO `user_permgroup` (`user_id`, `permgroup_id`)
VALUES (1, 4),
       (2, 3),
       (3, 2),
       (4, 1);

INSERT INTO `permgroup_permission`(`permgroup_id`, `permission_id`)
VALUES ((SELECT `id` FROM `permgroup` WHERE `name` = 'guest'), (SELECT `id` FROM `permission` WHERE `name` = 'post_read')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'guest'), (SELECT `id` FROM `permission` WHERE `name` = 'post_write')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'user'),  (SELECT `id` FROM `permission` WHERE `name` = 'post_read')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'user'),  (SELECT `id` FROM `permission` WHERE `name` = 'post_write')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'user'),  (SELECT `id` FROM `permission` WHERE `name` = 'comment_read')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'user'),  (SELECT `id` FROM `permission` WHERE `name` = 'comment_write')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'staff'), (SELECT `id` FROM `permission` WHERE `name` = 'post_read')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'staff'), (SELECT `id` FROM `permission` WHERE `name` = 'post_write')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'staff'), (SELECT `id` FROM `permission` WHERE `name` = 'problem_read')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'staff'), (SELECT `id` FROM `permission` WHERE `name` = 'problem_write')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'staff'), (SELECT `id` FROM `permission` WHERE `name` = 'board_read')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'staff'), (SELECT `id` FROM `permission` WHERE `name` = 'board_write')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'staff'), (SELECT `id` FROM `permission` WHERE `name` = 'comment_read')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'staff'), (SELECT `id` FROM `permission` WHERE `name` = 'comment_write')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'admin'), (SELECT `id` FROM `permission` WHERE `name` = 'permission_read')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'admin'), (SELECT `id` FROM `permission` WHERE `name` = 'permission_write')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'admin'), (SELECT `id` FROM `permission` WHERE `name` = 'permgroup_read')),
       ((SELECT `id` FROM `permgroup` WHERE `name` = 'admin'), (SELECT `id` FROM `permission` WHERE `name` = 'permgroup_write'));
