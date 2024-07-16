--제품코드 관리정보 관리시스템
--제품코드 관리: 코드, 제조사명, 등록일시
create table product_code (
code       varchar2(4) constraint product_code_pk primary key,
maker      varchar2(50) not null,
reg_date   date default sysdate
);

desc product_code;
insert into product_code (code, maker)
values ('A100', '삼성전자');
insert into product_code (code, maker)
values ('B100', 'LG전자');
commit;

select * from product_code;

update product_code set reg_date = '2019-10-31';
commit;




