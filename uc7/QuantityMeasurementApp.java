public class QuantityMeasurementApp {

    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.393701 / 12.0);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double toFeet(double value) {
            return value * factor;
        }

        public double fromFeet(double value) {
            return value / factor;
        }
    }

    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value))
                throw new IllegalArgumentException();
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        // UC7 Addition with explicit target unit
        public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
            if (other == null || targetUnit == null)
                throw new IllegalArgumentException();

            double sumFeet = this.toFeet() + other.toFeet();
            double result = targetUnit.fromFeet(sumFeet);

            return new QuantityLength(result, targetUnit);
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }
}
