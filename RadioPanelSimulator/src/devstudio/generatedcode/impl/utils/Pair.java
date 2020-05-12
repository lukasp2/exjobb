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


public final class Pair<X, Y> {
   private final X _first;
   private final Y _second;

   public Pair(X first, Y second) {
      _first = first;
      _second = second;
   }

   public X getFirst() {
      return _first;
   }

   public Y getSecond() {
      return _second;
   }

   public static <X, Y> Pair<X, Y> create(X first, Y second) {
      return new Pair<X, Y>(first, second);
   }

   @SuppressWarnings ({ "RedundantIfStatement" })
   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }

      final Pair pair = (Pair)o;

      if (_first != null ? !_first.equals(pair._first) : pair._first != null) {
         return false;
      }
      if (_second != null ? !_second.equals(pair._second) : pair._second != null) {
         return false;
      }

      return true;
   }

   @Override
   public int hashCode() {
      int result;
      result = (_first != null ? _first.hashCode() : 0);
      result = 29 * result + (_second != null ? _second.hashCode() : 0);
      return result;
   }
}
