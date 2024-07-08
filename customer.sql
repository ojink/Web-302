-- 고객관리
CREATE TABLE customer (
    ID      NUMBER CONSTRAINT customer_id_pk PRIMARY KEY,
    NAME    VARCHAR2(50) NOT NULL,
    GENDER  VARCHAR2(3) DEFAULT '남' NOT NULL,
    PHONE   VARCHAR2(13),
    EMAIL   VARCHAR2(50)
);

INSERT INTO customer(id, name)
VALUES  (1, '홍길동');

--customer 테이블의 pk인 id컬럼에 적용할 시퀀스
CREATE SEQUENCE seq_customer
START WITH 2 increment by 1 NOCACHE;

-- customer 테이블의 pk인 id컬럼에 시퀀스 자동적용할 트리거
-- :old, :new
CREATE or replace TRIGGER trg_customer
    before insert on customer -- 시점
    for each row
begin
    select seq_customer.nextval into :new.id from dual;
end;
/

INSERT INTO customer( id, name )
VALUES  ( seqcustomer.nextval, '박문수' );

SELECT * FROM customer;





