package com.chris.demo.repositories;

import com.chris.demo.DemoApplication;
import com.chris.demo.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserRepositoryTest {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void shouldAddUserIntoDBSuccessfullyGivenProperStudentObjectProvided(){
//        User user = new User();
//        user.setFirstName("abc");
//        user.setLastName("def");
//        User returnedStudent = userRepository.save(user);
//        Assertions.assertEquals("abc", returnedStudent.getFirstName());
//        Assertions.assertEquals("def", returnedStudent.getLastName());
//        Assertions.assertNotNull(returnedStudent.getId());
//    }
}
