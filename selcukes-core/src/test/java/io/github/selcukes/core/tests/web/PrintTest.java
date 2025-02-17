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

package io.github.selcukes.core.tests.web;

import io.github.selcukes.commons.annotation.Lifecycle;
import io.github.selcukes.core.page.Pages;
import io.github.selcukes.core.page.WebPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Lifecycle
public class PrintTest {
    WebPage page;

    @BeforeMethod
    public void setup() {
        page = Pages.webPage();
    }

    @Test
    public void testPrint() {
        page.open("https://techyworks.blogspot.com/2022/03/get-browser-session-storage-data-using-selenium.html");
       // page.printPage("target/print.pdf");
    }
}
