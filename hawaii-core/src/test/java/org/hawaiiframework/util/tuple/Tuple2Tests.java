/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hawaiiframework.util.tuple;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@link Tuple2}.
 *
 * @author Marcel Overdijk
 */
public class Tuple2Tests extends AbstractTupleTests {

    private Tuple2<Object1, Object2> tuple = Tuples.of(object1, object2);

    @Test
    public void testSizeIs2() {
        assertThat(tuple.size(), is(2));
    }

    @Test
    public void testSetElement2() {
        tuple.setElement2(other2);
        assertThat(tuple.getElement2(), is(sameInstance(other2)));
    }

    @Test
    public void testGetElement1() {
        assertThat(tuple.getElement1(), is(instanceOf(Object1.class)));
        assertThat(tuple.getElement1(), is(sameInstance(object1)));
    }

    @Test
    public void testGetElement2() {
        assertThat(tuple.getElement2(), is(instanceOf(Object2.class)));
        assertThat(tuple.getElement2(), is(sameInstance(object2)));
    }
}