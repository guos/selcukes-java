/*
 *  Copyright (c) Ramesh Babu Prudhvi.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.github.selcukes.databind.converters;

import io.github.selcukes.databind.utils.Clocks;

import java.time.LocalDateTime;

import static io.github.selcukes.databind.utils.Clocks.DATE_TIME_FORMAT;
import static java.time.LocalDateTime.parse;

/**
 * It converts a string to a `LocalDateTime` object
 */
public class LocalDateTimeConverter extends DefaultConverter<LocalDateTime> {

    @Override
    public LocalDateTime convert(final String value) {
        return convert(value, DATE_TIME_FORMAT);
    }

    @Override
    public LocalDateTime convert(final String value, final String format) {
        return parse(value, Clocks.dateTimeFormatter(format, DATE_TIME_FORMAT));
    }
}
