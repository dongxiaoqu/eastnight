/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : wnsoft

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-07-08 18:17:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` varchar(32) NOT NULL COMMENT '部门id',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父部门id',
  `dept_path` varchar(255) DEFAULT NULL COMMENT '部门路径',
  `dept_name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `status` char(1) DEFAULT NULL COMMENT '部门状态(0正常 1停用)',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标志（0代表存在 2代表删除）',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_dict_data`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` varchar(32) NOT NULL COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_id` varchar(32) DEFAULT '' COMMENT '字典ID',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `creator` varchar(32) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(32) DEFAULT '' COMMENT '更新者',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_dict_type`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` varchar(32) NOT NULL COMMENT '字典主键',
  `dict_name` varchar(128) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(128) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `creator` varchar(32) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(32) DEFAULT '' COMMENT '更新者',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(32) NOT NULL COMMENT '菜单主键',
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父菜单id',
  `menu_path` varchar(32) DEFAULT NULL COMMENT '路由地址',
  `menu_sort` int(4) DEFAULT NULL COMMENT '排序号',
  `menu_icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `menu_type` char(4) DEFAULT NULL COMMENT '菜单类型',
  `status` char(1) DEFAULT NULL COMMENT '菜单状态（0正常 1停用）',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL,
  `modifier` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_post`
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` varchar(32) NOT NULL COMMENT '岗位ID',
  `post_code` varchar(32) DEFAULT NULL COMMENT '岗位编码',
  `post_name` varchar(64) DEFAULT NULL COMMENT '岗位名称',
  `status` char(1) DEFAULT NULL COMMENT '状态（0正常 1停用',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(32) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_post
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(32) NOT NULL COMMENT '角色编码',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_dept_id` varchar(32) NOT NULL COMMENT '主键',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_menu_id` varchar(32) NOT NULL COMMENT '角色菜单主键',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色编码',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单编码',
  PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '登录口令',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `gender` char(1) DEFAULT NULL COMMENT '用户性别(0男 1女 2未知)',
  `age` smallint(3) DEFAULT NULL COMMENT '年龄',
  `status` char(1) DEFAULT '1' COMMENT '状态(1:启用；0:停用)',
  `user_type` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_post`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_post_id` varchar(32) NOT NULL COMMENT '主键',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `post_id` varchar(32) DEFAULT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_role_id` varchar(32) NOT NULL COMMENT '用户角色关系表主键',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编码',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
