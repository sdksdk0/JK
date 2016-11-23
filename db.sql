/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016/11/23 15:43:46                          */
/*==============================================================*/


alter table CONTRACT_PRODUCT_C
   drop constraint FK_CONTRACT_REFERENCE_CONTRACT;

alter table CONTRACT_PRODUCT_C
   drop constraint FK_CONTRACT_REFERENCE_FACTORY_;

alter table CONTRACT_PRODUCT_HIS_C
   drop constraint FK_CONTRACT_REFERENCE_CONTRAC2;

alter table EXPORT_PRODUCT_C
   drop constraint FK_EXPORT_P_REFERENCE_EXPORT_C;

alter table EXPORT_PRODUCT_C
   drop constraint FK_EXPORT_P_REFERENCE_FACTORY_;

alter table EXT_CPRODUCT_C
   drop constraint FK_EXT_CPRO_REFERENCE_FACTORY_;

alter table EXT_CPRODUCT_C
   drop constraint FK_EXT_CPRO_REFERENCE_CONTRAC2;

alter table EXT_CPRODUCT_HIS_C
   drop constraint FK_EXT_CPRO_REFERENCE_CONTRACT;

alter table EXT_EPRODUCT_C
   drop constraint FK_EXT_EPRO_REFERENCE_EXPORT_P;

alter table EXT_EPRODUCT_C
   drop constraint FK_EXT_EPRO_REFERENCE_FACTORY_;

alter table FINANCE_C
   drop constraint FK_FINANCE__REFERENCE_PACKING_;

alter table INVOICE_C
   drop constraint FK_INVOICE__REFERENCE_PACKING_;

alter table SHIPPING_ORDER_C
   drop constraint FK_SHIPPING_REFERENCE_PACKING_;

drop table CONTRACT_C cascade constraints;

drop table CONTRACT_HIS_C cascade constraints;

drop table CONTRACT_PRODUCT_C cascade constraints;

drop table CONTRACT_PRODUCT_HIS_C cascade constraints;

drop table EXPORT_C cascade constraints;

drop table EXPORT_PRODUCT_C cascade constraints;

drop table EXT_CPRODUCT_C cascade constraints;

drop table EXT_CPRODUCT_HIS_C cascade constraints;

drop table EXT_EPRODUCT_C cascade constraints;

drop table FACTORY_C cascade constraints;

drop table FINANCE_C cascade constraints;

drop table INVOICE_C cascade constraints;

drop table LOGIN_LOG_P cascade constraints;

drop table ONLINEINFO_T cascade constraints;

drop table PACKING_LIST_C cascade constraints;

drop table SHIPPING_ORDER_C cascade constraints;

drop table SYS_CODE_B cascade constraints;

/*==============================================================*/
/* Table: CONTRACT_C                                            */
/*==============================================================*/
create table CONTRACT_C 
(
   CONTRACT_ID          VARCHAR2(40)         not null,
   OFFEROR              VARCHAR2(200),
   CONTRACT_NO          VARCHAR2(50),
   SIGNING_DATE         TIMESTAMP,
   INPUT_BY             VARCHAR2(30),
   CHECK_BY             VARCHAR2(30),
   INSPECTOR            VARCHAR2(30),
   TOTAL_AMOUNT         NUMBER(10,2),
   IMPORT_NUM           INT,
   CREQUEST             VARCHAR2(2000),
   CUSTOM_NAME          VARCHAR2(200),
   DELIVERY_PERIOD      TIMESTAMP,
   SHIP_TIME            TIMESTAMP,
   TRADE_TERMS          VARCHAR2(30),
   REMARK               VARCHAR2(600),
   PRINT_STYLE          CHAR(1),
   OLD_STATE            INT,
   STATE                INT,
   OUT_STATE            INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   constraint PK_CONTRACT_C primary key (CONTRACT_ID)
);

comment on table CONTRACT_C is
'界面参考用户提供的《供销合同》
八个字段从《购销合同》中获取，加一个“总金额”冗余字段
四个字段从《出货表》中获取
六个控制字段
三个权限字段';

