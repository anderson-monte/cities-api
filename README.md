# Cities API

[![Rails](https://img.shields.io/badge/Java-_17.0.2-gray?style=flat&logo=java&logoColor=white&labelColor=007396)]()
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=springboot&logoColor=white)](https://start.spring.io/) 
[![Docker](https://img.shields.io/badge/Docker-blue?style=flat&logo=docker)](https://www.docker.com/) 
[![Postgres](https://img.shields.io/badge/Postgres-4169E1?style=flat&logo=postgresql&logoColor=white)](https://www.postgresql.org/)

## Description

This is an app that lists countries, cities and states in Brazil and has a feature that can calculate the distance between two cities.

It was made during the DIO challenge.

## Getting Started
### Installing
#### Prerequisites
>You can download the Docker and follow the instructions and read the Docker Documentation from [here](https://docs.docker.com/).
#### Docker-compose.yml

Open the file and set the environment variables. 

make sure everything is correct, otherwise the sprint boot server won't up.

```bash
#docker-compose.yml
#example
environment:
      POSTGRES_DB: cities
      POSTGRES_USER: cities_user
      POSTGRES_PASSWORD: password
````


## DataBase

### Populate

Download the data and import into your database.
* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

Acsses the Postgresql shell or use ADMINER on docker to use the commands bellow.

```bash
#psql -h localhost -U postgres_user_city cities
CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

#### Commands 
```bash
# Cloning the repository
$ git clone https://github.com/anderson-monte/cities-api.git
$ cd apirestful

# Initializing Docker-compose 
# This will create containers and their images.
$ docker-compose up -d --build

# Now the server is up, on http://localhost:8000/.
```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Query Earth Distance

Point
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cube
```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

## How to use the app

#### Download the POSTMAN or other.

```shell
#list all cities
http://localhost:8000/cities
#list all contries
http://localhost:8000/contries
#lsit all states
http://localhost:8000/states

⚠️you can set the ID in the end /id
```

#### Using the distance feature

```shell
#example
http://localhost:8000/distances/by-points?from=54&to=3456
#Result
628.7617532847723
```