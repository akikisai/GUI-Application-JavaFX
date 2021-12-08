// Listing 10-6: LocalDate test

import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("本日は、" + today);
        System.out.printf("%d年%d月%d日 %s(%d)\n", today.getYear(),
                today.getMonthValue(), today.getDayOfMonth(),
                today.getDayOfWeek(), today.getDayOfWeek().getValue());

        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("Gy年M月d日 E(e)");
        System.out.println(df1.format(today));
        
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("Gy年M月d日 E(e)").
                withChronology(JapaneseChronology.INSTANCE);
        System.out.println(df2.format(today));
        System.out.println();

        System.out.println("昨日は、" + today.plusDays(-1));
        System.out.println("明日は、" + today.plusDays(1));

        LocalDate tokyo2020 = LocalDate.of(2021, 7, 23);
        System.out.println("東京オリンピック、" + tokyo2020);
        System.out.printf("開会式まであと%d日\n",
                tokyo2020.toEpochDay() - today.toEpochDay());
    }
}
