import java.util.ArrayList;

public class VacationPlanner {

    public static String plan(ArrayList<String> route) {
        StringBuilder plannedRoute = new StringBuilder("");
        for (String destination : route) {
            plannedRoute.append(destination.split(" => ")[0]);
        }
        return plannedRoute.toString();
    }
}