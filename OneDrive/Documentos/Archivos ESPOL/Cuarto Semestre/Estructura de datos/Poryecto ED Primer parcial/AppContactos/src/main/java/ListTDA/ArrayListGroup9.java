/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListTDA;

/**
 *
 * @author Abeni
 */
public class ArrayListGroup9<E> implements ListGroup9<E>  {
    private E[] elements;
    private int MAX_SIZE = 100;
    private int effectiveSize;

    public ArrayListGroup9() {
        elements = (E[]) new Object[MAX_SIZE];
        effectiveSize = 0;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return this.effectiveSize==0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            elements[effectiveSize] = element;
            effectiveSize++;
            return true;
        }
        if (isFull()) {
            addCapacity();
        }
       //{23,5.6} {23,23,5,6}
        // empujar para hacer espacio. Bit shifting
        for (int i = effectiveSize; i >= 1; i--) {
            elements[i] = elements[i-1];
        }
        elements[0] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean add(E element) {
        if (element == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        //con humildad
        //elements[effectiveSize] = element;
        //effectiveSize++;
        // con orgullo
        elements[effectiveSize++] = element;
        return true;
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > effectiveSize) {
            // throw new IndexOutOfBoundsException("Invalid index: " + index);
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i - 1];
            // elements[i+1] = elements[i]; MAL
        }
        elements[index] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public E remove(int index) {
        
        
        if(index < 0 || index > effectiveSize)return null;
        E e = this.elements[index];
        
        E[] newElements = (E[])new Object[effectiveSize];
        for (int i = 0,j=0; i < newElements.length; i++) {
            if(i!=index){
                newElements[j] = this.elements[i];
                j++;
            }
        }
        this.effectiveSize--;
        this.elements = newElements;
        
        
        return e;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
          if(index<0|| index >= effectiveSize) return null;
          E temporal = this.elements[index];
          this.elements[index] = element;
          return temporal;
    }

    private void addCapacity() {
        MAX_SIZE = MAX_SIZE * 2;
        E[] newElements = (E[]) new Object[MAX_SIZE];
        // copiando los elementos del arreglo viejo al nuevo
//        for (int i= 0; i<effectiveSize; i++) {
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    private boolean isFull() {
        return effectiveSize == MAX_SIZE;
    }

    @Override
    public void reverse() {
        //{1,2,3}  --> [3,2,1]  3
        E[] newElements = (E[]) new Object[effectiveSize];
        for (int i = 0; i < this.effectiveSize; i++) {
            newElements[i] = elements[effectiveSize-1-i]; 
        }
        this.elements = newElements;
        
    }

    @Override
    public ListGroup9<E> subList(int from, int to) {
        ListGroup9<E> newArray = new ArrayListGroup9<E>();
        
        boolean cond1 = from >= 0 && from <= this.effectiveSize;
        boolean cond2 = to >=0 && to <= this.effectiveSize;
        if(cond1 & cond2){
           
            for (int i = from,j=0; i <= to; i++) {
                newArray.add(j,this.elements[i]);
                j++;
           }
            //System.out.println(newArray);
            return newArray;
        }     
        return newArray;
        
    }

    @Override
    //s [1, 2,3, 4, 5, 6], y n es 3, la lista queda así: [4, 5, 6].
    public boolean removeFirstNElements(int n) {
        if(isEmpty()==true && (n>0 && n<=effectiveSize)){
            return false;
        }
        int m = this.effectiveSize;
        for (int i = n,j=0; i <m ; i++) {
            this.elements[j] = this.elements[i];
            j++;           
        }
        this.effectiveSize-=n;
        return true;
        
    }
    
    @Override 
    public String toString(){
        String string = "";
        for (int i = 0; i < this.effectiveSize; i++) {
                string += this.elements[i] + ", ";
        }
        if(!"".equals(string)){
            return  "["+string.substring(0,string.length()-2)+"]";
        }
        return "";
    
    }
    public boolean remove(Object o){
        return true;
    }

}
