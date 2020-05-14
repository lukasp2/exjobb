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
 * Implementation of the <code>SpatialRVStruct</code> data type from the FOM.
 * This datatype can be used with the RprUtility package. Please see the Overview document
 * located in the project root directory for more information.
 * <br>Description from the FOM: <i>Spatial structure for Dead Reckoning Algorithm RVW (4) and RVB (8).</i>
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public final class SpatialRVStruct implements se.pitch.rpr2.util.datatypes.SpatialRV {

   /**
    * The value of the WorldLocation field.
    * <br>FOM name: <code>WorldLocation</code>.
    * <br>Description from the FOM: <i>Location of the object.</i>
    */
    public final WorldLocationStruct worldLocation;
   /**
    * The value of the IsFrozen field.
    * <br>FOM name: <code>IsFrozen</code>.
    * <br>Description from the FOM: <i>Whether the object is frozen or not.</i>
    */
    public final boolean isFrozen;
   /**
    * The value of the Orientation field.
    * <br>FOM name: <code>Orientation</code>.
    * <br>Description from the FOM: <i>The angles of rotation around the coordinate axes between the object's attitude and the reference coordinate system axes (calculated as the Tait-Bryan Euler angles specifying the successive rotations needed to transform from the world coordinate system to the entity coordinate system).</i>
    */
    public final OrientationStruct orientation;
   /**
    * The value of the VelocityVector field.
    * <br>FOM name: <code>VelocityVector</code>.
    * <br>Description from the FOM: <i>The rate at which an object's position is changing over time.</i>
    */
    public final VelocityVectorStruct velocityVector;
   /**
    * The value of the AccelerationVector field.
    * <br>FOM name: <code>AccelerationVector</code>.
    * <br>Description from the FOM: <i>The magnitude of the change in linear velocity of an object over time.</i>
    */
    public final AccelerationVectorStruct accelerationVector;
   /**
    * The value of the AngularVelocity field.
    * <br>FOM name: <code>AngularVelocity</code>.
    * <br>Description from the FOM: <i>The rate at which an object's orientation is changing over time.</i>
    */
    public final AngularVelocityVectorStruct angularVelocity;

    private SpatialRVStruct(
        WorldLocationStruct worldLocation,
        boolean isFrozen,
        OrientationStruct orientation,
        VelocityVectorStruct velocityVector,
        AccelerationVectorStruct accelerationVector,
        AngularVelocityVectorStruct angularVelocity
    ) {
        this.worldLocation = worldLocation;
        this.isFrozen = isFrozen;
        this.orientation = orientation;
        this.velocityVector = velocityVector;
        this.accelerationVector = accelerationVector;
        this.angularVelocity = angularVelocity;
    }

   /**
    * Create a new SpatialRVStruct.
    *
    * @param worldLocation value of the WorldLocation field
    * <br>Description from the FOM: <i>Location of the object.</i>
    * <br>Description of the data type from the FOM: <i>The location of an object in the world coordinate system, as specified in IEEE Std 1278.1-1995 section 1.3.2.</i>
    * @param isFrozen value of the IsFrozen field
    * <br>Description from the FOM: <i>Whether the object is frozen or not.</i>
    * <br>Description of the data type from the FOM: <i></i>
    * @param orientation value of the Orientation field
    * <br>Description from the FOM: <i>The angles of rotation around the coordinate axes between the object's attitude and the reference coordinate system axes (calculated as the Tait-Bryan Euler angles specifying the successive rotations needed to transform from the world coordinate system to the entity coordinate system).</i>
    * <br>Description of the data type from the FOM: <i>The orientation of an object in the world coordinate system, as specified in IEEE Std 1278.1-1995 section 1.3.2.</i>
    * @param velocityVector value of the VelocityVector field
    * <br>Description from the FOM: <i>The rate at which an object's position is changing over time.</i>
    * <br>Description of the data type from the FOM: <i>The rate at which the position is changing over time.</i>
    * @param accelerationVector value of the AccelerationVector field
    * <br>Description from the FOM: <i>The magnitude of the change in linear velocity of an object over time.</i>
    * <br>Description of the data type from the FOM: <i>The magnitude of the change in linear velocity over time.</i>
    * @param angularVelocity value of the AngularVelocity field
    * <br>Description from the FOM: <i>The rate at which an object's orientation is changing over time.</i>
    * <br>Description of the data type from the FOM: <i>The rate at which the orientation is changing over time, in body coordinates.</i>
    *
    * @return a new SpatialRVStruct
    */
    public static SpatialRVStruct create(
        WorldLocationStruct worldLocation,
        boolean isFrozen,
        OrientationStruct orientation,
        VelocityVectorStruct velocityVector,
        AccelerationVectorStruct accelerationVector,
        AngularVelocityVectorStruct angularVelocity
    ) {
        if (worldLocation == null) {
            throw new NullPointerException("worldLocation can not be null");
        }
        if (orientation == null) {
            throw new NullPointerException("orientation can not be null");
        }
        if (velocityVector == null) {
            throw new NullPointerException("velocityVector can not be null");
        }
        if (accelerationVector == null) {
            throw new NullPointerException("accelerationVector can not be null");
        }
        if (angularVelocity == null) {
            throw new NullPointerException("angularVelocity can not be null");
        }

        return new SpatialRVStruct(
           worldLocation,
           isFrozen,
           orientation,
           velocityVector,
           accelerationVector,
           angularVelocity
        );
    }

   /**
    * Get the value of the WorldLocation field.
    * <br>FOM name: <code>WorldLocation</code>.
    * <br>Description from the FOM: <i>Location of the object.</i>
    * <br>Description of the data type from the FOM: <i>The location of an object in the world coordinate system, as specified in IEEE Std 1278.1-1995 section 1.3.2.</i>
    *
    * @return the value of the WorldLocation field
    */
    public WorldLocationStruct getWorldLocation() {
        return worldLocation;
    }

   /**
    * Get the value of the IsFrozen field.
    * <br>FOM name: <code>IsFrozen</code>.
    * <br>Description from the FOM: <i>Whether the object is frozen or not.</i>
    * <br>Description of the data type from the FOM: <i></i>
    *
    * @return the value of the IsFrozen field
    */
    public boolean getIsFrozen() {
        return isFrozen;
    }

   /**
    * Get the value of the Orientation field.
    * <br>FOM name: <code>Orientation</code>.
    * <br>Description from the FOM: <i>The angles of rotation around the coordinate axes between the object's attitude and the reference coordinate system axes (calculated as the Tait-Bryan Euler angles specifying the successive rotations needed to transform from the world coordinate system to the entity coordinate system).</i>
    * <br>Description of the data type from the FOM: <i>The orientation of an object in the world coordinate system, as specified in IEEE Std 1278.1-1995 section 1.3.2.</i>
    *
    * @return the value of the Orientation field
    */
    public OrientationStruct getOrientation() {
        return orientation;
    }

   /**
    * Get the value of the VelocityVector field.
    * <br>FOM name: <code>VelocityVector</code>.
    * <br>Description from the FOM: <i>The rate at which an object's position is changing over time.</i>
    * <br>Description of the data type from the FOM: <i>The rate at which the position is changing over time.</i>
    *
    * @return the value of the VelocityVector field
    */
    public VelocityVectorStruct getVelocityVector() {
        return velocityVector;
    }

   /**
    * Get the value of the AccelerationVector field.
    * <br>FOM name: <code>AccelerationVector</code>.
    * <br>Description from the FOM: <i>The magnitude of the change in linear velocity of an object over time.</i>
    * <br>Description of the data type from the FOM: <i>The magnitude of the change in linear velocity over time.</i>
    *
    * @return the value of the AccelerationVector field
    */
    public AccelerationVectorStruct getAccelerationVector() {
        return accelerationVector;
    }

   /**
    * Get the value of the AngularVelocity field.
    * <br>FOM name: <code>AngularVelocity</code>.
    * <br>Description from the FOM: <i>The rate at which an object's orientation is changing over time.</i>
    * <br>Description of the data type from the FOM: <i>The rate at which the orientation is changing over time, in body coordinates.</i>
    *
    * @return the value of the AngularVelocity field
    */
    public AngularVelocityVectorStruct getAngularVelocity() {
        return angularVelocity;
    }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || getClass() != object.getClass()) {
         return false;
      }

      SpatialRVStruct other = (SpatialRVStruct)object;

      return new EqualsBuilder()
            .append(worldLocation, other.worldLocation)
            .append(isFrozen, other.isFrozen)
            .append(orientation, other.orientation)
            .append(velocityVector, other.velocityVector)
            .append(accelerationVector, other.accelerationVector)
            .append(angularVelocity, other.angularVelocity)
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder()
            .append(worldLocation)
            .append(isFrozen)
            .append(orientation)
            .append(velocityVector)
            .append(accelerationVector)
            .append(angularVelocity)
            .toHashCode();
   }

   @Override
   public String toString() {
      return new ToStringBuilder(this)
            .append("worldLocation", worldLocation)
            .append("isFrozen", isFrozen)
            .append("orientation", orientation)
            .append("velocityVector", velocityVector)
            .append("accelerationVector", accelerationVector)
            .append("angularVelocity", angularVelocity)
            .getToString();
   }

   /**
   * Convert from RprUtility datatype
   *
   * @param data se.pitch.rpr2.util.datatypes.SpatialRV to convert to SpatialRVStruct
   *
   * @return data converted to SpatialRVStruct
   */    
   public static SpatialRVStruct convert(se.pitch.rpr2.util.datatypes.SpatialRV data) {
      return SpatialRVStruct.create(
            WorldLocationStruct.convert(data.getWorldLocation()),
            data.getIsFrozen(),
            OrientationStruct.convert(data.getOrientation()),
            VelocityVectorStruct.convert(data.getVelocityVector()),
            AccelerationVectorStruct.convert(data.getAccelerationVector()),
            AngularVelocityVectorStruct.convert(data.getAngularVelocity())
      );
   }
}