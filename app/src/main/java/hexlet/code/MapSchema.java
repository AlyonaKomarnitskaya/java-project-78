package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        addCondition(map -> map instanceof Map<?, ?> && map != null);
        setRequiredOn();
        return this;
    }

    public MapSchema sizeof(int givenMap) {
        addCondition(map -> map instanceof Map && ((Map<?, ?>) map).size() == givenMap);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        addCondition(newMap -> chekingMap((Map<String, BaseSchema>) newMap, map));
        return this;
    }

    public boolean chekingMap(Map<String, BaseSchema> orig, Map<String, BaseSchema> shapedMap) {
        for (Map.Entry<String, BaseSchema> map : shapedMap.entrySet()) {
            String key = map.getKey();
            if (!map.getValue().isValid(orig.get(key))) {
                return false;
            }
        }
        return true;
    }
}
