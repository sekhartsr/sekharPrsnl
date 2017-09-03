CREATE TABLE `work_visit` (
  `wv_id` int(11) NOT NULL AUTO_INCREMENT,
  `wv_cabinet` varchar(255) DEFAULT NULL,
  `wv_cage` varchar(255) DEFAULT NULL,
  `wv_ibx` varchar(255) DEFAULT NULL,
  `wv_useer` varchar(255) DEFAULT NULL,
  `wv_dtls` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SELECT * FROM mydb.work_visit_ibx_info;