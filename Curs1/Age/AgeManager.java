package Age;

public class AgeManager {

    public String checkAge(int age) {
        if (age < 0) {
            return "Invalid age!";
        }

        switch (age) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "You are in kindergarden.";
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return "You are in elementary school.";
            case 11:
            case 12:
            case 13:
                return "You are in middle school.";
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return "You are in high school.";
            default:
                return "You should be in college.";

        }


    }

}
