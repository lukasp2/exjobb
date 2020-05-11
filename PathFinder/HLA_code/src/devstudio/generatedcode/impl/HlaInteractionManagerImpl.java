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

import devstudio.generatedcode.impl.encoders.BaseEncoder;
import se.pitch.encoders1516.HLAinteger64BE;
import se.pitch.encoders1516.HLAopaqueData;
import devstudio.generatedcode.*;
import devstudio.generatedcode.datatypes.ToStringBuilder;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.impl.fed.AbstractInteractionClassManager;
import devstudio.generatedcode.impl.fed.FederateInteractionManager;
import devstudio.generatedcode.impl.utils.*;

import se.pitch.ral.api.InteractionClassHandle;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;


/* @ThreadSafe */
final class HlaInteractionManagerImpl extends AbstractInteractionClassManager implements HlaInteractionManager {

   /* @GuardedBy("this") */
   private final HLAinteger64BE _hLAinteger64BEEncoder = BaseEncoder.createHLAinteger64BE();
   private final HLAinteger64BE _hLAinteger64BEDecoder = BaseEncoder.createHLAinteger64BE();
   /* @GuardedBy("this") */
   private final HLAopaqueData _hLAopaqueDataEncoder = BaseEncoder.createHLAopaqueData();
   private final HLAopaqueData _hLAopaqueDataDecoder = BaseEncoder.createHLAopaqueData();

   private static final class HlaRequestPathParametersImpl implements HlaRequestPathParameters {
      private final ParameterValue<Long> _fromNode;
      private final ParameterValue<Long> _toNode;
      private final HlaFederateId _producingFederate;
      private final boolean _isWithinInterest;

      private HlaRequestPathParametersImpl(
         ParameterValue<Long> fromNode,
         ParameterValue<Long> toNode,
         HlaFederateId producingFederate,
         boolean isWithinInterest
      ) {
         _fromNode = new ParameterValue<Long>(fromNode);
         _toNode = new ParameterValue<Long>(toNode);
         _producingFederate = producingFederate;
         _isWithinInterest = isWithinInterest;
      }

      public boolean hasFrom_node() {
         return _fromNode.hasValue();
      }

      public long getFrom_node() throws HlaValueNotSetException {
         if (_fromNode.hasValue()) {
            return _fromNode.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'fromNode' not set");
      }

      public long getFrom_node(long defaultValue) {
         if (_fromNode.hasValue()) {
            return _fromNode.getValue();
         }
         return defaultValue;
      }

      public boolean hasTo_node() {
         return _toNode.hasValue();
      }

      public long getTo_node() throws HlaValueNotSetException {
         if (_toNode.hasValue()) {
            return _toNode.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'toNode' not set");
      }

      public long getTo_node(long defaultValue) {
         if (_toNode.hasValue()) {
            return _toNode.getValue();
         }
         return defaultValue;
      }

      @Override
      public HlaFederateId getProducingFederate() {
         return _producingFederate;
      }

      @Override
      public boolean isWithinInterest() {
         return _isWithinInterest;
      }

      @Override
      public String toString() {
         ToStringBuilder sb = new ToStringBuilder("HlaRequestPathParameters");
         if (hasFrom_node()) {
            sb.append("from_node", getFrom_node());
         }
         if (hasTo_node()) {
            sb.append("to_node", getTo_node());
         }
         return sb.getToString();
      }
   }

   public class HlaRequestPathInteractionImpl {
      private final Object _lock = new Object();
      /* @GuardedBy("_lock") */
      private final ParameterValue<Long> _fromNode;
      /* @GuardedBy("_lock") */
      private final ParameterValue<Long> _toNode;

      private HlaRequestPathInteractionImpl() {
         _fromNode = new ParameterValue<Long>();
         _toNode = new ParameterValue<Long>();
      }

      public HlaRequestPathParametersImpl build(HlaFederateId producingFederate) {
         synchronized (_lock) {
            return new HlaRequestPathParametersImpl(
               _fromNode,
               _toNode,
               producingFederate,
               true
            );
         }
      }

      private HlaRequestPathParametersImpl build() {
         return build(HlaInteractionManagerImpl.this._hlaWorld.getFederateId());
      }

      public HlaRequestPathInteractionImpl setFrom_node(Long value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _fromNode.setValueFromUser(value);
         }
         return this;
      }

      public HlaRequestPathInteractionImpl setTo_node(Long value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _toNode.setValueFromUser(value);
         }
         return this;
      }

   }

