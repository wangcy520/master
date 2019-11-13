package com.wm.gameplat.core.mapper;
import com.wm.gameplat.core.domain.ExtendLoginInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* @author zi
* @description 推广注册表（tab_extend_login）
* @date 2019-11-13
*/
@Mapper
public interface ExtendLoginMapper {


	/**
	 * 查询推广注册信息表
	 *
	 * @param  params	查询推广注册信息
	 * @return 推广注册信息
	 */
	List<ExtendLoginInfo> selectExtendLoginList(Map<String, Object> params);


	/**
	 * 查询推广注册信息表
	 *
	 * @param  extendLogin	查询推广注册信息
	 * @return 推广注册信息
	 */

	int updateExtendLogin(ExtendLoginInfo extendLogin);





	/**
	 * 新增游戏推广注册信息表
	 *
	 * @param extendLogin
	 * @return 推广注册信息
	 */
	int addExtendLogin(ExtendLoginInfo extendLogin);








	List<ExtendLoginInfo> findByIds(List<Long> ids);
	
	List<ExtendLoginInfo> findByExample(ExtendLoginInfo extendLogin);
	
	int count(ExtendLoginInfo extendLogin);
	

	
	int countByParams(Map<String, Object> params);

	List<ExtendLoginInfo> findAll();



    int delete(Long id);
    
    int saveOrUpdate(ExtendLoginInfo extendLogin);
    
    int batchSave(List<ExtendLoginInfo> extendLoginList);
    
    int batchUpdate(List<ExtendLoginInfo> extendLoginList);
    
    int batchDelete(List<Long> ids);
 }