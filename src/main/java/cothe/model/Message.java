package cothe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message {

    private List<Map<String, String>> mapList = new ArrayList<>();

    public void addElement(String key, String value){
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        mapList.add(map);

    }

}
