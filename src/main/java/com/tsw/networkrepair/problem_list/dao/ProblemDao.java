package com.tsw.networkrepair.problem_list.dao;

import com.tsw.networkrepair.problem_list.model.CommentModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemDao {

    //查找某个节点的子节点
    List<CommentModel> select(int ancestor);

    //删除某个子节点或子叶子，需要知道父节点
    void deleteone(@Param("id") int id, @Param("ancestor_id") int ancestor);

    //删除所有此节点，包括它作为子代和父代的所有节点
    void delete(int id);

    //添加节点
    void insert(@Param("id") int id,@Param("ancestor_id") int ancestor);

}
