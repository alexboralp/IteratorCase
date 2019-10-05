/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorcase.datastructure;

import iteratorcase.iterator.IAggregate;
import iteratorcase.iterator.IIterator;

/**
 *
 * @author aborbon
 */
public class List implements IAggregate{
    protected NodeMain main;

    public List(NodeMain main) {
        this.main = main;
    }

    @Override
    public IIterator getIterator() {
        return new ListIterator(main);
    }
    
    private class ListIterator implements IIterator<INode> {

        NodeMain first;
        NodeMain nodeActual;
        IIterator<INode> iterator;

        public ListIterator(NodeMain nodeActual) {
            this.first = nodeActual;
            this.nodeActual = first;
            iterator = this.first.getIterator();
        }
        
        @Override
        public boolean hasNext() {
            if (iterator.hasNext())
                return true;
            else {
                if (nodeActual.next != null && nodeActual.next.getNext() != null) {
                    nodeActual = (NodeMain) nodeActual.next.getNext();
                    iterator = nodeActual.getIterator();
                    return true;
                } else if (nodeActual.nextDown != null && nodeActual.nextDown.getNext() != null) {
                    nodeActual = (NodeMain) nodeActual.nextDown.getNext();
                    iterator = nodeActual.getIterator();
                    return true;
                }else {
                    return false;
                }
            }
        }

        @Override
        public INode next() {
            if (iterator.hasNext()) {
                return iterator.next();
            }
            
            return null;
        }
        
    }
    
    
}
