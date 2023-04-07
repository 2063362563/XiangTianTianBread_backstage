package com.fan.xiangtiantianbread.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.xiangtiantianbread.pojo.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConsumerMapper extends BaseMapper<Consumer> {

    /**
     * 分页展示员工数据
     */
    @Select("select * from consumer limit ${(page-1)*10},10")
    List<Consumer> getAllConsumer(Integer page);

    /**
     * 根据name或者id模糊查询查询员工
     */
    @Select("select * from consumer where name like concat('%',#{queryContent},'%') or id like concat('%',#{queryContent},'%')")
    List<Consumer> getConsumerByNameOrId(String queryContent);

    /**
     * 返回总员工数
     */
    @Select("SELECT COUNT(id) FROM consumer")
    Integer getConsumerTotal();

}
