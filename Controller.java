package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import sample.Model.*;
import java.io.IOException;
import java.util.Optional;


public class Controller {

    //room
    @FXML
    TableView roomTableView;
    @FXML
    TextField roomNameSearchField;
    @FXML
    TextField roomCapacityFromSearchField;
    @FXML
    TextField roomCapacityToSearchField;
    @FXML
    private ObservableList<Room> rooms;

    //student
    @FXML
    TableView studentTableView;
    @FXML
    TextField studentIdSearchField;
    @FXML
    TextField studentNameSearchField;
    @FXML
    private ObservableList<Student> students;


    //teacher
    @FXML
    TableView teacherTableView;
    @FXML
    TextField teacherIdSearchField;
    @FXML
    TextField teacherNameSearchField;
    @FXML
    private ObservableList<Teacher> teachers;

    //course
    @FXML
    TableView courseTableView;
    @FXML
    TextField courseIdSearchField;
    @FXML
    TextField courseNameSearchField;
    @FXML
    private ObservableList<Course> courses;

    //session
    @FXML
    TableView sessionTableView;
    @FXML
    TextField sessionNameSearchField;
    @FXML
    TextField sessionCourseIdSearchField;
    @FXML
    TextField sessionCourseNameSearchField;
    @FXML
    TextField sessionTeacherIdSearchField;
    @FXML
    TextField sessionTeacherNameSearchField;
    @FXML
    TextField sessionRoomNameSearchField;
    @FXML
    TextField sessionDescriptionSearchField;
    @FXML
    private ObservableList<Session> sessions;


    //attendance
    @FXML
    TextField attendanceAttenderIdSearchField;
    @FXML
    TextField attendanceAttenderNameSearchField;
    @FXML
    TextField attendanceSessionNameSearchField;
    @FXML
    TextField attendanceCourseIdSearchField;
    @FXML
    TextField attendanceCourseNameSearchField;
    @FXML
    ObservableList<Attendence> attendances;


    //course registration
    @FXML
    TableView courseRegistrationTableView;
    @FXML
    TextField courseRegistrationStudentIdSearchField;
    @FXML
    TextField courseRegistrationStudentNameSearchField;
    @FXML
    TextField courseRegistrationCourseIdSearchField;
    @FXML
    TextField courseRegistrationCourseNameSearchField;
    @FXML
    ObservableList<CourseRegistration> courseRegistrations;

    // teachers course
    @FXML
    TableView teachersCourseTableView;
    @FXML
    TextField teachersCourseTeacherIdSearchField;
    @FXML
    TextField teachersCourseTeacherNameSearchField;
    @FXML
    TextField teachersCourseCourseIdSearchField;
    @FXML
    TextField teachersCourseCourseNameSearchField;
    @FXML
     ObservableList<TeachersCourse> teachersCourses;

    @FXML
    BorderPane roomDataView;
    @FXML
    BorderPane studentDataView;
    @FXML
    BorderPane teacherDataView;
    @FXML
    BorderPane courseDataView;
    @FXML
    BorderPane sessionDataView;
    @FXML
    BorderPane attendanceDataView;
    @FXML
    BorderPane courseRegistrationDataView;
    @FXML
    BorderPane teachersCourseDataView;

    @FXML
    ListView mainList;

    @FXML
    BorderPane mainPane;

