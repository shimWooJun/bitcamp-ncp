package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Student;
import bitcamp.myapp.vo.Teacher;

public interface TeacherDao {

  void insert(Teacher t);

  Teacher[] findAll();

  Teacher findByNo(int no);

  Student[] findByKeyword(String keyword);

  void update(Teacher t);

  boolean delete(Teacher t);

}

