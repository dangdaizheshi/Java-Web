package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select id, name, create_time, update_time from dept order by update_time desc ;")
    List<Dept> finaAll();

    void deleteByDeptIds(List<Integer> ids);

    @Insert("insert into dept(name, update_time) values(#{name}, #{updateTime});")
    void addDept(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id};")
    Dept selectDeptById(Integer id);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id};")
    void update(Dept dept);
}
