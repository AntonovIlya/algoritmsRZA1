import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data_Processing {
    private CurrentData cd;
    private CurrentRMS currentRMS = new CurrentRMS();
    private Logic log = new Logic(currentRMS);
    private double[] PhA = new double[20];
    private double[] PhB = new double[20];
    private double[] PhC = new double[20];
    private short count = 0;

    public Data_Processing(CurrentData cd) {
        this.cd = cd;
    }

    public void process() {
        double sumPhA = 0;
        double sumPhB = 0;
        double sumPhC = 0;
        PhA[count] = cd.getPhaseA();
        PhB[count] = cd.getPhaseB();
        PhC[count] = cd.getPhaseC();
        for (short i = 0; i < 20; i++) {
            sumPhA += Math.pow(PhA[i], 2);
            sumPhB += Math.pow(PhB[i], 2);
            sumPhC += Math.pow(PhC[i], 2);
        }
        currentRMS.setPhaseA(Math.sqrt(0.05 * sumPhA));
        currentRMS.setPhaseB(Math.sqrt(0.05 * sumPhB));
        currentRMS.setPhaseC(Math.sqrt(0.05 * sumPhC));
        Charts.addAnalogData(0, 1, Math.sqrt(0.05 * sumPhA));
        Charts.addAnalogData(1, 1, Math.sqrt(0.05 * sumPhB));
        Charts.addAnalogData(2, 1, Math.sqrt(0.05 * sumPhC));
        log.logic();
        if (++count >= 20) count = 0;
    }
}
