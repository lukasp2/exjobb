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
 * Implementation of the <code>DeadReckoningAlgorithmEnum8</code> data type from the FOM.
 * <br>Description from the FOM: <i>Dead-reckoning algorithm</i>
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public enum DeadReckoningAlgorithmEnum implements HlaEnumDataType {
    /** <code>Other</code> (with ordinal 0) */
    OTHER("Other", 0),
    /** <code>Static</code> (with ordinal 1) */
    STATIC_("Static", 1),
    /** <code>DRM_FPW</code> (with ordinal 2) */
    DRM_FPW("DRM_FPW", 2),
    /** <code>DRM_RPW</code> (with ordinal 3) */
    DRM_RPW("DRM_RPW", 3),
    /** <code>DRM_RVW</code> (with ordinal 4) */
    DRM_RVW("DRM_RVW", 4),
    /** <code>DRM_FVW</code> (with ordinal 5) */
    DRM_FVW("DRM_FVW", 5),
    /** <code>DRM_FPB</code> (with ordinal 6) */
    DRM_FPB("DRM_FPB", 6),
    /** <code>DRM_RPB</code> (with ordinal 7) */
    DRM_RPB("DRM_RPB", 7),
    /** <code>DRM_RVB</code> (with ordinal 8) */
    DRM_RVB("DRM_RVB", 8),
    /** <code>DRM_FVB</code> (with ordinal 9) */
    DRM_FVB("DRM_FVB", 9);

   /**
    * The name of the enum.
    */
    public final String name;
   /**
    * The ordinal of the enum.
    */
    public final long ordinal;

    private DeadReckoningAlgorithmEnum(String name, long ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public long getOrdinal() {
        return ordinal;
    }

    public String getName() {
        return name;
    }

   /**
    * Find the enum with the specified ordinal.
    *
    * @param ordinal ordinal of the enum to find
    *
    * @return the enum with the specified <code>ordinal</code>, or <code>null</code> if not found
    */
    public static DeadReckoningAlgorithmEnum find(long ordinal) {
        for (DeadReckoningAlgorithmEnum value : values()) {
            if (value.getOrdinal() == ordinal) {
                return value;
            }
        }
        return null;
    }

   /**
    * Find the enum with the specified name.
    *
    * @param name name of the enum to find
    *
    * @return the enum with the specified <code>name</code>, or <code>null</code> if not found
    */
    public static DeadReckoningAlgorithmEnum find(String name) {
        for (DeadReckoningAlgorithmEnum value : values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }
}
