CREATE TABLE  `dev`.`employee` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `empAge` int(11) DEFAULT NULL,
  `empname` varchar(255) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `USER_ID` int(10) unsigned NOT NULL,
  `USERNAME` varchar(40) NOT NULL,
  `PASSWORD` varchar(40) NOT NULL,
  `ACTIVE` tinyint(1) NOT NULL,
  PRIMARY KEY  (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


CREATE TABLE `user_roles` (
  `USER_ROLE_ID` int(10) unsigned NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  `AUTHORITY` varchar(45) NOT NULL,
  PRIMARY KEY  (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`USER_ID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

INSERT INTO `dev`.`users`
 (`USER_ID`,
 `USERNAME`,
 `PASSWORD`,
 `ACTIVE`
 )
 VALUES
 ('1',
 'janardhan',
 '1234',
 '1'
 );
 
 INSERT INTO `dev`.`user_roles` 
 (`USER_ROLE_ID`, 
 `USER_ID`, 
 `AUTHORITY`
 )
 VALUES
 ('1', 
 '1', 
 'ROLE_USER'
 );


 