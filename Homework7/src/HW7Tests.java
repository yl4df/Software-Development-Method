import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HW7Tests {

    BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
    BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>();

    // Test size() method;
    @Test
    public void testSize1() {
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        assertTrue(tree1.size() == 3);
    }

    // Test size() method;
    @Test
    public void testSize2() {
        tree2.insert(7);
        tree2.insert(3);
        tree2.insert(9);
        tree2.insert(2);
        tree2.insert(5);
        tree2.insert(1);
        tree2.insert(4);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        assertTrue(tree2.size() == 10);
    }

    // Test height() method;
    @Test
    public void testHeight1() {
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        assertTrue(tree1.height() == 3);
    }

    // Test height() method;
    @Test
    public void testHeight2() {
        tree2.insert(7);
        tree2.insert(3);
        tree2.insert(9);
        tree2.insert(2);
        tree2.insert(5);
        tree2.insert(1);
        tree2.insert(4);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        assertTrue(tree2.height() == 4);
    }

    // Test find() method;
    @Test
    public void testFind1() {
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        assertTrue(tree1.find(2));
    }

    // Test find() method;
    @Test
    public void testFind2() {
        tree2.insert(7);
        tree2.insert(3);
        tree2.insert(9);
        tree2.insert(2);
        tree2.insert(5);
        tree2.insert(1);
        tree2.insert(4);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        assertFalse(tree2.find(11));
    }

    // Test insert() method;
    @Test
    public void testInsert1() {
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        assertFalse(tree1.insert(2));
    }

    // Test insert() method;
    @Test
    public void testInsert2() {
        tree2.insert(7);
        tree2.insert(3);
        tree2.insert(9);
        tree2.insert(2);
        tree2.insert(5);
        tree2.insert(1);
        tree2.insert(4);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        assertTrue(tree2.insert(11));
    }

    // Test delete() method;
    @Test
    public void testDelete1() {
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        assertFalse(tree1.delete(4));
    }

    // Test delete() method;
    @Test
    public void testDelete2() {
        tree2.insert(7);
        tree2.insert(3);
        tree2.insert(9);
        tree2.insert(2);
        tree2.insert(5);
        tree2.insert(1);
        tree2.insert(4);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        assertTrue(tree2.delete(10));
    }

    // Test inOrder() method;
    @Test
    public void testInOrder1() {
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        assertEquals(tree1.inOrder(), "(1)(2)(3)");
    }

    // Test inOrder() method;
    @Test
    public void testInOrder2() {
        tree2.insert(7);
        tree2.insert(3);
        tree2.insert(9);
        tree2.insert(2);
        tree2.insert(5);
        tree2.insert(1);
        tree2.insert(4);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        assertEquals(tree2.inOrder(), "(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)");
    }

    // Test postOrder() method;
    @Test
    public void testPostOrder1() {
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        assertEquals(tree1.postOrder(), "(3)(2)(1)");
    }

    // Test postOrder() method;
    @Test
    public void testPostOrder2() {
        tree2.insert(7);
        tree2.insert(3);
        tree2.insert(9);
        tree2.insert(2);
        tree2.insert(5);
        tree2.insert(1);
        tree2.insert(4);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        assertEquals(tree2.postOrder(), "(1)(2)(4)(6)(5)(3)(8)(10)(9)(7)");
    }

    // Test toString() method;
    @Test
    public void testToString1() {
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        assertEquals(tree1.toString(), "(1)(2)(3)");
    }

    // Test toString() method;
    @Test
    public void testToSting2() {
        tree2.insert(7);
        tree2.insert(3);
        tree2.insert(9);
        tree2.insert(2);
        tree2.insert(5);
        tree2.insert(1);
        tree2.insert(4);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        assertEquals(tree2.toString(), "(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)");
    }

    // Test buildFromList() method;
    @Test
    public void testBuildFromList1() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(tree1.buildFromList(list));
    }

    // Test buildFromList() method;
    @Test
    public void testBuildFromList2() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        assertFalse(tree1.buildFromList(list));
    }

}
