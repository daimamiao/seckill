-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE IF NOT EXISTS `seckill`;
-- 使用数据库
USE seckill;

-- 创建秒杀库存表
DROP TABLE IF EXISTS `seckill`;
CREATE TABLE seckill(
  `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'product id',
  `name` VARCHAR(120) NOT NULL COMMENT 'product name',
  `number` INT NOT NULL COMMENT 'repertory number',
  `start_time` TIMESTAMP NOT NULL COMMENT 'seckill starting time',
  `end_time` TIMESTAMP NOT NULL COMMENT 'seckill ending time',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creating time',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='seckill table';

INSERT INTO
  seckill(name, number, start_time, end_time)
VALUES
  ('1000元秒杀iphone7', 100, '2016-12-16 00:00:00', '2016-12-17 00:00:00'),
  ('500元秒杀ipad2', 300, '2016-12-16 00:00:00', '2016-12-17 00:00:00'),
  ('1999元秒杀小米6', 500, '2016-12-16 00:00:00', '2016-12-17 00:00:00'),
  ('2000元秒杀红米note', 400, '2016-12-16 00:00:00', '2016-12-17 00:00:00');

DROP TABLE IF EXISTS `success_killed`;
CREATE TABLE success_killed(
  `seckill_id` bigint NOT NULL COMMENT 'product id',
  `user_phone` bigint NOT NULL COMMENT 'user phone',
  `state` tinyint NOT NULL DEFAULT -1 COMMENT '-1:invalid, 0:success, 1:paid',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creating time',
  PRIMARY KEY (seckill_id, user_phone),  /* associated key */
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='seckill success(status) table';