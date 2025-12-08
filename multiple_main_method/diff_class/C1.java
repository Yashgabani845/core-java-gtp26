package multiple_main_method.diff_class;

class C2{
    public static void main(String[] args) {
        System.out.println("From C2");
    }
}
class C1 {
    public static void main(String[] args) {
        System.out.println("From C1");
    }
}

// depends on what you run will work successfully

// need to compile first if you are running using CLI

// java C1 --> output from C1
// java C2 --> output from C2
