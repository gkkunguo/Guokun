package com.example.helenkellercompute.guokun.design.MVP.Presenter;


import com.example.helenkellercompute.guokun.design.MVP.Bean.Student;
import com.example.helenkellercompute.guokun.design.MVP.Model.IStudentMode;
import com.example.helenkellercompute.guokun.design.MVP.Model.StudentMode;
import com.example.helenkellercompute.guokun.design.MVP.View.IStudentView;

import java.util.List;

/**
 * 作者：许英俊
 * 中间者
 * 绑定View层和Model层
 */
public class StudentPresenter {

    private IStudentMode studentMode;
    private IStudentView studentView;

    public StudentPresenter(IStudentView studentView) {
        studentMode = new StudentMode();
        this.studentView = studentView;
    }

    /**
     * 通过Model查询学生，在View中展示
     */
    public void queryStudent(){
        studentMode.query(new IStudentMode.onQueryListener() {
            @Override
            public void onComplete(List<Student> students) {
                studentView.showStudent(students);
            }
        });
    }

    /**
     * 通过Model添加学生，在View中更新
     */
    public void addStudent(){
        studentMode.addStudent(new IStudentMode.onAddStudentListener() {
            @Override
            public void onComplete() {
                studentView.refreshStudent();
            }
        });
    }

    /**
     * 通过Model删除学生，在View中更新
     */
    public void deleteStudent(){
        studentMode.deleteStudent(new IStudentMode.onDeleteStudentListener() {
            @Override
            public void onComplete() {
                studentView.refreshStudent();
            }
        });
    }
}
