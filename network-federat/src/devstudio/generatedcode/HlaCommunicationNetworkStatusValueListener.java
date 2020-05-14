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

import devstudio.generatedcode.datatypes.NetworkConnectivityStruct;

/**
 * Listener for updates of attributes, with the new updated values.  
 */
public interface HlaCommunicationNetworkStatusValueListener {

   /**
    * This method is called when the attribute <code>communicationNetworkId</code> is updated.
    * <br>Description from the FOM: <i>Identifies the communicationn network.</i>
    * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
    *
    * @param communicationNetworkStatus   The object which is updated.
    * @param communicationNetworkId    The new value of the attribute in this update
    * @param validOldCommunicationNetworkId True if oldCommunicationNetworkId contains a valid value
    * @param oldCommunicationNetworkId   The old value of the attribute
    * @param timeStamp  The time when the update was initiated.
    * @param logicalTime The logical time when the update was initiated.
    */
    void communicationNetworkIdUpdated(HlaCommunicationNetworkStatus communicationNetworkStatus, byte[/* 16 */] communicationNetworkId, boolean validOldCommunicationNetworkId, byte[/* 16 */] oldCommunicationNetworkId, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * This method is called when the attribute <code>communicationConnectivity</code> is updated.
    * <br>Description from the FOM: <i>N/A</i>
    * <br>Description of the data type from the FOM: <i>N/A</i>
    *
    * @param communicationNetworkStatus   The object which is updated.
    * @param communicationConnectivity    The new value of the attribute in this update
    * @param validOldCommunicationConnectivity True if oldCommunicationConnectivity contains a valid value
    * @param oldCommunicationConnectivity   The old value of the attribute
    * @param timeStamp  The time when the update was initiated.
    * @param logicalTime The logical time when the update was initiated.
    */
    void communicationConnectivityUpdated(HlaCommunicationNetworkStatus communicationNetworkStatus, NetworkConnectivityStruct[] communicationConnectivity, boolean validOldCommunicationConnectivity, NetworkConnectivityStruct[] oldCommunicationConnectivity, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * This method is called when the producing federate of an attribute is changed.
    * Only available when using HLA Evolved.
    *
    * @param communicationNetworkStatus The object which is updated.
    * @param attribute The attribute that now has a new producing federate
    * @param oldProducingFederate The federate handle of the old producing federate
    * @param newProducingFederate The federate handle of the new producing federate
    * @param timeStamp  The time when the update was initiated.
    * @param logicalTime The logical time when the update was initiated.
    */
    void producingFederateUpdated(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaCommunicationNetworkStatusAttributes.Attribute attribute, HlaFederateId oldProducingFederate, HlaFederateId newProducingFederate, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * An abstract adapter class that implements the HlaCommunicationNetworkStatusValueListener interface with empty methods.
    * It might be used as a base class for a listener.
    */
    public abstract static class Adapter implements HlaCommunicationNetworkStatusValueListener {
        public void communicationNetworkIdUpdated(HlaCommunicationNetworkStatus communicationNetworkStatus, byte[/* 16 */] communicationNetworkId, boolean validOldCommunicationNetworkId, byte[/* 16 */] oldCommunicationNetworkId, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
        public void communicationConnectivityUpdated(HlaCommunicationNetworkStatus communicationNetworkStatus, NetworkConnectivityStruct[] communicationConnectivity, boolean validOldCommunicationConnectivity, NetworkConnectivityStruct[] oldCommunicationConnectivity, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
        public void producingFederateUpdated(HlaCommunicationNetworkStatus instance, HlaCommunicationNetworkStatusAttributes.Attribute attribute, HlaFederateId oldProducingFederate, HlaFederateId newProducingFederate, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
    }
}
