create database app
go
use app
go


create table Customer
(
	CustomerId int identity(1,1) primary key , 
	CustomerName nvarchar(50) not null,

);

Alter table Employee
Alter column SupervisorId nvarchar(50)
create table Employee
(
	EmployeeId int identity(1,1) primary key,
	EmployeeName nvarchar(50)not null,
	Salary money not null,
	SupervisorId nvarchar,
);

create table Product(
	ProductId int identity(1,1) Primary key,
	ProductName nvarchar(50) not null,
	ListPrice money not null,
);


create table Orders
(
	OrderId int identity (1,1) primary key,
	OrderDate Date not null,
	CustomerId int,
	EmployeeId int,
	Total int,
	foreign key (CustomerId) references Customer(CustomerId),
	foreign key (EmployeeId) references Employee(EmployeeId)
);


create table LineItem
(	
	LineItemId int identity (1,1) primary key,
	OrderId int,
	ProductId int,
	Quantity int,
	price money,
	foreign key( OrderId) references Orders(OrderId),
	foreign key(ProductId) references Product(ProductId)
)
 
Drop table line_item
Drop table Customer
Drop table Orders
Drop table Employee
Drop table Product

insert into Customer(CustomerName) values ('hoang')
insert into Customer(CustomerName) values ('Ghe z ba')

insert into Employee(EmployeeName, Salary, SupervisorId) values ('NV1',1000000, N'Hoang')

insert into Product(ProductName,ListPrice) values ('hoang',10000)

insert into Orders(OrderDate,CustomerId,EmployeeId,Total) values (26/09/2022,2,3,10)


update Customer set CustomerName = 'hoang1' where CustomerId = 1
select *from Customer
select *from Employee
select *from Product
select *from Orders
select *from LineItem	
select * from line_item_orders
select * from line_item_product