    public void initialize() {
        students.setAll(Datasource.getInstance().queryStudents("",""));
        teachers.setAll(Datasource.getInstance().queryTeacher("",""));
        courses.setAll(Datasource.getInstance().queryCourses("",""));
        sessions.setAll(Datasource.getInstance().querySession("","","","","","",""));
        attendances.setAll(Datasource.getInstance().queryAttendance("","","","",""));
        courseRegistrations.setAll(Datasource.getInstance().queryCourseRegistration("","","",""));
        teachersCourses.setAll(Datasource.getInstance().queryTeachersCourse("","","",""));
        rooms.setAll(Datasource.getInstance().queryRooms("",0,(int)Double.POSITIVE_INFINITY));

        mainList.getItems().add("student");
        mainList.getItems().add("teacher");
        mainList.getItems().add("course");
        mainList.getItems().add("session");
        mainList.getItems().add("attendance");
        mainList.getItems().add("course registration");
        mainList.getItems().add("teachers course");
        mainList.getItems().add("rooms");
        mainList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        studentTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        teacherTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        courseTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        sessionTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        courseRegistrationTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        teachersCourseTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        roomTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        roomTableView.setRowFactory( tv -> {
            TableRow<Room> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    showRoomUpdateDialog(row.getItem());
                }
            });
            return row ;
        });

        studentTableView.setRowFactory( tv -> {
            TableRow<Student> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    showStudentUpdateDialog(row.getItem());
                }
            });
            return row ;
        });

        teacherTableView.setRowFactory( tv -> {
            TableRow<Teacher> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    showTeacherUpdateDialog(row.getItem());
                }
            });
            return row ;
        });

        courseTableView.setRowFactory( tv -> {
            TableRow<Course> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    showCourseUpdateDialog(row.getItem());
                }
            });
            return row ;
        });

        sessionTableView.setRowFactory( tv -> {
            TableRow<Session> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    showSessionUpdateDialog(row.getItem());
                }
            });
            return row ;
        });

        courseRegistrationTableView.setRowFactory( tv -> {
            TableRow<CourseRegistration> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    showCourseRegistrationUpdateDialog(row.getItem());
                }
            });
            return row ;
        });

        teachersCourseTableView.setRowFactory(tv -> {
            TableRow<TeachersCourse> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    showTeachersCourseUpdateDialog(row.getItem());
                }
            });
            return row ;
        });

    }

    @FXML
    public void handleClickMainList() {
        String item = (String)mainList.getSelectionModel().getSelectedItem();
        studentDataView.setVisible(false);
        teacherDataView.setVisible(false);
        courseDataView.setVisible(false);
        sessionDataView.setVisible(false);
        attendanceDataView.setVisible(false);
        courseRegistrationDataView.setVisible(false);
        teachersCourseDataView.setVisible(false);
        roomDataView.setVisible(false);
        switch (item) {
            case "student": {
                System.out.println("student");
                studentDataView.setVisible(true);
                break;
            }
            case "teacher": {
                System.out.println("teacher");
                teacherDataView.setVisible(true);
                break;
            }
            case "course": {
                System.out.println("course");
                courseDataView.setVisible(true);
                break;
            }
            case "session": {
                System.out.println("session");
                sessionDataView.setVisible(true);
                break;
            }
            case "attendance": {
                System.out.println("attendance");
                attendanceDataView.setVisible(true);
                break;
            }
            case "course registration": {
                System.out.println("course registration");
                courseRegistrationDataView.setVisible(true);
                break;
            }
            case "teachers course": {
                System.out.println("teachers course");
                teachersCourseDataView.setVisible(true);
                break;
            }
            case "rooms": {
                System.out.println("rooms");
                roomDataView.setVisible(true);
                break;
            }
        }
    }

    @FXML
    void handleRoomField() {
        System.out.println(roomNameSearchField.getText() + " " + roomCapacityFromSearchField.getText()+ " " +roomCapacityToSearchField.getText());
        rooms.setAll(Datasource.getInstance().queryRooms(roomNameSearchField.getText(),Integer.parseInt(roomCapacityFromSearchField.getText()),Integer.parseInt(roomCapacityToSearchField.getText())));
    }

    @FXML
    void handleStudentField() {
        System.out.println(studentIdSearchField.getText() + " " + studentNameSearchField.getText());
        students.setAll(Datasource.getInstance().queryStudents(studentIdSearchField.getText(),studentNameSearchField.getText()));
    }

    @FXML
    void handleTeacherField() {
        System.out.println(teacherIdSearchField.getText() + " " + teacherNameSearchField.getText());
        teachers.setAll(Datasource.getInstance().queryTeacher(teacherIdSearchField.getText(),teacherNameSearchField.getText()));
    }

    @FXML
    void handleCourseField() {
        System.out.println(courseIdSearchField.getText() + " " + courseNameSearchField.getText());
        courses.setAll(Datasource.getInstance().queryCourses(courseIdSearchField.getText(),courseNameSearchField.getText()));
    }
    @FXML
    void handleSessionField() {
        System.out.println(sessionNameSearchField.getText() + " " + sessionCourseIdSearchField.getText() + " " + sessionCourseNameSearchField.getText() + " " + sessionDescriptionSearchField);
        sessions.setAll(Datasource.getInstance().querySession(sessionNameSearchField.getText(),sessionCourseIdSearchField.getText(),sessionCourseNameSearchField.getText(),sessionTeacherIdSearchField.getText(),sessionTeacherNameSearchField.getText(),sessionRoomNameSearchField.getText(),sessionDescriptionSearchField.getText()));
    }
    @FXML
    void handleAttendanceField() {
        System.out.println(attendanceAttenderIdSearchField.getText() + " " + attendanceAttenderNameSearchField.getText() + " " + attendanceSessionNameSearchField.getText() + " " + attendanceCourseIdSearchField.getText() + " " + attendanceCourseNameSearchField.getText() + "" + attendanceCourseNameSearchField.getText());
        attendances.setAll(Datasource.getInstance().queryAttendance(attendanceAttenderIdSearchField.getText(),attendanceAttenderNameSearchField.getText(),attendanceSessionNameSearchField.getText(),attendanceCourseIdSearchField.getText(),attendanceCourseNameSearchField.getText()));
    }
    @FXML
    void handleCourseRegistrationField() {
        System.out.println(courseRegistrationStudentIdSearchField.getText() + " " + courseRegistrationStudentNameSearchField.getText() + " " + courseRegistrationCourseIdSearchField.getText() + " " + courseRegistrationCourseNameSearchField.getText());
        courseRegistrations.setAll(Datasource.getInstance().queryCourseRegistration(courseRegistrationStudentIdSearchField.getText(),courseRegistrationStudentNameSearchField.getText(),courseRegistrationCourseIdSearchField.getText(),courseRegistrationCourseNameSearchField.getText()));
    }

    @FXML
    void handleTeachersCourseField() {
        System.out.println(teachersCourseTeacherIdSearchField.getText() + " " + teachersCourseTeacherNameSearchField.getText() + " " + teachersCourseCourseIdSearchField.getText() + " " + teachersCourseCourseNameSearchField.getText());
        teachersCourses.setAll(Datasource.getInstance().queryTeachersCourse(teachersCourseTeacherIdSearchField.getText(),teachersCourseTeacherNameSearchField.getText(),teachersCourseCourseIdSearchField.getText(),teachersCourseCourseNameSearchField.getText()));
    }


    public void showRoomInsertDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Add Room");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("roomDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Insert = new ButtonType("Insert");
        dialog.getDialogPane().getButtonTypes().add(Insert);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Insert) {
            RoomController controller = fxmlLoader.getController();
            String error = controller.insertRoom();
            Alert alert = new Alert(Alert.AlertType.INFORMATION,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            rooms.setAll(Datasource.getInstance().queryRooms("",0,(int)Double.POSITIVE_INFINITY));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }


    public void showStudentInsertDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Add Student");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("studentDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Insert = new ButtonType("Insert");
        dialog.getDialogPane().getButtonTypes().add(Insert);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Insert) {
            StudentController controller = fxmlLoader.getController();
            String error = controller.insertStudent();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            students.setAll(Datasource.getInstance().queryStudents("",""));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }
    @FXML
    public void showTeacherInsertDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Add Teacher");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("teacherDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Insert = new ButtonType("Insert");
        dialog.getDialogPane().getButtonTypes().add(Insert);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Insert) {
            TeacherController controller = fxmlLoader.getController();
            String error = controller.insertTeacher();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            teachers.setAll(Datasource.getInstance().queryTeacher("",""));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void showCourseInsertDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Add Course");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("courseDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Insert = new ButtonType("Insert");
        dialog.getDialogPane().getButtonTypes().add(Insert);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Insert) {
            CourseController controller = fxmlLoader.getController();
            String error = controller.insertCourse();
            Alert alert = new Alert(Alert.AlertType.ERROR,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            courses.setAll(Datasource.getInstance().queryCourses("",""));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void showSessionInsertDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Add Session");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sessionDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Insert = new ButtonType("Insert");
        dialog.getDialogPane().getButtonTypes().add(Insert);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Insert) {
            SessionController controller = fxmlLoader.getController();
            String error = controller.insertSession();
            Alert alert = new Alert(Alert.AlertType.ERROR,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            sessions.setAll(Datasource.getInstance().querySession("","","","","","",""));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void showCourseRegistrationInsertDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Register Course");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("courseRegistrationDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Insert = new ButtonType("Insert");
        dialog.getDialogPane().getButtonTypes().add(Insert);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Insert) {
            CourseRegistrationController controller = fxmlLoader.getController();
            String error = controller.insertCourseRegistration();
            Alert alert = new Alert(Alert.AlertType.ERROR,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            courseRegistrations.setAll(Datasource.getInstance().queryCourseRegistration("","","",""));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void showTeachersCourseInsertDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Insert Teacher Course");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("teachersCourseDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Insert = new ButtonType("Insert");
        dialog.getDialogPane().getButtonTypes().add(Insert);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Insert) {
            TeachersCourseController controller = fxmlLoader.getController();
            String error = controller.insertTeacherCourse();
            Alert alert = new Alert(Alert.AlertType.ERROR,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            teachersCourses.setAll(Datasource.getInstance().queryTeachersCourse("","","",""));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void handleRoomDelete() {
        System.out.println("deleting");
        ObservableList cells = roomTableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete");
        alert.setTitle("deleting");
        if (alert.showAndWait().get().equals(alert.getButtonTypes().get(0))) {
            for (Object cell : cells) {
                Datasource.getInstance().deleteRoom(((Room) cell).getRid());
            }
            rooms.setAll(Datasource.getInstance().queryRooms("", 0,(int)Double.POSITIVE_INFINITY));
        }
    }

    @FXML
    public void handleStudentDelete() {
        System.out.println("deleting");
        ObservableList cells = studentTableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete");
        alert.setTitle("deleting");
        if (alert.showAndWait().get().equals(alert.getButtonTypes().get(0))) {
            for (Object cell : cells) {
                Datasource.getInstance().deleteStudent(((Student) cell).getSid());
            }
            students.setAll(Datasource.getInstance().queryStudents("", ""));
        }
    }

        @FXML
        public void handleTeacherDelete() {
            System.out.println("deleting");
            ObservableList cells = teacherTableView.getSelectionModel().getSelectedItems();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to delete");
            alert.setTitle("deleting");
            if(alert.showAndWait().get().equals(alert.getButtonTypes().get(0))) {
                for (Object cell: cells) {
                    Datasource.getInstance().deleteTeacher(((Teacher)cell).getTid());
                }
                teachers.setAll(Datasource.getInstance().queryTeacher("",""));
            }
        }

    @FXML
    public void handleCourseDelete() {
        System.out.println("deleting");
        ObservableList cells = courseTableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to delete");
        alert.setTitle("deleting");
        if(alert.showAndWait().get().equals(alert.getButtonTypes().get(0))) {
            for (Object cell: cells) {
                Datasource.getInstance().deleteCourse(((Course)cell).getCid());
            }
            courses.setAll(Datasource.getInstance().queryCourses("",""));
        }
    }

    @FXML
    public void handleSessionDelete() {
        System.out.println("deleting");
        ObservableList cells = sessionTableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to delete");
        alert.setTitle("deleting");
        if(alert.showAndWait().get().equals(alert.getButtonTypes().get(0))) {
            for (Object cell: cells) {
                Datasource.getInstance().deleteSession(((Session)cell).getSid());
            }
            sessions.setAll(Datasource.getInstance().querySession("","","","","","",""));
        }
    }

    @FXML
    public void handleCourseRegistrationDelete() {
        System.out.println("deleting");
        ObservableList cells = courseRegistrationTableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to delete");
        alert.setTitle("deleting");
        if(alert.showAndWait().get().equals(alert.getButtonTypes().get(0))) {
            for (Object cell: cells) {
                Datasource.getInstance().deleteCourseRegistration(((CourseRegistration)cell).getSid(),((CourseRegistration)cell).getCid());
            }
            courseRegistrations.setAll(Datasource.getInstance().queryCourseRegistration("","","",""));
        }
    }

    @FXML
    public void handleTeacherCourseDelete() {
        System.out.println("deleting");
        ObservableList cells = teachersCourseTableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to delete");
        alert.setTitle("deleting");
        if(alert.showAndWait().get().equals(alert.getButtonTypes().get(0))) {
            for (Object cell: cells) {
                Datasource.getInstance().deleteTeachersCourse(((TeachersCourse)cell).getTid(),((TeachersCourse)cell).getCid());
            }
            teachersCourses.setAll(Datasource.getInstance().queryTeachersCourse("","","",""));
        }
    }

    @FXML
    public void showRoomUpdateDialog(Room room) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Update Room");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("roomDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Update = new ButtonType("Update");
        dialog.getDialogPane().getButtonTypes().add(Update);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        RoomController controller = fxmlLoader.getController();
        controller.setRid(room.getRid());
        controller.nameInsertField.setPromptText(room.getRname());
        controller.nameInsertField.setText(room.getRname());
        controller.capacityInsertField.setPromptText(room.getCapacity().toString());
        controller.capacityInsertField.getEditor().setText(room.getCapacity().toString());
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Update) {
            controller.updateRoom();
            rooms.setAll(Datasource.getInstance().queryRooms("",0,(int)Double.POSITIVE_INFINITY));
            System.out.println("update");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void showStudentUpdateDialog(Student student) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Update Student");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("studentDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Update = new ButtonType("Update");
        dialog.getDialogPane().getButtonTypes().add(Update);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        StudentController controller = fxmlLoader.getController();
        controller.idInsertField.setText(student.getSnum());
        controller.idInsertField.setEditable(false);
        controller.idInsertField.setVisible(true);
        controller.nameInsertField.setPromptText(student.getSname());
        controller.nameInsertField.setText(student.getSname());
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Update) {
            controller.updateStudent();
            students.setAll(Datasource.getInstance().queryStudents("",""));
            System.out.println("update");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void showTeacherUpdateDialog(Teacher teacher) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Update Teacher");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("teacherDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Update = new ButtonType("Update");
        dialog.getDialogPane().getButtonTypes().add(Update);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        TeacherController controller = fxmlLoader.getController();
        controller.idInsertField.setText(teacher.getTnum());
        controller.idInsertField.setEditable(false);
        controller.idInsertField.setVisible(true);
        controller.nameInsertField.setText(teacher.getTname());
        controller.nameInsertField.setPromptText(teacher.getTname());
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Update) {
            controller.updateTeacher();
            teachers.setAll(Datasource.getInstance().queryTeacher("",""));
            System.out.println("update");
        }
        else {
            System.out.println("cancel");
        }
    }


    public void showCourseUpdateDialog(Course course) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Update Course");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("courseDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Update = new ButtonType("Update");
        dialog.getDialogPane().getButtonTypes().add(Update);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        CourseController controller = fxmlLoader.getController();
        controller.idInsertField.setText(course.getCnum());
        controller.idInsertField.setEditable(false);
        controller.nameInsertField.setPromptText(course.getCname());
        controller.nameInsertField.setText(course.getCname());
        controller.descriptionInsertField.setPromptText(course.getDescription());
        controller.descriptionInsertField.setText(course.getDescription());

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Update) {
            controller.updateCourse();
            courses.setAll(Datasource.getInstance().queryCourses("",""));
            System.out.println("delete");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void showSessionUpdateDialog(Session session) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Update Session");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sessionDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Update = new ButtonType("Update");
        dialog.getDialogPane().getButtonTypes().add(Update);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        SessionController controller = fxmlLoader.getController();
        controller.setSid(session.getSid());
        controller.courseInsertField.setPromptText(session.getCnum());
        controller.courseInsertField.setText(session.getCnum());
        controller.nameInsertField.setPromptText(session.getSname());
        controller.nameInsertField.setText(session.getSname());
        //controller.timeInsertField.setValue(session.getBeginTime());
        controller.descriptionInsertField.setPromptText(session.getDescription());
        controller.descriptionInsertField.setText(session.getDescription());
        controller.roomInsertField.setText(session.getRid().toString());
        controller.roomInsertField.setPromptText(session.getRid().toString());
        controller.teacherInsertField.setPromptText(session.getTnum());
        controller.teacherInsertField.setText(session.getTnum());

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Update) {
            String error = controller.updateSession();
            Alert alert = new Alert(Alert.AlertType.ERROR,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            sessions.setAll(Datasource.getInstance().querySession("","","","","","",""));
            System.out.println("update");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void showCourseRegistrationUpdateDialog(CourseRegistration courseRegistration) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("update Registered Course");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("courseRegistrationDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Update = new ButtonType("Update");
        dialog.getDialogPane().getButtonTypes().add(Update);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        CourseRegistrationController controller = fxmlLoader.getController();
        controller.courseInsertField.setPromptText(courseRegistration.getCnum());
        controller.courseInsertField.setText(courseRegistration.getCnum());
        controller.studentInsertField.setPromptText(courseRegistration.getSnum());
        controller.studentInsertField.setText(courseRegistration.getSnum());

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Update) {
            String error = controller.updateCourseRegistration();
            Alert alert = new Alert(Alert.AlertType.ERROR,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            courseRegistrations.setAll(Datasource.getInstance().queryCourseRegistration("","","",""));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void showTeachersCourseUpdateDialog(TeachersCourse teachersCourse) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Update Teacher Course");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("teachersCourseDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Update = new ButtonType("Update");
        dialog.getDialogPane().getButtonTypes().add(Update);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        TeachersCourseController controller = fxmlLoader.getController();
        controller.courseInsertField.setPromptText(teachersCourse.getCnum());
        controller.courseInsertField.setText(teachersCourse.getCnum());
        controller.teacherInsertField.setPromptText(teachersCourse.getTnum());
        controller.teacherInsertField.setText(teachersCourse.getTnum());

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Update) {
            String error = controller.updateTeacherCourse();
            Alert alert = new Alert(Alert.AlertType.ERROR,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            teachersCourses.setAll(Datasource.getInstance().queryTeachersCourse("","","",""));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }
}
