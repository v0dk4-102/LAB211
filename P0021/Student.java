/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0021;

/**
 *
 * @author DELL
 */
public class Student implements Comparable<Student>{
    private int semester;
    private String id,name,courseName;

    public Student() {
    }

    public Student(String id, int semester, String name, String courseName) {
        this.id = id;
        this.semester = semester;
        this.name = name;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", semester=" + semester + ", name=" + name + ", courseName=" + courseName + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
    
}
