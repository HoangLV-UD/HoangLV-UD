/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [orderid]
      ,[orderdate]
      ,[total]
      ,[customerid]
      ,[employeeid]
  FROM [app].[dbo].[orders]


  select customer.customerid, customer.customername, orders.orderdate, orders.total
  from orders inner join customer 
  on orders.customerid = customer.customerid

  select orders.orderid, customer.customername, orders.total
  from orders inner join customer
  on orders.customerid = customer.customerid
  where customer.customerid =  '1'