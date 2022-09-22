-- Rewards configuration
-- If amount is morethan $100, rewards 2
insert into REWARDS_CONFIGURATION (PRICE, REWARDS) values (100.00, 2.00);
-- If amount is morethan $50, rewards 1
insert into REWARDS_CONFIGURATION (PRICE, REWARDS) values (50.00, 1.00);

 -- Customer 1 orders data
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (1,'2022-09-10', 120.03);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (1,'2022-09-15', 133.93);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (1,'2022-09-20', 233.23);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (1,'2022-08-05', 120.00);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (1,'2022-07-05', 10.00);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (1,'2022-07-10', 16.30);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (1,'2022-07-15', 15.15);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (1,'2022-06-25', 55.15);

-- Customer 2 orders data
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (2,'2022-09-22', 102.03);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (2,'2022-08-12', 233.23);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (2,'2022-07-15', 100.00);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (2,'2022-06-10', 106.30);
insert into ORDERS (CUSTOMER_ID, ORDER_DATE, PRICE ) values (2,'2022-05-15', 29.15);
