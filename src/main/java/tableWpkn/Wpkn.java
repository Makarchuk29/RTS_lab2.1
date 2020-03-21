package tableWpkn;

public class Wpkn {
    private double wReal;
    private double wImage;

    public Wpkn(double wReal, double wImage) {
        this.wReal = wReal;
        this.wImage = wImage;
    }

    public double getReal() {
        return wReal;
    }

    public double getImage() {
        return wImage;
    }

    @Override
    public String toString() {
        return wReal + " - j*(" + wImage + ")";
    }
}
