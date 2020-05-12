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

import devstudio.generatedcode.datatypes.VelocityVectorStruct;
import se.pitch.encoders1516.HLAfloat32BE;

public final class VelocityVectorStructEncoder extends AbstractFixedRecordEncoder<VelocityVectorStruct> {


   public VelocityVectorStructEncoder() {
      super(VelocityVectorStructEncoder.class);

      _encoder.add(BaseEncoder.createHLAfloat32BE());
      _encoder.add(BaseEncoder.createHLAfloat32BE());
      _encoder.add(BaseEncoder.createHLAfloat32BE());
   }

   public VelocityVectorStructEncoder(VelocityVectorStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(VelocityVectorStruct value) {
      ((HLAfloat32BE)_encoder.get(0)).setValue(value.getXVelocity());
      ((HLAfloat32BE)_encoder.get(1)).setValue(value.getYVelocity());
      ((HLAfloat32BE)_encoder.get(2)).setValue(value.getZVelocity());
   }

   protected VelocityVectorStruct decodeValue() {
      return VelocityVectorStruct.create(
         ((HLAfloat32BE)_encoder.get(0)).getValue(),
         ((HLAfloat32BE)_encoder.get(1)).getValue(),
         ((HLAfloat32BE)_encoder.get(2)).getValue()
      );
   }
}
