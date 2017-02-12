package guava_sidepro;

import com.google.common.base.Splitter;
import guava_sidepro.utils.StreamUtils;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String word = "hello,world,hello java,";
        Splitter splitter = Splitter.on(",");
        //splitter.trimResults();
        //splitter = splitter.omitEmptyStrings().trimResults();
        Iterable<String> stringIterable = splitter.split(word);
        stringIterable.forEach(System.out::println);
        StreamUtils.asStream(stringIterable.iterator()).map(s -> s.replaceAll(" ","")).forEach(System.out::println);

        Splitter splitter_2 = Splitter.on('/');
        //splitter_2.trimResults();
        splitter_2 = splitter_2.trimResults();
        Iterable<String> stringIterable2 = splitter_2.split("wrong / wrong / wrong");
        stringIterable2.forEach(System.out::println);

    }
}
