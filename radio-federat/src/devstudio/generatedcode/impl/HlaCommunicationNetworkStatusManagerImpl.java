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

import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.impl.fed.AbstractObjectClassManager;
import devstudio.generatedcode.impl.fed.ObjectManager;
import devstudio.generatedcode.impl.utils.*;

import se.pitch.ral.api.ObjectInstanceHandle;
import se.pitch.ral.api.ObjectClassHandle;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;


/* @ThreadSafe */
final class HlaCommunicationNetworkStatusManagerImpl extends AbstractObjectClassManager implements HlaCommunicationNetworkStatusManager {

   private static final String HLA_OBJECT_CLASS_NAME = "HLAobjectRoot.Communication.CommunicationNetworkStatus";

   private final ObjectManager _objectManager;
   private final HlaWorldImpl _worldImpl;
   private final Object _localCreationInProgressLock = new Object();

   private volatile boolean _enabled = true;
   private volatile boolean _optional = false;
   private ObjectClassHandle _objectClassHandle = null;

   private final Map<String, HlaCommunicationNetworkStatusImpl> _hlaInstanceNameMap =  new ConcurrentHashMap<String, HlaCommunicationNetworkStatusImpl>();
   private final Map<ByteBuffer, HlaCommunicationNetworkStatusImpl>  _encodedHlaInstanceHandleMap =   new ConcurrentHashMap<ByteBuffer, HlaCommunicationNetworkStatusImpl>();
   private final Map<ObjectInstanceHandle, HlaCommunicationNetworkStatusImpl> _localInstances =
         new ConcurrentHashMap<ObjectInstanceHandle, HlaCommunicationNetworkStatusImpl>();
   private final Map<ObjectInstanceHandle, HlaCommunicationNetworkStatusImpl> _remoteInstances =
         new ConcurrentHashMap<ObjectInstanceHandle, HlaCommunicationNetworkStatusImpl>();

   private final Set<HlaCommunicationNetworkStatusManagerListener> _listeners =
         new CopyOnWriteArraySet<HlaCommunicationNetworkStatusManagerListener>();

   private final Set<HlaCommunicationNetworkStatusValueListener> _defaultInstanceValueListeners =
         new CopyOnWriteArraySet<HlaCommunicationNetworkStatusValueListener>();
   private final Set<HlaCommunicationNetworkStatusListener> _defaultInstanceListeners =
         new CopyOnWriteArraySet<HlaCommunicationNetworkStatusListener>();

   /*
    * Share encoders and decoders for HlaCommunicationNetworkStatusImpl
    */
   protected final Object _encodersLock = new Object();
   protected final Object _decodersLock = new Object();

   HlaCommunicationNetworkStatusManagerImpl(HlaWorldImpl world, ObjectManager objectManager) {
      _objectManager = objectManager;
      _worldImpl = world;

      _objectManager.addManager(this, HLA_OBJECT_CLASS_NAME);
   }

   /*
    * HlaCommunicationNetworkStatusManager interface impl
    */

   public List<HlaCommunicationNetworkStatus> getHlaCommunicationNetworkStatus() {
      return getAllHlaCommunicationNetworkStatus();
   }

   public List<HlaCommunicationNetworkStatus> getAllHlaCommunicationNetworkStatus() {
      List<HlaCommunicationNetworkStatus> list = new ArrayList<HlaCommunicationNetworkStatus>(_localInstances.size() + _remoteInstances.size());
      list.addAll(_localInstances.values());
      list.addAll(_remoteInstances.values());
      return list;
   }

   public List<HlaCommunicationNetworkStatus> getLocalHlaCommunicationNetworkStatus() {
      return new ArrayList<HlaCommunicationNetworkStatus>(_localInstances.values());
   }

   public List<HlaCommunicationNetworkStatus> getRemoteHlaCommunicationNetworkStatus() {
      return new ArrayList<HlaCommunicationNetworkStatus>(_remoteInstances.values());
   }

