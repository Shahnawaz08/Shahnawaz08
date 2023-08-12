package AdvanceDSA.LL;

import java.util.Scanner;

public class P12_longestPalindromicList {
    static int countCommon(ListNode a, ListNode b)
    {
        int count = 0;

        // loop to count common in the list starting
        // from node a and b

        for (; a != null && b != null;
             a = a.next, b = b.next)

            // increment the count for same values
            if (a.val== b.val)
                ++count;
            else
                break;

        return count;
    }
    public static int solve(ListNode A) {
        int result = 0;
        ListNode prev = null, curr = A;

        // loop till the end of the linked list
        while (curr != null)
        {
            // The sublist from head to current
            // reversed.
            ListNode next = curr.next;
            curr.next = prev;

            // check for odd length
            // palindrome by finding
            // longest common list elements
            // beginning from prev and
            // from next (We exclude curr)
            result = Math.max(result,
                    2 * countCommon(prev, next)+1);

            // check for even length palindrome
            // by finding longest common list elements
            // beginning from curr and from next
            result = Math.max(result,
                    2*countCommon(curr, next));

            // update prev and curr for next iteration
            prev = curr;
            curr = next;
        }
        return result;
    }
    public static ListNode createLL(int n,Scanner sc){
        int x=sc.nextInt();
        ListNode head=new ListNode(x);
        ListNode tail=head;
        for(int d=2;d<=n;d++){
            x=sc.nextInt();
            tail.next=new ListNode(x);
            tail=tail.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of LinkedList ");
        int n=sc.nextInt();
        ListNode head=createLL(n,sc);
        int longestpalindrome=solve(head);
        System.out.println("Longest palindrome have size "+longestpalindrome);



    }
}
