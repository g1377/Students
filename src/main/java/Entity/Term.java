package Entity;

import java.util.LinkedList;
import java.util.Objects;

public class Term {

    private String id;
    private String name;
    private  String duration;
    private LinkedList<Disciplina> disciplinas = new LinkedList<>();


    public void addDiscipline(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }


    public LinkedList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(LinkedList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return disciplinas.equals(term.disciplinas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplinas);
    }


    @Override
    public String toString() {
        return "Term{" +
                "disciplinas=" + disciplinas +
                '}';
    }
}
