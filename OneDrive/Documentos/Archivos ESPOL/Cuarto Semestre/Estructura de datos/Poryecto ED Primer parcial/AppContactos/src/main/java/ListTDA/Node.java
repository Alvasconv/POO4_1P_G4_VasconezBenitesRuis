/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListTDA;

/**
 *
 * @author Abeni
 */
public class Node<E> {
    private E content;
    private Node<E> next;
    
    public Node (E content) {
        this.content = content;
        this.next = null;
    }
    
    public Node (E content, Node<E> next) {
        this(content);
        this.next = next;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    
}
