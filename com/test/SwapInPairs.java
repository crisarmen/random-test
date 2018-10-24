package com.test;

public class SwapInPairs {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        } else {
            //at least 2 nodes.
            ListNode p1;
            ListNode p2 = head.next;
            ListNode p0;

            p1 = p2.next;
            p2.next = head;
            p0 = head;
            head = p2;

            if(p1 == null) {    //just 2
                p0.next = null;
            } else {
                ListNode p3;
                do {
                    if(p1 != null) {
                        p2 = p1.next;
                    } else {
                        p2 = p1;
                    }

                    if(p2 != null) {
                        p3 = p2.next;
                    } else {
                        p3 = p2;
                    }

                    if(p1 == null || p2 == null) {
                        p0.next = p1;
                        break;  //TODO improve this bad condition..
                    } else {
                        p2.next = p1;
                        p0.next = p2;

                        p0 = p1;
                        p1 = p3;
                    }

                } while(true);
            }

            return head;
        }
    }

}
