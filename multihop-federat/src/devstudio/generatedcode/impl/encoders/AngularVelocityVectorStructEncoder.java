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

import devstudio.generatedcode.datatypes.AngularVelocityVectorStruct;
import se.pitch.encoders1516.HLAfloat32BE;

public final class AngularVelocityVectorStructEncoder extends AbstractFixedRecordEncoder<AngularVelocityVectorStruct> {


   public AngularVelocityVectorStructEncoder() {
      super(AngularVelocityVectorStructEncoder.class);

      _encoder.add(BaseEncoder.createHLAfloat32BE());
      _encoder.add(BaseEncoder.createHLAfloat32BE());
      _encoder.add(BaseEncoder.createHLAfloat32BE());
   }

   public AngularVelocityVectorStructEncoder(AngularVelocityVectorStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(AngularVelocityVectorStruct value) {
      ((HLAfloat32BE)_encoder.get(0)).setValue(value.getXAngularVelocity());
      ((HLAfloat32BE)_encoder.get(1)).setValue(value.getYAngularVelocity());
      ((HLAfloat32BE)_encoder.get(2)).setValue(value.getZAngularVelocity());
   }

   protected AngularVelocityVectorStruct decodeValue() {
      return AngularVelocityVectorStruct.create(
         ((HLAfloat32BE)_encoder.get(0)).getValue(),
         ((HLAfloat32BE)_encoder.get(1)).getValue(),
         ((HLAfloat32BE)_encoder.get(2)).getValue()
      );
   }
}
