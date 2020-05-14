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
public interface HlaNETNGroundVehicleAttributes {

  /**
   * An enumeration of the attributes of an HlaNETNGroundVehicle.
   *
   * <table summary="All attributes">
   * <tr><td><b>Enum constant</b></td><td><b>Java name</b></td><td><b>FOM name</b></td></tr>
   * <tr><td>UNIQUE_ID</td><td> uniqueID</td><td> <code>UniqueID</code></td></tr>
   * <tr><td>SPATIAL</td><td> spatial</td><td> <code>Spatial</code></td></tr>
   * </table>
   */
   enum Attribute {
      /**
      * uniqueID (FOM name: <code>UniqueID</code>).
      * <br>Description from the FOM: <i>The unique identifier of the object. 
Required value. 
If not assigned by the ORBAT specification or similar, shall a value be assigned, either randomized or generated from the Marking or EntityIdentifier attribute value.</i>
      */
      UNIQUE_ID("UniqueID"),
      /**
      * spatial (FOM name: <code>Spatial</code>).
      * <br>Description from the FOM: <i>Spatial state stored in one variant record attribute.</i>
      */
      SPATIAL("Spatial");
      
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
    * Returns true if the <code>uniqueID</code> attribute has received a value yet.
    *
    * <br>Description from the FOM: <i>The unique identifier of the object. 
Required value. 
If not assigned by the ORBAT specification or similar, shall a value be assigned, either randomized or generated from the Marking or EntityIdentifier attribute value.</i>
    *
    * @return true if <code>uniqueID</code> is available.
    */
    boolean hasUniqueID();

   /**
    * Gets the value of the <code>uniqueID</code> attribute.
    *
    * <br>Description from the FOM: <i>The unique identifier of the object. 
Required value. 
If not assigned by the ORBAT specification or similar, shall a value be assigned, either randomized or generated from the Marking or EntityIdentifier attribute value.</i>
    * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
    *
    * @return the <code>uniqueID</code> attribute.
    *
    * @throws HlaValueNotSetException unchecked exception that is thrown if no value is available.
    */
    byte[/* 16 */] getUniqueID() throws HlaValueNotSetException;

   /**
    * Gets the value of the <code>uniqueID</code> attribute, or <code>defaultValue</code> if value was not set.
    *
    * <br>Description from the FOM: <i>The unique identifier of the object. 
Required value. 
If not assigned by the ORBAT specification or similar, shall a value be assigned, either randomized or generated from the Marking or EntityIdentifier attribute value.</i>
    * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
    *
    * @param defaultValue default value
    *
    * @return the <code>uniqueID</code> attribute or <code>defaultValue</code> if not set
    */
    byte[/* 16 */] getUniqueID(byte[/* 16 */] defaultValue);

    /**
     * Gets the time stamped value of the <code>uniqueID</code> attribute.
     *
     * <br>Description from the FOM: <i>The unique identifier of the object. 
Required value. 
If not assigned by the ORBAT specification or similar, shall a value be assigned, either randomized or generated from the Marking or EntityIdentifier attribute value.</i>
     * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
     *
     * @return the time stamped <code>uniqueID</code> attribute.
     *
     * @throws HlaValueNotSetException unchecked exception that is thrown if no value is available.
     */
     HlaTimeStamped<byte[/* 16 */]> getUniqueIDTimeStamped() throws HlaValueNotSetException;

   /**
    * Returns true if the <code>spatial</code> attribute has received a value yet.
    *
    * <br>Description from the FOM: <i>Spatial state stored in one variant record attribute.</i>
    *
    * @return true if <code>spatial</code> is available.
    */
    boolean hasSpatial();

   /**
    * Gets the value of the <code>spatial</code> attribute.
    *
    * <br>Description from the FOM: <i>Spatial state stored in one variant record attribute.</i>
    * <br>Description of the data type from the FOM: <i>Variant Record for a single spatial attribute.</i>
    *
    * @return the <code>spatial</code> attribute.
    *
    * @throws HlaValueNotSetException unchecked exception that is thrown if no value is available.
    */
    SpatialVariantStruct getSpatial() throws HlaValueNotSetException;

   /**
    * Gets the value of the <code>spatial</code> attribute, or <code>defaultValue</code> if value was not set.
    *
    * <br>Description from the FOM: <i>Spatial state stored in one variant record attribute.</i>
    * <br>Description of the data type from the FOM: <i>Variant Record for a single spatial attribute.</i>
    *
    * @param defaultValue default value
    *
    * @return the <code>spatial</code> attribute or <code>defaultValue</code> if not set
    */
    SpatialVariantStruct getSpatial(SpatialVariantStruct defaultValue);

    /**
     * Gets the time stamped value of the <code>spatial</code> attribute.
     *
     * <br>Description from the FOM: <i>Spatial state stored in one variant record attribute.</i>
     * <br>Description of the data type from the FOM: <i>Variant Record for a single spatial attribute.</i>
     *
     * @return the time stamped <code>spatial</code> attribute.
     *
     * @throws HlaValueNotSetException unchecked exception that is thrown if no value is available.
     */
     HlaTimeStamped<SpatialVariantStruct> getSpatialTimeStamped() throws HlaValueNotSetException;
}
