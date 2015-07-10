# CharlesLovesBigData

#####*This is the Code Challenge of [Insight Data Engineering Fellows Program](http://insightdataengineering.com/), this tool could help analyze the community of Twitter users.*#####

###Functional Properties###
* Calculate the total number of times each word has been tweeted.
* Calculate the median of *unique* words per tweet, and update this median as tweet come in.

###Architecture & Design###
* Architecture
  * The main frame of TASK1&2 is written in `Task.java`.
  * The behaviour that calculating median of unique words per tweet is encapsulated as a bissiness logic class called `MedianCalculator.java`, which will run at each time when a new tweet comes in.
* Design
  * For TASK1, I used **TreeMap** to be the container, which can sort the Keys -- the words themselves, and stored the times they occur as Values.
  * For TASK2, I used **TreeSet** and **ArrayList** to keep words unique and store them, and then the median will be further calculated by invoke the helper class `MedianCalculator.java`. 

  For detailed algorithms and design patterns, please see the source code.
  
###Directory Structure###
* README.md  
* run.sh  
* src  
  * Task.java
  * MedianCalculator.java  
* bin
  * Task.class 
  * MedianCalculator.class
* tweet_input  
  * tweets.txt  
* tweet_output  
  * ft1.txt  
  * ft2.txt 
  


######P.S.: All the codes are written in Java, did not incorporate others work, did not use additional libraries.
