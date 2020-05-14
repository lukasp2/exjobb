package devstudio.generatedcode.impl;

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
import devstudio.generatedcode.HlaNETNGroundVehicleAttributes;
import devstudio.generatedcode.HlaTimeStamped;
import devstudio.generatedcode.exceptions.HlaValueNotSetException;
import devstudio.generatedcode.impl.utils.AttributeValue;

/* @Immutable */
final class HlaNETNGroundVehicleAttributesImpl implements HlaNETNGroundVehicleAttributes {

   private final AttributeValue<byte[/* 16 */]> _uniqueID;
   private final AttributeValue<SpatialVariantStruct> _spatial;

   HlaNETNGroundVehicleAttributesImpl(
      AttributeValue<byte[/* 16 */]> uniqueID,
      AttributeValue<SpatialVariantStruct> spatial
   ) {
      _uniqueID = new AttributeValue<byte[/* 16 */]>(uniqueID);
      _spatial = new AttributeValue<SpatialVariantStruct>(spatial);
   }

   public boolean hasUniqueID() {
      return _uniqueID.hasValue();
   }

   public byte[/* 16 */] getUniqueID() throws HlaValueNotSetException {
      if (_uniqueID.hasValue()) {
         return _uniqueID.getValue();
      }
      throw new HlaValueNotSetException("Attribute 'uniqueID' not set");
   }

   public byte[/* 16 */] getUniqueID(byte[/* 16 */] defaultValue) {
      if (_uniqueID.hasValue()) {
         return _uniqueID.getValue();
      }
      return defaultValue;
   }

   public HlaTimeStamped<byte[/* 16 */]> getUniqueIDTimeStamped() throws HlaValueNotSetException {
      if (_uniqueID.hasValue()) {
         return _uniqueID.getTimestampedValueForUser();
      }
      throw new HlaValueNotSetException("Attribute 'uniqueID' not set");
   }

   public boolean hasSpatial() {
      return _spatial.hasValue();
   }

   public SpatialVariantStruct getSpatial() throws HlaValueNotSetException {
      if (_spatial.hasValue()) {
         return _spatial.getValue();
      }
      throw new HlaValueNotSetException("Attribute 'spatial' not set");
   }

   public SpatialVariantStruct getSpatial(SpatialVariantStruct defaultValue) {
      if (_spatial.hasValue()) {
         return _spatial.getValue();
      }
      return defaultValue;
   }

   public HlaTimeStamped<SpatialVariantStruct> getSpatialTimeStamped() throws HlaValueNotSetException {
      if (_spatial.hasValue()) {
         return _spatial.getTimestampedValueForUser();
      }
      throw new HlaValueNotSetException("Attribute 'spatial' not set");
   }

}
