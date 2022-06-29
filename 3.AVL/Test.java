public class Test {
    public static void main(String[] args) {

        AVL<Integer> avl = new AVL<Integer>();

        // ItemDuplicated test
        try {
            avl.insert(1);
            avl.insert(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // the item duplicated is not added
            System.out.println(avl.toString());
        }

        // There is not error if we insert different items
        try {
            avl.insert(2);
            avl.insert(6);
            avl.insert(10);
            avl.insert(15);
            System.out.println(avl.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // throws an exception if we search an item that is not found
        try {
            avl.search(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // we can remove an item, but if the item is not found, it will throw an
        // exception
        try {
            avl.remove(15);
            System.out.println("15 deleted - " + avl.toString());
            // exception will be thrown
            avl.remove(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // if we try to print an empty tree, there will not be an exception but yes a
        // message
        AVL<Integer> avl2 = new AVL<Integer>();

        System.out.println(avl2.toString());

    }
}
