package test;  
  
public class Test {  
    public static void testmain(String[] args) {  
        int k = 0;  
        int ret = ++k + k++ + ++k + k;  
        // ret的值为多少  
        System.err.println(ret);  
    }  
}  