comment on column CONTRACT_C.CONTRACT_NO is
'自动产生';

comment on column CONTRACT_C.TOTAL_AMOUNT is
'冗余，自动计算，数量*单价';

comment on column CONTRACT_C.IMPORT_NUM is
'打印时标识几个星,对应说明中的内容
直接存放星星可以吗？可以CHAR(6)。但jsp页面jstl判断星星特殊字符失败。';

comment on column CONTRACT_C.CUSTOM_NAME is
'出处:出货表';

comment on column CONTRACT_C.DELIVERY_PERIOD is
'出处:出货表';

comment on column CONTRACT_C.SHIP_TIME is
'出处:出货表';

comment on column CONTRACT_C.TRADE_TERMS is
'出处:出货表';

comment on column CONTRACT_C.PRINT_STYLE is
'宽2:一页两个货物  窄1:一页一个货物';

comment on column CONTRACT_C.OLD_STATE is
'归档前状态, 方便回退';

comment on column CONTRACT_C.STATE is
'0草稿 1已上报待报运

归档后, 其他选择合同的地方均去除.
表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况';

comment on column CONTRACT_C.OUT_STATE is
'0未走货 1部分 2全部

归档后, 其他选择合同的地方均去除.
表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况';

/*==============================================================*/
/* Table: CONTRACT_HIS_C                                        */
/*==============================================================*/
create table CONTRACT_HIS_C 
(
   CONTRACT_ID          VARCHAR2(40)         not null,
   OFFEROR              VARCHAR2(200),
   CONTRACT_NO          VARCHAR2(50),
   SIGNING_DATE         TIMESTAMP,
   INPUT_BY             VARCHAR2(30),
   CHECK_BY             VARCHAR2(30),
   INSPECTOR            VARCHAR2(30),
   TOTAL_AMOUNT         NUMBER(10,2),
   IMPORT_NUM           CHAR(6),
   CREQUEST             VARCHAR2(2000),
   CUSTOM_NAME          VARCHAR2(200),
   DELIVERY_PERIOD      TIMESTAMP,
   SHIP_TIME            TIMESTAMP,
   TRADE_TERMS          VARCHAR2(30),
   REMARK               VARCHAR2(600),
   PRINT_STYLE          CHAR(1),
   OLD_STATE            INT,
   STATE                INT,
   OUT_STATE            INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   constraint PK_CONTRACT_HIS_C primary key (CONTRACT_ID)
);

comment on table CONTRACT_HIS_C is
'历史表就换表名，主键、其他字段都不改变；方便记录“转移”

Mapper映射文件就和合同差个表名，无需创建po对象，利用合同的';

comment on column CONTRACT_HIS_C.CONTRACT_NO is
'自动产生';

comment on column CONTRACT_HIS_C.TOTAL_AMOUNT is
'冗余';

comment on column CONTRACT_HIS_C.IMPORT_NUM is
'打印时标识几个星,对应说明中的内容';

comment on column CONTRACT_HIS_C.PRINT_STYLE is
'宽2:一页两个货物  窄1:一页一个货物';

comment on column CONTRACT_HIS_C.OLD_STATE is
'归档前状态, 方便回退';

comment on column CONTRACT_HIS_C.STATE is
'0草稿 1已上报待报运

归档后, 其他选择合同的地方均去除.
表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况';

comment on column CONTRACT_HIS_C.OUT_STATE is
'0未走货 1部分 2全部

归档后, 其他选择合同的地方均去除.
表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况';

/*==============================================================*/
/* Table: CONTRACT_PRODUCT_C                                    */
/*==============================================================*/
create table CONTRACT_PRODUCT_C 
(
   CONTRACT_PRODUCT_ID  VARCHAR2(40)         not null,
   CONTRACT_ID          VARCHAR2(40),
   FACTORY_ID           VARCHAR2(40),
   FACTORY_NAME         VARCHAR2(50),
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   CNUMBER              INT,
   OUT_NUMBER           INT,
   LOADING_RATE         VARCHAR2(10),
   BOX_NUM              INT,
   PACKING_UNIT         VARCHAR2(10),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   FINISHED             INT,
   EXTS                 VARCHAR2(50),
   ORDER_NO             INT,
   constraint PK_CONTRACT_PRODUCT_C primary key (CONTRACT_PRODUCT_ID)
);

