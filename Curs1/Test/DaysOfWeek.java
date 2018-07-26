package Test;

enum DaysOfWeek
{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;




    private DaysOfWeek() // modifier 'private' is redundant for enum constructors
    {
        System.out.println("new DaysOfWeek created");
    }



/*
    public DaysOfWeek() // modifier 'public' not allowed here
    {
        System.out.println("new DaysOfWeek created");
    }
*/


}
