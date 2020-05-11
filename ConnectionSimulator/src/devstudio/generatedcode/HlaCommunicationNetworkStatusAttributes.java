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
import devstudio.generatedcode.exceptions.HlaValueNotSetException;

import java.util.HashMap;
import java.util.Map;


/**
 * Interface used to represent all attributes for an object instance.
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public interface HlaCommunicationNetworkStatusAttributes {

  /**
   * An enumeration of the attributes of an HlaCommunicationNetworkStatus.
   *
   * <table summary="All attributes">
   * <tr><td><b>Enum constant</b></td><td><b>Java name</b></td><td><b>FOM name</b></td></tr>
   * <tr><td>COMMUNICATION_CONNECTIVITY</td><td> communicationConnectivity</td><td> <code>CommunicationConnectivity</code></td></tr>
   * </table>
   */
   enum Attribute {
      /**
      * communicationConnectivity (FOM name: <code>CommunicationConnectivity</code>).
      * <br>Description from the FOM: <i>N/A</i>
      */
      COMMUNICATION_CONNECTIVITY("CommunicationConnectivity");
      
      private static final Map<String, Attribute> NAMES;

      static {
         NAMES = new HashMap<String, Attribute>(values().length);
         for (Attribute val : values()) {
            NAMES.put(val._name, val);
         }
      }

      private final String _name;

      private Attribute(String name) {
         _name = name;
      }

     /**
      * Get the name of the Attribute.
      *
      * @return the name of the attribute
      */
      public String getName() {
         return _name;
      }

     /**
      * Find the Attribute with the specified name.
      *
      * @param name name of the attribute to find
      *
      * @return the attribute with the specified <code>name</code>, or <code>null</code> if not found
      */
      public static Attribute find(String name) {
         return NAMES.get(name);
      }
   }


   /**
    * Returns true if the <code>communicationConnectivity</code> attribute has received a value yet.
    *
    * <br>Description from the FOM: <i>N/A</i>
    *
    * @return true if <code>communicationConnectivity</code> is available.
    */
    boolean hasCommunicationConnectivity();

   /**
    * Gets the value of the <code>communicationConnectivity</code> attribute.
    *
    * <br>Description from the FOM: <i>N/A</i>
    * <br>Description of the data type from the FOM: <i>N/A</i>
    *
    * @return the <code>communicationConnectivity</code> attribute.
    *
    * @throws HlaValueNotSetException unchecked exception that is thrown if no value is available.
    */
    NetworkConnectivityStruct[] getCommunicationConnectivity() throws HlaValueNotSetException;

   /**
    * Gets the value of the <code>communicationConnectivity</code> attribute, or <code>defaultValue</code> if value was not set.
    *
    * <br>Description from the FOM: <i>N/A</i>
    * <br>Description of the data type from the FOM: <i>N/A</i>
    *
    * @param defaultValue default value
    *
    * @return the <code>communicationConnectivity</code> attribute or <code>defaultValue</code> if not set
    */
    NetworkConnectivityStruct[] getCommunicationConnectivity(NetworkConnectivityStruct[] defaultValue);

    /**
     * Gets the time stamped value of the <code>communicationConnectivity</code> attribute.
     *
     * <br>Description from the FOM: <i>N/A</i>
     * <br>Description of the data type from the FOM: <i>N/A</i>
     *
     * @return the time stamped <code>communicationConnectivity</code> attribute.
     *
     * @throws HlaValueNotSetException unchecked exception that is thrown if no value is available.
     */
     HlaTimeStamped<NetworkConnectivityStruct[]> getCommunicationConnectivityTimeStamped() throws HlaValueNotSetException;
}
