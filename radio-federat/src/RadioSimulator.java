import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.HlaBaseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class RadioSimulator {
    private final HlaWorld _hlaWorld;

    public RadioSimulator() {
        _hlaWorld = HlaWorld.Factory.create(new HlaSettings() {});
        _hlaWorld.getHlaInteractionManager().addHlaInteractionListener(_rrListener);
    }

    private final HlaInteractionListener _rrListener = new HlaInteractionListener() {
        @Override
        public void request(boolean local, HlaInteractionManager.HlaRequestParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {

        }

        @Override
        public void response(boolean local, HlaInteractionManager.HlaResponseParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            byte[][] path = parameters.getPath();
            long transactionID = parameters.getTransactionID();

            System.out.println("Path to be traversed for transaction " + transactionID);
            for (byte[] b : path) {
                System.out.print(Arrays.toString(b) + " -> ");
            }
            System.out.println();
        }
    };

    public void simulate() throws HlaBaseException, InterruptedException {
        _hlaWorld.connect();

        HlaInteractionManager _manager = _hlaWorld.getHlaInteractionManager();

        try {
            File myObj = new File("DATAFILE2.txt");
            Scanner scanner = new Scanner(myObj);
            scanner.useLocale(Locale.US);

            while (scanner.hasNext()) {
                int comType = scanner.nextInt();
                byte[] fromNodeByte = UuidAdapter.getBytesFromUUID(scanner.next());
                byte[] toNodeByte = UuidAdapter.getBytesFromUUID(scanner.next());

                long transactionID = scanner.nextInt();

                _manager.sendRequest(fromNodeByte, toNodeByte, comType, transactionID);

                System.out.println("sent request [" + comType + ": "
                        + UuidAdapter.getUUIDFromBytes(fromNodeByte).toString()
                        + "->"
                        + UuidAdapter.getUUIDFromBytes(toNodeByte).toString()
                        + "], transaction id " + transactionID );
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
