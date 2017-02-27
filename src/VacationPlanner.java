import java.util.ArrayList;

public class VacationPlanner {

    public static String plan(ArrayList<String> route) {
        StringBuilder plannedRoute = new StringBuilder("");
        for (String destination : route) {
            plannedRoute.append(destination.substring(0,1));
        }
        return plannedRoute.toString();
    }
}