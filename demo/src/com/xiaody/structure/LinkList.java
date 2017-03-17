package com.xiaody.structure;

/**
 * Created by Xiaody on 2017/2/27.
 */
public class LinkList<E>{

    private static class Node<E> {
        E item;
        Node prev;
        Node next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }


    private Node<E> first;

    private Node<E> last;

    private int size;


    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(e, null, f);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            first = newNode;
            f.prev = first;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, l, null);
        if (last == null) {
            last = newNode;
            first = newNode;
        } else {
            last = newNode;
            l.next = last;
        }
        size++;
    }

    public E get(int index) {
        if (index <= size >> 1) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x.item;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x.item;
        }
    }

    public int size() {
        return size;
    }



    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<>();
        linkList.addFirst("abc");
        linkList.addFirst("ss");
        linkList.addFirst("arasw");
        linkList.addFirst("fsd");
        linkList.addFirst("rwr");
        System.out.println(linkList.size());
        System.out.println(linkList.get(3));
    }

}
