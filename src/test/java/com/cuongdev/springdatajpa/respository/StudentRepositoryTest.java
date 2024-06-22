package com.cuongdev.springdatajpa.respository;

import com.cuongdev.springdatajpa.entity.Guardian;
import com.cuongdev.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("cuong2k2hanam@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
                //.guardianName("Nikhil")
                //.guardianEmail("nikhil@gmail.com")
                //.guardianMobile("0862964913")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWidthGuardian() {
        Guardian guardian = Guardian.builder()
                .email("cuong2k2hanam@gmail.com")
                .name("Nikhil")
                .mobile("0862964913")
                .build();

        Student student = Student.builder()
                .emailId("cuong@gmail.com")
                .firstName("Cuong")
                .lastName("Tran")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList =" + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("uong");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("Nikhil");
        System.out.println("students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "cuong2k2hanam@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "cuong@gmail.com"
                );

        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printGetStudentsByEmailAddressNative() {
        Student student =
                studentRepository.getStudentsByEmailAddressNative(
                        "cuong@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentsByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentsByEmailAddressNativeNamedParam(
                        "cuong@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "Dinh Cuong",
                "cuong@gmail.com");

    }
}