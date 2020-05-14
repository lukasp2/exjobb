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
import se.pitch.encoders1516.HLAfloat32BE;

public final class NetworkConnectivityStructEncoder extends AbstractFixedRecordEncoder<NetworkConnectivityStruct> {


   public NetworkConnectivityStructEncoder() {
      super(NetworkConnectivityStructEncoder.class);

      _encoder.add(new UuidArrayOfHLAbyte16Encoder());
      _encoder.add(new UuidArrayOfHLAbyte16Encoder());
      _encoder.add(BaseEncoder.createHLAfloat32BE());
   }

   public NetworkConnectivityStructEncoder(NetworkConnectivityStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(NetworkConnectivityStruct value) {
      ((UuidArrayOfHLAbyte16Encoder)_encoder.get(0)).setValue(value.getSender());
      ((UuidArrayOfHLAbyte16Encoder)_encoder.get(1)).setValue(value.getReceiver());
      ((HLAfloat32BE)_encoder.get(2)).setValue(value.getNetworkState());
   }

   protected NetworkConnectivityStruct decodeValue() {
      return NetworkConnectivityStruct.create(
         ((UuidArrayOfHLAbyte16Encoder)_encoder.get(0)).getValue(),
         ((UuidArrayOfHLAbyte16Encoder)_encoder.get(1)).getValue(),
         ((HLAfloat32BE)_encoder.get(2)).getValue()
      );
   }
}
