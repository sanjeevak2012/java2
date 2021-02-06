# LoginRegisterApp

install MySQL version 8.0.21   (ie. 8.0.x)

database username: admin
database password: welcome1

If you are using another user then needs to be changed in java file: DbUtil.java

mysql> create database flipkart;

mysql> use flipkart;

mysql> create table user(name varchar(100),password varchar(100), address varchar(1000), age int, profession varchar(100));

mysql> select * from User;

Go to server

1. yum install git -y 
2. cd $HOME
3. git clone https://github.com/mailrahulsre/java-db-Login.git
4. cd /root/java-db-Login/src/main
5. Update files - with DB end POINT
  - java/com/example/DbUtil.java
  - java/com/example/application.properties
  - webapp/WEB-INF/web.xml
  
  6. git add .
  7. git commit . -m "new db details"
  8. git push origin master
