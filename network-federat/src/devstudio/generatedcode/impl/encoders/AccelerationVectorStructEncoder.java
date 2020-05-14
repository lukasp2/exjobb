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

import devstudio.generatedcode.datatypes.AccelerationVectorStruct;
import se.pitch.encoders1516.HLAfloat32BE;

public final class AccelerationVectorStructEncoder extends AbstractFixedRecordEncoder<AccelerationVectorStruct> {


   public AccelerationVectorStructEncoder() {
      super(AccelerationVectorStructEncoder.class);

      _encoder.add(BaseEncoder.createHLAfloat32BE());
      _encoder.add(BaseEncoder.createHLAfloat32BE());
      _encoder.add(BaseEncoder.createHLAfloat32BE());
   }

   public AccelerationVectorStructEncoder(AccelerationVectorStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(AccelerationVectorStruct value) {
      ((HLAfloat32BE)_encoder.get(0)).setValue(value.getXAcceleration());
      ((HLAfloat32BE)_encoder.get(1)).setValue(value.getYAcceleration());
      ((HLAfloat32BE)_encoder.get(2)).setValue(value.getZAcceleration());
   }

   protected AccelerationVectorStruct decodeValue() {
      return AccelerationVectorStruct.create(
         ((HLAfloat32BE)_encoder.get(0)).getValue(),
         ((HLAfloat32BE)_encoder.get(1)).getValue(),
         ((HLAfloat32BE)_encoder.get(2)).getValue()
      );
   }
}
