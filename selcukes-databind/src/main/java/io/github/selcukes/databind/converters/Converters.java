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

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.selcukes.databind.utils.Reflections.newInstance;

@UtilityClass
public class Converters {

    /**
     * It creates a list of converters by instantiating each class in the list
     * of classes passed in
     *
     * @return A list of Converter objects.
     */
    @SuppressWarnings("unchecked")
    public static <T> List<Converter<T>> defaultConverters() {
        return Stream.of(
            BooleanConverter.class,
            StringConverter.class,
            IntegerConverter.class,
            DoubleConverter.class,
            LocalDateConverter.class,
            LocalDateTimeConverter.class)
                .map(cls -> (Converter<T>) newInstance(cls))
                .collect(Collectors.toList());
    }
}
