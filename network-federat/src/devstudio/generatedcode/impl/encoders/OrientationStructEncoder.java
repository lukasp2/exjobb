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

import devstudio.generatedcode.datatypes.OrientationStruct;
import se.pitch.encoders1516.HLAfloat32BE;

public final class OrientationStructEncoder extends AbstractFixedRecordEncoder<OrientationStruct> {


   public OrientationStructEncoder() {
      super(OrientationStructEncoder.class);

      _encoder.add(BaseEncoder.createHLAfloat32BE());
      _encoder.add(BaseEncoder.createHLAfloat32BE());
      _encoder.add(BaseEncoder.createHLAfloat32BE());
   }

   public OrientationStructEncoder(OrientationStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(OrientationStruct value) {
      ((HLAfloat32BE)_encoder.get(0)).setValue(value.getPsi());
      ((HLAfloat32BE)_encoder.get(1)).setValue(value.getTheta());
      ((HLAfloat32BE)_encoder.get(2)).setValue(value.getPhi());
   }

   protected OrientationStruct decodeValue() {
      return OrientationStruct.create(
         ((HLAfloat32BE)_encoder.get(0)).getValue(),
         ((HLAfloat32BE)_encoder.get(1)).getValue(),
         ((HLAfloat32BE)_encoder.get(2)).getValue()
      );
   }
}
