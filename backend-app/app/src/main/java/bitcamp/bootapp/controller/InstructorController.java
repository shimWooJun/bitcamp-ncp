package bitcamp.bootapp.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.bootapp.dao.InstructorDao;
import bitcamp.bootapp.vo.Instructor;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
@RestController
public class InstructorController {

  InstructorDao instructorDao = new InstructorDao();

  @PostMapping("/instructors")
  public Object addInstructor(
      String name,
      String tel,
      String email,
      byte level,
      String dhk,
      String major,
      int pay
      ) {

    Instructor a = new Instructor();
    a.setName(name);
    a.setTel(tel);
    a.setEmail(email);
    a.setLevel(level);
    a.setDhk(dhk);
    a.setMajor(major);
    a.setPay(pay);
    //    a.setCreatedDate(new Date(System.currentTimeMillis()).toString());

    this.instructorDao.insert(a);

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");

    return contentMap;
  }

  @GetMapping("/instructors")
  public Object getInstructors() {

    Instructor[] instructors = this.instructorDao.findAll();

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");
    contentMap.put("data", instructors);

    return contentMap;
  }


  @GetMapping("/instructors/{instructorNo}")
  public Object getInstructor(@PathVariable int instructorNo) {

    Instructor a = this.instructorDao.findByNo(instructorNo);

    Map<String,Object> contentMap = new HashMap<>();

    if (a == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
    } else {
      contentMap.put("status", "success");
      contentMap.put("data", a);
    }

    return contentMap;
  }

  @PutMapping("/instructors/{no}")
  public Object updateInstructor(
      Instructor instructor) {

    Map<String,Object> contentMap = new HashMap<>();

    Instructor old = this.instructorDao.findByNo(instructor.getNo());
    if (old == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
      return contentMap;
    }

    instructor.setCreatedDate(old.getCreatedDate());

    this.instructorDao.update(instructor);

    contentMap.put("status", "success");

    return contentMap;
  }

  @DeleteMapping("/instructors/{instructorNo}")
  public Object deleteInstructor(
      // 낱개로 받을 때는 @PathVariable 애노테이션을 생략하면 안된다.
      @PathVariable int instructorNo) {

    Instructor a = this.instructorDao.findByNo(instructorNo);

    Map<String,Object> contentMap = new HashMap<>();

    if (a == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");

    } else {
      this.instructorDao.delete(a);
      contentMap.put("status", "success");
    }

    return contentMap;
  }
}
