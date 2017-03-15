package com.xiaody.structure;

/**
 * Created by Xiaody on 2017/3/2.
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    static class Node<E> {
        E item;
        Node<E> leftChild;
        Node<E> rightChild;
        Node<E> parent;

        public Node(E item) {
            this.item = item;
        }
    }

    public void insert(E e) {
        insertNode(root, e);
    }

    private void insertNode(Node<E> rootNode, E e) {
        Node<E> newNode = new Node<>(e);
        if (rootNode == null) {
            root = newNode;
        } else {
            if (e.compareTo(rootNode.item) < 0) {
                if (rootNode.leftChild == null) {
                    rootNode.leftChild = newNode;
                    newNode.parent = rootNode;
                } else {
                    insertNode(rootNode.leftChild, e);
                }
            } else if (e.compareTo(rootNode.item) > 0) {
                if (rootNode.rightChild == null) {
                    rootNode.rightChild = newNode;
                    newNode.parent = rootNode;
                } else {
                    insertNode(rootNode.rightChild, e);
                }
            }
        }
    }

    public Node<E> getMin() {
        return getMinNode(root);
    }

    public Node<E> getMinNode(Node<E> node) {
        Node<E> min = node;
        while (min.leftChild != null) {
            min = min.leftChild;
        }
        return min;
    }

    public Node<E> getMax() {
        return getMaxNode(root);
    }

    public Node<E> getMaxNode(Node<E> node) {
        Node<E> max = node;
        while (max.rightChild != null) {
            max = max.rightChild;
        }
        return max;
    }

    /**
     * 查找某个节点
     *
     * @param e
     * @return
     */
    public Node<E> search(E e) {
        int count = 0;
        Node<E> current = root;
        while (current != null) {
            count++;
            if (current.item.compareTo(e) > 0) {
                current = current.leftChild;
            } else if (current.item.compareTo(e) < 0) {
                current = current.rightChild;
            } else if (current.item.compareTo(e) == 0) {
                System.out.println("查找次数为：" + count);
                return current;
            }
        }
        return null;
    }

    /**
     * 查找某节点的后继节点
     *
     * @param node
     * @return
     */
    public Node<E> getSuccessor(Node<E> node) {
        if (node.rightChild != null) {
            return getMinNode(node.rightChild);
        } else {
            Node<E> parentNode = node.parent;
            while (parentNode != null && parentNode.rightChild == node) {
                node = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
    }

    /**
     * 查找某节点的前驱节点
     *
     * @param node
     * @return
     */
    public Node<E> getPrecursor(Node<E> node) {
        if (node.leftChild != null) {
            return getMinNode(node.leftChild);
        } else {
            Node<E> parentNode = node.parent;
            while (parentNode != null && parentNode.leftChild == node) {
                node = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
    }


    public boolean deleteBST(Node<E> node, E key) {
        if (node == null) {
            return false;
        } else {
            if (node.item.compareTo(key) == 0) {
                return delete(node);
            } else if (node.item.compareTo(key) > 0) {
                return deleteBST(node.leftChild, key);
            } else {
                return deleteBST(node.rightChild, key);
            }
        }
    }

    public boolean delete(Node<E> node) {
        return true;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(1);
        tree.insert(1);
        tree.insert(9);
        tree.insert(3);
        tree.insert(7);
        tree.insert(0);
        tree.insert(4);
        System.out.println(tree.getMin().item);
        System.out.println(tree.getMax().item);
        tree.search(1);
        System.out.println(tree.getSuccessor(tree.search(4)).item);
        System.out.println(tree.getPrecursor(tree.search(7)).item);
    }
}
