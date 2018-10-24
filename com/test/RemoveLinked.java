package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by carmentano on 29/06/2018.
 */
public class RemoveLinked {

    public static void main(String[] args) {
        List<String> aaaaacccccaaaaaccccccaaaaagggttt = new RemoveLinked().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        int a = 1;
    }
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }

        if(head != null) {
            ListNode prev = head;
            ListNode next = head.next;

            while(next != null) {
                if(next.val == val) {
                    removeElement(prev);
                } else {
                    prev = prev.next;
                }
                next = next.next;
            }
        }

        return head;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> sol = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        for(int i = 0; i < s.length() - 10; i ++) {
            String currSeq = s.substring(i, i + 10);
            Integer compute = counts.compute(currSeq, (k, v) -> v == null ? 1 : v + 1);
            if(compute == 2) {
                sol.add(currSeq);
            }
        }

        return sol;
    }

    private void removeElement(ListNode prev) {
        ListNode el = prev.next;
        prev.next = el.next;
    }

     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
}
