package bitcamp.myapp.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import bitcamp.myapp.vo.Student;
import bitcamp.util.BinaryDecoder;
import bitcamp.util.BinaryEncoder;

public class StudentDao {

  List<Student> list;

  int lastNo;

  public StudentDao(List<Student> list) {
    this.list = list;
  }

  public void insert(Student s) {
    s.setNo(++lastNo);
    s.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    list.add(s);
  }

  public Student[] findAll() {
    Student[] students = new Student[list.size()];
    Iterator<Student> i = list.iterator();
    int index = 0;
    while (i.hasNext()) {
      students[index++] = i.next();
    }
    return students;
  }

  public Student findByNo(int no) {
    Student s = new Student();
    s.setNo(no);

    int index = list.indexOf(s);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public void update(Student s) {
    int index = list.indexOf(s);
    list.set(index, s);
  }

  public boolean delete(Student s) {
    return list.remove(s);
  }
  public void save(String filename) {
    try (
        // 1) 바이너리 데이터(바이트배열)를 출력할 도구를 준비한다.
        FileOutputStream out = new FileOutputStream(filename)){

      // 2) 게시글 개수를 출력 : 4byte
      out.write(BinaryEncoder.write(list.size()));

      //3 ) 게시글 출력
      // 목록에서 Board 객체를 꺼내 바이트 배열로 만든 다음 출력한다.

      for(Student s : list) {
        out.write(BinaryEncoder.write(s.getNo()));
        out.write(BinaryEncoder.write(s.getPostNo()));
        out.write(BinaryEncoder.write(s.getBasicAddress()));
        out.write(BinaryEncoder.write(s.getDetailAddress()));
        out.write(BinaryEncoder.write(s.getWorking()));
        out.write(BinaryEncoder.write(s.getGender()));
        out.write(BinaryEncoder.write(s.getLevel()));
        out.write(BinaryEncoder.write(s.getCreatedDate()));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void load(String filename) {
    if(list.size() > 0) { // 중복 로딩 방지!
      return;
    }
    try (

        // 1) 바이너리 데이터를 읽을 도구 준비
        FileInputStream in = new FileInputStream(filename)) {

      // 2) 저장된 게시글 개수를 읽는다: 4byte
      int size = BinaryDecoder.readInt(in);

      // 3) 게시글 개수 만큼 반복해서 데이터를 읽어 Board 객체에 저장한다.
      for(int i = 0; i < size; i++) {
        // 4) 바이너리 데이터를 저장한 순서대로 읽어서 Board 객체에 담는다.
        Student s = new Student();
        s.setNo(BinaryDecoder.readInt(in));
        s.setPostNo(BinaryDecoder.readString(in));
        s.setBasicAddress(BinaryDecoder.readString(in));
        s.setDetailAddress(BinaryDecoder.readString(in));
        s.setWorking(BinaryDecoder.readBoolean(in));
        s.setGender(BinaryDecoder.readChar(in));
        s.setLevel(BinaryDecoder.readByte(in));
        s.setCreatedDate(BinaryDecoder.readString(in));

        // 5) Board 객체를 목록에 추가한다.
        list.add(s);
      }
      if(list.size() > 0) {
        lastNo = list.get(list.size() -1).getNo();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}







