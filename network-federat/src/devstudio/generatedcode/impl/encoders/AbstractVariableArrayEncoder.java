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

import se.pitch.encoders1516.*;

abstract class AbstractVariableArrayEncoder<T> extends AbstractDataElement {

   private final Class<? extends AbstractVariableArrayEncoder> _class;
   protected final HLAvariableArray _encoder;

   private T _value;


   AbstractVariableArrayEncoder(Class<? extends AbstractVariableArrayEncoder> implementationClass) {
      _class = implementationClass;
      _encoder = BaseEncoder.createHLAvariableArray(new DataElementFactory() {
         public DataElement createElement(int i) {
            return AbstractVariableArrayEncoder.this.createElement();
         }
      });
   }

   public T getValue() {
      return _value;
   }

   public void setValue(T value) {
      _value = value;

      encodeValue(value);
   }

   protected abstract void encodeValue(T value);

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

      _value = decodeValue();
   }

   protected abstract T decodeValue();

   protected abstract DataElement createElement();

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!_class.isInstance(o)) {
         return false;
      }

      AbstractVariableArrayEncoder that = (AbstractVariableArrayEncoder)o;

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
