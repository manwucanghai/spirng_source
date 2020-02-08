package com.zws.mybatis.mapper;

import com.zws.mybatis.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhengws
 * @date 2020-01-29 22:32
 */
public interface CategoryMapper {
	@Select("select * from category")
	List<Category> query();

	@Select("select * from category where image_id = #{imageId}")
	List<Category> queryWithImageId(@Param("imageId") Integer imageId);
}
