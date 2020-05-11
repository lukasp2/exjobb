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

import devstudio.generatedcode.datatypes.SpatialStaticStruct;
import se.pitch.encoders1516.OMT13boolean;

public final class SpatialStaticStructEncoder extends AbstractFixedRecordEncoder<SpatialStaticStruct> {


   public SpatialStaticStructEncoder() {
      super(SpatialStaticStructEncoder.class);

      _encoder.add(new WorldLocationStructEncoder());
      _encoder.add(BaseEncoder.createOMT13boolean());
      _encoder.add(new OrientationStructEncoder());
   }

   public SpatialStaticStructEncoder(SpatialStaticStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(SpatialStaticStruct value) {
      ((WorldLocationStructEncoder)_encoder.get(0)).setValue(value.getWorldLocation());
      ((OMT13boolean)_encoder.get(1)).setValue(value.getIsFrozen());
      ((OrientationStructEncoder)_encoder.get(2)).setValue(value.getOrientation());
   }

   protected SpatialStaticStruct decodeValue() {
      return SpatialStaticStruct.create(
         ((WorldLocationStructEncoder)_encoder.get(0)).getValue(),
         ((OMT13boolean)_encoder.get(1)).getValue(),
         ((OrientationStructEncoder)_encoder.get(2)).getValue()
      );
   }
}