comment on table CONTRACT_PRODUCT_C is
'装率和箱数报运业务使用，合同业务不使用。';

comment on column CONTRACT_PRODUCT_C.FACTORY_NAME is
'冗余';

comment on column CONTRACT_PRODUCT_C.OUT_NUMBER is
'分次走货';

comment on column CONTRACT_PRODUCT_C.LOADING_RATE is
'报运业务使用X/Y';

comment on column CONTRACT_PRODUCT_C.BOX_NUM is
'报运业务使用=数量除以装率的分母，不够进位为整数
先将玻璃杯装小纸箱子，然后在装集装箱';

comment on column CONTRACT_PRODUCT_C.PACKING_UNIT is
'PCS/SETS';

comment on column CONTRACT_PRODUCT_C.AMOUNT is
'冗余 自动计算: 数量x单价';

comment on column CONTRACT_PRODUCT_C.FINISHED is
'0未完成1完成';

comment on column CONTRACT_PRODUCT_C.EXTS is
'冗余，出处：出货表
附件对应SYS_CODE中的附件分类名称，多个用换行符隔开，没有附件是写无。附件分类相同时合并。';

/*==============================================================*/
/* Table: CONTRACT_PRODUCT_HIS_C                                */
/*==============================================================*/
create table CONTRACT_PRODUCT_HIS_C 
(
   CONTRACT_PRODUCT_ID  VARCHAR2(40)         not null,
   CONTRACT_ID          VARCHAR2(40),
   FACTORY_ID           VARCHAR2(40),
   FACTORY_NAME         VARCHAR2(50),
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   CNUMBER              INT,
   OUT_NUMBER           INT,
   LOADING_RATE         VARCHAR2(10),
   BOX_NUM              INT,
   PACKING_UNIT         VARCHAR2(10),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   FINISHED             INT,
   ORDER_NO             INT,
   constraint PK_CONTRACT_PRODUCT_HIS_C primary key (CONTRACT_PRODUCT_ID)
);

comment on column CONTRACT_PRODUCT_HIS_C.FACTORY_NAME is
'冗余';

comment on column CONTRACT_PRODUCT_HIS_C.OUT_NUMBER is
'分次走货';

comment on column CONTRACT_PRODUCT_HIS_C.LOADING_RATE is
'报运业务使用X/Y';

comment on column CONTRACT_PRODUCT_HIS_C.BOX_NUM is
'报运业务使用=数量除以装率的分母，不够进位为整数
先将玻璃杯装小纸箱子，然后在装集装箱';

comment on column CONTRACT_PRODUCT_HIS_C.PACKING_UNIT is
'PCS/SETS';

comment on column CONTRACT_PRODUCT_HIS_C.AMOUNT is
'冗余 自动计算: 数量x单价';

comment on column CONTRACT_PRODUCT_HIS_C.FINISHED is
'0未完成1完成';

/*==============================================================*/
/* Table: EXPORT_C                                              */
/*==============================================================*/
create table EXPORT_C 
(
   EXPORT_ID            VARCHAR2(40)         not null,
   INPUT_DATE           TIMESTAMP,
   CONTRACT_IDS         VARCHAR2(500),
   CUSTOMER_CONTRACT    VARCHAR2(200),
   LCNO                 VARCHAR2(10),
   CONSIGNEE            VARCHAR2(100),
   MARKS                VARCHAR2(1000),
   REMARK               VARCHAR2(100),
   SHIPMENT_PORT        VARCHAR2(100),
   DESTINATION_PORT     VARCHAR2(100),
   TRANSPORT_MODE       VARCHAR2(10),
   PRICE_CONDITION      VARCHAR2(10),
   STATE                INT,
   GROSS_WEIGHT         NUMBER(5,2),
   NET_WEIGHT           NUMBER(5,2),
   MEASUREMENT          NUMBER(8,2),
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   constraint PK_EXPORT_C primary key (EXPORT_ID)
);

