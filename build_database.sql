CREATE TABLE Account (
  "account_id" serial primary key,
  "username" text,
  "password" text
);

CREATE TABLE Loan (
  "loan_id" serial primary key,
  "principal" int,
  "min_credit" numeric(3,0)
);

CREATE TABLE Banking (
  "banking_id" serial primary key,
  "account_id" int,
  "loan_id" int,
  "current_balance" int,
  "credit_score" numeric(3,0)
);

alter table Banking add constraint FK_account_id
foreign key (account_id) references Account (account_id) on delete cascade on update cascade;

alter table Banking add constraint FK_loan_id
foreign key (loan_id) references Loan (loan_id) on delete cascade on update cascade;

insert into account (username,password) values ('zach','pass');

insert into loan (principal, min_credit) values (10000, 600);

insert into banking (account_id,loan_id,current_balance,credit_score) values (1, null, 100, 700);

insert into account (username,password) values ('wowow','pass');

delete from account where username = 'wowow' and password = 'pass';
select * from account;
select * from loan;
select * from banking;
select pg_get_serial_sequence('account','account_id');
select setval('public.account_account_id_seq', 1, false);