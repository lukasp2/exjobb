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

import devstudio.generatedcode.datatypes.WorldLocationStruct;
import se.pitch.encoders1516.HLAfloat64BE;

public final class WorldLocationStructEncoder extends AbstractFixedRecordEncoder<WorldLocationStruct> {


   public WorldLocationStructEncoder() {
      super(WorldLocationStructEncoder.class);

      _encoder.add(BaseEncoder.createHLAfloat64BE());
      _encoder.add(BaseEncoder.createHLAfloat64BE());
      _encoder.add(BaseEncoder.createHLAfloat64BE());
   }

   public WorldLocationStructEncoder(WorldLocationStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(WorldLocationStruct value) {
      ((HLAfloat64BE)_encoder.get(0)).setValue(value.getX());
      ((HLAfloat64BE)_encoder.get(1)).setValue(value.getY());
      ((HLAfloat64BE)_encoder.get(2)).setValue(value.getZ());
   }

   protected WorldLocationStruct decodeValue() {
      return WorldLocationStruct.create(
         ((HLAfloat64BE)_encoder.get(0)).getValue(),
         ((HLAfloat64BE)_encoder.get(1)).getValue(),
         ((HLAfloat64BE)_encoder.get(2)).getValue()
      );
   }
}
