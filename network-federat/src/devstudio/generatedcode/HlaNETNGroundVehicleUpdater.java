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

import devstudio.generatedcode.datatypes.SpatialVariantStruct;
import devstudio.generatedcode.exceptions.*;


/**
 * Updater used to update attribute values.
 * <p>
 * This class is <code>ThreadSafe</code> as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public interface HlaNETNGroundVehicleUpdater {

   /**
    * Set the uniqueID for this update.
    * <br>Description from the FOM: <i>The unique identifier of the object. 
Required value. 
If not assigned by the ORBAT specification or similar, shall a value be assigned, either randomized or generated from the Marking or EntityIdentifier attribute value.</i>
    * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
    *
    * @param uniqueID the new uniqueID
    *
    * @return this updater
    */
    HlaNETNGroundVehicleUpdater setUniqueID(byte[/* 16 */] uniqueID);

   /**
    * Set the spatial for this update.
    * <br>Description from the FOM: <i>Spatial state stored in one variant record attribute.</i>
    * <br>Description of the data type from the FOM: <i>Variant Record for a single spatial attribute.</i>
    *
    * @param spatial the new spatial
    *
    * @return this updater
    */
    HlaNETNGroundVehicleUpdater setSpatial(SpatialVariantStruct spatial);

   /**
    * Send all the attributes.
    * Note that the <code>Updater</code> can not be reused after <code>sendUpdate</code> has been called.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaAttributeNotOwnedException if a changed attribute is not owned
    * @throws HlaUpdaterReusedException if the Updater is reused
    * @throws HlaObjectInstanceIsRemovedException if the object instance has been removed
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    void sendUpdate()
         throws HlaNotConnectedException, HlaAttributeNotOwnedException, HlaUpdaterReusedException,
                HlaInternalException, HlaRtiException, HlaObjectInstanceIsRemovedException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Send all the attributes with a specified timestamp.
    * Note that the <code>Updater</code> can not be reused after <code>sendUpdate</code> has been called.
    *
    * @param timestamp timestamp to send for this update
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaAttributeNotOwnedException if a changed attribute is not owned
    * @throws HlaUpdaterReusedException if the Updater is reused
    * @throws HlaObjectInstanceIsRemovedException if the object instance has been removed
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    void sendUpdate(HlaTimeStamp timestamp)
         throws HlaNotConnectedException, HlaAttributeNotOwnedException, HlaUpdaterReusedException,
                HlaInternalException, HlaRtiException, HlaObjectInstanceIsRemovedException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Send all the attributes with a specified logical time.
    * Note that the <code>Updater</code> can not be reused after <code>sendUpdate</code> has been called.
    *
    * @param logicalTime logical time to send for this update
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaAttributeNotOwnedException if a changed attribute is not owned
    * @throws HlaUpdaterReusedException if the Updater is reused
    * @throws HlaObjectInstanceIsRemovedException if the object instance has been removed
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    void sendUpdate(HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaAttributeNotOwnedException,
                HlaInvalidLogicalTimeException, HlaUpdaterReusedException,
                HlaInternalException, HlaRtiException, HlaObjectInstanceIsRemovedException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Send all the attributes with a specified timestamp and logical time.
    * Note that the <code>Updater</code> can not be reused after <code>sendUpdate</code> has been called.
    *
    * @param timestamp timestamp to send for this update
    * @param logicalTime logical time to send for this update
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaAttributeNotOwnedException if a changed attribute is not owned
    * @throws HlaUpdaterReusedException if the Updater is reused
    * @throws HlaObjectInstanceIsRemovedException if the object instance has been removed
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    void sendUpdate(HlaTimeStamp timestamp, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaAttributeNotOwnedException,
                HlaInvalidLogicalTimeException, HlaUpdaterReusedException,
                HlaInternalException, HlaRtiException, HlaObjectInstanceIsRemovedException,
                HlaSaveInProgressException, HlaRestoreInProgressException;
}