comment on table EXPORT_C is
'一个报运单由多个合同来
简化设计，不建立直接一对多关联。利用CONTRACT_IDS记录关联关系。

打断设计，实现跳跃查询';

comment on column EXPORT_C.CONTRACT_IDS is
'ID集合串

x,y,z';

comment on column EXPORT_C.CUSTOMER_CONTRACT is
'客户的合同号,可选择多个合同';

comment on column EXPORT_C.LCNO is
'信用证号L/C T/T';

comment on column EXPORT_C.TRANSPORT_MODE is
'SEA/AIR';

comment on column EXPORT_C.PRICE_CONDITION is
'FOB/CIF';

comment on column EXPORT_C.STATE is
'0-草稿 1-已上报 2-装箱 3-委托 4-发票 5-财务';

comment on column EXPORT_C.GROSS_WEIGHT is
'冗余，为委托服务，一个报运的总毛重';

comment on column EXPORT_C.NET_WEIGHT is
'冗余，为委托服务，一个报运的总净重

';

comment on column EXPORT_C.MEASUREMENT is
'冗余，为委托服务，一个报运的总体积

=长x高x宽/100 00 00

cm转换为m3 立方米

';

/*==============================================================*/
/* Table: EXPORT_PRODUCT_C                                      */
/*==============================================================*/
create table EXPORT_PRODUCT_C 
(
   EXPORT_PRODUCT_ID    VARCHAR2(40)         not null,
   EXPORT_ID            VARCHAR2(40),
   FACTORY_ID           VARCHAR2(40),
   FACTORY_NAME         VARCHAR2(50),
   PRODUCT_NO           VARCHAR2(50),
   PACKING_UNIT         VARCHAR2(10),
   CNUMBER              INT,
   BOX_NUM              INT,
   GROSS_WEIGHT         NUMBER(8,2),
   NET_WEIGHT           NUMBER(8,2),
   SIZE_LENGTH          NUMBER(8,2),
   SIZE_WIDTH           NUMBER(8,2),
   SIZE_HEIGHT          NUMBER(8,2),
   EX_PRICE             NUMBER(8,2),
   PRICE                NUMBER(10,2),
   TAX                  NUMBER(8,2),
   ORDER_NO             INT,
   constraint PK_EXPORT_PRODUCT_C primary key (EXPORT_PRODUCT_ID)
);

comment on column EXPORT_PRODUCT_C.FACTORY_NAME is
'冗余';

comment on column EXPORT_PRODUCT_C.PACKING_UNIT is
'PCS/SETS';

comment on column EXPORT_PRODUCT_C.CNUMBER is
'分次走货在此体现';

comment on column EXPORT_PRODUCT_C.BOX_NUM is
'就是合同中的箱数';

comment on column EXPORT_PRODUCT_C.EX_PRICE is
'sales confirmation 中的价格（手填）';

/*==============================================================*/
/* Table: EXT_CPRODUCT_C                                        */
/*==============================================================*/
create table EXT_CPRODUCT_C 
(
   EXT_CPRODUCT_ID      VARCHAR2(40)         not null,
   CONTRACT_PRODUCT_ID  VARCHAR2(40),
   FACTORY_ID           VARCHAR2(40),
   FACTORY_NAME         VARCHAR2(50),
   CTYPE                INT,
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   CNUMBER              INT,
   PACKING_UNIT         VARCHAR2(10),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   PRODUCT_REQUEST      VARCHAR2(2000),
   ORDER_NO             INT,
   constraint PK_EXT_CPRODUCT_C primary key (EXT_CPRODUCT_ID)
);

comment on table EXT_CPRODUCT_C is
'附件和货物的不同：多了附件类型和要求；同时货物从属合同，附件从属货物。';

comment on column EXT_CPRODUCT_C.FACTORY_NAME is
'冗余';

comment on column EXT_CPRODUCT_C.CTYPE is
'SYS_CODE_B 0104';

comment on column EXT_CPRODUCT_C.AMOUNT is
'自动计算: 数量x单价';

