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
 * Exception thrown if the federate tries to cancel acquire ownership of an attribute is
 * has already received ownership of.
 */
public final class HlaAttributeAlreadyOwnedException extends HlaBaseException {

   public HlaAttributeAlreadyOwnedException(String message) {
      super(message);
   }

   public HlaAttributeAlreadyOwnedException(String message, Throwable cause) {
      super(message, cause);
   }
}