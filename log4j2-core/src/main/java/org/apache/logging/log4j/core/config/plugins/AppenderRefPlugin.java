/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.core.config.plugins;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.internal.StatusLogger;

/**
 *
 */
@Plugin(name = "appender-ref", type = "Core", printObject = true)
public class AppenderRefPlugin {

    protected final static Logger logger = StatusLogger.getLogger();

    @PluginFactory
    public static String createAppenderRef(@PluginAttr("ref") String ref) {

        if (ref == null) {
            logger.error("Appender references must contain a reference");
        }
        return ref;
    }
}
