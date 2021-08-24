-- This script has possibility of NOT create anything!

CREATE DATABASE IF NOT EXISTS kry;
USE kry;

CREATE TABLE problem (
    id BIGINT NOT NULL AUTO_INCREMENT,
    accept_count INTEGER NOT NULL,
    content TEXT NOT NULL,
    created DATETIME(6) NOT NULL,
    input TEXT NOT NULL,
    memory_limit INTEGER NOT NULL,
    modified DATETIME(6) NOT NULL,
    note TEXT NOT NULL,
    output TEXT NOT NULL,
    submit_count INTEGER NOT NULL,
    time_limit DECIMAL(7, 5) NOT NULL,
    title VARCHAR(191) NOT NULL,
    PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE test_case (
    id BIGINT NOT NULL AUTO_INCREMENT,
    input TEXT NOT NULL,
    output TEXT NOT NULL,
    problem_id BIGINT,
    PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE tag (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(191) NOT NULL,
    PRIMARY KEY (id)
) engine=InnoDB;

INSERT INTO problem VALUES(1, 10, "두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.", "2020-03-13 11:04:39", "첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)", 128, "2020-03-13 11:04:39", "", "첫째 줄에 A+B를 출력한다.", 55, 1.0, "A+B");
INSERT INTO problem VALUES(2, 45, "두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.", "2020-03-13 11:04:39", "첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)", 128, "2020-03-13 11:04:39", "", "첫째 줄에 A-B를 출력한다.", 743, 1.0, "A-B");
INSERT INTO problem VALUES(3, 2, "조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다. 이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다. 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.", "2021-01-22 03:24:31", "첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다. 한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.", 128, "2021-01-22 03:26:04", "", "각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.", 5, 2.0, "터렛");
INSERT INTO problem VALUES(4, 79200, "두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.", "2021-07-11 22:22:22", "첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)", 128, "2021-07-11 22:22:22", "", "첫째 줄에 A/B를 출력한다.", 287310, 1.0, "A/B");
INSERT INTO problem VALUES(5, 2606, "P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열이다. 수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]이다. 배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성하시오. 비내림차순이란, 각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우를 말한다. 만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.", "2010-03-13 11:04:39", "첫째 줄에 배열 A의 크기 N이 주어진다. 둘째 줄에는 배열 A의 원소가 0번부터 차례대로 주어진다. N은 50보다 작거나 같은 자연수이고, 배열의 원소는 1,000보다 작거나 같은 자연수이다.", 128, "2010-03-13 11:04:39", "", "첫째 줄에 비내림차순으로 만드는 수열 P를 출력한다.", 7050, 1.0, "수열 정렬");
