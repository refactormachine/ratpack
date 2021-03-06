/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.stream.internal;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxAwareCounter {

  private final AtomicInteger counter = new AtomicInteger();
  private final AtomicInteger max = new AtomicInteger();

  public int inc() {
    int i = counter.incrementAndGet();
    max.updateAndGet(o -> Math.max(i, o));
    return i;
  }

  public int dec() {
    return counter.decrementAndGet();
  }

  public int max() {
    return max.get();
  }

}
