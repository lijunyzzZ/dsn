package com.ljy;

import javax.print.attribute.standard.Copies;

/**
 * 复杂链表的复制
 * 
 * @author 李君易
 *
 */
public class RandomList {
	public static class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}

		public RandomListNode() {
		}
	}

	public static RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null){
			return null;
		}
	
		//先复制链表将复制的链表节点放在原的链表中
		RandomListNode pCur = pHead;
		while(pCur != null){
			RandomListNode copy = new RandomListNode(pCur.label);
			copy.next = pCur.next;
			copy.random = null;
			pCur.next = copy;
			pCur = copy.next;
		}
		//复制random
		pCur = pHead;
		while(pCur != null){
			RandomListNode copyRNode = pCur.next;
			if(pCur.random != null){
				copyRNode.random = pCur.random;
			}
			pCur = copyRNode.next;
		}
		pCur = pHead;
		//拆分原链和复制链
		RandomListNode Head = pHead.next;
		RandomListNode cNode = pHead.next;
		pCur.next = cNode.next;
		pCur = cNode.next;
		while(pCur != null){
			//1'->2'
			cNode.next = pCur.next;
			pCur.next = cNode.next;
			pCur = pCur.next;
			cNode = cNode.next;
			
		}
		
		return Head;
	}
	public static void main(String[] args) {

        RandomListNode head = new RandomListNode();
        head.label = 1;

        RandomListNode RandomListNode2 = new RandomListNode();
        RandomListNode2.label = 2;

        RandomListNode RandomListNode3 = new RandomListNode();
        RandomListNode3.label = 3;

        RandomListNode RandomListNode4 = new RandomListNode();
        RandomListNode4.label = 4;

        RandomListNode RandomListNode5 = new RandomListNode();
        RandomListNode5.label = 5;

        head.next = RandomListNode2;
        head.random = RandomListNode3;

        RandomListNode2.next = RandomListNode3;
        RandomListNode2.random = RandomListNode5;

        RandomListNode3.next = RandomListNode4;

        RandomListNode4.next = RandomListNode5;
        RandomListNode4.random = RandomListNode2;

        RandomListNode copyHead = Clone(head);

        RandomListNode RandomListNode = copyHead;
        while(RandomListNode != null){
            System.out.println(RandomListNode);
            RandomListNode = RandomListNode.next;
        }

    }

}
