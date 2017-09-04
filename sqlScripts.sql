CREATE TABLE `work_visit` (
  `wv_id` int(11) NOT NULL AUTO_INCREMENT,
  `wv_cabinet` varchar(255) DEFAULT NULL,
  `wv_cage` varchar(255) DEFAULT NULL,
  `wv_ibx` varchar(255) DEFAULT NULL,
  `wv_useer` varchar(255) DEFAULT NULL,
  `wv_dtls` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `work_visit_details` (
  `wv_dtls_id` int(11) NOT NULL AUTO_INCREMENT,
  `wv_dtls_end_dt` datetime DEFAULT NULL,
  `wv_dtls_end_tm` varchar(255) DEFAULT NULL,
  `wv_dtls_start_dt` datetime DEFAULT NULL,
  `wv_dtls_start_tm` varchar(255) DEFAULT NULL,
  `wv_useer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wv_dtls_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `work_visit_ibx_info` (
  `ibx_id` int(11) NOT NULL AUTO_INCREMENT,
  `cabinet` varchar(255) DEFAULT NULL,
  `cage` varchar(255) DEFAULT NULL,
  `ibx` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ibx_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE `work_visit_users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


INSERT INTO work_visit_users(
company,first_name,last_name,user_name)
VALUES(
"Sachin Solutions",
"Sachin","Tendulkar",
"Sachin Tendulkar"
);

INSERT INTO work_visit_users(
company,first_name,last_name,user_name)
VALUES(
"Tunuri Technologies",
"Tunuri","Aanvith",
"Tunuri Aanvith"
);

INSERT INTO work_visit_users(
company,first_name,last_name,user_name)
VALUES(
"Dhoni Solutions",
"MS","Dhoni",
"MS Dhoni"
);

INSERT INTO work_visit_users(
company,first_name,last_name,user_name)
VALUES(
"Anil Associations",
"Anil","Kumble",
"Anil Kumble"
);
