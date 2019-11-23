import java.util.Objects;

public class ComplexNum {
    private double real;
    private double img;

    /**
     * konstruktor liczby zespolonej
     *
     * @param img  część urojona liczny zespolonej
     * @param real część rzeczywista
     */
    public ComplexNum(double real, double img) {
        this.real = real;
        this.img = img;
    }

    @Override
    public String toString() {

        if (img == 0 && real == 0) {
            return "0";
        } else if (real == 0) {
            return img + "*i";
        } else if (img == 0) {
            return String.valueOf(real);
        } else if (img < 0 && real != 0) {
            return real + "-" + (-1 * img) + "*i";
        } else {
            return real + "+" + img + "*i";
        }

    }

    /**
     * @return Zwraca wartosc części urojonej
     */
    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    /**
     * Metoda nadpisuje metodę equals w ten sposób, że zamiast porównywać referencje porównuje poszczególne wartości zmiennych obiektu
     *
     * @param
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNum that = (ComplexNum) o;
        return Double.compare(that.real, real) == 0 &&
                Double.compare(that.img, img) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, img);
    }
}
