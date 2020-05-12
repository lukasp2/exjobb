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

/**
 * Listener for updates of attributes, with the new updated values.  
 */
public interface HlaNETNGroundVehicleValueListener {

   /**
    * This method is called when the attribute <code>uniqueID</code> is updated.
    * <br>Description from the FOM: <i>The unique identifier of the object. 
Required value. 
If not assigned by the ORBAT specification or similar, shall a value be assigned, either randomized or generated from the Marking or EntityIdentifier attribute value.</i>
    * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
    *
    * @param nETNGroundVehicle   The object which is updated.
    * @param uniqueID    The new value of the attribute in this update
    * @param validOldUniqueID True if oldUniqueID contains a valid value
    * @param oldUniqueID   The old value of the attribute
    * @param timeStamp  The time when the update was initiated.
    * @param logicalTime The logical time when the update was initiated.
    */
    void uniqueIDUpdated(HlaNETNGroundVehicle nETNGroundVehicle, byte[/* 16 */] uniqueID, boolean validOldUniqueID, byte[/* 16 */] oldUniqueID, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * This method is called when the attribute <code>spatial</code> is updated.
    * <br>Description from the FOM: <i>Spatial state stored in one variant record attribute.</i>
    * <br>Description of the data type from the FOM: <i>Variant Record for a single spatial attribute.</i>
    *
    * @param nETNGroundVehicle   The object which is updated.
    * @param spatial    The new value of the attribute in this update
    * @param validOldSpatial True if oldSpatial contains a valid value
    * @param oldSpatial   The old value of the attribute
    * @param timeStamp  The time when the update was initiated.
    * @param logicalTime The logical time when the update was initiated.
    */
    void spatialUpdated(HlaNETNGroundVehicle nETNGroundVehicle, SpatialVariantStruct spatial, boolean validOldSpatial, SpatialVariantStruct oldSpatial, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * This method is called when the producing federate of an attribute is changed.
    * Only available when using HLA Evolved.
    *
    * @param nETNGroundVehicle The object which is updated.
    * @param attribute The attribute that now has a new producing federate
    * @param oldProducingFederate The federate handle of the old producing federate
    * @param newProducingFederate The federate handle of the new producing federate
    * @param timeStamp  The time when the update was initiated.
    * @param logicalTime The logical time when the update was initiated.
    */
    void producingFederateUpdated(HlaNETNGroundVehicle nETNGroundVehicle, HlaNETNGroundVehicleAttributes.Attribute attribute, HlaFederateId oldProducingFederate, HlaFederateId newProducingFederate, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime);

   /**
    * An abstract adapter class that implements the HlaNETNGroundVehicleValueListener interface with empty methods.
    * It might be used as a base class for a listener.
    */
    public abstract static class Adapter implements HlaNETNGroundVehicleValueListener {
        public void uniqueIDUpdated(HlaNETNGroundVehicle nETNGroundVehicle, byte[/* 16 */] uniqueID, boolean validOldUniqueID, byte[/* 16 */] oldUniqueID, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
        public void spatialUpdated(HlaNETNGroundVehicle nETNGroundVehicle, SpatialVariantStruct spatial, boolean validOldSpatial, SpatialVariantStruct oldSpatial, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
        public void producingFederateUpdated(HlaNETNGroundVehicle instance, HlaNETNGroundVehicleAttributes.Attribute attribute, HlaFederateId oldProducingFederate, HlaFederateId newProducingFederate, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {}
    }
}
