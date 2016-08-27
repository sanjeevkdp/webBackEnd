 
table for the handicraft
  1//===============================supplier==========================================//

create table SUPPLIER ( 
supplier_ID VARchar (20),
supplier_NAME VARchar(20) NOt null,
supplier_EMAIL VARCHAR(30)not null,
supplier_CONTACT VARCHAR(10),
supplier_ADDRESS VARCHAR(225),
supplier_imgurl varchar(225),
constraint pk_supplier_supplier_id primary key(supplier_id)
);

2//=================================category===========================================//
create table category(
category_id varchar(20),
category_name varchar(20),
imageUrl VARchar (50),
description varhchar,
constraint pk_category_category_id primary key(category_id)
);
3//================================product=========================================//

create table product(
product_id varchar(20),
product_name varchar(20),
description varchar(225),
unit_price decimal(10,2),
quantity int,
out_of_stock boolean,
category_id varchar(20),
supplier_id varchar(20),
imageUrl varchar(225),
constraint pk_product_product_id primary key(product_id),
constraint fk_product_category_id foreign key(category_id) references category(category_id) on delete set null,
constraint fk_product_supplier_id foreign key(supplier_id) references supplier(supplier_id) on delete set null
);
4//==================================customer============================================//
create table customer(
customerId varchar,
customer_name varchar,
phoneNo varchar ,
gender varchar ,
emailAddress varchar,
password varchar ,
userName varchar ,
enabled boolean,
constraint pk_customer_customerId primary key(customerId),
);
5//===============================cart==================================================//

create table cart(
cartId varchar(20) not null,
customerId varchar(20) not null unique,
grandTotal decimal(10),
noOfProducts decimal(3),
constraint pk_cart_cartId primary key (cartId),
constraint fk_cart_userName foreign key (customerId) references customer(customerId) on delete cascade
);

6//===================================cartItem========================================//

create table cartItem(
cartItemId varchar(20),
product_id varchar(20),
customerId varchar(20),
cartId varchar(20),
quantity decimal(10),
totalPrice decimal(20,2),
constraint pk_cartItem_cartLineId primary key (cartItemId),
constraint fk_cartItem_product_id foreign key (product_id) references product(product_id) on delete set null,
constraint fk_cartItem_userName foreign key (customerId) references customer(customerId) on delete cascade,
constraint fk_cartItem_cartId foreign key (cartId) references cart(cartId)on delete cascade 
);

7 //===============================card details======================================//
create table card(
card_id varchar,
customerId varchar not null ,
cardNumber varchar not null,
expiryMonth varchar not null,
expiryYear varchar not null,
cvNumber varchar not null ,
nameOnCard varchar not null,
totalCost decimal not null,
constraint pk_card_card_id primary key (card_id),
constraint fk_card_customerId foreign key (customerId) references customer(customerId) on delete set null
); 


8//=====================================shippingAddress===========================//
create table shippingAddress(
shippingAddress_id varchar,
customerId varchar,
apartmentNumber varchar not null,
streetName varchar not null,
city varchar not null,
state varchar not null,
country varchar not null,
zipCode varchar not null,
constraint pk_shippingAddress_shippingAddress_id primary key(shippingAddress_id),
constraint fk_shippingAddress_customerId foreign key (customerId) references customer(customerId) on delete cascade
);

9//======================================billingAddress==============================//
create table billingAddress(
billingAddress_id varchar,
customerId varchar,
apartmentNumber varchar not null,
streetName varchar not null,
city varchar not null,
state varchar not null,
country varchar not null,
zipCode varchar not null,
constraint pk_billingAddress_billingAddress_id primary key(billingAddress_id),
constraint fk_billingAddress_customerId foreign key (customerId) references customer(customerId) on delete cascade
);
10//=====================================order=====================================//
create table orderd(
order_id varchar,
customerId varchar ,
grandTotal decimal not null,
shippingAddress_id varchar not null,
billingAddress_id varchar not null,
constraint pk_order_order_id primary key (order_id),
constraint fk_order_customerId  foreign key(customerId) references customer(customerId) on delete set null
);
11//======================================orderItem=================================//

create table orderItems(
orderItems_id varchar,
customerId varchar,
product_id varchar,
totalPrice decimal not null,
quantity decimal not null,
constraint pk_orderItems_orderItems_id primary key (orderItems_id),
constraint fk_orderItems_customerId foreign key(customerId) references customer(customerId) on delete set null
); 


12//=====================================users=======================================//

create table users(
user_id varchar not null primary key,
username varchar not null ,
password varchar not null,
customerId varchar not null , 
enabled boolean not null,
constraint fk_users_customerId foreign key(customerId) references customer(customerId)
);
13//=====================================authoritytable=======================================//

create table authorities(
authorities_id varchar not null primary key,
username varchar not null,
authority varchar not null,
customerId varchar not null ,
constraint fk_authorities_username foreign key (username) references users(username),
constraint fk_authorities_customerId foreign key(customerId) references customer(customerId)
);
