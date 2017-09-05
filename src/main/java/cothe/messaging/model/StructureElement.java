package cothe.messaging.model;

import cothe.domain.ElementType;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public @Data
class StructureElement implements Iterable<Element>, Element {
    private String id;
    private String name;
    private int length;

    private List<Element> elements = new ArrayList<>();

    public void addElement(Element element) {
        elements.add(element);
    }

    @Override
    public Iterator<Element> iterator() {
        return elements.iterator();
    }

    @Override
    public ElementType getElementType() {
        return ElementType.STRUCTURE;
    }


}
