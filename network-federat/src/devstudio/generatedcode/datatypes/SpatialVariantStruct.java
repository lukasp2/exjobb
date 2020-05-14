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
 * Implementation of the <code>SpatialVariantStruct</code> data type from the FOM.
 * This datatype can be used with the RprUtility package. Please see the Overview document
 * located in the project root directory for more information.
 * <br>Description from the FOM: <i>Variant Record for a single spatial attribute.</i>
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public final class SpatialVariantStruct implements HlaVariantRecordDataType, se.pitch.rpr2.util.datatypes.Spatial {

   /**
    * The active discriminant of the variant record.
    */
    public final DeadReckoningAlgorithmEnum discriminant;

    /**
     * The value of the <code>SpatialStatic</code> field.
     * Note that this field is only valid of the discriminant is <code>Static</code>.
     * <br>Description from the FOM: <i>Variant for representing a static object.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm Static (1).</i>
     */
    public final SpatialStaticStruct spatialStatic;
    /**
     * The value of the <code>SpatialFPW</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_FPW</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with a constant velocity (or low acceleration) linear motion in world coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm FPW (2) and FPB (6).</i>
     */
    public final SpatialFPStruct spatialFPW;
    /**
     * The value of the <code>SpatialRPW</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_RPW</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with a constant velocity (or low acceleration) linear motion, including rotation information, in world coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm RPW (3) and RPB (7).</i>
     */
    public final SpatialRPStruct spatialRPW;
    /**
     * The value of the <code>SpatialRVW</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_RVW</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with high speed or maneuvering at any speed, including rotation information, in world coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm RVW (4) and RVB (8).</i>
     */
    public final SpatialRVStruct spatialRVW;
    /**
     * The value of the <code>SpatialFVW</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_FVW</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with high speed or maneuvering at any speed in world coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm FVW (5) and RVB (9).</i>
     */
    public final SpatialFVStruct spatialFVW;
    /**
     * The value of the <code>SpatialFPB</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_FPB</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with a constant velocity (or low acceleration) linear motion in body axis coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm FPW (2) and FPB (6).</i>
     */
    public final SpatialFPStruct spatialFPB;
    /**
     * The value of the <code>SpatialRPB</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_RPB</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with a constant velocity (or low acceleration) linear motion, including rotation information, in body axis coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm RPW (3) and RPB (7).</i>
     */
    public final SpatialRPStruct spatialRPB;
    /**
     * The value of the <code>SpatialRVB</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_RVB</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with high speed or maneuvering at any speed, including rotation information, in body axis coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm RVW (4) and RVB (8).</i>
     */
    public final SpatialRVStruct spatialRVB;
    /**
     * The value of the <code>SpatialFVB</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_FVB</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with high speed or maneuvering at any speed in body axis coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm FVW (5) and RVB (9).</i>
     */
    public final SpatialFVStruct spatialFVB;

    private SpatialVariantStruct(
        SpatialStaticStruct spatialStatic,
        SpatialFPStruct spatialFPW,
        SpatialRPStruct spatialRPW,
        SpatialRVStruct spatialRVW,
        SpatialFVStruct spatialFVW,
        SpatialFPStruct spatialFPB,
        SpatialRPStruct spatialRPB,
        SpatialRVStruct spatialRVB,
        SpatialFVStruct spatialFVB,
        DeadReckoningAlgorithmEnum discriminant
    ) {
        this.discriminant = discriminant;
        this.spatialStatic = spatialStatic;
        this.spatialFPW = spatialFPW;
        this.spatialRPW = spatialRPW;
        this.spatialRVW = spatialRVW;
        this.spatialFVW = spatialFVW;
        this.spatialFPB = spatialFPB;
        this.spatialRPB = spatialRPB;
        this.spatialRVB = spatialRVB;
        this.spatialFVB = spatialFVB;
    }

    public DeadReckoningAlgorithmEnum getDiscriminant() {
        return discriminant;
    }

    /**
     * Get the value of the <code>SpatialStatic</code> field.
     * Note that this field is only valid of the discriminant is <code>Static</code>.
     * <br>Description from the FOM: <i>Variant for representing a static object.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm Static (1).</i>
     *
     * @return the value of the <code>SpatialStatic</code> field
     */
    public SpatialStaticStruct getSpatialStatic() {
        return spatialStatic;
    }

    /**
     * Get the value of the <code>SpatialFPW</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_FPW</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with a constant velocity (or low acceleration) linear motion in world coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm FPW (2) and FPB (6).</i>
     *
     * @return the value of the <code>SpatialFPW</code> field
     */
    public SpatialFPStruct getSpatialFPW() {
        return spatialFPW;
    }

    /**
     * Get the value of the <code>SpatialRPW</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_RPW</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with a constant velocity (or low acceleration) linear motion, including rotation information, in world coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm RPW (3) and RPB (7).</i>
     *
     * @return the value of the <code>SpatialRPW</code> field
     */
    public SpatialRPStruct getSpatialRPW() {
        return spatialRPW;
    }

    /**
     * Get the value of the <code>SpatialRVW</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_RVW</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with high speed or maneuvering at any speed, including rotation information, in world coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm RVW (4) and RVB (8).</i>
     *
     * @return the value of the <code>SpatialRVW</code> field
     */
    public SpatialRVStruct getSpatialRVW() {
        return spatialRVW;
    }

    /**
     * Get the value of the <code>SpatialFVW</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_FVW</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with high speed or maneuvering at any speed in world coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm FVW (5) and RVB (9).</i>
     *
     * @return the value of the <code>SpatialFVW</code> field
     */
    public SpatialFVStruct getSpatialFVW() {
        return spatialFVW;
    }

    /**
     * Get the value of the <code>SpatialFPB</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_FPB</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with a constant velocity (or low acceleration) linear motion in body axis coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm FPW (2) and FPB (6).</i>
     *
     * @return the value of the <code>SpatialFPB</code> field
     */
    public SpatialFPStruct getSpatialFPB() {
        return spatialFPB;
    }

    /**
     * Get the value of the <code>SpatialRPB</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_RPB</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with a constant velocity (or low acceleration) linear motion, including rotation information, in body axis coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm RPW (3) and RPB (7).</i>
     *
     * @return the value of the <code>SpatialRPB</code> field
     */
    public SpatialRPStruct getSpatialRPB() {
        return spatialRPB;
    }

    /**
     * Get the value of the <code>SpatialRVB</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_RVB</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with high speed or maneuvering at any speed, including rotation information, in body axis coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm RVW (4) and RVB (8).</i>
     *
     * @return the value of the <code>SpatialRVB</code> field
     */
    public SpatialRVStruct getSpatialRVB() {
        return spatialRVB;
    }

    /**
     * Get the value of the <code>SpatialFVB</code> field.
     * Note that this field is only valid of the discriminant is <code>DRM_FVB</code>.
     * <br>Description from the FOM: <i>Variant for representing an object with high speed or maneuvering at any speed in body axis coordinates.</i>
     * <br>Description of the data type from the FOM: <i>Spatial structure for Dead Reckoning Algorithm FVW (5) and RVB (9).</i>
     *
     * @return the value of the <code>SpatialFVB</code> field
     */
    public SpatialFVStruct getSpatialFVB() {
        return spatialFVB;
    }


    /**
     * Create a new alternative SpatialVariantStruct, with <code>Static</code> as discriminant.
     *
     * @param spatialStatic value of the SpatialStatic field
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createSpatialStatic(SpatialStaticStruct spatialStatic) {
        if (spatialStatic == null) {
            throw new NullPointerException("spatialStatic can not be null");
        }
        return new SpatialVariantStruct(
            spatialStatic,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            DeadReckoningAlgorithmEnum.STATIC_
        );
    }

    /**
     * Create a new alternative SpatialVariantStruct, with <code>DRM_FPW</code> as discriminant.
     *
     * @param spatialFPW value of the SpatialFPW field
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createSpatialFPW(SpatialFPStruct spatialFPW) {
        if (spatialFPW == null) {
            throw new NullPointerException("spatialFPW can not be null");
        }
        return new SpatialVariantStruct(
            null,
            spatialFPW,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            DeadReckoningAlgorithmEnum.DRM_FPW
        );
    }

    /**
     * Create a new alternative SpatialVariantStruct, with <code>DRM_RPW</code> as discriminant.
     *
     * @param spatialRPW value of the SpatialRPW field
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createSpatialRPW(SpatialRPStruct spatialRPW) {
        if (spatialRPW == null) {
            throw new NullPointerException("spatialRPW can not be null");
        }
        return new SpatialVariantStruct(
            null,
            null,
            spatialRPW,
            null,
            null,
            null,
            null,
            null,
            null,
            DeadReckoningAlgorithmEnum.DRM_RPW
        );
    }

    /**
     * Create a new alternative SpatialVariantStruct, with <code>DRM_RVW</code> as discriminant.
     *
     * @param spatialRVW value of the SpatialRVW field
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createSpatialRVW(SpatialRVStruct spatialRVW) {
        if (spatialRVW == null) {
            throw new NullPointerException("spatialRVW can not be null");
        }
        return new SpatialVariantStruct(
            null,
            null,
            null,
            spatialRVW,
            null,
            null,
            null,
            null,
            null,
            DeadReckoningAlgorithmEnum.DRM_RVW
        );
    }

    /**
     * Create a new alternative SpatialVariantStruct, with <code>DRM_FVW</code> as discriminant.
     *
     * @param spatialFVW value of the SpatialFVW field
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createSpatialFVW(SpatialFVStruct spatialFVW) {
        if (spatialFVW == null) {
            throw new NullPointerException("spatialFVW can not be null");
        }
        return new SpatialVariantStruct(
            null,
            null,
            null,
            null,
            spatialFVW,
            null,
            null,
            null,
            null,
            DeadReckoningAlgorithmEnum.DRM_FVW
        );
    }

    /**
     * Create a new alternative SpatialVariantStruct, with <code>DRM_FPB</code> as discriminant.
     *
     * @param spatialFPB value of the SpatialFPB field
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createSpatialFPB(SpatialFPStruct spatialFPB) {
        if (spatialFPB == null) {
            throw new NullPointerException("spatialFPB can not be null");
        }
        return new SpatialVariantStruct(
            null,
            null,
            null,
            null,
            null,
            spatialFPB,
            null,
            null,
            null,
            DeadReckoningAlgorithmEnum.DRM_FPB
        );
    }

    /**
     * Create a new alternative SpatialVariantStruct, with <code>DRM_RPB</code> as discriminant.
     *
     * @param spatialRPB value of the SpatialRPB field
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createSpatialRPB(SpatialRPStruct spatialRPB) {
        if (spatialRPB == null) {
            throw new NullPointerException("spatialRPB can not be null");
        }
        return new SpatialVariantStruct(
            null,
            null,
            null,
            null,
            null,
            null,
            spatialRPB,
            null,
            null,
            DeadReckoningAlgorithmEnum.DRM_RPB
        );
    }

    /**
     * Create a new alternative SpatialVariantStruct, with <code>DRM_RVB</code> as discriminant.
     *
     * @param spatialRVB value of the SpatialRVB field
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createSpatialRVB(SpatialRVStruct spatialRVB) {
        if (spatialRVB == null) {
            throw new NullPointerException("spatialRVB can not be null");
        }
        return new SpatialVariantStruct(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            spatialRVB,
            null,
            DeadReckoningAlgorithmEnum.DRM_RVB
        );
    }

    /**
     * Create a new alternative SpatialVariantStruct, with <code>DRM_FVB</code> as discriminant.
     *
     * @param spatialFVB value of the SpatialFVB field
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createSpatialFVB(SpatialFVStruct spatialFVB) {
        if (spatialFVB == null) {
            throw new NullPointerException("spatialFVB can not be null");
        }
        return new SpatialVariantStruct(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            spatialFVB,
            DeadReckoningAlgorithmEnum.DRM_FVB
        );
    }

    /**
     * Create a new alternative SpatialVariantStruct, with <code>Other</code> as discriminant.
     *
     * @return a new SpatialVariantStruct
     */
    public static SpatialVariantStruct createOther() {
        return new SpatialVariantStruct(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            DeadReckoningAlgorithmEnum.OTHER
        );
    }


   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || getClass() != object.getClass()) {
         return false;
      }

      SpatialVariantStruct other = (SpatialVariantStruct)object;

      return new EqualsBuilder()
            .append(discriminant, other.discriminant)
            .append(spatialStatic, other.spatialStatic)
            .append(spatialFPW, other.spatialFPW)
            .append(spatialRPW, other.spatialRPW)
            .append(spatialRVW, other.spatialRVW)
            .append(spatialFVW, other.spatialFVW)
            .append(spatialFPB, other.spatialFPB)
            .append(spatialRPB, other.spatialRPB)
            .append(spatialRVB, other.spatialRVB)
            .append(spatialFVB, other.spatialFVB)
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder()
            .append(discriminant)
            .append(spatialStatic)
            .append(spatialFPW)
            .append(spatialRPW)
            .append(spatialRVW)
            .append(spatialFVW)
            .append(spatialFPB)
            .append(spatialRPB)
            .append(spatialRVB)
            .append(spatialFVB)
            .toHashCode();
   }

   @Override
   public String toString() {
      return new ToStringBuilder(this)
            .append("discriminant", discriminant)
            .append("spatialStatic", spatialStatic)
            .append("spatialFPW", spatialFPW)
            .append("spatialRPW", spatialRPW)
            .append("spatialRVW", spatialRVW)
            .append("spatialFVW", spatialFVW)
            .append("spatialFPB", spatialFPB)
            .append("spatialRPB", spatialRPB)
            .append("spatialRVB", spatialRVB)
            .append("spatialFVB", spatialFVB)
            .getToString();
   }

   /**
   * Get the discriminant ordinal
   *
   * @return the discriminant ordinal
   */
   public int getDiscriminantOrdinal() {
      return (int)discriminant.getOrdinal();
   }

   /**
   * Convert from RprUtility datatype
   *
   * @param spatial se.pitch.rpr2.util.datatypes.Spatial to convert to SpatialVariantStruct
   *
   * @return spatial converted to SpatialVariantStruct
   */
   public static SpatialVariantStruct convert(se.pitch.rpr2.util.datatypes.Spatial spatial) {
       int discriminant = spatial.getDiscriminantOrdinal();

       if (discriminant == DeadReckoningAlgorithmEnum.STATIC_.getOrdinal()) {
           return SpatialVariantStruct.createSpatialStatic(SpatialStaticStruct.convert(spatial.getSpatialStatic()));
       } else if (discriminant == DeadReckoningAlgorithmEnum.DRM_FPW.getOrdinal()) {
           return SpatialVariantStruct.createSpatialFPW(SpatialFPStruct.convert(spatial.getSpatialFPW()));
       } else if (discriminant == DeadReckoningAlgorithmEnum.DRM_RPW.getOrdinal()) {
           return SpatialVariantStruct.createSpatialRPW(SpatialRPStruct.convert(spatial.getSpatialRPW()));
       } else if (discriminant == DeadReckoningAlgorithmEnum.DRM_RVW.getOrdinal()) {
           return SpatialVariantStruct.createSpatialRVW(SpatialRVStruct.convert(spatial.getSpatialRVW()));
       } else if (discriminant == DeadReckoningAlgorithmEnum.DRM_FVW.getOrdinal()) {
           return SpatialVariantStruct.createSpatialFVW(SpatialFVStruct.convert(spatial.getSpatialFVW()));
       } else if (discriminant == DeadReckoningAlgorithmEnum.DRM_FPB.getOrdinal()) {
           return SpatialVariantStruct.createSpatialFPB(SpatialFPStruct.convert(spatial.getSpatialFPB()));
       } else if (discriminant == DeadReckoningAlgorithmEnum.DRM_RPB.getOrdinal()) {
           return SpatialVariantStruct.createSpatialRPB(SpatialRPStruct.convert(spatial.getSpatialRPB()));
       } else if (discriminant == DeadReckoningAlgorithmEnum.DRM_RVB.getOrdinal()) {
           return SpatialVariantStruct.createSpatialRVB(SpatialRVStruct.convert(spatial.getSpatialRVB()));
       } else if (discriminant == DeadReckoningAlgorithmEnum.DRM_FVB.getOrdinal()) {
           return SpatialVariantStruct.createSpatialFVB(SpatialFVStruct.convert(spatial.getSpatialFVB()));
       }

       return null;
   }
}