/*==============================================================*/
/* Table: EXT_CPRODUCT_HIS_C                                    */
/*==============================================================*/
create table EXT_CPRODUCT_HIS_C 
(
   EXT_CPRODUCT_ID      VARCHAR2(40)         not null,
   CONTRACT_PRODUCT_ID  VARCHAR2(40),
   FACTORY_ID           VARCHAR2(40),
   FACTORY_NAME         VARCHAR2(50),
   CTYPE                INT,
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   CNUMBER              INT,
   PACKING_UNIT         VARCHAR2(10),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   PRODUCT_REQUEST      VARCHAR2(2000),
   ORDER_NO             INT,
   constraint PK_EXT_CPRODUCT_HIS_C primary key (EXT_CPRODUCT_ID)
);

comment on column EXT_CPRODUCT_HIS_C.FACTORY_NAME is
'冗余';

comment on column EXT_CPRODUCT_HIS_C.CTYPE is
'SYS_CODE_B 0104';

comment on column EXT_CPRODUCT_HIS_C.PACKING_UNIT is
'PCS/SETS';

comment on column EXT_CPRODUCT_HIS_C.AMOUNT is
'自动计算: 数量x单价';

/*==============================================================*/
/* Table: EXT_EPRODUCT_C                                        */
/*==============================================================*/
create table EXT_EPRODUCT_C 
(
   EXT_EPRODUCT_ID      VARCHAR2(40)         not null,
   EXPORT_PRODUCT_ID    VARCHAR2(40),
   FACTORY_ID           VARCHAR2(40),
   FACTORY_NAME         VARCHAR2(50),
   CTYPE                INT,
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   CNUMBER              INT,
   PACKING_UNIT         VARCHAR2(10),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   PRODUCT_REQUEST      VARCHAR2(2000),
   ORDER_NO             INT,
   constraint PK_EXT_EPRODUCT_C primary key (EXT_EPRODUCT_ID)
);

comment on table EXT_EPRODUCT_C is
'直接复制合同附件表，整表冗余；加速后续业务读取数据
设计简单，方便适应需求变化';

comment on column EXT_EPRODUCT_C.FACTORY_NAME is
'冗余';

comment on column EXT_EPRODUCT_C.CTYPE is
'SYS_CODE_B 0104';

comment on column EXT_EPRODUCT_C.PACKING_UNIT is
'PCS/SETS';

comment on column EXT_EPRODUCT_C.AMOUNT is
'自动计算: 数量x单价';

/*==============================================================*/
/* Table: FACTORY_C                                             */
/*==============================================================*/
create table FACTORY_C 
(
   FACTORY_ID           VARCHAR2(40)         not null,
   FULL_NAME            VARCHAR2(200),
   FACTORY_NAME         VARCHAR2(50),
   CONTACTS             VARCHAR2(30),
   PHONE                VARCHAR2(20),
   MOBILE               VARCHAR2(20),
   FAX                  VARCHAR2(20),
   NOTE                 VARCHAR2(1000),
   INSPECTOR            VARCHAR2(30),
   STATE                CHAR(1),
   ORDER_NO             INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   constraint PK_FACTORY_C primary key (FACTORY_ID)
);

comment on column FACTORY_C.STATE is
'1正常0停用';

comment on column FACTORY_C.ORDER_NO is
'
';

/*==============================================================*/
/* Table: FINANCE_C                                             */
/*==============================================================*/
create table FINANCE_C 
(
   FINANCE_ID           VARCHAR2(40)         not null,
   INPUT_DATE           TIMESTAMP,
   INPUT_BY             VARCHAR2(30),
   STATE                INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   constraint PK_FINANCE_C primary key (FINANCE_ID)
);

comment on table FINANCE_C is
'和装箱单一对一';

comment on column FINANCE_C.STATE is
'0草稿 1已上报';

/*==============================================================*/
/* Table: INVOICE_C                                             */
/*==============================================================*/
create table INVOICE_C 
(
   INVOICE_ID           VARCHAR2(40)         not null,
   SC_NO                VARCHAR2(100),
   BL_NO                VARCHAR2(100),
   TRADE_TERMS          VARCHAR2(100),
   STATE                INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   constraint PK_INVOICE_C primary key (INVOICE_ID)
);

