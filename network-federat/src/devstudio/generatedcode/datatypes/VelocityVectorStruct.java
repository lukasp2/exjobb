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
 * Implementation of the <code>VelocityVectorStruct</code> data type from the FOM.
 * This datatype can be used with the RprUtility package. Please see the Overview document
 * located in the project root directory for more information.
 * <br>Description from the FOM: <i>The rate at which the position is changing over time.</i>
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public final class VelocityVectorStruct implements se.pitch.rpr2.util.datatypes.VelocityVector {

   /**
    * The value of the XVelocity field.
    * <br>FOM name: <code>XVelocity</code>.
    * <br>Description from the FOM: <i>Velocity component along the X axis.</i>
    */
    public final float xVelocity;
   /**
    * The value of the YVelocity field.
    * <br>FOM name: <code>YVelocity</code>.
    * <br>Description from the FOM: <i>Velocity component along the Y axis.</i>
    */
    public final float yVelocity;
   /**
    * The value of the ZVelocity field.
    * <br>FOM name: <code>ZVelocity</code>.
    * <br>Description from the FOM: <i>Velocity component along the Z axis.</i>
    */
    public final float zVelocity;

    private VelocityVectorStruct(
        float xVelocity,
        float yVelocity,
        float zVelocity
    ) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.zVelocity = zVelocity;
    }

   /**
    * Create a new VelocityVectorStruct.
    *
    * @param xVelocity value of the XVelocity field
    * <br>Description from the FOM: <i>Velocity component along the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Speed/Velocity in meter per second. [unit: meter per second (m/s), resolution: NA, accuracy: perfect]</i>
    * @param yVelocity value of the YVelocity field
    * <br>Description from the FOM: <i>Velocity component along the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Speed/Velocity in meter per second. [unit: meter per second (m/s), resolution: NA, accuracy: perfect]</i>
    * @param zVelocity value of the ZVelocity field
    * <br>Description from the FOM: <i>Velocity component along the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Speed/Velocity in meter per second. [unit: meter per second (m/s), resolution: NA, accuracy: perfect]</i>
    *
    * @return a new VelocityVectorStruct
    */
    public static VelocityVectorStruct create(
        float xVelocity,
        float yVelocity,
        float zVelocity
    ) {

        return new VelocityVectorStruct(
           xVelocity,
           yVelocity,
           zVelocity
        );
    }

   /**
    * Get the value of the XVelocity field.
    * <br>FOM name: <code>XVelocity</code>.
    * <br>Description from the FOM: <i>Velocity component along the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Speed/Velocity in meter per second. [unit: meter per second (m/s), resolution: NA, accuracy: perfect]</i>
    *
    * @return the value of the XVelocity field
    */
    public float getXVelocity() {
        return xVelocity;
    }

   /**
    * Get the value of the YVelocity field.
    * <br>FOM name: <code>YVelocity</code>.
    * <br>Description from the FOM: <i>Velocity component along the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Speed/Velocity in meter per second. [unit: meter per second (m/s), resolution: NA, accuracy: perfect]</i>
    *
    * @return the value of the YVelocity field
    */
    public float getYVelocity() {
        return yVelocity;
    }

   /**
    * Get the value of the ZVelocity field.
    * <br>FOM name: <code>ZVelocity</code>.
    * <br>Description from the FOM: <i>Velocity component along the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Speed/Velocity in meter per second. [unit: meter per second (m/s), resolution: NA, accuracy: perfect]</i>
    *
    * @return the value of the ZVelocity field
    */
    public float getZVelocity() {
        return zVelocity;
    }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || getClass() != object.getClass()) {
         return false;
      }

      VelocityVectorStruct other = (VelocityVectorStruct)object;

      return new EqualsBuilder()
            .append(xVelocity, other.xVelocity)
            .append(yVelocity, other.yVelocity)
            .append(zVelocity, other.zVelocity)
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder()
            .append(xVelocity)
            .append(yVelocity)
            .append(zVelocity)
            .toHashCode();
   }

   @Override
   public String toString() {
      return new ToStringBuilder(this)
            .append("xVelocity", xVelocity)
            .append("yVelocity", yVelocity)
            .append("zVelocity", zVelocity)
            .getToString();
   }

   /**
   * Convert from RprUtility datatype
   *
   * @param data se.pitch.rpr2.util.datatypes.VelocityVector to convert to VelocityVectorStruct
   *
   * @return data converted to VelocityVectorStruct
   */    
   public static VelocityVectorStruct convert(se.pitch.rpr2.util.datatypes.VelocityVector data) {
      return VelocityVectorStruct.create(
            data.getXVelocity(),
            data.getYVelocity(),
            data.getZVelocity()
      );
   }
}