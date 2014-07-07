import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KarateChopTest {

    @Test
    public void shouldReturnMinusOneForEmptyArray() {
        int[] array = new int[]{};

        assertEquals(-1, KarateChop.chop(3,array));
    }

    @Test
    public void shouldReturnMinusOneIfNonEmptyArrayDoesntHaveTarget(){
        int[] array = new int[]{3};

        assertEquals(-1, KarateChop.chop(1, array));
    }

    @Test
    public void shouldReturnZeroIfTargetIsOnlyElementInArray() {
        int[] array = new int[]{1};

        assertEquals(0, KarateChop.chop(1, array));
    }

    @Test
    public void shouldReturnOneIfTargetIsSecondElementInSortedArray(){
        int[] array = new int[]{1, 3, 5};

        assertEquals(0, KarateChop.chop(1, array));
    }

    @Test
    public void shouldReturnTheIndexOfTheTargetInSortedArray() {
        int[] array = new int[]{1, 3, 5};

        assertEquals(1, KarateChop.chop(3, array));
    }
}