comment on table INVOICE_C is
'和装箱单一对一';

comment on column INVOICE_C.INVOICE_ID is
'PACKING_LIST_ID值';

comment on column INVOICE_C.SC_NO is
'packing.getExportNos S/C就是报运的合同号';

comment on column INVOICE_C.STATE is
'0草稿 1已上报';

/*==============================================================*/
/* Table: LOGIN_LOG_P                                           */
/*==============================================================*/
create table LOGIN_LOG_P 
(
   LOGIN_LOG_ID         VARCHAR2(40)         not null,
   LOGIN_NAME           VARCHAR2(50),
   IP_ADDRESS           VARCHAR2(20),
   LOGIN_TIME           TIMESTAMP,
   constraint PK_LOGIN_LOG_P primary key (LOGIN_LOG_ID)
);

/*==============================================================*/
/* Table: ONLINEINFO_T                                          */
/*==============================================================*/
create table ONLINEINFO_T 
(
   A1                   CHAR(2)              not null,
   constraint PK_ONLINEINFO_T primary key (A1)
);

/*==============================================================*/
/* Table: PACKING_LIST_C                                        */
/*==============================================================*/
create table PACKING_LIST_C 
(
   PACKING_LIST_ID      VARCHAR2(40)         not null,
   SELLER               VARCHAR2(200),
   BUYER                VARCHAR2(200),
   INVOICE_NO           VARCHAR2(30),
   INVOICE_DATE         TIMESTAMP,
   MARKS                VARCHAR2(200),
   DESCRIPTIONS         VARCHAR2(200),
   EXPORT_IDS           VARCHAR2(200),
   EXPORT_NOS           VARCHAR2(200),
   STATE                INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   constraint PK_PACKING_LIST_C primary key (PACKING_LIST_ID)
);

comment on table PACKING_LIST_C is
'选择多个报运建立一个装箱';

comment on column PACKING_LIST_C.EXPORT_IDS is
'报运ID集合';

comment on column PACKING_LIST_C.EXPORT_NOS is
'报运NO集合x,y|z,h';

comment on column PACKING_LIST_C.STATE is
'0草稿 1已上报';

/*==============================================================*/
/* Table: SHIPPING_ORDER_C                                      */
/*==============================================================*/
create table SHIPPING_ORDER_C 
(
   SHIPPING_ORDER_ID    VARCHAR2(40)         not null,
   ORDER_TYPE           CHAR(6),
   SHIPPER              VARCHAR2(200),
   CONSIGNEE            VARCHAR2(200),
   NOTIFY_PARTY         VARCHAR2(200),
   LC_NO                VARCHAR2(30),
   PORT_OF_LOADING      VARCHAR2(30),
   PORT_OF_TRANS        VARCHAR2(30),
   PORT_OF_DISCHARGE    VARCHAR2(30),
   LOADING_DATE         TIMESTAMP,
   LIMIT_DATE           TIMESTAMP,
   IS_BATCH             CHAR(1),
   IS_TRANS             CHAR(1),
   COPY_NUM             VARCHAR2(20),
   CNOTE                VARCHAR2(200),
   SPECIAL_CONDITION    VARCHAR2(200),
   FREIGHT              VARCHAR2(200),
   CHECK_BY             VARCHAR2(30),
   STATE                INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   constraint PK_SHIPPING_ORDER_C primary key (SHIPPING_ORDER_ID)
);

comment on table SHIPPING_ORDER_C is
'一个委托来自一个装箱';

comment on column SHIPPING_ORDER_C.SHIPPING_ORDER_ID is
'等于PACKING_LIST_ID';

comment on column SHIPPING_ORDER_C.ORDER_TYPE is
'SEA海运AIR空运';

comment on column SHIPPING_ORDER_C.IS_BATCH is
'1是0否';

comment on column SHIPPING_ORDER_C.IS_TRANS is
'1是0否';

