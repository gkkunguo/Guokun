package com.example.helenkellercompute.guokun.design.MVP.View;


import com.example.helenkellercompute.guokun.design.MVP.Bean.Student;

import java.util.List;

/**
 * 作者：许英俊
 * 视图类
 * 对视图方法的抽象
 */
public interface IStudentView {
    /**
     * 展示学生
     * @param list
     */
    void showStudent(List<Student> list);

    /**
     * 刷新学生
     */
    void refreshStudent();
}
