import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SharedStackTest{
    private SharedStack pilaA,pilaB;

    @Before //inicialitzem les piles, això ho farà abans de cada test
    public void inicialitzacio(){
        pilaA = new SharedStack();
        pilaB = new SharedStack();
    }

    @Test
    public void pushInt() throws StackError{
        pilaA = pilaA.push(1);
        pilaA = pilaA.push(2);
        pilaA = pilaA.push(3);
        pilaB = pilaB.push(1);
        pilaB = pilaB.push(2);
        assertEquals(pilaB,pilaA.pop());
    }

    @Test
    public void pushString() throws StackError{
        pilaA = pilaA.push("Hola");
        pilaA = pilaA.push("Adeu");
        pilaB = pilaB.push("Hola");
        assertEquals(pilaB,pilaA.pop());
    }

    @Test
    public void SameElementsDiferentOrder(){
        pilaA = pilaA.push(3);
        pilaA = pilaA.push(2);
        pilaA = pilaA.push(1);
        pilaB = pilaB.push(1);
        pilaB = pilaB.push(2);
        pilaB = pilaB.push(3);
        assertNotEquals(pilaB,pilaA);
    }


    @Test
    public void popEmpty(){ // retorna true si NO podem fer pop ja que li pasem una pila buida. false si la pila no es buida per tant podem fer el pop.
        boolean empty = false;
        try{
            pilaA = pilaA.pop();
        }catch(StackError error){
            empty = true;
            assertEquals("La pila es buida", error.getMessage());
            System.out.print("La pila es buida, per tant no podem fer pop.");
        }
        assertTrue(empty);

    }
    @Test
    public void popInt() throws StackError{
        pilaA = pilaA.push(1);
        pilaA = pilaA.push(2);
        pilaA = pilaA.pop();
        pilaB = pilaB.push(1);
        assertEquals(pilaB,pilaA);
    }

    @Test
    public void popString() throws StackError{
        pilaA = pilaA.push("Element1");
        pilaB = pilaB.push("Element1");
        pilaA = pilaA.push("Element2").pop();
        assertEquals(pilaB,pilaA);
    }

    @Test
    public void topEmpty(){   // retorna true si NO podem fer top ja que li pasem una pila buida. false si la pila no es buida per tant podem retornar el element superior.
        boolean empty = false;
        try{
            int a = (int)pilaA.top();
        }catch(StackError error){
            empty = true;
            assertEquals("La pila es buida", error.getMessage());
            System.out.print("La pila es buida, per tant no podem fer agafar l'element superior amb top");
        }
        assertTrue(empty);
    }

    @Test
    public void topInt() throws StackError {
        pilaA = pilaA.push(1);
        assertEquals(1,pilaA.top());
    }

    @Test
    public void topString() throws StackError {
        pilaA = pilaA.push("Duracel");
        assertEquals("Duracel",pilaA.top());
    }
    @Test
    public void IsEmpty() {
        assertTrue(pilaA.isEmpty());
    }
    @Test
    public void IsNotEmpty(){
        pilaA = pilaA.push(1999);
        assertFalse(pilaA.isEmpty());
    }

}
