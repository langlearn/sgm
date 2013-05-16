package com.bdt.action;

import com.bdt.bean.User;
import com.bdt.bean.UserExample;
import com.bdt.common.base.MyActionSupport;
import com.bdt.common.util.MD5Util;
import com.bdt.mapper.UserMapper;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yang
 * Date: 13-5-12
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
@Results(
        @Result(name="loginPage",location="/index.jsp",type="redirect")
)
public class LoginAction extends MyActionSupport<User> {

    private User model=new User();

    @Override
    public User getModel() {
        return model;
    }

    @Inject
    private UserMapper userMapper;

    public void verify(){
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(model.getUsername());
        List<User> users=userMapper.selectByExample(example);
        if(users.size()>0){
            User user=users.get(0);
            if(MD5Util.getMD5Str(model.getUserpwd()).equals(user.getUserpwd())){
                session.put("optid",user.getId());
                session.put("loginUser",user);
                responseUtil.writeSuccess(response);
            }else {
                responseUtil.writeFailAndError(response,"密码错误，请重新输入!");
            }
        }else {
            responseUtil.writeFailAndError(response,"该用户不存在!");
        }
    }

    public String loginOff() {
        session.clear();
        return "loginPage";
    }
}
