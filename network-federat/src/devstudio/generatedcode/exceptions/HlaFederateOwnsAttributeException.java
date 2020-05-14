package devstudio.generatedcode.exceptions;

/*
 * DO NOT EDIT!
 * 
 * Automatically generated source code by Pitch Developer Studio
 * Licensed to LP Internal Development 2020
 *
 * Copyright (C) 2006-2020 Pitch Technologies AB. All rights reserved.
 * Use is subject to license terms.
 */


/**
 * Exception thrown if attempting to acquire an already owned attribute,
 * or if ownership acquisitions are pending or if attributes are owned
 * and this not handled by the resign action when disconnecting.
 */
public final class HlaFederateOwnsAttributeException extends HlaBaseRuntimeException {

   public HlaFederateOwnsAttributeException(String message) {
      super(message);
   }

   public HlaFederateOwnsAttributeException(String message, Throwable cause) {
      super(message, cause);
   }
}
