import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt();
            String name = "Name" + i;
            MyTestingClass key = new MyTestingClass(id, name);
            int idstudent=random.nextInt();
            String namestudent="Student"+i;
            Student value=new Student(idstudent,namestudent);
            table.put(key,value);
        }
        table.Count();
        MyBinary<Integer, String> tree = new MyBinary<>();
        tree.put(5, "Apple");
        tree.put(3, "Banana");
        tree.put(7, "Cherry");
        tree.put(2, "Grapes");
        tree.put(4, "Orange");
        tree.put(6, "Mango");
        tree.put(8, "Pineapple");
        List<MyBinary<Integer, String>.Node> nodes = tree.iterator();
        for (MyBinary<Integer, String>.Node node : nodes) {
            System.out.println("key is " + node.getKey() + " and value is " + node.getValue());
        }
    }
}