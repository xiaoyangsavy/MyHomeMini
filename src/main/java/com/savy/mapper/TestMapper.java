package com.savy.mapper;

import com.savy.model.Test;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {


    Test getById(@Param("id") Integer id);
}
