package Utils;

import Entity.Term;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class Utils {

    public static Term SearchTermById(List<Term> terms, String id) {
        for (Term t : terms) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }

    public static Double averageMark(HashMap<String, String> hm) {
        Double values = 0.0;
        for (String m : hm.values()) {
            values = values + Integer.parseInt(m);
        }
        values = values / hm.size();

        return (Math.ceil(values * 100) / 100);
    }
}
