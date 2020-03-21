import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garmonic garmonic = new Garmonic(12,900,256);
        List<Double> xData = initializationXData(garmonic.getCountOfDiscreteCalls());

        XYChart chart = new XYChartBuilder()
                .width(1200)
                .height(800)
                .title("x(t)")
                .xAxisTitle("t")
                .yAxisTitle("x")
                .build();


        garmonic.calculateSygnalsForResultingGarmonic();

        chart.addSeries("Fourier Function", xData, garmonic.calculateDFT());

        new SwingWrapper<>(chart).displayChart();
    }

    private static List<Double> initializationXData(int countOfDiscreteCalls) {
        if(countOfDiscreteCalls<0)
            return null;
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < countOfDiscreteCalls; i++) {
            res.add((double)i);
        }
        return res;
    }


}
