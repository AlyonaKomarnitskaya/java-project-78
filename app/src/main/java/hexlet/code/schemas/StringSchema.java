package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        addCondition(s -> s instanceof String && !"".equals(s) && s != null);
        setRequiredOn();
        return this;
    }

    public StringSchema minLength(int num) {
        addCondition(s -> s.toString().length() >= num);
        return this;
    }

    public StringSchema contains(String substring) {
        addCondition(s -> s.toString().contains(substring));
        return this;
    }
}
