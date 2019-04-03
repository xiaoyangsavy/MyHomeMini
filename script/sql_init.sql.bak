DROP DATABASE IF EXISTS myhome;

CREATE DATABASE myhome ;

USE myhome ;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS permission;
DROP TABLE IF EXISTS role_permission;
DROP TABLE IF EXISTS finance;
DROP TABLE IF EXISTS cash_log;
DROP TABLE IF EXISTS expenses_log;
DROP TABLE IF EXISTS expenses_main_type;
DROP TABLE IF EXISTS expenses_sub_type;
DROP TABLE IF EXISTS invest;
DROP TABLE IF EXISTS invest_type;
DROP TABLE IF EXISTS invest_log;
DROP TABLE IF EXISTS fixed_asset;
DROP TABLE IF EXISTS fixed_asset_type;
DROP TABLE IF EXISTS liabilities;
DROP TABLE IF EXISTS liabilities_type;
DROP TABLE IF EXISTS liabilities_log;
DROP TABLE IF EXISTS lender;
DROP TABLE IF EXISTS contribution_log;
 

 
/*==============================================================*/
/* Table: user     用户表                                     */
/*==============================================================*/
create table user
(
   user_id		int		not null	AUTO_INCREMENT	COMMENT '用户编号',
   user_name		varchar(45)     not null			COMMENT '用户名',
   password		varchar(45)     not null			COMMENT '密码',
   role_id		int             not null			COMMENT '角色编号',
   name			varchar(45)	default NULL			COMMENT '姓名',
   sex			VARCHAR(2)					COMMENT '性别',
   phone		varchar(11)	default NULL			COMMENT '手机号',
   email		varchar(45)	NOT NULL default ''		COMMENT '邮箱地址',
   last_login_date      datetime					COMMENT '最后登录时间',
   primary key (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户表';


/*==============================================================*/
/* Table: role    角色表                                */
/*==============================================================*/
create table role
(
   role_id		int		not null			COMMENT '角色编号',
   role_name		varchar(45)	default NULL			COMMENT '角色名',
   description		varchar(255)					COMMENT '角色描述',
   primary key (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色表';


/*==============================================================*/
/* Table: permission   权限表                           */
/*==============================================================*/
create table permission
(
   permission_id	int		not null			COMMENT '权限编号',
   permission_name	varchar(45)			default NULL	COMMENT '权限名',
   description		varchar(255)					COMMENT '描述' ,
   primary key (permission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '权限表';


/*==============================================================*/
/* Table: role_permission       角色-权限中间表                           */
/*==============================================================*/
create table role_permission
(
   role_id		int		not null	default 0	COMMENT '角色编号',
   permission_id	int		not null	default 0	COMMENT '权限编号',
   primary key (role_id, permission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色-权限中间表';

 

/*==============================================================*/
/* Table: finance		财务表	                              */
/*==============================================================*/
create table finance
(
   user_id		int	 				COMMENT '用户编号',
   cash			decimal(10,2)	 			COMMENT '现金',
   invest		decimal(10,2)	 			COMMENT '投资',
   liabilities		decimal(10,2)	 			COMMENT '债务',
   fixed_asset		decimal(10,2)	 			COMMENT '固定资产',
   contribution		int		 			COMMENT '贡献度',
   primary key (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '财务表';

/*==============================================================*/
/* Table: cash_log	         现金日志表                      */
/*==============================================================*/
create table cash_log
(				
   log_id		int		AUTO_INCREMENT			COMMENT '日志编号',
   cash_type		int		default 1			COMMENT '现金收支类型',
   cash_amount		decimal(10,2)	default '0.00'			COMMENT '数目（含正负）',
   operate_user		int		not null			COMMENT '操作人',
   operate_date		datetime	not null			COMMENT '操作时间',
   primary key (log_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '现金日志表';

 /*==============================================================*/
/* Table: expenses_log	        开销表                       */
/*==============================================================*/
create table expenses_log
(
   expenses_id		int		AUTO_INCREMENT			COMMENT '开销编号',
   expenses_name	VARCHAR(100)					COMMENT '开销名',
   expenses_type	int		default 1			COMMENT '开销类型，对应的子类编号',
   expenses_amount	decimal(10,2)	default '0.00'			COMMENT '开销数目',
   expenses_date	datetime	not null			COMMENT '花费日期',
   expenses_user	int		not null			COMMENT '花费人',
   operate_user		int		not null			COMMENT '操作人',
   operate_date		datetime	not null			COMMENT '操作时间',
   primary key (expenses_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '开销表';


/*==============================================================*/
/* Table: expenses_main_type	   开销大类表                            */
/*==============================================================*/
create table expenses_main_type
(
   type_id	int		AUTO_INCREMENT		COMMENT '开销大类',
   type_name	varchar(45)			default NULL	COMMENT '开销大类名',
   primary key (type_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '开销大类表';

/*==============================================================*/
/* Table: expenses_sub_type	  开销子类表                             */
/*==============================================================*/
create table expenses_sub_type
(
   type_id	int		AUTO_INCREMENT			COMMENT '开销子类',
   type_name	varchar(45)			default NULL	COMMENT '开销子类名',
   primary key (type_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '开销子类表';

/*==============================================================*/
/* Table: invest	     投资表                          */
/*==============================================================*/
create table invest
(
   invest_id		int		 AUTO_INCREMENT		COMMENT '投资编号',
   invest_type		int		default 0			COMMENT '投资类型',
   invest_amount        decimal(10,2)	default '0.00'			COMMENT '投资数目',
   primary key (invest_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '投资表';

/*==============================================================*/
/* Table: invest_type	     投资类型表                          */
/*==============================================================*/
create table invest_type
(
   type_id		int		AUTO_INCREMENT			COMMENT '投资类型编号',
   type_name		varchar(45)		default NULL			COMMENT '投资类型名称',
   primary key (type_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '投资类型表';

/*==============================================================*/
/* Table: invest_log	    投资日志表                           */
/*==============================================================*/
create table invest_log
(
   log_id		int		AUTO_INCREMENT			COMMENT '日志编号',
   invest_id		int		default 0			COMMENT '投资编号',
   invest_type		int		default 1			COMMENT '投资变动类型',
   invest_amount	decimal(10,2)	default '0.00'			COMMENT '投资变动数目',
   operate_user		int		not null			COMMENT '操作人',
   operate_date		datetime	not null			COMMENT '操作时间',
   primary key (log_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '投资日志表';

/*==============================================================*/
/* Table: fixed_asset	 固定资产表                              */
/*==============================================================*/
create table fixed_asset
(
   fixed_asset_id	int		default 0			COMMENT '固定资产编号',
   fixed_asset_name	VARCHAR(100)					COMMENT '固定资产名称',
   fixed_asset_type	int		default 1			COMMENT '固定资产类型',
   fixed_asset_value	decimal(10,2)	default '0.00'			COMMENT '固定资产价值',
   photo_url		VARCHAR(100)					COMMENT '图片地址',
   purchase_date	datetime	not null			COMMENT '购买时间',
   description		varchar(255)					COMMENT '描述',
   primary key (fixed_asset_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '固定资产表';

/*==============================================================*/
/* Table: fixed_asset_type	     固定资产类型表                          */
/*==============================================================*/
create table fixed_asset_type
(
   type_id		int		AUTO_INCREMENT			COMMENT '投资类型编号',
   type_name		varchar(45)		default NULL			COMMENT '投资类型名称',
   primary key (type_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '固定资产类型表';

/*==============================================================*/
/* Table: liabilities	      债务表                         */
/*==============================================================*/
create table liabilities
(
   liabilities_id	int		default 0			COMMENT '债务编号',
   liabilities_type	float		default 0			COMMENT '债务类型',
   liabilities_amount	decimal(10,2)	default '0.00'			COMMENT '债务数目',
   lender_id		int		default 0			COMMENT '借贷方编号',
   liabilities_date	datetime	not null			COMMENT '借贷时间',
   repay_date           datetime					COMMENT '偿还时间',
   annual_interest_rate	int		default 0			COMMENT '年利率',
   primary key (liabilities_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '债务表';

/*==============================================================*/
/* Table: liabilities_type	     债务类型表                          */
/*==============================================================*/
create table liabilities_type
(
   type_id		int		AUTO_INCREMENT			COMMENT '投资类型编号',
   type_name		varchar(45)		default NULL			COMMENT '投资类型名称',
   primary key (type_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '债务类型表'; 

/*==============================================================*/
/* Table: liabilities_log	债务日志表                               */
/*==============================================================*/
create table liabilities_log
(
   log_id		int		AUTO_INCREMENT			COMMENT '日志编号',
   liabilities_id	int		default 0			COMMENT '债务编号',
   lender_id		int		default 1			COMMENT '借贷方编号',
   lend_amount		decimal(10,2)	default '0.00'			COMMENT '本次借贷数目',
   operate_user		int		not null			COMMENT '操作人',
   operate_date		datetime	not null			COMMENT '操作时间',
   primary key (log_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '债务日志表';

/*==============================================================*/
/* Table: lender	   借贷方表                            */
/*==============================================================*/
create table lender
(
   lender_id		int		default 0			COMMENT '借贷方编号',
   lender_name		VARCHAR(100)					COMMENT '借贷方名称',
   lender_type		int		default 0			COMMENT '借贷方类型',
   total_lend_number	int		default 0			COMMENT '累计借贷次数',
   total_lend_amount	decimal(10,2)	default '0.00'			COMMENT '累计借贷数目',
   limit_amount		decimal(10,2)	default '0.00'			COMMENT '最高借贷额度',
   primary key (lender_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '借贷方表';

/*==============================================================*/
/* Table: contribution_log	  贡献度日志表                             */
/*==============================================================*/
create table contribution_log
(
   log_id		int		AUTO_INCREMENT			COMMENT '日志编号',
   user_id		int		default 0			COMMENT '用户编号',
   contribute_type	int		default 0			COMMENT '贡献度变动类型',
   contribute_amount	int		default 1			COMMENT '贡献度变动数目',
   change_date		datetime	not null			COMMENT '贡献度变动时间',
   operate_user		int		not null			COMMENT '操作人',
   operate_date		datetime	not null			COMMENT '操作时间',
   primary key (log_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '贡献度日志表';




INSERT INTO user (user_id,user_name,password,role_id,contribution,name,sex,phone,email,last_login_date)  
VALUES (1,'admin','admin','1',0,'管理员','男','15111111111','admin@qq.com','2006-08-10 17:32:50');

INSERT INTO role (role_id,role_name,description)  VALUES (1,'管理员','修改所有用户密码，修改数据，查看日志');
INSERT INTO role (role_id,role_name,description)  VALUES (2,'高级用户','修改自身用户密码，修改数据');
INSERT INTO role (role_id,role_name,description)  VALUES (3,'初级用户','修改自身用户密码，修改部分数据，金额数据只显示占比');

INSERT INTO permission (permission_id,permission_name,description)  VALUES (1,'查看敏感数据','金额数据显示数值和占比');
INSERT INTO permission (permission_id,permission_name,description)  VALUES (2,'修改数据','可修改自身账户的数据');
INSERT INTO permission (permission_id,permission_name,description)  VALUES (3,'账号管理','可修改所有用户的用户名和密码');
INSERT INTO permission (permission_id,permission_name,description)  VALUES (4,'查看日志','可查看系统日志');
INSERT INTO permission (permission_id,permission_name,description)  VALUES (5,'修改角色','修改用户的角色级别');

INSERT INTO role_permission (role_id,permission_id) 
VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(2,1),(2,2);


INSERT INTO invest_type (type_name) 
VALUES ('股票'),('基金');

INSERT INTO fixed_asset_type (type_name) 
VALUES ('住房'),('汽车'),('衣服'),('数码产品'),('书籍');

INSERT INTO liabilities_type (type_name) 
VALUES ('个人'),('网贷');

INSERT INTO finance (cash,invest,liabilities,fixed_asset,contribution) 
VALUES (0.00,0.00,0.00,0.00,0);




