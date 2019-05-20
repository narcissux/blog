/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 15/05/2019 21:35:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(7) NOT NULL,
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_num` int(8) NULL DEFAULT NULL,
  `view_num` int(10) NULL DEFAULT NULL,
  `category_id` int(5) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_fk`(`user_id`) USING BTREE,
  INDEX `category_id_fk`(`category_id`) USING BTREE,
  CONSTRAINT `category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '修改文章标题', '修改简介', '# 欢迎使用 Cmd Markdown 编辑阅读器\r\n\r\n我们理解您需要更便捷更高效的工具记录思想，整理笔记、知识，并将其中承载的价值传播给他人，**Cmd Markdown** 是我们给出的答案 —— 我们为记录思想和分享知识提供更专业的工具。 您可以使用 Cmd Markdown：\r\n\r\n> * 整理知识，学习笔记\r\n> * 发布日记，杂文，所见所想\r\n> * 撰写发布技术文稿（代码支持）\r\n> * 撰写发布学术论文（LaTeX 公式支持）\r\n\r\n![cmd-markdown-logo](https://www.zybuluo.com/static/img/logo.png)\r\n\r\n除了您现在看到的这个 Cmd Markdown 在线版本，您还可以前往以下网址下载：\r\n\r\n### [Windows/Mac/Linux 全平台客户端](https://www.zybuluo.com/cmd/)\r\n\r\n> 请保留此份 Cmd Markdown 的欢迎稿兼使用说明，如需撰写新稿件，点击顶部工具栏右侧的 <i class=\"icon-file\"></i> **新文稿** 或者使用快捷键 `Ctrl+Alt+N`。\r\n\r\n------\r\n\r\n## 什么是 Markdown\r\n\r\nMarkdown 是一种方便记忆、书写的纯文本标记语言，用户可以使用这些标记符号以最小的输入代价生成极富表现力的文档：譬如您正在阅读的这份文档。它使用简单的符号标记不同的标题，分割不同的段落，**粗体** 或者 *斜体* 某些文字，更棒的是，它还可以\r\n\r\n### 1. 制作一份待办事宜 [Todo 列表](https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown#13-待办事宜-todo-列表)\r\n\r\n- [ ] 支持以 PDF 格式导出文稿\r\n- [ ] 改进 Cmd 渲染算法，使用局部渲染技术提高渲染效率\r\n- [x] 新增 Todo 列表功能\r\n- [x] 修复 LaTex 公式渲染问题\r\n- [x] 新增 LaTex 公式编号功能\r\n\r\n### 2. 书写一个质能守恒公式[^LaTeX]\r\n\r\n$$E=mc^2$$\r\n\r\n### 3. 高亮一段代码[^code]\r\n\r\n```python\r\n@requires_authorization\r\nclass SomeClass:\r\n    pass\r\n\r\nif __name__ == \'__main__\':\r\n    # A comment\r\n    print \'hello world\'\r\n```', 1008, '修改昵称', 1, 35, 2, '2019-05-03 10:35:38', '2019-05-03 10:35:38');
