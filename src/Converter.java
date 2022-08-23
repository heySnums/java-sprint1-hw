public class Converter {

    double convertStepToMeter(int steps) {
        final double STEPTOMETER = 0.75;
        return steps * STEPTOMETER;
    }

    double convertStepToKCAL(int steps) {
        final int STEPTOCAL = 50;
        return steps * STEPTOCAL / 1000;
    }
}
