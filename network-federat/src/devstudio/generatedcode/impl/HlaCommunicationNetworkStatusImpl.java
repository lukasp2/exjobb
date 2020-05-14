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

import devstudio.generatedcode.datatypes.NetworkConnectivityStruct;
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
final class HlaCommunicationNetworkStatusImpl implements HlaCommunicationNetworkStatus {


   private static final String COMMUNICATION_NETWORK_ID_ATTRIBUTE_NAME = "CommunicationNetworkId";
   private static final String COMMUNICATION_CONNECTIVITY_ATTRIBUTE_NAME = "CommunicationConnectivity";

   public static final Set<String> HLA_ATTRIBUTE_NAMES = new SetAdapter<String>()
         .append(COMMUNICATION_NETWORK_ID_ATTRIBUTE_NAME)
         .append(COMMUNICATION_CONNECTIVITY_ATTRIBUTE_NAME)
         .unmodifiableSet();


   private final HlaWorldImpl _hlaWorld;
   private final HlaCommunicationNetworkStatusManagerImpl _objectClassManager;
   private final ObjectInstanceHandle _objectInstanceHandle;
   private final boolean _isLocal;
   private final HlaFederateId _createdByFederate;

   private final Object _attributesLock = new Object();

   /* @GuardedBy("_attributesLock") */
   private final AttributeValue<byte[/* 16 */]> _communicationNetworkIdAttribute = new AttributeValue<byte[/* 16 */]>();
   /* @GuardedBy("_attributesLock") */
   private final AttributeValue<NetworkConnectivityStruct[]> _communicationConnectivityAttribute = new AttributeValue<NetworkConnectivityStruct[]>();

   private final Set<HlaCommunicationNetworkStatusValueListener> _valueListeners = new CopyOnWriteArraySet<HlaCommunicationNetworkStatusValueListener>();
   private final Set<HlaCommunicationNetworkStatusListener> _listeners = new CopyOnWriteArraySet<HlaCommunicationNetworkStatusListener>();

   private volatile boolean _initializeFired = false;
   private volatile boolean _removed = false;

   HlaCommunicationNetworkStatusImpl(HlaWorldImpl hlaWorld, HlaCommunicationNetworkStatusManagerImpl objectClassManager, ObjectInstanceHandle objectInstanceHandle, boolean local, HlaFederateId producingFederate) {
      _hlaWorld = hlaWorld;
      _objectClassManager = objectClassManager;
      _objectInstanceHandle = objectInstanceHandle;
      _isLocal = local;
      _createdByFederate = producingFederate;
   }

