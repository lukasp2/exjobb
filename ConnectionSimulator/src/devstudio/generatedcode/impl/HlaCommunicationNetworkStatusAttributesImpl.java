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

   private final AttributeValue<NetworkConnectivityStruct[]> _communicationConnectivity;

   HlaCommunicationNetworkStatusAttributesImpl(
      AttributeValue<NetworkConnectivityStruct[]> communicationConnectivity
   ) {
      _communicationConnectivity = new AttributeValue<NetworkConnectivityStruct[]>(communicationConnectivity);
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
