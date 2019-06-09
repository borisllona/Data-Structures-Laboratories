
    /**
     * @author Boris Llona Alonso
     * @author Flor Martinez Malaret
     */

    public interface Stack<E> {
        /**
         * @return Retorna si la pila es buida o no
         */
        boolean isEmpty();

        /**
         *
         * @return Retorna l'element top de la pila
         */
        E top();

        /**
         * Elimina l'element top de la pila
         */
        void pop();

        /**
         * Afegeix l'element e al top de la pila
         * @param e
         */
        void push(E e);
    }

