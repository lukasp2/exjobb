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

import devstudio.generatedcode.datatypes.SpatialRPStruct;
import se.pitch.encoders1516.OMT13boolean;

public final class SpatialRPStructEncoder extends AbstractFixedRecordEncoder<SpatialRPStruct> {


   public SpatialRPStructEncoder() {
      super(SpatialRPStructEncoder.class);

      _encoder.add(new WorldLocationStructEncoder());
      _encoder.add(BaseEncoder.createOMT13boolean());
      _encoder.add(new OrientationStructEncoder());
      _encoder.add(new VelocityVectorStructEncoder());
      _encoder.add(new AngularVelocityVectorStructEncoder());
   }

   public SpatialRPStructEncoder(SpatialRPStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(SpatialRPStruct value) {
      ((WorldLocationStructEncoder)_encoder.get(0)).setValue(value.getWorldLocation());
      ((OMT13boolean)_encoder.get(1)).setValue(value.getIsFrozen());
      ((OrientationStructEncoder)_encoder.get(2)).setValue(value.getOrientation());
      ((VelocityVectorStructEncoder)_encoder.get(3)).setValue(value.getVelocityVector());
      ((AngularVelocityVectorStructEncoder)_encoder.get(4)).setValue(value.getAngularVelocity());
   }

   protected SpatialRPStruct decodeValue() {
      return SpatialRPStruct.create(
         ((WorldLocationStructEncoder)_encoder.get(0)).getValue(),
         ((OMT13boolean)_encoder.get(1)).getValue(),
         ((OrientationStructEncoder)_encoder.get(2)).getValue(),
         ((VelocityVectorStructEncoder)_encoder.get(3)).getValue(),
         ((AngularVelocityVectorStructEncoder)_encoder.get(4)).getValue()
      );
   }
}
