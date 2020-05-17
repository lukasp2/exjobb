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

import se.pitch.encoders1516.HLAopaqueData;
import java.util.Iterator;

public final class NodeArrayEncoder extends AbstractVariableArrayEncoder<byte[][]> {


   public NodeArrayEncoder() {
      super(NodeArrayEncoder.class);
   }

   public NodeArrayEncoder(byte[][] value) {
      this();
      setValue(value);
   }

   protected void encodeValue(byte[][] values) {
      _encoder.resize(values.length);

      int i = 0;
      for (Iterator iter = _encoder.iterator(); iter.hasNext();) {
         HLAopaqueData element = (HLAopaqueData)iter.next();
         element.setValue(values[i++]);
      }
   }

   protected byte[][] decodeValue() {
      byte[][] value = new byte[_encoder.size()][];
      int i = 0;
      for (Iterator iter = _encoder.iterator(); iter.hasNext();) {
         HLAopaqueData element = (HLAopaqueData)iter.next();
         value[i++] = element.getValue();
      }
      return value;
   }

   protected HLAopaqueData createElement() {
      return BaseEncoder.createHLAopaqueData();
   }
}
