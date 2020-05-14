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

import devstudio.generatedcode.datatypes.DeadReckoningAlgorithmEnum;

public final class DeadReckoningAlgorithmEnumEncoder extends AbstractEnum8Encoder<DeadReckoningAlgorithmEnum> {

   public DeadReckoningAlgorithmEnumEncoder() {
      super(DeadReckoningAlgorithmEnumEncoder.class, DeadReckoningAlgorithmEnum.class, BaseEncoder.createHLAoctet());
   }

   public DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum value) {
      this();
      setValue(value);
   }

   protected DeadReckoningAlgorithmEnum find(long ordinal) {
      return DeadReckoningAlgorithmEnum.find(ordinal);
   }
}
