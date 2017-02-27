import java.util.ArrayList;

public class VacationPlanner {

    public static String plan(ArrayList<String> route) {
        if (checkForBranches(route)) {
            return "Error: input has branches";
        }
        if (checkForLoop(route)) {
            return "Error: input has a loop";
        }
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

    public static boolean checkForBranches(ArrayList<String> route) {
        ArrayList<String> dependencies = new ArrayList<>();
        for (String destination : route) {
            if (destination.split(" => ").length > 1) {
                String dependency = destination.split(" => ")[1];
                if (dependencies.contains(dependency)) {
                    return true;
                } else {
                    dependencies.add(dependency);
                }
            }
        }
        return false;
    }

    public static boolean checkForLoop(ArrayList<String> route) {
        int destinationCounter = 0;
        int dependencyCounter = 0;
        for (String destination : route) {
            destinationCounter++;
            if (destination.split(" => ").length > 1) {
                dependencyCounter++;
            }
        }
         return destinationCounter == dependencyCounter;
    }
}