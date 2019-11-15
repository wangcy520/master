package com.wm.gameplat.core.mapper;

import com.wm.gameplat.core.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* @author zi
* @description 用户基础信息表（user_info）
* @date 2019-11-14
*/
@Mapper
public interface UserInfoMapper {

	/**
	 * 用户新增代理注册
	 *
	 * @param  userInfo	用户新增代理注册
	 * @return 用户新增代理注册
	 */
	List<UserInfo> addManageLogin (UserInfo userInfo);


	/**
	 * 查询用户列表
	 *
	 * @param  userInfo	查询用户列表
	 * @return 查询用户列表
	 */

	List<UserInfo> selectUserList(UserInfo userInfo);

 }