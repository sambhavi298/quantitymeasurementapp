public enum LengthUnit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.393701 / 12.0);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    // Convert to base unit (feet)
    public double convertToBase(double value) {
        return value * factor;
    }

    // Convert from base unit (feet)
    public double convertFromBase(double baseValue) {
        return baseValue / factor;
    }
}
