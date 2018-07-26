import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test
{

    private static List<String> words = Arrays.asList("lac","iamac","cartof","telefon","bec");

    public static void main(String[] args)
    {
        exercise1();

        exercise2();

        exercise3();

        exercise4();

        exercise5();
    }


    public static void exercise1()
    {
        List shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
        System.out.println(shortWords);

        List wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
        System.out.println(wordsWithB);

        List evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);
        System.out.println(evenLengthWords);
    }

    public static void exercise2()
    {
        List exclamationWords = StringUtils.transformedList(words, s -> s + "!");
        System.out.println(exclamationWords);

        List eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
        System.out.println(eyeWords);

        List upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);
        System.out.println(upperCaseWords);
    }

    public static void exercise3()
    {
        List<String> results = words.stream().map(String::toUpperCase).filter(s -> s.length() < 4).filter(s -> s.contains("E")).collect(Collectors.toList());
        System.out.println(results.get(0));
    }

    public static void exercise4()
    {
        String[] results =  words.stream().map(String::toUpperCase).filter(s -> s.length() < 4).filter(s -> s.contains("E")).toArray(String[]::new);
        System.out.println(Arrays.asList(results));
    }

    public static void exercise5()
    {
        String str = words.stream().reduce("",(s1,s2) -> s1.toUpperCase() + s2.toUpperCase());
        System.out.println(str);

    }

}
