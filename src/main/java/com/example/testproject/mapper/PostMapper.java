package com.example.testproject.mapper;

import com.example.testproject.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    public List<Post> listPost();
}
