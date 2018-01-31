package com.tsw.networkrepair.problem_list.service;

import com.tsw.networkrepair.problem_list.dao.ProblemDao;
import com.tsw.networkrepair.problem_list.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {
    @Autowired
    ProblemDao problemDao;

    public List<CommentModel> select(int ancestor){
        return problemDao.select(ancestor);
    }

    public void insert(int id,int ancestor){
         problemDao.insert(id,ancestor);
    }

    public void delete(int id){
        problemDao.delete(id);
    }

    public void deleteone(int id,int ancetor){
        problemDao.deleteone(id,ancetor);
    }
}
