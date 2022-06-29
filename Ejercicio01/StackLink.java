public class StackLink<E> implements Stack<E> {
  private Node<E> tope;
  public void push(E x){
    this.tope = new Node<E>(x, this.tope);
  }

  public E pop() throws ExceptionIsEmpty{
    E item = top();
    this.tope = this.tope.next;
    return item;
  }

  public E top() throws ExceptionIsEmpty{
    if(isEmpty())
      throw new ExceptionIsEmpty("Stack vacio");
    return this.tope.data;
  }

  public boolean isEmpty (){
    return this.tope == null;
  }

  public String toString(){
    String str = "";
    for (Node<E> i = this.tope; i != null; i = i.next) {
      str = i.toString() + " , " + str; 
    }
    return str;
  }

}
