# Soft twitter Backend

## Introduction
**Objective** of this repository is to work on System Design.  
I think about the **design of an application**, with all its components.  
One of the most interesting choice to explore is the **database choice**. I want to create my own conviction.  
So i will, with this repository, poke difference between SQL & NoSQL Database.  
I will create similar object, store it, and play with. I will work on a large amount of data to simulate as best as possible. Twitter like.  

## Technical Choice

 - **Language** : Java (I want to practice it again)
 - **Framework** : Spring
 - **Database system** : Postgresql (for SQL), MongoDB (for NoSQL)
 - **Libraries / tools** : JPA, Hibernate, Docker for host database

## Architecture

I want to apply this kind of architecture.

![Architecture Diagram](https://cdn-media-1.freecodecamp.org/images/YIABVRTHRz58ZiT6W-emBkfNIQUHBelp8t6U)

 - I will be able to split my code nicely.
 - I will have 2 **data providers** (blue) => One for SQL, and one for NoSQL.
 - I will create HTTPs **entrypoints** (green), to simulate calls from front for exemple. To do that, i will use a tool which is able to do a lot of calls.

## Tests 

The goal is to reproduce something like real usage. To do that, I will send a lot of requests.
Here some common use cases : 
 - Load news feed. (For a user, activies of people he follows).
 - Tweet. (Create a tweet, i will simulate a lot of concurent creation).
 - Load people activity. (For a user, load his last actions, like or tweets for a range of time).
 - Load response, feed of a tweet. (For a tweet, load all linked tweets).

### Execution

#### Configure Postgres

1. docker pull postgres
2. docker run --name twitterPostgresDB -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres

#### Configure Mongo

1. docker pull mongo
2. docker run  --name twitterMongoDB -d mongo:latest

#### Launch Spring Application

##### SQL
1. mvn spring-boot:run -Dspring-boot.run.profiles=sql

##### NoSQL
1. mvn spring-boot:run -Dspring-boot.run.profiles=nosql
