import devstudio.generatedcode.HlaInteractionManager;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaSettings;
import devstudio.generatedcode.HlaWorld;
import devstudio.generatedcode.exceptions.HlaBaseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class RadioSimulator {
    private final HlaWorld _hlaWorld;

    public RadioSimulator() {
        _hlaWorld = HlaWorld.Factory.create(new HlaSettings() {
        });
    }

    public void simulate() throws HlaBaseException, InterruptedException {
        HlaLogicalTime currentTime = _hlaWorld.connect();

        //HlaInteractionManager.HlaRequestInteraction a = _hlaWorld.getHlaInteractionManager().getHlaRequestInteraction();
        HlaInteractionManager a = _hlaWorld.getHlaInteractionManager();

        try {
            File myObj = new File("DATAFILE.txt");
            Scanner scanner = new Scanner(myObj);
            scanner.useLocale(Locale.US);

            while (scanner.hasNext()) {
                int comType = scanner.nextInt();
                String fromNode = scanner.next();
                String toNode = scanner.next();
                int transactionID = scanner.nextInt();

                a.sendRequest(fromNode.getBytes(), toNode.getBytes(), comType, transactionID);
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // prevent disconnecting from federation prematurely
        Thread.sleep(1000);

        _hlaWorld.disconnect();
    }

    public static void main(String[] args) throws HlaBaseException, InterruptedException {
        new RadioSimulator().simulate();
    }
}
