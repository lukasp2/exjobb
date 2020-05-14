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

import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.datatypes.ToStringBuilder;
import devstudio.generatedcode.impl.utils.AttributeValue;
import devstudio.generatedcode.impl.utils.Equals;
import devstudio.generatedcode.impl.utils.NameValueMap;
import devstudio.generatedcode.impl.utils.SetAdapter;
import devstudio.generatedcode.impl.utils.ParameterValue;

import se.pitch.ral.api.ObjectInstanceHandle;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;


/* @ThreadSafe */
final class HlaNETNGroundVehicleImpl implements HlaNETNGroundVehicle {



   public static final Set<String> HLA_ATTRIBUTE_NAMES = new SetAdapter<String>()
         .unmodifiableSet();


   private final HlaWorldImpl _hlaWorld;
   private final HlaNETNGroundVehicleManagerImpl _objectClassManager;
   private final ObjectInstanceHandle _objectInstanceHandle;
   private final boolean _isLocal;
   private final HlaFederateId _createdByFederate;

   private final Object _attributesLock = new Object();


   private final Set<HlaNETNGroundVehicleValueListener> _valueListeners = new CopyOnWriteArraySet<HlaNETNGroundVehicleValueListener>();
   private final Set<HlaNETNGroundVehicleListener> _listeners = new CopyOnWriteArraySet<HlaNETNGroundVehicleListener>();

   private volatile boolean _initializeFired = false;
   private volatile boolean _removed = false;

   HlaNETNGroundVehicleImpl(HlaWorldImpl hlaWorld, HlaNETNGroundVehicleManagerImpl objectClassManager, ObjectInstanceHandle objectInstanceHandle, boolean local, HlaFederateId producingFederate) {
      _hlaWorld = hlaWorld;
      _objectClassManager = objectClassManager;
      _objectInstanceHandle = objectInstanceHandle;
      _isLocal = local;
      _createdByFederate = producingFederate;
   }

   /*
    * HlaNETNGroundVehicle interface impl
    */

   public boolean isLocal() {
      return _isLocal;
   }

   public boolean isInitialized() {
      return true;
   }

   public boolean isWithinInterest() {
      return !_removed;
   }

   public boolean isRemoved() {
      return _removed;
   }

   public HlaFederateId getProducingFederate() {
      return _createdByFederate;
   }

   public HlaNETNGroundVehicleAttributes getHlaNETNGroundVehicleAttributes() {
      synchronized (_attributesLock) {
         return new HlaNETNGroundVehicleAttributesImpl(
         );
      }
   }

   public HlaNETNGroundVehicleUpdater getHlaNETNGroundVehicleUpdater() {
      return new HlaNETNGroundVehicleUpdaterImpl(this);
   }

   public String getHlaInstanceName() {
      return _objectInstanceHandle.getObjectInstanceName();
   }

   public byte[] getEncodedHlaObjectInstanceHandle() {
      return _objectInstanceHandle.getEncodedHandle();
   }

   public ObjectClassType getClassType() {
      return ObjectClassType.NETNGROUND_VEHICLE;
   }


   public void addHlaNETNGroundVehicleValueListener(HlaNETNGroundVehicleValueListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _valueListeners.add(listener);
   }

   public void removeHlaNETNGroundVehicleValueListener(HlaNETNGroundVehicleValueListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _valueListeners.remove(listener);
   }

   public void addHlaNETNGroundVehicleListener(HlaNETNGroundVehicleListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.add(listener);
   }

   public void removeHlaNETNGroundVehicleListener(HlaNETNGroundVehicleListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.remove(listener);
   }

   /*
    * Functions used by HlaNETNGroundVehicleManagerImpl
    */

   boolean isInitializedFired() {
      return _initializeFired;
   }

   void setInitializedFired() {
      _initializeFired = true;
   }

   ObjectInstanceHandle getObjectInstanceHandle() {
      return _objectInstanceHandle;
   }

   void setRemoved() {
      _removed = true;
      _valueListeners.clear();
      _listeners.clear();
   }


   void provideAttributeValueUpdate(Set<String> attributes, HlaTimeStamp hlaTimeStamp) {
      try {
         sendAttributes(getAttributeEnum(attributes), getHlaNETNGroundVehicleAttributes(), hlaTimeStamp, HlaLogicalTimeImpl.INVALID);
      } catch (HlaBaseException e) {
         //ignore
      } catch (HlaBaseRuntimeException e) {
         //ignore
      }
   }

   Set<String> getUnsetAttributeNames() {
      Set<String> unsetAttributes = new HashSet<String>(HLA_ATTRIBUTE_NAMES.size());
      HlaNETNGroundVehicleAttributes attributes = getHlaNETNGroundVehicleAttributes();
      return unsetAttributes;
   }

   @SuppressWarnings ({ "UnnecessaryContinue" })
   void reflectAttributeValues(NameValueMap attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      Set<HlaNETNGroundVehicleAttributes.Attribute> attributesUpdated = EnumSet.noneOf(HlaNETNGroundVehicleAttributes.Attribute.class);

      fireAttributesUpdated(attributesUpdated, timeStamp, logicalTime);
   }



   /*
    * Functions used by HlaNETNGroundVehicleUpdaterImpl
    */

   void applyUpdate(EnumMap<HlaNETNGroundVehicleAttributes.Attribute, Object> attributeMap,
                    EnumSet<HlaNETNGroundVehicleAttributes.Attribute> sendAttributes,
                    HlaTimeStamp timestamp,
                    HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaAttributeNotOwnedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaObjectInstanceIsRemovedException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      if (timestamp == null) {
         timestamp = _hlaWorld.getCurrentTime();
      }
      if (logicalTime == null) {
         logicalTime = _hlaWorld.getDefaultSendTime();
      }
      HlaNETNGroundVehicleAttributes attributes = applyUpdate(attributeMap, timestamp, logicalTime, _hlaWorld.getFederateId());
      sendAttributes.addAll(addDefaultSendAttributes(attributeMap.keySet()));
      sendAttributes(sendAttributes, attributes, timestamp, logicalTime);
   }


   /*
    * Private functions
    */

   private Set<HlaNETNGroundVehicleAttributes.Attribute> addDefaultSendAttributes(Set<HlaNETNGroundVehicleAttributes.Attribute> attributes) {
      return attributes;
   }

   private void fireAttributesUpdated(final Set<HlaNETNGroundVehicleAttributes.Attribute> attributes, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      final HlaNETNGroundVehicle instance = this;
      for (final HlaNETNGroundVehicleListener listener : _listeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               listener.attributesUpdated(instance, attributes, timeStamp, logicalTime);
            }
         });
      }
   }

   @SuppressWarnings ({ "UnnecessaryContinue" })
   private Set<HlaNETNGroundVehicleAttributes.Attribute> getAttributeEnum(Set<String> attributeNames) {
      Set<HlaNETNGroundVehicleAttributes.Attribute> ret = EnumSet.noneOf(HlaNETNGroundVehicleAttributes.Attribute.class);

      return ret;
   }

   private HlaNETNGroundVehicleAttributes applyUpdate(EnumMap<HlaNETNGroundVehicleAttributes.Attribute, Object> attributeUpdates, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      HlaNETNGroundVehicleAttributes ret;

      synchronized (_attributesLock) {
         for (Map.Entry<HlaNETNGroundVehicleAttributes.Attribute, Object> attributeUpdate : attributeUpdates.entrySet()) {
            switch (attributeUpdate.getKey()) {
            }
         }
         ret = getHlaNETNGroundVehicleAttributes();
      }

      if (!attributeUpdates.isEmpty()) {
         fireAttributesUpdated(attributeUpdates.keySet(), timeStamp, logicalTime);
      }

      return ret;
   }

   private void sendAttributes(Set<HlaNETNGroundVehicleAttributes.Attribute> attributes, HlaNETNGroundVehicleAttributes attributeValues, HlaTimeStamp timestamp, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaAttributeNotOwnedException, HlaInternalException, HlaRtiException, HlaObjectInstanceIsRemovedException, HlaInvalidLogicalTimeException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      NameValueMap attributeValueMap = new NameValueMap();

      synchronized (_objectClassManager._encodersLock) {
         for (HlaNETNGroundVehicleAttributes.Attribute attribute : attributes) {
            switch (attribute) {
            }
         }
      }

      if (!attributeValueMap.isEmpty()) {
         _objectClassManager.updateAttributeValues(this, _objectInstanceHandle, attributeValueMap, timestamp, logicalTime);
      }
   }
}