   public HlaRequestPathInteractionImpl getHlaRequestPathInteraction() {
      return new HlaRequestPathInteractionImpl();
   }

   private static final class HlaResultPathParametersImpl implements HlaResultPathParameters {
      private final ParameterValue<byte[]> _intArray;
      private final HlaFederateId _producingFederate;
      private final boolean _isWithinInterest;

      private HlaResultPathParametersImpl(
         ParameterValue<byte[]> intArray,
         HlaFederateId producingFederate,
         boolean isWithinInterest
      ) {
         _intArray = new ParameterValue<byte[]>(intArray);
         _producingFederate = producingFederate;
         _isWithinInterest = isWithinInterest;
      }

      public boolean hasIntArray() {
         return _intArray.hasValue();
      }

      public byte[] getIntArray() throws HlaValueNotSetException {
         if (_intArray.hasValue()) {
            return _intArray.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'intArray' not set");
      }

      public byte[] getIntArray(byte[] defaultValue) {
         if (_intArray.hasValue()) {
            return _intArray.getValue();
         }
         return defaultValue;
      }

      @Override
      public HlaFederateId getProducingFederate() {
         return _producingFederate;
      }

      @Override
      public boolean isWithinInterest() {
         return _isWithinInterest;
      }

      @Override
      public String toString() {
         ToStringBuilder sb = new ToStringBuilder("HlaResultPathParameters");
         if (hasIntArray()) {
            sb.append("IntArray", getIntArray());
         }
         return sb.getToString();
      }
   }

   public class HlaResultPathInteractionImpl implements HlaResultPathInteraction {
      private final Object _lock = new Object();
      /* @GuardedBy("_lock") */
      private final ParameterValue<byte[]> _intArray;

      private HlaResultPathInteractionImpl() {
         _intArray = new ParameterValue<byte[]>();
      }

      public HlaResultPathParametersImpl build(HlaFederateId producingFederate) {
         synchronized (_lock) {
            return new HlaResultPathParametersImpl(
               _intArray,
               producingFederate,
               true
            );
         }
      }

      private HlaResultPathParametersImpl build() {
         return build(HlaInteractionManagerImpl.this._hlaWorld.getFederateId());
      }

      public HlaResultPathInteractionImpl setIntArray(byte[] value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _intArray.setValueFromUser(value);
         }
         return this;
      }

      public void sendInteraction() throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendResultPathParams(build(), null);
      }

