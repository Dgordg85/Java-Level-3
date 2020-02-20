import Lesson_06.Homework06;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestHomework06 {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}},
                {new int[]{}, new int[]{1, 2, 5, 8, 2, 3, 4, 1, 4}},
                {new int[]{2, 5, 6, 2, 3, 6, 1, 7}, new int[]{4, 2, 5, 6, 2, 3, 6, 1, 7}},
        });
    }

    private Homework06 hw;
    private int[] expected;
    private int[] array;

    public TestHomework06(int[] expected, int[] array) {
        this.expected = expected;
        this.array = array;
    }

    @Before
    public void init(){
        hw = new Homework06();
    }

    @Test
    public void massTest(){
        Assert.assertArrayEquals(expected, hw.getMassiveByLast4(array));
    }

    @Test(expected = RuntimeException.class)
    public void testGetMassiveByLast4_1(){
        Assert.assertArrayEquals(new int[]{},hw.getMassiveByLast4(new int[]{1, 2, 6, 6, 2, 3, 8, 1, 7}));
    }

    @Test(expected = RuntimeException.class)
    public void testGetMassiveByLast4_2(){
        Assert.assertArrayEquals(new int[]{},hw.getMassiveByLast4(new int[]{}));
    }

    @Test
    public void testIsOneOrFourInArray_1(){
        Assert.assertTrue(hw.isOneOrFourInArray(new int[]{1, 4, 5, 7}));
    }

    @Test
    public void testIsOneOrFourInArray_2(){
        Assert.assertTrue(hw.isOneOrFourInArray(new int[]{1}));
    }

    @Test
    public void testIsOneOrFourInArray_3(){
        Assert.assertTrue(hw.isOneOrFourInArray(new int[]{4}));
    }

    @Test
    public void testIsOneOrFourInArray_4(){
        Assert.assertFalse(hw.isOneOrFourInArray(new int[]{}));
    }

    @Test
    public void testIsOneOrFourInArray_5(){
        Assert.assertFalse(hw.isOneOrFourInArray(new int[]{7, 8}));
    }

    @Test
    public void testIsOneOrFourInArray_6(){
        Assert.assertTrue(hw.isOneOrFourInArray(new int[]{3, 8, 5, 4}));
    }

    @Test
    public void testIsOneOrFourInArray_7(){
        Assert.assertTrue(hw.isOneOrFourInArray(new int[]{3, 8, 5, 1}));
    }

    @Test
    public void testIsOneOrFourInArray_8(){
        Assert.assertFalse(hw.isOneOrFourInArray(new int[]{8, 10, 5, 7}));
    }
    @Test
    public void testIsOneOrFourInArray_9(){
        Assert.assertFalse(hw.isOneOrFourInArray(null));
    }
}
