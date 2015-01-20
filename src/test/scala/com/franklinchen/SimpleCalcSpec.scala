package com.franklinchen

import org.specs2._

import org.antlr.runtime._

/**
  Unfortunately, ANTLR 3 is very stateful.
  Here we catch and save errors ourselves into some state, then retrieve.
  */
class SimpleCalcSpec extends Specification { def is = s2"""
  Good expression $e1
  Bad expression  $e2
  """

  def e1 = {
    val s = "1 * (2 +3)"
    val stream = new ANTLRStringStream(s)
    val lexer = new SimpleCalcLexer(stream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new SimpleCalcParser(tokens)
    val _ = parser.expr()
    lexer.getExceptions() must beLike { case es => es.size() ==== 0 }
    parser.getExceptions() must beLike { case es => es.size() ==== 0 }
  }

  def e2 = {
    val s = ")1 + (2 +3)"
    val stream = new ANTLRStringStream(s)
    val lexer = new SimpleCalcLexer(stream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new SimpleCalcParser(tokens)
    val _ = parser.expr()
    lexer.getExceptions() must beLike { case es => es.size() must be_>(0) }
    // Don't even bother checking the parser.
  }
}
