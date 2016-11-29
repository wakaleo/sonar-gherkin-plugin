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
package org.sonar.gherkin.tree.impl;

import com.google.common.collect.Iterators;
import org.sonar.plugins.gherkin.api.tree.*;
import org.sonar.plugins.gherkin.api.visitors.DoubleDispatchVisitor;

import javax.annotation.Nullable;
import java.util.Iterator;

public class StepTreeImpl extends GherkinTree implements StepTree {

  private final PrefixTree prefix;
  private final SyntaxToken sentence;
  private final DocStringTree docString;
  private final TableTree table;

  public StepTreeImpl(PrefixTree prefix, SyntaxToken sentence, @Nullable Tree data) {
    this.prefix = prefix;
    this.sentence = sentence;

    if (data != null) {
      if (data instanceof DocStringTree) {
        docString = (DocStringTree) data;
        table = null;
      } else if (data instanceof TableTree) {
        table = (TableTree) data;
        docString = null;
      } else {
        throw new IllegalStateException("Unsupported data tree: " + data.toString());
      }
    } else {
      docString = null;
      table = null;
    }
  }

  @Override
  public Kind getKind() {
    return Kind.STEP;
  }

  @Override
  public Iterator<Tree> childrenIterator() {
    return Iterators.forArray(prefix, sentence, docString, table);
  }

  @Override
  public PrefixTree prefix() {
    return prefix;
  }

  @Override
  public SyntaxToken sentence() {
    return sentence;
  }

  @Override
  @Nullable
  public DocStringTree docString() {
    return docString;
  }

  @Override
  @Nullable
  public TableTree table() {
    return table;
  }

  @Override
  public void accept(DoubleDispatchVisitor visitor) {
    visitor.visitStep(this);
  }

}