package com.example.project;

public class SinglyLinkedList<T extends Comparable <T>> {
  private Node<T> first; // Primero nodo de la lista
  private int size; // Tamano de la lista

  // Constructor (crea lista vacia)
  SinglyLinkedList() {
    first = null;
    size = 0;
  }

  // Retorna el tamano de la lista
  public int size() {
    return size;
  }

  // Devuelve true si la lista esta vazia o false caso contrario
  public boolean isEmpty() {
    return (size == 0);
  }

  // Adiciona v al inicio de la lista
  public void addFirst(T v) {
    Node<T> newNode = new Node<T>(v, first);
    first = newNode;
    size++;
  }

  // Adiciona v al final de la lista
  public void addLast(T v) {
    Node<T> newNode = new Node<T>(v, null);
    if (isEmpty()) {
      first = newNode;
    } else {
      Node<T> cur = first;
      while (cur.getNext() != null)
	cur = cur.getNext();
      cur.setNext(newNode);
    }
    size++;
  }

  // Retorna el primer valor de la lista (o null si la lista esta vacia)
  public T getFirst() {
    if (isEmpty())
      return null;
    return first.getValue();
  }

  // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
  public T getLast() {
    if (isEmpty())
      return null;
    Node<T> cur = first;
    while (cur.getNext() != null)
      cur = cur.getNext();
    return cur.getValue();
  }

  // Elimina el primer elemento de la lista (si esta vacia no hara nada)
  public void removeFirst() {
    if (isEmpty())
      return;
    first = first.getNext();
    size--;
  }

  // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
  public void removeLast() {
    if (isEmpty())
      return;
    if (size == 1) {
      first = null;
    } else {
      // Ciclo con for y uso de size para mostrar alternativa al while
      Node<T> cur = first;
      for (int i = 0; i < size - 2; i++)
	cur = cur.getNext();
      cur.setNext(cur.getNext().getNext());
    }
    size--;
  }

  // Convierte la lista para um String
  public String toString() {
    String str = "{";
    Node<T> cur = first;
    while (cur != null) {
      str += cur.getValue();
      cur = cur.getNext();
      if (cur != null)
	str += ",";
    }
    str += "}";
    return str;
  }

  // NUEVOS METODOS

  // Elimina aquellos nodos de la lista que esten duplicados
  public void deleteDuplicates() {
    if (size ==0) System.out.println("vacio");
    int contador = 0;
    Node <T> puntero1 = this.first;
    for (int i =1 ; i <size;i++){
      Node <T> puntero2 = puntero1.getNext();
      contador = i;
      for (int j =i; j <size; j++){
	contador++;
	if (puntero1.getValue().equals(puntero2.getValue())) deleteNth(contador-1);
	puntero2 = puntero2.getNext();
	//System.out.println("i"+i+"j"+j+"contador"+(contador-1));
      }
      puntero1 = puntero1.getNext();
    }

  }

  // Inserta un nuevo nodo en una posicion especifica de la lista
  public void insertNth(T data, int position) {
    //System.out.println("se introduc nuevo nodo en posicion : "+position);
    Node <T> cur = searchIndex(position-1);
    if (position == this.size) {
	    addLast(data);
	    return;
    }
    if ( position == 0) addFirst(data);
    if (position >= this.size) System.out.println("Fuera de rango");
    if ( cur != null){
      cur.setNext( new Node<T>(data, cur.getNext()));
    }

  }

  // Elimina el nodo de una posicion especifica de la lista
  public void deleteNth(int position) {
    //System.out.println("se eliminara a : "+ position);
    Node <T> cur = searchIndex(position-1);
    if (cur != null) {
      cur.setNext(cur.getNext().getNext());
      size--;
    }else System.out.println("Fuera de rango");

  }
  public Node <T> searchIndex(int i){
    //System.out.println("se buscara indice"+ i);
    Node <T> cur = this.first;
    int contador = 0;
    while (i >= 0 && cur != null && contador != i ){
      cur = cur.getNext();
      contador++;
    }
    if(i<0) return null;
    if (cur != null) return cur;
    return null;

  }

  public static void main(final String[] args) {

    testExercicio1();
    testExercicio2();
    testExercicio3();       

  }

  public static void testExercicio1(){

    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

    list.addLast(47);
    list.addLast(89);
    list.addLast(56);
    list.addLast(89);
    list.addLast(56);

    System.out.println(list);

    list.deleteDuplicates();

    System.out.println(list);
  }

  public static void testExercicio2(){

    SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

    list.addLast('a');
    list.addLast('b');
    list.addLast('d');

    System.out.println(list);

    list.insertNth('c', 2);

    System.out.println(list);
  }

  public static void testExercicio3(){

    SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

    list.addLast('a');
    list.addLast('b');
    list.addLast('d');

    System.out.println(list);

    list.deleteNth(2);

    System.out.println(list);
  }

}
