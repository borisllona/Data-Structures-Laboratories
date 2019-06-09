
import org.junit.Before;
import java.util.*;
import static org.junit.Assert.*;

    public class TaskTest {
        private List<Long> list1;
        private List<Engineer> engineers;
        private List<Employee> superc;
        private List<Employee> employees;
        private List<Manager> managers;
        private static Manager[] manager = new Manager[3];
        private static Engineer[] engineer = new Engineer[3];
        private static Employee[] employee = new Employee[3];

        @Before
        public void createarr () {
            list1 = Arrays.asList(1L, 2L, 3L, 4L, 5L);
            initEmployeesLists();
        }

        @Before
        public  void initEmployees () {
            employee[0] = new Employee("Boris");
            employee[1] = new Employee("Mario");
            employee[2] = new Employee("Molins");
            manager[0] = new Manager("Dand", 4);
            manager[1] = new Manager("Lafu", 0);
            manager[2] = new Manager("Robert", 2);
            engineer[0] = new Engineer("Galiano");
            engineer[1] = new Engineer("Xuso");
            engineer[2] = new Engineer("Joel");
        }

        private void initEmployeesLists(){
            employees = Arrays.asList(employee);
            managers = Arrays.asList(manager);
            engineers = Arrays.asList(engineer);
            superc = new ArrayList<>();
            superc.addAll(employees);
            superc.addAll(managers);
            superc.addAll(engineers);
        }

        @org.junit.Test
        public void testWithinRange1() {  //Test withinRange amb condicionals i generics
            List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
            assertEquals(Arrays.asList( 1, 2, 3, 4), Task.withinRange(list, 5, 1));
            assertEquals(Collections.emptyList(), Task.withinRange(list, 1, 2));
            assertEquals(Collections.singletonList(1), Task.withinRange(list, 2, 1));
        }

        @org.junit.Test
        public void testWithinRange2() {  //Test withinRange amb Comparable
            assertEquals(Arrays.asList(3L, 4L, 5L), Task.withinRange(list1, 6L, 3L));
            assertEquals(Collections.emptyList(), Task.withinRange(list1, 1L, 2L));
            assertEquals(Collections.singletonList(1L), Task.withinRange(list1, 2L, 1L));
        }

        @org.junit.Test
        public void testWithinRange3() { //Test withinRange amb Comparator
            assertEquals(Arrays.asList(3L, 4L), Task.withinTange(Comparator.naturalOrder(), list1, 5L, 3L));
            assertEquals(Collections.emptyList(), Task.withinTange(Comparator.naturalOrder(), list1, 1L, 2L));
            assertEquals(Collections.singletonList(1L), Task.withinTange(Comparator.naturalOrder(), list1, 2L, 1L));
        }

        @org.junit.Test
        public void testCopyWithRange() {
            List<Long> list3 = new ArrayList<>();
            Task.copyWithRange(list1, list3, 1L, 2L);
            assertEquals(Collections.emptyList(), list3);
            Task.copyWithRange(list1, list3, 5L, 2L);
            assertEquals(Arrays.asList(2L, 3L, 4L), list3);
            list3 = Arrays.asList(10L, 11L, 12L, 13L, 14L);
            Task.copyWithRange(list1, list3, 5L, 2L);
            assertEquals(Arrays.asList(2L, 3L, 4L, 13L, 14L), list3);
        }

        @org.junit.Test
        public void testCopyWithTange() {
            List<Long> list3 = new ArrayList<>();
            Task.copyWithRange(Comparator.naturalOrder(), list1, list3, 1L, 2L);
            assertEquals(Collections.emptyList(), list3);
            Task.copyWithRange(Comparator.naturalOrder(), list1, list3, 5L, 2L);
            assertEquals(Arrays.asList(2L, 3L, 4L), list3);
            list3 = Arrays.asList(10L, 11L, 12L, 13L, 14L);
            Task.copyWithRange(Comparator.naturalOrder(), list1, list3, 5L, 2L);
            assertEquals(Arrays.asList(2L, 3L, 4L, 13L, 14L), list3);

        }


    }
