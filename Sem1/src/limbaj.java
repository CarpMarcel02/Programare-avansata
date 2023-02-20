public class limbaj {
    public static void main ( String language[]) {
        String languages[] = {"C", "C++", "C#", "Python", "" +
                "go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(languages[3]);
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        n = n * 3;
        int y = Integer.parseInt("10101",2);
        int x = Integer.parseInt("FF", 16);
        System.out.println(x);
        n = n + y;

        n = n + x;
        n = n * 6;
        while (n > 9) {

            int cn = n;
            int c = 0;
            while (cn != 0) {
                c = c + cn % 10;
                cn = cn / 10;
            }
            n = c;

        }
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

    }

}