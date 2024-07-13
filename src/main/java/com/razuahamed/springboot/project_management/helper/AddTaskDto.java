package com.razuahamed.springboot.project_management.helper;

import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;

import java.util.List;

public class AddTaskDto {
    public long teamId;
    public String name;
    public List<Integer> membersId;
}
