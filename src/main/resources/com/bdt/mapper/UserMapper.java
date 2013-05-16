package com.bdt.mapper;

import com.bdt.bean.User;
import com.bdt.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="UserName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="UserPwd", property="userpwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="TrueName", property="truename", jdbcType=JdbcType.VARCHAR),
        @Result(column="Department", property="department", jdbcType=JdbcType.VARCHAR),
        @Result(column="ZhiWei", property="zhiwei", jdbcType=JdbcType.VARCHAR),
        @Result(column="ZaiGang", property="zaigang", jdbcType=JdbcType.VARCHAR),
        @Result(column="EmailStr", property="emailstr", jdbcType=JdbcType.VARCHAR),
        @Result(column="Sex", property="sex", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="UserName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="UserPwd", property="userpwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="TrueName", property="truename", jdbcType=JdbcType.VARCHAR),
        @Result(column="Department", property="department", jdbcType=JdbcType.VARCHAR),
        @Result(column="ZhiWei", property="zhiwei", jdbcType=JdbcType.VARCHAR),
        @Result(column="ZaiGang", property="zaigang", jdbcType=JdbcType.VARCHAR),
        @Result(column="EmailStr", property="emailstr", jdbcType=JdbcType.VARCHAR),
        @Result(column="Sex", property="sex", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);
}