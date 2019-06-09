/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedStackTest {
    LinkedStack<Integer> pila = new LinkedStack<Integer>();
    LinkedStack<Integer> pila1 = new LinkedStack<Integer>();
    LinkedStack<String> pilaA = new LinkedStack<String>();
    LinkedStack<String> pilaB = new LinkedStack<String>();

    @Before
    public void inicialitzacio(){
        pila.push(1);
        pila.push(2);
    }

    /**
     * Per comprovar que la pila és buida eliminem els elements que té.
     */
    @Test
    public void isEmpty() {
        assertFalse(pila.isEmpty());
        pila.pop();
        pila.pop();
        assertTrue(pila.isEmpty());
    }
    @Test
    public void IsNotEmpty(){
        assertFalse(pila.isEmpty());
    }

    /**
     * Hem de fer el pop sobre la pila dos vegades perque quedi buida, ja que té dos elements
     */
    @Test
    public void pop() {
        pila.pop();
        assertFalse(pila.isEmpty());
        pila.pop();
        assertTrue(pila.isEmpty());
    }

    /**
     * Agafem l'element de la cima de la pila.
     */
    @Test
    public void topInt() {
        int a = pila.top();
        assertEquals(2,a);
        assertNotEquals(1,a);
    }
    @Test
    public void topString() {
        pilaA.push("Duracel");
        String a = pilaA.top();
        assertEquals("Duracel",a);
    }

    /**
     * inserim elements en una pila noma i comprovem que es igual a la que teniem
     */
    @Test
    public void push(){
        pila1.push(1);
        pila1.push(2);
        assertEquals(pila, pila1);
        pila1.pop();
        assertNotEquals(pila, pila1);
        pila1.push(125);
        assertNotEquals(pila, pila1);
    }

    /**
     * inserim elements en una pila noma i comprovem que es igual a la que teniem pero aquesta vegada amb strings
     */
    @Test
    public void pushString(){
        pilaA.push("Hola");
        pilaA.push("Adeu");
        pilaB.push("Hola");
        assertNotEquals(pilaB,pilaA);
        pilaA.pop();
        assertEquals(pilaB,pilaA);
    }

}


