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
 * Implementation of the <code>AngularVelocityVectorStruct</code> data type from the FOM.
 * This datatype can be used with the RprUtility package. Please see the Overview document
 * located in the project root directory for more information.
 * <br>Description from the FOM: <i>The rate at which the orientation is changing over time, in body coordinates.</i>
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public final class AngularVelocityVectorStruct implements se.pitch.rpr2.util.datatypes.AngularVelocityVector {

   /**
    * The value of the XAngularVelocity field.
    * <br>FOM name: <code>XAngularVelocity</code>.
    * <br>Description from the FOM: <i>Acceleration component about the X axis.</i>
    */
    public final float xAngularVelocity;
   /**
    * The value of the YAngularVelocity field.
    * <br>FOM name: <code>YAngularVelocity</code>.
    * <br>Description from the FOM: <i>Acceleration component about the Y axis.</i>
    */
    public final float yAngularVelocity;
   /**
    * The value of the ZAngularVelocity field.
    * <br>FOM name: <code>ZAngularVelocity</code>.
    * <br>Description from the FOM: <i>Acceleration component about the Z axis.</i>
    */
    public final float zAngularVelocity;

    private AngularVelocityVectorStruct(
        float xAngularVelocity,
        float yAngularVelocity,
        float zAngularVelocity
    ) {
        this.xAngularVelocity = xAngularVelocity;
        this.yAngularVelocity = yAngularVelocity;
        this.zAngularVelocity = zAngularVelocity;
    }

   /**
    * Create a new AngularVelocityVectorStruct.
    *
    * @param xAngularVelocity value of the XAngularVelocity field
    * <br>Description from the FOM: <i>Acceleration component about the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Angular velocity vector composed of SI base units. Based on the Angular Velocity Vector record as specified in IEEE 1278.1-1995 section 5.2.2. [unit: radian per second (rad/s), resolution: NA, accuracy: perfect]</i>
    * @param yAngularVelocity value of the YAngularVelocity field
    * <br>Description from the FOM: <i>Acceleration component about the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Angular velocity vector composed of SI base units. Based on the Angular Velocity Vector record as specified in IEEE 1278.1-1995 section 5.2.2. [unit: radian per second (rad/s), resolution: NA, accuracy: perfect]</i>
    * @param zAngularVelocity value of the ZAngularVelocity field
    * <br>Description from the FOM: <i>Acceleration component about the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Angular velocity vector composed of SI base units. Based on the Angular Velocity Vector record as specified in IEEE 1278.1-1995 section 5.2.2. [unit: radian per second (rad/s), resolution: NA, accuracy: perfect]</i>
    *
    * @return a new AngularVelocityVectorStruct
    */
    public static AngularVelocityVectorStruct create(
        float xAngularVelocity,
        float yAngularVelocity,
        float zAngularVelocity
    ) {

        return new AngularVelocityVectorStruct(
           xAngularVelocity,
           yAngularVelocity,
           zAngularVelocity
        );
    }

   /**
    * Get the value of the XAngularVelocity field.
    * <br>FOM name: <code>XAngularVelocity</code>.
    * <br>Description from the FOM: <i>Acceleration component about the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Angular velocity vector composed of SI base units. Based on the Angular Velocity Vector record as specified in IEEE 1278.1-1995 section 5.2.2. [unit: radian per second (rad/s), resolution: NA, accuracy: perfect]</i>
    *
    * @return the value of the XAngularVelocity field
    */
    public float getXAngularVelocity() {
        return xAngularVelocity;
    }

   /**
    * Get the value of the YAngularVelocity field.
    * <br>FOM name: <code>YAngularVelocity</code>.
    * <br>Description from the FOM: <i>Acceleration component about the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Angular velocity vector composed of SI base units. Based on the Angular Velocity Vector record as specified in IEEE 1278.1-1995 section 5.2.2. [unit: radian per second (rad/s), resolution: NA, accuracy: perfect]</i>
    *
    * @return the value of the YAngularVelocity field
    */
    public float getYAngularVelocity() {
        return yAngularVelocity;
    }

   /**
    * Get the value of the ZAngularVelocity field.
    * <br>FOM name: <code>ZAngularVelocity</code>.
    * <br>Description from the FOM: <i>Acceleration component about the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Angular velocity vector composed of SI base units. Based on the Angular Velocity Vector record as specified in IEEE 1278.1-1995 section 5.2.2. [unit: radian per second (rad/s), resolution: NA, accuracy: perfect]</i>
    *
    * @return the value of the ZAngularVelocity field
    */
    public float getZAngularVelocity() {
        return zAngularVelocity;
    }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || getClass() != object.getClass()) {
         return false;
      }

      AngularVelocityVectorStruct other = (AngularVelocityVectorStruct)object;

      return new EqualsBuilder()
            .append(xAngularVelocity, other.xAngularVelocity)
            .append(yAngularVelocity, other.yAngularVelocity)
            .append(zAngularVelocity, other.zAngularVelocity)
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder()
            .append(xAngularVelocity)
            .append(yAngularVelocity)
            .append(zAngularVelocity)
            .toHashCode();
   }

   @Override
   public String toString() {
      return new ToStringBuilder(this)
            .append("xAngularVelocity", xAngularVelocity)
            .append("yAngularVelocity", yAngularVelocity)
            .append("zAngularVelocity", zAngularVelocity)
            .getToString();
   }

   /**
   * Convert from RprUtility datatype
   *
   * @param data se.pitch.rpr2.util.datatypes.AngularVelocityVector to convert to AngularVelocityVectorStruct
   *
   * @return data converted to AngularVelocityVectorStruct
   */    
   public static AngularVelocityVectorStruct convert(se.pitch.rpr2.util.datatypes.AngularVelocityVector data) {
      return AngularVelocityVectorStruct.create(
            data.getXAngularVelocity(),
            data.getYAngularVelocity(),
            data.getZAngularVelocity()
      );
   }
}