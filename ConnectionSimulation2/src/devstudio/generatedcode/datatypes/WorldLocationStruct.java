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
 * Implementation of the <code>WorldLocationStruct</code> data type from the FOM.
 * This datatype can be used with the RprUtility package. Please see the Overview document
 * located in the project root directory for more information.
 * <br>Description from the FOM: <i>The location of an object in the world coordinate system, as specified in IEEE Std 1278.1-1995 section 1.3.2.</i>
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public final class WorldLocationStruct implements se.pitch.rpr2.util.datatypes.WorldLocation {

   /**
    * The value of the X field.
    * <br>FOM name: <code>X</code>.
    * <br>Description from the FOM: <i>Distance from the origin along the X axis.</i>
    */
    public final double x;
   /**
    * The value of the Y field.
    * <br>FOM name: <code>Y</code>.
    * <br>Description from the FOM: <i>Distance from the origin along the Y axis.</i>
    */
    public final double y;
   /**
    * The value of the Z field.
    * <br>FOM name: <code>Z</code>.
    * <br>Description from the FOM: <i>Distance from the origin along the Z axis.</i>
    */
    public final double z;

    private WorldLocationStruct(
        double x,
        double y,
        double z
    ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

   /**
    * Create a new WorldLocationStruct.
    *
    * @param x value of the X field
    * <br>Description from the FOM: <i>Distance from the origin along the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Datatype based on SI base unit meter, unit symbol m. [unit: meter (m), resolution: NA, accuracy: perfect]</i>
    * @param y value of the Y field
    * <br>Description from the FOM: <i>Distance from the origin along the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Datatype based on SI base unit meter, unit symbol m. [unit: meter (m), resolution: NA, accuracy: perfect]</i>
    * @param z value of the Z field
    * <br>Description from the FOM: <i>Distance from the origin along the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Datatype based on SI base unit meter, unit symbol m. [unit: meter (m), resolution: NA, accuracy: perfect]</i>
    *
    * @return a new WorldLocationStruct
    */
    public static WorldLocationStruct create(
        double x,
        double y,
        double z
    ) {

        return new WorldLocationStruct(
           x,
           y,
           z
        );
    }

   /**
    * Get the value of the X field.
    * <br>FOM name: <code>X</code>.
    * <br>Description from the FOM: <i>Distance from the origin along the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Datatype based on SI base unit meter, unit symbol m. [unit: meter (m), resolution: NA, accuracy: perfect]</i>
    *
    * @return the value of the X field
    */
    public double getX() {
        return x;
    }

   /**
    * Get the value of the Y field.
    * <br>FOM name: <code>Y</code>.
    * <br>Description from the FOM: <i>Distance from the origin along the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Datatype based on SI base unit meter, unit symbol m. [unit: meter (m), resolution: NA, accuracy: perfect]</i>
    *
    * @return the value of the Y field
    */
    public double getY() {
        return y;
    }

   /**
    * Get the value of the Z field.
    * <br>FOM name: <code>Z</code>.
    * <br>Description from the FOM: <i>Distance from the origin along the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Datatype based on SI base unit meter, unit symbol m. [unit: meter (m), resolution: NA, accuracy: perfect]</i>
    *
    * @return the value of the Z field
    */
    public double getZ() {
        return z;
    }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || getClass() != object.getClass()) {
         return false;
      }

      WorldLocationStruct other = (WorldLocationStruct)object;

      return new EqualsBuilder()
            .append(x, other.x)
            .append(y, other.y)
            .append(z, other.z)
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder()
            .append(x)
            .append(y)
            .append(z)
            .toHashCode();
   }

   @Override
   public String toString() {
      return new ToStringBuilder(this)
            .append("x", x)
            .append("y", y)
            .append("z", z)
            .getToString();
   }

   /**
   * Convert from RprUtility datatype
   *
   * @param data se.pitch.rpr2.util.datatypes.WorldLocation to convert to WorldLocationStruct
   *
   * @return data converted to WorldLocationStruct
   */    
   public static WorldLocationStruct convert(se.pitch.rpr2.util.datatypes.WorldLocation data) {
      return WorldLocationStruct.create(
            data.getX(),
            data.getY(),
            data.getZ()
      );
   }
}