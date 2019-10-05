/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorcase.datastructure;

/**
 *
 * @author aborbon
 */
public class AbsNode implements INode {
    protected INode previous;
    protected INode next;
    
    protected int val;

    public AbsNode() {}

    public AbsNode(int val) {
        this.val = val;
    }

    public AbsNode(INode previous, INode next, int val) {
        this.previous = previous;
        this.next = next;
        this.val = val;
    }

    @Override
    public INode getPrevious() {
        return previous;
    }

    @Override
    public INode getNext() {
        return next;
    }

    @Override
    public void setPrevious(INode previous) {
        this.previous = previous;
    }

    @Override
    public void setNext(INode next) {
        this.next = next;
    }
    
    public int getVal(){
        return val;
    }
    
    public void setVal(int val) {
        this.val = val;
    }
    
    @Override
    public String toString(){
        return Integer.toString(val);
    }
}
