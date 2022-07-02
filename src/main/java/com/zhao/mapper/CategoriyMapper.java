package com.zhao.mapper;

import com.zhao.pojo.Categoriy;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoriyMapper {
    List<Categoriy> queryCategoriy();
}
