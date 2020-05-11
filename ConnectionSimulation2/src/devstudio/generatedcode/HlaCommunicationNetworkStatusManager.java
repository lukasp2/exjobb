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
 * Manager used to manage HlaCommunicationNetworkStatus.
 * <p>
 * This class is <code>ThreadSafe</code> as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public interface HlaCommunicationNetworkStatusManager {

   /**
    * Gets a list of all HlaCommunicationNetworkStatus within interest, both local and remote.
    * The list is a copy that is allowed to be altered.
    *
    * @return a list of HlaCommunicationNetworkStatus
    */
    List<HlaCommunicationNetworkStatus> getHlaCommunicationNetworkStatus();

   /**
    * Gets a list of all HlaCommunicationNetworkStatus, both local and remote.
    * HlaCommunicationNetworkStatus not within interest are also included.
    * The list is a copy that is allowed to be altered.
    *
    * @return a list of all HlaCommunicationNetworkStatus
    */
    List<HlaCommunicationNetworkStatus> getAllHlaCommunicationNetworkStatus();

   /**
    * Gets a list of local HlaCommunicationNetworkStatus within interest.
    * The list is a copy that is allowed to be altered.
    *
    * @return a list of local HlaCommunicationNetworkStatus
    */
    List<HlaCommunicationNetworkStatus> getLocalHlaCommunicationNetworkStatus();

   /**
    * Gets a list of remote HlaCommunicationNetworkStatus within interest.
    * The list is a copy that is allowed to be altered.
    *
    * @return a list of remote HlaCommunicationNetworkStatus
    */
    List<HlaCommunicationNetworkStatus> getRemoteHlaCommunicationNetworkStatus();

   /**
    * Find a HlaCommunicationNetworkStatus with the given <code>HLA instance name</code>.
    * If none is found, <code>null</code> is returned.
    *
    * @param hlaInstanceName the <code>HLA instance name</code> of the HlaCommunicationNetworkStatus to find
    *
    * @return the specified HlaCommunicationNetworkStatus, or <code>null</code> if not found.
    */
   HlaCommunicationNetworkStatus getCommunicationNetworkStatusByHlaInstanceName(String hlaInstanceName);

   /**
    * Find a HlaCommunicationNetworkStatus with the given <code>HLA instance name</code>.
    * If none is found, <code>null</code> is returned.
    *
    * @param encodedHlaInstanceHandle the encoded <code>HLA instance handle</code> of the HlaCommunicationNetworkStatus to find
    *
    * @return the specified HlaCommunicationNetworkStatus, or <code>null</code> if not found.
    */
   HlaCommunicationNetworkStatus getCommunicationNetworkStatusByHlaInstanceHandle(byte[] encodedHlaInstanceHandle);

   /**
    * Creates a new HlaCommunicationNetworkStatus, and sets all <i>Create</i> attributes.
    *
    *
    * @return Returns a new local HlaCommunicationNetworkStatus.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaCommunicationNetworkStatus createLocalHlaCommunicationNetworkStatus(
    ) throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
             HlaSaveInProgressException, HlaRestoreInProgressException;


   /**
    * Creates a new HlaCommunicationNetworkStatus with a specified <code>HLA instance name</code>, and sets all
    * <i>Create</i> attributes.
    *
    * @param hlaInstanceName the <code>HLA instance name</code> to register for this instance
    *
    * @return Returns a new local HlaCommunicationNetworkStatus.
    *
    * @throws HlaIllegalInstanceNameException if the name is illegal
    * @throws HlaInstanceNameInUseException if the name is already in use
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaCommunicationNetworkStatus createLocalHlaCommunicationNetworkStatus(
       String hlaInstanceName
    ) throws HlaIllegalInstanceNameException, HlaInstanceNameInUseException,
             HlaNotConnectedException, HlaInternalException, HlaRtiException,
             HlaSaveInProgressException, HlaRestoreInProgressException;


   /**
    * Deletes a local HlaCommunicationNetworkStatus and removes it from the federation.
    *
    * @param communicationNetworkStatus The HlaCommunicationNetworkStatus to delete
    *
    * @return the HlaCommunicationNetworkStatus deleted, null if it did not exist.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaCommunicationNetworkStatus deleteLocalHlaCommunicationNetworkStatus(HlaCommunicationNetworkStatus communicationNetworkStatus)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Deletes a local HlaCommunicationNetworkStatus and removes it from the federation with a specified timestamp
    *
    * @param communicationNetworkStatus The HlaCommunicationNetworkStatus to delete
    * @param timestamp timestamp when the instance was removed.
    *
    * @return the HlaCommunicationNetworkStatus deleted, null if it did not exist.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaCommunicationNetworkStatus deleteLocalHlaCommunicationNetworkStatus(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timestamp)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Deletes a local HlaCommunicationNetworkStatus and removes it from the federation at a specified logical time.
    *
    * @param communicationNetworkStatus The HlaCommunicationNetworkStatus to delete
    * @param logicalTime The logical time when the instance was removed.
    *
    * @return the HlaCommunicationNetworkStatus deleted, null if it did not exist.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaCommunicationNetworkStatus deleteLocalHlaCommunicationNetworkStatus(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Deletes a local HlaCommunicationNetworkStatus and removes it from the federation with a specified timestamp at a specified logical time.
    *
    * @param communicationNetworkStatus The HlaCommunicationNetworkStatus to delete
    * @param timestamp timestamp when the instance was removed.
    * @param logicalTime The logical time when the instance was removed.
    *
    * @return the HlaCommunicationNetworkStatus deleted, null if it did not exist.
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
    HlaCommunicationNetworkStatus deleteLocalHlaCommunicationNetworkStatus(HlaCommunicationNetworkStatus communicationNetworkStatus, HlaTimeStamp timestamp, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException;

    /**
     * Add an HlaCommunicationNetworkStatus manager listener.
     *
     * @param managerListener listener to add
     */
    void addHlaCommunicationNetworkStatusManagerListener(HlaCommunicationNetworkStatusManagerListener managerListener);

    /**
     * Remove an HlaCommunicationNetworkStatus manager listener.
     *
     * @param managerListener listener to remove
     */
    void removeHlaCommunicationNetworkStatusManagerListener(HlaCommunicationNetworkStatusManagerListener managerListener);

    /**
     * Add a listener that will automatically be added to all instances of HlaCommunicationNetworkStatus (Both local and remote).
     * The listener is notified when any attribute of an instance of HlaCommunicationNetworkStatus is updated.
     * The listener is also called when an interaction is sent to an instance of HlaCommunicationNetworkStatus.
     * All listeners will automatically be removed when an instance is removed.
     * This method is idempotent.
     *
     * @param listener The listener to add.
     */
    void addHlaCommunicationNetworkStatusDefaultInstanceListener(HlaCommunicationNetworkStatusListener listener);

    /**
     * Remove a listener from the set of listeners that are automatically added to new instances of HlaCommunicationNetworkStatus.
     * Note: The listener will not be removed from already existing instances of HlaCommunicationNetworkStatus.
     * This method is idempotent.
     *
     * @param listener The listener to remove.
     */
    void removeHlaCommunicationNetworkStatusDefaultInstanceListener(HlaCommunicationNetworkStatusListener listener);

    /**
     * Add a valueListener that will automatically be added to all instances of HlaCommunicationNetworkStatus (Both local and remote).
     * The  Valuelistener is notified when any attribute of an instance of HlaCommunicationNetworkStatus is updated.
     * Note that the attribute values that are notified are not guaranteed to
     * be the latest available values for that attribute.
     * All listeners will automatically be removed when an instance is removed.
     * This method is idempotent.
     *
     * @param valueListener The valueListener to add.
     */
    void addHlaCommunicationNetworkStatusDefaultInstanceValueListener(HlaCommunicationNetworkStatusValueListener valueListener);

    /**
     * Remove a valueListener from the set of listeners that are automatically added to new instances of HlaCommunicationNetworkStatus.
     * Note: The valueListener will not be removed from already existing instances of HlaCommunicationNetworkStatus.
     * This method is idempotent.
     *
     * @param valueListener The valueListener to remove.
     */
    void removeHlaCommunicationNetworkStatusDefaultInstanceValueListener(HlaCommunicationNetworkStatusValueListener valueListener);

    /**
     * Enables or disables the HlaCommunicationNetworkStatus manager.
     * The manager is enabled by default. The state can only be changed when not connected.
     * When the HlaCommunicationNetworkStatus manager is disabled it will act as disconnected,
     * ie throws HlaNotConnectedException.
     *
     * @param enabled <code>true</code> to enable the HlaCommunicationNetworkStatus manager, otherwise <code>false</code>
     */
    void setEnabled(boolean enabled);

    /**
     * Enables the HlaCommunicationNetworkStatus manager if it is avalable in the FOM at runtime.
     * The manager is enabled by default. The state can only be changed when not connected.
     * When the HlaCommunicationNetworkStatus manager is disabled it will act as disconnected,
     * ie throws HlaNotConnectedException.
     */
    void setEnabledIfAvailableInFom();

    /**
     * Check if the HlaCommunicationNetworkStatus manager is actually enabled when connected.
     * An HlaCommunicationNetworkStatus manager may be disabled with the <code>setEnabled(false)</code> function, or it may be configured
     * as <i>if available in the FOM</i> by the <code>setEnabledIfAvailableInFom()</code> function and
     * then not available in the FOM at runtime.
     * <p>
     * This method should only be used when connected, it will always return <code>false</code>
     * when not connected.
     *
     * @return <code>true</code> if connected and the HlaCommunicationNetworkStatus manager is enabled.
     */
    boolean isEnabled();
}

