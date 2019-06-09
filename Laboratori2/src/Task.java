import java.util.*;

public class Task{


    public static List<Integer> withinRange(List<Integer> l, int max, int min) {
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (i >= min && i < max) {
                list.add(i);
            }
        }
        return list;
    }

    public static <E extends Comparable <E>> List<E> withinRange(List<E> l, E max, E min)  {

        List<E> list = new ArrayList<>();
        Iterator<E> it = l.iterator();
        while (it.hasNext()) {
            E val = it.next();
            if ( val.compareTo(min) >= 0 &&  val.compareTo(max)<0) {
                list.add(val);
            }
        }
            return list;
        }

    public static <E> List withinTange(Comparator<E> comp,List<E> l,E max,E min){
        List<E> list = new ArrayList<>();
        Iterator<E> it = l.iterator();
        while (it.hasNext()) {
            E val = it.next();
            if (comp.compare(val,min)>= 0 &&  comp.compare(val,max)<0) {
                list.add(val);
            }
        }
        return list;
    }
    public static <E extends Comparable<? super E>> void copyWithRange(List<? extends E> src, List<? super E> trg, E max, E min) {
        Iterator<? extends E> srcit = src.iterator();
        ListIterator<? super E> trgit = trg.listIterator(); //El creo com ListIterator, ja que podem obtenir valors aixi com afegirlos en qualsevol punt del iterador, i per tant, sol cal afegirlos al target.
        while(srcit.hasNext()) {
            E val = srcit.next();
            if (val.compareTo(min) >= 0 &&  val.compareTo(max)<0) {
                if (trgit.hasNext()) {
                    trgit.next();
                    trgit.set(val);
                } else {
                    trgit.add(val);
                }
            }
        }
    }

    public static <E> void copyWithRange(Comparator<E> comp, List<? extends E> src, List<? super E> trg, E max, E min) {
        Iterator<? extends E> srcit = src.iterator();
        ListIterator<? super E> trgit = trg.listIterator();
        while(srcit.hasNext()) {
            E val = srcit.next();
            if (comp.compare(val,min)>= 0 &&  comp.compare(val,max)<0) {
                if (trgit.hasNext()) {
                    trgit.next();
                    trgit.set(val);
                } else {
                    trgit.add(val);
                }
            }
        }
    }
    }

