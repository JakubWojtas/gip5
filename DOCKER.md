## Docker

Start databank

```sh
$ docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
```

## Docker compose (tweede manier)

1. Navigeer naar project in command line

2. Start databank

```sh
$ docker-compose up -d
```

3. Stop databank

```sh
$ docker-compose down
```