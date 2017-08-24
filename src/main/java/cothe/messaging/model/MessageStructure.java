package cothe.messaging.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageStructure implements Iterable<Element>{
    private String structureId;
    private List<Element> elements = new ArrayList<>();

    public void addElement(Element element){
        elements.add(element);
    }

    @Override
    public Iterator<Element> iterator() {
        return elements.iterator();
    }
}
