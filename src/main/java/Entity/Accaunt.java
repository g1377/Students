package Entity;

public class Accaunt {

    private String name;
    private String pass;
    private String role;

    public Accaunt() {
    }

    public Accaunt(String name, String pass, String role) {
        this.name = name;
        this.pass = pass;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
