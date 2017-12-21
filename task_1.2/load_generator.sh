#!/bin/bash
export CLASSPATH=mysql-connector.jar:$CLASSPATH 
export CLASSPATH=java-json.jar:$CLASSPATH
#java myjar.jar
echo "The tool will use 1/3rd of your RAM size"
javac Check.java
java Check $1 $2
var=$(free | awk '/^Mem:/{print $2}')
#echo "Your RAM coniguration is $var GB"
#echo "The tool will use 1/3rd of your RAM size"
#echo 'hai'
#javac -classpath ".:/home/local/ZOHOCORP/gowtham-pt1690/Desktop/sample/task/json-simple-1.1.1.jar:/home/local/ZOHOCORP/gowtham-pt1690/Desktop/sample/task/mysql-connector.jar
#javac -cp ".;*.jar" MyRtmpClient.java
#export CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java.jar