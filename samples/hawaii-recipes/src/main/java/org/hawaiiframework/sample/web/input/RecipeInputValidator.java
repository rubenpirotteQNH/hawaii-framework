/*
 * Copyright 2015-2018 the original author or authors.
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

package org.hawaiiframework.sample.web.input;

import org.hawaiiframework.validation.ValidationResult;
import org.hawaiiframework.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;
import static org.hamcrest.Matchers.greaterThan;

/**
 * @author Marcel Overdijk
 */
@Component
public class RecipeInputValidator implements Validator<RecipeInput> {

    private final IngredientInputValidator ingredientInputValidator;

    @Autowired
    public RecipeInputValidator(final IngredientInputValidator ingredientInputValidator) {
        this.ingredientInputValidator = requireNonNull(ingredientInputValidator, "'ingredientInputValidator' must not be null");
    }

    @Override
    public void validate(RecipeInput recipe, ValidationResult validationResult) {
        validationResult.rejectField("name", recipe.getName())
                .whenNull()
                .orWhen(n -> n.length() > 100, "length");

        validationResult.rejectField("email", recipe.getEmail())
                .whenNull()
                .orWhen(String::length, greaterThan(100), "length");
            // TODO validate email

        validationResult.rejectField("description", recipe.getDescription())
                .whenNull()
                .orWhen(d -> d.length() > 1000, "length");
    }
}
