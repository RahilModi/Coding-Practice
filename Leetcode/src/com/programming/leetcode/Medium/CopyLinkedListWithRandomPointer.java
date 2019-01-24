package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

//Please read solution of leetcode problem : 138 for detailed explanation..
public class CopyLinkedListWithRandomPointer {

    //Below two solutions take O(N) time and O(N) space...
    Map<RandomListNode, RandomListNode> visited = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        if(visited.containsKey(head)){
            return visited.get(head);
        }
        RandomListNode node = new RandomListNode(head.label);
        visited.put(head,node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    Map<RandomListNode, RandomListNode> visitedNodes = new HashMap<>();
    public RandomListNode copyRandomListIterative(RandomListNode head) {
        if(head == null) return null;
        RandomListNode oldNode = head;
        RandomListNode newNode = new RandomListNode(head.label);
        visitedNodes.put(oldNode, newNode);
        while(oldNode != null){
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visitedNodes.get(head);
    }

    public RandomListNode getClonedNode(RandomListNode node){
        if(node != null){
            if(visitedNodes.containsKey(node)){
                return visitedNodes.get(node);
            }else{
                visitedNodes.put(node, new RandomListNode(node.label));
                return visitedNodes.get(node);
            }
        }
        return null;
    }

    //We can do it in O(1) space using a->a'->b->b'->c->c' => a->b->c & a'->b'->c'
    public RandomListNode copyRandomListNoExtraSpace(RandomListNode head) {
        if(head ==null) return null;

        RandomListNode ptr = head;

        while(ptr != null){
            RandomListNode newNode =new RandomListNode(ptr.label);
            newNode.next = ptr.next;
            ptr.next =newNode;
            ptr = newNode.next;
        }

        ptr = head;

        while(ptr != null){
            ptr.next.random = ptr.random != null ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        ptr=head;
        RandomListNode newHead = ptr.next;
        RandomListNode res = newHead;
        while(ptr != null){
            ptr.next = res.next;
            ptr = ptr.next;
            res.next = ptr == null ? null : ptr.next;
            res = res.next;
        }
        return newHead;
    }


}
