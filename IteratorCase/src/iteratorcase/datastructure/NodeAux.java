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
public class NodeAux extends AbsNode {

    public NodeAux() {}

    public NodeAux(int val) {
        super(val);
    }

    public NodeAux(INode previous, INode next, int val) {
        super(previous, next, val);
    }
    
}
