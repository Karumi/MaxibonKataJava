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
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitQuickcheck.class) public class DeveloperProperties {

  private static final String ANY_NAME = "Pedro";
  private static final int ANY_NUMBER_OF_MAXIBONS = 1;

  @Property public void theNumberOfMaxibonsAssignedIsPositiveOrZero(int numberOfMaxibons) {
    System.out.println("Trying with number of maxibons " + numberOfMaxibons);
    Developer developer = new Developer(ANY_NAME, numberOfMaxibons);
    assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
  }

  @Property public void theNameIsAssignedInConstruction(String name) {
    System.out.println("Trying with name " + name);
    Developer developer = new Developer(name, ANY_NUMBER_OF_MAXIBONS);
    assertEquals(name, developer.getName());
  }

  @Test public void theNumberOfMaxibonsAssociatedToEveryKarumieIsAlreadyAssigned() {
    assertEquals(3, Karumies.PEDRO.getNumberOfMaxibonsToGrab());
    assertEquals(0, Karumies.DAVIDE.getNumberOfMaxibonsToGrab());
    assertEquals(1, Karumies.ALBERTO.getNumberOfMaxibonsToGrab());
    assertEquals(2, Karumies.SERGIO.getNumberOfMaxibonsToGrab());
    assertEquals(1, Karumies.JORGE.getNumberOfMaxibonsToGrab());
  }
}
