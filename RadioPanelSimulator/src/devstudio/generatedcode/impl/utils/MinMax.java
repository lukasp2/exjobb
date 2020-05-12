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

public final class MinMax<T> {
   public final T _min;
   public final T _max;

   private MinMax(T min, T max) {
      _min = min;
      _max = max;
   }

   public static <T> MinMax<T> create(T min, T max) {
      return new MinMax<T>(min, max);
   }
}
