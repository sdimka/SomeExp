import streamApiExpl.Converter;
import streamApiExpl.MegaClass;
import streamApiExpl.MyIntImpl;
import streamApiExpl.MyInterface;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        MegaClass megaClass = new MegaClass();
        System.out.println(megaClass.nc);

        try {
            System.out.println("Hello World!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        MyInterface mi = new MyIntImpl();
        System.out.println(mi.getAge(1980));

        System.out.println(" -- - - - - - - - ");
        //Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Converter<String, Integer> converter = Integer::valueOf;
        Integer res = converter.convert("56");
        System.out.println(res);

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");
    }


}
