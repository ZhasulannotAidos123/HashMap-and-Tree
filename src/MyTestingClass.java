public class MyTestingClass {
    private int id;
    private String name;
    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode() {
        int multyplying=29;
        int result = multyplying * 3 + id;
        return result;
    }
}
