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

import devstudio.generatedcode.datatypes.HlaEnumDataType;
import devstudio.generatedcode.exceptions.HlaDecodeException;
import se.pitch.encoders1516.AbstractDataElement;
import se.pitch.encoders1516.ByteWrapper;
import se.pitch.encoders1516.DataElementByte;

abstract class AbstractEnum8Encoder<T extends HlaEnumDataType> extends AbstractDataElement {

   private final Class<? extends AbstractEnum8Encoder> _class;
   private final Class<T> _dataTypeClass;
   private final DataElementByte _encoder;
   private T _value;

   protected AbstractEnum8Encoder(Class<? extends AbstractEnum8Encoder> implementationClass,
                                  Class<T> dataTypeClass,
                                  DataElementByte encoder) {
      _class = implementationClass;
      _dataTypeClass = dataTypeClass;
      _encoder = encoder;
   }

   public T getValue() {
      return _value;
   }

   public void setValue(T value) {
      _value = value;
      _encoder.setValue((byte)_value.getOrdinal());
   }

   public int getOctetBoundary() {
      return _encoder.getOctetBoundary();
   }

   public void encode(ByteWrapper byteWrapper) {
      _encoder.encode(byteWrapper);
   }

   public int getEncodedLength() {
      return _encoder.getEncodedLength();
   }

   public void decode(ByteWrapper byteWrapper) {
      _encoder.decode(byteWrapper);
      byte ordinal = _encoder.getValue();
      T newValue = find(ordinal);
      if (newValue != null) {
         _value = newValue;
      } else {
         throw new HlaDecodeException("Failed to decode " + _dataTypeClass.getSimpleName() + " with ordinal " + ordinal);
      }
   }

   protected abstract T find(long ordinal);

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!_class.isInstance(o)) {
         return false;
      }

      AbstractEnum8Encoder that = (AbstractEnum8Encoder)o;

      return _encoder.equals(that._encoder);
   }

   @Override
   public int hashCode() {
      return _encoder.hashCode();
   }

   @Override
   public String toString() {
      return _class.getSimpleName() + "<" + getValue().getName() + ">";
   }
}
