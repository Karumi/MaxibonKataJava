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

import java.util.Collections;
import java.util.List;

public class KarumiHQs {

  private final Chat chat;

  private int maxibonsLeft;

  public KarumiHQs() {
    this(new ConsoleChat());
  }

  public KarumiHQs(Chat chat) {
    this.chat = chat;
    this.maxibonsLeft = 10;
  }

  public void openFridge(Developer developer) {
    openFridge(Collections.singletonList(developer));
  }

  public void openFridge(List<Developer> developers) {
    for (Developer developer : developers) {
      grabMaxibons(developer);
      if (shouldBuyMoreMaxibons()) {
        notifyWeShouldByMaxibon(developer);
        buyMaxibons();
      }
    }
  }

  private void grabMaxibons(Developer developer) {
    maxibonsLeft -= developer.getNumberOfMaxibonsToGrab();
    if (maxibonsLeft < 0) {
      maxibonsLeft = 0;
    }
  }

  private boolean shouldBuyMoreMaxibons() {
    return maxibonsLeft <= 2;
  }

  private void notifyWeShouldByMaxibon(Developer developer) {
    chat.sendMessage("Hi guys, I'm " + developer.getName() + ". We need more maxibons!");
  }

  private void buyMaxibons() {
    maxibonsLeft += 10;
  }

  public int getMaxibonsLeft() {
    return maxibonsLeft;
  }
}
