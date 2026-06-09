create database `nitte2026`;
use nitte2026;
create table creditcard(
card_no bigint not null primary key,
card_holder varchar(255) not null,
card_limit int not null,card_status varchar(255) default 'active');
describe creditcard;
create table merchant(
merchant_id int not null primary key, 
merchant_name varchar(255) not null,
merchant_account bigint not null
);
describe merchant;
create table transactions(
	t_id bigint not null primary key auto_increment,
    t_date date not null, t_amount double not null,
    t_by bigint not null, t_to int not null, 
    foreign key(t_by) references creditcard(card_no),
    foreign key(t_to) references merchant(merchant_id)
);
describe transactions;

insert into creditcard values(87656765665654,'Razak Mohamed',120000,'active');
insert into creditcard values(45678567834444,'Prem Kumar',80000,'active');
insert into creditcard values(98765456765653,'Patrick',25000,'closed');

insert into merchant values(1234,'Arun',8765677656455);
insert into merchant values(4755,'Sridhar',9876567876784);
insert into merchant values(9893,'Venkat',567546466464646);

insert into transactions values(20260624,now(),7800.4,45678567834444,1234);
insert into transactions values(20260629,now(),25.0,87656765665654,9893);
insert into transactions values(20251021,now(),450000.8,98765456765653,4755);
insert into transactions values(20260110,now(),200.5,87656765665654,1234);

select * from transactions;
DQL where
select * from creditcard where card_no=98765456765653;
select * from transactions where t_by=87656765665654;

select * from transactions inner join merchant on merchant.merchant_id=transactions.t_to where t_by=87656765665654;
select t_amount,t_date,merchant.merchant_name from transactions inner join merchant on merchant.merchant_id=transactions.t_to where t_by=87656765665654;