/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.logging.log4j.perf.jmh.jpa;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.db.jpa.BasicLogEventEntity;
import org.apache.logging.log4j.core.appender.db.jpa.converter.ContextMapJsonAttributeConverter;

@Entity
@Table(name = "jpaBasicLogEntry")
@SuppressWarnings("unused")
public class TestBasicEntity extends BasicLogEventEntity {
    private static final long serialVersionUID = 1L;

    private long id = 0L;

    public TestBasicEntity() {
    }

    public TestBasicEntity(final LogEvent wrapped) {
        super(wrapped);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @Override
    @Convert(converter = ContextMapJsonAttributeConverter.class)
    @Column(name = "contextMapJson")
    public Map<String, String> getContextMap() {
        return super.getContextMap();
    }
}
