public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value))
            throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.convertToBase(value);
    }

    public QuantityLength convertTo(LengthUnit target) {
        double base = toBase();
        double converted = target.convertFromBase(base);
        return new QuantityLength(converted, target);
    }

    public QuantityLength add(QuantityLength other, LengthUnit target) {
        if (other == null || target == null)
            throw new IllegalArgumentException();

        double sum = this.toBase() + other.toBase();
        double result = target.convertFromBase(sum);

        return new QuantityLength(result, target);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;
        return Double.compare(this.toBase(), other.toBase()) == 0;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
