package cothe.model;

import java.util.Iterator;
import java.util.List;

public class MessageStructure implements Iterable<Element>{
    private String structureId;
    private List<Element> elements;

    @Override
    public Iterator<Element> iterator() {
        return elements.iterator();
    }
}
