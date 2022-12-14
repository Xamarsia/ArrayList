import java.io.Serializable;
import java.util.Iterator;

public interface ArrayListInterface<Type extends Serializable> extends Serializable, Iterable<Type> {

    int size();

    Type get(int index) throws IndexOutOfBoundsException;

    void add(Type value);

    boolean contains(Object object);

    Type remove(int index) throws IndexOutOfBoundsException;

    @Override
    Iterator<Type> iterator();
}
