import java.util.ArrayList;

public class VacationPlanner {

    public static String plan(ArrayList<String> route) {
        StringBuilder plannedRoute = new StringBuilder("");
        for (String destination : route) {
            String currentDest = destination.split(" => ")[0];
            if (!plannedRoute.toString().contains(currentDest)) {
                plannedRoute.append(currentDest);
            }
            if (destination.split(" => ").length > 1) {
                String prevDest = destination.split(" => ")[1];
                plannedRoute.insert(plannedRoute.toString().indexOf(currentDest), prevDest);
            }
        }
        return plannedRoute.toString();
    }
}