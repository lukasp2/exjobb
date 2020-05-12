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

import devstudio.generatedcode.datatypes.HlaVariantRecordDataType;
import se.pitch.encoders1516.AbstractDataElement;
import se.pitch.encoders1516.ByteWrapper;
import se.pitch.encoders1516.HLAvariantRecord;

abstract class AbstractVariantRecordEncoder<T extends HlaVariantRecordDataType> extends AbstractDataElement {

   private final Class<? extends AbstractVariantRecordEncoder> _class;
   protected final HLAvariantRecord _encoder;

   private T _value;


   public AbstractVariantRecordEncoder(Class<? extends AbstractVariantRecordEncoder> implementationClass) {
      _class = implementationClass;
      _encoder = BaseEncoder.createHLAvariantRecord();
   }

   public T getValue() {
      return _value;
   }

   public void setValue(T value) {
      _value = value;

      encodeValue(value);
   }

   protected abstract void encodeValue(T value);

   public void decode(ByteWrapper byteWrapper) {
      _encoder.decode(byteWrapper);

      _value = decodeValue();
   }

   protected abstract T decodeValue();

   public int getEncodedLength() {
      return _encoder.getEncodedLength();
   }

   public void encode(ByteWrapper byteWrapper) {
      _encoder.encode(byteWrapper);
   }

   public int getOctetBoundary() {
      return _encoder.getOctetBoundary();
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!_class.isInstance(o)) {
         return false;
      }

      AbstractVariantRecordEncoder that = (AbstractVariantRecordEncoder)o;

      return _encoder.equals(that._encoder);
   }

   @Override
   public int hashCode() {
      return _encoder.hashCode();
   }

   @Override
   public String toString() {
      return _class.getSimpleName() + "<" + getValue() + ">";
   }
}
