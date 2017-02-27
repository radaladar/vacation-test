import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VacationPlannerTest {

    ArrayList<String> onePlace = new ArrayList<>();
    ArrayList<String> simpleRoute = new ArrayList<>();
    ArrayList<String> oneDependency = new ArrayList<>();
    ArrayList<String> multipleDependencies = new ArrayList<>();
    ArrayList<String> multipleDependencies2 = new ArrayList<>();

    @Before
    public void setup() {
        onePlace.add("x => ");

        simpleRoute.add("x => ");
        simpleRoute.add("y => ");
        simpleRoute.add("z => ");

        oneDependency.add("x => ");
        oneDependency.add("y => z");
        oneDependency.add("z => ");

        multipleDependencies.add("u => ");
        multipleDependencies.add("v => w");
        multipleDependencies.add("w => z");
        multipleDependencies.add("x => u");
        multipleDependencies.add("y => v");
        multipleDependencies.add("z => ");

        multipleDependencies2.add("u => w");
        multipleDependencies2.add("v => x");
        multipleDependencies2.add("w => y");
        multipleDependencies2.add("x => ");
        multipleDependencies2.add("y => ");
        multipleDependencies2.add("z => u");
    }
    @Test
    public void testOnePlace() {assertEquals("x", VacationPlanner.plan(onePlace));}
    @Test
    public void testSimpleRoute() {assertEquals("xyz", VacationPlanner.plan(simpleRoute));}
    @Test
    public void testOneDependency() {assertEquals("xzy", VacationPlanner.plan(oneDependency));}
    @Test
    public void testMultipleDependencies() {assertEquals("uxzwvy", VacationPlanner.plan(multipleDependencies));}
    @Test
    public void testMultipleDependencies2() {assertEquals("ywuzxv", VacationPlanner.plan(multipleDependencies2));}
}
