/*
 * Copyright 2003-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gls.syntax

public class MethodCallValidationTest extends gls.CompilableTestSupport {

    void testDeclarationInMethodCall() {
        shouldNotCompile """
            foo(String a)
        """
    }

    void testDuplicateNamedParameters() {
        shouldNotCompile """
            def closure = { println it }
            closure debit: 30, credit: 40, debit: 50, {}
        """

        shouldNotCompile """
            def closure = { println it }
            closure debit: 30, credit: 40, debit: 50
        """

        shouldNotCompile """
            def method(map) {
                println map
            }
            method debit: 30, credit: 40, debit: 50
        """
    }
}