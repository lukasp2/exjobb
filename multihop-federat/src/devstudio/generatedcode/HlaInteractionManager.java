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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Manager used to manage all interactions.
 * <p>
 * This class is <code>ThreadSafe</code> as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public interface HlaInteractionManager {

   /**
    * An enumeration of all interactions.
    *
    * <table summary="All interactions">
    * <tr><td><b>Enum constant</b></td><td><b>Java name</b></td><td><b>FOM name</b></td></tr>
    * <tr><td>REQUEST</td><td>Request</td><td><code>HLAinteractionRoot.Request</code></td></tr>
    * <tr><td>RESPONSE</td><td>Response</td><td><code>HLAinteractionRoot.Response</code></td></tr>
    * </table>
    */
   enum Interaction {
      /** Request (FOM name <code>HLAinteractionRoot.Request</code>) */
      REQUEST("HLAinteractionRoot.Request"),
      /** Response (FOM name <code>HLAinteractionRoot.Response</code>) */
      RESPONSE("HLAinteractionRoot.Response");

      private static final Map<String, Interaction> NAMES;

      static {
         NAMES = new HashMap<String, Interaction>(values().length);
         for (Interaction val : values()) {
            NAMES.put(val._hlaName, val);
         }
      }

      private final String _hlaName;

      private Interaction(String hlaName) {
         _hlaName = hlaName;
      }

      /**
       * Get the HLA name of the interaction.
       *
       * @return the HLA name of the interaction.
       */
      public String getHlaName() {
         return _hlaName;
      }

     /**
      * Find the Interaction with the specified name.
      *
      * @param name name of the interaction to find
      *
      * @return the interaction with the specified <code>name</code>, or <code>null</code> if not found
      */
      public static Interaction find(String name) {
         return NAMES.get(name);
      }
   }

   /**
    * Interface for getting HLAinteractionRoot.Request parameters
    * <p>
    * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
    */
    public interface HlaRequestParameters {

      /**
       * Returns true if a valid value for fromNode is available.
       *
       * <br>Description from the FOM: <i></i>
       *
       * @return true if fromNode is valid
       */
       public boolean hasFromNode();

      /**
       * Returns the value of the fromNode parameter.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i></i>
       *
       * @return the fromNode
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public byte[] getFromNode() throws HlaValueNotSetException;

      /**
       * Returns the value of the fromNode parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i></i>
       *
       * @param defaultValue default value
       *
       * @return the fromNode or <code>defaultValue</code> if not set
       */
       public byte[] getFromNode(byte[] defaultValue);

      /**
       * Returns true if a valid value for toNode is available.
       *
       * <br>Description from the FOM: <i></i>
       *
       * @return true if toNode is valid
       */
       public boolean hasToNode();

      /**
       * Returns the value of the toNode parameter.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i></i>
       *
       * @return the toNode
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public byte[] getToNode() throws HlaValueNotSetException;

      /**
       * Returns the value of the toNode parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i></i>
       *
       * @param defaultValue default value
       *
       * @return the toNode or <code>defaultValue</code> if not set
       */
       public byte[] getToNode(byte[] defaultValue);

      /**
       * Returns true if a valid value for comType is available.
       *
       * <br>Description from the FOM: <i></i>
       *
       * @return true if comType is valid
       */
       public boolean hasComType();

      /**
       * Returns the value of the comType parameter.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^31, 2^31 - 1]</i>
       *
       * @return the comType
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public int getComType() throws HlaValueNotSetException;

      /**
       * Returns the value of the comType parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^31, 2^31 - 1]</i>
       *
       * @param defaultValue default value
       *
       * @return the comType or <code>defaultValue</code> if not set
       */
       public int getComType(int defaultValue);

      /**
       * Returns true if a valid value for transactionID is available.
       *
       * <br>Description from the FOM: <i></i>
       *
       * @return true if transactionID is valid
       */
       public boolean hasTransactionID();

      /**
       * Returns the value of the transactionID parameter.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
       *
       * @return the transactionID
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public long getTransactionID() throws HlaValueNotSetException;

      /**
       * Returns the value of the transactionID parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
       *
       * @param defaultValue default value
       *
       * @return the transactionID or <code>defaultValue</code> if not set
       */
       public long getTransactionID(long defaultValue);

      /**
       * Get the HlaFederateId for the federate that sent this interaction.
       *
       * @return The federate id for the federate that sent this interaction
       */
       public HlaFederateId getProducingFederate();

      /**
       * Check if the parameters are within the interest defined for this interaction.
       *
       * @return true if the parameters are within interest
       */
       public boolean isWithinInterest();

      /**
       * Get a string representation of the interaction parameters.
       *
       * @return A string representation of the interaction parameters.
       */
       public String toString();
    }

  /**
   *  Interface for creating a HlaRequestInteraction
   * <p>
   * This class is <code>ThreadSafe</code> as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
   */
   public interface HlaRequestInteraction {

     /**
      * Sets the value for fromNode.
      * <br>Description from the FOM: <i></i>
      * <br>Description of the data type from the FOM: <i></i>
      *
      * @param fromNode value to set
      *
      * @return the updated interaction
      *
      */
      public HlaRequestInteraction setFromNode(byte[] fromNode);

     /**
      * Sets the value for toNode.
      * <br>Description from the FOM: <i></i>
      * <br>Description of the data type from the FOM: <i></i>
      *
      * @param toNode value to set
      *
      * @return the updated interaction
      *
      */
      public HlaRequestInteraction setToNode(byte[] toNode);

     /**
      * Sets the value for comType.
      * <br>Description from the FOM: <i></i>
      * <br>Description of the data type from the FOM: <i>Integer in the range [-2^31, 2^31 - 1]</i>
      *
      * @param comType value to set
      *
      * @return the updated interaction
      *
      */
      public HlaRequestInteraction setComType(Integer comType);

     /**
      * Sets the value for transactionID.
      * <br>Description from the FOM: <i></i>
      * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
      *
      * @param transactionID value to set
      *
      * @return the updated interaction
      *
      */
      public HlaRequestInteraction setTransactionID(Long transactionID);

     /**
      * Send the HlaRequestInteraction
      *
      * @throws HlaNotConnectedException if the federate is not connected
      * @throws HlaFomException if the FOM is invalid
      * @throws HlaInternalException on internal errors
      * @throws HlaRtiException on exception from the RTI
      * @throws HlaSaveInProgressException if a federation save is in progress
      * @throws HlaRestoreInProgressException if a federation restore is in progress
      */
      public void sendInteraction() throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
                                           HlaSaveInProgressException, HlaRestoreInProgressException;

     /**
      * Send the HlaRequestInteraction with a specified timestamp
      *
      * @param timeStamp timestamp to send for this interaction
      *
      * @throws HlaNotConnectedException if the federate is not connected
      * @throws HlaFomException if the FOM is invalid
      * @throws HlaInternalException on internal errors
      * @throws HlaRtiException on exception from the RTI
      * @throws HlaSaveInProgressException if a federation save is in progress
      * @throws HlaRestoreInProgressException if a federation restore is in progress
      */
      public void sendInteraction(HlaTimeStamp timeStamp) throws HlaNotConnectedException, HlaFomException, HlaInternalException,
                                                                       HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;

     /**
      * Send the HlaRequestInteraction with a specified logical time.
      *
      * @param logicalTime logical time to send for this interaction
      *
      * @throws HlaNotConnectedException if the federate is not connected
      * @throws HlaFomException if the FOM is invalid
      * @throws HlaInvalidLogicalTimeException if the logical time is invalid
      * @throws HlaInternalException on internal errors
      * @throws HlaRtiException on exception from the RTI
      * @throws HlaSaveInProgressException if a federation save is in progress
      * @throws HlaRestoreInProgressException if a federation restore is in progress
      */
      public void sendInteraction(HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException,
                                                                           HlaInternalException, HlaRtiException, HlaSaveInProgressException,
                                                                           HlaRestoreInProgressException;

     /**
      * Send the HlaRequestInteraction with a specified timestamp and logical time.
      *
      * @param timeStamp timestamp to send for this interaction
      * @param logicalTime logical time to send for this interaction
      *
      * @throws HlaNotConnectedException if the federate is not connected
      * @throws HlaFomException if the FOM is invalid
      * @throws HlaInvalidLogicalTimeException if the logical time is invalid
      * @throws HlaInternalException on internal errors
      * @throws HlaRtiException on exception from the RTI
      * @throws HlaSaveInProgressException if a federation save is in progress
      * @throws HlaRestoreInProgressException if a federation restore is in progress
      */
      public void sendInteraction(HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) throws HlaNotConnectedException,
                                                                HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException,
                                                                HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;
   }

  /**
   * Get a HlaRequestInteraction
   *
   * @return An interaction
   */
   HlaRequestInteraction getHlaRequestInteraction();

   /**
    * Interface for getting HLAinteractionRoot.Response parameters
    * <p>
    * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
    */
    public interface HlaResponseParameters {

      /**
       * Returns true if a valid value for path is available.
       *
       * <br>Description from the FOM: <i>A list of nodes to be travesed</i>
       *
       * @return true if path is valid
       */
       public boolean hasPath();

      /**
       * Returns the value of the path parameter.
       *
       * <br>Description from the FOM: <i>A list of nodes to be travesed</i>
       * <br>Description of the data type from the FOM: <i></i>
       *
       * @return the path
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public byte[] getPath() throws HlaValueNotSetException;

      /**
       * Returns the value of the path parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i>A list of nodes to be travesed</i>
       * <br>Description of the data type from the FOM: <i></i>
       *
       * @param defaultValue default value
       *
       * @return the path or <code>defaultValue</code> if not set
       */
       public byte[] getPath(byte[] defaultValue);

      /**
       * Returns true if a valid value for transactionID is available.
       *
       * <br>Description from the FOM: <i></i>
       *
       * @return true if transactionID is valid
       */
       public boolean hasTransactionID();

      /**
       * Returns the value of the transactionID parameter.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
       *
       * @return the transactionID
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public long getTransactionID() throws HlaValueNotSetException;

      /**
       * Returns the value of the transactionID parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
       *
       * @param defaultValue default value
       *
       * @return the transactionID or <code>defaultValue</code> if not set
       */
       public long getTransactionID(long defaultValue);

      /**
       * Get the HlaFederateId for the federate that sent this interaction.
       *
       * @return The federate id for the federate that sent this interaction
       */
       public HlaFederateId getProducingFederate();

      /**
       * Check if the parameters are within the interest defined for this interaction.
       *
       * @return true if the parameters are within interest
       */
       public boolean isWithinInterest();

      /**
       * Get a string representation of the interaction parameters.
       *
       * @return A string representation of the interaction parameters.
       */
       public String toString();
    }

  /**
   *  Interface for creating a HlaResponseInteraction
   * <p>
   * This class is <code>ThreadSafe</code> as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
   */
   public interface HlaResponseInteraction {

     /**
      * Sets the value for path.
      * <br>Description from the FOM: <i>A list of nodes to be travesed</i>
      * <br>Description of the data type from the FOM: <i></i>
      *
      * @param path value to set
      *
      * @return the updated interaction
      *
      */
      public HlaResponseInteraction setPath(byte[] path);

     /**
      * Sets the value for transactionID.
      * <br>Description from the FOM: <i></i>
      * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
      *
      * @param transactionID value to set
      *
      * @return the updated interaction
      *
      */
      public HlaResponseInteraction setTransactionID(Long transactionID);

     /**
      * Send the HlaResponseInteraction
      *
      * @throws HlaNotConnectedException if the federate is not connected
      * @throws HlaFomException if the FOM is invalid
      * @throws HlaInternalException on internal errors
      * @throws HlaRtiException on exception from the RTI
      * @throws HlaSaveInProgressException if a federation save is in progress
      * @throws HlaRestoreInProgressException if a federation restore is in progress
      */
      public void sendInteraction() throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
                                           HlaSaveInProgressException, HlaRestoreInProgressException;

     /**
      * Send the HlaResponseInteraction with a specified timestamp
      *
      * @param timeStamp timestamp to send for this interaction
      *
      * @throws HlaNotConnectedException if the federate is not connected
      * @throws HlaFomException if the FOM is invalid
      * @throws HlaInternalException on internal errors
      * @throws HlaRtiException on exception from the RTI
      * @throws HlaSaveInProgressException if a federation save is in progress
      * @throws HlaRestoreInProgressException if a federation restore is in progress
      */
      public void sendInteraction(HlaTimeStamp timeStamp) throws HlaNotConnectedException, HlaFomException, HlaInternalException,
                                                                       HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;

     /**
      * Send the HlaResponseInteraction with a specified logical time.
      *
      * @param logicalTime logical time to send for this interaction
      *
      * @throws HlaNotConnectedException if the federate is not connected
      * @throws HlaFomException if the FOM is invalid
      * @throws HlaInvalidLogicalTimeException if the logical time is invalid
      * @throws HlaInternalException on internal errors
      * @throws HlaRtiException on exception from the RTI
      * @throws HlaSaveInProgressException if a federation save is in progress
      * @throws HlaRestoreInProgressException if a federation restore is in progress
      */
      public void sendInteraction(HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException,
                                                                           HlaInternalException, HlaRtiException, HlaSaveInProgressException,
                                                                           HlaRestoreInProgressException;

     /**
      * Send the HlaResponseInteraction with a specified timestamp and logical time.
      *
      * @param timeStamp timestamp to send for this interaction
      * @param logicalTime logical time to send for this interaction
      *
      * @throws HlaNotConnectedException if the federate is not connected
      * @throws HlaFomException if the FOM is invalid
      * @throws HlaInvalidLogicalTimeException if the logical time is invalid
      * @throws HlaInternalException on internal errors
      * @throws HlaRtiException on exception from the RTI
      * @throws HlaSaveInProgressException if a federation save is in progress
      * @throws HlaRestoreInProgressException if a federation restore is in progress
      */
      public void sendInteraction(HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) throws HlaNotConnectedException,
                                                                HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException,
                                                                HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;
   }

  /**
   * Get a HlaResponseInteraction
   *
   * @return An interaction
   */
   HlaResponseInteraction getHlaResponseInteraction();

   /**
    * Sends the <code>HLAinteractionRoot.Request</code> interaction.
    *
    * @param fromNode   represents the <code>fromNode</code> from the FOM.
    * <br>Description from the FOM: <i></i>
    * <br>Description of the data type from the FOM: <i></i>
    * @param toNode   represents the <code>toNode</code> from the FOM.
    * <br>Description from the FOM: <i></i>
    * <br>Description of the data type from the FOM: <i></i>
    * @param comType   represents the <code>comType</code> from the FOM.
    * <br>Description from the FOM: <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^31, 2^31 - 1]</i>
    * @param transactionID   represents the <code>transactionID</code> from the FOM.
    * <br>Description from the FOM: <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendRequest(
      byte[] fromNode,
      byte[] toNode,
      int comType,
      long transactionID
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.Request</code> interaction with a specified timestamp.
    *
    * @param fromNode   represents the <code>fromNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param toNode   represents the <code>toNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param comType   represents the <code>comType</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^31, 2^31 - 1]</i><br>
    * @param transactionID   represents the <code>transactionID</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param timeStamp timestamp to send for this interaction
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendRequest(
      byte[] fromNode,
      byte[] toNode,
      int comType,
      long transactionID,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.Request</code> interaction with a specified logical time.
    *
    * @param fromNode   represents the <code>fromNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param toNode   represents the <code>toNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param comType   represents the <code>comType</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^31, 2^31 - 1]</i><br>
    * @param transactionID   represents the <code>transactionID</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param logicalTime logical time to send for this interaction
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendRequest(
      byte[] fromNode,
      byte[] toNode,
      int comType,
      long transactionID,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException,
            HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.Request</code> interaction with a specified timestamp and logical time.
    *
    * @param fromNode   represents the <code>fromNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param toNode   represents the <code>toNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param comType   represents the <code>comType</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^31, 2^31 - 1]</i><br>
    * @param transactionID   represents the <code>transactionID</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param timeStamp timestamp to send for this interaction
    * @param logicalTime logical time to send for this interaction
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendRequest(
      byte[] fromNode,
      byte[] toNode,
      int comType,
      long transactionID,
      HlaTimeStamp timeStamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException,
            HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;
   /**
    * Sends the <code>HLAinteractionRoot.Response</code> interaction.
    *
    * @param path   represents the <code>Path</code> from the FOM.
    * <br>Description from the FOM: <i>A list of nodes to be travesed</i>
    * <br>Description of the data type from the FOM: <i></i>
    * @param transactionID   represents the <code>transactionID</code> from the FOM.
    * <br>Description from the FOM: <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendResponse(
      byte[] path,
      long transactionID
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.Response</code> interaction with a specified timestamp.
    *
    * @param path   represents the <code>Path</code> from the FOM.
    * <br>Description from the FOM <i>A list of nodes to be travesed</i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param transactionID   represents the <code>transactionID</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param timeStamp timestamp to send for this interaction
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendResponse(
      byte[] path,
      long transactionID,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.Response</code> interaction with a specified logical time.
    *
    * @param path   represents the <code>Path</code> from the FOM.
    * <br>Description from the FOM <i>A list of nodes to be travesed</i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param transactionID   represents the <code>transactionID</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param logicalTime logical time to send for this interaction
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendResponse(
      byte[] path,
      long transactionID,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException,
            HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.Response</code> interaction with a specified timestamp and logical time.
    *
    * @param path   represents the <code>Path</code> from the FOM.
    * <br>Description from the FOM <i>A list of nodes to be travesed</i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param transactionID   represents the <code>transactionID</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param timeStamp timestamp to send for this interaction
    * @param logicalTime logical time to send for this interaction
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInvalidLogicalTimeException if the logical time is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendResponse(
      byte[] path,
      long transactionID,
      HlaTimeStamp timeStamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException,
            HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Add a interaction listener.
    *
    * @param listener listener to add
    */
   void addHlaInteractionListener(HlaInteractionListener listener);

   /**
    * Remove a interaction listener.
    *
    * @param listener listener to remove
    */
   void removeHlaInteractionListener(HlaInteractionListener listener);

   /**
    * Enables or disables an interaction.
    * The interaction is enabled by default. The state can only be changed when not connected.
    * When an interaction is disabled it will act as disconnected,
    * ie throws HlaNotConnectedException.
    *
    * @param enabled <code>true</code> to enable the interaction, otherwise <code>false</code>
    * @param interaction the interaction to change
    */
   void setEnabled(boolean enabled, Interaction interaction);

   /**
    * Enables or disables a set of interactions.
    * The interactions are enabled by default. The state can only be changed when not connected.
    * When an interaction is disabled it will act as disconnected,
    * ie throws HlaNotConnectedException.
    *
    * @param enabled <code>true</code> to enable the interactions, otherwise <code>false</code>
    * @param interactions the interactions to change
    */
   void setEnabled(boolean enabled, Set<Interaction> interactions);

   /**
    * Enables a set of interactions if they are avalable in the FOM at runtime.
    * The interactions are enabled by default. The state can only be changed when not connected.
    * When an interaction is disabled it will act as disconnected,
    * ie throws HlaNotConnectedException.
    *
    * @param interactions the interactions to change
    */
   void setEnabledIfAvailableInFom(Set<Interaction> interactions);

   /**
    * Check if an interaction is actually enabled when connected.
    * An interaction may be disabled with the <code>setEnabled(false, ...)</code> function, or it may be configured
    * as <i>if available in the FOM</i> by the <code>setEnabledIfAvailableInFom(...)</code> function and
    * then not available in the FOM at runtime.
    * <p>
    * This method should only be used when connected, it will always return <code>false</code>
    * when not connected.
    *
    * @param interaction the interaction to check
    *
    * @return <code>true</code> if connected and the interaction is enabled.
    */
   boolean isEnabled(Interaction interaction);
}
