Drop table if exists customers;
Drop table if exists books;
Drop table if exists loans;

create table customers (
  CID Int(4),
  CNAME varchar(20),
  LOANPERIOD Int(3),
  primary key (CID)

)  Engine=InnoDB;

insert into customers (CID, CNAME, LOANPERIOD) values (1, "John", 10);
insert into customers (CID, CNAME, LOANPERIOD) values (2, "Tom", 20);
insert into customers (CID, CNAME, LOANPERIOD) values (3, "Fred", 30);

create table books (
  BID Int(4),
  TITLE varchar(40),
  AUTHOR varchar(30),
  primary key (BID)

)  Engine=InnoDB;

insert into books (BID, TITLE, AUTHOR) values (100, "The Da Vinci Code", "Dan Brown");
insert into books (BID, TITLE, AUTHOR) values (101, "The Boy in the Striped Pyjamas", "John Boyne");
insert into books (BID, TITLE, AUTHOR) values (102, "Mayday", "Thomas Block");
insert into books (BID, TITLE, AUTHOR) values (103, "Runaway Jury", "John Grisham");
insert into books (BID, TITLE, AUTHOR) values (104, "Big Maggie", "John B. Keane");

create table loans
(
  LID           int                                                        not null,
  BID           int                                                        not null,
  CID           int                                                        not null,    
  DUEDATE       date                                                       not null
) engine = InnoDB;

insert into loans (LID, BID, CID, DUEDATE) values (2000, 100, 2, "2019-10-04");
insert into loans (LID, BID, CID, DUEDATE) values (2001, 101, 2, "2019-11-01");
insert into loans (LID, BID, CID, DUEDATE) values (2002, 104, 2, "2019-11-04");
insert into loans (LID, BID, CID, DUEDATE) values (2003, 103, 3, "2019-11-27");


