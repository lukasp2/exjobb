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
import devstudio.generatedcode.impl.encoders.NodeArrayEncoder;
import se.pitch.encoders1516.HLAinteger32BE;
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
   private final HLAopaqueData _hLAopaqueDataEncoder = BaseEncoder.createHLAopaqueData();
   private final HLAopaqueData _hLAopaqueDataDecoder = BaseEncoder.createHLAopaqueData();
   /* @GuardedBy("this") */
   private final HLAinteger32BE _hLAinteger32BEEncoder = BaseEncoder.createHLAinteger32BE();
   private final HLAinteger32BE _hLAinteger32BEDecoder = BaseEncoder.createHLAinteger32BE();
   /* @GuardedBy("this") */
   private final HLAinteger64BE _hLAinteger64BEEncoder = BaseEncoder.createHLAinteger64BE();
   private final HLAinteger64BE _hLAinteger64BEDecoder = BaseEncoder.createHLAinteger64BE();
   /* @GuardedBy("this") */
   private final NodeArrayEncoder _nodeArrayEncoderEncoder = new NodeArrayEncoder();
   private final NodeArrayEncoder _nodeArrayEncoderDecoder = new NodeArrayEncoder();

   private static final class HlaRequestParametersImpl implements HlaRequestParameters {
      private final ParameterValue<byte[]> _fromNode;
      private final ParameterValue<byte[]> _toNode;
      private final ParameterValue<Integer> _comType;
      private final ParameterValue<Long> _transactionID;
      private final HlaFederateId _producingFederate;
      private final boolean _isWithinInterest;

      private HlaRequestParametersImpl(
         ParameterValue<byte[]> fromNode,
         ParameterValue<byte[]> toNode,
         ParameterValue<Integer> comType,
         ParameterValue<Long> transactionID,
         HlaFederateId producingFederate,
         boolean isWithinInterest
      ) {
         _fromNode = new ParameterValue<byte[]>(fromNode);
         _toNode = new ParameterValue<byte[]>(toNode);
         _comType = new ParameterValue<Integer>(comType);
         _transactionID = new ParameterValue<Long>(transactionID);
         _producingFederate = producingFederate;
         _isWithinInterest = isWithinInterest;
      }

      public boolean hasFromNode() {
         return _fromNode.hasValue();
      }

      public byte[] getFromNode() throws HlaValueNotSetException {
         if (_fromNode.hasValue()) {
            return _fromNode.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'fromNode' not set");
      }

      public byte[] getFromNode(byte[] defaultValue) {
         if (_fromNode.hasValue()) {
            return _fromNode.getValue();
         }
         return defaultValue;
      }

      public boolean hasToNode() {
         return _toNode.hasValue();
      }

      public byte[] getToNode() throws HlaValueNotSetException {
         if (_toNode.hasValue()) {
            return _toNode.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'toNode' not set");
      }

      public byte[] getToNode(byte[] defaultValue) {
         if (_toNode.hasValue()) {
            return _toNode.getValue();
         }
         return defaultValue;
      }

      public boolean hasComType() {
         return _comType.hasValue();
      }

      public int getComType() throws HlaValueNotSetException {
         if (_comType.hasValue()) {
            return _comType.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'comType' not set");
      }

      public int getComType(int defaultValue) {
         if (_comType.hasValue()) {
            return _comType.getValue();
         }
         return defaultValue;
      }

      public boolean hasTransactionID() {
         return _transactionID.hasValue();
      }

      public long getTransactionID() throws HlaValueNotSetException {
         if (_transactionID.hasValue()) {
            return _transactionID.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'transactionID' not set");
      }

      public long getTransactionID(long defaultValue) {
         if (_transactionID.hasValue()) {
            return _transactionID.getValue();
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
         ToStringBuilder sb = new ToStringBuilder("HlaRequestParameters");
         if (hasFromNode()) {
            sb.append("fromNode", getFromNode());
         }
         if (hasToNode()) {
            sb.append("toNode", getToNode());
         }
         if (hasComType()) {
            sb.append("comType", getComType());
         }
         if (hasTransactionID()) {
            sb.append("transactionID", getTransactionID());
         }
         return sb.getToString();
      }
   }

   public class HlaRequestInteractionImpl implements HlaRequestInteraction {
      private final Object _lock = new Object();
      /* @GuardedBy("_lock") */
      private final ParameterValue<byte[]> _fromNode;
      /* @GuardedBy("_lock") */
      private final ParameterValue<byte[]> _toNode;
      /* @GuardedBy("_lock") */
      private final ParameterValue<Integer> _comType;
      /* @GuardedBy("_lock") */
      private final ParameterValue<Long> _transactionID;

      private HlaRequestInteractionImpl() {
         _fromNode = new ParameterValue<byte[]>();
         _toNode = new ParameterValue<byte[]>();
         _comType = new ParameterValue<Integer>();
         _transactionID = new ParameterValue<Long>();
      }

      public HlaRequestParametersImpl build(HlaFederateId producingFederate) {
         synchronized (_lock) {
            return new HlaRequestParametersImpl(
               _fromNode,
               _toNode,
               _comType,
               _transactionID,
               producingFederate,
               true
            );
         }
      }

      private HlaRequestParametersImpl build() {
         return build(HlaInteractionManagerImpl.this._hlaWorld.getFederateId());
      }

      public HlaRequestInteractionImpl setFromNode(byte[] value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _fromNode.setValueFromUser(value);
         }
         return this;
      }

      public HlaRequestInteractionImpl setToNode(byte[] value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _toNode.setValueFromUser(value);
         }
         return this;
      }

      public HlaRequestInteractionImpl setComType(Integer value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _comType.setValueFromUser(value);
         }
         return this;
      }

      public HlaRequestInteractionImpl setTransactionID(Long value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _transactionID.setValueFromUser(value);
         }
         return this;
      }

      public void sendInteraction() throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendRequestParams(build(), null);
      }

      public void sendInteraction(HlaTimeStamp timestamp) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendRequestParams(build(), timestamp);
      }

      public void sendInteraction(HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendRequestParams(build(), null, logicalTime);
      }

      public void sendInteraction(HlaTimeStamp timestamp, HlaLogicalTime logicalTime) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
         HlaInteractionManagerImpl.this.sendRequestParams(build(), timestamp, logicalTime);
      }
   }

   public HlaRequestInteractionImpl getHlaRequestInteraction() {
      return new HlaRequestInteractionImpl();
   }

   private static final class HlaResponseParametersImpl implements HlaResponseParameters {
      private final ParameterValue<byte[][]> _path;
      private final ParameterValue<Long> _transactionID;
      private final HlaFederateId _producingFederate;
      private final boolean _isWithinInterest;

      private HlaResponseParametersImpl(
         ParameterValue<byte[][]> path,
         ParameterValue<Long> transactionID,
         HlaFederateId producingFederate,
         boolean isWithinInterest
      ) {
         _path = new ParameterValue<byte[][]>(path);
         _transactionID = new ParameterValue<Long>(transactionID);
         _producingFederate = producingFederate;
         _isWithinInterest = isWithinInterest;
      }

      public boolean hasPath() {
         return _path.hasValue();
      }

      public byte[][] getPath() throws HlaValueNotSetException {
         if (_path.hasValue()) {
            return _path.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'path' not set");
      }

      public byte[][] getPath(byte[][] defaultValue) {
         if (_path.hasValue()) {
            return _path.getValue();
         }
         return defaultValue;
      }

      public boolean hasTransactionID() {
         return _transactionID.hasValue();
      }

      public long getTransactionID() throws HlaValueNotSetException {
         if (_transactionID.hasValue()) {
            return _transactionID.getValue();
         }
         throw new HlaValueNotSetException("Parameter 'transactionID' not set");
      }

      public long getTransactionID(long defaultValue) {
         if (_transactionID.hasValue()) {
            return _transactionID.getValue();
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
         ToStringBuilder sb = new ToStringBuilder("HlaResponseParameters");
         if (hasPath()) {
            sb.append("Path", getPath());
         }
         if (hasTransactionID()) {
            sb.append("transactionID", getTransactionID());
         }
         return sb.getToString();
      }
   }

   public class HlaResponseInteractionImpl {
      private final Object _lock = new Object();
      /* @GuardedBy("_lock") */
      private final ParameterValue<byte[][]> _path;
      /* @GuardedBy("_lock") */
      private final ParameterValue<Long> _transactionID;

      private HlaResponseInteractionImpl() {
         _path = new ParameterValue<byte[][]>();
         _transactionID = new ParameterValue<Long>();
      }

      public HlaResponseParametersImpl build(HlaFederateId producingFederate) {
         synchronized (_lock) {
            return new HlaResponseParametersImpl(
               _path,
               _transactionID,
               producingFederate,
               true
            );
         }
      }

      private HlaResponseParametersImpl build() {
         return build(HlaInteractionManagerImpl.this._hlaWorld.getFederateId());
      }

      public HlaResponseInteractionImpl setPath(byte[][] value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _path.setValueFromUser(value);
         }
         return this;
      }

      public HlaResponseInteractionImpl setTransactionID(Long value) {
         if (value == null) {
            throw new NullPointerException();
         }
         synchronized (_lock) {
            _transactionID.setValueFromUser(value);
         }
         return this;
      }

   }

   public HlaResponseInteractionImpl getHlaResponseInteraction() {
      return new HlaResponseInteractionImpl();
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

   private static final String REQUEST_INTERACTION_CLASS_NAME = "HLAinteractionRoot.Request";
   private static final String RESPONSE_INTERACTION_CLASS_NAME = "HLAinteractionRoot.Response";

   private static final Map<String, InteractionInfo> INTERACTIONS = new MapAdapter<String, InteractionInfo>()
         .append(REQUEST_INTERACTION_CLASS_NAME, new InteractionInfo(true, false))
         .append(RESPONSE_INTERACTION_CLASS_NAME, new InteractionInfo(false, true))
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


   public void sendRequest(
      byte[] fromNode,
      byte[] toNode,
      int comType,
      long transactionID
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaRequestInteractionImpl interaction = getHlaRequestInteraction();
      interaction.setFromNode(fromNode);
      interaction.setToNode(toNode);
      interaction.setComType(comType);
      interaction.setTransactionID(transactionID);
      interaction.sendInteraction();
   }

   public void sendRequest(
      byte[] fromNode,
      byte[] toNode,
      int comType,
      long transactionID,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaRequestInteractionImpl interaction = getHlaRequestInteraction();
      interaction.setFromNode(fromNode);
      interaction.setToNode(toNode);
      interaction.setComType(comType);
      interaction.setTransactionID(transactionID);
      interaction.sendInteraction(timeStamp);
   }

   public void sendRequest(
      byte[] fromNode,
      byte[] toNode,
      int comType,
      long transactionID,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException, HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaRequestInteractionImpl interaction = getHlaRequestInteraction();
      interaction.setFromNode(fromNode);
      interaction.setToNode(toNode);
      interaction.setComType(comType);
      interaction.setTransactionID(transactionID);
      interaction.sendInteraction(logicalTime);
   }

   public void sendRequest(
      byte[] fromNode,
      byte[] toNode,
      int comType,
      long transactionID,
      HlaTimeStamp timeStamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      HlaRequestInteractionImpl interaction = getHlaRequestInteraction();
      interaction.setFromNode(fromNode);
      interaction.setToNode(toNode);
      interaction.setComType(comType);
      interaction.setTransactionID(transactionID);
      interaction.sendInteraction(timeStamp, logicalTime);
   }

   public void sendRequestParams(
      HlaRequestParameters parameters,
      HlaTimeStamp timeStamp
   ) throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
   try {
         sendRequestParams(
            parameters,
            timeStamp,
            null
         );
      } catch (HlaInvalidLogicalTimeException e) {
         //can not happen with null logicalTime
      }
   }

   public void sendRequestParams(
      HlaRequestParameters parameters,
      HlaTimeStamp timestamp,
      HlaLogicalTime logicalTime
   ) throws HlaNotConnectedException, HlaFomException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      InteractionClassHandle handle = _interactions.get(REQUEST_INTERACTION_CLASS_NAME);

      if (handle == null) {
         throw new HlaNotConnectedException("Not connected");
      }

      HlaTimeStamp hlaTimeStamp = timestamp != null ? timestamp : _hlaWorld.getCurrentTime();
      HlaLogicalTime hlaLogicalTime = logicalTime != null ? logicalTime : _hlaWorld.getDefaultSendTime();
      NameValueMap nameValueMap = new NameValueMap(4);
      synchronized (this) {
         if (parameters.hasFromNode()) {
            try {
               _hLAopaqueDataEncoder.setValue(parameters.getFromNode());
               nameValueMap.put("fromNode",
                                _hLAopaqueDataEncoder.toByteArray(),
                                false);
            } catch (Throwable t) {
               _hlaWorld.postException(new HlaDecodeException("Failed to encode fromNode", t));
            }
         }
         if (parameters.hasToNode()) {
            try {
               _hLAopaqueDataEncoder.setValue(parameters.getToNode());
               nameValueMap.put("toNode",
                                _hLAopaqueDataEncoder.toByteArray(),
                                false);
            } catch (Throwable t) {
               _hlaWorld.postException(new HlaDecodeException("Failed to encode toNode", t));
            }
         }
         if (parameters.hasComType()) {
            try {
               _hLAinteger32BEEncoder.setValue(parameters.getComType());
               nameValueMap.put("comType",
                                _hLAinteger32BEEncoder.toByteArray(),
                                false);
            } catch (Throwable t) {
               _hlaWorld.postException(new HlaDecodeException("Failed to encode comType", t));
            }
         }
         if (parameters.hasTransactionID()) {
            try {
               _hLAinteger64BEEncoder.setValue(parameters.getTransactionID());
               nameValueMap.put("transactionID",
                                _hLAinteger64BEEncoder.toByteArray(),
                                false);
            } catch (Throwable t) {
               _hlaWorld.postException(new HlaDecodeException("Failed to encode transactionID", t));
            }
         }
      }

      _interactionManager.sendInteraction(handle, nameValueMap, hlaTimeStamp, hlaLogicalTime);

      fireRequestInteraction(
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
         case RESPONSE: {
            receiveResponse(parameters, hlaTimeStamp, logicalTime, producingFederate);
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

   private void receiveResponse(NameValueMap parameters, HlaTimeStamp hlaTimeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      HlaResponseInteractionImpl interaction = getHlaResponseInteraction();
      byte[] interactionData;
      interactionData = parameters.get("Path");
      if (interactionData != null) {
         try {
            _nodeArrayEncoderDecoder.decode(interactionData);
            interaction.setPath(_nodeArrayEncoderDecoder.getValue());

            if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _nodeArrayEncoderDecoder.getEncodedLength() != interactionData.length) {
               _hlaWorld.postException(
                  new HlaDecodeException("Failed to decode Path. " +
                                         "Invalid data length " + interactionData.length + ", expected " + _nodeArrayEncoderDecoder.getEncodedLength(),
                                         interactionData));
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode Path", interactionData, t));
         }
      }

      interactionData = parameters.get("transactionID");
      if (interactionData != null) {
         try {
            _hLAinteger64BEDecoder.decode(interactionData);
            interaction.setTransactionID(_hLAinteger64BEDecoder.getValue());

            if (HlaTuning.VERIFY_RECEIVED_DATA_LENGTH && _hLAinteger64BEDecoder.getEncodedLength() != interactionData.length) {
               _hlaWorld.postException(
                  new HlaDecodeException("Failed to decode transactionID. " +
                                         "Invalid data length " + interactionData.length + ", expected " + _hLAinteger64BEDecoder.getEncodedLength(),
                                         interactionData));
            }
         } catch (Throwable t) {
            _hlaWorld.postException(new HlaDecodeException("Failed to decode transactionID", interactionData, t));
         }
      }

      fireResponseInteraction(
         false,
         interaction.build(producingFederate),
         hlaTimeStamp,
         logicalTime
      );
   }


   private void fireRequestInteraction(
      final boolean local,
      final HlaRequestParameters parameters,
      final HlaTimeStamp hlaTimeStamp,
      final HlaLogicalTime hlaLogicalTime
   ) {
      for (final HlaInteractionListener listener : _listeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               listener.request(
                  local,
                  parameters,
                  hlaTimeStamp,
                  hlaLogicalTime
               );
            }
         });
      }
   }

   private void fireResponseInteraction(
      final boolean local,
      final HlaResponseParameters parameters,
      final HlaTimeStamp hlaTimeStamp,
      final HlaLogicalTime hlaLogicalTime
   ) {
      for (final HlaInteractionListener listener : _listeners) {
         _hlaWorld.postNotification(new Runnable() {
            public void run() {
               listener.response(
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
