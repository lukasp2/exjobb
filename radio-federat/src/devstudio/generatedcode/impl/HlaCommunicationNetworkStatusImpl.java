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
final class HlaCommunicationNetworkStatusImpl implements HlaCommunicationNetworkStatus {



   public static final Set<String> HLA_ATTRIBUTE_NAMES = new SetAdapter<String>()
         .unmodifiableSet();


   private final HlaWorldImpl _hlaWorld;
   private final HlaCommunicationNetworkStatusManagerImpl _objectClassManager;
   private final ObjectInstanceHandle _objectInstanceHandle;
   private final boolean _isLocal;
   private final HlaFederateId _createdByFederate;

   private final Object _attributesLock = new Object();


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

   public HlaFederateId getProducingFederate() {
      return _createdByFederate;
   }

   public HlaCommunicationNetworkStatusAttributes getHlaCommunicationNetworkStatusAttributes() {
      synchronized (_attributesLock) {
         return new HlaCommunicationNetworkStatusAttributesImpl(
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
      return unsetAttributes;
   }

   @SuppressWarnings ({ "UnnecessaryContinue" })
   void reflectAttributeValues(NameValueMap attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      Set<HlaCommunicationNetworkStatusAttributes.Attribute> attributesUpdated = EnumSet.noneOf(HlaCommunicationNetworkStatusAttributes.Attribute.class);

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

   @SuppressWarnings ({ "UnnecessaryContinue" })
   private Set<HlaCommunicationNetworkStatusAttributes.Attribute> getAttributeEnum(Set<String> attributeNames) {
      Set<HlaCommunicationNetworkStatusAttributes.Attribute> ret = EnumSet.noneOf(HlaCommunicationNetworkStatusAttributes.Attribute.class);

      return ret;
   }

   private HlaCommunicationNetworkStatusAttributes applyUpdate(EnumMap<HlaCommunicationNetworkStatusAttributes.Attribute, Object> attributeUpdates, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      HlaCommunicationNetworkStatusAttributes ret;

      synchronized (_attributesLock) {
         for (Map.Entry<HlaCommunicationNetworkStatusAttributes.Attribute, Object> attributeUpdate : attributeUpdates.entrySet()) {
            switch (attributeUpdate.getKey()) {
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
            }
         }
      }

      if (!attributeValueMap.isEmpty()) {
         _objectClassManager.updateAttributeValues(this, _objectInstanceHandle, attributeValueMap, timestamp, logicalTime);
      }
   }
}
