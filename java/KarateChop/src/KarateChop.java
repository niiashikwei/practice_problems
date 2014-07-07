public class KarateChop {

    public static int chop(int target, int[] array) {

        for (int index = 0; index < array.length; index++) {
           if (array[index] == target) {
                return index;
            }
        }

        return -1;
    }
}
