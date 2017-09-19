package cothe.messaging;

import java.io.Serializable;
import java.util.*;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 19.
 */
public class MessageHeaders implements Map<String, Object> {
    private final Map<String, Object> headers;

    public MessageHeaders(Map<String, Object> headers) {
        this.headers = (headers != null ? new HashMap<>(headers) : new HashMap<>());


    }

    @Override
    public boolean containsKey(Object key) {
        return this.headers.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.headers.containsValue(value);
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return Collections.unmodifiableMap(this.headers).entrySet();
    }

    @Override
    public Object get(Object key) {
        return this.headers.get(key);
    }

    @Override
    public boolean isEmpty() {
        return this.headers.isEmpty();
    }

    @Override
    public Set<String> keySet() {
        return Collections.unmodifiableSet(this.headers.keySet());
    }

    @Override
    public int size() {
        return this.headers.size();
    }

    @Override
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(this.headers.values());
    }

    @Override
    public Object put(String key, Object value) {
        throw new UnsupportedOperationException("MessageHeaders is immutable");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> map) {
        throw new UnsupportedOperationException("MessageHeaders is immutable");
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException("MessageHeaders is immutable");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("MessageHeaders is immutable");
    }


}
