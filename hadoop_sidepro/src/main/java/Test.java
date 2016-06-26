import java.io.File;
import java.net.URL;

/**
 * Created by fqc on 2016/6/23.
 */
public class Test {
    public static void main(String[] args) {

        Test tr = new Test();
        //System.out.println(new TestResource().getClass().getClassLoader().getResource(".").getPath());


        File f = new File(Test.class.getClass().getResource("/").getPath());
        System.out.println(f);


        File ff = new File(tr.getClass().getResource("").getPath());
        System.out.println(ff);


//        URL xmlpath = tr.getClass().getClassLoader().getResource("src/main/resources/join_data/student_info.txt");
        URL xmlpath = tr.getClass().getClassLoader().getResource("../");
        System.out.println(xmlpath);


        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(tr.getClass().getResourceAsStream("hadoop_sidepro/src/student_info.txt"));
    }
}

