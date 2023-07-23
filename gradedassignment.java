// question1
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no.of elements");
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        cumulative(a);
    }
    public static void cumulative(int a[]){
        int result=1;
        for(int i=0;i<a.length;i++){
            result*=a[i];
            a[i]=result;
        }
        System.out.println("Cumulative multiplication of array: ");
        System.out.println(Arrays.toString(a));
    }
}
//question4
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int c=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=a[j];
                if(sum<0){
                    c++;
                }
            }
        }
        System.out.println(c);
    }
}

// question7
class Solution {
    public String longestPalindrome(String s) {
        int first=0;
        int last=0;
        for(int i=0;i<s.length();i++){
            int odd=expand(s,i,i);
            int even=expand(s,i,i+1);
            int len=Math.max(odd,even);
            if(len>last-first){
                first=i-(len-1)/2;
                last=i+len/2;
            }
        }
        return s.substring(first,last+1);
    }
    int expand(String s,int a,int b){
        while(a>=0 && b<s.length()&& s.charAt(a)==s.charAt(b)){
            a--;
            b++;

        }
        return b-a-1;
    }
}

//question 8
import java.util.*;
class Solution{
    
    public static boolean isBalance(String input){
        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='{'||input.charAt(i)=='['||input.charAt(i)=='('){
                s.push(input.charAt(i));
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                else{
                char t=s.pop();
                if(input.charAt(i)==']'&& t!='['){
                    return false;
                }
                else if(input.charAt(i)=='}'&&t!='{'){
                    return false;
                }
                else if(input.charAt(i)==')'&&t!='('){
                    return false;
                }
            }
            }
        }
    
    if(!s.isEmpty()){
        return false;
    }
    else return true;
    }
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            boolean result=isBalance(input);
            System.out.println(result);
            
		}
		
	}
    
}

// question 9
    import java.util.*;
    public class test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();
            int max=Integer.MIN_VALUE;
            Set<Integer> set=new HashSet<>();

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                
                deque.add(num);
                set.add(num);
                if(deque.size()==m){
                    if(set.size()>max){
                        max=set.size();
                    }
                    int item=(int) deque.remove();
                    if(!deque.contains(item)){
                        set.remove(item);
                    }
                    }
            }
            System.out.println(max);
        }
    }



// question 11

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp=new ListNode();
        temp.next=head;
        ListNode node=temp;
        while(node!=null){
            ListNode first=node.next;
            ListNode second=null;
            if(first!=null){
                second=first.next;
            }
            if(second!=null){
                ListNode secondNext=second.next;
                second.next=first;
                node.next=second;
                first.next=secondNext;
                node=first;
            }
            else{
                break;
            }
        }
        return temp.next;
    }
}

//question 12
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1){
            return head;
        }
    
    ListNode temp=new ListNode(-1);
    temp.next=head;
    int total=0;
    ListNode current=head;
    while(current!=null){
        total++;
        current=current.next;
    }
    current=head;
    ListNode suc=null;
    ListNode prev=temp;
    while(total>=k){
        current=prev.next;
        suc=current.next;
        for(int i=1;i<k;i++){
            current.next=suc.next;
            suc.next=prev.next;
            prev.next=suc;
            suc=current.next;
        }
        prev=current;
        total-=k;
    }
    return temp.next;
}
}


