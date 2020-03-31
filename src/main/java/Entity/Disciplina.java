package Entity;

import java.util.Objects;

public class Disciplina {
    private int id;
    private String disciplina;
    private int status = 1;

    public Disciplina() {
    }

    public Disciplina(int id, String disciplina, int status) {
        this.id = id;
        this.disciplina = disciplina;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", disciplina='" + disciplina + '\'' +
                ", status=" + status +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return id == that.id &&
                status == that.status &&
                disciplina.equals(that.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, disciplina, status);
    }
}
