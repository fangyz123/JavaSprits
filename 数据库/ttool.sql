/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : ttool

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2018-12-17 11:41:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `classadministration`
-- ----------------------------
DROP TABLE IF EXISTS `classadministration`;
CREATE TABLE `classadministration` (
  `c_a_id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`c_a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classadministration
-- ----------------------------
INSERT INTO `classadministration` VALUES ('1', '一班');
INSERT INTO `classadministration` VALUES ('2', '二班');
INSERT INTO `classadministration` VALUES ('3', '三班');
INSERT INTO `classadministration` VALUES ('4', '四班');
INSERT INTO `classadministration` VALUES ('5', '五班');
INSERT INTO `classadministration` VALUES ('6', '六班');
INSERT INTO `classadministration` VALUES ('7', '七班');
INSERT INTO `classadministration` VALUES ('8', '八班');

-- ----------------------------
-- Table structure for `classcourse`
-- ----------------------------
DROP TABLE IF EXISTS `classcourse`;
CREATE TABLE `classcourse` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(40) DEFAULT NULL,
  `tid` varchar(15) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classcourse
-- ----------------------------
INSERT INTO `classcourse` VALUES ('1', '数据库1', '1', '1');
INSERT INTO `classcourse` VALUES ('2', '操作系统1', '1', '2');
INSERT INTO `classcourse` VALUES ('3', '大数据', '1', '3');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL,
  `cname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数据库');
INSERT INTO `course` VALUES ('2', '操作系统');
INSERT INTO `course` VALUES ('3', '大数据');

-- ----------------------------
-- Table structure for `leavepaper`
-- ----------------------------
DROP TABLE IF EXISTS `leavepaper`;
CREATE TABLE `leavepaper` (
  `id` int(11) NOT NULL,
  `sid` varchar(15) DEFAULT NULL,
  `apply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `img_src` varchar(40) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leavepaper
-- ----------------------------

-- ----------------------------
-- Table structure for `loadstudent`
-- ----------------------------
DROP TABLE IF EXISTS `loadstudent`;
CREATE TABLE `loadstudent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sid` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loadstudent
-- ----------------------------
INSERT INTO `loadstudent` VALUES ('1', '2018-12-15 15:06:25', '2016011329');
INSERT INTO `loadstudent` VALUES ('2', '2018-12-15 15:06:41', '2016011329');
INSERT INTO `loadstudent` VALUES ('3', '2018-12-15 15:12:46', '2016011329');
INSERT INTO `loadstudent` VALUES ('4', '2018-12-15 15:19:19', '2016011329');
INSERT INTO `loadstudent` VALUES ('5', '2018-12-15 17:56:49', '2016011329');
INSERT INTO `loadstudent` VALUES ('6', '2018-12-15 18:01:44', '2016011329');
INSERT INTO `loadstudent` VALUES ('7', '2018-12-16 17:09:02', '2016011357');
INSERT INTO `loadstudent` VALUES ('8', '2018-12-16 17:15:56', '2016011357');
INSERT INTO `loadstudent` VALUES ('9', '2018-12-16 17:18:40', '2016011357');
INSERT INTO `loadstudent` VALUES ('10', '2018-12-16 17:23:24', '2016011357');
INSERT INTO `loadstudent` VALUES ('11', '2018-12-16 17:24:56', '2016011357');
INSERT INTO `loadstudent` VALUES ('12', '2018-12-16 21:16:10', '2016011329');
INSERT INTO `loadstudent` VALUES ('13', '2018-12-16 21:16:43', '2016011329');
INSERT INTO `loadstudent` VALUES ('14', '2018-12-16 21:28:54', '2016011329');
INSERT INTO `loadstudent` VALUES ('15', '2018-12-16 21:29:32', '2016011329');
INSERT INTO `loadstudent` VALUES ('16', '2018-12-16 21:30:04', '2016011329');
INSERT INTO `loadstudent` VALUES ('17', '2018-12-16 21:30:40', '2016011329');
INSERT INTO `loadstudent` VALUES ('18', '2018-12-16 21:30:40', '2016011329');
INSERT INTO `loadstudent` VALUES ('19', '2018-12-16 22:05:25', '2016011329');
INSERT INTO `loadstudent` VALUES ('20', '2018-12-16 22:26:20', '2016011329');
INSERT INTO `loadstudent` VALUES ('21', '2018-12-16 22:27:25', '2016011329');
INSERT INTO `loadstudent` VALUES ('22', '2018-12-16 22:30:21', '2016011329');
INSERT INTO `loadstudent` VALUES ('23', '2018-12-16 22:31:45', '2016011329');
INSERT INTO `loadstudent` VALUES ('24', '2018-12-16 22:37:44', '2016011329');
INSERT INTO `loadstudent` VALUES ('25', '2018-12-16 22:40:33', '2016011329');
INSERT INTO `loadstudent` VALUES ('26', '2018-12-16 22:41:52', '2016011329');
INSERT INTO `loadstudent` VALUES ('27', '2018-12-16 22:56:49', '2016011329');
INSERT INTO `loadstudent` VALUES ('28', '2018-12-16 23:01:46', '2016011329');
INSERT INTO `loadstudent` VALUES ('29', '2018-12-17 10:40:28', '2016011357');
INSERT INTO `loadstudent` VALUES ('30', '2018-12-17 10:41:31', '2016011357');
INSERT INTO `loadstudent` VALUES ('31', '2018-12-17 10:42:02', '2016011329');
INSERT INTO `loadstudent` VALUES ('32', '2018-12-17 10:43:54', '2016011329');
INSERT INTO `loadstudent` VALUES ('33', '2018-12-17 10:49:24', '2016011329');
INSERT INTO `loadstudent` VALUES ('34', '2018-12-17 10:52:11', '2016011329');
INSERT INTO `loadstudent` VALUES ('35', '2018-12-17 10:58:10', '2016011329');
INSERT INTO `loadstudent` VALUES ('36', '2018-12-17 11:00:52', '2016011329');
INSERT INTO `loadstudent` VALUES ('37', '2018-12-17 11:03:23', '2016011329');
INSERT INTO `loadstudent` VALUES ('38', '2018-12-17 11:10:29', '2016011329');
INSERT INTO `loadstudent` VALUES ('39', '2018-12-17 11:16:54', '2016011329');
INSERT INTO `loadstudent` VALUES ('40', '2018-12-17 11:17:42', '2016011329');
INSERT INTO `loadstudent` VALUES ('41', '2018-12-17 11:18:27', '2016011329');
INSERT INTO `loadstudent` VALUES ('42', '2018-12-17 11:25:54', '2016011329');
INSERT INTO `loadstudent` VALUES ('43', '2018-12-17 11:26:53', '2016011329');
INSERT INTO `loadstudent` VALUES ('44', '2018-12-17 11:30:05', '2016011329');
INSERT INTO `loadstudent` VALUES ('45', '2018-12-17 11:32:08', '2016011329');
INSERT INTO `loadstudent` VALUES ('46', '2018-12-17 11:32:55', '2016011329');
INSERT INTO `loadstudent` VALUES ('47', '2018-12-17 11:37:05', '2016011329');

-- ----------------------------
-- Table structure for `loadteacher`
-- ----------------------------
DROP TABLE IF EXISTS `loadteacher`;
CREATE TABLE `loadteacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tid` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loadteacher
-- ----------------------------
INSERT INTO `loadteacher` VALUES ('1', '2018-12-14 22:31:24', '1');
INSERT INTO `loadteacher` VALUES ('2', '2018-12-14 22:32:32', '1');
INSERT INTO `loadteacher` VALUES ('3', '2018-12-14 22:33:45', '1');
INSERT INTO `loadteacher` VALUES ('4', '2018-12-14 22:35:01', '1');
INSERT INTO `loadteacher` VALUES ('5', '2018-12-14 22:35:12', '1');
INSERT INTO `loadteacher` VALUES ('6', '2018-12-15 14:45:05', '1');
INSERT INTO `loadteacher` VALUES ('7', '2018-12-15 14:45:30', '1');
INSERT INTO `loadteacher` VALUES ('8', '2018-12-15 14:45:47', '1');
INSERT INTO `loadteacher` VALUES ('9', '2018-12-15 15:19:30', '1');
INSERT INTO `loadteacher` VALUES ('10', '2018-12-16 17:32:09', '1');
INSERT INTO `loadteacher` VALUES ('11', '2018-12-16 22:43:58', '1');
INSERT INTO `loadteacher` VALUES ('12', '2018-12-16 22:55:15', '1');
INSERT INTO `loadteacher` VALUES ('13', '2018-12-16 22:56:28', '1');
INSERT INTO `loadteacher` VALUES ('14', '2018-12-17 11:19:54', '1');
INSERT INTO `loadteacher` VALUES ('15', '2018-12-17 11:22:47', '1');
INSERT INTO `loadteacher` VALUES ('16', '2018-12-17 11:27:18', '1');
INSERT INTO `loadteacher` VALUES ('17', '2018-12-17 11:30:56', '1');
INSERT INTO `loadteacher` VALUES ('18', '2018-12-17 11:37:20', '1');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `m_id` varchar(15) NOT NULL,
  `password` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for `nodenumber`
-- ----------------------------
DROP TABLE IF EXISTS `nodenumber`;
CREATE TABLE `nodenumber` (
  `node_id` int(11) NOT NULL AUTO_INCREMENT,
  `node` varchar(10) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `sign_range` int(11) DEFAULT NULL,
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nodenumber
-- ----------------------------
INSERT INTO `nodenumber` VALUES ('1', '1-2', '08:00:00', '09:30:00', '30');
INSERT INTO `nodenumber` VALUES ('2', '3-4', '09:45:00', '11:15:00', '30');
INSERT INTO `nodenumber` VALUES ('3', '5', '11:20:00', '12:05:00', '30');
INSERT INTO `nodenumber` VALUES ('4', '6-7', '14:00:00', '15:30:00', '30');
INSERT INTO `nodenumber` VALUES ('5', '8', '15:35:00', '16:20:00', '30');
INSERT INTO `nodenumber` VALUES ('6', '9-10', '16:35:00', '18:05:00', '30');
INSERT INTO `nodenumber` VALUES ('7', '11', '11:18:00', '18:17:20', '30');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(15) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `class_id` int(11) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '2016011329', '1', '2018-12-17 10:49:50', '3', 'faceimg\\2018-12-172016011329.jpg');
INSERT INTO `record` VALUES ('2', '2016011329', '1', '2018-12-17 10:51:50', '3', 'faceimg\\2018-12-172016011329.jpg');
INSERT INTO `record` VALUES ('3', '2016011329', '1', '2018-12-17 10:52:35', '3', 'faceimg\\2018-12-172016011329.jpg');
INSERT INTO `record` VALUES ('4', '2016011329', '1', '2018-12-17 10:58:44', '3', 'faceimg\\2018-12-172016011329.jpg');
INSERT INTO `record` VALUES ('5', '2016011329', '1', '2018-12-17 11:03:42', '3', 'faceimg\\2018-12-172016011329.jpg');
INSERT INTO `record` VALUES ('7', '2016011329', '1', '2018-12-17 11:18:44', '3', 'faceimg\\java.text.SimpleDateFormat@f67a0200-2016011329.jpg');
INSERT INTO `record` VALUES ('8', '2016011329', '1', '2018-12-17 11:22:23', '3', 'faceimg\\java.text.SimpleDateFormat@f67a0200-2016011329.jpg');
INSERT INTO `record` VALUES ('9', '2016011329', '1', '2018-12-17 11:26:15', '3', 'faceimg\\java.text.SimpleDateFormat@f67a0200-2016011329.jpg');
INSERT INTO `record` VALUES ('10', '2016011329', '1', '2018-12-17 11:26:28', '3', 'faceimg\\java.text.SimpleDateFormat@f67a0200-2016011329.jpg');
INSERT INTO `record` VALUES ('11', '2016011329', '1', '2018-12-17 11:26:34', '3', 'faceimg\\java.text.SimpleDateFormat@f67a0200-2016011329.jpg');
INSERT INTO `record` VALUES ('12', '2016011329', '1', '2018-12-17 11:27:07', '3', 'faceimg\\java.text.SimpleDateFormat@f67a0200-2016011329.jpg');
INSERT INTO `record` VALUES ('13', '2016011329', '1', '2018-12-17 11:29:29', '3', 'faceimg\\java.text.SimpleDateFormat@f67a0200-2016011329.jpg');
INSERT INTO `record` VALUES ('14', '2016011329', '1', '2018-12-17 11:30:33', '3', 'faceimg\\java.text.SimpleDateFormat@f67a0200-2016011329.jpg');

-- ----------------------------
-- Table structure for `studentclass`
-- ----------------------------
DROP TABLE IF EXISTS `studentclass`;
CREATE TABLE `studentclass` (
  `id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `sid` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentclass
-- ----------------------------
INSERT INTO `studentclass` VALUES ('1', '3', '2016011329');
INSERT INTO `studentclass` VALUES ('2', '3', '2016011357');

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `sid` varchar(15) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `c_a_id` int(11) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('2015015176', '0000', '1', '王宁', null, null);
INSERT INTO `students` VALUES ('2015015407', '0000', '1', '田实', null, null);
INSERT INTO `students` VALUES ('2016011329', '0000', '1', '方玉珍', null, '10.7.84.43');
INSERT INTO `students` VALUES ('2016011335', '0000', '1', '祁虹蕾', null, null);
INSERT INTO `students` VALUES ('2016011338', '0000', '1', '董莹', null, null);
INSERT INTO `students` VALUES ('2016011344', '0000', '1', '曹泽辰', null, null);
INSERT INTO `students` VALUES ('2016011349', '0000', '1', '于欣洋', null, null);
INSERT INTO `students` VALUES ('2016011352', '0000', '1', '栾晓玥', null, null);
INSERT INTO `students` VALUES ('2016011357', '0000', '1', '郭程媛', null, '10.7.84.43');
INSERT INTO `students` VALUES ('2016011360', '0000', '1', '王笑语', null, null);
INSERT INTO `students` VALUES ('2016011372', '0000', '1', '刘亚双', null, null);
INSERT INTO `students` VALUES ('2016011374', '0000', '1', '张鼎', null, null);
INSERT INTO `students` VALUES ('2016011377', '0000', '1', '赵家瑶', null, null);
INSERT INTO `students` VALUES ('2016011379', '0000', '1', '王梦真', null, null);
INSERT INTO `students` VALUES ('2016011380', '0000', '1', '成琼', null, null);
INSERT INTO `students` VALUES ('2016011384', '0000', '1', '任玉媛', null, null);
INSERT INTO `students` VALUES ('2016011387', '0000', '1', '王子璇', null, null);
INSERT INTO `students` VALUES ('2016011393', '0000', '1', '侯忠祺', null, null);
INSERT INTO `students` VALUES ('2016011394', '0000', '1', '吕凝慧', null, null);
INSERT INTO `students` VALUES ('2016011395', '0000', '1', '何慧霞', null, null);
INSERT INTO `students` VALUES ('2016011399', '0000', '1', '郭金康', null, null);
INSERT INTO `students` VALUES ('2016011401', '0000', '1', '王玉玲', null, null);
INSERT INTO `students` VALUES ('2016011402', '0000', '1', '徐俊美', null, null);
INSERT INTO `students` VALUES ('2016011404', '0000', '1', '袁云鹏', null, null);
INSERT INTO `students` VALUES ('2016011408', '0000', '1', '汪世昭', null, null);
INSERT INTO `students` VALUES ('2016011410', '0000', '1', '杨林旺', null, null);
INSERT INTO `students` VALUES ('2016011413', '0000', '1', '黄军阳', null, null);
INSERT INTO `students` VALUES ('2016011414', '0000', '1', '任少帅', null, null);
INSERT INTO `students` VALUES ('2016011416', '0000', '1', '黄文旭', null, null);
INSERT INTO `students` VALUES ('2016011418', '0000', '1', '李云洋', null, null);
INSERT INTO `students` VALUES ('2016011427', '0000', '1', '白晨皓', null, null);
INSERT INTO `students` VALUES ('2016011428', '0000', '1', '丁泽仁', null, null);
INSERT INTO `students` VALUES ('2016011439', '0000', '1', '李岱恒', null, null);
INSERT INTO `students` VALUES ('2016011442', '0000', '1', '孙程程', null, null);
INSERT INTO `students` VALUES ('2016011448', '0000', '1', '唐溪', null, null);
INSERT INTO `students` VALUES ('2016011453', '0000', '1', '张正扬', null, null);
INSERT INTO `students` VALUES ('2016011455', '0000', '1', '王慧', null, null);
INSERT INTO `students` VALUES ('2016011456', '0000', '1', '王碧云', null, null);
INSERT INTO `students` VALUES ('2016011462', '0000', '1', '王云弟', null, null);
INSERT INTO `students` VALUES ('2016011463', '0000', '1', '闫正伟', null, null);
INSERT INTO `students` VALUES ('2016011480', '0000', '1', '卓必诚', null, null);
INSERT INTO `students` VALUES ('2016011484', '0000', '1', '孙亦璇', null, null);
INSERT INTO `students` VALUES ('2016011493', '0000', '1', '刘金辀', null, null);
INSERT INTO `students` VALUES ('2016011497', '0000', '1', '徐昌隆', null, null);
INSERT INTO `students` VALUES ('2016011506', '0000', '1', '靳若琪', null, null);
INSERT INTO `students` VALUES ('2016011513', '0000', '1', '赵旭', null, null);
INSERT INTO `students` VALUES ('2016011514', '0000', '1', '户子超', null, null);
INSERT INTO `students` VALUES ('2016011524', '0000', '1', '倪泽苒', null, null);
INSERT INTO `students` VALUES ('2016011527', '0000', '1', '陈鹏宇', null, null);
INSERT INTO `students` VALUES ('2016011529', '0000', '1', '闵俨', null, null);
INSERT INTO `students` VALUES ('2016011541', '0000', '1', '孙晴晴', null, null);
INSERT INTO `students` VALUES ('2016011556', '0000', '1', '齐雪婷', null, null);
INSERT INTO `students` VALUES ('2016011561', '0000', '1', '李春良', null, null);
INSERT INTO `students` VALUES ('2016011562', '0000', '1', '高天禹', null, null);
INSERT INTO `students` VALUES ('2016011574', '0000', '1', '徐润凯', null, null);
INSERT INTO `students` VALUES ('2016011584', '0000', '1', '瞿婷婷', null, null);
INSERT INTO `students` VALUES ('2016011587', '0000', '1', '田悦霖', null, null);
INSERT INTO `students` VALUES ('2016011589', '0000', '1', '梁芳芳', null, null);
INSERT INTO `students` VALUES ('2016011591', '0000', '1', '张煜熙', null, null);
INSERT INTO `students` VALUES ('2016011594', '0000', '1', '辛佳锟', null, null);
INSERT INTO `students` VALUES ('2016011602', '0000', '1', '刘珊珊', null, null);
INSERT INTO `students` VALUES ('2016011603', '0000', '1', '赵玉龙', null, null);
INSERT INTO `students` VALUES ('2016011608', '0000', '1', '郭秋霞', null, null);
INSERT INTO `students` VALUES ('2016011619', '0000', '1', '易剑权', null, null);
INSERT INTO `students` VALUES ('2016011620', '0000', '1', '鲍彩倩', null, null);
INSERT INTO `students` VALUES ('2016011621', '0000', '1', '梁雅茹', null, null);
INSERT INTO `students` VALUES ('2016011622', '0000', '1', '张思嘉', null, null);
INSERT INTO `students` VALUES ('2016011627', '0000', '1', '王志臻', null, null);
INSERT INTO `students` VALUES ('2016011635', '0000', '1', '邓旸', null, null);
INSERT INTO `students` VALUES ('2016011636', '0000', '1', '孙明伟', null, null);
INSERT INTO `students` VALUES ('2016011638', '0000', '1', '段智兴', null, null);
INSERT INTO `students` VALUES ('2016011640', '0000', '1', '魏谦强', null, null);
INSERT INTO `students` VALUES ('2016011641', '0000', '1', '董世轩', null, null);
INSERT INTO `students` VALUES ('2016011651', '0000', '1', '胡宇', null, null);
INSERT INTO `students` VALUES ('2016011654', '0000', '1', '刘杼滨', null, null);
INSERT INTO `students` VALUES ('2016011668', '0000', '1', '鲍张军', null, null);
INSERT INTO `students` VALUES ('2016011674', '0000', '1', '刘田会', null, null);
INSERT INTO `students` VALUES ('2016011676', '0000', '1', '杜曼', null, null);
INSERT INTO `students` VALUES ('2016011678', '0000', '1', '张春辉', null, null);
INSERT INTO `students` VALUES ('2016011679', '0000', '1', '王海峰', null, null);
INSERT INTO `students` VALUES ('2016011681', '0000', '1', '刘晓倩', null, null);
INSERT INTO `students` VALUES ('2016011683', '0000', '1', '黄媛媛', null, null);
INSERT INTO `students` VALUES ('2016011695', '0000', '1', '王昭', null, null);
INSERT INTO `students` VALUES ('2016011697', '0000', '1', '崔珊', null, null);
INSERT INTO `students` VALUES ('2016011705', '0000', '1', '邬梓渌', null, null);
INSERT INTO `students` VALUES ('2016011707', '0000', '1', '薛云晴', null, null);
INSERT INTO `students` VALUES ('2016011719', '0000', '1', '韩泽豪', null, null);
INSERT INTO `students` VALUES ('2016011720', '0000', '1', '任家华', null, null);

-- ----------------------------
-- Table structure for `studentstatus`
-- ----------------------------
DROP TABLE IF EXISTS `studentstatus`;
CREATE TABLE `studentstatus` (
  `sid` varchar(15) NOT NULL,
  `record_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentstatus
-- ----------------------------
INSERT INTO `studentstatus` VALUES ('2015015176', '0');
INSERT INTO `studentstatus` VALUES ('2015015407', '0');
INSERT INTO `studentstatus` VALUES ('2016011329', '1');
INSERT INTO `studentstatus` VALUES ('2016011335', '0');
INSERT INTO `studentstatus` VALUES ('2016011338', '0');
INSERT INTO `studentstatus` VALUES ('2016011344', '0');
INSERT INTO `studentstatus` VALUES ('2016011349', '0');
INSERT INTO `studentstatus` VALUES ('2016011352', '0');
INSERT INTO `studentstatus` VALUES ('2016011357', '0');
INSERT INTO `studentstatus` VALUES ('2016011360', '0');
INSERT INTO `studentstatus` VALUES ('2016011372', '0');
INSERT INTO `studentstatus` VALUES ('2016011374', '0');
INSERT INTO `studentstatus` VALUES ('2016011377', '0');
INSERT INTO `studentstatus` VALUES ('2016011379', '0');
INSERT INTO `studentstatus` VALUES ('2016011380', '0');
INSERT INTO `studentstatus` VALUES ('2016011384', '0');
INSERT INTO `studentstatus` VALUES ('2016011387', '0');
INSERT INTO `studentstatus` VALUES ('2016011393', '0');
INSERT INTO `studentstatus` VALUES ('2016011394', '0');
INSERT INTO `studentstatus` VALUES ('2016011395', '0');
INSERT INTO `studentstatus` VALUES ('2016011399', '0');
INSERT INTO `studentstatus` VALUES ('2016011401', '0');
INSERT INTO `studentstatus` VALUES ('2016011402', '0');
INSERT INTO `studentstatus` VALUES ('2016011404', '0');
INSERT INTO `studentstatus` VALUES ('2016011408', '0');
INSERT INTO `studentstatus` VALUES ('2016011410', '0');
INSERT INTO `studentstatus` VALUES ('2016011413', '0');
INSERT INTO `studentstatus` VALUES ('2016011414', '0');
INSERT INTO `studentstatus` VALUES ('2016011416', '0');
INSERT INTO `studentstatus` VALUES ('2016011418', '0');
INSERT INTO `studentstatus` VALUES ('2016011427', '0');
INSERT INTO `studentstatus` VALUES ('2016011428', '0');
INSERT INTO `studentstatus` VALUES ('2016011439', '0');
INSERT INTO `studentstatus` VALUES ('2016011442', '0');
INSERT INTO `studentstatus` VALUES ('2016011448', '0');
INSERT INTO `studentstatus` VALUES ('2016011453', '0');
INSERT INTO `studentstatus` VALUES ('2016011455', '0');
INSERT INTO `studentstatus` VALUES ('2016011456', '0');
INSERT INTO `studentstatus` VALUES ('2016011462', '0');
INSERT INTO `studentstatus` VALUES ('2016011463', '0');
INSERT INTO `studentstatus` VALUES ('2016011480', '0');
INSERT INTO `studentstatus` VALUES ('2016011484', '0');
INSERT INTO `studentstatus` VALUES ('2016011493', '0');
INSERT INTO `studentstatus` VALUES ('2016011497', '0');
INSERT INTO `studentstatus` VALUES ('2016011506', '0');
INSERT INTO `studentstatus` VALUES ('2016011513', '0');
INSERT INTO `studentstatus` VALUES ('2016011514', '0');
INSERT INTO `studentstatus` VALUES ('2016011524', '0');
INSERT INTO `studentstatus` VALUES ('2016011527', '0');
INSERT INTO `studentstatus` VALUES ('2016011529', '0');
INSERT INTO `studentstatus` VALUES ('2016011541', '0');
INSERT INTO `studentstatus` VALUES ('2016011556', '0');
INSERT INTO `studentstatus` VALUES ('2016011561', '0');
INSERT INTO `studentstatus` VALUES ('2016011562', '0');
INSERT INTO `studentstatus` VALUES ('2016011574', '0');
INSERT INTO `studentstatus` VALUES ('2016011584', '0');
INSERT INTO `studentstatus` VALUES ('2016011587', '0');
INSERT INTO `studentstatus` VALUES ('2016011589', '0');
INSERT INTO `studentstatus` VALUES ('2016011591', '0');
INSERT INTO `studentstatus` VALUES ('2016011594', '0');
INSERT INTO `studentstatus` VALUES ('2016011602', '0');
INSERT INTO `studentstatus` VALUES ('2016011603', '0');
INSERT INTO `studentstatus` VALUES ('2016011608', '0');
INSERT INTO `studentstatus` VALUES ('2016011619', '0');
INSERT INTO `studentstatus` VALUES ('2016011620', '0');
INSERT INTO `studentstatus` VALUES ('2016011621', '0');
INSERT INTO `studentstatus` VALUES ('2016011622', '0');
INSERT INTO `studentstatus` VALUES ('2016011627', '0');
INSERT INTO `studentstatus` VALUES ('2016011635', '0');
INSERT INTO `studentstatus` VALUES ('2016011636', '0');
INSERT INTO `studentstatus` VALUES ('2016011638', '0');
INSERT INTO `studentstatus` VALUES ('2016011640', '0');
INSERT INTO `studentstatus` VALUES ('2016011641', '0');
INSERT INTO `studentstatus` VALUES ('2016011651', '0');
INSERT INTO `studentstatus` VALUES ('2016011654', '0');
INSERT INTO `studentstatus` VALUES ('2016011668', '0');
INSERT INTO `studentstatus` VALUES ('2016011674', '0');
INSERT INTO `studentstatus` VALUES ('2016011676', '0');
INSERT INTO `studentstatus` VALUES ('2016011678', '0');
INSERT INTO `studentstatus` VALUES ('2016011679', '0');
INSERT INTO `studentstatus` VALUES ('2016011681', '0');
INSERT INTO `studentstatus` VALUES ('2016011683', '0');
INSERT INTO `studentstatus` VALUES ('2016011695', '0');
INSERT INTO `studentstatus` VALUES ('2016011697', '0');
INSERT INTO `studentstatus` VALUES ('2016011705', '0');
INSERT INTO `studentstatus` VALUES ('2016011707', '0');
INSERT INTO `studentstatus` VALUES ('2016011719', '0');
INSERT INTO `studentstatus` VALUES ('2016011720', '0');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` varchar(15) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `tname` varchar(15) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '1', '1', 'aa', '10.7.84.43');
INSERT INTO `teacher` VALUES ('2', '2', '1', '王伟', null);

-- ----------------------------
-- Table structure for `teacherstatus`
-- ----------------------------
DROP TABLE IF EXISTS `teacherstatus`;
CREATE TABLE `teacherstatus` (
  `tid` varchar(15) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacherstatus
-- ----------------------------
INSERT INTO `teacherstatus` VALUES ('1', '0');
INSERT INTO `teacherstatus` VALUES ('2', '0');

-- ----------------------------
-- Table structure for `term`
-- ----------------------------
DROP TABLE IF EXISTS `term`;
CREATE TABLE `term` (
  `term_id` int(11) NOT NULL,
  `time_begin` date NOT NULL,
  `time_end` date NOT NULL DEFAULT '0000-00-00',
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`term_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of term
-- ----------------------------
INSERT INTO `term` VALUES ('1', '2018-09-10', '2019-01-19', '1');

-- ----------------------------
-- Table structure for `times`
-- ----------------------------
DROP TABLE IF EXISTS `times`;
CREATE TABLE `times` (
  `id` int(11) NOT NULL,
  `c_week` varchar(20) DEFAULT NULL,
  `c_date` varchar(20) DEFAULT NULL,
  `node_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of times
-- ----------------------------
INSERT INTO `times` VALUES ('1', '1-10', '星期一', '1', '3');
INSERT INTO `times` VALUES ('2', '1-10', '星期一', '2', '3');
INSERT INTO `times` VALUES ('3', '1-18', '星期一', '7', '3');
INSERT INTO `times` VALUES ('4', '1-18', '星期日', '7', '3');
