public class TwoSeven {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sb.append("Two");
            }
            if (i % 7 == 0) {
                sb.append("Seven");
            }
            if (sb.length() == 0) {
                System.out.println(i);
            } else {
                System.out.println(sb.toString());
                sb.setLength(0);
            }
        }

    }
}
