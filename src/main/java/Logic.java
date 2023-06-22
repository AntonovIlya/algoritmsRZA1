public class Logic {
    private CurrentRMS cr;
    private boolean flag = false;
    private OutputData od = new OutputData();
    double SetpointPhA = 3.016;
    double SetpointPhB = 4.335;
    double SetpointPhC = 4.55;

    public Logic(CurrentRMS cr) {
        this.cr = cr;
    }

    public void logic() {
        Charts.addAnalogData(0, 2, SetpointPhA);
        Charts.addAnalogData(1, 2, SetpointPhB);
        Charts.addAnalogData(2, 2, SetpointPhC);
        if (cr.getPhaseA() > SetpointPhA || cr.getPhaseB() > SetpointPhB || cr.getPhaseC() > SetpointPhC) {
            flag = true;
        }
        if (flag) od.process(true);
        else od.process(false);
    }
}
