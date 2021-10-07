-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 06 Eki 2021, 16:30:57
-- Sunucu sürümü: 10.4.20-MariaDB
-- PHP Sürümü: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `vet_app_restapi`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `agenda`
--

CREATE TABLE `agenda` (
  `id` varchar(255) NOT NULL,
  `agdate` varchar(255) DEFAULT NULL,
  `agtext` varchar(255) DEFAULT NULL,
  `agtime` varchar(255) DEFAULT NULL,
  `agtitle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `agenda`
--

INSERT INTO `agenda` (`id`, `agdate`, `agtext`, `agtime`, `agtitle`) VALUES
('0c9cda76-f81f-43e8-83b0-d2c85fa23d05', 'asdasdas', 'striasdasdng', 'striasdasng', 'striasdasdng'),
('160b1f28-f90d-45da-a860-7f7977c79ae8', 'string', 'string', 'string', 'string'),
('17f570fc-d44b-439a-9715-bce84fe7977b', 'asdasdas', 'striasdasdng', 'striasdasng', 'striasdasdng'),
('3e7f7dca-a50e-4e6d-9c3b-32d27357fd0a', 'asdasdas', 'striasdasdng', 'striasdasng', 'striasdasdng'),
('571c1e8e-107c-4169-986d-04e33a9a6b35', 'Redis ile eklendi', 'Redis ile eklendi', 'Redis ile eklendi', 'Redis ile eklendi'),
('5ebbc59e-a2dc-4b73-a01c-b49b9d467694', 'asdasdas', 'striasdasdng', 'striasdasng', 'striasdasdng'),
('675d1eb5-da5b-4889-aee8-7f4b984d32c4', 'string Düzelendi', 'string Düzelendi', 'string Düzelendi', 'string Düzelendi'),
('e7af471e-c21b-4bc1-bee0-b6e15f7e2994', 'string', 'string', 'string', 'string Düzelendi'),
('ed7d3dee-b554-4184-9e30-faf6bbc65e65', 'string', 'string', 'string', 'string Düzelendi'),
('fe891555-9495-4c83-b22b-fe774e2429fc', 'string Düzelendi', 'string Düzelendi', 'string Düzelendi', 'string Düzelendi');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `buying`
--

CREATE TABLE `buying` (
  `bid` int(11) NOT NULL,
  `bfatura_no` int(11) NOT NULL,
  `bgross_price` int(11) NOT NULL,
  `bnet_price` int(11) NOT NULL,
  `bnote` varchar(255) DEFAULT NULL,
  `btotal_price` int(11) NOT NULL,
  `buying_date` datetime DEFAULT NULL,
  `pdiscount` int(11) NOT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `proamount` int(11) NOT NULL,
  `probirim` int(11) NOT NULL,
  `proprice` int(11) NOT NULL,
  `purtype` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `taxtype` int(11) NOT NULL,
  `tname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `buying`
--

INSERT INTO `buying` (`bid`, `bfatura_no`, `bgross_price`, `bnet_price`, `bnote`, `btotal_price`, `buying_date`, `pdiscount`, `pname`, `proamount`, `probirim`, `proprice`, `purtype`, `status`, `taxtype`, `tname`) VALUES
(1, 2323, 0, 0, 'string', 0, '2021-10-03 18:33:24', 0, '1', 0, 0, 0, 0, 1, 0, '1'),
(3, 0, 0, 0, 'string', 0, '2021-10-03 18:33:30', 0, '3', 0, 0, 0, 0, 0, 0, '1'),
(4, 22, 0, 0, NULL, 0, '2021-10-03 18:47:29', 0, '3', 0, 0, 0, 0, 2, 0, '1'),
(5, 23, 0, 0, 'string', 0, '2021-10-05 01:00:42', 0, '2', 0, 0, 0, 0, 1, 0, '1'),
(6, 23, 0, 0, 'string', 0, '2021-10-05 01:00:46', 0, '2', 0, 0, 0, 0, 1, 0, '1'),
(7, 23, 0, 0, NULL, 0, '2021-10-05 01:02:42', 0, '2', 0, 0, 0, 0, 2, 0, '1'),
(8, 0, 0, 0, 'string', 0, '2021-10-06 12:56:54', 0, 'string', 0, 0, 0, 0, 0, 0, 'string');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `calendar_info`
--

CREATE TABLE `calendar_info` (
  `cid` int(11) NOT NULL,
  `cbg_color` varchar(255) DEFAULT NULL,
  `cborder_color` varchar(255) DEFAULT NULL,
  `ccolor` varchar(255) DEFAULT NULL,
  `cdrag_bg_color` varchar(255) DEFAULT NULL,
  `cname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `calendar_info`
--

INSERT INTO `calendar_info` (`cid`, `cbg_color`, `cborder_color`, `ccolor`, `cdrag_bg_color`, `cname`) VALUES
(1, 'string', 'string', 'string', 'string', 'string'),
(2, 'string', 'string', 'string', 'string', 'Düzenlendi'),
(3, 'string', 'string', 'string', 'string', 'string');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `cure`
--

CREATE TABLE `cure` (
  `curid` int(11) NOT NULL,
  `curcomment` varchar(255) DEFAULT NULL,
  `curdebt` int(11) DEFAULT NULL,
  `curtitle` varchar(255) DEFAULT NULL,
  `curla` int(11) DEFAULT NULL,
  `curpro` int(11) DEFAULT NULL,
  `curvac` int(11) DEFAULT NULL,
  `pet_pid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `cure`
--

INSERT INTO `cure` (`curid`, `curcomment`, `curdebt`, `curtitle`, `curla`, `curpro`, `curvac`, `pet_pid`) VALUES
(1, 'string', 0, 'string', NULL, NULL, NULL, NULL),
(2, 'string', 0, 'string', NULL, NULL, NULL, NULL),
(4, 'string', 0, 'string', NULL, NULL, NULL, NULL),
(5, 'string', 0, 'string', NULL, NULL, NULL, 2),
(6, 'string', 0, 'string', NULL, NULL, NULL, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customer`
--

CREATE TABLE `customer` (
  `cid` int(11) NOT NULL,
  `caddress` varchar(255) DEFAULT NULL,
  `ccitizenship` int(11) DEFAULT NULL,
  `ccity` varchar(255) DEFAULT NULL,
  `cdate` varchar(255) DEFAULT NULL,
  `cdebpt` int(11) DEFAULT NULL,
  `cdiscount` int(11) DEFAULT NULL,
  `cmail` varchar(255) NOT NULL,
  `cname` varchar(100) NOT NULL,
  `cnote` varchar(255) DEFAULT NULL,
  `csurname` varchar(255) NOT NULL,
  `ctax_office` varchar(255) DEFAULT NULL,
  `ctel` varchar(255) DEFAULT NULL,
  `ctel_2` varchar(255) DEFAULT NULL,
  `ctown` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `customer`
--

INSERT INTO `customer` (`cid`, `caddress`, `ccitizenship`, `ccity`, `cdate`, `cdebpt`, `cdiscount`, `cmail`, `cname`, `cnote`, `csurname`, `ctax_office`, `ctel`, `ctel_2`, `ctown`) VALUES
(1, NULL, NULL, NULL, NULL, NULL, NULL, 'ferhatactio1n@mail.com', 'ActionFerhatSUNUMSUZ', NULL, 'ARFSUNUMSUZ', 'Eskişehir', '123213', NULL, NULL),
(2, NULL, NULL, NULL, NULL, NULL, NULL, 'ferhatSunumsuzn@mail.com', 'ActionSunumsuz', NULL, 'ARFSUNUMSUZ', 'Eskişehir', '123213', NULL, NULL),
(4, NULL, NULL, NULL, NULL, NULL, NULL, 'alper@mail.com', 'Alpers', NULL, 'alper', 'Bursa', '123123', NULL, NULL),
(5, NULL, NULL, NULL, NULL, NULL, NULL, 'alper43534@mail.com', 'Alpers', NULL, 'alper', 'Bursa', '123123', NULL, NULL),
(6, NULL, NULL, NULL, NULL, NULL, NULL, 'alper43534@mail.com', 'Alpers', NULL, 'alper', 'Bursa', '123123', NULL, NULL),
(7, NULL, NULL, NULL, NULL, NULL, NULL, 'alper34@mail.com', 'Alpers', NULL, 'alper', 'Bursa', '123123', NULL, NULL),
(8, NULL, NULL, NULL, NULL, NULL, NULL, 'alper3e4@mail.com', 'Alpers', NULL, 'alper', 'Bursa', '123123', NULL, NULL),
(9, NULL, NULL, NULL, NULL, NULL, NULL, 'alper3e4@mail.com', 'Alpers', NULL, 'alper', 'Bursa', '123123', NULL, NULL),
(10, NULL, NULL, NULL, NULL, NULL, NULL, 'alper3e4@mail.com', 'Alpers', NULL, 'alper', 'Bursa', '123123', NULL, NULL),
(11, NULL, NULL, NULL, NULL, NULL, NULL, 'alper3e4@mail.com', 'Alpers', NULL, 'alper', 'Bursa', '123123', NULL, NULL),
(12, NULL, NULL, NULL, NULL, NULL, NULL, 'alper3e4@mail.com', 'Alpers', NULL, 'alper', 'Bursa', '123123', NULL, NULL),
(13, NULL, NULL, NULL, NULL, NULL, NULL, 'ferhat4443@mail.com', 'ferhat', NULL, 'yıldırım', 'Bursa', '123123', NULL, NULL);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(11);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `lab`
--

CREATE TABLE `lab` (
  `lid` int(11) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `lcomment` varchar(255) DEFAULT NULL,
  `ldate` datetime DEFAULT NULL,
  `ltitle` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `lab`
--

INSERT INTO `lab` (`lid`, `file_name`, `lcomment`, `ldate`, `ltitle`, `pid`) VALUES
(1, '74eb9441-9e91-47bc-ac2b-bc3b7a459a92l.png', 'adasdasd', '2021-10-02 18:22:59', '12123231', 2),
(3, '8cb593c1-1369-4245-9466-d13973394645r.png', 'adasdasd', '2021-10-06 13:53:36', '12123231', 2),
(4, 'c1506c67-07f4-49de-a3ff-21d6e2e874a3r.png', 'adasdasd', '2021-10-06 17:15:55', '12123231', 2),
(5, '51a90b3f-2622-4abe-bec2-7c3f74832bc2r.png', 'Labaratuvar Sonucu', '2021-10-06 17:16:40', 'Labaratuvar Sonucu', 2),
(6, 'b7a8c3eb-dd8d-4967-8e55-da6f09a7e2c6r.png', 'Laboratuvar Sonucu', '2021-10-06 17:18:05', 'Laboratuvar Sonucu', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `labor`
--

CREATE TABLE `labor` (
  `laid` int(11) NOT NULL,
  `lamoney` int(11) DEFAULT NULL,
  `laname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `labor`
--

INSERT INTO `labor` (`laid`, `lamoney`, `laname`) VALUES
(1, 0, 'string'),
(2, 0, 'string'),
(3, 130, 'YIKAMA'),
(4, 130, 'Tırnak Kesme'),
(5, 130, 'Tırnak '),
(6, 130, 'Tüy Kesimi '),
(7, 130, 'Alper'),
(8, 130, 'Alper'),
(9, 130, 'Alper'),
(10, 130, 'Alper'),
(11, 130, 'ferhat rezzan');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `logger`
--

CREATE TABLE `logger` (
  `lid` int(11) NOT NULL,
  `l_date` datetime DEFAULT NULL,
  `l_ip` varchar(255) DEFAULT NULL,
  `l_url` varchar(255) DEFAULT NULL,
  `lemail` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `lroles` varchar(255) DEFAULT NULL,
  `lsession_id` varchar(255) DEFAULT NULL,
  `lsurname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `money_case`
--

CREATE TABLE `money_case` (
  `cid` int(11) NOT NULL,
  `cbuysell` int(11) DEFAULT NULL,
  `ccomment` varchar(255) DEFAULT NULL,
  `cdatenow` datetime DEFAULT NULL,
  `cmoney` int(11) DEFAULT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `cpeople` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `money_case`
--

INSERT INTO `money_case` (`cid`, `cbuysell`, `ccomment`, `cdatenow`, `cmoney`, `cname`, `cpeople`) VALUES
(1, 1, 'Satış', '2021-10-03 17:55:34', 0, 'alper@mail.com', 'string'),
(2, 2, 'Fatura', '2021-10-03 18:47:29', 0, 'alper@mail.com', 'stringname'),
(3, 2, 'Fatura', '2021-10-05 01:02:42', 0, 'alper@mail.com', 'stringname'),
(4, 2, 'Fatura', '2021-10-05 01:02:42', 0, 'alper@mail.com', 'stringname');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `password_reset_token`
--

CREATE TABLE `password_reset_token` (
  `id` int(11) NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `password_reset_token`
--

INSERT INTO `password_reset_token` (`id`, `expiry_date`, `token`, `user_id`) VALUES
(3, NULL, '9613c111-51a8-4103-a1c8-2902c6f7dbe8', 1),
(4, NULL, 'f20ed080-bcae-4eef-a130-7c8882631ec8', 1),
(5, NULL, 'e6db08a2-d668-467d-80bc-ec13b89ae32d', 1),
(7, NULL, '69e2a454-bb84-492b-9a3c-2ece76af7434', 1),
(8, NULL, '9a09b7ef-6256-483e-82d3-fcfd044a7613', 1),
(9, NULL, 'a6eb572e-689a-4d3f-a477-a7987ff574c3', 1),
(10, NULL, '8f94d5d2-bb3e-4721-9876-cfc798533287', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `pet`
--

CREATE TABLE `pet` (
  `pid` int(11) NOT NULL,
  `pbirthday` datetime DEFAULT NULL,
  `pchip` int(11) DEFAULT NULL,
  `pcolor` int(11) DEFAULT NULL,
  `pearnumber` varchar(255) DEFAULT NULL,
  `pgender` int(11) DEFAULT NULL,
  `pname` varchar(255) NOT NULL,
  `prace` varchar(255) DEFAULT NULL,
  `pspay` int(11) DEFAULT NULL,
  `ptype` int(11) DEFAULT NULL,
  `cid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `pet`
--

INSERT INTO `pet` (`pid`, `pbirthday`, `pchip`, `pcolor`, `pearnumber`, `pgender`, `pname`, `prace`, `pspay`, `ptype`, `cid`) VALUES
(2, NULL, 3232432, NULL, NULL, NULL, 'Kedix', NULL, NULL, NULL, 2),
(3, NULL, 3232432, NULL, NULL, NULL, 'Köpek', NULL, NULL, NULL, 2),
(4, NULL, 3232432, NULL, NULL, NULL, 'Kedixx', NULL, NULL, NULL, 2),
(5, NULL, 3232432, NULL, NULL, NULL, 'Köpekxxxx', NULL, NULL, NULL, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `product`
--

CREATE TABLE `product` (
  `prid` int(11) NOT NULL,
  `practive` int(11) DEFAULT NULL,
  `prbarcode` varchar(255) DEFAULT NULL,
  `prbuying` int(11) DEFAULT NULL,
  `prcategory` int(11) DEFAULT NULL,
  `prcode` varchar(255) DEFAULT NULL,
  `prname` varchar(150) NOT NULL,
  `prsales` int(11) DEFAULT NULL,
  `prstock` int(11) DEFAULT NULL,
  `prsupplier` int(11) DEFAULT NULL,
  `prtax` int(11) DEFAULT NULL,
  `prtaxincluded` int(11) DEFAULT NULL,
  `prtype` int(11) DEFAULT NULL,
  `prunit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `product`
--

INSERT INTO `product` (`prid`, `practive`, `prbarcode`, `prbuying`, `prcategory`, `prcode`, `prname`, `prsales`, `prstock`, `prsupplier`, `prtax`, `prtaxincluded`, `prtype`, `prunit`) VALUES
(1, 0, 'string', 0, 0, 'string', 'stringDüzenlendi', 0, 0, 0, 0, 0, 0, 0),
(3, 0, 'string', 0, 0, 'string', 'string', 0, 0, 0, 0, 0, 0, 0),
(4, 1, 'productbarcode düzenlendi', 23, 2, '234s', 'productname düzenlendi', 2, 3, 4, 3, 2, 3, 4);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_CUSTOMER'),
(4, 'ROLE_SUPERADMIN');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sale`
--

CREATE TABLE `sale` (
  `sid` int(11) NOT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `fatura_no` int(11) NOT NULL,
  `gross_price` int(11) NOT NULL,
  `net_price` int(11) NOT NULL,
  `note` varchar(250) DEFAULT NULL,
  `pamount` int(11) NOT NULL,
  `pdiscount` int(11) NOT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `pprice` int(11) NOT NULL,
  `pro_type` int(11) NOT NULL,
  `pur_type` int(11) NOT NULL,
  `sale_date` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `tax_type` int(11) NOT NULL,
  `total_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `schedule_calendar`
--

CREATE TABLE `schedule_calendar` (
  `sid` int(11) NOT NULL,
  `bg_color` varchar(255) DEFAULT NULL,
  `border_color` varchar(255) DEFAULT NULL,
  `calendar_id` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `drag_bg_color` varchar(255) DEFAULT NULL,
  `due_date_class` varchar(255) DEFAULT NULL,
  `end` varchar(255) DEFAULT NULL,
  `id` varchar(255) DEFAULT NULL,
  `is_all_day` bit(1) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `raw` varchar(255) DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `storage`
--

CREATE TABLE `storage` (
  `stid` int(11) NOT NULL,
  `staction` int(11) DEFAULT NULL,
  `stchangeamount` int(11) DEFAULT NULL,
  `stdate` datetime DEFAULT NULL,
  `stlastamount` int(11) DEFAULT NULL,
  `stpro` int(11) DEFAULT NULL,
  `stvac` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `storage`
--

INSERT INTO `storage` (`stid`, `staction`, `stchangeamount`, `stdate`, `stlastamount`, `stpro`, `stvac`) VALUES
(1, 0, 0, '2021-10-01 01:31:49', 0, NULL, NULL),
(2, 0, 33, '2021-10-01 01:31:49', 23, NULL, NULL),
(3, 0, 0, '2021-10-01 01:31:49', 0, NULL, NULL),
(4, 0, 0, '2021-10-01 01:31:49', 0, NULL, NULL),
(6, 1, 0, '2021-10-03 18:47:29', 0, 3, NULL),
(7, 1, 0, '2021-10-05 01:02:42', 0, NULL, 2),
(8, 1, 0, '2021-10-05 01:02:42', 0, NULL, 2),
(9, 1, 60, '2021-10-05 15:56:34', 60, NULL, 7),
(10, 1, 60, '2021-10-05 16:00:28', 60, NULL, 8),
(11, 1, 3, '2021-10-05 16:18:12', 3, 4, NULL);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `suppliers`
--

CREATE TABLE `suppliers` (
  `suid` int(11) NOT NULL,
  `suactive` int(11) DEFAULT NULL,
  `sudebt` int(11) DEFAULT NULL,
  `sumail` varchar(255) DEFAULT NULL,
  `suname` varchar(255) DEFAULT NULL,
  `sutel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `suppliers`
--

INSERT INTO `suppliers` (`suid`, `suactive`, `sudebt`, `sumail`, `suname`, `sutel`) VALUES
(1, 1, 2, 'string@mail.com', 'stringname', '1231243'),
(2, 1, 5, 'string@mail.com', 'stringname', '1231243');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token_expired` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `token_expired`) VALUES
(1, 'alper@mail.com', b'1', 'alper', 'yilmaz', '$2a$10$paoPa.hO31VzdNAoPMoOluChuzwFVp7z9CGbAkkABsAJdWvlE.A2i', b'1'),
(6, 'mails@mail.com', b'1', 'Ferhat', 'Yıldırım', '$2a$10$WXjacdB4Y7mdVPkjh6mdFe5xXNo0wiD0QUOw4QuRe6hplfiozdYzy', b'1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 2),
(6, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `vaccine`
--

CREATE TABLE `vaccine` (
  `vacid` int(11) NOT NULL,
  `vacactive` int(11) DEFAULT NULL,
  `vacbarcode` varchar(255) DEFAULT NULL,
  `vacbuying` int(11) DEFAULT NULL,
  `vaccategory` int(11) DEFAULT NULL,
  `vaccode` varchar(255) DEFAULT NULL,
  `vacname` varchar(150) NOT NULL,
  `vacpettype` int(11) DEFAULT NULL,
  `vacrepeat` int(11) DEFAULT NULL,
  `vacsales` int(11) DEFAULT NULL,
  `vacstock` int(11) DEFAULT NULL,
  `vacsupplier` int(11) DEFAULT NULL,
  `vactax` int(11) DEFAULT NULL,
  `vactaxincluded` int(11) DEFAULT NULL,
  `vactype` int(11) DEFAULT NULL,
  `vacunit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `vaccine`
--

INSERT INTO `vaccine` (`vacid`, `vacactive`, `vacbarcode`, `vacbuying`, `vaccategory`, `vaccode`, `vacname`, `vacpettype`, `vacrepeat`, `vacsales`, `vacstock`, `vacsupplier`, `vactax`, `vactaxincluded`, `vactype`, `vacunit`) VALUES
(1, 0, 'string', 0, 0, 'string', 'string', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(2, 0, 'string', 0, 0, 'string', 'stringDüzenlendi', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 0, 'string', 0, 0, 'string', 'string', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 0, 'string', 0, 0, 'string', 'string', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 1, 'vacc barcode', 125, 2, 'vaccode', 'vacname', 2, 3, 4, 60, 40, 2, 600, 3, 5),
(7, 1, 'vacc barcode', 125, 2, 'vaccode', 'vacname', 2, 3, 4, 60, 40, 2, 600, 3, 5),
(8, 1, 'vacc barcode', 125, 2, 'vaccode', 'vacname', 2, 3, 4, 60, 40, 2, 600, 3, 5);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `buying`
--
ALTER TABLE `buying`
  ADD PRIMARY KEY (`bid`);

--
-- Tablo için indeksler `calendar_info`
--
ALTER TABLE `calendar_info`
  ADD PRIMARY KEY (`cid`);

--
-- Tablo için indeksler `cure`
--
ALTER TABLE `cure`
  ADD PRIMARY KEY (`curid`),
  ADD KEY `FK58g2vdcywkwh5w3eeyodg05bt` (`curla`),
  ADD KEY `FKgxyitbwnent20j5oxlf4nijiy` (`curpro`),
  ADD KEY `FKsdc66mcbmxycyuf4x93b4u2c5` (`curvac`),
  ADD KEY `FK5eexl7mq9kjkwpx2lfegwcasm` (`pet_pid`);

--
-- Tablo için indeksler `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cid`);

--
-- Tablo için indeksler `lab`
--
ALTER TABLE `lab`
  ADD PRIMARY KEY (`lid`),
  ADD KEY `FK3pp161be0191phy1kw801b2i2` (`pid`);

--
-- Tablo için indeksler `labor`
--
ALTER TABLE `labor`
  ADD PRIMARY KEY (`laid`);

--
-- Tablo için indeksler `logger`
--
ALTER TABLE `logger`
  ADD PRIMARY KEY (`lid`);

--
-- Tablo için indeksler `money_case`
--
ALTER TABLE `money_case`
  ADD PRIMARY KEY (`cid`);

--
-- Tablo için indeksler `password_reset_token`
--
ALTER TABLE `password_reset_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5lwtbncug84d4ero33v3cfxvl` (`user_id`);

--
-- Tablo için indeksler `pet`
--
ALTER TABLE `pet`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `FK56h8ygbfpruejv0xebxqg554t` (`cid`);

--
-- Tablo için indeksler `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`prid`);

--
-- Tablo için indeksler `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`sid`);

--
-- Tablo için indeksler `schedule_calendar`
--
ALTER TABLE `schedule_calendar`
  ADD PRIMARY KEY (`sid`);

--
-- Tablo için indeksler `storage`
--
ALTER TABLE `storage`
  ADD PRIMARY KEY (`stid`),
  ADD KEY `FKplsi8p3k7uy88wd83addmrin0` (`stpro`),
  ADD KEY `FKhtb39j3l4vmchxk47al9nqjhb` (`stvac`);

--
-- Tablo için indeksler `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`suid`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  ADD KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`);

--
-- Tablo için indeksler `vaccine`
--
ALTER TABLE `vaccine`
  ADD PRIMARY KEY (`vacid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `buying`
--
ALTER TABLE `buying`
  MODIFY `bid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `calendar_info`
--
ALTER TABLE `calendar_info`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `cure`
--
ALTER TABLE `cure`
  MODIFY `curid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `customer`
--
ALTER TABLE `customer`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Tablo için AUTO_INCREMENT değeri `lab`
--
ALTER TABLE `lab`
  MODIFY `lid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `labor`
--
ALTER TABLE `labor`
  MODIFY `laid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `logger`
--
ALTER TABLE `logger`
  MODIFY `lid` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `money_case`
--
ALTER TABLE `money_case`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `pet`
--
ALTER TABLE `pet`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `product`
--
ALTER TABLE `product`
  MODIFY `prid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `sale`
--
ALTER TABLE `sale`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `schedule_calendar`
--
ALTER TABLE `schedule_calendar`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `storage`
--
ALTER TABLE `storage`
  MODIFY `stid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `suid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `vaccine`
--
ALTER TABLE `vaccine`
  MODIFY `vacid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `cure`
--
ALTER TABLE `cure`
  ADD CONSTRAINT `FK58g2vdcywkwh5w3eeyodg05bt` FOREIGN KEY (`curla`) REFERENCES `labor` (`laid`),
  ADD CONSTRAINT `FK5eexl7mq9kjkwpx2lfegwcasm` FOREIGN KEY (`pet_pid`) REFERENCES `pet` (`pid`),
  ADD CONSTRAINT `FKgxyitbwnent20j5oxlf4nijiy` FOREIGN KEY (`curpro`) REFERENCES `product` (`prid`),
  ADD CONSTRAINT `FKsdc66mcbmxycyuf4x93b4u2c5` FOREIGN KEY (`curvac`) REFERENCES `vaccine` (`vacid`);

--
-- Tablo kısıtlamaları `lab`
--
ALTER TABLE `lab`
  ADD CONSTRAINT `FK3pp161be0191phy1kw801b2i2` FOREIGN KEY (`pid`) REFERENCES `pet` (`pid`);

--
-- Tablo kısıtlamaları `password_reset_token`
--
ALTER TABLE `password_reset_token`
  ADD CONSTRAINT `FK5lwtbncug84d4ero33v3cfxvl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Tablo kısıtlamaları `pet`
--
ALTER TABLE `pet`
  ADD CONSTRAINT `FK56h8ygbfpruejv0xebxqg554t` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`);

--
-- Tablo kısıtlamaları `storage`
--
ALTER TABLE `storage`
  ADD CONSTRAINT `FKhtb39j3l4vmchxk47al9nqjhb` FOREIGN KEY (`stvac`) REFERENCES `vaccine` (`vacid`),
  ADD CONSTRAINT `FKplsi8p3k7uy88wd83addmrin0` FOREIGN KEY (`stpro`) REFERENCES `product` (`prid`);

--
-- Tablo kısıtlamaları `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
