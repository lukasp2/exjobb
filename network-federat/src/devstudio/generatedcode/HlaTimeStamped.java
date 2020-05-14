package devstudio.generatedcode;

/*
 * DO NOT EDIT!
 * 
 * Automatically generated source code by Pitch Developer Studio
 * Licensed to LP Internal Development 2020
 *
 * Copyright (C) 2006-2020 Pitch Technologies AB. All rights reserved.
 * Use is subject to license terms.
 */


/**
 * A timestamp associated with a value. 
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public interface HlaTimeStamped<T> {

   /**
    * Get the value associated with the timestamp.
    *
    * @return The value associated with the timestamp.
    */
   T getValue();

   /**
   * Get the timestamp associated with the value.
   *
   * @return The timestamp associated with the value.
    */
   HlaTimeStamp getTimeStamp();

   /**
   * Get the logical time associated with the value.
   *
   * @return The logical time associated with the value.
    */
   HlaLogicalTime getLogicalTime();
}
