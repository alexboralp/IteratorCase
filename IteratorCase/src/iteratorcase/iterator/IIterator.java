/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorcase.iterator;


/**
 *
 * @author aborbon
 * @param <T>
 */
public interface IIterator<T> {
    public boolean hasNext();
    public T next();
}
