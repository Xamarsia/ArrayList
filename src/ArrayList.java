import java.util.Iterator;

public class ArrayList<Type> implements ArrayListInterface<Type> {
    private int capacity = 10;
    private int size = 0;

    private Object[] content = {};

    public ArrayList() {
        this.content = new Object[capacity];
    }

    public ArrayList(int initialCapacity) {
        capacity = initialCapacity;
        this.content = new Object[capacity];
    }

    public ArrayList(ArrayList<Type> arraylists) {
        if (arraylists == null) {
            return;
        }
        capacity = arraylists.size() * 2;
        this.content = new Object[capacity];

        for (int i = 0; i < arraylists.size(); i++) {
            content[i] = arraylists.get(i);
            ++size;
        }
    }

    public static class ArrayIterator<Type> implements Iterator<Type> {
        int currentIndex = 0;
        ArrayList<Type> array;

        public ArrayIterator(ArrayList<Type> array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < array.size();
        }

        @Override
        public Type next() {
            Type value = array.get(currentIndex);
            ++currentIndex;
            return value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Type get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return (Type) content[index];
    }

    @Override
    public void add(Type value) {
        if (size == capacity) {
            grow();     // increase current capacity of list
        }
        content[size++] = value;
    }

    @Override
    public boolean contains(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (content[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(content[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Type remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + size);
        }

        Object removedElement = content[index];
        for (int i = index; i < size - 1; i++) {
            content[i] = content[i + 1];
        }
        content[size - 1] = null;
        size--;
        return (Type) removedElement;
    }

    @Override
    public Iterator<Type> iterator() {
        return new ArrayIterator<>(this);
    }

    private void grow() {
        Object[] newContent = new Object[capacity * 2];
        capacity *= 2;
        for (int i = 0; i < size; i++) {
            newContent[i] = content[i];
        }
        content = newContent;
    }
}

