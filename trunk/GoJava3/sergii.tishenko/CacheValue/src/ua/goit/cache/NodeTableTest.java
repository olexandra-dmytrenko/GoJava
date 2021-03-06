package ua.goit.cache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.goit.cache.Node;
import ua.goit.cache.NodeTable;

public class NodeTableTest {

  @Test
  public void putAndGetTest() {

    NodeTable nodeTable = new NodeTable();
    nodeTable.put(1, 10);
    nodeTable.put(2, 20);
    nodeTable.put(3, 30);
    nodeTable.put(4, 40);
    nodeTable.put(5, 50);

    int expected = 30;
    int actual = nodeTable.get(3);
    assertEquals(actual, expected);
  }

  @Test
  public void pushNodeTest() {

    NodeTable nodeTable = new NodeTable();
    nodeTable.put(1, 10);
    nodeTable.put(2, 20);
    nodeTable.put(3, 30);
    nodeTable.put(4, 40);
    nodeTable.put(5, 50);

    nodeTable.put(6, 60);
    nodeTable.put(7, 70);

    int expected = -1;
    int actual = nodeTable.get(1);
    assertEquals(expected, actual);

    actual = nodeTable.get(2);
    assertEquals(actual, expected);

    nodeTable.put(8, 80);
    actual = nodeTable.get(3);
    assertEquals(actual, expected);

    nodeTable.put(9, 90);
    actual = nodeTable.get(4);
    assertEquals(actual, expected);

    nodeTable.put(10, 100);
    actual = nodeTable.get(5);
    assertEquals(actual, expected);

  }

  @Test
  public void changePritityTest() {

    NodeTable nodeTable = new NodeTable();
    nodeTable.put(1, 10);
    nodeTable.put(2, 20);
    nodeTable.put(3, 30);
    nodeTable.put(4, 40);
    nodeTable.put(5, 50);

    int actual = nodeTable.get(1);

    nodeTable.put(6, 60);
    nodeTable.put(7, 70);
    nodeTable.put(8, 80);
    nodeTable.put(9, 90);

    int expected = 10;
    actual = nodeTable.get(1);
    assertEquals(expected, actual);

  }

  @Test
  public void keysTest() {

    NodeTable nodeTable = new NodeTable(3);
    nodeTable.put(1, 10);
    nodeTable.put(2, 20);
    nodeTable.put(1, 30);
    nodeTable.put(2, 40);
    nodeTable.put(5, 50);
    nodeTable.put(1, 30);

    int actual = nodeTable.get(1);
    int expected = 30;
    assertEquals(expected, actual);

    nodeTable.put(2, 10);
    nodeTable.put(5, 10);
    nodeTable.put(6, 10);

    expected = -1;
    actual = nodeTable.get(1);
    assertEquals(expected, actual);

    expected = 10;
    
    actual = nodeTable.get(6);
    assertEquals(expected, actual);
    
    
    actual = nodeTable.get(5);
    assertEquals(expected, actual);

    actual = nodeTable.get(2);
    assertEquals(expected, actual);
    
    nodeTable.put(3, 30);

    expected = -1;
    actual = nodeTable.get(6);
    assertEquals(expected, actual);
    
    expected = 10;
    actual = nodeTable.get(5);
    assertEquals(expected, actual);

    expected = 10;
    actual = nodeTable.get(2);
    assertEquals(expected, actual);

  }
  
  
  @Test
  public void listTest() {

    NodeTable nodeTable = new NodeTable(3);
    int actual = 0;
    int expected = 0;
    
    
    nodeTable.put(1, 10);
    expected = 1;
    actual  =listQuantity(nodeTable);
    assertEquals(expected, actual);
    
    nodeTable.put(2, 20);
    expected = 2;
    actual  =listQuantity(nodeTable);
    assertEquals(expected, actual);
    

    
    nodeTable.put(1, 30);
    expected = 2;
    actual  =listQuantity(nodeTable);
    assertEquals(expected, actual);
    
    
    nodeTable.put(2, 40);
    expected = 2;
    actual  =listQuantity(nodeTable);
    assertEquals(expected, actual);
    
    nodeTable.put(5, 50);
    expected = 3;
    actual  =listQuantity(nodeTable);
    assertEquals(expected, actual);
    
    nodeTable.put(1, 30);
    expected = 3;
    actual  =listQuantity(nodeTable);
    assertEquals(expected, actual);
    

    actual = nodeTable.get(1);
    expected = 30;
    assertEquals(expected, actual);

    expected = 3;
    actual  =listQuantity(nodeTable);
    assertEquals(expected, actual);
    

    nodeTable.put(2, 10);
    nodeTable.put(5, 10);
    nodeTable.put(6, 10);

    expected = 10;
    actual  = nodeTable.getHead().getValue();
    assertEquals(expected, actual);

    expected = 2;
    actual  = nodeTable.getHead().getKey();
    assertEquals(expected, actual);

    expected = 6;
    actual  = nodeTable.getTail().getKey();
    assertEquals(expected, actual);

    expected = 6;
    actual  = nodeTable.getTail().getKey();
    assertEquals(expected, actual);
    
    expected = 3;
    actual  =listQuantity(nodeTable);
    assertEquals(expected, actual);

  }
  
  
  int listQuantity(NodeTable ntd){
    Node head = ntd.getHead();
    int res = 0;
    while(head !=null){
      //System.out.println("--" + head.getValue());
      res++;
      head = head.getNextNode();
      
    }
    return res;
  }
  
}
