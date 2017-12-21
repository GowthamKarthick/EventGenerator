#!/bin/bash
export CLASSPATH=mysql-connector.jar:$CLASSPATH 
export CLASSPATH=java-json.jar:$CLASSPATH
#java myjar.jar
var=$(free | awk '/^Mem:/{print $2}')
div=$(( 1024*1024 ))
var=$(( var/div ))
echo "Your RAM coniguration is $var GB"
echo "The tool will use 1/3rd of your RAM size"
var=1
#$(( var/2 ))
#grep -c ^processor /proc/cpuinfo     
cores=$(grep -c ^processor /proc/cpuinfo 2>/dev/null || sysctl -n hw.ncpu)
cores=2
#echo $cores
javac Check.java
java Check $cores
#time java Check $cores
#echo "-Xms256m -Xmx$varg Check $cores"
#javac -classpath ".:/home/local/ZOHOCORP/gowtham-pt1690/Desktop/sample/task/json-simple-1.1.1.jar:/home/local/ZOHOCORP/gowtham-pt1690/Desktop/sample/task/mysql-connector.jar
#javac -cp ".;*.jar" MyRtmpClient.java
#export CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java.jarz