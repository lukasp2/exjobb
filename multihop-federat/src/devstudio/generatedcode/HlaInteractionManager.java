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
    * <tr><td>REQUEST_PATH</td><td>RequestPath</td><td><code>HLAinteractionRoot.RequestPath</code></td></tr>
    * <tr><td>RESPONSE_PATH</td><td>ResponsePath</td><td><code>HLAinteractionRoot.ResponsePath</code></td></tr>
    * </table>
    */
   enum Interaction {
      /** RequestPath (FOM name <code>HLAinteractionRoot.RequestPath</code>) */
      REQUEST_PATH("HLAinteractionRoot.RequestPath"),
      /** ResponsePath (FOM name <code>HLAinteractionRoot.ResponsePath</code>) */
      RESPONSE_PATH("HLAinteractionRoot.ResponsePath");

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
    * Interface for getting HLAinteractionRoot.RequestPath parameters
    * <p>
    * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
    */
    public interface HlaRequestPathParameters {

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
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
       *
       * @return the fromNode
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public long getFromNode() throws HlaValueNotSetException;

      /**
       * Returns the value of the fromNode parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
       *
       * @param defaultValue default value
       *
       * @return the fromNode or <code>defaultValue</code> if not set
       */
       public long getFromNode(long defaultValue);

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
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
       *
       * @return the toNode
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public long getToNode() throws HlaValueNotSetException;

      /**
       * Returns the value of the toNode parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
       *
       * @param defaultValue default value
       *
       * @return the toNode or <code>defaultValue</code> if not set
       */
       public long getToNode(long defaultValue);

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
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^15, 2^15 - 1]</i>
       *
       * @return the comType
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public short getComType() throws HlaValueNotSetException;

      /**
       * Returns the value of the comType parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i></i>
       * <br>Description of the data type from the FOM: <i>Integer in the range [-2^15, 2^15 - 1]</i>
       *
       * @param defaultValue default value
       *
       * @return the comType or <code>defaultValue</code> if not set
       */
       public short getComType(short defaultValue);

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
   *  Interface for creating a HlaRequestPathInteraction
   * <p>
   * This class is <code>ThreadSafe</code> as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
   */
   public interface HlaRequestPathInteraction {

     /**
      * Sets the value for fromNode.
      * <br>Description from the FOM: <i></i>
      * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
      *
      * @param fromNode value to set
      *
      * @return the updated interaction
      *
      */
      public HlaRequestPathInteraction setFromNode(Long fromNode);

     /**
      * Sets the value for toNode.
      * <br>Description from the FOM: <i></i>
      * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
      *
      * @param toNode value to set
      *
      * @return the updated interaction
      *
      */
      public HlaRequestPathInteraction setToNode(Long toNode);

     /**
      * Sets the value for comType.
      * <br>Description from the FOM: <i></i>
      * <br>Description of the data type from the FOM: <i>Integer in the range [-2^15, 2^15 - 1]</i>
      *
      * @param comType value to set
      *
      * @return the updated interaction
      *
      */
      public HlaRequestPathInteraction setComType(Short comType);

     /**
      * Send the HlaRequestPathInteraction
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
      * Send the HlaRequestPathInteraction with a specified timestamp
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
      * Send the HlaRequestPathInteraction with a specified logical time.
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
      * Send the HlaRequestPathInteraction with a specified timestamp and logical time.
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
   * Get a HlaRequestPathInteraction
   *
   * @return An interaction
   */
   HlaRequestPathInteraction getHlaRequestPathInteraction();

   /**
    * Interface for getting HLAinteractionRoot.ResponsePath parameters
    * <p>
    * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
    */
    public interface HlaResponsePathParameters {

      /**
       * Returns true if a valid value for nodeArray is available.
       *
       * <br>Description from the FOM: <i>Array of the nodes to be traversed in the network</i>
       *
       * @return true if nodeArray is valid
       */
       public boolean hasNodeArray();

      /**
       * Returns the value of the nodeArray parameter.
       *
       * <br>Description from the FOM: <i>Array of the nodes to be traversed in the network</i>
       * <br>Description of the data type from the FOM: <i></i>
       *
       * @return the nodeArray
       *
       * @throws HlaValueNotSetException if value was not set
       */
       public byte[] getNodeArray() throws HlaValueNotSetException;

      /**
       * Returns the value of the nodeArray parameter, or <code>defaultValue</code> if value was not set.
       *
       * <br>Description from the FOM: <i>Array of the nodes to be traversed in the network</i>
       * <br>Description of the data type from the FOM: <i></i>
       *
       * @param defaultValue default value
       *
       * @return the nodeArray or <code>defaultValue</code> if not set
       */
       public byte[] getNodeArray(byte[] defaultValue);

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
   *  Interface for creating a HlaResponsePathInteraction
   * <p>
   * This class is <code>ThreadSafe</code> as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
   */
   public interface HlaResponsePathInteraction {

     /**
      * Sets the value for nodeArray.
      * <br>Description from the FOM: <i>Array of the nodes to be traversed in the network</i>
      * <br>Description of the data type from the FOM: <i></i>
      *
      * @param nodeArray value to set
      *
      * @return the updated interaction
      *
      */
      public HlaResponsePathInteraction setNodeArray(byte[] nodeArray);

     /**
      * Send the HlaResponsePathInteraction
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
      * Send the HlaResponsePathInteraction with a specified timestamp
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
      * Send the HlaResponsePathInteraction with a specified logical time.
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
      * Send the HlaResponsePathInteraction with a specified timestamp and logical time.
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
   * Get a HlaResponsePathInteraction
   *
   * @return An interaction
   */
   HlaResponsePathInteraction getHlaResponsePathInteraction();

   /**
    * Sends the <code>HLAinteractionRoot.RequestPath</code> interaction.
    *
    * @param fromNode   represents the <code>fromNode</code> from the FOM.
    * <br>Description from the FOM: <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
    * @param toNode   represents the <code>toNode</code> from the FOM.
    * <br>Description from the FOM: <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i>
    * @param comType   represents the <code>comType</code> from the FOM.
    * <br>Description from the FOM: <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^15, 2^15 - 1]</i>
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendRequestPath(
      long fromNode,
      long toNode,
      short comType
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.RequestPath</code> interaction with a specified timestamp.
    *
    * @param fromNode   represents the <code>fromNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param toNode   represents the <code>toNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param comType   represents the <code>comType</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^15, 2^15 - 1]</i><br>
    * @param timeStamp timestamp to send for this interaction
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendRequestPath(
      long fromNode,
      long toNode,
      short comType,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.RequestPath</code> interaction with a specified logical time.
    *
    * @param fromNode   represents the <code>fromNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param toNode   represents the <code>toNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param comType   represents the <code>comType</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^15, 2^15 - 1]</i><br>
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
   void sendRequestPath(
      long fromNode,
      long toNode,
      short comType,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException,
            HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.RequestPath</code> interaction with a specified timestamp and logical time.
    *
    * @param fromNode   represents the <code>fromNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param toNode   represents the <code>toNode</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^63, 2^63 - 1]</i><br>
    * @param comType   represents the <code>comType</code> from the FOM.
    * <br>Description from the FOM <i></i>
    * <br>Description of the data type from the FOM: <i>Integer in the range [-2^15, 2^15 - 1]</i><br>
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
   void sendRequestPath(
      long fromNode,
      long toNode,
      short comType,
      HlaTimeStamp timeStamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException,
            HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;
   /**
    * Sends the <code>HLAinteractionRoot.ResponsePath</code> interaction.
    *
    * @param nodeArray   represents the <code>nodeArray</code> from the FOM.
    * <br>Description from the FOM: <i>Array of the nodes to be traversed in the network</i>
    * <br>Description of the data type from the FOM: <i></i>
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendResponsePath(
      byte[] nodeArray
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.ResponsePath</code> interaction with a specified timestamp.
    *
    * @param nodeArray   represents the <code>nodeArray</code> from the FOM.
    * <br>Description from the FOM <i>Array of the nodes to be traversed in the network</i>
    * <br>Description of the data type from the FOM: <i></i><br>
    * @param timeStamp timestamp to send for this interaction
    *
    * @throws HlaNotConnectedException if the federate is not connected
    * @throws HlaFomException if the FOM is invalid
    * @throws HlaInternalException on internal errors
    * @throws HlaRtiException on exception from the RTI
    * @throws HlaSaveInProgressException if a federation save is in progress
    * @throws HlaRestoreInProgressException if a federation restore is in progress
    */
   void sendResponsePath(
      byte[] nodeArray,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.ResponsePath</code> interaction with a specified logical time.
    *
    * @param nodeArray   represents the <code>nodeArray</code> from the FOM.
    * <br>Description from the FOM <i>Array of the nodes to be traversed in the network</i>
    * <br>Description of the data type from the FOM: <i></i><br>
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
   void sendResponsePath(
      byte[] nodeArray,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException,
            HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException;

   /**
    * Sends the <code>HLAinteractionRoot.ResponsePath</code> interaction with a specified timestamp and logical time.
    *
    * @param nodeArray   represents the <code>nodeArray</code> from the FOM.
    * <br>Description from the FOM <i>Array of the nodes to be traversed in the network</i>
    * <br>Description of the data type from the FOM: <i></i><br>
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
   void sendResponsePath(
      byte[] nodeArray,
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
