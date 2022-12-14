import java.io.*;

public class SerializationUtil<E extends Serializable> {
    private String file = "yourfile.txt";

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return this.file;
    }

    public void serialization(ArrayList<E> array) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(array);
//        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public ArrayList<E> deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ArrayList<E> array = (ArrayList<E>) objectInputStream.readObject();
        objectInputStream.close();

        fileInputStream.close();
        return array;
    }
}