INSERT INTO `article` VALUES (2, 'Java', '开发', '# 欢迎使用 Cmd Markdown 编辑阅读器\r\n\r\n我们理解您需要更便捷更高效的工具记录思想，整理笔记、知识，并将其中承载的价值传播给他人，**Cmd Markdown** 是我们给出的答案 —— 我们为记录思想和分享知识提供更专业的工具。 您可以使用 Cmd Markdown：\r\n\r\n> * 整理知识，学习笔记\r\n> * 发布日记，杂文，所见所想\r\n> * 撰写发布技术文稿（代码支持）\r\n> * 撰写发布学术论文（LaTeX 公式支持）\r\n\r\n![cmd-markdown-logo](https://www.zybuluo.com/static/img/logo.png)\r\n\r\n除了您现在看到的这个 Cmd Markdown 在线版本，您还可以前往以下网址下载：\r\n\r\n### [Windows/Mac/Linux 全平台客户端](https://www.zybuluo.com/cmd/)\r\n\r\n> 请保留此份 Cmd Markdown 的欢迎稿兼使用说明，如需撰写新稿件，点击顶部工具栏右侧的 <i class=\"icon-file\"></i> **新文稿** 或者使用快捷键 `Ctrl+Alt+N`。\r\n\r\n------\r\n\r\n## 什么是 Markdown\r\n\r\nMarkdown 是一种方便记忆、书写的纯文本标记语言，用户可以使用这些标记符号以最小的输入代价生成极富表现力的文档：譬如您正在阅读的这份文档。它使用简单的符号标记不同的标题，分割不同的段落，**粗体** 或者 *斜体* 某些文字，更棒的是，它还可以\r\n\r\n### 1. 制作一份待办事宜 [Todo 列表](https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown#13-待办事宜-todo-列表)\r\n\r\n- [ ] 支持以 PDF 格式导出文稿\r\n- [ ] 改进 Cmd 渲染算法，使用局部渲染技术提高渲染效率\r\n- [x] 新增 Todo 列表功能\r\n- [x] 修复 LaTex 公式渲染问题\r\n- [x] 新增 LaTex 公式编号功能\r\n\r\n### 2. 书写一个质能守恒公式[^LaTeX]\r\n\r\n$$E=mc^2$$\r\n\r\n### 3. 高亮一段代码[^code]\r\n\r\n```python\r\n@requires_authorization\r\nclass SomeClass:\r\n    pass\r\n\r\nif __name__ == \'__main__\':\r\n    # A comment\r\n    print \'hello world\'\r\n```', 1001, '别名', 0, 6, 1, '2019-05-11 08:49:43', '2019-05-11 08:49:43');
INSERT INTO `article` VALUES (3, 'python', 'python', '# 欢迎使用 Cmd Markdown 编辑阅读器\r\n\r\n我们理解您需要更便捷更高效的工具记录思想，整理笔记、知识，并将其中承载的价值传播给他人，**Cmd Markdown** 是我们给出的答案 —— 我们为记录思想和分享知识提供更专业的工具。 您可以使用 Cmd Markdown：\r\n\r\n> * 整理知识，学习笔记\r\n> * 发布日记，杂文，所见所想\r\n> * 撰写发布技术文稿（代码支持）\r\n> * 撰写发布学术论文（LaTeX 公式支持）\r\n\r\n![cmd-markdown-logo](https://www.zybuluo.com/static/img/logo.png)\r\n\r\n除了您现在看到的这个 Cmd Markdown 在线版本，您还可以前往以下网址下载：\r\n\r\n### [Windows/Mac/Linux 全平台客户端](https://www.zybuluo.com/cmd/)\r\n\r\n> 请保留此份 Cmd Markdown 的欢迎稿兼使用说明，如需撰写新稿件，点击顶部工具栏右侧的 <i class=\"icon-file\"></i> **新文稿** 或者使用快捷键 `Ctrl+Alt+N`。\r\n\r\n------\r\n\r\n## 什么是 Markdown\r\n\r\nMarkdown 是一种方便记忆、书写的纯文本标记语言，用户可以使用这些标记符号以最小的输入代价生成极富表现力的文档：譬如您正在阅读的这份文档。它使用简单的符号标记不同的标题，分割不同的段落，**粗体** 或者 *斜体* 某些文字，更棒的是，它还可以\r\n\r\n### 1. 制作一份待办事宜 [Todo 列表](https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown#13-待办事宜-todo-列表)\r\n\r\n- [ ] 支持以 PDF 格式导出文稿\r\n- [ ] 改进 Cmd 渲染算法，使用局部渲染技术提高渲染效率\r\n- [x] 新增 Todo 列表功能\r\n- [x] 修复 LaTex 公式渲染问题\r\n- [x] 新增 LaTex 公式编号功能\r\n\r\n### 2. 书写一个质能守恒公式[^LaTeX]\r\n\r\n$$E=mc^2$$\r\n\r\n### 3. 高亮一段代码[^code]\r\n\r\n```python\r\n@requires_authorization\r\nclass SomeClass:\r\n    pass\r\n\r\nif __name__ == \'__main__\':\r\n    # A comment\r\n    print \'hello world\'\r\n```', 1002, 'python', 0, 13, 1, '2019-05-11 09:16:06', '2019-05-11 09:16:06');
INSERT INTO `article` VALUES (7, '夏夜最初的笔记', NULL, '![你好](http://narcissup.cn-gd.ufileos.com/70419200_p0.jpg)', 1008, '夏夜', 0, 14, 2, '2019-05-15 09:43:55', '2019-05-15 09:43:55');
INSERT INTO `article` VALUES (8, '夏夜最初的笔记', NULL, '![你好]http://narcissup.cn-![你好](http://narcissup.cn-gd.ufileos.com/70419200_p0.jpg)', 1008, '夏夜', 0, 7, 2, '2019-05-15 10:02:24', '2019-05-15 10:02:24');
INSERT INTO `article` VALUES (9, '夏夜最初的笔记', NULL, '![你好]http://narcissup.cn-![你好](http://narcissup.cn-gd.ufileos.com/70419200_p0.jpg)', 1008, '夏夜', 0, 4, 2, '2019-05-15 10:04:17', '2019-05-15 10:04:17');

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `article_id` int(7) NULL DEFAULT NULL,
  `tag_id` int(5) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `article_id_fk`(`article_id`) USING BTREE,
  INDEX `tag_id_fk`(`tag_id`) USING BTREE,
  CONSTRAINT `article_id_fk` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tag_id_fk` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES (1, 1, 2, '2019-05-14 19:33:36', '2019-05-14 19:33:36');
INSERT INTO `article_tag` VALUES (3, 3, 3, '2019-05-11 09:18:22', '2019-05-11 09:18:22');
INSERT INTO `article_tag` VALUES (4, 1, 3, '2019-05-13 20:08:45', '2019-05-13 20:08:46');
INSERT INTO `article_tag` VALUES (5, NULL, 1, '2019-05-15 09:44:20', '2019-05-15 09:44:21');
INSERT INTO `article_tag` VALUES (6, NULL, 4, '2019-05-15 09:44:20', '2019-05-15 09:44:21');
INSERT INTO `article_tag` VALUES (7, NULL, 5, '2019-05-15 09:44:20', '2019-05-15 09:44:21');
INSERT INTO `article_tag` VALUES (8, NULL, 6, '2019-05-15 09:44:20', '2019-05-15 09:44:21');
INSERT INTO `article_tag` VALUES (9, NULL, 7, '2019-05-15 09:44:20', '2019-05-15 09:44:21');
INSERT INTO `article_tag` VALUES (10, NULL, 1, '2019-05-15 10:02:55', '2019-05-15 10:02:55');
INSERT INTO `article_tag` VALUES (11, NULL, 4, '2019-05-15 10:02:55', '2019-05-15 10:02:55');
INSERT INTO `article_tag` VALUES (12, NULL, 5, '2019-05-15 10:02:55', '2019-05-15 10:02:55');
INSERT INTO `article_tag` VALUES (13, NULL, 6, '2019-05-15 10:02:55', '2019-05-15 10:02:55');
INSERT INTO `article_tag` VALUES (14, NULL, 7, '2019-05-15 10:02:55', '2019-05-15 10:02:55');
INSERT INTO `article_tag` VALUES (15, 9, 1, '2019-05-15 10:04:59', '2019-05-15 10:04:59');
INSERT INTO `article_tag` VALUES (16, 9, 4, '2019-05-15 10:04:59', '2019-05-15 10:04:59');
INSERT INTO `article_tag` VALUES (17, 9, 5, '2019-05-15 10:04:59', '2019-05-15 10:04:59');
INSERT INTO `article_tag` VALUES (18, 9, 6, '2019-05-15 10:04:59', '2019-05-15 10:04:59');
INSERT INTO `article_tag` VALUES (19, 9, 7, '2019-05-15 10:04:59', '2019-05-15 10:04:59');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '分类', '描述', 'www.baidu.com', '2019-05-03 10:34:47', '2019-05-03 10:34:47');
INSERT INTO `category` VALUES (2, '分类2', '分类2', 'www.google.com', '2019-05-13 12:02:12', '2019-05-13 12:02:12');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(7) NOT NULL,
  `article_id` int(7) NOT NULL,
  `content` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` int(8) NULL DEFAULT NULL,
  `to_uid` int(7) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `comment_user_id_fk`(`user_id`) USING BTREE,
  CONSTRAINT `comment_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `ID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `CODE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `PARENT_ID` int(11) NULL DEFAULT NULL COMMENT '父资源编码->菜单',
  `URI` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址URL',
  `TYPE` smallint(4) NULL DEFAULT NULL COMMENT '类型 1:菜单menu 2:资源element(rest-api) 3:资源分类',
  `METHOD` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问方式 GET POST PUT DELETE PATCH',
  `ICON` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `STATUS` smallint(4) NULL DEFAULT 1 COMMENT '状态   1:正常、9：禁用',
  `CREATE_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `UPDATE_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 145 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源信息表(菜单,资源)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (101, 'ACCOUNT_LOGIN', '用户登录', 103, '/account/login', 2, 'POST', NULL, 1, NULL, NULL);
INSERT INTO `resource` VALUES (103, 'GROUP_ACCOUNT', '账户系列', 110, '', 3, 'POST', NULL, 1, NULL, NULL);
INSERT INTO `resource` VALUES (104, 'USER_MAGE', '用户管理', -1, '/index/user', 1, 'POST', 'fa fa-user', 1, NULL, NULL);
INSERT INTO `resource` VALUES (106, 'RESOURCE_MAGE', '资源配置', -1, '', 1, 'POST', 'fa fa-pie-chart', 1, NULL, NULL);
INSERT INTO `resource` VALUES (107, 'MENU_MANAGE', '菜单管理', 106, '/index/menu', 1, 'POST', 'fa fa-th', 1, NULL, NULL);
INSERT INTO `resource` VALUES (109, 'API_MANAGE', 'API管理', 106, '/index/api', 1, NULL, 'fa fa-share', 1, '2018-04-07 09:40:24', '2018-04-07 09:40:24');
INSERT INTO `resource` VALUES (110, 'CATEGORY_GROUP', '分类集合(API类别请放入此集合)', -1, NULL, 3, NULL, NULL, 1, '2018-04-07 14:27:58', '2018-04-07 14:27:58');
INSERT INTO `resource` VALUES (112, 'ACCOUNT_REGISTER', '用户注册', 103, '/account/register', 2, 'POST', NULL, 1, '2018-04-07 16:21:45', '2018-04-07 16:21:45');
INSERT INTO `resource` VALUES (115, 'GROUP_USER', '用户系列', 110, '', 3, 'GET', NULL, 1, '2018-04-07 16:31:01', '2018-04-07 16:31:01');
INSERT INTO `resource` VALUES (117, 'ROLE_MANAGE', '角色管理', 106, '/index/role', 1, NULL, 'fa fa-adjust', 1, '2018-04-08 05:36:31', '2018-04-08 05:36:31');
INSERT INTO `resource` VALUES (118, 'GROUP_RESOURCE', '资源系列', 110, NULL, 3, NULL, NULL, 1, '2018-04-09 02:29:14', '2018-04-09 02:29:14');
INSERT INTO `resource` VALUES (119, 'USER_ROLE_APPID', '获取对应用户角色', 115, '/user/role', 2, 'GET', NULL, 1, '2018-04-12 03:07:22', '2018-04-12 03:07:22');
INSERT INTO `resource` VALUES (120, 'USER_LIST', '获取用户列表', 115, '/user/list', 2, 'GET', NULL, 1, '2018-04-12 03:08:30', '2018-04-12 03:08:30');
INSERT INTO `resource` VALUES (121, 'USER_AUTHORITY_ROLE', '给用户授权添加角色', 115, '/user/authority/role', 2, 'POST', NULL, 1, '2018-04-12 03:15:56', '2018-04-12 03:15:56');
INSERT INTO `resource` VALUES (122, 'USER_AUTHORITY_ROLE', '删除已经授权的用户角色', 115, '/user/authority/role', 2, 'DELETE', NULL, 1, '2018-04-12 03:29:03', '2018-04-12 03:29:03');
INSERT INTO `resource` VALUES (123, 'RESOURCE_AUTORITYMENU', '获取用户被授权菜单', 118, '/resource/authorityMenu', 2, 'GET', NULL, 1, '2018-04-12 05:30:03', '2018-04-12 05:30:03');
INSERT INTO `resource` VALUES (124, 'RESOURCE_MENUS', '获取全部菜单列', 118, '/resource/menus', 2, 'GET', NULL, 1, '2018-04-12 05:42:46', '2018-04-12 05:42:46');
INSERT INTO `resource` VALUES (125, 'RESOURCE_MENU', '增加菜单', 118, '/resource/menu', 2, 'POST', NULL, 1, '2018-04-12 06:15:39', '2018-04-12 06:15:39');
INSERT INTO `resource` VALUES (126, 'RESOURCE_MENU', '修改菜单', 118, '/resource/menu', 2, 'PUT', NULL, 1, '2018-04-12 06:16:35', '2018-04-12 06:16:35');
INSERT INTO `resource` VALUES (127, 'RESOURCE_MENU', '删除菜单', 118, '/resource/menu', 2, 'DELETE', NULL, 1, '2018-04-12 06:17:18', '2018-04-12 06:17:18');
INSERT INTO `resource` VALUES (128, 'RESOURCE_API', '获取API list', 118, '/resource/api', 2, 'GET', NULL, 1, '2018-04-12 06:18:02', '2018-04-12 06:18:02');
INSERT INTO `resource` VALUES (129, 'RESOURCE_API', '增加API', 118, '/resource/api', 2, 'POST', NULL, 1, '2018-04-12 06:18:42', '2018-04-12 06:18:42');
INSERT INTO `resource` VALUES (130, 'RESOURCE_API', '修改API', 118, '/resource/api', 2, 'PUT', NULL, 1, '2018-04-12 06:19:32', '2018-04-12 06:19:32');
INSERT INTO `resource` VALUES (131, 'RESOURCE_API', '删除API', 118, '/resource/api', 2, 'DELETE', NULL, 1, '2018-04-12 06:20:03', '2018-04-12 06:20:03');
INSERT INTO `resource` VALUES (132, 'GROUP_ROLE', '角色系列', 110, NULL, 3, NULL, NULL, 1, '2018-04-12 06:22:02', '2018-04-12 06:22:02');
INSERT INTO `resource` VALUES (133, 'ROLE_USER', '获取角色关联用户列表', 132, '/role/user', 2, 'GET', NULL, 1, '2018-04-12 06:22:59', '2018-04-12 06:22:59');
INSERT INTO `resource` VALUES (134, 'ROLE_USER', '获取角色未关联用户列表', 132, '/role/user/-/', 2, 'GET', NULL, 1, '2018-04-12 06:24:09', '2018-04-12 06:24:09');
INSERT INTO `resource` VALUES (135, 'ROLE_API', '获取角色关联API资源', 132, '/role/api', 2, 'GET', NULL, 1, '2018-04-12 06:25:32', '2018-04-12 06:25:32');
INSERT INTO `resource` VALUES (136, 'ROLE_API', '获取角色未关联API资源', 132, '/role/api/-/', 2, 'GET', NULL, 1, '2018-04-12 06:26:12', '2018-04-12 06:26:12');
INSERT INTO `resource` VALUES (137, 'ROLE_MENU', '获取角色关联菜单资源', 132, 'role/menu', 2, 'GET', NULL, 1, '2018-04-12 06:27:20', '2018-04-12 06:27:20');
INSERT INTO `resource` VALUES (138, 'ROLE_MENU', '获取角色未关联菜单资源', 132, '/role/menu/-/', 2, 'GET', NULL, 1, '2018-04-12 06:27:56', '2018-04-12 06:27:56');
INSERT INTO `resource` VALUES (139, 'ROLE_AUTHORITY_RESOURCE', '授权资源给角色', 132, '/role/authority/resource', 2, 'POST', NULL, 1, '2018-04-12 06:29:45', '2018-04-12 06:29:45');
INSERT INTO `resource` VALUES (140, 'ROLE_AUTHORITY_RESOURCE', '删除角色的授权资源', 132, '/role/authority/resource', 2, 'DELETE', NULL, 1, '2018-04-12 06:31:12', '2018-04-12 06:31:12');
INSERT INTO `resource` VALUES (141, 'ROLE', '获取角色LIST', 132, 'role', 2, 'GET', NULL, 1, '2018-04-12 06:32:34', '2018-04-12 06:32:34');
INSERT INTO `resource` VALUES (142, 'ROLE', '添加角色', 132, 'role', 2, 'POST', NULL, 1, '2018-04-12 06:33:25', '2018-04-12 06:33:25');
INSERT INTO `resource` VALUES (143, 'USER', '更新角色', 132, 'role', 2, 'PUT', NULL, 1, '2018-04-12 06:34:27', '2018-04-12 06:34:27');
INSERT INTO `resource` VALUES (144, 'ROLE', '删除角色', 132, 'role', 2, 'DELETE', NULL, 1, '2018-04-12 06:35:15', '2018-04-12 06:35:15');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `ID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `CODE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `STATUS` smallint(4) NULL DEFAULT 1 COMMENT '状态   1:正常、9：禁用',
  `CREATE_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `UPDATE_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 105 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (100, 'role_admin', '管理员角色', 1, NULL, NULL);
INSERT INTO `role` VALUES (102, 'role_user', '用户角色', 1, NULL, NULL);
INSERT INTO `role` VALUES (103, 'role_guest', '访客角色', 1, NULL, NULL);
INSERT INTO `role` VALUES (104, 'role_anon', '非角色', 1, NULL, NULL);

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `ID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID',
  `RESOURCE_ID` int(11) NOT NULL COMMENT '资源ID',
  `CREATE_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `UPDATE_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `ROLE_ID`(`ROLE_ID`, `RESOURCE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, '标签', 'www.baidu.com', '2019-05-03 10:32:16', '2019-05-03 10:32:16');
INSERT INTO `tag` VALUES (2, '标签2', 'www.google.com', '2019-05-03 10:36:27', '2019-05-03 10:36:27');
INSERT INTO `tag` VALUES (3, '标签4', 'www.souhu.com', '2019-05-11 09:16:36', '2019-05-11 09:16:36');
INSERT INTO `tag` VALUES (4, '东京', NULL, '2019-05-15 09:44:20', '2019-05-15 09:44:20');
INSERT INTO `tag` VALUES (5, '西京', NULL, '2019-05-15 09:44:20', '2019-05-15 09:44:20');
INSERT INTO `tag` VALUES (6, '南京', NULL, '2019-05-15 09:44:20', '2019-05-15 09:44:20');
INSERT INTO `tag` VALUES (7, '标签1', NULL, '2019-05-15 09:44:20', '2019-05-15 09:44:20');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_login_time` timestamp(0) NULL DEFAULT NULL,
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_admin` tinyint(4) NULL DEFAULT 0,
  `status` int(1) NOT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name`(`name`) USING BTREE,
  UNIQUE INDEX `user_email`(`email`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1011 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1000, 'liangfeihu', 'db51a589f5a613b9167fc3675173cd2168d15f1378dd2151a3ec74eaefb47790', 'FZlooHpZ', 'liangfhhd@163.com', '15214353029', '2018-07-06 10:47:38', '雪山飞狐', 'http://thirdwx.qlogo.cn/mmopen/dblNMLLBUzHePvsEX51jyM0hOsPT3Q1VDYibsc8Pjq9Z9TnOhu4bmPP9XxqcF7S6u35qyS5wHLCwsNeianHWerfaHOWzQRpY5Q/132', 1, 1, '2018-07-06 10:47:38', '2018-07-06 10:47:38');
INSERT INTO `user` VALUES (1001, 'liangweijie', '33df963150e257efad0a5c7d9577705b9c1ad114137ff50809b631327a7d4036', 'IpXPpHFf', NULL, NULL, '2018-07-06 11:36:20', '梁伟杰', NULL, 1, 1, '2018-07-06 11:36:20', '2018-07-06 11:36:20');
INSERT INTO `user` VALUES (1002, 'liangweijie2', 'eb05df2b71e3c371448180fa667de29641c80af7402eff6fa226d1829ceae008', 'kowccvio', NULL, NULL, '2018-07-06 11:36:59', '梁伟杰', NULL, 1, 1, '2018-07-06 11:36:59', '2018-07-06 11:36:59');
INSERT INTO `user` VALUES (1003, 'liangweijie3', '1a65cb4d5440d7327faafbd63e969d492d17704b4bd737d728f7d29b81b18ef2', 'MvXx1As8', NULL, NULL, '2018-07-06 11:37:13', '梁伟杰', NULL, 1, 1, '2018-07-06 11:37:13', '2018-07-06 11:37:13');
INSERT INTO `user` VALUES (1004, 'liangweijie6', 'ddbdf4948bfa247433c7bf8b1094f378c29ba2895a016d3357d031743e164144', 'FkFYReqB', NULL, NULL, '2018-07-06 11:37:26', '梁伟杰', NULL, 1, 1, '2018-07-06 11:37:26', '2018-07-06 11:37:26');
INSERT INTO `user` VALUES (1005, 'liangweijie8', 'b4c0fcffe89309a76280129b8e5d1f49f8bc4cc2332df28bb9aaa0ab2972d8d1', 'Q0AYWBtk', NULL, NULL, '2018-07-06 11:37:43', '梁伟杰', NULL, 1, 1, '2018-07-06 11:37:43', '2018-07-06 11:37:43');
INSERT INTO `user` VALUES (1006, 'liangweijie9', 'aa14adb91b6ec8b85ec7cd3341fa7fd7d7963c94135d74d1489ab98524ebf720', 'xFMTlILG', NULL, NULL, '2018-07-06 11:37:48', '梁伟杰', NULL, 1, 1, '2018-07-06 11:37:48', '2018-07-06 11:37:48');
INSERT INTO `user` VALUES (1007, '夏夜3', 'dfdf', NULL, 'dfdf', '15296dfdfds', '2019-05-03 13:09:23', 'xiamengmeng', 'sfsfs', 0, 2, '2019-05-03 13:09:23', '2019-05-03 13:09:23');
INSERT INTO `user` VALUES (1008, 'narcissu', '78b8fdcdfec075f1ad832426a84bf37e92ef49652089762b919c3bdd8d58017f', 'pouJfOd5', '242116@qq.com', '12566564', '2019-05-12 18:32:30', '夏夜', NULL, 1, 3, '2019-05-12 18:32:33', '2019-05-12 18:32:33');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `ID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户角色关联表主键',
  `USER_ID` int(7) NOT NULL COMMENT '用户UID',
  `ROLE_ID` int(11) UNSIGNED NOT NULL COMMENT '角色ID',
  `CREATE_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `UPDATE_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `USER_ID`(`USER_ID`, `ROLE_ID`) USING BTREE,
  INDEX `USER_ROLE_RID_FK`(`ROLE_ID`) USING BTREE,
  CONSTRAINT `USER_ROLE_RID_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `USER_ROLE_UID_FK` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1000, 102, '2019-05-12 18:15:36', '2019-05-12 18:15:36');

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `user_id` int(7) NOT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `expire_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `token_unique`(`token`) USING BTREE,
  INDEX `token_user_id_fk`(`user_id`) USING BTREE,
  CONSTRAINT `token_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_token
-- ----------------------------
INSERT INTO `user_token` VALUES (1, 1000, 'sfffdsfssfs', '2019-05-03 10:31:35', '2019-05-03 10:31:41', '2019-05-03 10:31:41');

SET FOREIGN_KEY_CHECKS = 1;
