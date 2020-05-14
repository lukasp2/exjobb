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
final class HlaNETNGroundVehicleManagerImpl extends AbstractObjectClassManager implements HlaNETNGroundVehicleManager {

   private static final String HLA_OBJECT_CLASS_NAME = "HLAobjectRoot.BaseEntity.PhysicalEntity.Platform.GroundVehicle.NETN_GroundVehicle";

   private final ObjectManager _objectManager;
   private final HlaWorldImpl _worldImpl;
   private final Object _localCreationInProgressLock = new Object();

   private volatile boolean _enabled = true;
   private volatile boolean _optional = false;
   private ObjectClassHandle _objectClassHandle = null;

   private final Map<String, HlaNETNGroundVehicleImpl> _hlaInstanceNameMap =  new ConcurrentHashMap<String, HlaNETNGroundVehicleImpl>();
   private final Map<ByteBuffer, HlaNETNGroundVehicleImpl>  _encodedHlaInstanceHandleMap =   new ConcurrentHashMap<ByteBuffer, HlaNETNGroundVehicleImpl>();
   private final Map<ObjectInstanceHandle, HlaNETNGroundVehicleImpl> _localInstances =
         new ConcurrentHashMap<ObjectInstanceHandle, HlaNETNGroundVehicleImpl>();
   private final Map<ObjectInstanceHandle, HlaNETNGroundVehicleImpl> _remoteInstances =
         new ConcurrentHashMap<ObjectInstanceHandle, HlaNETNGroundVehicleImpl>();

   private final Set<HlaNETNGroundVehicleManagerListener> _listeners =
         new CopyOnWriteArraySet<HlaNETNGroundVehicleManagerListener>();

   private final Set<HlaNETNGroundVehicleValueListener> _defaultInstanceValueListeners =
         new CopyOnWriteArraySet<HlaNETNGroundVehicleValueListener>();
   private final Set<HlaNETNGroundVehicleListener> _defaultInstanceListeners =
         new CopyOnWriteArraySet<HlaNETNGroundVehicleListener>();

   /*
    * Share encoders and decoders for HlaNETNGroundVehicleImpl
    */
   protected final Object _encodersLock = new Object();
   protected final Object _decodersLock = new Object();

   HlaNETNGroundVehicleManagerImpl(HlaWorldImpl world, ObjectManager objectManager) {
      _objectManager = objectManager;
      _worldImpl = world;

      _objectManager.addManager(this, HLA_OBJECT_CLASS_NAME);
   }

   /*
    * HlaNETNGroundVehicleManager interface impl
    */

   public List<HlaNETNGroundVehicle> getHlaNETNGroundVehicles() {
      return getAllHlaNETNGroundVehicles();
   }

   public List<HlaNETNGroundVehicle> getAllHlaNETNGroundVehicles() {
      List<HlaNETNGroundVehicle> list = new ArrayList<HlaNETNGroundVehicle>(_localInstances.size() + _remoteInstances.size());
      list.addAll(_localInstances.values());
      list.addAll(_remoteInstances.values());
      return list;
   }

   public List<HlaNETNGroundVehicle> getLocalHlaNETNGroundVehicles() {
      return new ArrayList<HlaNETNGroundVehicle>(_localInstances.values());
   }

   public List<HlaNETNGroundVehicle> getRemoteHlaNETNGroundVehicles() {
      return new ArrayList<HlaNETNGroundVehicle>(_remoteInstances.values());
   }

   public HlaNETNGroundVehicleImpl getNETNGroundVehicleByHlaInstanceName(String hlaInstanceName) {
      return _hlaInstanceNameMap.get(hlaInstanceName);
   }

   public HlaNETNGroundVehicle getNETNGroundVehicleByHlaInstanceHandle(byte[] encodedHlaInstanceHandle) {
      return _encodedHlaInstanceHandleMap.get(ByteBuffer.wrap(encodedHlaInstanceHandle));
   }

