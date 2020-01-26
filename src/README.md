# DS4300 Assignment 1
## Contributions: 
Griffin Milas(Java objects, API & API implementation)

Dan Krasnonosenkikh(Tweet / follow generation)

Matthew Wojtowicz(SQL Schema creation/ API implementation)

## Assumptions: 
* Users are followed and follow other users randomly. 
* 1,000,000 tweets are assigned to users randomly. 
* Dates are assigned via the formula (current date - random long).  
* Users cannot follow themself
* Size of tweet is at max 140 characters.
* There are 1,000 users
* A timeline consists of at max 10 tweets

We assume that by assigning followers and tweets randomly instead of in a biased way, tweets and followers will be distributed fairly evenly amongst users, resulting in better performance than if they were distributed in a more realistic way.


## Results
### Tweet Posting
Rate: 241 Tweets/Second

### Timeline Fetching
Rate: 4.78 Timelines/Second


## Analysis
### Computer Specs
CPU: i7 7700HQ. 4 cores at 2.80GHz
RAM: 16gb 
Storage: 512gb SSD. Sequential read up to 3000 MB/s and sequential write up to 1150 MB/s

Most users are only following one or two users. Because of this, the majority of timelines can be fetched much faster than if users were following many different users. The performance of fetching timelines would decrease as the number of user/follower relations increases since more tweets would need to be searched through to find the corresponding timeline for a user. Generating a billion tweets would have taken much more time and disk space. Additionally, finding a user's tweets amongst a billion would take longer than just a million.

### Theoretical Optimal Performance
Regarding theoretical performance, writing records to a disk simply scaled with the number of records, whereas inserting records in the database takes more time per insert since the tweets are indexed. Likewise, simply reading 10 tweets from a file would take far less time than needing to find a user's followers, their followers tweets, and sort those tweets by date. In the current configuration with a relational database, we are far form the optimal performance of inserting tweets and fetching user's timelines. 
