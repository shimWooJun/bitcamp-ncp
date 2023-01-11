package bitcamp.bootapp.dao;

import java.util.Arrays;
import bitcamp.bootapp.vo.Instructor;

public class InstructorDao {
  private static final int SIZE = 100;

  private int no;
  private int count;
  private Instructor[] instructors = new Instructor[SIZE];

  public void insert(Instructor instructor) {
    instructor.setNo(++no);
    this.instructors[this.count++] = instructor;
  }

  public Instructor[] findAll() {
    return Arrays.copyOf(instructors, count);
  }

  public Instructor findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.instructors[i].getNo() == no) {
        return this.instructors[i];
      }
    }
    return null;
  }

  public void update(Instructor instructor) {
    this.instructors[this.indexOf(instructor)] = instructor;
  }

  public void delete(Instructor instructor) {
    for (int i = this.indexOf(instructor) + 1; i < this.count; i++) {
      this.instructors[i - 1] = this.instructors[i];
    }
    this.instructors[--this.count] = null; // 레퍼런스 카운트를 줄인다.
  }

  private int indexOf(Instructor a) {
    for (int i = 0; i < this.count; i++) {
      if (this.instructors[i].getNo() == a.getNo()) {
        return i;
      }
    }
    return -1;
  }
}
