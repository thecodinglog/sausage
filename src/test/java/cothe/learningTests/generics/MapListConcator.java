package cothe.learningTests.generics;

import java.util.List;
import java.util.Map;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
public class MapListConcator implements ListConcator<Map.Entry<String, String>> {

    @Override
    public String concat(List<Map.Entry<String, String>> list) {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(e -> stringBuilder.append(e.getValue()));

        return stringBuilder.toString();
    }
}