# SPOTIFY CLONE SERVER DOCUMENTATION

<img src="https://img.shields.io/github/stars/minhtrifit/spotify-clone-server"/> ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/minhtrifit/spotify-clone-server)

![Thumbnail](./showcase/screenshot.png)

🎧 🎵 Music project app base on [Spotify 2.0](https://open.spotify.com)

This project includes two repository (Client and Server), you can checkout **[client repository](https://github.com/minhtrifit/spotify-clone-client)**

## 💻 Technical Stack

<a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> <a href="https://expressjs.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/express/express-original-wordmark.svg" alt="express" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://www.docker.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a>

- [Java Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
- [ExpressJS](https://expressjs.com) - Fast, unopinionated, minimalist web framework for Node.js
- [MySQL](https://www.mysql.com) - Widely used relational database management system (RDBMS).
- [Docker](https://www.docker.com) - Accelerate how you build, share, and run applications



## 📦 Installation

### 🐬 🐳 MySQL & PhpMyAdmin (using Docker)

**NOTE: If you have installed MySQL (Xampp or anything else), you can skip this step.**

* Run docker-compose:

To run MySQL & PhpMyAdmin to interact with database:

```console
docker-compose -f .\docker-compose.yml up
```

* PhpMyAdmin browser: `http://localhost:8090`

Using default account to login to PhpMyAdmin:

```console
username: root
password: password
```
<br>

![login](/doc_image/login.png "Login to phpmyadmin")

Create database before start Java Spring Boot server:

![login](/doc_image/create_db.png "Login to phpmyadmin")

Init [spotify_clone.sql]() file to database with path ./spotify_clone.sql

![login](/doc_image/init_db.png "Login to phpmyadmin")

### ⚙️ Server config setting

Note: This repository use **TWO** server.

- Main server with Spring Boot.</br>

- NodeJS (ExpressJS) server to upload audio file.

### Spring Boot Server config

Go to [application.properties]() file with path: `src/main/resources/application.properties`

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

### ExpressJS Server config

Setting [.env]() config file with path: `upload-server/.env`

**Config .env file for ExpressJS server, this server using [Google Drive API](https://www.npmjs.com/package/@googleapis/drive) to upload Audio file.**</br>

To get Google Drive API key, you can check out: [Youtube tutorial](https://www.youtube.com/watch?v=1y0-IfRW114)

To get FOLDER_ID:

* Navigate to the folder in Google Drive.
* Copy the Folder ID found in the URL. This is everything that comes after “folder/” in the URL. For example, if the URL was “https://drive.google.com/drive/folders/1dyUEebJaFnWa3Z4n0BFMVAXQ7mfUH11g”, then the Folder ID would be “1dyUEebJaFnWa3Z4n0BFMVAXQ7mfUH11g”.

```bash
PORT=5500
CLIENT_URL=localhost:5173
CLIENT_ID=value
CLIENT_SECRET=value
REDIRECT_URI=https://developers.google.com/oauthplayground
REFRESH_TOKEN=value
FOLDER_ID=value
```

### Run audio upload server (ExpressJS server): `upload-server/`

Intall packages & dependencies
```console
npm install
```

Or install packages with legacy peer dependencies.
```console
npm install --legacy-peer-deps
```

Run server project
```console
npm run start
```

## ⚡️API Documentation

* **Authentication & Authorization** 

<details>
<summary><code>Register</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/auth/register</code></summary>

```php
{
  body: {
    "username": "user1",
    "password": "123",
    "email": "user@gmail.com",
    "roles": "ROLE_USER"
  }
}
```
</details>

<details>
<summary><code>Login</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/auth/login</code></summary>

```php
{
  body: {
    "username": "user1",
    "password": "123"
  }
}
```
</details>

<details>
<summary><code>Refresh</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/auth/refresh</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer accessToken`
  }
}
```
</details>

<details>
<summary><code>Get user profile</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/auth/profile</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  }
}
```
</details>

<details>
<summary><code>Check user role</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/auth/user</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
}
```
</details>

<details>
<summary><code>Check admin role</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/auth/admin</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
}
```
</details>

<br>

* **Image Handle** 

<details>
<summary><code>Upload new image</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/upload</code></summary>

```php
{
  form-data: {
    "file": choosefile
  }
}
```
</details>

<details>
<summary><code>Get image url</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/upload/files/1.png</code></summary>

```php
{

}
```
</details>

<br>

* **Audio Handle**

<details>
<summary><code>Upload new audio</code> <code><b>/</b></code> <code>[POST]: http://localhost:5500/upload</code></summary>

```php
{
  form-data: {
    "file": choosefile
  }
}
```
</details>

<details>
<summary><code>Get all audio</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/api/v1/audios</code></summary>

```php
{

}
```
</details>

<details>
<summary><code>Add new audio</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/add/audio</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
  body: {
    "name": "Bài ca dành cho em",
    "artists": [2],
    "albums": [1],
    "url": "http://example.com",
    "avatar": "http://localhost:8080/upload/files/example.png"
  }
}
```
</details>

<details>
<summary><code>Delete audio by id</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/delete/audio/id</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  }
}
```
</details>

<br>

* **Artist Handle**

<details>
<summary><code>Get all artists</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/api/v1/artists</code></summary>

```php
{

}
```
</details>

<details>
<summary><code>Add new artist</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/add/artist</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
  body: {
    "name": "Yến Napun",
    "avatar": "http://localhost:8080/upload/files/example.png"
  }
}
```
</details>

<details>
<summary><code>Edit artist</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/edit/artist</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
  body: {
    "id": 102,
    "name": "Yến Napun Cover",
    "followers": 100,
    "avatar": "http://localhost:8080/upload/files/edit.png"
  }
}
```
</details>

<details>
<summary><code>Delete artist by id</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/delete/artist/id</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  }
}
```
</details>

<br>

* **Album Handle**

<details>
<summary><code>Get all albums</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/api/v1/albums</code></summary>

```php
{

}
```
</details>

<details>
<summary><code>Add new album</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/add/album</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
  body: {
    "name": "Lofi chill",
    "audios": [1, 2],
    "avatar": "http://localhost:8080/upload/files/example.png"
  }
}
```
</details>

<details>
<summary><code>Edit album</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/edit/album</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
  body: {
    "id": 3,
    "name": "Lofi chill",
    "audios": [1, 2, 3],
    "avatar": "http://localhost:8080/upload/files/example.png"
  }
}
```
</details>

<details>
<summary><code>Delete album by id</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/delete/album/id</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  }
}
```
</details>

<br>

* **Playlist Handle**

<details>
<summary><code>Get all playlist by UserId</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/api/v1/playlist/id</code></summary>

```php
{

}
```
</details>

<details>
<summary><code>Get playlist by Id</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/api/v1/playlist/detail/id</code></summary>

```php
{

}
```
</details>

<details>
<summary><code>Add new playlist</code> <code><b>/</b></code> <code>[GET]: http://localhost:8080/api/v1/add/playlist</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
  body: {
    "userId": 1,
    "name": "Nhạc của sadboiz",
    "audios": [1, 2],
    "avatar": "http://localhost:8080/upload/files/example.png"
  }
}
```
</details>

