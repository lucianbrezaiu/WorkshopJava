import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringUtils
{
    public static List<String> allMatches(List<String> words, Predicate<String> condition)
    {
        return words.stream().filter(condition).collect(Collectors.toList());
    }


    public static List<String> transformedList(List<String> words, Function<String,String> condition)
    {
        return words.stream().map(condition).collect(Collectors.toList());
    }






}
