import java.util.ArrayList;

public class VacationPlanner {
    
    public static String plan(ArrayList<String> route) {
        StringBuilder plannedRoute = new StringBuilder("");
        for (String destination : route) {
            String currentDest = destination.split(" => ")[0];
            if (destination.split(" => ").length > 1) {
                String prevDest = destination.split(" => ")[1];
                if (plannedRoute.toString().contains(currentDest)
                && !plannedRoute.toString().contains(prevDest)) {
                    plannedRoute.insert(plannedRoute.toString().indexOf(currentDest), prevDest);
                }
                else if (plannedRoute.toString().contains(prevDest)
                        && !plannedRoute.toString().contains(currentDest)) {
                    plannedRoute.insert(plannedRoute.toString().indexOf(prevDest)+1, currentDest);
                }  else {
                    plannedRoute.append(prevDest);
                    plannedRoute.append(currentDest);
                }
            }
            if (!plannedRoute.toString().contains(currentDest)) {
                plannedRoute.append(currentDest);
            }

        }
        return plannedRoute.toString();
    }
}