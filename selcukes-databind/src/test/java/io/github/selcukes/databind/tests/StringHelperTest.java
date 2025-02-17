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

package io.github.selcukes.databind.tests;

import io.github.selcukes.databind.utils.StringHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringHelperTest {
    @Test
    public void interpolateTest() {
        Map<String, String> stringMap = Map.of("module", "question");
        String label = "This is sample ${module} maker";
        String updatedLabel = StringHelper.interpolate(label, matcher -> stringMap.get(matcher.group(1)));
        Assert.assertEquals(updatedLabel, "This is sample question maker");
    }

    @Test
    public void stringCaseTest() {
        String camelCase = "HelloWorld";
        String snakeCase = "hello_world";
        Assert.assertEquals(StringHelper.toCamelCase(snakeCase), camelCase);
        Assert.assertEquals(StringHelper.toSnakeCase(camelCase), snakeCase);
    }

    @Test
    public void jsonTest() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        String expected = "{\"a\":\"1\",\"b\":\"2\",\"c\":\"3\"}";
        Assert.assertEquals(StringHelper.toJson(map), expected);
    }

    @Test
    public void normalizeTextTest() {
        String text = "Hello\nbe";
        Assert.assertEquals(StringHelper.normalizeText(text), "Hello be");
    }
}
