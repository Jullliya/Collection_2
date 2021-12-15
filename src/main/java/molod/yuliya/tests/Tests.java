package molod.yuliya.tests;

import molod.yuliya.project.Person;
import molod.yuliya.project.Subdivision;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests of the Person class
 */
public class Tests {

    Person person = new Person("1", "Name", "Sex", "15.12.2021", "1000", new Subdivision(1, "A"));

    @Test
    public void Test_Id() {
        assertNotNull(person.getId());
        assertEquals("1", person.getId());
    }

    @Test
    public void Test_Name() {
        assertNotNull(person.getName());
        assertEquals("Name", person.getName());
    }

    @Test
    public void Test_Sex() {
        assertNotNull(person.getName());
        assertEquals("Sex", person.getSex());
    }

    @Test
    public void Test_Date() {
        assertNotNull(person.getDate());
        assertEquals("15.12.2021", person.getDate());
    }

    @Test
    public void Test_Salary() {
        assertNotNull(person.getSalary());
        assertEquals("1000", person.getSalary());
    }

    @Test
    public void Test_Subdivision_Id() {
        assertNotNull(person.getDivision().divisionGetId());
        assertEquals(1, person.getDivision().divisionGetId());
    }

    @Test
    public void Test_Subdivision_Name() {
        assertNotNull(person.getDivision().divisionGetName());
        assertEquals("A", person.getDivision().divisionGetName());
    }

}
