import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Garmonic {
    private int countOfGarmonics;
    private int limitFrequency;
    private int countOfDiscreteCalls;
    private double[] sygnalsForResultingGarmonic;

    public Garmonic(int countOfGarmonics, int limitFrequency, int countOfDescreteCalls) {
        this.countOfGarmonics = countOfGarmonics;
        this.limitFrequency = limitFrequency;
        this.countOfDiscreteCalls = countOfDescreteCalls;
        this.sygnalsForResultingGarmonic = new double[countOfDescreteCalls];
    }
    public List<Double> calculateDFT(double[] sygnalsOfResultingGarmonic){

        int N = sygnalsOfResultingGarmonic.length;
        double[] dft_real = new double[N];
        double[] dft_image = new double[N];
        double[] dft_final = new double[N];

        for (int p = 0; p < N; p++) {
            for (int k = 0; k < N; k++) {
                dft_real[p] += sygnalsOfResultingGarmonic[k] * WReal(p,k,N);
                dft_image[p] += sygnalsOfResultingGarmonic[k] *WImage(p,k,N);
            }
            dft_final[p] = Math.sqrt(Math.pow(dft_real[p],2) +
                    Math.pow(dft_image[p],2));
        }
        return Arrays.stream(dft_final).boxed().collect(Collectors.toList());
    }

    public List<Double> calculateDFT(){
        return calculateDFT(getSygnalsForResultingGarmonic());
    }

    private double WReal(int p, int k, int N){
        return Math.cos(2*Math.PI*p*k/N);
    }

    private double WImage(int p, int k, int N){
        return Math.sin(2*Math.PI*p*k/N);
    }

    public List<Number> calculateSygnalsForResultingGarmonic(){
        Random r = new Random();
        double A = r.nextDouble();
        double fi = r.nextDouble()*Math.PI;
        for (int i = 0; i < countOfGarmonics; i++) {
            for (int j = 0; j < countOfDiscreteCalls; j++) {
                sygnalsForResultingGarmonic[j] += A * Math.sin(1.*limitFrequency*(i+1)/countOfGarmonics*j + fi);//
            }
        }
        return Arrays.stream(sygnalsForResultingGarmonic).boxed().collect(Collectors.toList());
    }

    public int getCountOfDiscreteCalls() {
        return countOfDiscreteCalls;
    }

    public double[] getSygnalsForResultingGarmonic() {
        return sygnalsForResultingGarmonic;
    }
}
