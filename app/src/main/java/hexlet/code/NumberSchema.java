package hexlet.code;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addCondition(num -> num instanceof Integer && num != null);
        setRequiredOn();
        return this;
    }

    public NumberSchema positive() {
        addCondition(num -> num instanceof Integer && Integer.parseInt(num.toString()) > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCondition(num -> num instanceof Integer && min <= Integer.parseInt(num.toString())
                && Integer.parseInt(num.toString()) <= max);
        return this;
    }

}
