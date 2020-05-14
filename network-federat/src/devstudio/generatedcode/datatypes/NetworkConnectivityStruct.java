package devstudio.generatedcode.datatypes;

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
 * Implementation of the <code>NetworkConnectivityStruct</code> data type from the FOM.
 * <br>Description from the FOM: <i>Describes the connectivity status between a sender and a receiver entity. 
The state of this communication link is decribed in percentage of the probability of having a connection: 0% if there is no connectivity. 100% if there is maximum connectivity available.</i>
 * <p>
 * This class is <code>Immutable</code> (and therefore <code>ThreadSafe</code>)
 * as defined by <i>Java Concurrency in Practice</i>,
 * see <a href="http://jcip.net/annotations/doc/net/jcip/annotations/package-summary.html">jcip.net</a>.
 */
public final class NetworkConnectivityStruct {

   /**
    * The value of the Sender field.
    * <br>FOM name: <code>Sender</code>.
    * <br>Description from the FOM: <i>Uniquie Id of the sending entity/unit</i>
    */
    public final byte[/* 16 */] sender;
   /**
    * The value of the Receiver field.
    * <br>FOM name: <code>Receiver</code>.
    * <br>Description from the FOM: <i>Unique Id of the receiving entity/unit</i>
    */
    public final byte[/* 16 */] receiver;
   /**
    * The value of the NetworkState field.
    * <br>FOM name: <code>NetworkState</code>.
    * <br>Description from the FOM: <i>Percentage decribing the probability of having a connection: 0% if there is no connectivity. 100% if there is maximum connectivity available.</i>
    */
    public final float networkState;

    private NetworkConnectivityStruct(
        byte[/* 16 */] sender,
        byte[/* 16 */] receiver,
        float networkState
    ) {
        this.sender = sender;
        this.receiver = receiver;
        this.networkState = networkState;
    }

   /**
    * Create a new NetworkConnectivityStruct.
    *
    * @param sender value of the Sender field
    * <br>Description from the FOM: <i>Uniquie Id of the sending entity/unit</i>
    * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
    * @param receiver value of the Receiver field
    * <br>Description from the FOM: <i>Unique Id of the receiving entity/unit</i>
    * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
    * @param networkState value of the NetworkState field
    * <br>Description from the FOM: <i>Percentage decribing the probability of having a connection: 0% if there is no connectivity. 100% if there is maximum connectivity available.</i>
    * <br>Description of the data type from the FOM: <i>Percentage [unit: percent (%), resolution: NA, accuracy: NA]</i>
    *
    * @return a new NetworkConnectivityStruct
    */
    public static NetworkConnectivityStruct create(
        byte[/* 16 */] sender,
        byte[/* 16 */] receiver,
        float networkState
    ) {
        if (sender == null) {
            throw new NullPointerException("sender can not be null");
        }
        if (receiver == null) {
            throw new NullPointerException("receiver can not be null");
        }

        return new NetworkConnectivityStruct(
           sender,
           receiver,
           networkState
        );
    }

   /**
    * Get the value of the Sender field.
    * <br>FOM name: <code>Sender</code>.
    * <br>Description from the FOM: <i>Uniquie Id of the sending entity/unit</i>
    * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
    *
    * @return the value of the Sender field
    */
    public byte[/* 16 */] getSender() {
        return sender;
    }

   /**
    * Get the value of the Receiver field.
    * <br>FOM name: <code>Receiver</code>.
    * <br>Description from the FOM: <i>Unique Id of the receiving entity/unit</i>
    * <br>Description of the data type from the FOM: <i>16 bytes in the UUID. 
A universally unique identifier (UUID), standardized by the Open Software Foundation (OSF) as part of the Distributed Computing Environment (DCE). 
A UUID is a 16-byte (128-bit) number. In its canonical form, a UUID is represented by 32 hexadecimal digits, displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 digits and four hyphens). For example: 
550e8400-e29b-41d4-a716-446655440000</i>
    *
    * @return the value of the Receiver field
    */
    public byte[/* 16 */] getReceiver() {
        return receiver;
    }

   /**
    * Get the value of the NetworkState field.
    * <br>FOM name: <code>NetworkState</code>.
    * <br>Description from the FOM: <i>Percentage decribing the probability of having a connection: 0% if there is no connectivity. 100% if there is maximum connectivity available.</i>
    * <br>Description of the data type from the FOM: <i>Percentage [unit: percent (%), resolution: NA, accuracy: NA]</i>
    *
    * @return the value of the NetworkState field
    */
    public float getNetworkState() {
        return networkState;
    }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || getClass() != object.getClass()) {
         return false;
      }

      NetworkConnectivityStruct other = (NetworkConnectivityStruct)object;

      return new EqualsBuilder()
            .append(sender, other.sender)
            .append(receiver, other.receiver)
            .append(networkState, other.networkState)
            .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder()
            .append(sender)
            .append(receiver)
            .append(networkState)
            .toHashCode();
   }

   @Override
   public String toString() {
      return new ToStringBuilder(this)
            .append("sender", sender)
            .append("receiver", receiver)
            .append("networkState", networkState)
            .getToString();
   }
}