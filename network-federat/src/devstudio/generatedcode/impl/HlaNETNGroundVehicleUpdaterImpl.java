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
import devstudio.generatedcode.HlaNETNGroundVehicleUpdater;
import devstudio.generatedcode.HlaNETNGroundVehicleListener;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.impl.utils.AttributeValue;
import devstudio.generatedcode.HlaNETNGroundVehicleAttributes; 

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;


/* @ThreadSafe */
final class HlaNETNGroundVehicleUpdaterImpl implements HlaNETNGroundVehicleUpdater {
   private final AtomicBoolean _updateSent = new AtomicBoolean(false);
   private final Object _attributesLock = new Object();

   /* @GuardedBy("_attributesLock") */
   private final AttributeValue<byte[/* 16 */]> _uniqueID = new AttributeValue<byte[/* 16 */]>();
   /* @GuardedBy("_attributesLock") */
   private final AttributeValue<SpatialVariantStruct> _spatial = new AttributeValue<SpatialVariantStruct>();

   private final HlaNETNGroundVehicleImpl _instance;


   HlaNETNGroundVehicleUpdaterImpl(HlaNETNGroundVehicleImpl instance) {
      _instance = instance;
   }

   public HlaNETNGroundVehicleUpdaterImpl setUniqueID(byte[/* 16 */] value) {
      if (value == null) {
         throw new NullPointerException();
      }
      synchronized (_attributesLock) {
         _uniqueID.setValueFromUser(value);
      }
      return this;
   }

   public HlaNETNGroundVehicleUpdaterImpl setSpatial(SpatialVariantStruct value) {
      if (value == null) {
         throw new NullPointerException();
      }
      synchronized (_attributesLock) {
         _spatial.setValueFromUser(value);
      }
      return this;
   }


   public void sendUpdate() throws HlaNotConnectedException, HlaAttributeNotOwnedException, HlaUpdaterReusedException, HlaInternalException, HlaRtiException, HlaObjectInstanceIsRemovedException, HlaSaveInProgressException, HlaRestoreInProgressException {
      try {
         sendUpdate(null, null);
      } catch (HlaInvalidLogicalTimeException e) {
         //can not happen with null logicalTime
      }
   }

   public void sendUpdate(HlaTimeStamp timestamp) throws HlaNotConnectedException, HlaAttributeNotOwnedException, HlaUpdaterReusedException, HlaInternalException, HlaRtiException, HlaObjectInstanceIsRemovedException, HlaSaveInProgressException, HlaRestoreInProgressException {
      try {
         sendUpdate(timestamp, null);
      } catch (HlaInvalidLogicalTimeException e) {
         //can not happen with null logicalTime
      }
   }

   public void sendUpdate(HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaAttributeNotOwnedException, HlaInvalidLogicalTimeException, HlaUpdaterReusedException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      sendUpdate(null, logicalTime);
   }

   public void sendUpdate(HlaTimeStamp timestamp, HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaAttributeNotOwnedException, HlaInvalidLogicalTimeException, HlaUpdaterReusedException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      if (!_instance.isLocal()) {
         throw new HlaAttributeNotOwnedException("Can not change remote object");
      }
      if (_updateSent.getAndSet(true)) {
         throw new HlaUpdaterReusedException("Update already sent");
      }

      EnumMap<HlaNETNGroundVehicleAttributes.Attribute, Object> attributeUpdates =
            new EnumMap<HlaNETNGroundVehicleAttributes.Attribute, Object>(HlaNETNGroundVehicleAttributes.Attribute.class);
      EnumSet<HlaNETNGroundVehicleAttributes.Attribute> sendAttributes = EnumSet.noneOf(HlaNETNGroundVehicleAttributes.Attribute.class);

      synchronized (_attributesLock) {
         if (_uniqueID.hasValue()) {
            attributeUpdates.put(HlaNETNGroundVehicleAttributes.Attribute.UNIQUE_ID, _uniqueID.getValue());
         }
         if (_spatial.hasValue()) {
            attributeUpdates.put(HlaNETNGroundVehicleAttributes.Attribute.SPATIAL, _spatial.getValue());
         }
      }

      _instance.applyUpdate(attributeUpdates, sendAttributes, timestamp, logicalTime);
   }
}
