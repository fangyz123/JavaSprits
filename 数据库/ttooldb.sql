/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : ttooldb

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2018-12-05 15:30:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `class_administration`
-- ----------------------------
DROP TABLE IF EXISTS `class_administration`;
CREATE TABLE `class_administration` (
  `c_a_id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`c_a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_administration
-- ----------------------------
INSERT INTO `class_administration` VALUES ('1', '16软件工程1班');
INSERT INTO `class_administration` VALUES ('2', '16软件工程2班');
INSERT INTO `class_administration` VALUES ('3', '16软件工程3班');
INSERT INTO `class_administration` VALUES ('4', '16软件工程4班');
INSERT INTO `class_administration` VALUES ('5', '16软件工程5班');
INSERT INTO `class_administration` VALUES ('6', '16软件工程6班');
INSERT INTO `class_administration` VALUES ('7', '16软件工程7班');
INSERT INTO `class_administration` VALUES ('8', '16软件工程8班');
INSERT INTO `class_administration` VALUES ('9', '15软件工程1班');

-- ----------------------------
-- Table structure for `class_course`
-- ----------------------------
DROP TABLE IF EXISTS `class_course`;
CREATE TABLE `class_course` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(40) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_course
-- ----------------------------

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

-- ----------------------------
-- Table structure for `leave_paper`
-- ----------------------------
DROP TABLE IF EXISTS `leave_paper`;
CREATE TABLE `leave_paper` (
  `id` int(11) NOT NULL,
  `sid` varchar(15) DEFAULT NULL,
  `apply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `img_src` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leave_paper
-- ----------------------------

-- ----------------------------
-- Table structure for `load_student`
-- ----------------------------
DROP TABLE IF EXISTS `load_student`;
CREATE TABLE `load_student` (
  `id` int(11) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sid` int(11) DEFAULT NULL,
  `ip_current` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of load_student
-- ----------------------------

-- ----------------------------
-- Table structure for `load_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `load_teacher`;
CREATE TABLE `load_teacher` (
  `id` int(11) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tid` int(11) DEFAULT NULL,
  `current_id` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of load_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL,
  `sid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `sid` varchar(15) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `c_a_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('2015015176', null, null, '王宁', null, '9');
INSERT INTO `students` VALUES ('2015015407', null, null, '田实', null, '9');
INSERT INTO `students` VALUES ('2016011329', null, null, '方玉珍', null, '1');
INSERT INTO `students` VALUES ('2016011335', null, null, '祁虹蕾', null, '1');
INSERT INTO `students` VALUES ('2016011338', null, null, '董莹', null, '1');
INSERT INTO `students` VALUES ('2016011344', null, null, '曹泽辰', null, '1');
INSERT INTO `students` VALUES ('2016011349', null, null, '于欣洋', null, '1');
INSERT INTO `students` VALUES ('2016011352', null, null, '栾晓玥', null, '1');
INSERT INTO `students` VALUES ('2016011357', null, null, '郭程媛', null, '1');
INSERT INTO `students` VALUES ('2016011360', null, null, '王笑语', null, '1');
INSERT INTO `students` VALUES ('2016011372', null, null, '刘亚双', null, '1');
INSERT INTO `students` VALUES ('2016011374', null, null, '张鼎', null, '1');
INSERT INTO `students` VALUES ('2016011377', null, null, '赵家瑶', null, '2');
INSERT INTO `students` VALUES ('2016011379', null, null, '王梦真', null, '2');
INSERT INTO `students` VALUES ('2016011380', null, null, '成琼', null, '2');
INSERT INTO `students` VALUES ('2016011384', null, null, '任玉媛', null, '2');
INSERT INTO `students` VALUES ('2016011387', null, null, '王子璇', null, '2');
INSERT INTO `students` VALUES ('2016011393', null, null, '侯忠祺', null, '2');
INSERT INTO `students` VALUES ('2016011394', null, null, '吕凝慧', null, '2');
INSERT INTO `students` VALUES ('2016011395', null, null, '何慧霞', null, '2');
INSERT INTO `students` VALUES ('2016011399', null, null, '郭金康', null, '2');
INSERT INTO `students` VALUES ('2016011401', null, null, '王玉玲', null, '2');
INSERT INTO `students` VALUES ('2016011402', null, null, '徐俊美', null, '2');
INSERT INTO `students` VALUES ('2016011404', null, null, '袁云鹏', null, '2');
INSERT INTO `students` VALUES ('2016011408', null, null, '汪世昭', null, '2');
INSERT INTO `students` VALUES ('2016011410', null, null, '杨林旺', null, '2');
INSERT INTO `students` VALUES ('2016011413', null, null, '黄军阳', null, '2');
INSERT INTO `students` VALUES ('2016011414', null, null, '任少帅', null, '2');
INSERT INTO `students` VALUES ('2016011416', null, null, '黄文旭', null, '2');
INSERT INTO `students` VALUES ('2016011418', null, null, '李云洋', null, '2');
INSERT INTO `students` VALUES ('2016011427', null, null, '白晨皓', null, '3');
INSERT INTO `students` VALUES ('2016011428', null, null, '丁泽仁', null, '3');
INSERT INTO `students` VALUES ('2016011439', null, null, '李岱恒', null, '3');
INSERT INTO `students` VALUES ('2016011442', null, null, '孙程程', null, '3');
INSERT INTO `students` VALUES ('2016011448', null, null, '唐溪', null, '3');
INSERT INTO `students` VALUES ('2016011453', null, null, '张正扬', null, '3');
INSERT INTO `students` VALUES ('2016011455', null, null, '王慧', null, '3');
INSERT INTO `students` VALUES ('2016011456', null, null, '王碧云', null, '3');
INSERT INTO `students` VALUES ('2016011462', null, null, '王云弟', null, '3');
INSERT INTO `students` VALUES ('2016011463', null, null, '闫正伟', null, '3');
INSERT INTO `students` VALUES ('2016011480', null, null, '卓必诚', null, '4');
INSERT INTO `students` VALUES ('2016011484', null, null, '孙亦璇', null, '4');
INSERT INTO `students` VALUES ('2016011493', null, null, '刘金辀', null, '4');
INSERT INTO `students` VALUES ('2016011497', null, null, '徐昌隆', null, '4');
INSERT INTO `students` VALUES ('2016011506', null, null, '靳若琪', null, '4');
INSERT INTO `students` VALUES ('2016011513', null, null, '赵旭', null, '4');
INSERT INTO `students` VALUES ('2016011514', null, null, '户子超', null, '4');
INSERT INTO `students` VALUES ('2016011524', null, null, '倪泽苒', null, '4');
INSERT INTO `students` VALUES ('2016011527', null, null, '陈鹏宇', null, '5');
INSERT INTO `students` VALUES ('2016011529', null, null, '闵俨', null, '5');
INSERT INTO `students` VALUES ('2016011541', null, null, '孙晴晴', null, '5');
INSERT INTO `students` VALUES ('2016011556', null, null, '齐雪婷', null, '5');
INSERT INTO `students` VALUES ('2016011561', null, null, '李春良', null, '5');
INSERT INTO `students` VALUES ('2016011562', null, null, '高天禹', null, '5');
INSERT INTO `students` VALUES ('2016011574', null, null, '徐润凯', null, '5');
INSERT INTO `students` VALUES ('2016011584', null, null, '瞿婷婷', null, '6');
INSERT INTO `students` VALUES ('2016011587', null, null, '田悦霖', null, '6');
INSERT INTO `students` VALUES ('2016011589', null, null, '梁芳芳', null, '6');
INSERT INTO `students` VALUES ('2016011591', null, null, '张煜熙', null, '6');
INSERT INTO `students` VALUES ('2016011594', null, null, '辛佳锟', null, '6');
INSERT INTO `students` VALUES ('2016011602', null, null, '刘珊珊', null, '6');
INSERT INTO `students` VALUES ('2016011603', null, null, '赵玉龙', null, '6');
INSERT INTO `students` VALUES ('2016011608', null, null, '郭秋霞', null, '6');
INSERT INTO `students` VALUES ('2016011619', null, null, '易剑权', null, '6');
INSERT INTO `students` VALUES ('2016011620', null, null, '鲍彩倩', null, '6');
INSERT INTO `students` VALUES ('2016011621', null, null, '梁雅茹', null, '6');
INSERT INTO `students` VALUES ('2016011622', null, null, '张思嘉', null, '6');
INSERT INTO `students` VALUES ('2016011627', null, null, '王志臻', null, '6');
INSERT INTO `students` VALUES ('2016011635', null, null, '邓旸', null, '7');
INSERT INTO `students` VALUES ('2016011636', null, null, '孙明伟', null, '7');
INSERT INTO `students` VALUES ('2016011638', null, null, '段智兴', null, '7');
INSERT INTO `students` VALUES ('2016011640', null, null, '魏谦强', null, '7');
INSERT INTO `students` VALUES ('2016011641', null, null, '董世轩', null, '7');
INSERT INTO `students` VALUES ('2016011651', null, null, '胡宇', null, '7');
INSERT INTO `students` VALUES ('2016011654', null, null, '刘杼滨', null, '7');
INSERT INTO `students` VALUES ('2016011668', null, null, '鲍张军', null, '7');
INSERT INTO `students` VALUES ('2016011674', null, null, '刘田会', null, '7');
INSERT INTO `students` VALUES ('2016011676', null, null, '杜曼', null, '7');
INSERT INTO `students` VALUES ('2016011678', null, null, '张春辉', null, '7');
INSERT INTO `students` VALUES ('2016011679', null, null, '王海峰', null, '8');
INSERT INTO `students` VALUES ('2016011681', null, null, '刘晓倩', null, '8');
INSERT INTO `students` VALUES ('2016011683', null, null, '黄媛媛', null, '8');
INSERT INTO `students` VALUES ('2016011695', null, null, '王昭', null, '8');
INSERT INTO `students` VALUES ('2016011697', null, null, '崔珊', null, '8');
INSERT INTO `students` VALUES ('2016011705', null, null, '邬梓渌', null, '8');
INSERT INTO `students` VALUES ('2016011707', null, null, '薛云晴', null, '8');
INSERT INTO `students` VALUES ('2016011719', null, null, '韩泽豪', null, '8');
INSERT INTO `students` VALUES ('2016011720', null, null, '任家华', null, '8');

-- ----------------------------
-- Table structure for `student_class`
-- ----------------------------
DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class` (
  `id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `sid` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_class
-- ----------------------------

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `tname` varchar(15) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `times`
-- ----------------------------
DROP TABLE IF EXISTS `times`;
CREATE TABLE `times` (
  `id` int(11) NOT NULL,
  `c_week` varchar(20) DEFAULT NULL,
  `c_date` varchar(20) DEFAULT NULL,
  `c_time` varchar(30) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of times
-- ----------------------------
