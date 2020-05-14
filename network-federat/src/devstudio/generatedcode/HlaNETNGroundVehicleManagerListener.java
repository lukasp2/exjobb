package devstudio.generatedcode;

/*
 * DO NOT EDIT!
 * 
 * Automatically generated source code by Pitch Developer Studio
 * Licensed to LP Internal Development 2020
 *
 * Copyright (C) 2006-2020 Pitch Technologies AB. All rights reserved.
 * Use is subject to license terms.
 */



/**
 * Listener for changes of HlaNETNGroundVehicle instances.
 */
public interface HlaNETNGroundVehicleManagerListener {

   /**
    * This method is called when a new HlaNETNGroundVehicle instance is discovered.
    * A discovered instance is initially within interest.
    *
    * @param nETNGroundVehicle the object which is discovered
    * @param timeStamp the time when the update was initiated
    */
    void hlaNETNGroundVehicleDiscovered(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp);

   /**
    * This method is called when a HlaNETNGroundVehicle instance is initialized.
    * An instance is initialized when it has been discovered and all attribute marked with
    * <i>initialized</i> has a value.
    *
    * @param nETNGroundVehicle the object which is initialized
    * @param timeStamp the time when the update was initiated
    * @param logicalTime the logical time when the update was initiated
    */
    void hlaNETNGroundVehicleInitialized(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * This method is called when a HlaNETNGroundVehicle instance comes within interest.
    * A discovered instance is initially within interest, so this will not
    * be called at the time of discovery.
    *
    * @param nETNGroundVehicle the object which has come into interest
    * @param timeStamp the time when the update was initiated
    */
    void hlaNETNGroundVehicleInInterest(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp);

   /**
    * This method is called when a HlaNETNGroundVehicle instance goes out of interest.
    *
    * @param nETNGroundVehicle the object which has gone out of interest
    * @param timeStamp the time when the update was initiated
    */
    void hlaNETNGroundVehicleOutOfInterest(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp);

   /**
    * This method is called when a HlaNETNGroundVehicle instance is deleted.
    *
    * @param nETNGroundVehicle the object which is deleted
    * @param timeStamp the time when the update was initiated
    * @param logicalTime the logical time when the update was initiated
    */
    void hlaNETNGroundVehicleDeleted(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * An abstract adapter class that implements the HlaNETNGroundVehicleManagerListener interface with empty methods.
    * It might be used as a base class for a listener.
    */
    public abstract static class Adapter implements HlaNETNGroundVehicleManagerListener {
        public void hlaNETNGroundVehicleDiscovered(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp) {}
        public void hlaNETNGroundVehicleInitialized(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
        public void hlaNETNGroundVehicleInInterest(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp) {}
        public void hlaNETNGroundVehicleOutOfInterest(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp) {}
        public void hlaNETNGroundVehicleDeleted(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
    }
}
