package devstudio.generatedcode.impl;

/*
 * DO NOT EDIT!
 * 
 * Automatically generated source code by Pitch Developer Studio
 * Licensed to LP Internal Development 2020
 *
 * Copyright (C) 2006-2020 Pitch Technologies AB. All rights reserved.
 * Use is subject to license terms.
 */

import devstudio.generatedcode.HlaFederateId;
import devstudio.generatedcode.exceptions.HlaValueNotSetException;

import se.pitch.ral.api.FederateHandle;


/* @ThreadSafe */
public final class HlaFederateIdImpl implements HlaFederateId {
   private final FederateHandle _federateHandle;

   public HlaFederateIdImpl(FederateHandle federateHandle) {
      _federateHandle = federateHandle;
   }                                         

   public boolean hasFederateName() {
      return _federateHandle != null && _federateHandle.getFederateName() != null;
   }

   public String getFederateName() throws HlaValueNotSetException {
      if (hasFederateName()) {
         return _federateHandle.getFederateName();
      }
      throw new HlaValueNotSetException("Federate name is not available");
   }

   public boolean hasEncodedHlaFederateHandle() {
      return _federateHandle != null && _federateHandle.getEncodedHandle() != null;
   }

   public byte[] getEncodedHlaFederateHandle() throws HlaValueNotSetException {
      if (hasEncodedHlaFederateHandle()) {
         return _federateHandle.getEncodedHandle();
      }
      throw new HlaValueNotSetException("Encoded HlaFederateHandle is not available");
   }

   @Override
   public boolean equals(Object other) {
      if (this == other) {
         return true;
      }

      if (other == null || getClass() != other.getClass()) {
         return false;
      }

      HlaFederateIdImpl that = (HlaFederateIdImpl)other;
      return _federateHandle != null ? _federateHandle.equals(that._federateHandle) : that._federateHandle == null;
   }

   @Override
   public int hashCode() {
      return _federateHandle != null ? _federateHandle.hashCode() : 0;
   }
}
