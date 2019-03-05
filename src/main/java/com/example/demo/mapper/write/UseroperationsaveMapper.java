package com.example.demo.mapper.write;

import com.example.demo.generator.pojo.Useroperationsave;

import java.util.List;

public interface UseroperationsaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Useroperationsave record);

    int insertSelective(Useroperationsave record);

    Useroperationsave selectByPrimaryKey(Integer id);

    Useroperationsave selectByName(String productName);

    List<Useroperationsave> selectLable();

    int updateByPrimaryKeySelective(Useroperationsave record);

    int updateByPrimaryKey(Useroperationsave record);
}