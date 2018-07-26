import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Test
{
    private List<Figure> figures = new ArrayList<>();
    private Set<Figure> set = new TreeSet<Figure>();

    private void tema()
    {
        Double radius = null;

        do {
            radius = ThreadLocalRandom.current().nextDouble(1,10);

            Figure fig = new Circle(radius);

            set.add(fig);

        }while(radius > 2);
    }

    private void initialization()
    {

        Random random = new Random();
        Double radius = null;

        do {
            radius = random.nextDouble();

            Figure fig = new Circle(radius);

            figures.add(fig);

        }while(radius>0.1);

    }

    private void display()
    {
        set.forEach(System.out::println);
    }

    private void display2()
    {
        set.forEach(x -> System.out.println(x.getArea()));
    }

    public static void main(String[] args)
    {
        Test test = new Test();

        test.tema();

        test.display();

        System.out.println("\n");

        test.display2();
    }
}
