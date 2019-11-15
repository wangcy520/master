package com.wm.gameplat.controller.wage;


import com.wm.gameplat.core.domain.ExtendLoginInfo;
import com.wm.gameplat.core.domain.UserInfo;
import com.wm.gameplat.core.service.ExtendLoginService;
import com.wm.gameplat.core.service.UserInfoService;
import com.wm.gameplat.utils.CreateVerifyCode;
import com.wm.gameplat.utils.QRCodeUtil;
import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.utils.StringUtils;
import com.wm.gameplat.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.wm.gameplat.utils.ResultUtil.error;

/**
 * @author zi
 * @description 用户基础信息表（user_info）
 * @date 2019-11-14
 */

@RestController
@RequestMapping("/system/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    /**
     *  用户新增代理注册
     *  （注册管理）
     * @param userInfo
     */
    @PostMapping(value = "/addManageLogin")
    public Result addManageLogin(UserInfo userInfo) {
/*        // userId不可为null,取操作人为上级代理
        if(StringUtils.isNull(userInfo.getUserId())){
//            UserInfo info =  getUser();
            UserInfo info =  userInfoService.selectUserInfoByUserId(userInfo.getUserId());
            userInfo.setParentId(info.getUserId());
            userInfo.setParentName(info.getUserName());
            userInfo.setAncestralInfo(info.getAncestralInfo()+","+info.getUserName());
            userInfo.setSalt(ShiroUtils.randomSalt());
        }*/

        //用户类型、昵称、真实姓名、电话号码、用户账号、登录密码、奖金设置不可为空
        if(null == userInfo.getUserType()) return error("不可为空");
        if(null == userInfo.getNickName())return error("不可为空");
        if(null == userInfo.getRelName())return  error("不可为空");
        if(null == userInfo.getPhoneNumber())return  error("不可为空");
        if(null == userInfo.getUsername())return  error("不可为空");
        if(null == userInfo.getPassword())return  error("不可为空");
        if(null == userInfo.getRebateId(
                //获得上一级信息得到等级分利规则（未获得上一级权限）
        ))return  error("不可为空");


        return ResultUtil.data(userInfoService.addManageLogin(userInfo));
    }

    /**
     *  查询用户列表
     *
     * @param userInfo
     */
    @GetMapping("/list")//（未完成）
    @ResponseBody
    public Result selectUserList(UserInfo userInfo) {
        return ResultUtil.data(userInfoService.selectUserList(userInfo));
    }





}