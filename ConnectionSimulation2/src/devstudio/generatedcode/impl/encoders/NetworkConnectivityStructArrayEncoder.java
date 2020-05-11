package devstudio.generatedcode.impl.encoders;

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
import java.util.Iterator;

public final class NetworkConnectivityStructArrayEncoder extends AbstractVariableArrayEncoder<NetworkConnectivityStruct[]> {


   public NetworkConnectivityStructArrayEncoder() {
      super(NetworkConnectivityStructArrayEncoder.class);
   }

   public NetworkConnectivityStructArrayEncoder(NetworkConnectivityStruct[] value) {
      this();
      setValue(value);
   }

   protected void encodeValue(NetworkConnectivityStruct[] values) {
      _encoder.resize(values.length);

      int i = 0;
      for (Iterator iter = _encoder.iterator(); iter.hasNext();) {
         NetworkConnectivityStructEncoder element = (NetworkConnectivityStructEncoder)iter.next();
         element.setValue(values[i++]);
      }
   }

   protected NetworkConnectivityStruct[] decodeValue() {
      NetworkConnectivityStruct[] value = new NetworkConnectivityStruct[_encoder.size()];
      int i = 0;
      for (Iterator iter = _encoder.iterator(); iter.hasNext();) {
         NetworkConnectivityStructEncoder element = (NetworkConnectivityStructEncoder)iter.next();
         value[i++] = element.getValue();
      }
      return value;
   }

   protected NetworkConnectivityStructEncoder createElement() {
      return new NetworkConnectivityStructEncoder();
   }
}
