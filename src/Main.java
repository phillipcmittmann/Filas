public class Main {
    public static void main(String[] args) {
        Rng r = new Rng(12,23,4534535,65);
        for (int i=1; i<1000; i++) {
            System.out.println(r.next());
        }
    }
}