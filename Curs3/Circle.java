public class Circle extends Figure implements Comparable<Circle>
{
    private Double radius;

    public Circle(Double radius)
    {
        this.radius = radius;
    }
    @Override
    public double getArea()
    {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    @Override
    public String toString()
    {
        return "[ radius: " + radius + " ]";
    }

    @Override
    public int compareTo(Circle o)
    {
        return Double.compare(this.radius, o.getRadius());

    }
}
