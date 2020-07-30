CREATE TABLE `user` (
  `id` bigint(20) PRIMARY KEY NOT NULL,
  `auth_id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `display_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;