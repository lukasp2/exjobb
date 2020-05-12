package devstudio.generatedcode.impl.fed;

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
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.impl.utils.NameValueMap;

import se.pitch.ral.api.InteractionClassHandle;


public abstract class AbstractInteractionClassManager {
   public abstract void receiveInteraction(InteractionClassHandle interactionClassHandle, NameValueMap parameters,
                                           HlaTimeStamp hlaTimeStamp, HlaLogicalTime logicalTime,
                                           HlaFederateId producingFederate);

   public abstract boolean isEnabled(String interactionClassName);
   public abstract boolean isOptional(String interactionClassName);

   public abstract void connected(InteractionClassHandle interactionClassHandle, String interactionClassName)
      throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
             HlaSaveInProgressException, HlaRestoreInProgressException;

   public abstract void disconnected(InteractionClassHandle interactionClassHandle);
}
