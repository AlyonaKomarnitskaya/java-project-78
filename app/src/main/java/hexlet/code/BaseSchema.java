package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate> conditions = new ArrayList<>();
    private boolean cheking = false;

    public void addCondition(Predicate condition) {
        conditions.add(condition);
    }

    public final boolean isValid(Object obj) {
        if (obj == null) {
            return cheking ? false : true;
        }
        for (Predicate condition : conditions) {
            if (!condition.test(obj)) {
                return false;
            }
        }
        return true;
    }

    protected void setRequiredOn() {
        cheking = true;
    }

    protected void restart() {
        conditions.clear();
    }
}
