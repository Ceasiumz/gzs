import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Complex {
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return real + " + " + imag + "i";
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Complex add(Complex c1, Complex c2) {
        return new Complex(c1.real + c2.real, c1.imag + c2.imag);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Complex subtract(Complex c1, Complex c2) {
        return new Complex(c1.real - c2.real, c1.imag - c2.imag);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Complex multiply(Complex c1, Complex c2) {
        return new Complex(c1.real * c2.real - c1.imag * c2.imag, c1.real * c2.imag + c1.imag * c2.real);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Complex divide(Complex c1, Complex c2) {
        double denominator = c2.real * c2.real + c2.imag * c2.imag;
        return new Complex((c1.real * c2.real + c1.imag * c2.imag) / denominator, (c1.imag * c2.real - c1.real * c2.imag) / denominator);
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double phase() {
        return Math.atan2(imag, real);
    }

    @Contract(value = " -> new", pure = true)
    public @NotNull Complex conjugate() {
        return new Complex(real, -imag);
    }
}