mysql> CREATE USER 'springbatch'@'%' IDENTIFIED BY 'springbatchdb';
Query OK, 0 rows affected (0.02 sec)

mysql> GRANT ALL PRIVILEGES ON *.* TO 'springbatch'@'%';
Query OK, 0 rows affected (0.01 sec)

mysql> flush privileges;
Query OK, 0 rows affected (0.00 sec)

mysql> drop user springbatch;
Query OK, 0 rows affected (0.02 sec)

mysql> CREATE DATABASE springbatchdb default CHARACTER SET UTF8;
Query OK, 1 row affected, 1 warning (0.01 sec)

mysql> CREATE USER 'springbatch'@'%' IDENTIFIED BY '1234';
Query OK, 0 rows affected (0.00 sec)

mysql> GRANT ALL PRIVILEGES ON *.* TO 'springbatch'@'%';
Query OK, 0 rows affected (0.01 sec)