   public HlaNETNGroundVehicle createLocalHlaNETNGroundVehicle(
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


   public HlaNETNGroundVehicle createLocalHlaNETNGroundVehicle(
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


   private HlaNETNGroundVehicle createLocalInstance(
      String hlaInstanceName
   ) throws HlaInstanceNameInUseException, HlaNotConnectedException, HlaInternalException, HlaRtiException,
            HlaSaveInProgressException, HlaRestoreInProgressException {

      HlaNETNGroundVehicleImpl instance;
      synchronized (_localCreationInProgressLock) {
         ObjectInstanceHandle objectInstanceHandle = _objectManager.createObjectInstance(_objectClassHandle, hlaInstanceName);
         instance = createObjectInstance(objectInstanceHandle, true, _worldImpl.getFederateId());
         _localInstances.put(objectInstanceHandle, instance);
         _hlaInstanceNameMap.put(instance.getHlaInstanceName(), instance);
         _encodedHlaInstanceHandleMap.put(ByteBuffer.wrap(instance.getEncodedHlaObjectInstanceHandle()), instance);
      }

      HlaTimeStamp timeStamp = _worldImpl.getCurrentTime();
      fireDiscovered(instance, timeStamp);

      for (HlaNETNGroundVehicleListener instanceListener : _defaultInstanceListeners) {
         instance.addHlaNETNGroundVehicleListener(instanceListener);
      }
      for (HlaNETNGroundVehicleValueListener instanceValueListener : _defaultInstanceValueListeners) {
         instance.addHlaNETNGroundVehicleValueListener(instanceValueListener);
      }

      checkInitializedFired(instance, timeStamp, HlaLogicalTimeImpl.INVALID);

      return instance;
   }

   public HlaNETNGroundVehicle deleteLocalHlaNETNGroundVehicle(HlaNETNGroundVehicle instance)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      try {
         return deleteHlaNETNGroundVehicle(instance, _worldImpl.getCurrentTime(), _worldImpl.getDefaultSendTime(), true);
      } catch (HlaInvalidLogicalTimeException e) {
         throw new HlaInternalException("Failed to delete instance with default Logical Time", e);
      }
   }

   public HlaNETNGroundVehicle deleteLocalHlaNETNGroundVehicle(HlaNETNGroundVehicle instance, HlaTimeStamp timestamp)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      try {
         return deleteHlaNETNGroundVehicle(instance, timestamp, _worldImpl.getDefaultSendTime(), true);
      } catch (HlaInvalidLogicalTimeException e) {
         throw new HlaInternalException("Failed to delete instance with default Logical Time", e);
      }
   }

   public HlaNETNGroundVehicle deleteLocalHlaNETNGroundVehicle(HlaNETNGroundVehicle instance, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      return deleteHlaNETNGroundVehicle(instance, _worldImpl.getCurrentTime(), logicalTime, true);
   }

   public HlaNETNGroundVehicle deleteLocalHlaNETNGroundVehicle(HlaNETNGroundVehicle instance, HlaTimeStamp timestamp, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      return deleteHlaNETNGroundVehicle(instance, timestamp, logicalTime, true);
   }

   private HlaNETNGroundVehicle deleteHlaNETNGroundVehicle(HlaNETNGroundVehicle instance, HlaTimeStamp timestamp, HlaLogicalTime logicalTime, boolean checkLocal)
         throws HlaNotConnectedException, HlaInvalidLogicalTimeException, HlaInternalException, HlaRtiException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      if (instance.isRemoved() || (checkLocal && !instance.isLocal())) {
         return null;
      }

      HlaNETNGroundVehicleImpl instanceImpl = (HlaNETNGroundVehicleImpl) instance;
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

   public void addHlaNETNGroundVehicleManagerListener(HlaNETNGroundVehicleManagerListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.add(listener);
   }

   public void removeHlaNETNGroundVehicleManagerListener(HlaNETNGroundVehicleManagerListener listener) {
       if (listener == null) {
           throw new NullPointerException();
       }
      _listeners.remove(listener);
   }


   public void addHlaNETNGroundVehicleDefaultInstanceListener(HlaNETNGroundVehicleListener listener) {
      if (listener == null) {
         throw new NullPointerException();
      }
      _defaultInstanceListeners.add(listener);
   }

   public void addHlaNETNGroundVehicleDefaultInstanceValueListener(HlaNETNGroundVehicleValueListener valueListener) {
      if (valueListener == null) {
         throw new NullPointerException();
      }
      _defaultInstanceValueListeners.add(valueListener);
   }

   public void removeHlaNETNGroundVehicleDefaultInstanceListener(HlaNETNGroundVehicleListener listener) {
      if (listener == null) {
         throw new NullPointerException();
      }
      _defaultInstanceListeners.remove(listener);
   }

