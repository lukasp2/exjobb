import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.HlaBaseException;
import devstudio.generatedcode.datatypes.*;

import java.util.concurrent.TimeUnit;

public class PathFinder {
    private final HlaWorld _hlaWorld;
    private final HlaPacer _hlaPacer;

    PathFinder() {
        _hlaWorld = HlaWorld.Factory.create();
        _hlaPacer = HlaPacer.create(1, TimeUnit.SECONDS);

        // _hlaWorld.getHlaInteractionManager().addHlaInteractionListener(new MyListener());
    }

    /*
    private final HlaAircraftValueListener _printListener = new HlaAircraftValueListener.Adapter() {
        @Override
        public void positionUpdated(HlaAircraft aircraft, PositionRec position, boolean validOldPosition, PositionRec oldPosition, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            System.out.println(aircraft.getHlaInstanceName() + " at " + position.toString() +
                    (USE_TIME_MANAGEMENT ? " on " + logicalTime.toString() : ""));
        }
    };
    */

    public void simulate() throws HlaBaseException, InterruptedException {

        HlaLogicalTime currentTime = _hlaWorld.connect();

        System.out.println("Joined federation" + (USE_TIME_MANAGEMENT ? " at " + currentTime.toString() : ""));

        /*
        HlaPath aircraft = _hlaWorld.getHlaAircraftManager().createLocalHlaAircraft("AircraftId");

        HlaAircraftUpdater initialUpdater = aircraft.getHlaAircraftUpdater();
        initialUpdater.setAirLine(AirLineEnum.SAS);
        initialUpdater.setPosition(PositionRec.create(1, 20, 300));
        initialUpdater.sendUpdate();

        for (int i = 1; i < 20; i++) {
            HlaAircraftUpdater updater = aircraft.getHlaAircraftUpdater();
            updater.setPosition(PositionRec.create(i, i * 20, i * 300));
            updater.sendUpdate();

            _hlaWorld.advanceToNextFrame();
            _hlaPacer.pace();
        }
        _hlaWorld.getHlaAircraftManager().deleteLocalHlaAircraft(aircraft);
        */

        _hlaWorld.disconnect();
    }

    public static void main(String[] args) throws HlaBaseException, InterruptedException {
        new PathFinder().simulate();
    }
}