   /*
    * HlaCommunicationNetworkStatus interface impl
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

   public boolean hasCommunicationNetworkId() {
      synchronized (_attributesLock) {
         updateCommunicationNetworkId();
         return _communicationNetworkIdAttribute.hasValue();
      }
   }

   public byte[/* 16 */] getCommunicationNetworkId() throws HlaValueNotSetException {
      synchronized (_attributesLock) {
         updateCommunicationNetworkId();
         if (_communicationNetworkIdAttribute.hasValue()) {
            return _communicationNetworkIdAttribute.getValueForUser();
         }
      }
      throw new HlaValueNotSetException("Attribute 'communicationNetworkId' not set for instance " + _objectInstanceHandle.getObjectInstanceName());
   }

   public byte[/* 16 */] getCommunicationNetworkId(byte[/* 16 */] defaultValue) {
      synchronized (_attributesLock) {
         updateCommunicationNetworkId();
         if (_communicationNetworkIdAttribute.hasValue()) {
            return _communicationNetworkIdAttribute.getValueForUser();
         }
      }
      return defaultValue;
   }

   public HlaTimeStamped<byte[/* 16 */]> getCommunicationNetworkIdTimeStamped() throws HlaValueNotSetException {
      synchronized (_attributesLock) {
         updateCommunicationNetworkId();
         if (_communicationNetworkIdAttribute.hasValue()) {
            return _communicationNetworkIdAttribute.getTimestampedValueForUser();
         }
      }
      throw new HlaValueNotSetException("Attribute 'communicationNetworkId' not set for instance " + _objectInstanceHandle.getObjectInstanceName());
   }

   /* @GuardedBy("_attributesLock") */
   private void updateCommunicationNetworkId() {
      byte[] encodedValue = _communicationNetworkIdAttribute.getEncodedValue();
      if (encodedValue != null) {
         try {
            synchronized (_objectClassManager._decodersLock) {
               _objectClassManager._uuidArrayOfHLAbyte16EncoderDecoder.decode(encodedValue);
               _communicationNetworkIdAttribute.setDecodedValue(_objectClassManager._uuidArrayOfHLAbyte16EncoderDecoder.getValue());

               if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _objectClassManager._uuidArrayOfHLAbyte16EncoderDecoder.getEncodedLength() != encodedValue.length) {
                  _hlaWorld.postException(
                     new HlaDecodeException("Failed to decode " + COMMUNICATION_NETWORK_ID_ATTRIBUTE_NAME + ". " +
                                                  "Invalid data length " + encodedValue.length + ", expected " + _objectClassManager._uuidArrayOfHLAbyte16EncoderDecoder.getEncodedLength(),
                                                  encodedValue));
               }
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode " + COMMUNICATION_NETWORK_ID_ATTRIBUTE_NAME, encodedValue, t));
            _communicationNetworkIdAttribute.clearEncodedValue();
         }
      }
   }

   public boolean hasCommunicationConnectivity() {
      synchronized (_attributesLock) {
         updateCommunicationConnectivity();
         return _communicationConnectivityAttribute.hasValue();
      }
   }

   public NetworkConnectivityStruct[] getCommunicationConnectivity() throws HlaValueNotSetException {
      synchronized (_attributesLock) {
         updateCommunicationConnectivity();
         if (_communicationConnectivityAttribute.hasValue()) {
            return _communicationConnectivityAttribute.getValueForUser();
         }
      }
      throw new HlaValueNotSetException("Attribute 'communicationConnectivity' not set for instance " + _objectInstanceHandle.getObjectInstanceName());
   }

   public NetworkConnectivityStruct[] getCommunicationConnectivity(NetworkConnectivityStruct[] defaultValue) {
      synchronized (_attributesLock) {
         updateCommunicationConnectivity();
         if (_communicationConnectivityAttribute.hasValue()) {
            return _communicationConnectivityAttribute.getValueForUser();
         }
      }
      return defaultValue;
   }

   public HlaTimeStamped<NetworkConnectivityStruct[]> getCommunicationConnectivityTimeStamped() throws HlaValueNotSetException {
      synchronized (_attributesLock) {
         updateCommunicationConnectivity();
         if (_communicationConnectivityAttribute.hasValue()) {
            return _communicationConnectivityAttribute.getTimestampedValueForUser();
         }
      }
      throw new HlaValueNotSetException("Attribute 'communicationConnectivity' not set for instance " + _objectInstanceHandle.getObjectInstanceName());
   }

   /* @GuardedBy("_attributesLock") */
   private void updateCommunicationConnectivity() {
      byte[] encodedValue = _communicationConnectivityAttribute.getEncodedValue();
      if (encodedValue != null) {
         try {
            synchronized (_objectClassManager._decodersLock) {
               _objectClassManager._networkConnectivityStructArrayEncoderDecoder.decode(encodedValue);
               _communicationConnectivityAttribute.setDecodedValue(_objectClassManager._networkConnectivityStructArrayEncoderDecoder.getValue());

               if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _objectClassManager._networkConnectivityStructArrayEncoderDecoder.getEncodedLength() != encodedValue.length) {
                  _hlaWorld.postException(
                     new HlaDecodeException("Failed to decode " + COMMUNICATION_CONNECTIVITY_ATTRIBUTE_NAME + ". " +
                                                  "Invalid data length " + encodedValue.length + ", expected " + _objectClassManager._networkConnectivityStructArrayEncoderDecoder.getEncodedLength(),
                                                  encodedValue));
               }
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode " + COMMUNICATION_CONNECTIVITY_ATTRIBUTE_NAME, encodedValue, t));
            _communicationConnectivityAttribute.clearEncodedValue();
         }
      }
   }

   public HlaFederateId getProducingFederate() {
      return _createdByFederate;
   }

   public HlaFederateId getLastProducingFederate(HlaCommunicationNetworkStatusAttributes.Attribute attribute) {
      synchronized (_attributesLock) {
         switch (attribute) {
            case COMMUNICATION_NETWORK_ID:
               if (_communicationNetworkIdAttribute.hasLastProducingFederate()) {
                  return _communicationNetworkIdAttribute.getLastProducingFederate();
               }
            case COMMUNICATION_CONNECTIVITY:
               if (_communicationConnectivityAttribute.hasLastProducingFederate()) {
                  return _communicationConnectivityAttribute.getLastProducingFederate();
               }
         }
      }
      return new HlaFederateIdImpl(null);
   }

   public HlaCommunicationNetworkStatusAttributes getHlaCommunicationNetworkStatusAttributes() {
      synchronized (_attributesLock) {
         updateCommunicationNetworkId();
         updateCommunicationConnectivity();
         return new HlaCommunicationNetworkStatusAttributesImpl(
            _communicationNetworkIdAttribute,
            _communicationConnectivityAttribute
         );
      }
   }

   public HlaCommunicationNetworkStatusUpdater getHlaCommunicationNetworkStatusUpdater() {
      return new HlaCommunicationNetworkStatusUpdaterImpl(this);
   }

   public String getHlaInstanceName() {
      return _objectInstanceHandle.getObjectInstanceName();
   }

   public byte[] getEncodedHlaObjectInstanceHandle() {
      return _objectInstanceHandle.getEncodedHandle();
   }

   public ObjectClassType getClassType() {
      return ObjectClassType.COMMUNICATION_NETWORK_STATUS;
   }


   public void addHlaCommunicationNetworkStatusValueListener(HlaCommunicationNetworkStatusValueListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _valueListeners.add(listener);
   }

   public void removeHlaCommunicationNetworkStatusValueListener(HlaCommunicationNetworkStatusValueListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _valueListeners.remove(listener);
   }

   public void addHlaCommunicationNetworkStatusListener(HlaCommunicationNetworkStatusListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.add(listener);
   }

   public void removeHlaCommunicationNetworkStatusListener(HlaCommunicationNetworkStatusListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.remove(listener);
   }

   /*
    * Functions used by HlaCommunicationNetworkStatusManagerImpl
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
         sendAttributes(getAttributeEnum(attributes), getHlaCommunicationNetworkStatusAttributes(), hlaTimeStamp, HlaLogicalTimeImpl.INVALID);
      } catch (HlaBaseException e) {
         //ignore
      } catch (HlaBaseRuntimeException e) {
         //ignore
      }
   }

   Set<String> getUnsetAttributeNames() {
      Set<String> unsetAttributes = new HashSet<String>(HLA_ATTRIBUTE_NAMES.size());
      HlaCommunicationNetworkStatusAttributes attributes = getHlaCommunicationNetworkStatusAttributes();
      if (!attributes.hasCommunicationNetworkId()) {
         unsetAttributes.add(COMMUNICATION_NETWORK_ID_ATTRIBUTE_NAME);
      }
      if (!attributes.hasCommunicationConnectivity()) {
         unsetAttributes.add(COMMUNICATION_CONNECTIVITY_ATTRIBUTE_NAME);
      }
      return unsetAttributes;
   }

   @SuppressWarnings ({ "UnnecessaryContinue" })
   void reflectAttributeValues(NameValueMap attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      Set<HlaCommunicationNetworkStatusAttributes.Attribute> attributesUpdated = EnumSet.noneOf(HlaCommunicationNetworkStatusAttributes.Attribute.class);

      synchronized (_attributesLock) {
         for (Map.Entry<String, byte[]> newAttribute : attributes.entrySet()) {
            String attributeName = newAttribute.getKey();
            byte[] attributeValue = newAttribute.getValue();

            HlaCommunicationNetworkStatusAttributes.Attribute attribute = HlaCommunicationNetworkStatusAttributes.Attribute.find(attributeName);
            if (attribute == null) {
               continue;
            }

            switch (attribute) {
               case COMMUNICATION_NETWORK_ID: {
                  attributesUpdated.add(HlaCommunicationNetworkStatusAttributes.Attribute.COMMUNICATION_NETWORK_ID);

                  if (_valueListeners.isEmpty()) {
                     _communicationNetworkIdAttribute.setEncodedValue(attributeValue, timeStamp, logicalTime, producingFederate);
                  } else {
                     updateCommunicationNetworkId();
                     AttributeValue<byte[/* 16 */]> oldValue = new AttributeValue<byte[/* 16 */]>(_communicationNetworkIdAttribute);

                     _communicationNetworkIdAttribute.setEncodedValue(attributeValue, timeStamp, logicalTime, producingFederate);

                     updateCommunicationNetworkId();
                     if (_communicationNetworkIdAttribute.hasValue()) {
                        fireCommunicationNetworkIdUpdated(_communicationNetworkIdAttribute.getValue(), oldValue, timeStamp, logicalTime);
                     }
                     fireProducingFederateUpdatedIfChanged(Attribute.COMMUNICATION_NETWORK_ID, oldValue.getLastProducingFederate(), producingFederate, timeStamp, logicalTime);
                  }
                  break;
               }
               case COMMUNICATION_CONNECTIVITY: {
                  attributesUpdated.add(HlaCommunicationNetworkStatusAttributes.Attribute.COMMUNICATION_CONNECTIVITY);

                  if (_valueListeners.isEmpty()) {
                     _communicationConnectivityAttribute.setEncodedValue(attributeValue, timeStamp, logicalTime, producingFederate);
                  } else {
                     updateCommunicationConnectivity();
                     AttributeValue<NetworkConnectivityStruct[]> oldValue = new AttributeValue<NetworkConnectivityStruct[]>(_communicationConnectivityAttribute);

                     _communicationConnectivityAttribute.setEncodedValue(attributeValue, timeStamp, logicalTime, producingFederate);

                     updateCommunicationConnectivity();
                     if (_communicationConnectivityAttribute.hasValue()) {
                        fireCommunicationConnectivityUpdated(_communicationConnectivityAttribute.getValue(), oldValue, timeStamp, logicalTime);
                     }
                     fireProducingFederateUpdatedIfChanged(Attribute.COMMUNICATION_CONNECTIVITY, oldValue.getLastProducingFederate(), producingFederate, timeStamp, logicalTime);
                  }
                  break;
               }
            }
         }
      }

      fireAttributesUpdated(attributesUpdated, timeStamp, logicalTime);
   }



   /*
    * Functions used by HlaCommunicationNetworkStatusUpdaterImpl
    */

   void applyUpdate(EnumMap<HlaCommunicationNetworkStatusAttributes.Attribute, Object> attributeMap,
                    EnumSet<HlaCommunicationNetworkStatusAttributes.Attribute> sendAttributes,
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
      HlaCommunicationNetworkStatusAttributes attributes = applyUpdate(attributeMap, timestamp, logicalTime, _hlaWorld.getFederateId());
      sendAttributes.addAll(addDefaultSendAttributes(attributeMap.keySet()));
      sendAttributes(sendAttributes, attributes, timestamp, logicalTime);
   }


   /*
    * Private functions
    */

   private Set<HlaCommunicationNetworkStatusAttributes.Attribute> addDefaultSendAttributes(Set<HlaCommunicationNetworkStatusAttributes.Attribute> attributes) {
      return attributes;
   }

   private void fireCommunicationNetworkIdUpdated(final byte[/* 16 */] value, AttributeValue<byte[/* 16 */]> previous, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      final HlaCommunicationNetworkStatus instance = this;
      final boolean oldValid = previous.hasValue();
      final byte[/* 16 */] oldValue = oldValid ? previous.getValue() : value;

      for (final HlaCommunicationNetworkStatusValueListener valueListener : _valueListeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               valueListener.communicationNetworkIdUpdated(instance, value, oldValid, oldValue, timeStamp, logicalTime);
            }
         });
      }
   }

   private void fireCommunicationConnectivityUpdated(final NetworkConnectivityStruct[] value, AttributeValue<NetworkConnectivityStruct[]> previous, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      final HlaCommunicationNetworkStatus instance = this;
      final boolean oldValid = previous.hasValue();
      final NetworkConnectivityStruct[] oldValue = oldValid ? previous.getValue() : value;

      for (final HlaCommunicationNetworkStatusValueListener valueListener : _valueListeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               valueListener.communicationConnectivityUpdated(instance, value, oldValid, oldValue, timeStamp, logicalTime);
            }
         });
      }
   }

   private void fireAttributesUpdated(final Set<HlaCommunicationNetworkStatusAttributes.Attribute> attributes, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      final HlaCommunicationNetworkStatus instance = this;
      for (final HlaCommunicationNetworkStatusListener listener : _listeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               listener.attributesUpdated(instance, attributes, timeStamp, logicalTime);
            }
         });
      }
   }

   private void fireProducingFederateUpdatedIfChanged(final HlaCommunicationNetworkStatusAttributes.Attribute attribute, final HlaFederateId oldProducingFederate, final HlaFederateId newProducingFederate, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      if (Equals.isEquals(oldProducingFederate, newProducingFederate)) {
         return;
      }

      final HlaCommunicationNetworkStatus instance = this;
      for (final HlaCommunicationNetworkStatusValueListener valueListener : _valueListeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               valueListener.producingFederateUpdated(instance, attribute, oldProducingFederate, newProducingFederate, timeStamp, logicalTime);
            }
         });
      }
   }

   @SuppressWarnings ({ "UnnecessaryContinue" })
   private Set<HlaCommunicationNetworkStatusAttributes.Attribute> getAttributeEnum(Set<String> attributeNames) {
      Set<HlaCommunicationNetworkStatusAttributes.Attribute> ret = EnumSet.noneOf(HlaCommunicationNetworkStatusAttributes.Attribute.class);

      for (String attributeName : attributeNames) {
         HlaCommunicationNetworkStatusAttributes.Attribute attribute = HlaCommunicationNetworkStatusAttributes.Attribute.find(attributeName);
         if (attribute != null) {
            ret.add(attribute);
         }
      }
      return ret;
   }

   private HlaCommunicationNetworkStatusAttributes applyUpdate(EnumMap<HlaCommunicationNetworkStatusAttributes.Attribute, Object> attributeUpdates, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      HlaCommunicationNetworkStatusAttributes ret;

      synchronized (_attributesLock) {
         for (Map.Entry<HlaCommunicationNetworkStatusAttributes.Attribute, Object> attributeUpdate : attributeUpdates.entrySet()) {
            switch (attributeUpdate.getKey()) {
               case COMMUNICATION_NETWORK_ID: {
                  updateCommunicationNetworkId();
                  AttributeValue<byte[/* 16 */]> oldValue = new AttributeValue<byte[/* 16 */]>(_communicationNetworkIdAttribute);

                  byte[/* 16 */] value = (byte[/* 16 */])attributeUpdate.getValue();
                  _communicationNetworkIdAttribute.setValue(value, timeStamp, logicalTime, producingFederate);

                  fireCommunicationNetworkIdUpdated(value, oldValue, timeStamp, logicalTime);
                  fireProducingFederateUpdatedIfChanged(Attribute.COMMUNICATION_NETWORK_ID, oldValue.getLastProducingFederate(), producingFederate, timeStamp, logicalTime);
                  break;
               }
               case COMMUNICATION_CONNECTIVITY: {
                  updateCommunicationConnectivity();
                  AttributeValue<NetworkConnectivityStruct[]> oldValue = new AttributeValue<NetworkConnectivityStruct[]>(_communicationConnectivityAttribute);

                  NetworkConnectivityStruct[] value = (NetworkConnectivityStruct[])attributeUpdate.getValue();
                  _communicationConnectivityAttribute.setValue(value, timeStamp, logicalTime, producingFederate);

                  fireCommunicationConnectivityUpdated(value, oldValue, timeStamp, logicalTime);
                  fireProducingFederateUpdatedIfChanged(Attribute.COMMUNICATION_CONNECTIVITY, oldValue.getLastProducingFederate(), producingFederate, timeStamp, logicalTime);
                  break;
               }
            }
         }
         ret = getHlaCommunicationNetworkStatusAttributes();
      }

      if (!attributeUpdates.isEmpty()) {
         fireAttributesUpdated(attributeUpdates.keySet(), timeStamp, logicalTime);
      }

      return ret;
   }

   private void sendAttributes(Set<HlaCommunicationNetworkStatusAttributes.Attribute> attributes, HlaCommunicationNetworkStatusAttributes attributeValues, HlaTimeStamp timestamp, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaAttributeNotOwnedException, HlaInternalException, HlaRtiException, HlaObjectInstanceIsRemovedException, HlaInvalidLogicalTimeException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      NameValueMap attributeValueMap = new NameValueMap();

      synchronized (_objectClassManager._encodersLock) {
         for (HlaCommunicationNetworkStatusAttributes.Attribute attribute : attributes) {
            switch (attribute) {
               case COMMUNICATION_NETWORK_ID:
                  if (attributeValues.hasCommunicationNetworkId()) {
                     try {
                        _objectClassManager._uuidArrayOfHLAbyte16EncoderEncoder.setValue(attributeValues.getCommunicationNetworkId());
                        attributeValueMap.put(COMMUNICATION_NETWORK_ID_ATTRIBUTE_NAME, _objectClassManager._uuidArrayOfHLAbyte16EncoderEncoder.toByteArray(), false);
                     } catch (Throwable t) {
                        _hlaWorld.postException(new HlaDecodeException("Failed to encode " + COMMUNICATION_NETWORK_ID_ATTRIBUTE_NAME, t));
                     }
                  }
                  break;
               case COMMUNICATION_CONNECTIVITY:
                  if (attributeValues.hasCommunicationConnectivity()) {
                     try {
                        _objectClassManager._networkConnectivityStructArrayEncoderEncoder.setValue(attributeValues.getCommunicationConnectivity());
                        attributeValueMap.put(COMMUNICATION_CONNECTIVITY_ATTRIBUTE_NAME, _objectClassManager._networkConnectivityStructArrayEncoderEncoder.toByteArray(), false);
                     } catch (Throwable t) {
                        _hlaWorld.postException(new HlaDecodeException("Failed to encode " + COMMUNICATION_CONNECTIVITY_ATTRIBUTE_NAME, t));
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
