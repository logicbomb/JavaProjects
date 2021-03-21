import com.rukon.junit.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    @Test
    void sum_with3numbers() {
        MyMath myMath = new MyMath();
        int result = myMath.sum(new int[]{1, 2, 3});
        assertEquals(6, result);
        System.out.println(result);

    }
}