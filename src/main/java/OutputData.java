public class OutputData {
    private boolean signal = false;

    public void process(boolean signal) {
        this.signal = signal;
        Charts.addDiscreteData(0, signal);
    }
}
