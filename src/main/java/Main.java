import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static InputData inputData = new InputData();

    public static void main(String[] args) {
        System.out.println(Time.getCurrentHour());
        Charts.createAnalogChart("PhA,rms", 0);
        Charts.addSeries("PhaseA, kA", 0, 0);
        Charts.addSeries("PhaseArms, kA", 0, 1);
        Charts.addSeries("Setpoint, kA", 0, 2);

        Charts.createAnalogChart("PhB,rms", 1);
        Charts.addSeries("PhaseB, kA", 1, 0);
        Charts.addSeries("PhaseArms, kA", 1, 1);
        Charts.addSeries("Setpoint, kA", 1, 2);

        Charts.createAnalogChart("PhC,rms", 2);
        Charts.addSeries("PhaseC, kA", 2, 0);
        Charts.addSeries("PhaseArms, kA", 2, 1);
        Charts.addSeries("Setpoint, kA", 2, 2);

        Charts.createDiscreteChart("Signal", 3);
        inputData.start();
        System.out.println("Время работы программы: " + Time.getCurrentHour() + " мс");
    }
}
