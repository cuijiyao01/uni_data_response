package com.wx;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class UniDataResponseApplicationTests {

  @Test
  void contextLoads() {
    User user1 = new User("张三", 5);
    User user2 = new User("李四", 5);
    User user3 = new User("王五", 5);
    User user4 = new User("赵六", 2);
    User user5 = new User("孙秋", 6);
    User user6 = new User("宋词", 8);
    List<User> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);
    users.add(user3);
    users.add(user4);
    users.add(user5);
    users.add(user6);
    List<User> userList = users.stream().filter(user -> user.getPoint() > 0).collect(Collectors.toList());
    Collections.sort(userList, new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
        return o1.getPoint().compareTo(o2.getPoint());
      }
    });
    System.out.println(userList);
  }
  //[User{name='赵六', point=2}, User{name='张三', point=5}, User{name='李四', point=5}, User{name='王五', point=5}, User{name='孙秋', point=6}, User{name='宋词', point=8}]

  class User {
    private String name;
    private Integer point;

    public User(String name, Integer point) {
      this.name = name;
      this.point = point;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getPoint() {
      return point;
    }

    public void setPoint(Integer point) {
      this.point = point;
    }

    @Override
    public String toString() {
      return "User{" +
          "name='" + name + '\'' +
          ", point=" + point +
          '}';
    }
  }

}
