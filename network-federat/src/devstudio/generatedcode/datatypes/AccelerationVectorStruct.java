package devstudio.generatedcode.datatypes;

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
 * Implementation of the <code>AccelerationVectorStruct</code> data type from the FOM.
 * This datatype can be used with the RprUtility package. Please see the Overview document
 * located in the project root directory for more information.
 * <br>Description from the FOM: <i>The magnitude of the change in linear velocity over time.</i>
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public final class AccelerationVectorStruct implements se.pitch.rpr2.util.datatypes.AccelerationVector {

   /**
    * The value of the XAcceleration field.
    * <br>FOM name: <code>XAcceleration</code>.
    * <br>Description from the FOM: <i>Acceleration component along the X axis.</i>
    */
    public final float xAcceleration;
   /**
    * The value of the YAcceleration field.
    * <br>FOM name: <code>YAcceleration</code>.
    * <br>Description from the FOM: <i>Acceleration component along the Y axis.</i>
    */
    public final float yAcceleration;
   /**
    * The value of the ZAcceleration field.
    * <br>FOM name: <code>ZAcceleration</code>.
    * <br>Description from the FOM: <i>Acceleration component along the Z axis.</i>
    */
    public final float zAcceleration;

    private AccelerationVectorStruct(
        float xAcceleration,
        float yAcceleration,
        float zAcceleration
    ) {
        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;
        this.zAcceleration = zAcceleration;
    }

   /**
    * Create a new AccelerationVectorStruct.
    *
    * @param xAcceleration value of the XAcceleration field
    * <br>Description from the FOM: <i>Acceleration component along the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Linear acceleration vector composed of SI base units. Based on the Linear Acceleration Vector record as specified in IEEE 1278.1-1995 section 5.2.33b. [unit: meter per second squared (m/(s^2)), resolution: NA, accuracy: NA]</i>
    * @param yAcceleration value of the YAcceleration field
    * <br>Description from the FOM: <i>Acceleration component along the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Linear acceleration vector composed of SI base units. Based on the Linear Acceleration Vector record as specified in IEEE 1278.1-1995 section 5.2.33b. [unit: meter per second squared (m/(s^2)), resolution: NA, accuracy: NA]</i>
    * @param zAcceleration value of the ZAcceleration field
    * <br>Description from the FOM: <i>Acceleration component along the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Linear acceleration vector composed of SI base units. Based on the Linear Acceleration Vector record as specified in IEEE 1278.1-1995 section 5.2.33b. [unit: meter per second squared (m/(s^2)), resolution: NA, accuracy: NA]</i>
    *
    * @return a new AccelerationVectorStruct
    */
    public static AccelerationVectorStruct create(
        float xAcceleration,
        float yAcceleration,
        float zAcceleration
    ) {

        return new AccelerationVectorStruct(
           xAcceleration,
           yAcceleration,
           zAcceleration
        );
    }

   /**
    * Get the value of the XAcceleration field.
    * <br>FOM name: <code>XAcceleration</code>.
    * <br>Description from the FOM: <i>Acceleration component along the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Linear acceleration vector composed of SI base units. Based on the Linear Acceleration Vector record as specified in IEEE 1278.1-1995 section 5.2.33b. [unit: meter per second squared (m/(s^2)), resolution: NA, accuracy: NA]</i>
    *
    * @return the value of the XAcceleration field
    */
    public float getXAcceleration() {
        return xAcceleration;
    }

   /**
    * Get the value of the YAcceleration field.
    * <br>FOM name: <code>YAcceleration</code>.
    * <br>Description from the FOM: <i>Acceleration component along the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Linear acceleration vector composed of SI base units. Based on the Linear Acceleration Vector record as specified in IEEE 1278.1-1995 section 5.2.33b. [unit: meter per second squared (m/(s^2)), resolution: NA, accuracy: NA]</i>
    *
    * @return the value of the YAcceleration field
    */
    public float getYAcceleration() {
        return yAcceleration;
    }

   /**
    * Get the value of the ZAcceleration field.
    * <br>FOM name: <code>ZAcceleration</code>.
    * <br>Description from the FOM: <i>Acceleration component along the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Linear acceleration vector composed of SI base units. Based on the Linear Acceleration Vector record as specified in IEEE 1278.1-1995 section 5.2.33b. [unit: meter per second squared (m/(s^2)), resolution: NA, accuracy: NA]</i>
    *
    * @return the value of the ZAcceleration field
    */
    public float getZAcceleration() {
        return zAcceleration;
    }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || getClass() != object.getClass()) {
         return false;
      }

      AccelerationVectorStruct other = (AccelerationVectorStruct)object;

      return new EqualsBuilder()
            .append(xAcceleration, other.xAcceleration)
            .append(yAcceleration, other.yAcceleration)
            .append(zAcceleration, other.zAcceleration)
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder()
            .append(xAcceleration)
            .append(yAcceleration)
            .append(zAcceleration)
            .toHashCode();
   }

   @Override
   public String toString() {
      return new ToStringBuilder(this)
            .append("xAcceleration", xAcceleration)
            .append("yAcceleration", yAcceleration)
            .append("zAcceleration", zAcceleration)
            .getToString();
   }

   /**
   * Convert from RprUtility datatype
   *
   * @param data se.pitch.rpr2.util.datatypes.AccelerationVector to convert to AccelerationVectorStruct
   *
   * @return data converted to AccelerationVectorStruct
   */    
   public static AccelerationVectorStruct convert(se.pitch.rpr2.util.datatypes.AccelerationVector data) {
      return AccelerationVectorStruct.create(
            data.getXAcceleration(),
            data.getYAcceleration(),
            data.getZAcceleration()
      );
   }
}