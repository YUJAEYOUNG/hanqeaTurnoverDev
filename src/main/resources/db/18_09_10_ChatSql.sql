-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.3.7-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- hanqeaturnover 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `hanqeaturnover` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hanqeaturnover`;


UPDATE menu SET MENU_URL='/webChat/community.do' WHERE  MENU_ID='MENU0002';

-- 테이블 hanqeaturnover.chat_join_entry 구조 내보내기
CREATE TABLE IF NOT EXISTS `chat_join_entry` (
  `cje_seq` int(11) NOT NULL AUTO_INCREMENT,
  `cje_room_id` varchar(100) NOT NULL COMMENT '채팅방 아이디',
  `cje_email` varchar(100) NOT NULL COMMENT '채팅방 유저 이메일',
  PRIMARY KEY (`cje_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='채팅 방 참여 인원';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hanqeaturnover.chat_log 구조 내보내기
CREATE TABLE IF NOT EXISTS `chat_log` (
  `cl_seq` int(11) NOT NULL AUTO_INCREMENT,
  `cl_room_id` varchar(100) NOT NULL COMMENT '채팅방 아이디',
  `cl_message` varchar(255) NOT NULL COMMENT '채팅 메세지',
  `cl_writer` varchar(100) DEFAULT NULL COMMENT '채팅 작성자',
  `cl_reg_dt` date NOT NULL COMMENT '채팅 작성 시간',
  PRIMARY KEY (`cl_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='채팅 로그';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hanqeaturnover.chat_option 구조 내보내기
CREATE TABLE IF NOT EXISTS `chat_option` (
  `co_seq` int(11) NOT NULL AUTO_INCREMENT,
  `co_room_id` varchar(100) NOT NULL COMMENT '채팅방 아이디',
  `co_room_name` varchar(100) NOT NULL COMMENT '채팅방 이름',
  `co_participant_cnt` int(11) NOT NULL COMMENT '채팅방 참여 인원',
  `co_room_type` char(2) NOT NULL DEFAULT '1' COMMENT ' 채팅방 타입 : 1 : 1:1   2 : 멀티',
  PRIMARY KEY (`co_seq`,`co_room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='채팅방 옵션';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hanqeaturnover.chat_room 구조 내보내기
CREATE TABLE IF NOT EXISTS `chat_room` (
  `cr_seq` int(11) NOT NULL AUTO_INCREMENT,
  `cr_id` varchar(100) NOT NULL COMMENT '채팅방 아이디',
  PRIMARY KEY (`cr_seq`,`cr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='채팅방';

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
