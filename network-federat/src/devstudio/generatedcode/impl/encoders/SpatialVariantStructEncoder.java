package devstudio.generatedcode.impl.encoders;

/*
 * DO NOT EDIT!
 * 
 * Automatically generated source code by Pitch Developer Studio
 * Licensed to LP Internal Development 2020
 *
 * Copyright (C) 2006-2020 Pitch Technologies AB. All rights reserved.
 * Use is subject to license terms.
 */

import devstudio.generatedcode.datatypes.DeadReckoningAlgorithmEnum;
import devstudio.generatedcode.datatypes.SpatialVariantStruct;
import devstudio.generatedcode.exceptions.HlaDecodeException;


public final class SpatialVariantStructEncoder extends AbstractVariantRecordEncoder<SpatialVariantStruct> {


   public SpatialVariantStructEncoder() {
      super(SpatialVariantStructEncoder.class);

      _encoder.setDiscriminant(new DeadReckoningAlgorithmEnumEncoder());

      _encoder.setVariant(new DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum.STATIC_),
                          new SpatialStaticStructEncoder());
      _encoder.setVariant(new DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum.DRM_FPW),
                          new SpatialFPStructEncoder());
      _encoder.setVariant(new DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum.DRM_RPW),
                          new SpatialRPStructEncoder());
      _encoder.setVariant(new DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum.DRM_RVW),
                          new SpatialRVStructEncoder());
      _encoder.setVariant(new DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum.DRM_FVW),
                          new SpatialFVStructEncoder());
      _encoder.setVariant(new DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum.DRM_FPB),
                          new SpatialFPStructEncoder());
      _encoder.setVariant(new DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum.DRM_RPB),
                          new SpatialRPStructEncoder());
      _encoder.setVariant(new DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum.DRM_RVB),
                          new SpatialRVStructEncoder());
      _encoder.setVariant(new DeadReckoningAlgorithmEnumEncoder(DeadReckoningAlgorithmEnum.DRM_FVB),
                          new SpatialFVStructEncoder());
   }

   public SpatialVariantStructEncoder(SpatialVariantStruct value) {
      this();
      setValue(value);
   }

   protected void encodeValue(SpatialVariantStruct value) {
      DeadReckoningAlgorithmEnum discriminant = value.getDiscriminant();

      ((DeadReckoningAlgorithmEnumEncoder)_encoder.getDiscriminant()).setValue(discriminant);

      switch (discriminant) {
         case STATIC_:
            ((SpatialStaticStructEncoder)_encoder.getValue()).setValue(value.getSpatialStatic());
            break;
         case DRM_FPW:
            ((SpatialFPStructEncoder)_encoder.getValue()).setValue(value.getSpatialFPW());
            break;
         case DRM_RPW:
            ((SpatialRPStructEncoder)_encoder.getValue()).setValue(value.getSpatialRPW());
            break;
         case DRM_RVW:
            ((SpatialRVStructEncoder)_encoder.getValue()).setValue(value.getSpatialRVW());
            break;
         case DRM_FVW:
            ((SpatialFVStructEncoder)_encoder.getValue()).setValue(value.getSpatialFVW());
            break;
         case DRM_FPB:
            ((SpatialFPStructEncoder)_encoder.getValue()).setValue(value.getSpatialFPB());
            break;
         case DRM_RPB:
            ((SpatialRPStructEncoder)_encoder.getValue()).setValue(value.getSpatialRPB());
            break;
         case DRM_RVB:
            ((SpatialRVStructEncoder)_encoder.getValue()).setValue(value.getSpatialRVB());
            break;
         case DRM_FVB:
            ((SpatialFVStructEncoder)_encoder.getValue()).setValue(value.getSpatialFVB());
            break;

         case OTHER:
            break;
         default:
            throw new HlaDecodeException("Failed to encode, unknown discriminant: " + discriminant);
      }
   }

   protected SpatialVariantStruct decodeValue() {
      DeadReckoningAlgorithmEnum enumValue = ((DeadReckoningAlgorithmEnumEncoder)_encoder.getDiscriminant()).getValue();

      switch (enumValue) {
         case STATIC_:
            return SpatialVariantStruct.createSpatialStatic(
                  ((SpatialStaticStructEncoder)_encoder.getValue()).getValue()
            );
         case DRM_FPW:
            return SpatialVariantStruct.createSpatialFPW(
                  ((SpatialFPStructEncoder)_encoder.getValue()).getValue()
            );
         case DRM_RPW:
            return SpatialVariantStruct.createSpatialRPW(
                  ((SpatialRPStructEncoder)_encoder.getValue()).getValue()
            );
         case DRM_RVW:
            return SpatialVariantStruct.createSpatialRVW(
                  ((SpatialRVStructEncoder)_encoder.getValue()).getValue()
            );
         case DRM_FVW:
            return SpatialVariantStruct.createSpatialFVW(
                  ((SpatialFVStructEncoder)_encoder.getValue()).getValue()
            );
         case DRM_FPB:
            return SpatialVariantStruct.createSpatialFPB(
                  ((SpatialFPStructEncoder)_encoder.getValue()).getValue()
            );
         case DRM_RPB:
            return SpatialVariantStruct.createSpatialRPB(
                  ((SpatialRPStructEncoder)_encoder.getValue()).getValue()
            );
         case DRM_RVB:
            return SpatialVariantStruct.createSpatialRVB(
                  ((SpatialRVStructEncoder)_encoder.getValue()).getValue()
            );
         case DRM_FVB:
            return SpatialVariantStruct.createSpatialFVB(
                  ((SpatialFVStructEncoder)_encoder.getValue()).getValue()
            );

         case OTHER:
            return SpatialVariantStruct.createOther();

         default:
            throw new HlaDecodeException("Failed to decode, unknown discriminant: " + enumValue);
      }
   }
}
