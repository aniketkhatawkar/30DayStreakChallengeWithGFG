class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // Your code here
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;   
            fast = fast.next.next;
        }
        
        Node start2 = reverseLinkedList(slow);
        Node start1 = head;
        
        while(start2!=null){
            if(start2.data!=start1.data){
                return false;
            }
            start2=start2.next;
            start1=start1.next;
        }
        
        return true;
    }
    Node reverseLinkedList(Node curr){
        Node prev = null;
        Node head = curr;
        Node next = null;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}