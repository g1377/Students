package Utils;

import Entity.Term;

import java.util.List;

public class DBUtils {

    public static boolean isCointainsTerm(List<Term> terms, Term term) {
        for (Term t : terms) {
            if (t.getId().equals(term.getId())) return true;
        }
        return false;
    }

    public static String getIdTermByName(String name, List<Term> terms) {
        for (Term t : terms) {
            if (t.getName().equals(name)) return t.getId();
        }
        return "-1";
    }
}
