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

import com.google.common.base.Charsets;
import com.sonar.sslr.api.RecognitionException;
import org.junit.Test;

public class GherkinGrammarTest {

  @Test(expected = RecognitionException.class)
  public void parse_error() throws Exception {
    GherkinParserBuilder
      .createTestParser(Charsets.UTF_8, GherkinLexicalGrammar.GHERKIN_DOCUMENT)
      .parse("blabla");
  }

}