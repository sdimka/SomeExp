import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateTimeAPITest {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        System.out.println(currentDate.getDayOfYear());
        System.out.println(currentDate.isLeapYear());
        System.out.println(currentDate.getDayOfWeek());

        LocalDate firstDayOfMonth = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);

        LocalDate dayOfMay = LocalDate.of(1980, Month.MAY, 28);
        System.out.println(dayOfMay.getDayOfWeek());

        Period period = Period.between(dayOfMay, currentDate);
        System.out.println(period.getYears());

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        LocalTime currentTimeInNewYork = LocalTime.now(ZoneId.of("America/New_York"));
        System.out.println(currentTimeInNewYork);
        //ZoneId.getAvailableZoneIds().forEach(a -> System.out.println(a));

        System.out.println(currentTimeInNewYork.getHour());
    }

}
