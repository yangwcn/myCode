create table tb_order (orderid int primary key auto_increment, username varchar(20) not null);

alter table tb_order add constraint  'orderhold' foreign key (username) references user(name);

delimiter //
create trigger tborderuser
after insert on tb_order for each row
begin
  declare usercount int;
  select count(1) into usercount where name = new.username;
  if usercount < 1
  then
    insert into user values (new.username,new.username);
  end if;
end
delimiter;

create table student (
  id varchar(10)  not null,
  name varchar(10) not null
)
insert into student values ('s1','yangw');
insert into student values ('s2','yangwcn');
insert into student values ('s3','yangw3');
insert into student values ('s4','yangw4');
create table course (
  id varchar(10) not null,
  name varchar(10) not null,
  teacher varchar(10) not null
)
insert into course values ('c1','course1','t1');
insert into course values ('c2','course2','t2');

create table sc (
  sid varchar(10) not null,
  cid varchar(10) not null,
  score int not null
)
insert into sc values ('s1','c1', 60);
insert into sc values ('s2','c1', 50);
insert into sc values ('s3','c1', 30);
insert into sc values ('s4','c1', 40);

insert into sc values ('s1','c2', 60);
insert into sc values ('s2','c2', 50);
insert into sc values ('s3','c2', 30);
insert into sc values ('s4','c2', 30);


create table teacher (
  id varchar(10) not null,
  name varchar(10) not null
)
insert into teacher values ('t1','tyangw');
insert into teacher values ('t2','tyangwcn');

select sc.sid,s.name,sc.cid,sum(sc.score) from sc sc join student s on s.id = sc.sid group by sid having sum(sc.score) <> 100
join student on s.id = sc.sid

select * from sc sc join student s on s.id = sc.sid group by sid

select distinct(sc.sid) from course c,teacher t,sc sc where t.id = c.teacher and c.id = sc.cid and t.name = 'tyangw';

select * from student s,sc sc where s.id = sc.sid group by sc.sid having sum(sc.score) > 100;
select sc.sid from sc sc where sum(sc) > 100

create table city (
 city_code varchar(10) not null,
 city_name varchar(10) not null
)

insert into city values ('1001','beijing');
insert into city values ('1002','shanghai');
insert into city values ('1003','tianjin');

create procedure select_user(in u_name varchar(20))
 begin
  select * from user where name = u_name;
  end