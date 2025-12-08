package strings;

public class f1 {
    public static void main(String[] args) {
        String str = "apeksha";

        String s1 = new String("apeksha");

        System.out.println(str==s1);
        System.out.println(str.hashCode()==s1.hashCode());
        System.out.println(str==s1.intern());

        str = "api";
        System.out.println(str);

        str = str.concat(" shah");
        // doesn't use stringbuilder internally
        System.out.println(str);

        str = s1 + " shah";
        // uses stringbuilder internally
        System.out.println(str);





    }
}
