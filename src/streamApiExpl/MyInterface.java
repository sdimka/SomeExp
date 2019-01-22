package streamApiExpl;

import java.time.LocalDate;

public interface MyInterface {

    String name = new String();

    String getName();

    default int getAge(int yearBithday){
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear() - yearBithday;
    }

}
