import java.util.Iterator;

public interface ArrayListInterface<Type> extends Iterable<Type> {

    public int size();

    public Type get(int index) throws IndexOutOfBoundsException;

    public void add(Type value);

    public boolean contains(Object object);

    public Type remove(int index) throws IndexOutOfBoundsException;;

    @Override
    public Iterator<Type> iterator();
}
