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
public class NodeMain extends AbsNode implements IAggregate {
    NodeAux previousDown;
    NodeAux nextDown;

    public NodeMain() {}

    public NodeMain(int val) {
        super(val);
    }

    public NodeMain(NodeAux previousDown, NodeAux nextDown, INode previous, INode next, int val) {
        super(previous, next, val);
        this.previousDown = previousDown;
        this.nextDown = nextDown;
    }
    
    public INode getPreviousDown() {
        return previousDown;
    }
    
    public void setPreviousDown(NodeAux previousDown) {
        this.previousDown = previousDown;
        previousDown.next = this;
    }
    
    public void setPrevious(NodeAux previous) {
        super.setPrevious(previous);
        previous.next = this;
    }
    
    public INode getNextDown() {
        return nextDown;
    }
    
    public void setNextDown(NodeAux nextDown) {
        this.nextDown = nextDown;
        nextDown.setPrevious(this);
    }
    
    public void setNext(NodeAux next) {
        super.setNext(next);
        next.setPrevious(this);
    }

    @Override
    public IIterator getIterator() {
        return new NodeIterator(this);
    }
    
    private class NodeIterator implements IIterator<INode> {

        private int iter;
        NodeMain nodeActual;

        public NodeIterator(NodeMain nodeActual) {
            this.nodeActual = nodeActual;
            if ((nodeActual.previous != null && nodeActual.previous.getPrevious() != null) ||
                    (nodeActual.previousDown != null && nodeActual.previousDown.getPrevious() != null))
                iter = 3;
            else
                iter = 1;
        }
        
        @Override
        public boolean hasNext() {
            switch(iter) {
                case 1:
                    if (nodeActual.previous != null) { return true; }
                case 2:
                    iter = 2;
                    if (nodeActual.previousDown != null) { return true; }
                case 3:
                    iter = 3;
                    return true;
                case 4:
                    iter = 4;
                    if (nodeActual.next != null) { return true; }
                case 5:
                    iter = 5;
                    if (nodeActual.nextDown != null) { return true; }
                default:
                    iter = -1;
                    return false;
            }
        }

        @Override
        public INode next() {
            if (hasNext()){
                switch(iter) {
                        case 1:
                            iter++;
                            return previous;
                        case 2:
                            iter++;
                            return previousDown;
                        case 3:
                            iter++;
                            return nodeActual;
                        case 4:
                            iter++;
                            return next;
                        case 5:
                            iter++;
                            return nextDown;
                        default:
                            iter = -1;
                            return null;
                    }
            }
            
            return null;
        }
        
    }
}
