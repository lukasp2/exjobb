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

import java.util.HashMap;
import java.util.Map;

final class PersistentHelper<T extends PersistentHelper.State> {

   /** Marker interface for all savable state. */
   public interface State {
   }

   private final Map<String, T> _persistentState = new HashMap<String, T>();

   public boolean saveState(String label, T state) {
      _persistentState.put(label, state);
      return true;
   }

   public T loadState(String label) {
      return _persistentState.get(label);
   }

   public void clear() {
      _persistentState.clear();
   }
}
