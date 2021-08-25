# 소개
온라인 저지를 만들고자 시작한 kry-judge 프로젝트입니다. 김기동의 k, 료의 r, 윤의 y를 따서 kry가 되었습니다.

## 환경 설정

### 준비물

- docker
- docker-compose

### 따라하기

1. 이 리포지토리를 클론한다.
```bash
$ git clone https://github.com/orderoutofchaos/kry-judge.git
$ cd kry-judge
```

2. `.env.sample` 파일을 `.env` 파일로 복사하고 환경변수 값을 채워넣는다.
```bash
$ cp .env.sample .env
$ vi .env
```
```text
# .env.sample
MYSQL_HOST=localhost
MYSQL_PORT=3306
MYSQL_DATABASE=
MYSQL_ROOT_PASSWORD=

KRY_DB=
KRY_DB_USERNAME=
KRY_DB_PASS=
```

3. 다음의 커맨드를 실행한다.
```bash
$ docker-compose up
```
