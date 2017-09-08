package cothe.messaging.bind;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
public class SimpleMapEntryValueConcator implements ListConcator<Map.Entry<String, String>> {
    @Override
    public String concat(List<Map.Entry<String, String>> list) {
        return list.stream().map(Map.Entry::getValue).collect(Collectors.joining("|"));
    }
}
