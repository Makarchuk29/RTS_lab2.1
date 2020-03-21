package tableWpkn;


public class Table {
    private Wpkn[][] tableWpkn;
    private int N;

    public Table(int N) {
        this.N = N;
        this.tableWpkn = new Wpkn[N][N];
    }

    public void createTable(){
        long startTime = System.currentTimeMillis();
        for (int p = 0; p < N; p++) {
            for (int k = 0; k < N; k++) {
                tableWpkn[p][k] = new Wpkn(WReal(p,k,N), WImage(p,k,N));
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
    }


    public Wpkn get(int p, int k){
        return tableWpkn[p][k];
    }

    private double WReal(int p, int k, int N){
        return Math.cos(2*Math.PI*p*k/N);
    }

    private double WImage(int p, int k, int N){
        return Math.sin(2*Math.PI*p*k/N);
    }
}
