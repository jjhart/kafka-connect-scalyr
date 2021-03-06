/*
 * Copyright 2020 Scalyr Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scalyr.integrations.kafka.mapping;

import org.apache.kafka.connect.sink.SinkRecord;

import java.util.Collections;
import java.util.Map;

/**
 * Abstraction for getting event fields from SinkRecord values,
 * which are in different message source formats and can be nested.
 */
public interface MessageMapper {
  String getServerHost(SinkRecord record);
  String getLogfile(SinkRecord record);
  String getParser(SinkRecord record);
  String getMessage(SinkRecord record);
  default Map<String, Object> getAdditionalAttrs(SinkRecord record) {
    return Collections.EMPTY_MAP;
  }

  /**
   * Check message attribute to see if this MessageMapper applies to this message.
   * @return true if the message mapper matches the message.
   */
  boolean matches(SinkRecord record);
}
