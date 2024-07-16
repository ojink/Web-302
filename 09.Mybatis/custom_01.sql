/*
2. 업무 요건
 - 입력정보 요건에 따라 입력 테이블인 회원 테이블 생성하시오.
 - 회원 테이블 샘플데이터를 참조하여 생성하시오.
2-1) 회원정보 명세서 (테이블 명 : custom_01)
순서 컬럼ID 컬럼명 형태 길이 NULL 비고
1 p_id 회원ID varchar2 10 NOT NULL Primary Key
2 p_pw 비번 varchar2 10
3 c_name 회원명 varchar2 20
4 c_email email varchar2 20
5 c_tel 연락처 varchar2 14
*/
회원 테이블 생성
create table custom_01 (
p_id     varchar2(10) constraint custom_id_pk primary key,
p_pw     varchar2(10),
c_name   varchar2(20),
c_email  varchar2(20),
c_tel    varchar2(14)
);

/*
 회원정보 샘플 데이터
회원ID 비번 회원명 email 연락처
aaa 1234 김회원 aaa@korea.com 010-1111-1111
bbb 1234 이회원 bbb@korea.com 010-1111-1112
ddd 1234 오회원 ddd@korea.com 010-1111-1114
eee 1234 최회원 eee@korea.com 010-1111-1115
fff 1234 조회원 fff@korea.com 010-1111-1116
*/
insert into custom_01
values ( 'aaa', '1234', '김회원', 'aaa@korea.com', '010-1111-1111'  );

insert into custom_01
values ( 'bbb', '1234', '이회원', 'bbb@korea.com', '010-1111-1112'  );

insert into custom_01
values ( 'ddd', '1234', '오회원', 'ddd@korea.com', '010-1111-1114'  );

insert into custom_01
values ( 'eee', '1234', '최회원', 'eee@korea.com', '010-1111-1115'  );

insert into custom_01
values ( 'fff', '1234', '조회원', 'fff@korea.com', '010-1111-1116'  );
commit;

select * from custom_01;
