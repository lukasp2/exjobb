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
import devstudio.generatedcode.HlaCommunicationNetworkStatusAttributes;
import devstudio.generatedcode.HlaTimeStamped;
import devstudio.generatedcode.exceptions.HlaValueNotSetException;
import devstudio.generatedcode.impl.utils.AttributeValue;

/* @Immutable */
final class HlaCommunicationNetworkStatusAttributesImpl implements HlaCommunicationNetworkStatusAttributes {

   private final AttributeValue<byte[/* 16 */]> _communicationNetworkId;
   private final AttributeValue<NetworkConnectivityStruct[]> _communicationConnectivity;

   HlaCommunicationNetworkStatusAttributesImpl(
      AttributeValue<byte[/* 16 */]> communicationNetworkId,
      AttributeValue<NetworkConnectivityStruct[]> communicationConnectivity
   ) {
      _communicationNetworkId = new AttributeValue<byte[/* 16 */]>(communicationNetworkId);
      _communicationConnectivity = new AttributeValue<NetworkConnectivityStruct[]>(communicationConnectivity);
   }

   public boolean hasCommunicationNetworkId() {
      return _communicationNetworkId.hasValue();
   }

   public byte[/* 16 */] getCommunicationNetworkId() throws HlaValueNotSetException {
      if (_communicationNetworkId.hasValue()) {
         return _communicationNetworkId.getValue();
      }
      throw new HlaValueNotSetException("Attribute 'communicationNetworkId' not set");
   }

   public byte[/* 16 */] getCommunicationNetworkId(byte[/* 16 */] defaultValue) {
      if (_communicationNetworkId.hasValue()) {
         return _communicationNetworkId.getValue();
      }
      return defaultValue;
   }

   public HlaTimeStamped<byte[/* 16 */]> getCommunicationNetworkIdTimeStamped() throws HlaValueNotSetException {
      if (_communicationNetworkId.hasValue()) {
         return _communicationNetworkId.getTimestampedValueForUser();
      }
      throw new HlaValueNotSetException("Attribute 'communicationNetworkId' not set");
   }

   public boolean hasCommunicationConnectivity() {
      return _communicationConnectivity.hasValue();
   }

   public NetworkConnectivityStruct[] getCommunicationConnectivity() throws HlaValueNotSetException {
      if (_communicationConnectivity.hasValue()) {
         return _communicationConnectivity.getValue();
      }
      throw new HlaValueNotSetException("Attribute 'communicationConnectivity' not set");
   }

   public NetworkConnectivityStruct[] getCommunicationConnectivity(NetworkConnectivityStruct[] defaultValue) {
      if (_communicationConnectivity.hasValue()) {
         return _communicationConnectivity.getValue();
      }
      return defaultValue;
   }

   public HlaTimeStamped<NetworkConnectivityStruct[]> getCommunicationConnectivityTimeStamped() throws HlaValueNotSetException {
      if (_communicationConnectivity.hasValue()) {
         return _communicationConnectivity.getTimestampedValueForUser();
      }
      throw new HlaValueNotSetException("Attribute 'communicationConnectivity' not set");
   }

}
