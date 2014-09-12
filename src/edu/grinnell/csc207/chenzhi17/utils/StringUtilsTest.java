package edu.grinnell.csc207.chenzhi17.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest
{

  @Test
  public void testSplitAt()
  {
    
    assertArrayEquals(new String[] { "a", "b", "c" },
                      StringUtils.splitAt("a:b:c", ':'));
    assertArrayEquals(new String[] { "a", "b", "c" },
                      StringUtils.splitAt("a b c", ' '));
    assertArrayEquals(new String[] { "a:b:c" },
                      StringUtils.splitAt("a:b:c", ' '));
    assertArrayEquals("one field", new String[] { "a" },
                      StringUtils.splitAt("a", ':'));
    assertArrayEquals("empty inner field", new String[] { "a", "", "c" },
                      StringUtils.splitAt("a::c", ':'));
    assertArrayEquals("leading empty field", new String[] { "", "a" },
                      StringUtils.splitAt(":a", ':'));
    assertArrayEquals("trailing empty field", new String[] { "a", "" },
                      StringUtils.splitAt("a:", ':'));
    
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitAt("a,b,c", ','));
    assertArrayEquals (new String[] { "a,b", "c" },
                       StringUtils.splitAt("\"a,b\",c", ','));
    assertArrayEquals (new String[] { "a", "b,b\"", "c" },
                       StringUtils.splitAt("a,\"b,b\"\"\",c", ','));
  }
  
}
