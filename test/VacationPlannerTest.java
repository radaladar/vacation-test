import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VacationPlannerTest {

    ArrayList<String> onePlace;
    ArrayList<String> simpleRoute;
    ArrayList<String> simpleRouteWithNames;
    ArrayList<String> oneDependeny;
    ArrayList<String> multipleDependencies;

    @Before
    public void setup() {
        onePlace.add("x => ");

        simpleRoute.add("x => ");
        simpleRoute.add("y => ");
        simpleRoute.add("z => ");

        simpleRouteWithNames.add("London => ");
        simpleRouteWithNames.add("Paris => ");
        simpleRouteWithNames.add("Rome  => ");

        oneDependeny.add("x => ");
        oneDependeny.add("y => z");
        oneDependeny.add("z => ");

        multipleDependencies.add("u => ");
        multipleDependencies.add("v => w");
        multipleDependencies.add("w => z");
        multipleDependencies.add("x => u");
        multipleDependencies.add("y => v");
        multipleDependencies.add("z => ");
    }
    @Test
    public void testOnePlace() {assertEquals("x", VacationPlanner.plan(onePlace));}
    @Test
    public void testSimpleRoute() {assertEquals("xyz", VacationPlanner.plan(simpleRoute));}
    @Test
    public void testSimpleRouteWithNames() {assertEquals("LondonParisRome", VacationPlanner.plan(simpleRouteWithNames));}
    @Test
    public void testOneDependency() {assertEquals("xzy", VacationPlanner.plan(oneDependeny));}
    @Test
    public void testMultipleDependencies() {assertEquals("uxzwvy", VacationPlanner.plan(multipleDependencies));}
}