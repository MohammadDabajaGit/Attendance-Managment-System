package sample.Model;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Datasource {

    private static final String DB_NAME = "university";
    private static final String DB_LOCATION ="jdbc:mysql://localhost:3306/";
    private static final String STUDENT_QUERY = "SELECT stid,snum,sname FROM student WHERE snum like ? AND sname LIKE ?";
    private static final String TEACHER_QUERY = "SELECT tid,tnum,tname FROM teacher WHERE tnum LIKE ? AND tname LIKE ?";
    private static final String COURSE_QUERY = "SELECT * FROM course WHERE cnum LIKE ? AND cname LIKE ?";
    private static final String SESSION_QUERY = "SELECT s.sid, s.sname, c.cid, c.cnum, cname, t.tid, t.tnum, t.tname, r.rid, r.rname, s.description, date_time " +
                                                "FROM session s, course c, teacher t, room r " +
                                                "WHERE s.cid = c.cid AND s.tid = t.tid AND r.rid = s.rid AND " +
                                                        "s.sname LIKE ? AND c.cnum LIKE ? AND c.cname LIKE ? AND t.tnum LIKE ? AND t.tname LIKE ? AND r.rname LIKE ? AND s.description LIKE ?";

    private static final String ATTENDANCE_QUERY = "SELECT a.attid, st.stid, st.snum, st.sname, s.sid, s.sname,c.cid,c.cnum,c.cname, a.attended_from, a.attended_to, s.date_time " +
                                                    "FROM attendance a, session s, course c, student st " +
                                                    "WHERE s.cid = c.cid AND a.attender_id = st.stid AND s.sid = a.sid AND " +
                                                        "  st.snum LIKE ? AND st.sname LIKE ? AND s.sname LIKE ? AND c.cnum = ? AND c.cname LIKE ?";
    private static final String COURSE_REGISTRATION_QUERY = "SELECT s.stid,s.snum, s.sname,c.cid, c.cnum, c.cname FROM student s, course c, course_registration r WHERE r.cid=c.cid AND s.stid=r.stid AND s.snum LIKE ? AND s.sname LIKE ? AND c.cnum LIKE ? AND c.cname LIKE ?";
    private static final String TEACHERS_COURSE_QUERY = "SELECT t.tid,t.tnum, t.tname, c.cid,c.cnum, c.cname FROM teacher t, course c, teaches r WHERE r.cid=c.cid AND t.tid=r.tid AND t.tnum LIKE ? AND t.tname LIKE ? AND c.cnum LIKE ? AND c.cname LIKE ?";
    private static final String ROOM_QUERY = "SELECT * FROM room WHERE rname LIKE ? AND Capacity > ? AND Capacity < ?";
    private static final String ADMIN_QUERY = "SELECT * FROM admin WHERE name=? AND pass=?";

    private static final String INSERT_STUDENT = "INSERT INTO student(sname,pass) VALUES(?,?)";
    private static final String INSERT_TEACHER = "INSERT INTO teacher(tname,pass) VALUES(?,?)";
    private static final String INSERT_COURSE = "INSERT INTO course VALUES(?,?,?,?)";
    private static final String INSERT_SESSION = "INSERT INTO session(sname,cid,tid,rid,date_time,description) VALUES(?,?,?,?,?,?)";
    private static final String INSERT_COURSE_REGISTRATION = "INSERT INTO course_registration(stid,cid) VALUES(?,?)";
    private static final String INSERT_TEACHERS_COURSE = "INSERT INTO teaches(tid,cid) VALUES(?,?)";
    private static final String INSERT_ROOM = "INSERT INTO room (rname,capacity) VALUES(?,?)";

    private static final String DELETE_STUDENT = "DELETE FROM student WHERE stid=?";
    private static final String DELETE_TEACHER = "DELETE FROM teacher WHERE tid=?";
    private static final String DELETE_COURSE = "DELETE FROM course WHERE cid=?";
    private static final String DELETE_SESSION = "DELETE FROM session WHERE sid=?";
    private static final String DELETE_COURSE_REGISTRATION = "DELETE FROM course_registration WHERE stid=? AND cid=?";
    private static final String DELETE_TEACHERS_COURSE = "DELETE FROM teaches WHERE tid=? AND cid=?";
    private static final String DELETE_ROOM  = "DELETE FROM room WHERE rid=?";

    private static final String UPDATE_STUDENT = "UPDATE student SET sname=?,pass=? WHERE snum=?";
    private static final String UPDATE_TEACHER = "UPDATE teacher SET tname=?,pass=? WHERE tnum=?";
    private static final String UPDATE_COURSE = "UPDATE course SET cname=?, description=? WHERE cnum=?";
    private static final String UPDATE_SESSION = "UPDATE session SET sname=?,tid=?, cid=?,rid=?,date_time=?, description=? WHERE sid=?";
    private static final String UPDATE_COURSE_REGISTRATION = "UPDATE course_registration SET stid=?, cid=? WHERE stid=? AND cid=?";
    private static final String UPDATE_TEACHERS_COURSE = "UPDATE teaches SET tid=?, cid=? WHERE tid=? AND cid=?";
    private static final String UPDATE_ROOM = "UPDATE room SET rname=?, capacity=? WHERE rid=?";

    private Connection connection;
    private PreparedStatement queryStudentPreparedStatement;
    private PreparedStatement queryTeacherPreparedStatement;
    private PreparedStatement queryCoursePreparedStatement;
    private PreparedStatement querySessionPreparedStatement;
    private PreparedStatement queryAttendancePreparedStatement;
    private PreparedStatement queryCourseRegistrationPreparedStatement;
    private PreparedStatement queryTeachersCoursePreparedStatement;
    private PreparedStatement queryRoomPreparedStatement;
    private PreparedStatement queryAdminPreparedStatement;
    private PreparedStatement insertStudentPreparedStatement;
    private PreparedStatement insertTeacherPreparedStatement;
    private PreparedStatement insertCoursePreparedStatement;
    private PreparedStatement insertSessionPreparedStatement;
    private PreparedStatement insertCourseRegistrationPreparedStatement;
    private PreparedStatement insertTeachersCoursePreparedStatement;
    private PreparedStatement insertRoomPreparedStatement;
    private PreparedStatement deleteStudentPreparedStatement;
    private PreparedStatement deleteTeacherPreparedStatement;
    private PreparedStatement deleteCoursePreparedStatement;
    private PreparedStatement deleteSessionPreparedStatement;
    private PreparedStatement deleteCourseRegistrationPreparedStatement;
    private PreparedStatement deleteTeachersCoursePreparedStatement;
    private PreparedStatement deleteRoomPreparedStatement;
    private PreparedStatement updateStudentPreparedStatement;
    private PreparedStatement updateTeacherPreparedStatement;
    private PreparedStatement updateCoursePreparedStatement;
    private PreparedStatement updateSessionPreparedStatement;
    private PreparedStatement updateCourseRegistrationPreparedStatement;
    private PreparedStatement updateTeachersCoursePreparedStatement;
    private PreparedStatement updateRoomPreparedStatement;

    private static Datasource instance = new Datasource();

    private Datasource() {}

    public static Datasource getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            connection = DriverManager.getConnection(DB_LOCATION+DB_NAME,"ADMIN_UNIVERSITY_GUI","1234");
            queryStudentPreparedStatement = connection.prepareStatement(STUDENT_QUERY);
            queryTeacherPreparedStatement = connection.prepareStatement(TEACHER_QUERY);
            queryCoursePreparedStatement = connection.prepareStatement(COURSE_QUERY);
            querySessionPreparedStatement = connection.prepareStatement(SESSION_QUERY);
            queryAttendancePreparedStatement = connection.prepareStatement(ATTENDANCE_QUERY);
            queryCourseRegistrationPreparedStatement = connection.prepareStatement(COURSE_REGISTRATION_QUERY);
            queryTeachersCoursePreparedStatement = connection.prepareStatement(TEACHERS_COURSE_QUERY);
            queryRoomPreparedStatement = connection.prepareStatement(ROOM_QUERY);
            queryAdminPreparedStatement = connection.prepareStatement(ADMIN_QUERY);

            insertStudentPreparedStatement = connection.prepareStatement(INSERT_STUDENT,Statement.RETURN_GENERATED_KEYS);
            insertTeacherPreparedStatement = connection.prepareStatement(INSERT_TEACHER,Statement.RETURN_GENERATED_KEYS);
            insertCoursePreparedStatement = connection.prepareStatement(INSERT_COURSE);
            insertSessionPreparedStatement = connection.prepareStatement(INSERT_SESSION);
            insertCourseRegistrationPreparedStatement = connection.prepareStatement(INSERT_COURSE_REGISTRATION);
            insertTeachersCoursePreparedStatement = connection.prepareStatement(INSERT_TEACHERS_COURSE);
            insertRoomPreparedStatement = connection.prepareStatement(INSERT_ROOM);

            deleteStudentPreparedStatement = connection.prepareStatement(DELETE_STUDENT);
            deleteTeacherPreparedStatement = connection.prepareStatement(DELETE_TEACHER);
            deleteCoursePreparedStatement = connection.prepareStatement(DELETE_COURSE);
            deleteSessionPreparedStatement = connection.prepareStatement(DELETE_SESSION);
            deleteCourseRegistrationPreparedStatement = connection.prepareStatement(DELETE_COURSE_REGISTRATION);
            deleteTeachersCoursePreparedStatement = connection.prepareStatement(DELETE_TEACHERS_COURSE);
            deleteRoomPreparedStatement = connection.prepareStatement(DELETE_ROOM);

            updateStudentPreparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            updateTeacherPreparedStatement = connection.prepareStatement(UPDATE_TEACHER);
            updateCoursePreparedStatement = connection.prepareStatement(UPDATE_COURSE);
            updateSessionPreparedStatement = connection.prepareStatement(UPDATE_SESSION);
            updateCourseRegistrationPreparedStatement = connection.prepareStatement(UPDATE_COURSE_REGISTRATION);
            updateTeachersCoursePreparedStatement = connection.prepareStatement(UPDATE_TEACHERS_COURSE);
            updateRoomPreparedStatement = connection.prepareStatement(UPDATE_ROOM);
            return true;
        } catch (SQLException e) {
            System.out.println("open error:" + e.getMessage());
            return false;
        }

    }

    public boolean queryAdmin(String name,String pass) {
        try {
            System.out.println("querying admin ...");
            queryAdminPreparedStatement.setString(1,name);
            queryAdminPreparedStatement.setString(2,pass);
            ResultSet results = queryAdminPreparedStatement.executeQuery();
            if(!results.next()) {
                return false;
            }
            return true;
        } catch(SQLException e) {
            System.out.println(" Query error: " + e.getMessage());
            return false;
        }
    }

    public ObservableList<Room> queryRooms(String rname,int capacityFrom,int capacityTO) {
        ObservableList<Room> rooms =  FXCollections.observableArrayList();
        try {
            System.out.println("querying rooms ...");
            queryRoomPreparedStatement.setString(1,rname+"%");
            queryRoomPreparedStatement.setInt(2,capacityFrom);
            queryRoomPreparedStatement.setInt(3,capacityTO);
            ResultSet results = queryRoomPreparedStatement.executeQuery();
            while(results.next()) {
                Room room = new Room(results.getInt(1),results.getString(2),results.getInt(3));
                rooms.add(room);
            }
            return rooms;
        } catch(SQLException e) {
            System.out.println(" Query error: " + e.getMessage());
            return null;
        }
    }

    public ObservableList<Student> queryStudents(String snum,String sname) {
        ObservableList<Student> students =  FXCollections.observableArrayList();
        try {
            System.out.println("querying students ...");
            queryStudentPreparedStatement.setString(1,snum+"%");
            queryStudentPreparedStatement.setString(2,sname+"%");
            ResultSet results = queryStudentPreparedStatement.executeQuery();
            while(results.next()) {
                Student student = new Student(results.getInt(1),results.getString(2),results.getString(3));
                students.add(student);
            }
            return students;
        } catch(SQLException e) {
            System.out.println(" Query error: " + e.getMessage());
            return null;
        }
    }

    public ObservableList<Course> queryCourses(String cnum, String cname) {
        ObservableList<Course> courses =  FXCollections.observableArrayList();
        try {
            System.out.println("querying courses ...");
            queryCoursePreparedStatement.setString(1,cnum+"%");
            queryCoursePreparedStatement.setString(2,cname+"%");
            ResultSet results = queryCoursePreparedStatement.executeQuery();
            while(results.next()) {
                Course course = new Course(results.getString(1),results.getString(2),results.getString(3),results.getString(4));
                courses.add(course);
            }
            return courses;
        } catch(SQLException e) {
            System.out.println(" Query error: " + e.getMessage());
            return null;
        }
    }

    public ObservableList<Teacher> queryTeacher(String tnum,String tname) {
        ObservableList<Teacher> teachers =  FXCollections.observableArrayList();
        try {
            System.out.println("querying teachers ...");
            queryTeacherPreparedStatement.setString(1,tnum+"%");
            queryTeacherPreparedStatement.setString(2,tname+"%");
            ResultSet results = queryTeacherPreparedStatement.executeQuery();
            while(results.next()) {
                Teacher teacher = new Teacher(results.getInt(1),results.getString(2),results.getString(3));
                teachers.add(teacher);
            }
            return teachers;
        } catch(SQLException e) {
            System.out.println(" Query error: " + e.getMessage());
            return null;
        }
    }

    public ObservableList<Session> querySession(String sname,String cnum,String cname,String tnum,String tname,String rname, String description) {
        ObservableList<Session> sessions =  FXCollections.observableArrayList();
        try {
            System.out.println("querying sessions ...");
            querySessionPreparedStatement.setString(1,"%"+sname+"%");
            querySessionPreparedStatement.setString(2,cnum+"%");
            querySessionPreparedStatement.setString(3,cname+"%");
            querySessionPreparedStatement.setString(4,tnum+"%");
            querySessionPreparedStatement.setString(5,tname+"%");
            querySessionPreparedStatement.setString(6,rname+"%");
            querySessionPreparedStatement.setString(7,"%"+description+"%");
            ResultSet results = querySessionPreparedStatement.executeQuery();
            while(results.next()) {
                Session session = new Session(results.getInt(1),results.getString(2),results.getString(3),results.getString(4),results.getString(5),results.getInt(6),results.getString(7),results.getString(8),results.getInt(9),results.getString(10),results.getString(11),results.getTimestamp(12));
                sessions.add(session);
            }
            return sessions;
        } catch(SQLException e) {
            System.out.println(" Query error: " + e.getMessage());
            return null;
        }
    }

    public ObservableList<Attendence> queryAttendance(String attenderId, String attenderName, String sname, String cnum, String cname) {
        ObservableList<Attendence> attendences =  FXCollections.observableArrayList();
        try {
            System.out.println("querying attendances ...");
            queryAttendancePreparedStatement.setString(1,attenderId+"%");
            queryAttendancePreparedStatement.setString(2,attenderName+"%");
            queryAttendancePreparedStatement.setString(3,sname+"%");
            queryAttendancePreparedStatement.setString(4,cnum+"%");
            queryAttendancePreparedStatement.setString(5,cname+"%");
            ResultSet results = queryAttendancePreparedStatement.executeQuery();
            while(results.next()) {
                Attendence attendence = new Attendence(results.getInt(1),results.getInt(2),results.getString(3),results.getString(4),results.getInt(5),results.getString(6),results.getInt(7),results.getString(8),results.getString(9),results.getTimestamp(10),results.getTimestamp(11),results.getTimestamp(12));
                attendences.add(attendence);
            }
            return attendences;
        } catch(SQLException e) {
            System.out.println(" Query error: " + e.getMessage());
            return null;
        }
    }

    public ObservableList<CourseRegistration> queryCourseRegistration(String snum, String sname, String cnum, String cname) {
        ObservableList<CourseRegistration> courseRegistrations =  FXCollections.observableArrayList();
        try {
            System.out.println("querying course registrations ...");
            queryCourseRegistrationPreparedStatement.setString(1,snum+"%");
            queryCourseRegistrationPreparedStatement.setString(2,sname+"%");
            queryCourseRegistrationPreparedStatement.setString(3,cnum+"%");
            queryCourseRegistrationPreparedStatement.setString(4,cname+"%");
            ResultSet results = queryCourseRegistrationPreparedStatement.executeQuery();
            while(results.next()) {
                CourseRegistration courseRegistration = new CourseRegistration(results.getInt(1),results.getString(2),results.getString(3),results.getString(4),results.getString(5),results.getString(6));
                courseRegistrations.add(courseRegistration);
            }
            return courseRegistrations;
        } catch(SQLException e) {
            System.out.println(" Query error: " + e.getMessage());
            return null;
        }
    }

    public ObservableList<TeachersCourse> queryTeachersCourse(String tnum, String tname, String cnum, String cname) {
        ObservableList<TeachersCourse> teachersCourses =  FXCollections.observableArrayList();
        try {
            System.out.println("querying teachers courses ...");
            queryTeachersCoursePreparedStatement.setString(1,tnum+"%");
            queryTeachersCoursePreparedStatement.setString(2,tname+"%");
            queryTeachersCoursePreparedStatement.setString(3,cnum+"%");
            queryTeachersCoursePreparedStatement.setString(4,cname+"%");
            ResultSet results = queryTeachersCoursePreparedStatement.executeQuery();
            while(results.next()) {
                TeachersCourse teachersCourse = new TeachersCourse(results.getInt(1),results.getString(2),results.getString(3),results.getString(4),results.getString(5),results.getString(6));

                teachersCourses.add(teachersCourse);
            }
            return teachersCourses;
        } catch(SQLException e) {
            System.out.println(" Query error: " + e.getMessage());
            return null;
        }
    }

    public String insertRoom(String rname,int capacity) {
        try {
            insertRoomPreparedStatement.setString(1,rname);
            insertRoomPreparedStatement.setInt(2,capacity);
            System.out.println(insertRoomPreparedStatement.executeUpdate() + " rows are insert");
            ResultSet result = insertRoomPreparedStatement.getGeneratedKeys();
            result.next();
            return "id: " + result.getInt(1) ;
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
        return "";
    }

    public String insertStudent(String sname,String pass) {
        try {
            insertStudentPreparedStatement.setString(1,sname);
            insertStudentPreparedStatement.setString(2,pass);
            System.out.println(insertStudentPreparedStatement.executeUpdate() + " rows are updated");
            ResultSet result = insertStudentPreparedStatement.getGeneratedKeys();
            result.next();
            return "id: " + result.getInt(1) ;
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
        return "";
    }


    public String insertTeacher(String tname,String pass) {
        try {
            insertTeacherPreparedStatement.setString(1,tname);
            insertTeacherPreparedStatement.setString(2,pass);
            System.out.println(insertTeacherPreparedStatement.executeUpdate() + " rows are updated");
            ResultSet result = insertTeacherPreparedStatement.getGeneratedKeys();
            result.next();
            return "id: " + result.getInt(1) ;
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
        return "";
    }

    public String insertCourse(String cid,String cname,String description) {
        try {
            insertCoursePreparedStatement.setString(1,cid);
            insertCoursePreparedStatement.setString(2,cid);
            insertCoursePreparedStatement.setString(3,cname);
            insertCoursePreparedStatement.setString(4,description);
            System.out.println(insertCoursePreparedStatement.executeUpdate() + " rows are updated");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
            if(e.getMessage().contains("Duplicate entry"))
                return "Course Id already Exist";
        }
        return "";
    }

    public String insertSession(String sname,String cid,String tid,String rid,Timestamp begin,String description) {
        try {
            insertSessionPreparedStatement.setString(1,sname);
            insertSessionPreparedStatement.setString(2,cid);
            insertSessionPreparedStatement.setString(3,tid);
            insertSessionPreparedStatement.setString(4,rid);
            insertSessionPreparedStatement.setTimestamp(5,begin);
            insertSessionPreparedStatement.setString(6,description);
            System.out.println(insertSessionPreparedStatement.executeUpdate() + " rows are updated");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
            if(e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails"))
                return "either course or teacher or room is not found";
        }
        return "";
    }


    public String insertCourseRegistration(String sid,String cid) {
        try {
            insertCourseRegistrationPreparedStatement.setString(1,sid);
            insertCourseRegistrationPreparedStatement.setString(2,cid);
            System.out.println(insertCourseRegistrationPreparedStatement.executeUpdate() + " rows are updated");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
            if(e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails"))
                return "either course or student are not found";
            if(e.getMessage().contains("Duplicate entry"))
                return "course already registered to this student";
        }
        return "";
    }

    public String insertTeachersCourse(String tid,String cid) {
        try {
            insertTeachersCoursePreparedStatement.setString(1,tid);
            insertTeachersCoursePreparedStatement.setString(2,cid);
            System.out.println(insertTeachersCoursePreparedStatement.executeUpdate() + " rows are updated");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
            if(e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails"))
                return "either course or teacher are not found";
            if(e.getMessage().contains("Duplicate entry"))
                return "course already given to this teacher";
        }
        return "";
    }

    public void deleteRoom(int rid) {
        try {
            deleteRoomPreparedStatement.setInt(1,rid);
            System.out.println(deleteRoomPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void deleteStudent(int sid) {
        try {
            deleteStudentPreparedStatement.setInt(1,sid);
            System.out.println(deleteStudentPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void deleteTeacher(int tid) {
        try {
            deleteTeacherPreparedStatement.setInt(1,tid);
            System.out.println(deleteTeacherPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void deleteCourse(String cid) {
        try {
            deleteCoursePreparedStatement.setString(1,cid);
            System.out.println(deleteCoursePreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void deleteSession(int sid) {
        try {
            deleteSessionPreparedStatement.setInt(1,sid);
            System.out.println(deleteSessionPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void deleteCourseRegistration(int sid,String cid) {
        try {
            deleteCourseRegistrationPreparedStatement.setInt(1,sid);
            deleteCourseRegistrationPreparedStatement.setString(2,cid);
            System.out.println(deleteCourseRegistrationPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void deleteTeachersCourse(int tid, String cid) {
        try {
            deleteTeachersCoursePreparedStatement.setInt(1,tid);
            deleteTeachersCoursePreparedStatement.setString(2,cid);
            System.out.println(deleteTeachersCoursePreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void updateRoom(int rid,String rname,int capacity) {
        try {
            updateRoomPreparedStatement.setInt(3,rid);
            updateRoomPreparedStatement.setString(1,rname);
            updateRoomPreparedStatement.setInt(2,capacity);

            System.out.println(updateRoomPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void updateStudent(String sid,String sname,String pass) {
        try {
            updateStudentPreparedStatement.setString(1,sname);
            updateStudentPreparedStatement.setString(2,pass);
            updateStudentPreparedStatement.setString(3,sid);

            System.out.println(updateStudentPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void updateTeacher(String tid,String tname,String pass) {
        try {
            updateTeacherPreparedStatement.setString(1,tname);
            updateTeacherPreparedStatement.setString(2,pass);
            updateTeacherPreparedStatement.setString(3,tid);
            System.out.println(updateTeacherPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public void updateCourse(String cid,String cname, String description) {
        try {
            updateCoursePreparedStatement.setString(1,cname);
            updateCoursePreparedStatement.setString(2,description);
            updateCoursePreparedStatement.setString(3,cid);
            System.out.println(updateCoursePreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }

    public String updateSession(int sid,String sname,String tid,String cid,String rid,Timestamp time,String description) {
        try {
            updateSessionPreparedStatement.setString(1,sname);
            updateSessionPreparedStatement.setString(2,tid);
            updateSessionPreparedStatement.setString(3,cid);
            updateSessionPreparedStatement.setString(4,rid);
            updateSessionPreparedStatement.setTimestamp(5,time);
            updateSessionPreparedStatement.setString(6,description);
            updateSessionPreparedStatement.setInt(7,sid);
            System.out.println(updateSessionPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
            if (e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails"))
                return "either course or teacher or room is not found";
        }
        return "";
    }

    public String updateCourseRegistration(String newSid,String newCid, String sid,String cid) {
        try {
            updateCourseRegistrationPreparedStatement.setString(1,newSid);
            updateCourseRegistrationPreparedStatement.setString(2,newCid);
            updateCourseRegistrationPreparedStatement.setString(3,sid);
            updateCourseRegistrationPreparedStatement.setString(4,cid);
            System.out.println(updateCourseRegistrationPreparedStatement.executeUpdate() + " rows deleted");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
            if (e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails"))
                return "either student id or course id is ot found";
            if(e.getMessage().contains("Duplicate entry"))
                return "course already registered to this student";
        }
        return "";
    }

    public String updateTeachersCourse(String oldTid,String oldCid,String newTid,String newCid) {
        try {
            updateTeachersCoursePreparedStatement.setString(1,newTid);
            updateTeachersCoursePreparedStatement.setString(2,newCid);
            updateTeachersCoursePreparedStatement.setString(3,oldTid);
            updateTeachersCoursePreparedStatement.setString(4,oldCid);
            System.out.println(updateTeachersCoursePreparedStatement.executeUpdate() + " rows updated");
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
            if(e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails"))
                return "either teacher id or course id is ot found";
            if(e.getMessage().contains("Duplicate entry"))
                return "course already given to this teacher";
        }
        return "";
    }

    public void close() {
        try {
            if(updateRoomPreparedStatement != null)
                updateRoomPreparedStatement.close();
            if(updateTeachersCoursePreparedStatement != null)
                updateTeachersCoursePreparedStatement.close();
            if(updateCourseRegistrationPreparedStatement != null)
                updateCourseRegistrationPreparedStatement.close();
            if(updateSessionPreparedStatement != null)
                updateSessionPreparedStatement.close();
            if(updateCoursePreparedStatement != null)
                updateCoursePreparedStatement.close();
            if(updateTeacherPreparedStatement != null)
                updateTeacherPreparedStatement.close();
            if(updateStudentPreparedStatement != null)
                updateStudentPreparedStatement.close();

            if(deleteRoomPreparedStatement != null)
                deleteRoomPreparedStatement.close();
            if(deleteTeachersCoursePreparedStatement != null)
                deleteTeachersCoursePreparedStatement.close();
            if(deleteCourseRegistrationPreparedStatement != null)
                deleteCourseRegistrationPreparedStatement.close();
            if(deleteSessionPreparedStatement != null)
                deleteSessionPreparedStatement.close();
            if(deleteCoursePreparedStatement != null)
                deleteCoursePreparedStatement.close();
            if(deleteTeacherPreparedStatement != null)
                deleteTeacherPreparedStatement.close();
            if(deleteStudentPreparedStatement != null)
                deleteStudentPreparedStatement.close();

            if(insertRoomPreparedStatement != null)
                insertRoomPreparedStatement.close();
            if(insertTeachersCoursePreparedStatement != null)
                insertTeachersCoursePreparedStatement.close();
            if(insertCourseRegistrationPreparedStatement != null)
                insertCourseRegistrationPreparedStatement.close();
            if(insertSessionPreparedStatement != null)
                insertSessionPreparedStatement.close();
            if(insertCoursePreparedStatement != null)
                insertCoursePreparedStatement.close();
            if(insertTeacherPreparedStatement != null)
                insertTeacherPreparedStatement.close();
            if(insertStudentPreparedStatement != null)
                insertStudentPreparedStatement.close();

            if(queryRoomPreparedStatement != null)
                queryRoomPreparedStatement.close();
            if(queryTeachersCoursePreparedStatement != null)
                queryTeachersCoursePreparedStatement.close();
            if(queryAttendancePreparedStatement != null)
                queryAttendancePreparedStatement.close();
            if(queryAttendancePreparedStatement != null)
                queryAttendancePreparedStatement.close();
            if(querySessionPreparedStatement != null)
                querySessionPreparedStatement.close();
            if(queryTeacherPreparedStatement != null)
                queryTeacherPreparedStatement.close();
            if(queryStudentPreparedStatement != null)
                queryStudentPreparedStatement.close();
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            System.out.println("close error:" + e.getMessage());
        }
    }
}
