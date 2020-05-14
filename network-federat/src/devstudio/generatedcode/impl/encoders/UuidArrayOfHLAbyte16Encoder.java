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

import se.pitch.encoders1516.HLAoctet;
import java.util.Iterator;

public final class UuidArrayOfHLAbyte16Encoder extends AbstractFixedArrayEncoder<byte[]> {


   public UuidArrayOfHLAbyte16Encoder() {
      super(UuidArrayOfHLAbyte16Encoder.class, 16);
   }

   public UuidArrayOfHLAbyte16Encoder(byte[] value) {
      this();
      setValue(value);
   }

   protected void encodeValue(byte[] values) {
      Iterator iter = _encoder.iterator();
      for (int i = 0; i < values.length && iter.hasNext(); i++) {
         HLAoctet element = (HLAoctet)iter.next();
         element.setValue(values[i]);
      }
   }

   protected byte[] decodeValue() {
      byte[] value = new byte[_encoder.size()];
      int i = 0;
      for (Iterator iter = _encoder.iterator(); iter.hasNext();) {
         HLAoctet element = (HLAoctet)iter.next();
         value[i++] = element.getValue();
      }
      return value;
   }

   protected HLAoctet createElement() {
      return BaseEncoder.createHLAoctet();
   }

   protected int getLength(byte[] value) {
      return value.length;
   }
}
