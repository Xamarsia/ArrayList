public class Main {
    public Main() {
    }

    static public void serializingAndDeserializingArrayList() {
        SerializationUtil<Integer> util = new SerializationUtil<>();
        int size = 6;
        ArrayList<Integer> array = new ArrayList<Integer>(size);

        for (int i = 0; i < size; ++i) {
            array.add(i);
        }

        ArrayList<Integer> array2 = null;
        try {
            util.serialization(array);
            array2 = util.deserialization();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("array1 " + array.size());
        for (int num : array) {
            System.out.println(num);
        }

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (array2 == null) {
            return;
        }

        System.out.println("array2 " + array2.size());
        for (int num : array2) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        serializingAndDeserializingArrayList();

//        int size = 6;
//        ArrayList<Integer> array = new ArrayList<>(size);
//        ArrayList<Integer> array1 = new ArrayList<Integer>(size);
//        for (int i = 0; i < size; ++i) {
//            array.add(i);
//        }

//        array.add(33);
//        System.out.println(array.size());
//        array.remove(2);
//
//        boolean a = array.contains(33);
//        System.out.println(a);
//
//        for (int num : array) {
//            System.out.println(num);
//        }
    }
}