package chesse;

public class HelperUser {

    public static boolean checkPosition(int position) {
        if (position >= 0 && position <= 7) return true;
        else return false;
    }

    public static int getMax(int a, int b) {
        return Math.max(a, b);
    }

    public static int getMin(int a, int b) {
        return Math.min(a, b);
    }
}
