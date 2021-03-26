# Soft twitter Backend

## Introduction
Objective of this repository is to work on System Design.
I think about the design of an application, with all its components.
One of the most interesting choice to explore is the database choice.
I want to create my own conviction.
So i will, with this repository, poke difference between SQL & NoSQL Database.
I will create similar object, store it, and play with. I will work on a large amount of data to simulate as best as possible. Twitter like.

## Technical Choice

Language : Java (I want to practice it again)
Framework : Spring
Database system : Postgresql (for SQL), MongoDB (for NoSQL)
Libraries / tools : JPA, Hibernate, Docker for host database

## Architecture

I want to apply this kind of architecture.
![Architecture Diagram](https://cdn-media-1.freecodecamp.org/images/YIABVRTHRz58ZiT6W-emBkfNIQUHBelp8t6U)

I will be able to split my code nicely.
I will have 2 data providers (blue) => One for SQL, and one for NoSQL.
I will create HTTPs entrypoints, to simulate calls from front for exemple. To do that i will use a tool.