<details>
<summary><code>Edit playlist</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/edit/playlist</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
  body: {
    "id": 1,
    "userId": 1,
    "name": "Nhạc của sadboiz",
    "audios": [1, 2, 3],
    "avatar": "http://localhost:8080/upload/files/example.png"
  }
}
```
</details>

<details>
<summary><code>Delete playlist by id</code> <code><b>/</b></code> <code>[POST]: http://localhost:8080/api/v1/delete/playlist/id</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  }
}
```
</details>

<details>
<summary><code>Modify Add playlist</code> <code><b>/</b></code> <code>[PUT]: http://localhost:8080/api/v1/edit/playlist</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
  body: {
    "userId": 1,
    "playlistId": 153,
    "audioId": 4
  }
}
```
</details>

<details>
<summary><code>Modify Remove playlist</code> <code><b>/</b></code> <code>[DELETE]: http://localhost:8080/api/v1/edit/playlist</code></summary>

```php
{
  headers: {
    "Authorization": `Bearer token`
  },
  body: {
    "userId": 1,
    "playlistId": 153,
    "audioId": 4
  }
}
```
</details>

<br>

## ▶️ YouTube Demo

[![Thumnail](https://img.youtube.com/vi/iLBWCdZQNpQ/0.jpg)](https://youtu.be/iLBWCdZQNpQ)

## More Documentation

[Spring Boot urf-8 encoding support](https://copyprogramming.com/howto/utf-8-character-encoding-is-not-working-for-spring-boot)

## 💌 Contact

- Author - [minhtrifit](https://minhtrifitdev.netlify.app)
- [Github](https://github.com/minhtrifit)

> CopyRight© minhtrifit