comment on column SHIPPING_ORDER_C.STATE is
'0草稿 1已上报';

/*==============================================================*/
/* Table: SYS_CODE_B                                            */
/*==============================================================*/
create table SYS_CODE_B 
(
   SYS_CODE_ID          VARCHAR2(40)         not null,
   NAME                 VARCHAR2(100),
   PARENT_ID            VARCHAR2(40),
   PARENT_NAME          VARCHAR2(100),
   LAYER_NUM            INT,
   IS_LEAF              INT,
   QUOTE_NUM            INT,
   CNOTE                VARCHAR2(100),
   ICO                  VARCHAR2(20),
   ORDER_NO             INT,
   STATE                CHAR(1),
   CREATED_BY           VARCHAR2(40),
   CREATED_TIME         TIMESTAMP,
   UPDATED_BY           VARCHAR2(40),
   UPDATED_TIME         TIMESTAMP,
   constraint PK_SYS_CODE_B primary key (SYS_CODE_ID)
);

comment on table SYS_CODE_B is
'数据字典';

comment on column SYS_CODE_B.STATE is
'0停用1启用';

alter table CONTRACT_PRODUCT_C
   add constraint FK_CONTRACT_REFERENCE_CONTRACT foreign key (CONTRACT_ID)
      references CONTRACT_C (CONTRACT_ID);

alter table CONTRACT_PRODUCT_C
   add constraint FK_CONTRACT_REFERENCE_FACTORY_ foreign key (FACTORY_ID)
      references FACTORY_C (FACTORY_ID);

alter table CONTRACT_PRODUCT_HIS_C
   add constraint FK_CONTRACT_REFERENCE_CONTRAC2 foreign key (CONTRACT_ID)
      references CONTRACT_HIS_C (CONTRACT_ID);

alter table EXPORT_PRODUCT_C
   add constraint FK_EXPORT_P_REFERENCE_EXPORT_C foreign key (EXPORT_ID)
      references EXPORT_C (EXPORT_ID);

alter table EXPORT_PRODUCT_C
   add constraint FK_EXPORT_P_REFERENCE_FACTORY_ foreign key (FACTORY_ID)
      references FACTORY_C (FACTORY_ID);

alter table EXT_CPRODUCT_C
   add constraint FK_EXT_CPRO_REFERENCE_FACTORY_ foreign key (FACTORY_ID)
      references FACTORY_C (FACTORY_ID);

alter table EXT_CPRODUCT_C
   add constraint FK_EXT_CPRO_REFERENCE_CONTRAC2 foreign key (CONTRACT_PRODUCT_ID)
      references CONTRACT_PRODUCT_C (CONTRACT_PRODUCT_ID);

alter table EXT_CPRODUCT_HIS_C
   add constraint FK_EXT_CPRO_REFERENCE_CONTRACT foreign key (CONTRACT_PRODUCT_ID)
      references CONTRACT_PRODUCT_HIS_C (CONTRACT_PRODUCT_ID);

alter table EXT_EPRODUCT_C
   add constraint FK_EXT_EPRO_REFERENCE_EXPORT_P foreign key (EXPORT_PRODUCT_ID)
      references EXPORT_PRODUCT_C (EXPORT_PRODUCT_ID);

alter table EXT_EPRODUCT_C
   add constraint FK_EXT_EPRO_REFERENCE_FACTORY_ foreign key (FACTORY_ID)
      references FACTORY_C (FACTORY_ID);

alter table FINANCE_C
   add constraint FK_FINANCE__REFERENCE_PACKING_ foreign key (FINANCE_ID)
      references PACKING_LIST_C (PACKING_LIST_ID);

alter table INVOICE_C
   add constraint FK_INVOICE__REFERENCE_PACKING_ foreign key (INVOICE_ID)
      references PACKING_LIST_C (PACKING_LIST_ID);

alter table SHIPPING_ORDER_C
   add constraint FK_SHIPPING_REFERENCE_PACKING_ foreign key (SHIPPING_ORDER_ID)
      references PACKING_LIST_C (PACKING_LIST_ID);

