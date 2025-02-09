// Copyright 2018 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.skyframe.serialization;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import java.util.Collections;
import java.util.List;

/**
 * Codec for {@link Collections.EMPTY_LIST}
 *
 * <p>TODO(shahan): this might be better as an AutoCodec field tag, but this package, the logical
 * home for the codec, is a dependency of AutoCodec, so doing so would create a circular dependency.
 */
@SuppressWarnings("rawtypes")
class EmptyListCodec extends LeafObjectCodec<List> {

  @Override
  public Class<? extends List> getEncodedClass() {
    return Collections.emptyList().getClass();
  }

  @Override
  public void serialize(List unusedValue, CodedOutputStream unusedCodedOut) {}

  @Override
  public List deserialize(CodedInputStream unusedCodedIn) {
    return Collections.emptyList();
  }
}
