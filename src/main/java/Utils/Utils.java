package Utils;

import Entity.Term;

import java.util.List;

public class Utils {

    public static Term SearchTermById(List<Term> terms, String id) {
        for (Term t : terms) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }
}
