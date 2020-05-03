package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.CompetitionEvent;

public interface CompetitionEventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompetitionEvent record);

    int insertSelective(CompetitionEvent record);

    CompetitionEvent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompetitionEvent record);

    int updateByPrimaryKey(CompetitionEvent record);
}