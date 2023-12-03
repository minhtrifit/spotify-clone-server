> # SPOTIFY CLONE SERVER DOCUMENTATION

# Technical Stack

<a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> <a href="https://expressjs.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/express/express-original-wordmark.svg" alt="express" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://www.docker.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a> 

# 1. Install mysql (using Docker)

* If you have installed MySql (Xampp or anything else), you can skip this step.

## Run docker-compose: `docker-compose -f .\docker-compose.yml up`

## PhpMyAdmin: `http://localhost:8090`

```php
username: root
password: password
```

# 2. Server config setting

* Note: This repository use **TWO** server.

**1. Main server with Spring Boot.**
**2. NodeJS(ExpressJS) server to upload audio file.**

## application.properties: `src/main/resources/application.properties`

* This config file to map your Mysql database with Spring Boot project
* Change: "url, username, password" value for example `spotify_clone, root, password`

```php
spring.main.allow-circular-references=true

spring.datasource.url=jdbc:mysql://localhost:3306/spotify_clone?createDatabaseIfNotExist=true&useUnicode=true&connectionCollation=utf8_bin&characterSetResults=utf8
spring.datasource.username=root
spring.datasource.password=password

spring.jpa.properties.hibernate.connection.characterEncoding=utf-8
spring.jpa.properties.hibernate.connection.CharSet=utf-8
spring.jpa.properties.hibernate.connection.useUnicode=true
spring.jpa.properties.hibernate.connection.collationConnection=utf8_bin

spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.diatect=org.hibernate.dialect.MySQL8InnoDBDialect
spring.jpa.properties.hibernate.use_nationalized_character_data =true
```

## .env config: `upload-server/.env`

**Config ExpressJS server, this server using [Google Drive API](https://www.npmjs.com/package/@googleapis/drive) two upload Audio file.**
**How to get Google Drive API key, you can check out: [Youtube tutorial](https://www.youtube.com/watch?v=1y0-IfRW114)**

```bash
PORT=5500
CLIENT_URL=localhost:5173
CLIENT_ID=value
CLIENT_SECRET=value
REDIRECT_URI=value
REFRESH_TOKEN=value
FOLDER_ID=value
```

## Run audio upload server: `upload-server/`

```bash
npm install
npm run start
```

# 3. API Documentation

## Register: `[POST]: http://localhost:8080/auth/register`

```php
{
  "username": "user1",
  "password": "123",
  "email": "user@gmail.com",
  "roles": "ROLE_USER"
}
```

## Login: `[POST]: http://localhost:8080/auth/login`

```php
{
  "username": "user1",
  "password": "123"
}
```

## Refresh: `[POST]: http://localhost:8080/auth/refresh`

**Header: Bearer generateToken**

```php
{
  "Authorization": Bearer accessToken
}
```

## Get user profile: `[GET]: http://localhost:8080/auth/profile`

**Header: Bearer generateToken**

```php
{
  "Authorization": Bearer token
}
```

## Check user role: `[GET]: http://localhost:8080/auth/user`

**Header: Bearer generateToken**

```php
{
  "Authorization": Bearer token
}
```

## Check admin role: `[GET]: http://localhost:8080/auth/admin`

**Header: Bearer generateToken**

```php
{
  "Authorization": Bearer token
}
```

---

## Upload new image: `[POST]: http://localhost:8080/upload`

**form-data: file choosefile**

## Get image url: `[GET]: http://localhost:8080/upload/files/1.png`

---

## Get all audio: `[GET]: http://localhost:8080/api/v1/audios`

## Add new audio: `[POST]: http://localhost:8080/api/v1/add/audio`

**Header: Bearer generateToken**

```php
{
    "name": "Bài ca dành cho em",
    "artist": [2],
    "albums": [1],
    "url": "http://example.com",
    "avatar": "http://localhost:8080/upload/files/example.png",
}
```

## Delete audio by id: `[POST]: http://localhost:8080/api/v1/delete/audio/id`

**Header: Bearer generateToken**

---

## Get all artists: `[GET]: http://localhost:8080/api/v1/artists`

---

## Get all albums: `[GET]: http://localhost:8080/api/v1/albums`

## Add new album: `[POST]: http://localhost:8080/api/v1/add/album`

**Header: Bearer generateToken**

```php
{
    "name": "Lofi chill",
    "audios": [1, 2],
    "avatar": "http://localhost:8080/upload/files/example.png"
}
```

## Edit album: `[POST]: http://localhost:8080/api/v1/edit/album`

**Header: Bearer generateToken**

```php
{
    "id": 3,
    "name": "Lofi chill",
    "audios": [1, 2, 3]
}
```

## Delete album by id: `[POST]: http://localhost:8080/api/v1/delete/album/id`

**Header: Bearer generateToken**

---

## Add new playlist: `[POST]: http://localhost:8080/api/v1/add/playlist`

**Header: Bearer generateToken**

```php
{
    "userId": 1,
    "name": "Nhạc của sadboiz",
    "audios": [1, 2]
}
```

## Edit playlist: `[POST]: http://localhost:8080/api/v1/edit/playlist`

**Header: Bearer generateToken**

```php
{
    "id": 1,
    "userId": 1,
    "name": "Nhạc của sadboiz",
    "audios": [1, 2, 3]
}
```

## 4. More Documentation

**https://copyprogramming.com/howto/utf-8-character-encoding-is-not-working-for-spring-boot**