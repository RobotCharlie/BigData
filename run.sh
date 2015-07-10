#!/usr/bin/env bash
#I love big data!!
javac -d ./bin ./src/*.java
java -cp ./bin: Task ./tweet_input/tweets.txt ./tweet_output/ft1.txt ./tweet_output/ft2.txt


