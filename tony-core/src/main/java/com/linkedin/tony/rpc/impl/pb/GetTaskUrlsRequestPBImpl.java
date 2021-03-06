/**
 * Copyright 2018 LinkedIn Corporation. All rights reserved. Licensed under the BSD-2 Clause license.
 * See LICENSE in the project root for license information.
 */
package com.linkedin.tony.rpc.impl.pb;


import com.linkedin.tony.rpc.GetTaskUrlsRequest;
import com.linkedin.tony.rpc.proto.YarnTensorFlowClusterProtos.GetTaskUrlsRequestProto;


public class GetTaskUrlsRequestPBImpl implements GetTaskUrlsRequest {
  private GetTaskUrlsRequestProto proto = GetTaskUrlsRequestProto.getDefaultInstance();
  private GetTaskUrlsRequestProto.Builder builder = null;
  private boolean viaProto = false;

  private boolean rebuild = false;

  public GetTaskUrlsRequestPBImpl() {
        builder = GetTaskUrlsRequestProto.newBuilder();
    }

  public GetTaskUrlsRequestPBImpl(GetTaskUrlsRequestProto proto) {
    this.proto = proto;
    viaProto = true;
  }

  private void mergeLocalToProto() {
    if (viaProto) {
      maybeInitBuilder();
    }
    proto = builder.build();
    rebuild = false;
    viaProto = true;
  }

  public GetTaskUrlsRequestProto getProto() {
     if (rebuild) {
       mergeLocalToProto();
     }
    proto = viaProto ? proto : builder.build();
    viaProto = true;
    return proto;
  }

  private void maybeInitBuilder() {
    if (viaProto || builder == null) {
      builder = GetTaskUrlsRequestProto.newBuilder(proto);
    }
    viaProto = false;
  }
}