   public void removeHlaNETNGroundVehicleDefaultInstanceValueListener(HlaNETNGroundVehicleValueListener valueListener) {
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
      final HlaNETNGroundVehicleImpl instance = createObjectInstance(objectInstanceHandle, false, producingFederate);
      _remoteInstances.put(objectInstanceHandle, instance);
      _hlaInstanceNameMap.put(instance.getHlaInstanceName(), instance);
      _encodedHlaInstanceHandleMap.put(ByteBuffer.wrap(instance.getEncodedHlaObjectInstanceHandle()), instance);
      fireDiscovered(instance, timeStamp);

      for (HlaNETNGroundVehicleListener listener : _defaultInstanceListeners) {
         instance.addHlaNETNGroundVehicleListener(listener);
      }
      for (HlaNETNGroundVehicleValueListener listener : _defaultInstanceValueListeners) {
         instance.addHlaNETNGroundVehicleValueListener(listener);
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
      HlaNETNGroundVehicleImpl instance = _remoteInstances.get(objectInstanceHandle);
      if (instance != null) {
         instance.reflectAttributeValues(attributes, timeStamp, logicalTime, producingFederate);
         checkInitializedFired(instance, timeStamp, logicalTime);
      } else {
         _worldImpl.postException(new HlaInternalException("Get reflect for an unknown instance: " + objectInstanceHandle));
      }
   }

   @Override
   public void removeObjectInstance(ObjectInstanceHandle objectInstanceHandle, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
      HlaNETNGroundVehicleImpl instance = _remoteInstances.remove(objectInstanceHandle);

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

      _objectManager.publish(_objectClassHandle, HlaNETNGroundVehicleImpl.HLA_ATTRIBUTE_NAMES);
      _objectManager.subscribe(_objectClassHandle, HlaNETNGroundVehicleImpl.HLA_ATTRIBUTE_NAMES);
   }

   private void clearAllInstances(boolean doFireDeleted) {
      HlaTimeStamp timeStamp = _worldImpl.getCurrentTime();

      for (Iterator<HlaNETNGroundVehicleImpl> iterator = MapAdapter.concat(_localInstances.values().iterator(), _remoteInstances.values().iterator()); iterator.hasNext();) {
         HlaNETNGroundVehicleImpl instance = iterator.next();
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
      HlaNETNGroundVehicleImpl instance;
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
    * Functions called from HlaNETNGroundVehicleImpl
    */

   void updateAttributeValues(HlaNETNGroundVehicleImpl instance, ObjectInstanceHandle objectInstanceHandle, NameValueMap attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime)
         throws HlaNotConnectedException, HlaInternalException, HlaRtiException, HlaAttributeNotOwnedException, HlaObjectInstanceIsRemovedException, HlaInvalidLogicalTimeException,
                HlaSaveInProgressException, HlaRestoreInProgressException {
      _objectManager.updateAttributeValues(objectInstanceHandle, attributes, timeStamp, logicalTime);

      checkInitializedFired(instance, timeStamp, logicalTime);
   }


   /*
    * Private helpers...
    */

   private HlaNETNGroundVehicleImpl createObjectInstance(ObjectInstanceHandle objectInstanceHandle, boolean isLocal, HlaFederateId producingFederate) {
      return new HlaNETNGroundVehicleImpl(_worldImpl, this, objectInstanceHandle, isLocal, producingFederate);
   }

   private void checkInitializedFired(HlaNETNGroundVehicleImpl instance, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
      if (!instance.isInitializedFired() && instance.isInitialized()) {
         instance.setInitializedFired();
         fireInitialized(instance, timeStamp, logicalTime);
      }
   }

   private void fireDiscovered(final HlaNETNGroundVehicle instance, final HlaTimeStamp timeStamp) {
      for (final HlaNETNGroundVehicleManagerListener listener : _listeners) {
         _worldImpl.postNotification(new Runnable() {
            public void run() {
               listener.hlaNETNGroundVehicleDiscovered(instance, timeStamp);
            }
         });
      }
   }

   private void fireDeleted(final HlaNETNGroundVehicle instance, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      for (final HlaNETNGroundVehicleManagerListener listener : _listeners) {
         _worldImpl.postNotification(new Runnable() {
            public void run() {
               listener.hlaNETNGroundVehicleDeleted(instance, timeStamp, logicalTime);
            }
         });
      }
   }

   private void fireInitialized(final HlaNETNGroundVehicle instance, final HlaTimeStamp timeStamp, final HlaLogicalTime logicalTime) {
      for (final HlaNETNGroundVehicleManagerListener listener : _listeners) {
         _worldImpl.postNotification(new Runnable() {
            public void run() {
               listener.hlaNETNGroundVehicleInitialized(instance, timeStamp, logicalTime);
            }
         });
      }
   }
}
