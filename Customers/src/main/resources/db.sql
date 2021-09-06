create database customers;



DROP TABLE IF EXISTS customers_transaction;
CREATE TABLE customers_transaction (
  cust_id INT NOT NULL AUTO_INCREMENT,
  cust_name VARCHAR(100) NOT NULL,
  transaction_date DATE NOT NULL,
  transation_value INT NOT NULL,
  PRIMARY KEY (cust_id));
  
  
  INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(1,'Unicoz','2021-08-13',1000);
  INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(10,'Unicoz','2021-08-13',1000);
  INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(2,'Unicoz','2021-07-13',1000);
  INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(3,'Unicoz','2021-06-13',1000);
  
  
  INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(4,'Unicoz1','2021-08-13',500);
  INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(5,'Unicoz1','2021-07-13',500);
  INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(6,'Unicoz1','2021-06-13',500);
  
  
   INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(7,'Unicoz2','2021-08-13',200);
  INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(8,'Unicoz2','2021-07-13',200);
  INSERT INTO customers_transaction(cust_id,cust_name,transaction_date,transation_value)VALUES(9,'Unicoz2','2021-06-13',200);