   public HlaCommunicationNetworkStatusImpl getCommunicationNetworkStatusByHlaInstanceName(String hlaInstanceName) {
      return _hlaInstanceNameMap.get(hlaInstanceName);
   }

   public HlaCommunicationNetworkStatus getCommunicationNetworkStatusByHlaInstanceHandle(byte[] encodedHlaInstanceHandle) {
      return _encodedHlaInstanceHandleMap.get(ByteBuffer.wrap(encodedHlaInstanceHandle));
   }

   public HlaCommunicationNetworkStatus createLocalHlaCommunicationNetworkStatus(
   ) throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      if (_objectClassHandle == null) {
         throw new HlaNotConnectedException("Not connected");
      }

      try {
         return createLocalInstance(
            null
         );
      } catch (HlaInstanceNameInUseException e) {
         //can not happen with null hlaInstanceName
         return null;
      }
   }


   public HlaCommunicationNetworkStatus createLocalHlaCommunicationNetworkStatus(
      String hlaInstanceName
   ) throws HlaIllegalInstanceNameException, HlaInstanceNameInUseException,
            HlaNotConnectedException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {
      if (_objectClassHandle == null) {
         throw new HlaNotConnectedException("Not connected");
      }

      //Silently ignore if we could not register object instance name, we might have registered it before
      _objectManager.registerObjectInstanceName(hlaInstanceName);

      return createLocalInstance(
         hlaInstanceName
      );
   }


   private HlaCommunicationNetworkStatus createLocalInstance(
      String hlaInstanceName
   ) throws HlaInstanceNameInUseException, HlaNotConnectedException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {

      HlaCommunicationNetworkStatusImpl instance;
      synchronized (_localCreationInProgressLock) {
         ObjectInstanceHandle objectInstanceHandle = _objectManager.createObjectInstance(_objectClassHandle, hlaInstanceName);
         instance = createObjectInstance(objectInstanceHandle, true, _worldImpl.getFederateId());
         _localInstances.put(objectInstanceHandle, instance);
         _hlaInstanceNameMap.put(instance.getHlaInstanceName(), instance);
         _encodedHlaInstanceHandleMap.put(ByteBuffer.wrap(instance.getEncodedHlaObjectInstanceHandle()), instance);
      }

      HlaTimeStamp timeStamp = _worldImpl.getCurrentTime();
      fireDiscovered(instance, timeStamp);

      for (HlaCommunicationNetworkStatusListener instanceListener : _defaultInstanceListeners) {
         instance.addHlaCommunicationNetworkStatusListener(instanceListener);
      }
      for (HlaCommunicationNetworkStatusValueListener instanceValueListener : _defaultInstanceValueListeners) {
         instance.addHlaCommunicationNetworkStatusValueListener(instanceValueListener);
      }

      checkInitializedFired(instance, timeStamp, HlaLogicalTimeImpl.INVALID);

      return instance;
   }

   public HlaCommunicationNetworkStatus deleteLocalHlaCommunicationNetworkStatus(HlaCommunicationNetworkStatus instance)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      try {
         return deleteHlaCommunicationNetworkStatus(instance, _worldImpl.getCurrentTime(), _worldImpl.getDefaultSendTime(), true);
      } catch (HlaInvalidLogicalTimeException e) {
         throw new HlaInternalException("Failed to delete instance with default Logical Time", e);
      }
   }

   public HlaCommunicationNetworkStatus deleteLocalHlaCommunicationNetworkStatus(HlaCommunicationNetworkStatus instance, HlaTimeStamp timestamp)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      try {
         return deleteHlaCommunicationNetworkStatus(instance, timestamp, _worldImpl.getDefaultSendTime(), true);
      } catch (HlaInvalidLogicalTimeException e) {
         throw new HlaInternalException("Failed to delete instance with default Logical Time", e);
      }
   }

   public HlaCommunicationNetworkStatus deleteLocalHlaCommunicationNetworkStatus(HlaCommunicationNetworkStatus instance, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      return deleteHlaCommunicationNetworkStatus(instance, _worldImpl.getCurrentTime(), logicalTime, true);
   }

   public HlaCommunicationNetworkStatus deleteLocalHlaCommunicationNetworkStatus(HlaCommunicationNetworkStatus instance, HlaTimeStamp timestamp, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      return deleteHlaCommunicationNetworkStatus(instance, timestamp, logicalTime, true);
   }

   private HlaCommunicationNetworkStatus deleteHlaCommunicationNetworkStatus(HlaCommunicationNetworkStatus instance, HlaTimeStamp timestamp, HlaLogicalTime logicalTime, boolean checkLocal)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      if (instance.isRemoved() || (checkLocal && !instance.isLocal())) {
         return null;
      }

      HlaCommunicationNetworkStatusImpl instanceImpl = (HlaCommunicationNetworkStatusImpl) instance;
      ObjectInstanceHandle instanceHandle = instanceImpl.getObjectInstanceHandle();

      _objectManager.deleteObjectInstance(instanceHandle, timestamp, logicalTime);

      _hlaInstanceNameMap.remove(instance.getHlaInstanceName());
      _encodedHlaInstanceHandleMap.remove(ByteBuffer.wrap(instance.getEncodedHlaObjectInstanceHandle()));

      if (instance.isLocal()) {
         _localInstances.remove(instanceHandle);
      } else {
         _remoteInstances.remove(instanceHandle);
      }
      instanceImpl.setRemoved();
      fireDeleted(instance, timestamp, logicalTime);

      return instance;
   }

   public void addHlaCommunicationNetworkStatusManagerListener(HlaCommunicationNetworkStatusManagerListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.add(listener);
   }

   public void removeHlaCommunicationNetworkStatusManagerListener(HlaCommunicationNetworkStatusManagerListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.remove(listener);
   }


   public void addHlaCommunicationNetworkStatusDefaultInstanceListener(HlaCommunicationNetworkStatusListener listener) {
      if (listener == null) {
         throw new NullPointerException();
      }
      _defaultInstanceListeners.add(listener);
   }

   public void addHlaCommunicationNetworkStatusDefaultInstanceValueListener(HlaCommunicationNetworkStatusValueListener valueListener) {
      if (valueListener == null) {
         throw new NullPointerException();
      }
      _defaultInstanceValueListeners.add(valueListener);
   }

   public void removeHlaCommunicationNetworkStatusDefaultInstanceListener(HlaCommunicationNetworkStatusListener listener) {
      if (listener == null) {
         throw new NullPointerException();
      }
      _defaultInstanceListeners.remove(listener);
   }

   public void removeHlaCommunicationNetworkStatusDefaultInstanceValueListener(HlaCommunicationNetworkStatusValueListener valueListener) {
      if (valueListener == null) {
         throw new NullPointerException();
      }
      _defaultInstanceValueListeners.remove(valueListener);
   }

   public void setEnabled(boolean enabled) {
      _optional = false;
      _enabled = enabled;
   }

   public void setEnabledIfAvailableInFom() {
      _optional = true;
      _enabled = true;
   }

   public boolean isEnabled() {
      return _objectClassHandle != null;
   }

   /*
    * AbstractObjectClassManager impl
    */

   @Override
   public void discoverObjectInstance(final ObjectInstanceHandle objectInstanceHandle, String instanceName, HlaTimeStamp timeStamp, HlaFederateId producingFederate) {
      final HlaCommunicationNetworkStatusImpl instance = createObjectInstance(objectInstanceHandle, false, producingFederate);
      _remoteInstances.put(objectInstanceHandle, instance);
      _hlaInstanceNameMap.put(instance.getHlaInstanceName(), instance);
      _encodedHlaInstanceHandleMap.put(ByteBuffer.wrap(instance.getEncodedHlaObjectInstanceHandle()), instance);
      fireDiscovered(instance, timeStamp);

      for (HlaCommunicationNetworkStatusListener listener : _defaultInstanceListeners) {
         instance.addHlaCommunicationNetworkStatusListener(listener);
      }
      for (HlaCommunicationNetworkStatusValueListener listener : _defaultInstanceValueListeners) {
         instance.addHlaCommunicationNetworkStatusValueListener(listener);
      }

      checkInitializedFired(instance, timeStamp, HlaLogicalTimeImpl.INVALID);

      if (HlaTuning.REQUEST) {
         _worldImpl.invokeDelay(HlaTuning.REQUEST_MIN_DELAY_MS, HlaTuning.REQUEST_MAX_DELAY_MS, new Runnable() {
            public void run() {
               if (!instance.isRemoved()) {
                  Set<String> unsetAttributes = instance.getUnsetAttributeNames();
                  if (!unsetAttributes.isEmpty()) {
                     try {
                        _objectManager.requestAttributeValueUpdate(objectInstanceHandle, unsetAttributes, _worldImpl.getCurrentTime());
                     } catch (HlaBaseException e) {
                        //ignore
                     } catch (HlaBaseRuntimeException e) {
                        //ignore
                     }
                  }
               }
            }
         });
      }
   }

   @Override
   public void reflectAttributeValues(ObjectInstanceHandle objectInstanceHandle, NameValueMap attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime, HlaFederateId producingFederate) {
      HlaCommunicationNetworkStatusImpl instance = _remoteInstances.get(objectInstanceHandle);
      if (instance != null) {
         instance.reflectAttributeValues(attributes, timeStamp, logicalTime, producingFederate);
         checkInitializedFired(instance, timeStamp, logicalTime);
      } else {
         _worldImpl.postException(new HlaInternalException("Get reflect for an unknown instance: " + objectInstanceHandle));
      }
   }

   @Override
   public void removeObjectInstance(ObjectInstanceHandle objectInstanceHandle, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
      HlaCommunicationNetworkStatusImpl instance = _remoteInstances.remove(objectInstanceHandle);

      if (instance != null) {
         _hlaInstanceNameMap.remove(instance.getHlaInstanceName());
         _encodedHlaInstanceHandleMap.remove(ByteBuffer.wrap(instance.getEncodedHlaObjectInstanceHandle()));
         instance.setRemoved();
         fireDeleted(instance, timeStamp, logicalTime);
      } else {
         _worldImpl.postException(new HlaInternalException("Get remove for an unknown instance: " + objectInstanceHandle));
      }
   }

   @Override
   public boolean isEnabled(String objectClassName) {
      return _enabled;
   }

   @Override
   public boolean isOptional(String objectClassName) {
      return _optional;
   }

   @Override
   public void connected(ObjectClassHandle objectClassHandle, String objectClassName)
         throws HlaNotConnectedException, HlaFomException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      _objectClassHandle = objectClassHandle;

      _objectManager.publish(_objectClassHandle, HlaCommunicationNetworkStatusImpl.HLA_ATTRIBUTE_NAMES);
      _objectManager.subscribe(_objectClassHandle, HlaCommunicationNetworkStatusImpl.HLA_ATTRIBUTE_NAMES);
   }

   private void clearAllInstances(boolean doFireDeleted) {
      HlaTimeStamp timeStamp = _worldImpl.getCurrentTime();

      for (Iterator<HlaCommunicationNetworkStatusImpl> iterator = MapAdapter.concat(_localInstances.values().iterator(), _remoteInstances.values().iterator()); iterator.hasNext();) {
         HlaCommunicationNetworkStatusImpl instance = iterator.next();
         iterator.remove();
         instance.setRemoved();
         if (doFireDeleted) {
            fireDeleted(instance, timeStamp, HlaLogicalTimeImpl.INVALID);
         }
      }
      _hlaInstanceNameMap.clear();
      _encodedHlaInstanceHandleMap.clear();
   }

   @Override
   public void disconnected(ObjectClassHandle objectClassHandle) {
      _objectClassHandle = null;
      clearAllInstances(true);
   }

   @Override
   public void provideAttributeValueUpdate(ObjectInstanceHandle objectInstanceHandle, Set<String> attributes, HlaTimeStamp hlaTimeStamp) {
      HlaCommunicationNetworkStatusImpl instance;
      synchronized (_localCreationInProgressLock) {
         instance = _localInstances.get(objectInstanceHandle);
      }

      // instance may be null since provideAttributeValueUpdate is called on a separate thread
      if (instance != null) {
         instance.provideAttributeValueUpdate(attributes, hlaTimeStamp);
      }
   }

   @Override
   public void attributesInScope(ObjectInstanceHandle objectInstanceHandle, Set<String> attributes) {
   }

   @Override
   public void attributesOutOfScope(ObjectInstanceHandle objectInstanceHandle, Set<String> attributes) {
   }

   @Override
   public void save(ObjectClassHandle objectClassHandle) throws HlaSaveFederateException {
      if (!_localInstances.isEmpty()) {
         throw new HlaSaveFederateException("Unable to save local instances");
      }
      if (!_remoteInstances.isEmpty()) {
         throw new HlaSaveFederateException("Unable to save remote instances");
      }
   }

   @Override
   public void restore(ObjectClassHandle objectClassHandle) {
      clearAllInstances(false);
   }

   /*
    * Functions called from HlaCommunicationNetworkStatusImpl
    */

   void updateAttributeValues(HlaCommunicationNetworkStatusImpl instance, ObjectInstanceHandle objectInstanceHandle, NameValueMap attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException, HlaAttributeNotOwnedException, HlaObjectInstanceIsRemovedException, HlaInvalidLogicalTimeException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      _objectManager.updateAttributeValues(objectInstanceHandle, attributes, timeStamp, logicalTime);

      checkInitializedFired(instance, timeStamp, logicalTime);
   }


   /*
    * Private helpers...
    */

   private HlaCommunicationNetworkStatusImpl createObjectInstance(ObjectInstanceHandle objectInstanceHandle, boolean isLocal, HlaFederateId producingFederate) {
      return new HlaCommunicationNetworkStatusImpl(_worldImpl, this, objectInstanceHandle, isLocal, producingFederate);
   }

   private void checkInitializedFired(HlaCommunicationNetworkStatusImpl instance, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
      if (!instance.isInitializedFired() && instance.isInitialized()) {
         instance.setInitializedFired();
         fireInitialized(instance, timeStamp, logicalTime);
      }
   }

   private void fireDiscovered(final HlaCommunicationNetworkStatus instance, final HlaTimeStamp timeStamp) {
      for (final HlaCommunicationNetworkStatusManagerListener listener : _listeners) {
         _worldImpl.postNotification(new Runnable() {
            public void run() {
               listener.hlaCommunicationNetworkStatusDiscovered(instance, timeStamp);
            }
         });
      }
   }

   private void fireDeleted(final HlaCommunicationNetworkStatus instance, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      for (final HlaCommunicationNetworkStatusManagerListener listener : _listeners) {
         _worldImpl.postNotification(new Runnable() {
            public void run() {
               listener.hlaCommunicationNetworkStatusDeleted(instance, timeStamp, logicalTime);
            }
         });
      }
   }

   private void fireInitialized(final HlaCommunicationNetworkStatus instance, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      for (final HlaCommunicationNetworkStatusManagerListener listener : _listeners) {
         _worldImpl.postNotification(new Runnable() {
            public void run() {
               listener.hlaCommunicationNetworkStatusInitialized(instance, timeStamp, logicalTime);
            }
         });
      }
   }
}
