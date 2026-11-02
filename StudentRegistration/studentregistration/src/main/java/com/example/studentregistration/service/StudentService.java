
package com.example.studentregistration.service;

import com.example.studentregistration.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    // Register a new student
    public Student registerStudent(Student student) {
        students.add(student);
        return student;
    }

    // Get all registered students
    public List<Student> getAllStudents() {
        return students;
    }

    // Find student by ID
    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    // Update student details
    public Student updateStudent(int studentId, Student updatedStudent) {
        Student existingStudent = getStudentById(studentId);

        if (existingStudent != null) {
            existingStudent.setStudentName(updatedStudent.getStudentName());
            existingStudent.setCourseName(updatedStudent.getCourseName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setAge(updatedStudent.getAge());

            return existingStudent;
        }

        return null;
    }

    // Delete student registration
    public boolean deleteStudent(int studentId) {
        Student student = getStudentById(studentId);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }
}
