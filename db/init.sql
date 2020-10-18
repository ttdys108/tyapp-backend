CREATE TABLE `tbl_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32),
  `password` varchar(64),
  `account_no` varchar(32),
  `avatar` varchar(128),
  `nickname` varchar(64),
  `mobile` varchar(16),
  `email` varchar(128),
  `status` varchar(10) NOT NULL DEFAULT 'ACTIVE',
  `device_id` varchar(128),
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) ,
  INDEX `idx_user_name`(`username`) ,
  INDEX `idx_user_account`(`account_no`) ,
  INDEX `idx_user_mobile`(`mobile`)
) AUTO_INCREMENT = 1000000;