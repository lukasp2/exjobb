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
import devstudio.generatedcode.HlaCommunicationNetworkStatusUpdater;
import devstudio.generatedcode.HlaCommunicationNetworkStatusListener;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.impl.utils.AttributeValue;
import devstudio.generatedcode.HlaCommunicationNetworkStatusAttributes; 

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;


/* @ThreadSafe */
final class HlaCommunicationNetworkStatusUpdaterImpl implements HlaCommunicationNetworkStatusUpdater {
   private final AtomicBoolean _updateSent = new AtomicBoolean(false);
   private final Object _attributesLock = new Object();

   /* @GuardedBy("_attributesLock") */
   private final AttributeValue<NetworkConnectivityStruct[]> _communicationConnectivity = new AttributeValue<NetworkConnectivityStruct[]>();

   private final HlaCommunicationNetworkStatusImpl _instance;


   HlaCommunicationNetworkStatusUpdaterImpl(HlaCommunicationNetworkStatusImpl instance) {
      _instance = instance;
   }

   public HlaCommunicationNetworkStatusUpdaterImpl setCommunicationConnectivity(NetworkConnectivityStruct[] value) {
      if (value == null) {
         throw new NullPointerException();
      }
      synchronized (_attributesLock) {
         _communicationConnectivity.setValueFromUser(value);
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

      EnumMap<HlaCommunicationNetworkStatusAttributes.Attribute, Object> attributeUpdates =
            new EnumMap<HlaCommunicationNetworkStatusAttributes.Attribute, Object>(HlaCommunicationNetworkStatusAttributes.Attribute.class);
      EnumSet<HlaCommunicationNetworkStatusAttributes.Attribute> sendAttributes = EnumSet.noneOf(HlaCommunicationNetworkStatusAttributes.Attribute.class);

      synchronized (_attributesLock) {
         if (_communicationConnectivity.hasValue()) {
            attributeUpdates.put(HlaCommunicationNetworkStatusAttributes.Attribute.COMMUNICATION_CONNECTIVITY, _communicationConnectivity.getValue());
         }
      }

      _instance.applyUpdate(attributeUpdates, sendAttributes, timestamp, logicalTime);
   }
}
