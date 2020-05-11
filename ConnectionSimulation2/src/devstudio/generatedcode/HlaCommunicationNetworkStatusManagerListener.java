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
 * Listener for changes of HlaCommunicationNetworkStatus instances.
 */
public interface HlaCommunicationNetworkStatusManagerListener {

   /**
    * This method is called when a new HlaCommunicationNetworkStatus instance is discovered.
    * A discovered instance is initially within interest.
    *
    * @param communicationNetworkStatus the object which is discovered
    * @param timeStamp the time when the update was initiated
    */
    void hlaCommunicationNetworkStatusDiscovered(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp);

   /**
    * This method is called when a HlaCommunicationNetworkStatus instance is initialized.
    * An instance is initialized when it has been discovered and all attribute marked with
    * <i>initialized</i> has a value.
    *
    * @param communicationNetworkStatus the object which is initialized
    * @param timeStamp the time when the update was initiated
    * @param logicalTime the logical time when the update was initiated
    */
    void hlaCommunicationNetworkStatusInitialized(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * This method is called when a HlaCommunicationNetworkStatus instance comes within interest.
    * A discovered instance is initially within interest, so this will not
    * be called at the time of discovery.
    *
    * @param communicationNetworkStatus the object which has come into interest
    * @param timeStamp the time when the update was initiated
    */
    void hlaCommunicationNetworkStatusInInterest(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp);

   /**
    * This method is called when a HlaCommunicationNetworkStatus instance goes out of interest.
    *
    * @param communicationNetworkStatus the object which has gone out of interest
    * @param timeStamp the time when the update was initiated
    */
    void hlaCommunicationNetworkStatusOutOfInterest(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp);

   /**
    * This method is called when a HlaCommunicationNetworkStatus instance is deleted.
    *
    * @param communicationNetworkStatus the object which is deleted
    * @param timeStamp the time when the update was initiated
    * @param logicalTime the logical time when the update was initiated
    */
    void hlaCommunicationNetworkStatusDeleted(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * An abstract adapter class that implements the HlaCommunicationNetworkStatusManagerListener interface with empty methods.
    * It might be used as a base class for a listener.
    */
    public abstract static class Adapter implements HlaCommunicationNetworkStatusManagerListener {
        public void hlaCommunicationNetworkStatusDiscovered(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp) {}
        public void hlaCommunicationNetworkStatusInitialized(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
        public void hlaCommunicationNetworkStatusInInterest(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp) {}
        public void hlaCommunicationNetworkStatusOutOfInterest(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp) {}
        public void hlaCommunicationNetworkStatusDeleted(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
    }
}
