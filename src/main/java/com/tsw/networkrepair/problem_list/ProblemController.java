package com.tsw.networkrepair.problem_list;

import com.tsw.networkrepair.problem_list.model.CommentModel;
import com.tsw.networkrepair.problem_list.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    ProblemService problemService;

    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public List<CommentModel> select(@RequestParam int ancestor){
        return problemService.select(ancestor);
    }

    @RequestMapping("/insert")
    public void insert(@RequestParam int id,int ancestor){
        problemService.insert(id,ancestor);
    }
}
