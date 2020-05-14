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
 * Implementation of the <code>OrientationStruct</code> data type from the FOM.
 * This datatype can be used with the RprUtility package. Please see the Overview document
 * located in the project root directory for more information.
 * <br>Description from the FOM: <i>The orientation of an object in the world coordinate system, as specified in IEEE Std 1278.1-1995 section 1.3.2.</i>
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public final class OrientationStruct implements se.pitch.rpr2.util.datatypes.Orientation {

   /**
    * The value of the Psi field.
    * <br>FOM name: <code>Psi</code>.
    * <br>Description from the FOM: <i>Rotation about the Z axis.</i>
    */
    public final float psi;
   /**
    * The value of the Theta field.
    * <br>FOM name: <code>Theta</code>.
    * <br>Description from the FOM: <i>Rotation about the Y axis.</i>
    */
    public final float theta;
   /**
    * The value of the Phi field.
    * <br>FOM name: <code>Phi</code>.
    * <br>Description from the FOM: <i>Rotation about the X axis.</i>
    */
    public final float phi;

    private OrientationStruct(
        float psi,
        float theta,
        float phi
    ) {
        this.psi = psi;
        this.theta = theta;
        this.phi = phi;
    }

   /**
    * Create a new OrientationStruct.
    *
    * @param psi value of the Psi field
    * <br>Description from the FOM: <i>Rotation about the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Angle, based on SI derived unit radian, unit symbol rad. [unit: radian (rad), resolution: NA, accuracy: NA]</i>
    * @param theta value of the Theta field
    * <br>Description from the FOM: <i>Rotation about the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Angle, based on SI derived unit radian, unit symbol rad. [unit: radian (rad), resolution: NA, accuracy: NA]</i>
    * @param phi value of the Phi field
    * <br>Description from the FOM: <i>Rotation about the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Angle, based on SI derived unit radian, unit symbol rad. [unit: radian (rad), resolution: NA, accuracy: NA]</i>
    *
    * @return a new OrientationStruct
    */
    public static OrientationStruct create(
        float psi,
        float theta,
        float phi
    ) {

        return new OrientationStruct(
           psi,
           theta,
           phi
        );
    }

   /**
    * Get the value of the Psi field.
    * <br>FOM name: <code>Psi</code>.
    * <br>Description from the FOM: <i>Rotation about the Z axis.</i>
    * <br>Description of the data type from the FOM: <i>Angle, based on SI derived unit radian, unit symbol rad. [unit: radian (rad), resolution: NA, accuracy: NA]</i>
    *
    * @return the value of the Psi field
    */
    public float getPsi() {
        return psi;
    }

   /**
    * Get the value of the Theta field.
    * <br>FOM name: <code>Theta</code>.
    * <br>Description from the FOM: <i>Rotation about the Y axis.</i>
    * <br>Description of the data type from the FOM: <i>Angle, based on SI derived unit radian, unit symbol rad. [unit: radian (rad), resolution: NA, accuracy: NA]</i>
    *
    * @return the value of the Theta field
    */
    public float getTheta() {
        return theta;
    }

   /**
    * Get the value of the Phi field.
    * <br>FOM name: <code>Phi</code>.
    * <br>Description from the FOM: <i>Rotation about the X axis.</i>
    * <br>Description of the data type from the FOM: <i>Angle, based on SI derived unit radian, unit symbol rad. [unit: radian (rad), resolution: NA, accuracy: NA]</i>
    *
    * @return the value of the Phi field
    */
    public float getPhi() {
        return phi;
    }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || getClass() != object.getClass()) {
         return false;
      }

      OrientationStruct other = (OrientationStruct)object;

      return new EqualsBuilder()
            .append(psi, other.psi)
            .append(theta, other.theta)
            .append(phi, other.phi)
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder()
            .append(psi)
            .append(theta)
            .append(phi)
            .toHashCode();
   }

   @Override
   public String toString() {
      return new ToStringBuilder(this)
            .append("psi", psi)
            .append("theta", theta)
            .append("phi", phi)
            .getToString();
   }

   /**
   * Convert from RprUtility datatype
   *
   * @param data se.pitch.rpr2.util.datatypes.Orientation to convert to OrientationStruct
   *
   * @return data converted to OrientationStruct
   */    
   public static OrientationStruct convert(se.pitch.rpr2.util.datatypes.Orientation data) {
      return OrientationStruct.create(
            data.getPsi(),
            data.getTheta(),
            data.getPhi()
      );
   }
}