public class Rng {
    private int a;
    private int c;
    private int m;
    private int x;

    public Rng(int a, int c, int m, int x0){
        this.a = a;
        this.c = c;
        this.m = m;
        this.x = x0;
    }

    public double next(){
        x = (a * x + c) % m;
        return (double)x / m;
    }
}
