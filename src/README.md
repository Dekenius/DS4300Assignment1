# DS4300 Assignment 1
## Contributions: 
Griffin Milas(Java objects, API & API implementation)

Dan Krasnonosenkikh(Tweet / follow generation)

Matthew Wojtowicz(SQL Schema creation)

## Assumptions: 
* Users are followed and follow other users randomly. 
* 1,000,000 tweets are assigned to users randomly. 
* Dates are assigned via the formula (current date - random long).  
* Users cannot follow themself
* Size of tweet is at max 140 characters.
* There are 1,000 users
* A timeline consists of at max 20 tweets

We assume that by assigning followers and tweets randomly instead of biasing, tweets and followers will be distributed fairly evenly amongst users, resulting in better performance than if they were biased.


## Results
### Tweet Posting
Rate: X Tweets/Second

### Timeline Fetching
Rate: X Timelines/Second


## Analysis
### Computer Specs
CPU: i7 7700HQ. 4 cores at 2.80GHz
RAM: 16gb 
Disk: 512gb SSD. Sequential read up to 3000 MB/s and sequential write up to 1150 MB/s

### Theoretical Optimal Performance
