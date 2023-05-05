import com.example.memotest.test.domain.Student;
import org.junit.jupiter.api.Test;

public class StudentTest {


    @Test
    public void equalsTest() {

        Student s1 = new Student("dsg", 30);
        Student s2 = new Student("dsg", 30);

        System.out.println("result: " + s1.equals(s2));
    }

}
