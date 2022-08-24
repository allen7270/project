-- create database
create database if not exists `project`;

-- id table
CREATE TABLE IF NOT EXISTS id (
    `idno` VARCHAR(3) NOT NULL,
    `idname` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`idno`)
);
insert into id (`idno`, `idname`) values ('I01','root'),('I02','member'),('I03','nonmember');
-- store table
CREATE TABLE IF NOT EXISTS store (
    `deptno` VARCHAR(3) NOT NULL,
    `deptname` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`deptno`)
);
insert into store (`deptno`, `deptname`) values ('D01','Zhongshan'),('D02','Gongyi'),('D03','Lingya');
-- punch(IO) table
CREATE TABLE IF NOT EXISTS punch (
    `date` VARCHAR(20) NOT NULL,
    `account` VARCHAR(20) NOT NULL,
    `in` VARCHAR(10) DEFAULT NULL,
    `out` VARCHAR(10) DEFAULT NULL
);
CREATE TABLE IF NOT EXISTS member (
    `id` VARCHAR(10) NOT NULL,
    `username` VARCHAR(20) NOT NULL,
    `account` VARCHAR(20) DEFAULT 'null',
    `passwd` VARCHAR(20) DEFAULT 'null',
    `mail` VARCHAR(20) NOT NULL,
    `phone` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`username`),
    FOREIGN KEY (`id`)
        REFERENCES id (`idno`)
);
-- insert root
INSERT INTO `project`.`member` (`id`, `username`, `account`, `passwd`, `mail`, `phone`) VALUES ('I01', 'root', 'root', 'sppu', 'root.gmail.com', '0988888888');
INSERT INTO `project`.`member` (`id`, `username`, `account`, `passwd`, `mail`, `phone`) VALUES ('I01', 'root1', 'root1', 'sppu2', 'root1.gmail.com', '0988888888');

-- reservedDetail table
CREATE TABLE IF NOT EXISTS reservedDetail (
    `no` INT AUTO_INCREMENT,
    `username` VARCHAR(10) NOT NULL,
    `deptno` VARCHAR(3) NOT NULL,
    `date` VARCHAR(10) NOT NULL,
    `time` VARCHAR(10) NOT NULL,
    `number` VARCHAR(5) NOT NULL,
    PRIMARY KEY (`no`),
    FOREIGN KEY (`username`)
        REFERENCES member (`username`),
    FOREIGN KEY (`deptno`)
        REFERENCES store (`deptno`)
);
-- orderInfo
CREATE TABLE IF NOT EXISTS orderInfo (
    `username` VARCHAR(10) NOT NULL,
    `loc` VARCHAR(45) NOT NULL,
    `mail` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`username`)
);
-- order payment method
CREATE TABLE IF NOT EXISTS paymentMethod (
    `payno` VARCHAR(10) NOT NULL,
    `paymentMethod` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`payno`)
);
insert into paymentMethod values('0', 'Credit card'), ('1', 'Cash');
-- online orderDetail table
CREATE TABLE IF NOT EXISTS onlineOrderDetail (
    `no` INT AUTO_INCREMENT,
    `date` VARCHAR(10) NOT NULL,
    `username` VARCHAR(10) NOT NULL,
    `payno` VARCHAR(10) DEFAULT NULL,
    `set1` TINYINT NULL DEFAULT 0,
    `set2` TINYINT NULL DEFAULT 0,
    `set3` TINYINT NULL DEFAULT 0,
    `carte1` TINYINT NULL DEFAULT 0,
    `carte2` TINYINT NULL DEFAULT 0,
    `carte3` TINYINT NULL DEFAULT 0,
    `carte4` TINYINT NULL DEFAULT 0,
    `carte5` TINYINT NULL DEFAULT 0,
    `carte6` TINYINT NULL DEFAULT 0,
    `carte7` TINYINT NULL DEFAULT 0,
    `carte8` TINYINT NULL DEFAULT 0,
    PRIMARY KEY (`no`),
    FOREIGN KEY (`username`)
        REFERENCES orderInfo (`username`),
    FOREIGN KEY (`payno`)
        REFERENCES paymentMethod (`payno`)
);
-- onsite orderDetail table
CREATE TABLE IF NOT EXISTS onsiteOrderDetail (
    `no` INT AUTO_INCREMENT,
    `date` VARCHAR(10) NOT NULL,
    `username` VARCHAR(10) NOT NULL,
    `set1` TINYINT NULL DEFAULT 0,
    `set2` TINYINT NULL DEFAULT 0,
    `set3` TINYINT NULL DEFAULT 0,
    `carte1` TINYINT NULL DEFAULT 0,
    `carte2` TINYINT NULL DEFAULT 0,
    `carte3` TINYINT NULL DEFAULT 0,
    `carte4` TINYINT NULL DEFAULT 0,
    `carte5` TINYINT NULL DEFAULT 0,
    `carte6` TINYINT NULL DEFAULT 0,
    `carte7` TINYINT NULL DEFAULT 0,
    `carte8` TINYINT NULL DEFAULT 0,
    PRIMARY KEY (`no`),
    FOREIGN KEY (`username`)
        REFERENCES member (`username`)
);




