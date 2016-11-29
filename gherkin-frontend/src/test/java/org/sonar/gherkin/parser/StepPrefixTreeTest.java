/*
 * SonarQube Gherkin Analyzer
 * Copyright (C) 2016-2016 David RACODON
 * david.racodon@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.gherkin.parser;

import org.junit.Test;

public class StepPrefixTreeTest extends PrefixTreeTest {

  public StepPrefixTreeTest() {
    super(GherkinLexicalGrammar.STEP_PREFIX);
  }

  @Test
  public void stepPrefix() throws Exception {
    checkParsed("Given", "Given");
    checkParsed(" Given", "Given");
    checkParsed("When", "When");
    checkParsed(" When", "When");
    checkParsed("Then", "Then");
    checkParsed(" Then", "Then");
    checkParsed("*", "*");
    checkParsed(" *", "*");
    checkParsed("And", "And");
    checkParsed(" And", "And");
    checkParsed("But", "But");
    checkParsed(" But", "But");
  }

  @Test
  public void notStepPrefix() throws Exception {
    checkNotParsed("given");
    checkNotParsed("GIVEN");
    checkNotParsed("when");
    checkNotParsed("WHEN");
    checkNotParsed("then");
    checkNotParsed("THEN");
    checkNotParsed("but");
    checkNotParsed("BUT");
    checkNotParsed("and");
    checkNotParsed("AND");
    checkNotParsed("blabla");
  }

}