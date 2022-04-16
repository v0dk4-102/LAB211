/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0021;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author DELL
 */
public class Manager {

    GetData getData = new GetData();

    public void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
    }

    private void displayAStudent(ArrayList<Student> studentList, int index) {
        System.out.format("%10s%30s%10d%13s\n", studentList.get(index).getId(),
                studentList.get(index).getName(), studentList.get(index).getSemester(), studentList.get(index).getCourseName());
    }

    private void displayAllStudent(ArrayList<Student> studentList) {
        //check empty
        if (studentList.isEmpty()) {
            System.out.println("Student list is currently empty");
            return;
        }
        System.out.format("%10s%30s%10s%13s\n", "Id", "Student name", "Semester", "Course name");
        //using loop to display each element of studentList
        for (int i = 0; i < studentList.size(); i++) {
            displayAStudent(studentList, i);
        }
    }

    private boolean checkDuplicatedId(ArrayList<Student> studentList, String id, String name) {
        boolean isDuplicated = false;
        //using loop to access each element of studentList
        for (Student student : studentList) {
            //check duplicate
            if (student.getId().compareToIgnoreCase(id) == 0 && student.getName().compareToIgnoreCase(name) != 0) {
                isDuplicated = true;
                break;
            }
        }
        return isDuplicated;
    }

    private boolean checkDuplicatedStudentSemesterAndCourseName(ArrayList<Student> studentList, String id, String name, int semester, String courseName) {
        boolean isDuplicated = false;
        //using loop to access each element of studentList
        for (Student student : studentList) {
            //check whether the same student's info exist
            if (student.getId().compareToIgnoreCase(id) == 0 && student.getName().compareToIgnoreCase(name) == 0
                    && student.getSemester() == semester && student.getCourseName().compareToIgnoreCase(courseName) == 0) {
                isDuplicated = true;
                break;
            }
        }
        return isDuplicated;
    }

    public void createStudent(ArrayList<Student> studentList) {
        System.out.println("-----------Create Student-------------");
        displayAllStudent(studentList);
        /*using loop to create student until number of student greater than 10 and
         user dont want to create anymore*/
        while (true) {
            Student student = new Student();
            // {a,b} match previous token between a and b times
            //[a-zA-Z] include characters in alphabet ignore case
            // \s whitespace character
            // ? match previous token between 0 and 1 time
            // + match previous token between 1 and unlimited times
            String studentName = getData.getString("Enter student's name:", "([a-zA-Z]{1,10}\\s?)+", "Vu Dang Khoa");
            String studentId;
            //using loop to get correct id
            while (true) {
                //[a-zA-Z0-9] include characters in alphabet ignore case and digits from 0 to 9
                studentId = getData.getString("Enter student's id:", "[a-zA-Z0-9]+", "HE000001");
                //check duplicate
                if (checkDuplicatedId(studentList, studentId, studentName)) {
                    System.out.println("You have entered an id that has already existed, please try again");
                    continue;
                }
                break;
            }
            int studentSemester = getData.getInteger("Enter student's semester:", 1, 9);
            String courseName;
            //using loop to get expected input
            while (true) {
                courseName = getData.getString("Enter student's course name:", "", "");
                //check whether course is supported
                if (!courseName.equalsIgnoreCase("Java") && !courseName.equalsIgnoreCase(".Net")
                        && !courseName.equalsIgnoreCase("C") && !courseName.equalsIgnoreCase("C++")) {
                    System.out.println("There are only three courses: Java, .Net and C/C++");
                    System.out.println("Please choose one of them");
                    continue;
                }
                break;
            }
            //with the same student cannot register the same course in the same semester
            if (checkDuplicatedStudentSemesterAndCourseName(studentList, studentId, studentName, studentSemester, courseName)) {
                System.out.println("This student has already registered " + courseName + " in semester " + studentSemester);
                System.out.println("You can register the same course at another semester");
                continue;
            }
            student.setId(studentId);
            student.setName(studentName);
            student.setSemester(studentSemester);
            student.setCourseName(courseName);
            studentList.add(student);
            displayAllStudent(studentList);
            //check whether size of list is greater than 10
            if (studentList.size() > 10) {
                //[yn]: input must be y or n
                String answer = getData.getString("Do you want to continue(Y/N)?", "[yn]", "y or n(case sensitive)");
                if (answer.compareTo("n") == 0) {
                    break;
                }
            }
        }
    }

    private boolean checkNameExistence(ArrayList<Student> studentList, String name) {
        boolean isExisted = false;
        //using loop to access each element of student list
        for (Student student : studentList) {
            //check whether name existed
            if (student.getName().contains(name)) {
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }

    public void findAndSort(ArrayList<Student> studentList) {
        System.out.println("-----------Find and Sort Student-------------");
        //check empty
        if (studentList.isEmpty()) {
            System.out.println("There is no student in list to sort"
                    + ", please choose option 1 to create student first");
            return;
        }
        // {a,b} match previous token between a and b times
        //[a-zA-Z] include characters in alphabet ignore case
        // \s whitespace character
        // ? match previous token between 0 and 1 time
        // + match previous token between 1 and unlimited times
        String name = getData.getString("Enter name of student to search:",
                "([a-zA-Z]{1,10}\\s?)+", "Vu Dang Khoa");
        //check name existence
        if (!checkNameExistence(studentList, name)) {
            System.out.println("There is no student with that name in list");
            return;
        }
        ArrayList<Student> searchResult = new ArrayList<>();
        //using loop to access each element of student list
        for (Student student : studentList) {
            //check whether student's name contain variable name
            if (student.getName().contains(name)) {
                searchResult.add(student);
            }
        }
        System.out.println("---------Search result before sorting----------");
        displayAllStudent(searchResult);
        Collections.sort(searchResult);
        System.out.println("---------Search result after sorting----------");
        displayAllStudent(searchResult);
    }

    private int countResultSearchById(ArrayList<Student> studentList, String id) {
        int count = 0;
        //using loop to access each element of student list
        for (Student student : studentList) {
            //check whether student's id equals to variable id
            if (student.getId().compareToIgnoreCase(id) == 0) {
                count++;
            }
        }
        return count;
    }

    private int countResultSearchBySemester(ArrayList<Student> studentList, int semester, String id) {
        int count = 0;
        //using loop to access each element of student list
        for (Student student : studentList) {
            /*check whether student's semester equals to variable semester
             and student's id equals to variable id*/
            if (student.getSemester() == semester
                    && student.getId().compareToIgnoreCase(id) == 0) {
                count++;
            }
        }
        return count;
    }

    private int countResultSearchByCourseName(ArrayList<Student> studentList, String courseName, String id) {
        int count = 0;
        //using loop to access each element of student list
        for (Student student : studentList) {
            /*check whether student's course name equals to variable course 
             name and student's id equals to variable id*/
            if (student.getCourseName().compareToIgnoreCase(courseName) == 0
                    && student.getId().compareToIgnoreCase(id) == 0) {
                count++;
            }
        }
        return count;
    }

    private int searchById(ArrayList<Student> studentList, String id) {
        int pos = -1;
        //check empty
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty");
        } else {
            /*loop use to access each element of employee list from
             the beginning to the end*/
            for (Student student : studentList) {
                //compare variable id and each id of employee in the list
                if (student.getId().compareToIgnoreCase(id) == 0) {
                    pos = studentList.indexOf(student);
                    break;
                }
            }
        }
        return pos;
    }

    private int searchByIdAndSemester(ArrayList<Student> studentList, String id, int semester) {
        int pos = -1;
        //check empty
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty");
        } else {
            /*loop use to access each element of employee list from
             the beginning to the end*/
            for (Student student : studentList) {
                //compare variable id and each id of employee in the list
                if (student.getId().compareToIgnoreCase(id) == 0
                        && student.getSemester() == semester) {
                    pos = studentList.indexOf(student);
                    break;
                }
            }
        }
        return pos;
    }

    private int searchByIdAndSemesterAndCourseName(ArrayList<Student> studentList, String id, int semester, String courseName) {
        int pos = -1;
        //check empty
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty");
        } else {
            /*loop use to access each element of employee list from
             the beginning to the end*/
            for (Student student : studentList) {
                //compare variable id and each id of employee in the list
                if (student.getId().compareToIgnoreCase(id) == 0
                        && student.getSemester() == semester
                        && student.getCourseName().compareToIgnoreCase(courseName) == 0) {
                    pos = studentList.indexOf(student);
                    break;
                }
            }
        }
        return pos;
    }

    public void updateOrDelete(ArrayList<Student> studentList) {
        //check empty
        if (studentList.isEmpty()) {
            System.out.println("There is no student in list to update/delete");
            System.out.println("Please choose option 1 to create student first");
            return;
        }
        displayAllStudent(studentList);
        String id = getData.getString("Enter student's id:", "[a-zA-Z0-9]+", "HE000001");
        String courseName = "";
        int semester = -1;
        //check id existence
        if (countResultSearchById(studentList, id) == 0) {
            System.out.println("That id does not exist in current student list");
            return;
        }
        //check whether student register more than 1 course
        if (countResultSearchById(studentList, id) > 1) {
            System.out.println("That student have register more than 1 course"
                    + ", please enter more data to exactly update");
            while (true) {
                semester = getData.getInteger("Enter student's semester: ", 1, 9);
                //check whether semester existence
                if (countResultSearchBySemester(studentList, semester, id) == 0) {
                    System.out.println("That student didn't register any course in that semester"
                            + ", please try again");
                    continue;
                }
                break;
            }
            //check whether student register more than 1 course in 1 semester
            if (countResultSearchBySemester(studentList, semester, id) > 1) {
                System.out.println("That student have register more than 1 course"
                        + " in semester " + semester);
                System.out.println("Please enter more data to exactly update");
                while (true) {
                    courseName = getData.getString("Enter student's course name: ", "", "");
                    //check whether course is supported
                    if (!courseName.equalsIgnoreCase("Java") && !courseName.equalsIgnoreCase(".Net")
                            && !courseName.equalsIgnoreCase("C") && !courseName.equalsIgnoreCase("C++")) {
                        System.out.println("There are only three courses: Java, .Net and C/C++");
                        System.out.println("Please choose one of them");
                        continue;
                    }
                    //check whether student register course
                    if (countResultSearchByCourseName(studentList, courseName, id) == 0) {
                        System.out.println("That student didnt register course " + courseName);
                        System.out.println("Please try again");
                        continue;
                    }
                    break;
                }
            }
        }
        int pos;
        //initialize variable pos in three case
        //case 1: student register only 1 course
        //case 2: student register lot of courses but in different semester
        //case 3: student register lot of courses but in the same semester
        if (countResultSearchById(studentList, id) == 1) {
            pos = searchById(studentList, id);
        } else if (countResultSearchBySemester(studentList, semester, id) == 1) {
            pos = searchByIdAndSemester(studentList, id, semester);
        } else {
            pos = searchByIdAndSemesterAndCourseName(studentList, id, semester, courseName);
        }
        String choice = getData.getString("Do you want to update(U) or delete(D) student?", "[UD]", "U or D(case sensive)");
        //perform funcntion base on user's choice
        switch (choice) {
            //updating
            case "U": {
                System.out.println("----------Menu update---------------");
                System.out.println("\t1. Update Student's Name");
                System.out.println("\t2. Update Student's Id");
                System.out.println("\t3. Update Student's semester");
                System.out.println("\t4. Update Student's course name");
                int choiceUpdate = getData.getInteger("Your choice:", 1, 4);
                switch (choiceUpdate) {
                    //update student's name
                    // {a,b} match previous token between a and b times
                    //[a-zA-Z] include characters in alphabet ignore case
                    // \s whitespace character
                    // ? match previous token between 0 and 1 time
                    // + match previous token between 1 and unlimited times
                    //update name
                    case 1: {
                        String nameUpdate = getData.getString("Enter student's name:", "([a-zA-Z]{1,10}\\s?)+", "Vu Dang Khoa");
                        //case student register only one course
                        if (countResultSearchById(studentList, id) == 1) {
                            studentList.get(pos).setName(nameUpdate);
                        }//case student register lot of courses
                        else {
                            //using loop to access each element of student list
                            for (Student student : studentList) {
                                //check whether student's id equals to variable id
                                if (student.getId().compareToIgnoreCase(id) == 0) {
                                    student.setName(nameUpdate);
                                }
                            }
                            System.out.println("======== After Update ========");
                            displayAllStudent(studentList);
                        }
                        break;
                    }
                    //update id
                    case 2: {
                        String idUpdate;
                        boolean checkExistedId = false;
                        while (true) {
                            //[a-zA-Z0-9] include characters in alphabet ignore case and digits from 0 to 9
                            // + match previous token between 1 and unlimited times
                            idUpdate = getData.getString("Enter student's id:", "[a-zA-Z0-9]+", "HE000001");
                            //check whether update id equals to old id
                            if (id.compareToIgnoreCase(idUpdate) == 0) {
                                System.out.println("You have enter old id, please try again");
                                continue;
                            }
                            //check whether id exists
                            if (countResultSearchById(studentList, idUpdate) >= 1) {
                                checkExistedId = true;
                                boolean isDuplicate = false;
                                for (Student student : studentList) {
                                    if (idUpdate.compareToIgnoreCase(student.getId()) == 0
                                            && studentList.get(pos).getCourseName().compareToIgnoreCase(student.getCourseName()) == 0
                                            && studentList.get(pos).getSemester() == student.getSemester()) {
                                        System.out.println("Duplicate!!");
                                        isDuplicate = true;
                                        break;
                                    }
                                }
                                if (isDuplicate) {
                                    System.out.println("Please try again");
                                    continue;
                                } else {
                                    for (Student student : studentList) {
                                        if (student.getId().compareToIgnoreCase(idUpdate) == 0) {
                                            studentList.get(pos).setId(idUpdate);
                                            studentList.get(pos).setName(student.getName());
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                        }
                        if (!checkExistedId) {
                            studentList.get(pos).setId(idUpdate);
                        }
                        System.out.println("======== After Update ========");
                        displayAllStudent(studentList);
                        break;
                    }
                    //update semester
                    case 3: {
                        int semesterUpdate;
                        while (true) {
                            semesterUpdate = getData.getInteger("Enter semester:", 1, 9);
                            //check whether update semester equals old semester
                            if (semesterUpdate == studentList.get(pos).getSemester()) {
                                System.out.println("You have enter old semester,"
                                        + " please try again");
                                continue;
                            }
                            int newPos = searchByIdAndSemester(studentList, id, semesterUpdate);
                            //check whether semester exists
                            if (newPos == -1) {
                                break;
                            }
                            //check whether course name's existence at update semester
                            if (studentList.get(pos).getCourseName().compareToIgnoreCase(studentList.get(newPos).getCourseName()) == 0) {
                                System.out.println("You have enter a semester in which course name existed");
                                continue;
                            }
                            break;
                        }
                        studentList.get(pos).setSemester(semesterUpdate);
                        System.out.println("======== After Update ========");
                        displayAllStudent(studentList);
                        break;
                    }
                    //update course name
                    case 4: {
                        if (countResultSearchBySemester(studentList, semester, id) == 3) {
                            System.out.println("You can not update course name of student"
                                    + " in semester " + semester);
                            System.out.println("Because this student has already registered "
                                    + "3 courses");
                            return;
                        }
                        String courseNameUpdate;
                        while (true) {
                            courseNameUpdate = getData.getString("Enter student's course name:", "", "");
                            //check whether course is supported
                            if (!courseNameUpdate.equalsIgnoreCase("Java")
                                    && !courseNameUpdate.equalsIgnoreCase(".Net")
                                    && !courseNameUpdate.equalsIgnoreCase("C")
                                    && !courseNameUpdate.equalsIgnoreCase("C++")) {
                                System.out.println("There are only three courses: Java, .Net and C/C++");
                                System.out.println("Please choose one of them");
                                continue;
                            }
                            //check whether update course name equals to old course name
                            if (courseNameUpdate.compareToIgnoreCase(studentList.get(pos).getCourseName()) == 0) {
                                System.out.println("You have entered old course name"
                                        + ", please try again");
                                continue;
                            }
                            int newPos = searchByIdAndSemesterAndCourseName(studentList, id, semester, courseNameUpdate);
                            //check whether course name exist in semester
                            if (newPos == -1) {
                                break;
                            } else {
                                System.out.println("You have enter existed student's "
                                        + "course name in semester " + studentList.get(pos).getSemester());
                                continue;
                            }
                        }
                        studentList.get(pos).setCourseName(courseNameUpdate);
                        System.out.println("======== After Update ========");
                        displayAllStudent(studentList);
                        break;
                    }
                }
                break;
            }
            //deleting
            case "D": {
                studentList.remove(pos);
                System.out.println("======== After Delete ========");
                displayAllStudent(studentList);
                break;
            }
        }
    }

    public void report(ArrayList<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("There is no registered course, please"
                    + " choose option 1 to add student first and course");
        }
        ArrayList<Student> tempList = new ArrayList<>();
        //using temporary list to store separate course's students
        //access each element of student list 
//        for (Student student : studentList) {
//            //check whether student register a course exactly 1 time
//            if (countResultSearchByCourseName(studentList, student.getCourseName(), student.getId()) == 1) {
//                tempList.add(student);
//            }
//        }
        //access each element of student list 
        for (Student student : studentList) {
            //check whether course of student has existed in temporary list
            if (countResultSearchByCourseName(tempList, student.getCourseName(), student.getId()) < 1) {
                tempList.add(student);
            }
        }
        //access each element of temporary list
        for (Student student : tempList) {
            System.out.print(student.getName() + " | " + student.getCourseName()
                    + " | " + countResultSearchByCourseName(studentList, student.getCourseName(), student.getId()) + "\n");
        }
    }
}
