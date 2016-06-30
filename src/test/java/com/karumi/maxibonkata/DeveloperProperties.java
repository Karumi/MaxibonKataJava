/*
 * Copyright (C) 2016 Karumi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {

  private static final String ANY_NAME = "Pedro";

  @Property public void theNumberOfMaxibonsAssignedIsPositiveOrZero(int numberOfMaxibons) {
    Developer developer = new Developer(ANY_NAME, numberOfMaxibons);
    assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
  }

}
