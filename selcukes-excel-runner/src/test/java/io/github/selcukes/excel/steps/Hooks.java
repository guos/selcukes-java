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

package io.github.selcukes.excel.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    public static ThreadLocal<String> testName = new InheritableThreadLocal<>();

    public static String getFeatureName(Scenario scenario) {
        String featureName = scenario.getUri().getPath();
        featureName = featureName.substring(featureName.lastIndexOf("/") + 1, featureName.indexOf("."));
        return featureName;
    }

    @Before
    public void beforeTest(Scenario scenario) {
        String test = getFeatureName(scenario) + "::" + scenario.getName();
        testName.set(test);
    }

    @After
    public void afterTest(Scenario scenario) {
        testName.remove();
    }
}
