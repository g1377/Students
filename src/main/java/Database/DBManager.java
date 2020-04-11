package Database;

import Entity.Accaunt;
import Entity.Disciplina;
import Entity.Student;
import Entity.Term;
import Utils.DBUtils;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;

import java.sql.*;
import java.util.*;

public class DBManager {
    private static Connection connection;
    private static PreparedStatement modifyDStm;
    private static PreparedStatement addDisc;
    private static PreparedStatement addStud;
    private static PreparedStatement deletStud;
    private static PreparedStatement modStud;
    private static PreparedStatement dellDisc;
    private static PreparedStatement getAccByLogPass;
    private static PreparedStatement createTerm;
    private static PreparedStatement getAllActiveTerms;
    private static PreparedStatement addDiscForTerm;
    private static PreparedStatement modifyTerm;
    private static PreparedStatement modifyTermByDisc;
    private static PreparedStatement updateDurationTerm;
    private static PreparedStatement deleteTerm;
    private static PreparedStatement progresStudentByTerm;


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
            createTerm = connection.prepareStatement("INSERT INTO `student_crm`.`term` (`name`, `duration`) VALUES (?, ?);");
            getAllActiveTerms = connection.prepareStatement("SELECT * FROM term_discipline td left join term t on td.id_term =  t.id left join discipline d on td.id_disc = d.id where status = 1 order by t.name");
            addDiscForTerm = connection.prepareStatement("INSERT INTO term_discipline (id_term, id_disc) values (?,?);");
            modifyTerm = connection.prepareStatement("delete from term_discipline where id_term = ?;");
            updateDurationTerm = connection.prepareStatement("update term set duration = ? where id = ?;");
            modifyTermByDisc = connection.prepareStatement("insert into term_discipline(id_term, id_disc) values (?,?);");
            deleteTerm = connection.prepareStatement("delete from term where id = ? ;");
            progresStudentByTerm = connection.prepareStatement("SELECT * FROM marks m left join term_discipline t on m.id_term_disc = t.id left join discipline d on  t.id_disc = d.id where  m.id_student = ? and t.id_term= ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        return connection;
    }


    public static void deleteTermbyId(String id) {
        DBManager.deleteTerm(id);
        try {
            deleteTerm.setString(1, id);
            deleteTerm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


    public static void modifyTermByDisc(String idTerm, String[] disciplines, String duration) {
        try {
            for (String d : disciplines) {
                modifyTermByDisc.setString(1, idTerm);
                modifyTermByDisc.setString(2, d);
                modifyTermByDisc.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTerm(String idTerm) {
        try {
            modifyTerm.setString(1, idTerm);
            modifyTerm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDuration(String idTerm, String duration) {
        try {
            updateDurationTerm.setString(1, duration);
            updateDurationTerm.setString(2, idTerm);
            updateDurationTerm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Term> getAllActiveTerms() {
        List<Term> terms = new ArrayList<>();
        try {
            ResultSet rs = getAllActiveTerms.executeQuery();
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getString("id_term"));
                term.setDuration(rs.getString("duration"));
                term.setName(rs.getString("name"));
                Disciplina disciplina = new Disciplina();
                disciplina.setDisciplina(rs.getString("discipline"));
                disciplina.setId(rs.getInt("id"));
                if (!DBUtils.isCointainsTerm(terms, term)) {
                    term.addDiscipline(disciplina);
                    terms.add(term);
                } else terms.get(terms.size() - 1).addDiscipline(disciplina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return terms;
    }

    public static List<Term> getAllTerm() {
        List<Term> terms = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select * from term");
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getString("id"));
                term.setName(rs.getString("name"));
                terms.add(term);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return terms;
    }

    public static void createTerm(String name, String duraton, String[] disciplines) {
        try {
            createTerm.setString(1, name);
            createTerm.setString(2, duraton);
            createTerm.execute();

            String idTerm = DBUtils.getIdTermByName(name, DBManager.getAllTerm());
            for (Term t : DBManager.getAllTerm()) {
                System.out.println(t.getName());
            }
            for (String d : disciplines) {
                addDiscForTerm.setString(1, idTerm);
                addDiscForTerm.setString(2, d);
                addDiscForTerm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public static HashMap<String, String> progresStudentByTerm(String idStudent, String idTerm) {
        HashMap<String, String> resP = new HashMap<>();
        try {
            progresStudentByTerm.setString(1, idStudent);
            progresStudentByTerm.setString(2, idTerm);
            ResultSet rs = progresStudentByTerm.executeQuery();
            while (rs.next()) {
                resP.put(rs.getString("discipline"), rs.getString("mark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resP;
    }


}
