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

import devstudio.generatedcode.exceptions.*;
import java.util.List;


/**
 * Manager used to manage HlaNETNGroundVehicles.
 * <p>
 * This class is <code>ThreadSafe</code> as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public interface HlaNETNGroundVehicleManager {

   /**
    * Gets a list of all HlaNETNGroundVehicles within interest, both local and remote.
    * The list is a copy that is allowed to be altered.
    *
    * @return a list of HlaNETNGroundVehicles
    */
    List<HlaNETNGroundVehicle> getHlaNETNGroundVehicles();

   /**
    * Gets a list of all HlaNETNGroundVehicles, both local and remote.
    * HlaNETNGroundVehicles not within interest are also included.
    * The list is a copy that is allowed to be altered.
    *
    * @return a list of all HlaNETNGroundVehicles
    */
    List<HlaNETNGroundVehicle> getAllHlaNETNGroundVehicles();

   /**
    * Gets a list of local HlaNETNGroundVehicles within interest.
    * The list is a copy that is allowed to be altered.
    *
    * @return a list of local HlaNETNGroundVehicles
    */
    List<HlaNETNGroundVehicle> getLocalHlaNETNGroundVehicles();

   /**
    * Gets a list of remote HlaNETNGroundVehicles within interest.
    * The list is a copy that is allowed to be altered.
    *
    * @return a list of remote HlaNETNGroundVehicles
    */
    List<HlaNETNGroundVehicle> getRemoteHlaNETNGroundVehicles();

   /**
    * Find a HlaNETNGroundVehicle with the given <code>HLA instance name</code>.
    * If none is found, <code>null</code> is returned.
    *
    * @param hlaInstanceName the <code>HLA instance name</code> of the HlaNETNGroundVehicle to find
    *
    * @return the specified HlaNETNGroundVehicle, or <code>null</code> if not found.
    */
   HlaNETNGroundVehicle getNETNGroundVehicleByHlaInstanceName(String hlaInstanceName);

   /**
    * Find a HlaNETNGroundVehicle with the given <code>HLA instance name</code>.
    * If none is found, <code>null</code> is returned.
    *
    * @param encodedHlaInstanceHandle the encoded <code>HLA instance handle</code> of the HlaNETNGroundVehicle to find
    *
    * @return the specified HlaNETNGroundVehicle, or <code>null</code> if not found.
    */
   HlaNETNGroundVehicle getNETNGroundVehicleByHlaInstanceHandle(byte[] encodedHlaInstanceHandle);

   /**
    * Creates a new HlaNETNGroundVehicle, and sets all <i>Create</i> attributes.
    *
    *
    * @return Returns a new local HlaNETNGroundVehicle.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaNETNGroundVehicle createLocalHlaNETNGroundVehicle(
    ) throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
             HlaSaveInProgressException, HlaRestoreInProgressException;


   /**
    * Creates a new HlaNETNGroundVehicle with a specified <code>HLA instance name</code>, and sets all
    * <i>Create</i> attributes.
    *
    * @param hlaInstanceName the <code>HLA instance name</code> to register for this instance
    *
    * @return Returns a new local HlaNETNGroundVehicle.
    *
    * @throws HlaIllegalInstanceNameException if the name is illegal
    * @throws HlaInstanceNameInUseException if the name is already in use
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaNETNGroundVehicle createLocalHlaNETNGroundVehicle(
       String hlaInstanceName
    ) throws HlaIllegalInstanceNameException, HlaInstanceNameInUseException,
             HlaNotConnectedException, HlaInternalException, HlaRtiException,
             HlaSaveInProgressException, HlaRestoreInProgressException;


   /**
    * Deletes a local HlaNETNGroundVehicle and removes it from the federation.
    *
    * @param nETNGroundVehicle The HlaNETNGroundVehicle to delete
    *
    * @return the HlaNETNGroundVehicle deleted, null if it did not exist.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaNETNGroundVehicle deleteLocalHlaNETNGroundVehicle(HlaNETNGroundVehicle nETNGroundVehicle)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Deletes a local HlaNETNGroundVehicle and removes it from the federation with a specified timestamp
    *
    * @param nETNGroundVehicle The HlaNETNGroundVehicle to delete
    * @param timestamp timestamp when the instance was removed.
    *
    * @return the HlaNETNGroundVehicle deleted, null if it did not exist.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaNETNGroundVehicle deleteLocalHlaNETNGroundVehicle(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timestamp)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Deletes a local HlaNETNGroundVehicle and removes it from the federation at a specified logical time.
    *
    * @param nETNGroundVehicle The HlaNETNGroundVehicle to delete
    * @param logicalTime The logical time when the instance was removed.
    *
    * @return the HlaNETNGroundVehicle deleted, null if it did not exist.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaNETNGroundVehicle deleteLocalHlaNETNGroundVehicle(HlaNETNGroundVehicle nETNGroundVehicle, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Deletes a local HlaNETNGroundVehicle and removes it from the federation with a specified timestamp at a specified logical time.
    *
    * @param nETNGroundVehicle The HlaNETNGroundVehicle to delete
    * @param timestamp timestamp when the instance was removed.
    * @param logicalTime The logical time when the instance was removed.
    *
    * @return the HlaNETNGroundVehicle deleted, null if it did not exist.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaNETNGroundVehicle deleteLocalHlaNETNGroundVehicle(HlaNETNGroundVehicle nETNGroundVehicle, HlaTimeStamp timestamp, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

    /**
     * Add an HlaNETNGroundVehicle manager listener.
     *
     * @param managerListener listener to add
     */
    void addHlaNETNGroundVehicleManagerListener(HlaNETNGroundVehicleManagerListener managerListener);

    /**
     * Remove an HlaNETNGroundVehicle manager listener.
     *
     * @param managerListener listener to remove
     */
    void removeHlaNETNGroundVehicleManagerListener(HlaNETNGroundVehicleManagerListener managerListener);

    /**
     * Add a listener that will automatically be added to all instances of HlaNETNGroundVehicle (Both local and remote).
     * The listener is notified when any attribute of an instance of HlaNETNGroundVehicle is updated.
     * The listener is also called when an interaction is sent to an instance of HlaNETNGroundVehicle.
     * All listeners will automatically be removed when an instance is removed.
     * This method is idempotent.
     *
     * @param listener The listener to add.
     */
    void addHlaNETNGroundVehicleDefaultInstanceListener(HlaNETNGroundVehicleListener listener);

    /**
     * Remove a listener from the set of listeners that are automatically added to new instances of HlaNETNGroundVehicle.
     * Note: The listener will not be removed from already existing instances of HlaNETNGroundVehicle.
     * This method is idempotent.
     *
     * @param listener The listener to remove.
     */
    void removeHlaNETNGroundVehicleDefaultInstanceListener(HlaNETNGroundVehicleListener listener);

    /**
     * Add a valueListener that will automatically be added to all instances of HlaNETNGroundVehicle (Both local and remote).
     * The  Valuelistener is notified when any attribute of an instance of HlaNETNGroundVehicle is updated.
     * Note that the attribute values that are notified are not guaranteed to
     * be the latest available values for that attribute.
     * All listeners will automatically be removed when an instance is removed.
     * This method is idempotent.
     *
     * @param valueListener The valueListener to add.
     */
    void addHlaNETNGroundVehicleDefaultInstanceValueListener(HlaNETNGroundVehicleValueListener valueListener);

    /**
     * Remove a valueListener from the set of listeners that are automatically added to new instances of HlaNETNGroundVehicle.
     * Note: The valueListener will not be removed from already existing instances of HlaNETNGroundVehicle.
     * This method is idempotent.
     *
     * @param valueListener The valueListener to remove.
     */
    void removeHlaNETNGroundVehicleDefaultInstanceValueListener(HlaNETNGroundVehicleValueListener valueListener);

    /**
     * Enables or disables the HlaNETNGroundVehicle manager.
     * The manager is enabled by default. The state can only be changed when not connected.
     * When the HlaNETNGroundVehicle manager is disabled it will act as disconnected,
     * ie throws HlaNotConnectedException.
     *
     * @param enabled <code>true</code> to enable the HlaNETNGroundVehicle manager, otherwise <code>false</code>
     */
    void setEnabled(boolean enabled);

    /**
     * Enables the HlaNETNGroundVehicle manager if it is avalable in the FOM at runtime.
     * The manager is enabled by default. The state can only be changed when not connected.
     * When the HlaNETNGroundVehicle manager is disabled it will act as disconnected,
     * ie throws HlaNotConnectedException.
     */
    void setEnabledIfAvailableInFom();

    /**
     * Check if the HlaNETNGroundVehicle manager is actually enabled when connected.
     * An HlaNETNGroundVehicle manager may be disabled with the <code>setEnabled(false)</code> function, or it may be configured
     * as <i>if available in the FOM</i> by the <code>setEnabledIfAvailableInFom()</code> function and
     * then not available in the FOM at runtime.
     * <p>
     * This method should only be used when connected, it will always return <code>false</code>
     * when not connected.
     *
     * @return <code>true</code> if connected and the HlaNETNGroundVehicle manager is enabled.
     */
    boolean isEnabled();
}

