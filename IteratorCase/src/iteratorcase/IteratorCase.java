/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorcase;

import iteratorcase.datastructure.INode;
import iteratorcase.datastructure.List;
import iteratorcase.datastructure.NodeAux;
import iteratorcase.datastructure.NodeMain;
import iteratorcase.iterator.IIterator;

/**
 *
 * @author aborbon
 */
public class IteratorCase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        NodeAux node1 = new NodeAux(1);
        NodeAux node2 = new NodeAux(2);
        NodeMain node3 = new NodeMain(3);
        NodeAux node4 = new NodeAux(4);
        NodeAux node5 = new NodeAux(5);
        NodeMain node6 = new NodeMain(6);
        NodeAux node7 = new NodeAux(7);
        NodeMain node9 = new NodeMain(9);
        NodeAux node10 = new NodeAux(10);
        
        node3.setPrevious(node1);
        node3.setPreviousDown(node2);
        node3.setNext(node4);
        node3.setNextDown(node5);
        
        node6.setPrevious(node4);
        node6.setPreviousDown(node5);
        node6.setNext(node7);
        
        node9.setPrevious(node7);
        node9.setNextDown(node10);
        
        List list = new List(node3);
        
        IIterator iterator = list.getIterator();
        
        while(iterator.hasNext()){
            INode node = (INode)iterator.next();
            System.out.println(node.toString());
        }
        
    }
    
}
