package Database;

import Entity.Accaunt;
import Entity.Disciplina;
import Entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;
    public static PreparedStatement modifyDStm;
    public static PreparedStatement addDisc;
    public static PreparedStatement addStud;
    public static PreparedStatement deletStud;
    public static PreparedStatement modStud;
    public static PreparedStatement dellDisc;
    private static PreparedStatement getAccByLogPass;
    private static PreparedStatement createTerm;


    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/student_crm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            modifyDStm = connection.prepareStatement("UPDATE discipline SET discipline = ? WHERE id = ?;");
            addDisc = connection.prepareStatement("INSERT INTO `discipline` (`discipline`) VALUES (?);");
            addStud = connection.prepareStatement("INSERT INTO `student_crm`.`student` (`last_name`, `name`, `group`, `date`) VALUES (?,?,?,?);");
            deletStud = connection.prepareStatement("UPDATE student SET status = 0 WHERE id = ?;");
            modStud = connection.prepareStatement("UPDATE `student` SET `last_name` = ?, `name` = ?, `group` = ? , `date` = ?  WHERE (`id` = ?);");
            dellDisc = connection.prepareStatement("UPDATE discipline SET status = 0 WHERE id = ?;");
            getAccByLogPass = connection.prepareStatement("SELECT * FROM user_role left join user on user_role.id_user = user.id  where user.user = ? and user.password = ? and user_role.id_role = ?");
            createTerm = connection.prepareStatement("INSERT INTO term_disc (name_term, term_disciplines, duration) VALUES (?,?,?);");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }


    public static List<Disciplina> getDisciplineList() {
        List<Disciplina> disciplinas = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from discipline where status = 1");
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();

                disciplina.setDisciplina(rs.getString("discipline"));
                disciplina.setId(rs.getInt("id"));
                disciplina.setStatus(rs.getInt("status"));
                disciplinas.add(disciplina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplinas;
    }

    public static List<Student> getStudedentList() {
        List<Student> students = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from student where status = 1");

            while (rs.next()) {
                Student student1 = new Student();

                student1.setId(rs.getInt("id"));
                student1.setLastName(rs.getString("last_name"));
                student1.setName(rs.getString("name"));
                student1.setGroup(rs.getString("group"));
                student1.setDate(rs.getString("date"));
                student1.setStatus(rs.getInt("status"));

                students.add(student1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    public static void addDiscipline(String discipline) {
        try {
            addDisc.setString(1, discipline);
            addDisc.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(String lastName, String name, String group, String date) {
        try {
            addStud.setString(1, lastName);
            addStud.setString(2, name);
            addStud.setString(3, group);
            addStud.setString(4, date);
            addStud.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Disciplina getDiscById(String id) {
        Disciplina disciplina = new Disciplina();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from  discipline where id= " + id + " and status=1;");
            while (rs.next()) {
                disciplina.setId(rs.getInt("id"));
                disciplina.setDisciplina(rs.getString("discipline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplina;
    }

    public static void modifyDiscipline(String id, String value) {
        try {
            modifyDStm.setString(2, id);
            modifyDStm.setString(1, value);
            modifyDStm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteDiscipline(String[] ids) {

        try {
            for (String i : ids) {
                dellDisc.setString(1, i);
                dellDisc.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Student getStudentById(String id) {
        Student student = new Student();
        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(" select * from  student where id= " + id + " and status = 1 ; ");
            while (rs.next()) {
                student.setId(rs.getInt("id"));
                student.setLastName(rs.getString("last_name"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getString("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static void modifyStudent(String id, String lastName, String name, String group, String date) {
        try {
            modStud.setString(5, id);
            modStud.setString(1, lastName);
            modStud.setString(2, name);
            modStud.setString(3, group);
            modStud.setString(4, date);
            modStud.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(String[] ids) {
        try {
            for (String i : ids) {
                deletStud.setString(1, i);
                deletStud.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean getAccByNameRole(String login, String pass, String role) {
        try {
            getAccByLogPass.setString(1, login);
            getAccByLogPass.setString(2, pass);
            getAccByLogPass.setString(3, role);

            ResultSet rs = getAccByLogPass.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void createTerm(String name, String disc, String duration) {
        try {
            createTerm.setString(1, name);
            createTerm.setString(2, disc);
            createTerm.setString(3, duration);
            createTerm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
