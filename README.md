> # SPOTIFY CLONE SERVER DOCUMENTATION

# 1. Install mysql (using Docker)

## Run docker-compose: `docker-compose -f .\docker-compose.yml up`

## PhpMyAdmin: `http://localhost:8090`

```php
username: root
password: password
```

## Create database: `spotify_clone`

# 2. Config setting

## application.properties: `src/main/resources/application.properties`

```php
# configs/AuthEntryPointJwt.java/PasswordEncoder
spring.main.allow-circular-references=true

spring.datasource.url=jdbc:mysql://localhost:3306/spring_boot_db
spring.datasource.username=root
spring.datasource.password=password

spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.diatect=org.hibernate.dialect.MySQL8InnoDBDialect
```

## .env config: `upload-server/.env`

```bash
PORT=5500
CLIENT_URL=localhost:5173
CLIENT_ID=value
CLIENT_SECRET=value
REDIRECT_URI=value
REFRESH_TOKEN=value
FOLDER_ID=value
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

## Add new audio: `[POST: http://localhost:8080/api/v1/add/audio`

**Header: Bearer generateToken**

```php
{
    "name": "Bài ca dành cho em",
    "artist": [2],
    "albums": [1],
    "url": "http://example.com"
}
```

## Delete audio by od: `[POST: http://localhost:8080/api/v1/delete/audio/id`

**Header: Bearer generateToken**


## 4. More Documentation

**https://copyprogramming.com/howto/utf-8-character-encoding-is-not-working-for-spring-boot**