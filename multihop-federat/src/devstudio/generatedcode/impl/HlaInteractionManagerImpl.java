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
import se.pitch.encoders1516.HLAinteger16BE;
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
   private final HLAinteger16BE _hLAinteger16BEEncoder = BaseEncoder.createHLAinteger16BE();
   private final HLAinteger16BE _hLAinteger16BEDecoder = BaseEncoder.createHLAinteger16BE();
   /* @GuardedBy("this") */
   private final HLAopaqueData _hLAopaqueDataEncoder = BaseEncoder.createHLAopaqueData();
   private final HLAopaqueData _hLAopaqueDataDecoder = BaseEncoder.createHLAopaqueData();

   private static final class HlaRequestPathParametersImpl implements HlaRequestPathParameters {
      private final ParameterValue<Long> _fromNode;
      private final ParameterValue<Long> _toNode;
      private final ParameterValue<Short> _comType;
      private final HlaFederateId _producingFederate;
      private final boolean _isWithinInterest;

      private HlaRequestPathParametersImpl(
         ParameterValue<Long> fromNode,
         ParameterValue<Long> toNode,
         ParameterValue<Short> comType,
         HlaFederateId producingFederate,
         boolean isWithinInterest
      ) {
         _fromNode = new ParameterValue<Long>(fromNode);
         _toNode = new ParameterValue<Long>(toNode);
         _comType = new ParameterValue<Short>(comType);
         _producingFederate = producingFederate;
         _isWithinInterest = isWithinInterest;
      }

      public boolean hasFromNode() {
         return _fromNode.hasValue();
      }

      public long getFromNode() throws HlaValueNotSetException {
         if (_fromNode.hasValue()) {
            return _fromNode.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'fromNode' not set");
      }

      public long getFromNode(long defaultValue) {
         if (_fromNode.hasValue()) {
            return _fromNode.getValue();
         }
         return defaultValue;
      }

      public boolean hasToNode() {
         return _toNode.hasValue();
      }

      public long getToNode() throws HlaValueNotSetException {
         if (_toNode.hasValue()) {
            return _toNode.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'toNode' not set");
      }

      public long getToNode(long defaultValue) {
         if (_toNode.hasValue()) {
            return _toNode.getValue();
         }
         return defaultValue;
      }

      public boolean hasComType() {
         return _comType.hasValue();
      }

      public short getComType() throws HlaValueNotSetException {
         if (_comType.hasValue()) {
            return _comType.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'comType' not set");
      }

      public short getComType(short defaultValue) {
         if (_comType.hasValue()) {
            return _comType.getValue();
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
         if (hasFromNode()) {
            sb.append("fromNode", getFromNode());
         }
         if (hasToNode()) {
            sb.append("toNode", getToNode());
         }
         if (hasComType()) {
            sb.append("comType", getComType());
         }
         return sb.getToString();
      }
   }

   public class HlaRequestPathInteractionImpl implements HlaRequestPathInteraction {
      private final Object _lock = new Object();
      /* @GuardedBy("_lock") */
      private final ParameterValue<Long> _fromNode;
      /* @GuardedBy("_lock") */
      private final ParameterValue<Long> _toNode;
      /* @GuardedBy("_lock") */
      private final ParameterValue<Short> _comType;

      private HlaRequestPathInteractionImpl() {
         _fromNode = new ParameterValue<Long>();
         _toNode = new ParameterValue<Long>();
         _comType = new ParameterValue<Short>();
      }

      public HlaRequestPathParametersImpl build(HlaFederateId producingFederate) {
         synchronized (_lock) {
            return new HlaRequestPathParametersImpl(
               _fromNode,
               _toNode,
               _comType,
               producingFederate,
               true
            );
         }
      }

      private HlaRequestPathParametersImpl build() {
         return build(HlaInteractionManagerImpl.this._hlaWorld.getFederateId());
      }

      public HlaRequestPathInteractionImpl setFromNode(Long value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _fromNode.setValueFromUser(value);
         }
         return this;
      }

      public HlaRequestPathInteractionImpl setToNode(Long value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _toNode.setValueFromUser(value);
         }
         return this;
      }

      public HlaRequestPathInteractionImpl setComType(Short value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _comType.setValueFromUser(value);
         }
         return this;
      }

      public void sendInteraction() throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendRequestPathParams(build(), null);
      }

      public void sendInteraction(HlaTimeStamp timestamp) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendRequestPathParams(build(), timestamp);
      }

      public void sendInteraction(HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendRequestPathParams(build(), null, logicalTime);
      }

      public void sendInteraction(HlaTimeStamp timestamp, HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendRequestPathParams(build(), timestamp, logicalTime);
      }
   }

   public HlaRequestPathInteractionImpl getHlaRequestPathInteraction() {
      return new HlaRequestPathInteractionImpl();
   }

   private static final class HlaResponsePathParametersImpl implements HlaResponsePathParameters {
      private final ParameterValue<byte[]> _nodeArray;
      private final HlaFederateId _producingFederate;
      private final boolean _isWithinInterest;

      private HlaResponsePathParametersImpl(
         ParameterValue<byte[]> nodeArray,
         HlaFederateId producingFederate,
         boolean isWithinInterest
      ) {
         _nodeArray = new ParameterValue<byte[]>(nodeArray);
         _producingFederate = producingFederate;
         _isWithinInterest = isWithinInterest;
      }

      public boolean hasNodeArray() {
         return _nodeArray.hasValue();
      }

      public byte[] getNodeArray() throws HlaValueNotSetException {
         if (_nodeArray.hasValue()) {
            return _nodeArray.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'nodeArray' not set");
      }

      public byte[] getNodeArray(byte[] defaultValue) {
         if (_nodeArray.hasValue()) {
            return _nodeArray.getValue();
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
         ToStringBuilder sb = new ToStringBuilder("HlaResponsePathParameters");
         if (hasNodeArray()) {
            sb.append("nodeArray", getNodeArray());
         }
         return sb.getToString();
      }
   }

   public class HlaResponsePathInteractionImpl implements HlaResponsePathInteraction {
      private final Object _lock = new Object();
      /* @GuardedBy("_lock") */
      private final ParameterValue<byte[]> _nodeArray;

      private HlaResponsePathInteractionImpl() {
         _nodeArray = new ParameterValue<byte[]>();
      }

      public HlaResponsePathParametersImpl build(HlaFederateId producingFederate) {
         synchronized (_lock) {
            return new HlaResponsePathParametersImpl(
               _nodeArray,
               producingFederate,
               true
            );
         }
      }

      private HlaResponsePathParametersImpl build() {
         return build(HlaInteractionManagerImpl.this._hlaWorld.getFederateId());
      }

      public HlaResponsePathInteractionImpl setNodeArray(byte[] value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _nodeArray.setValueFromUser(value);
         }
         return this;
      }

      public void sendInteraction() throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendResponsePathParams(build(), null);
      }

      public void sendInteraction(HlaTimeStamp timestamp) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendResponsePathParams(build(), timestamp);
      }

      public void sendInteraction(HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendResponsePathParams(build(), null, logicalTime);
      }

      public void sendInteraction(HlaTimeStamp timestamp, HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendResponsePathParams(build(), timestamp, logicalTime);
      }
   }

   public HlaResponsePathInteractionImpl getHlaResponsePathInteraction() {
      return new HlaResponsePathInteractionImpl();
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
   private static final String RESPONSE_PATH_INTERACTION_CLASS_NAME = "HLAinteractionRoot.ResponsePath";

   private static final Map<String, InteractionInfo> INTERACTIONS = new MapAdapter<String, InteractionInfo>()
         .append(REQUEST_PATH_INTERACTION_CLASS_NAME, new InteractionInfo(true, true))
         .append(RESPONSE_PATH_INTERACTION_CLASS_NAME, new InteractionInfo(true, true))
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


   public void sendRequestPath(
      long fromNode,
      long toNode,
      short comType
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaRequestPathInteractionImpl interaction = getHlaRequestPathInteraction();
      interaction.setFromNode(fromNode);
      interaction.setToNode(toNode);
      interaction.setComType(comType);
      interaction.sendInteraction();
   }

   public void sendRequestPath(
      long fromNode,
      long toNode,
      short comType,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaRequestPathInteractionImpl interaction = getHlaRequestPathInteraction();
      interaction.setFromNode(fromNode);
      interaction.setToNode(toNode);
      interaction.setComType(comType);
      interaction.sendInteraction(timeStamp);
   }

   public void sendRequestPath(
      long fromNode,
      long toNode,
      short comType,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaRequestPathInteractionImpl interaction = getHlaRequestPathInteraction();
      interaction.setFromNode(fromNode);
      interaction.setToNode(toNode);
      interaction.setComType(comType);
      interaction.sendInteraction(logicalTime);
   }

   public void sendRequestPath(
      long fromNode,
      long toNode,
      short comType,
      HlaTimeStamp timeStamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaRequestPathInteractionImpl interaction = getHlaRequestPathInteraction();
      interaction.setFromNode(fromNode);
      interaction.setToNode(toNode);
      interaction.setComType(comType);
      interaction.sendInteraction(timeStamp, logicalTime);
   }

   public void sendRequestPathParams(
      HlaRequestPathParameters parameters,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
   try {
         sendRequestPathParams(
            parameters,
            timeStamp,
            null
         );
      } catch (HlaInvalidLogicalTimeException e) {
         //can not happen with null logicalTime
      }
   }

   public void sendRequestPathParams(
      HlaRequestPathParameters parameters,
      HlaTimeStamp timestamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      InteractionClassHandle handle = _interactions.get(REQUEST_PATH_INTERACTION_CLASS_NAME);

      if (handle == null) {
         throw new HlaNotConnectedException("Not connected");
      }

      HlaTimeStamp hlaTimeStamp = timestamp != null ? timestamp : _hlaWorld.getCurrentTime();
      HlaLogicalTime hlaLogicalTime = logicalTime != null ? logicalTime : _hlaWorld.getDefaultSendTime();
      NameValueMap nameValueMap = new NameValueMap(3);
      synchronized (this) {
         if (parameters.hasFromNode()) {
            try {
               _hLAinteger64BEEncoder.setValue(parameters.getFromNode());
               nameValueMap.put("fromNode",
                                _hLAinteger64BEEncoder.toByteArray(),
                                false);
            } catch (Throwable t) {
               _hlaWorld.postException(new HlaDecodeException("Failed to encode fromNode", t));
            }
         }
         if (parameters.hasToNode()) {
            try {
               _hLAinteger64BEEncoder.setValue(parameters.getToNode());
               nameValueMap.put("toNode",
                                _hLAinteger64BEEncoder.toByteArray(),
                                false);
            } catch (Throwable t) {
               _hlaWorld.postException(new HlaDecodeException("Failed to encode toNode", t));
            }
         }
         if (parameters.hasComType()) {
            try {
               _hLAinteger16BEEncoder.setValue(parameters.getComType());
               nameValueMap.put("comType",
                                _hLAinteger16BEEncoder.toByteArray(),
                                false);
            } catch (Throwable t) {
               _hlaWorld.postException(new HlaDecodeException("Failed to encode comType", t));
            }
         }
      }

      _interactionManager.sendInteraction(handle, nameValueMap, hlaTimeStamp, hlaLogicalTime);

      fireRequestPathInteraction(
         true,
         parameters,
         hlaTimeStamp,
         hlaLogicalTime
      );
   }


   public void sendResponsePath(
      byte[] nodeArray
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaResponsePathInteractionImpl interaction = getHlaResponsePathInteraction();
      interaction.setNodeArray(nodeArray);
      interaction.sendInteraction();
   }

   public void sendResponsePath(
      byte[] nodeArray,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaResponsePathInteractionImpl interaction = getHlaResponsePathInteraction();
      interaction.setNodeArray(nodeArray);
      interaction.sendInteraction(timeStamp);
   }

   public void sendResponsePath(
      byte[] nodeArray,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaResponsePathInteractionImpl interaction = getHlaResponsePathInteraction();
      interaction.setNodeArray(nodeArray);
      interaction.sendInteraction(logicalTime);
   }

   public void sendResponsePath(
      byte[] nodeArray,
      HlaTimeStamp timeStamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaResponsePathInteractionImpl interaction = getHlaResponsePathInteraction();
      interaction.setNodeArray(nodeArray);
      interaction.sendInteraction(timeStamp, logicalTime);
   }

   public void sendResponsePathParams(
      HlaResponsePathParameters parameters,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
   try {
         sendResponsePathParams(
            parameters,
            timeStamp,
            null
         );
      } catch (HlaInvalidLogicalTimeException e) {
         //can not happen with null logicalTime
      }
   }

   public void sendResponsePathParams(
      HlaResponsePathParameters parameters,
      HlaTimeStamp timestamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      InteractionClassHandle handle = _interactions.get(RESPONSE_PATH_INTERACTION_CLASS_NAME);

      if (handle == null) {
         throw new HlaNotConnectedException("Not connected");
      }

      HlaTimeStamp hlaTimeStamp = timestamp != null ? timestamp : _hlaWorld.getCurrentTime();
      HlaLogicalTime hlaLogicalTime = logicalTime != null ? logicalTime : _hlaWorld.getDefaultSendTime();
      NameValueMap nameValueMap = new NameValueMap(1);
      synchronized (this) {
         if (parameters.hasNodeArray()) {
            try {
               _hLAopaqueDataEncoder.setValue(parameters.getNodeArray());
               nameValueMap.put("nodeArray",
                                _hLAopaqueDataEncoder.toByteArray(),
                                false);
            } catch (Throwable t) {
               _hlaWorld.postException(new HlaDecodeException("Failed to encode nodeArray", t));
            }
         }
      }

      _interactionManager.sendInteraction(handle, nameValueMap, hlaTimeStamp, hlaLogicalTime);

      fireResponsePathInteraction(
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
         case RESPONSE_PATH: {
            receiveResponsePath(parameters, hlaTimeStamp, logicalTime, producingFederate);
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
      interactionData = parameters.get("fromNode");
      if (interactionData != null) {
         try {
            _hLAinteger64BEDecoder.decode(interactionData);
            interaction.setFromNode(_hLAinteger64BEDecoder.getValue());

            if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _hLAinteger64BEDecoder.getEncodedLength() != interactionData.length) {
               _hlaWorld.postException(
                  new HlaDecodeException("Failed to decode fromNode. " +
                                         "Invalid data length " + interactionData.length + ", expected " + _hLAinteger64BEDecoder.getEncodedLength(),
                                         interactionData));
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode fromNode", interactionData, t));
         }
      }

      interactionData = parameters.get("toNode");
      if (interactionData != null) {
         try {
            _hLAinteger64BEDecoder.decode(interactionData);
            interaction.setToNode(_hLAinteger64BEDecoder.getValue());

            if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _hLAinteger64BEDecoder.getEncodedLength() != interactionData.length) {
               _hlaWorld.postException(
                  new HlaDecodeException("Failed to decode toNode. " +
                                         "Invalid data length " + interactionData.length + ", expected " + _hLAinteger64BEDecoder.getEncodedLength(),
                                         interactionData));
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode toNode", interactionData, t));
         }
      }

      interactionData = parameters.get("comType");
      if (interactionData != null) {
         try {
            _hLAinteger16BEDecoder.decode(interactionData);
            interaction.setComType(_hLAinteger16BEDecoder.getValue());

            if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _hLAinteger16BEDecoder.getEncodedLength() != interactionData.length) {
               _hlaWorld.postException(
                  new HlaDecodeException("Failed to decode comType. " +
                                         "Invalid data length " + interactionData.length + ", expected " + _hLAinteger16BEDecoder.getEncodedLength(),
                                         interactionData));
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode comType", interactionData, t));
         }
      }

      fireRequestPathInteraction(
         false,
         interaction.build(producingFederate),
         hlaTimeStamp,
         logicalTime
      );
   }

   private void receiveResponsePath(NameValueMap parameters, HlaTimeStamp hlaTimeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      HlaResponsePathInteractionImpl interaction = getHlaResponsePathInteraction();
      byte[] interactionData;
      interactionData = parameters.get("nodeArray");
      if (interactionData != null) {
         try {
            _hLAopaqueDataDecoder.decode(interactionData);
            interaction.setNodeArray(_hLAopaqueDataDecoder.getValue());

            if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _hLAopaqueDataDecoder.getEncodedLength() != interactionData.length) {
               _hlaWorld.postException(
                  new HlaDecodeException("Failed to decode nodeArray. " +
                                         "Invalid data length " + interactionData.length + ", expected " + _hLAopaqueDataDecoder.getEncodedLength(),
                                         interactionData));
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode nodeArray", interactionData, t));
         }
      }

      fireResponsePathInteraction(
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

   private void fireResponsePathInteraction(
      final boolean local,
      final HlaResponsePathParameters parameters,
      final HlaTimeStamp hlaTimeStamp,
      final HlaLogicalTime hlaLogicalTime
   ) {
      for (final HlaInteractionListener listener : _listeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               listener.responsePath(
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
