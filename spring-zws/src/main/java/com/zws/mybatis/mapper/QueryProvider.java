package com.zws.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @author zhengws
 * @date 2020-02-11 10:10
 */
public class QueryProvider {
    public String selectCategory(@Param("imageId") Set<Integer> imageId){
        final StringBuilder sb = new StringBuilder("select * from category where image_id in (");
        imageId.forEach(id->{
            sb.append(id).append(",");
        });
        sb.deleteCharAt(sb.length() -1);
        sb.append(")");
        return sb.toString();
    }
}
