import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputData {
    private CurrentData data = new CurrentData();
    private Data_Processing data_processing = new Data_Processing(data);
    short i = 0;
    short count = 0;

    public void start() {
        try {
            File csv;
            String path = "C:\\Users\\IlYHA_PC\\Desktop\\II_half-year\\Algorithms_RP\\LR1\\ggg\\Опыты\\Начало линии\\";
            String csvName = "PhAB80.csv";
            csv = new File(path + csvName);
            FileReader fr = new FileReader(csv);
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNextLine()) {
                if (i >= 1) {
                    count ++;
                    if (count == 4) {
                        String[] lineData = scanner.nextLine().split(",");
                        data.setPhaseA(Double.parseDouble(lineData[1]));
                        data.setPhaseB(Double.parseDouble(lineData[2]));
                        data.setPhaseC(Double.parseDouble(lineData[3]));
                        data_processing.process();
                        Charts.addAnalogData(0, 0, data.getPhaseA());
                        Charts.addAnalogData(1,0,data.getPhaseB());
                        Charts.addAnalogData(2,0,data.getPhaseC());
                        count = 0;
                    } else scanner.nextLine();
                } else {
                    scanner.nextLine();
                    i++;
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
