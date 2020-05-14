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

import devstudio.generatedcode.datatypes.SpatialFPStruct;
import se.pitch.encoders1516.OMT13boolean;

public final class SpatialFPStructEncoder extends AbstractFixedRecordEncoder<SpatialFPStruct> {


   public SpatialFPStructEncoder() {
      super(SpatialFPStructEncoder.class);

      _encoder.add(new WorldLocationStructEncoder());
      _encoder.add(BaseEncoder.createOMT13boolean());
      _encoder.add(new OrientationStructEncoder());
      _encoder.add(new VelocityVectorStructEncoder());
   }

   public SpatialFPStructEncoder(SpatialFPStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(SpatialFPStruct value) {
      ((WorldLocationStructEncoder)_encoder.get(0)).setValue(value.getWorldLocation());
      ((OMT13boolean)_encoder.get(1)).setValue(value.getIsFrozen());
      ((OrientationStructEncoder)_encoder.get(2)).setValue(value.getOrientation());
      ((VelocityVectorStructEncoder)_encoder.get(3)).setValue(value.getVelocityVector());
   }

   protected SpatialFPStruct decodeValue() {
      return SpatialFPStruct.create(
         ((WorldLocationStructEncoder)_encoder.get(0)).getValue(),
         ((OMT13boolean)_encoder.get(1)).getValue(),
         ((OrientationStructEncoder)_encoder.get(2)).getValue(),
         ((VelocityVectorStructEncoder)_encoder.get(3)).getValue()
      );
   }
}
