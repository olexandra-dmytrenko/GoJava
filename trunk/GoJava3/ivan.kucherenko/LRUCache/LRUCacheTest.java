package ua.goit.alg.LRUCache;

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheTest {

  @Test
  public void fillCache() {
    LRUCache cache = new LRUCache(5);

    for (int i = 0; i < 5; i++){
      cache.set(i,i);
    }
    String cacheContents = String.valueOf(cache.get(3));
    String expectedResult = "3";
    assertEquals(cacheContents, expectedResult);
  }
  @Test
  public void addNumberOnTailAndGetResultInHead() {
    LRUCache cache = new LRUCache(5);

    for (int i = 0; i < 6; i++){
      cache.set(i,i);
    }
    String cacheContents = String.valueOf(cache.get(0));
    String expectedResult = "-1";
    assertEquals(cacheContents, expectedResult);
  }

  @Test
  public void getNumberAndAddNumberOnTail() {
    LRUCache cache = new LRUCache(5);

    for (int i = 0; i < 5; i++){
      cache.set(i,i);
    }
    cache.get(3);
    cache.set(6, 6);
    String cacheContents = String.valueOf(cache.get(0));
    String expectedResult = "-1";
    assertEquals(cacheContents, expectedResult);
  }

  @Test
  public void setBigNumbers() {
    LRUCache cache = new LRUCache(20);

    for (int i = 0; i < 2000; i++){
      cache.set(i,i);
    }
    String cacheContents = String.valueOf(cache.get(1999));
    String expectedResult = "1999";
    assertEquals(cacheContents, expectedResult);
  }

  @Test
  public void setSmallNumbers() {
    LRUCache cache = new LRUCache(2);

    for (int i = 0; i < 2; i++){
      cache.set(i,i);
    }
    String cacheContents = String.valueOf(cache.get(1));
    String expectedResult = "1";
    assertEquals(cacheContents, expectedResult);
  }

  @Test
  public void setOneNumber_Key2AndValue1() {
    LRUCache cache = new LRUCache(1);
    cache.set(2, 1);
    String cacheContents = String.valueOf(cache.get(2));
    String expectedResult = "1";
    assertEquals(cacheContents, expectedResult);
  }

  @Test
  public void setOneNumber_Key3AndValue2_Get2() {
    LRUCache cache = new LRUCache(1);
    cache.set(3, 2);
    String cacheContents = String.valueOf(cache.get(2));
    String expectedResult = "-1";
    assertEquals(cacheContents, expectedResult);
  }

  @Test
  public void setTwoNumbers_Key2AndValue2_Get2() {
    LRUCache cache = new LRUCache(2);
    cache.set(2, 1);
    cache.set(2, 2);
    String cacheContents = String.valueOf(cache.get(2));
    String expectedResult = "2";
    assertEquals(cacheContents, expectedResult);
  }

  @Test
  public void setTwoNumbers_Key1_Value1_AND_Key4_Value1_Get2() {
    LRUCache cache = new LRUCache(2);
    cache.set(2, 1);
    cache.set(2, 2);
    cache.get(2);
    cache.set(1, 1);
    cache.set(4, 1);
    String cacheContents = String.valueOf(cache.get(2));
    String expectedResult = "-1";
    assertEquals(cacheContents, expectedResult);;    

  }


}
