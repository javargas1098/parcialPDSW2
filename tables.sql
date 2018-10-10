CREATE TABLE `BLOG_USUARIO` (
  `login` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `nombre` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `apellido` varchar(100) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci

CREATE TABLE `BLOG` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `title` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `content` varchar(100) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `BLOG_BLOG_USUARIO_FK` (`author`),
  CONSTRAINT `BLOG_BLOG_USUARIO_FK` FOREIGN KEY (`author`) REFERENCES `BLOG_USUARIO` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci

CREATE TABLE `BLOG_COMMENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `blog_id` int(11) NOT NULL,
  `content` varchar(100) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `BLOG_COMMENT_BLOG_FK` (`blog_id`),
  KEY `BLOG_COMMENT_BLOG_USUARIO_FK` (`author`),
  CONSTRAINT `BLOG_COMMENT_BLOG_FK` FOREIGN KEY (`blog_id`) REFERENCES `BLOG` (`id`),
  CONSTRAINT `BLOG_COMMENT_BLOG_USUARIO_FK` FOREIGN KEY (`author`) REFERENCES `BLOG_USUARIO` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci