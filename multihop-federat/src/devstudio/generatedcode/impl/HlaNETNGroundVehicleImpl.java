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


   private static final String UNIQUE_ID_ATTRIBUTE_NAME = "UniqueID";
   private static final String SPATIAL_ATTRIBUTE_NAME = "Spatial";

   public static final Set<String> HLA_ATTRIBUTE_NAMES = new SetAdapter<String>()
         .append(UNIQUE_ID_ATTRIBUTE_NAME)
         .append(SPATIAL_ATTRIBUTE_NAME)
         .unmodifiableSet();


   private final HlaWorldImpl _hlaWorld;
   private final HlaNETNGroundVehicleManagerImpl _objectClassManager;
   private final ObjectInstanceHandle _objectInstanceHandle;
   private final boolean _isLocal;
   private final HlaFederateId _createdByFederate;

   private final Object _attributesLock = new Object();

   /* @GuardedBy("_attributesLock") */
   private final AttributeValue<byte[/* 16 */]> _uniqueIDAttribute = new AttributeValue<byte[/* 16 */]>();
   /* @GuardedBy("_attributesLock") */
   private final AttributeValue<SpatialVariantStruct> _spatialAttribute = new AttributeValue<SpatialVariantStruct>();

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

   public boolean hasUniqueID() {
      synchronized (_attributesLock) {
         updateUniqueID();
         return _uniqueIDAttribute.hasValue();
      }
   }

   public byte[/* 16 */] getUniqueID() throws HlaValueNotSetException {
      synchronized (_attributesLock) {
         updateUniqueID();
         if (_uniqueIDAttribute.hasValue()) {
            return _uniqueIDAttribute.getValueForUser();
         }
      }
      throw new HlaValueNotSetException("Attribute 'uniqueID' not set for instance " + _objectInstanceHandle.getObjectInstanceName());
   }

   public byte[/* 16 */] getUniqueID(byte[/* 16 */] defaultValue) {
      synchronized (_attributesLock) {
         updateUniqueID();
         if (_uniqueIDAttribute.hasValue()) {
            return _uniqueIDAttribute.getValueForUser();
         }
      }
      return defaultValue;
   }

   public HlaTimeStamped<byte[/* 16 */]> getUniqueIDTimeStamped() throws HlaValueNotSetException {
      synchronized (_attributesLock) {
         updateUniqueID();
         if (_uniqueIDAttribute.hasValue()) {
            return _uniqueIDAttribute.getTimestampedValueForUser();
         }
      }
      throw new HlaValueNotSetException("Attribute 'uniqueID' not set for instance " + _objectInstanceHandle.getObjectInstanceName());
   }

   /* @GuardedBy("_attributesLock") */
   private void updateUniqueID() {
      byte[] encodedValue = _uniqueIDAttribute.getEncodedValue();
      if (encodedValue != null) {
         try {
            synchronized (_objectClassManager._decodersLock) {
               _objectClassManager._uuidArrayOfHLAbyte16EncoderDecoder.decode(encodedValue);
               _uniqueIDAttribute.setDecodedValue(_objectClassManager._uuidArrayOfHLAbyte16EncoderDecoder.getValue());

               if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _objectClassManager._uuidArrayOfHLAbyte16EncoderDecoder.getEncodedLength() != encodedValue.length) {
                  _hlaWorld.postException(
                     new HlaDecodeException("Failed to decode " + UNIQUE_ID_ATTRIBUTE_NAME + ". " +
                                                  "Invalid data length " + encodedValue.length + ", expected " + _objectClassManager._uuidArrayOfHLAbyte16EncoderDecoder.getEncodedLength(),
                                                  encodedValue));
               }
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode " + UNIQUE_ID_ATTRIBUTE_NAME, encodedValue, t));
            _uniqueIDAttribute.clearEncodedValue();
         }
      }
   }

   public boolean hasSpatial() {
      synchronized (_attributesLock) {
         updateSpatial();
         return _spatialAttribute.hasValue();
      }
   }

   public SpatialVariantStruct getSpatial() throws HlaValueNotSetException {
      synchronized (_attributesLock) {
         updateSpatial();
         if (_spatialAttribute.hasValue()) {
            return _spatialAttribute.getValueForUser();
         }
      }
      throw new HlaValueNotSetException("Attribute 'spatial' not set for instance " + _objectInstanceHandle.getObjectInstanceName());
   }

   public SpatialVariantStruct getSpatial(SpatialVariantStruct defaultValue) {
      synchronized (_attributesLock) {
         updateSpatial();
         if (_spatialAttribute.hasValue()) {
            return _spatialAttribute.getValueForUser();
         }
      }
      return defaultValue;
   }

   public HlaTimeStamped<SpatialVariantStruct> getSpatialTimeStamped() throws HlaValueNotSetException {
      synchronized (_attributesLock) {
         updateSpatial();
         if (_spatialAttribute.hasValue()) {
            return _spatialAttribute.getTimestampedValueForUser();
         }
      }
      throw new HlaValueNotSetException("Attribute 'spatial' not set for instance " + _objectInstanceHandle.getObjectInstanceName());
   }

   /* @GuardedBy("_attributesLock") */
   private void updateSpatial() {
      byte[] encodedValue = _spatialAttribute.getEncodedValue();
      if (encodedValue != null) {
         try {
            synchronized (_objectClassManager._decodersLock) {
               _objectClassManager._spatialVariantStructEncoderDecoder.decode(encodedValue);
               _spatialAttribute.setDecodedValue(_objectClassManager._spatialVariantStructEncoderDecoder.getValue());

               if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _objectClassManager._spatialVariantStructEncoderDecoder.getEncodedLength() != encodedValue.length) {
                  _hlaWorld.postException(
                     new HlaDecodeException("Failed to decode " + SPATIAL_ATTRIBUTE_NAME + ". " +
                                                  "Invalid data length " + encodedValue.length + ", expected " + _objectClassManager._spatialVariantStructEncoderDecoder.getEncodedLength(),
                                                  encodedValue));
               }
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode " + SPATIAL_ATTRIBUTE_NAME, encodedValue, t));
            _spatialAttribute.clearEncodedValue();
         }
      }
   }

   public HlaFederateId getProducingFederate() {
      return _createdByFederate;
   }

   public HlaFederateId getLastProducingFederate(HlaNETNGroundVehicleAttributes.Attribute attribute) {
      synchronized (_attributesLock) {
         switch (attribute) {
            case UNIQUE_ID:
               if (_uniqueIDAttribute.hasLastProducingFederate()) {
                  return _uniqueIDAttribute.getLastProducingFederate();
               }
            case SPATIAL:
               if (_spatialAttribute.hasLastProducingFederate()) {
                  return _spatialAttribute.getLastProducingFederate();
               }
         }
      }
      return new HlaFederateIdImpl(null);
   }

   public HlaNETNGroundVehicleAttributes getHlaNETNGroundVehicleAttributes() {
      synchronized (_attributesLock) {
         updateUniqueID();
         updateSpatial();
         return new HlaNETNGroundVehicleAttributesImpl(
            _uniqueIDAttribute,
            _spatialAttribute
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
      if (!attributes.hasUniqueID()) {
         unsetAttributes.add(UNIQUE_ID_ATTRIBUTE_NAME);
      }
      if (!attributes.hasSpatial()) {
         unsetAttributes.add(SPATIAL_ATTRIBUTE_NAME);
      }
      return unsetAttributes;
   }

   @SuppressWarnings ({ "UnnecessaryContinue" })
   void reflectAttributeValues(NameValueMap attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      Set<HlaNETNGroundVehicleAttributes.Attribute> attributesUpdated = EnumSet.noneOf(HlaNETNGroundVehicleAttributes.Attribute.class);

      synchronized (_attributesLock) {
         for (Map.Entry<String, byte[]> newAttribute : attributes.entrySet()) {
            String attributeName = newAttribute.getKey();
            byte[] attributeValue = newAttribute.getValue();

            HlaNETNGroundVehicleAttributes.Attribute attribute = HlaNETNGroundVehicleAttributes.Attribute.find(attributeName);
            if (attribute == null) {
               continue;
            }

            switch (attribute) {
               case UNIQUE_ID: {
                  attributesUpdated.add(HlaNETNGroundVehicleAttributes.Attribute.UNIQUE_ID);

                  if (_valueListeners.isEmpty()) {
                     _uniqueIDAttribute.setEncodedValue(attributeValue, timeStamp, logicalTime, producingFederate);
                  } else {
                     updateUniqueID();
                     AttributeValue<byte[/* 16 */]> oldValue = new AttributeValue<byte[/* 16 */]>(_uniqueIDAttribute);

                     _uniqueIDAttribute.setEncodedValue(attributeValue, timeStamp, logicalTime, producingFederate);

                     updateUniqueID();
                     if (_uniqueIDAttribute.hasValue()) {
                        fireUniqueIDUpdated(_uniqueIDAttribute.getValue(), oldValue, timeStamp, logicalTime);
                     }
                     fireProducingFederateUpdatedIfChanged(Attribute.UNIQUE_ID, oldValue.getLastProducingFederate(), producingFederate, timeStamp, logicalTime);
                  }
                  break;
               }
               case SPATIAL: {
                  attributesUpdated.add(HlaNETNGroundVehicleAttributes.Attribute.SPATIAL);

                  if (_valueListeners.isEmpty()) {
                     _spatialAttribute.setEncodedValue(attributeValue, timeStamp, logicalTime, producingFederate);
                  } else {
                     updateSpatial();
                     AttributeValue<SpatialVariantStruct> oldValue = new AttributeValue<SpatialVariantStruct>(_spatialAttribute);

                     _spatialAttribute.setEncodedValue(attributeValue, timeStamp, logicalTime, producingFederate);

                     updateSpatial();
                     if (_spatialAttribute.hasValue()) {
                        fireSpatialUpdated(_spatialAttribute.getValue(), oldValue, timeStamp, logicalTime);
                     }
                     fireProducingFederateUpdatedIfChanged(Attribute.SPATIAL, oldValue.getLastProducingFederate(), producingFederate, timeStamp, logicalTime);
                  }
                  break;
               }
            }
         }
      }

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

   private void fireUniqueIDUpdated(final byte[/* 16 */] value, AttributeValue<byte[/* 16 */]> previous, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      final HlaNETNGroundVehicle instance = this;
      final boolean oldValid = previous.hasValue();
      final byte[/* 16 */] oldValue = oldValid ? previous.getValue() : value;

      for (final HlaNETNGroundVehicleValueListener valueListener : _valueListeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               valueListener.uniqueIDUpdated(instance, value, oldValid, oldValue, timeStamp, logicalTime);
            }
         });
      }
   }

   private void fireSpatialUpdated(final SpatialVariantStruct value, AttributeValue<SpatialVariantStruct> previous, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      final HlaNETNGroundVehicle instance = this;
      final boolean oldValid = previous.hasValue();
      final SpatialVariantStruct oldValue = oldValid ? previous.getValue() : value;

      for (final HlaNETNGroundVehicleValueListener valueListener : _valueListeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               valueListener.spatialUpdated(instance, value, oldValid, oldValue, timeStamp, logicalTime);
            }
         });
      }
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

   private void fireProducingFederateUpdatedIfChanged(final HlaNETNGroundVehicleAttributes.Attribute attribute, final HlaFederateId oldProducingFederate, final HlaFederateId newProducingFederate, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      if (Equals.isEquals(oldProducingFederate, newProducingFederate)) {
         return;
      }

      final HlaNETNGroundVehicle instance = this;
      for (final HlaNETNGroundVehicleValueListener valueListener : _valueListeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               valueListener.producingFederateUpdated(instance, attribute, oldProducingFederate, newProducingFederate, timeStamp, logicalTime);
            }
         });
      }
   }

   @SuppressWarnings ({ "UnnecessaryContinue" })
   private Set<HlaNETNGroundVehicleAttributes.Attribute> getAttributeEnum(Set<String> attributeNames) {
      Set<HlaNETNGroundVehicleAttributes.Attribute> ret = EnumSet.noneOf(HlaNETNGroundVehicleAttributes.Attribute.class);

      for (String attributeName : attributeNames) {
         HlaNETNGroundVehicleAttributes.Attribute attribute = HlaNETNGroundVehicleAttributes.Attribute.find(attributeName);
         if (attribute != null) {
            ret.add(attribute);
         }
      }
      return ret;
   }

   private HlaNETNGroundVehicleAttributes applyUpdate(EnumMap<HlaNETNGroundVehicleAttributes.Attribute, Object> attributeUpdates, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      HlaNETNGroundVehicleAttributes ret;

      synchronized (_attributesLock) {
         for (Map.Entry<HlaNETNGroundVehicleAttributes.Attribute, Object> attributeUpdate : attributeUpdates.entrySet()) {
            switch (attributeUpdate.getKey()) {
               case UNIQUE_ID: {
                  updateUniqueID();
                  AttributeValue<byte[/* 16 */]> oldValue = new AttributeValue<byte[/* 16 */]>(_uniqueIDAttribute);

                  byte[/* 16 */] value = (byte[/* 16 */])attributeUpdate.getValue();
                  _uniqueIDAttribute.setValue(value, timeStamp, logicalTime, producingFederate);

                  fireUniqueIDUpdated(value, oldValue, timeStamp, logicalTime);
                  fireProducingFederateUpdatedIfChanged(Attribute.UNIQUE_ID, oldValue.getLastProducingFederate(), producingFederate, timeStamp, logicalTime);
                  break;
               }
               case SPATIAL: {
                  updateSpatial();
                  AttributeValue<SpatialVariantStruct> oldValue = new AttributeValue<SpatialVariantStruct>(_spatialAttribute);

                  SpatialVariantStruct value = (SpatialVariantStruct)attributeUpdate.getValue();
                  _spatialAttribute.setValue(value, timeStamp, logicalTime, producingFederate);

                  fireSpatialUpdated(value, oldValue, timeStamp, logicalTime);
                  fireProducingFederateUpdatedIfChanged(Attribute.SPATIAL, oldValue.getLastProducingFederate(), producingFederate, timeStamp, logicalTime);
                  break;
               }
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
               case UNIQUE_ID:
                  if (attributeValues.hasUniqueID()) {
                     try {
                        _objectClassManager._uuidArrayOfHLAbyte16EncoderEncoder.setValue(attributeValues.getUniqueID());
                        attributeValueMap.put(UNIQUE_ID_ATTRIBUTE_NAME, _objectClassManager._uuidArrayOfHLAbyte16EncoderEncoder.toByteArray(), false);
                     } catch (Throwable t) {
                        _hlaWorld.postException(new HlaDecodeException("Failed to encode " + UNIQUE_ID_ATTRIBUTE_NAME, t));
                     }
                  }
                  break;
               case SPATIAL:
                  if (attributeValues.hasSpatial()) {
                     try {
                        _objectClassManager._spatialVariantStructEncoderEncoder.setValue(attributeValues.getSpatial());
                        attributeValueMap.put(SPATIAL_ATTRIBUTE_NAME, _objectClassManager._spatialVariantStructEncoderEncoder.toByteArray(), false);
                     } catch (Throwable t) {
                        _hlaWorld.postException(new HlaDecodeException("Failed to encode " + SPATIAL_ATTRIBUTE_NAME, t));
                     }
                  }
                  break;
            }
         }
      }

      if (!attributeValueMap.isEmpty()) {
         _objectClassManager.updateAttributeValues(this, _objectInstanceHandle, attributeValueMap, timestamp, logicalTime);
      }
   }
}