      public void sendInteraction(HlaTimeStamp timestamp) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendResultPathParams(build(), timestamp);
      }

      public void sendInteraction(HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendResultPathParams(build(), null, logicalTime);
      }

      public void sendInteraction(HlaTimeStamp timestamp, HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendResultPathParams(build(), timestamp, logicalTime);
      }
   }

   public HlaResultPathInteractionImpl getHlaResultPathInteraction() {
      return new HlaResultPathInteractionImpl();
   }

   private static class InteractionInfo {
      private final boolean _local;
      private final boolean _remote;

      public InteractionInfo(boolean local, boolean remote) {
         _local = local;
         _remote = remote;
      }

      public boolean isLocal() {
         return _local;
      }

      public boolean isRemote() {
         return _remote;
      }
   }

   private static final String REQUEST_PATH_INTERACTION_CLASS_NAME = "HLAinteractionRoot.RequestPath";
   private static final String RESULT_PATH_INTERACTION_CLASS_NAME = "HLAinteractionRoot.ResultPath";

   private static final Map<String, InteractionInfo> INTERACTIONS = new MapAdapter<String, InteractionInfo>()
         .append(REQUEST_PATH_INTERACTION_CLASS_NAME, new InteractionInfo(false, true))
         .append(RESULT_PATH_INTERACTION_CLASS_NAME, new InteractionInfo(true, false))
         .unmodifiableMap();


   private final FederateInteractionManager _interactionManager;
   private final HlaWorldImpl _hlaWorld;

   private final DualMap<String, InteractionClassHandle> _interactions =
      new DualMap<String, InteractionClassHandle>(2);

   private final Set<HlaInteractionListener> _listeners = new CopyOnWriteArraySet<HlaInteractionListener>();
   private final Set<Interaction> _enabled = EnumSet.allOf(Interaction.class);
   private final Set<Interaction> _optional = EnumSet.noneOf(Interaction.class);


   HlaInteractionManagerImpl(FederateInteractionManager interactionManager, HlaWorldImpl hlaWorld) {
      _interactionManager = interactionManager;
      _hlaWorld = hlaWorld;

      for (String name : INTERACTIONS.keySet()) {
         _interactionManager.addManager(this, name);
      }
   }

   /*
    * HlaInteractionManager interface impl
    */


   public void sendResultPath(
      byte[] intArray
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaResultPathInteractionImpl interaction = getHlaResultPathInteraction();
      interaction.setIntArray(intArray);
      interaction.sendInteraction();
   }

   public void sendResultPath(
      byte[] intArray,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaResultPathInteractionImpl interaction = getHlaResultPathInteraction();
      interaction.setIntArray(intArray);
      interaction.sendInteraction(timeStamp);
   }

   public void sendResultPath(
      byte[] intArray,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaResultPathInteractionImpl interaction = getHlaResultPathInteraction();
      interaction.setIntArray(intArray);
      interaction.sendInteraction(logicalTime);
   }

   public void sendResultPath(
      byte[] intArray,
      HlaTimeStamp timeStamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaResultPathInteractionImpl interaction = getHlaResultPathInteraction();
      interaction.setIntArray(intArray);
      interaction.sendInteraction(timeStamp, logicalTime);
   }

   public void sendResultPathParams(
      HlaResultPathParameters parameters,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
   try {
         sendResultPathParams(
            parameters,
            timeStamp,
            null
         );
      } catch (HlaInvalidLogicalTimeException e) {
         //can not happen with null logicalTime
      }
   }

   public void sendResultPathParams(
      HlaResultPathParameters parameters,
      HlaTimeStamp timestamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      InteractionClassHandle handle = _interactions.get(RESULT_PATH_INTERACTION_CLASS_NAME);

      if (handle == null) {
         throw new HlaNotConnectedException("Not connected");
      }

      HlaTimeStamp hlaTimeStamp = timestamp != null ? timestamp : _hlaWorld.getCurrentTime();
      HlaLogicalTime hlaLogicalTime = logicalTime != null ? logicalTime : _hlaWorld.getDefaultSendTime();
      NameValueMap nameValueMap = new NameValueMap(1);
      synchronized (this) {
         if (parameters.hasIntArray()) {
            try {
               _hLAopaqueDataEncoder.setValue(parameters.getIntArray());
               nameValueMap.put("IntArray",
                                _hLAopaqueDataEncoder.toByteArray(),
                                false);
            } catch (Throwable t) {
               _hlaWorld.postException(new HlaDecodeException("Failed to encode IntArray", t));
            }
         }
      }

      _interactionManager.sendInteraction(handle, nameValueMap, hlaTimeStamp, hlaLogicalTime);

      fireResultPathInteraction(
         true,
         parameters,
         hlaTimeStamp,
         hlaLogicalTime
      );
   }

   public void addHlaInteractionListener(HlaInteractionListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.add(listener);
   }

   public void removeHlaInteractionListener(HlaInteractionListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.remove(listener);
   }


   public void setEnabled(boolean enabled, Interaction interaction) {
      setEnabled(enabled, EnumSet.of(interaction));
   }

   public void setEnabled(boolean enabled, Set<Interaction> interactions) {
      _optional.removeAll(interactions);
      if (enabled) {
         _enabled.addAll(interactions);
      } else {
         _enabled.removeAll(interactions);
      }
   }

   public void setEnabledIfAvailableInFom(Set<Interaction> interactions) {
      _optional.addAll(interactions);
      _enabled.addAll(interactions);
   }

   public boolean isEnabled(Interaction interaction) {
      return _interactions.get(interaction.getHlaName()) != null;
   }

   /*
    * AbstractInteractionClassManager impl
    */

   @Override
   public void receiveInteraction(InteractionClassHandle interactionClassHandle, NameValueMap parameters, HlaTimeStamp hlaTimeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      String interactionName = _interactions.getByValue(interactionClassHandle);
      if (interactionName == null) {
         _hlaWorld.postException(new HlaInternalException("Received unknown interaction: " + interactionClassHandle));
         return;
      }

      Interaction interaction = Interaction.find(interactionName);
      if (interaction == null) {
         _hlaWorld.postException(new HlaInternalException("Received unknown interaction: " + interactionName));
         return;
      }

      switch (interaction) {
         case REQUEST_PATH: {
            receiveRequestPath(parameters, hlaTimeStamp, logicalTime, producingFederate);
            return;
         }
      }
      _hlaWorld.postException(new HlaInternalException("Received unknown interaction: " + interactionName));
   }

   @Override
   public boolean isEnabled(String interactionClassName) {
      Interaction interaction = Interaction.find(interactionClassName);
      return interaction != null && _enabled.contains(interaction);
   }

   @Override
   public boolean isOptional(String interactionClassName) {
      Interaction interaction = Interaction.find(interactionClassName);
      return interaction != null && _optional.contains(interaction);
   }

   @Override
   public void connected(InteractionClassHandle interactionClassHandle, String interactionClassName)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      _interactions.put(interactionClassName, interactionClassHandle);

      InteractionInfo interactionInfo = INTERACTIONS.get(interactionClassName);
      if (interactionInfo == null) {
         return;
      }

      if (interactionInfo.isLocal()) {
         _interactionManager.publish(interactionClassHandle);
      }

      if (interactionInfo.isRemote()) {
         _interactionManager.subscribe(interactionClassHandle);
      }
   }

   @Override
   public void disconnected(InteractionClassHandle interactionClassHandle) {
      _interactions.removeByValue(interactionClassHandle);
   }


   /*
    * Private functions
    */

   private void receiveRequestPath(NameValueMap parameters, HlaTimeStamp hlaTimeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      HlaRequestPathInteractionImpl interaction = getHlaRequestPathInteraction();
      byte[] interactionData;
      interactionData = parameters.get("from_node");
      if (interactionData != null) {
         try {
            _hLAinteger64BEDecoder.decode(interactionData);
            interaction.setFrom_node(_hLAinteger64BEDecoder.getValue());

            if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _hLAinteger64BEDecoder.getEncodedLength() != interactionData.length) {
               _hlaWorld.postException(
                  new HlaDecodeException("Failed to decode from_node. " +
                                         "Invalid data length " + interactionData.length + ", expected " + _hLAinteger64BEDecoder.getEncodedLength(),
                                         interactionData));
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode from_node", interactionData, t));
         }
      }

      interactionData = parameters.get("to_node");
      if (interactionData != null) {
         try {
            _hLAinteger64BEDecoder.decode(interactionData);
            interaction.setTo_node(_hLAinteger64BEDecoder.getValue());

            if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _hLAinteger64BEDecoder.getEncodedLength() != interactionData.length) {
               _hlaWorld.postException(
                  new HlaDecodeException("Failed to decode to_node. " +
                                         "Invalid data length " + interactionData.length + ", expected " + _hLAinteger64BEDecoder.getEncodedLength(),
                                         interactionData));
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode to_node", interactionData, t));
         }
      }

      fireRequestPathInteraction(
         false,
         interaction.build(producingFederate),
         hlaTimeStamp,
         logicalTime
      );
   }


   private void fireRequestPathInteraction(
      final boolean local,
      final HlaRequestPathParameters parameters,
      final HlaTimeStamp hlaTimeStamp,
      final HlaLogicalTime hlaLogicalTime
   ) {
      for (final HlaInteractionListener listener : _listeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               listener.requestPath(
                  local,
                  parameters,
                  hlaTimeStamp,
                  hlaLogicalTime
               );
            }
         });
      }
   }

   private void fireResultPathInteraction(
      final boolean local,
      final HlaResultPathParameters parameters,
      final HlaTimeStamp hlaTimeStamp,
      final HlaLogicalTime hlaLogicalTime
   ) {
      for (final HlaInteractionListener listener : _listeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               listener.resultPath(
                  local,
                  parameters,
                  hlaTimeStamp,
                  hlaLogicalTime
               );
            }
         });
      }
   }

}
