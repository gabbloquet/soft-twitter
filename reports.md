# Load tests reports

To analyze the performance of the web server under test, you should focus on 2 parameters

 - Throughput
 - Deviation

The Throughput is the most important parameter. It represents the ability of the server to handle a heavy load.  The higher the Throughput is, the better is the server performance.

## Write

### Create User

200 threads (users), 60sec ramp up, 60000 loop.

#### SQL
Test crashed at 1:03.
![image](https://user-images.githubusercontent.com/25029077/114772183-c9f1df80-9d6d-11eb-85ab-5cf3b1217ed2.png)

#### NoSQL
Test crashed at 1:19.
![image](https://user-images.githubusercontent.com/25029077/114771280-ad08dc80-9d6c-11eb-9427-bb9f364414e1.png)

### Create Tweet

150 threads (users), 60sec ramp up.
Here we have a link, because with save the tweet for a given user.

#### SQL
Test crashed at 0:50.
![image](https://user-images.githubusercontent.com/25029077/114773417-54870e80-9d6f-11eb-944d-06c73f04e337.png)

#### NoSQL
No crash, stopped at 2:00.
![image](https://user-images.githubusercontent.com/25029077/114773983-ff97c800-9d6f-11eb-85d2-4c641c96518c.png)

## Read

### Get tweets of User

#### SQL
Test stopped 1min.
![image](https://user-images.githubusercontent.com/25029077/116112226-a9078380-a6b7-11eb-8deb-3ead10d99516.png)


#### NoSQL
Test stopped 1min.
![image](https://user-images.githubusercontent.com/25029077/116113087-75792900-a6b8-11eb-9323-95e9824997cb.png)

# First conclusions

NoSQL reacts much better to the increase in load. The application crashes less quickly and generates fewer errors.
If we take a look to deviation and throughput, difference is huge between both solutions.
Indeed, i tested it in local environment. We can imagine that behaviour could be different in production. 
