package devstudio.generatedcode.impl.utils;

/*
 * DO NOT EDIT!
 * 
 * Automatically generated source code by Pitch Developer Studio
 * Licensed to LP Internal Development 2020
 *
 * Copyright (C) 2006-2020 Pitch Technologies AB. All rights reserved.
 * Use is subject to license terms.
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public final class SetAdapter<V> {
   private final Set<V> _set;

   public SetAdapter(Set<V> set) {
      _set = set;
   }

   public SetAdapter() {
      _set = new HashSet<V>();
   }

   public SetAdapter<V> append(V value) {
      _set.add(value);
      return this;
   }

   public Set<V> unmodifiableSet() {
      return Collections.unmodifiableSet(_set);
   }
}
