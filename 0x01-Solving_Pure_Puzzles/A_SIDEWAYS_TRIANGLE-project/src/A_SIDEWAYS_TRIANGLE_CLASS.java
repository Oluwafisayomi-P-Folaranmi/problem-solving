public class A_SIDEWAYS_TRIANGLE_CLASS {

    public static void buildSidewaysTriangle() {

        for (int row = 1; row <= 7; row++) {
            for (int line = 1; line <= 4 - Math.abs(4 - row); line++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
