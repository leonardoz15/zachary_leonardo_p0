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


-----------------------------------------------------------------------------------------




select * from account;
select * from loan;
select * from banking;

call reset_all();

create or replace procedure reset_all()
as 
$$
begin 
	delete from account;
	delete from banking;
	perform setval('public.account_account_id_seq', 1, false);
	perform setval('public.banking_banking_id_seq', 1, false);
end;
$$ language plpgsql;
