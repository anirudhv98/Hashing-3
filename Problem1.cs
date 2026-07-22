// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Method Used - Robin Karp Algorithm
1. Assign integer values to each distinct character that can be present in sequence A -> 1, C -> 2, G -> 3, T -> 4. Maintain two hashsets - of type long to store rolling hash and string to store substring.
2. Starting from i = 0 to length of string, calculate rolling hash for each string as existing rolling hash * 4 + integer value of character.
3. If length of substring becomes greater than or equal to 10 (9 if zero-indexed), add rolling hash to rollingHashSet if it's not present. If present, add current substring to resultant hashset.
4. Remove the contribution of i - 9th character by subtracting 4^9 * value of the i - 9th character from rolling hash.
5. Return result after converting it into a list
*/

public class Solution {
    public IList<string> FindRepeatedDnaSequences(string s) {
        HashSet<string> result = new();
        HashSet<long> rollingHashSet = new();
        long rollingHash = 0;
        Dictionary<char, int> valueMap = new();
        valueMap['A'] = 1;
        valueMap['C'] = 2;
        valueMap['G'] = 3;
        valueMap['T'] = 4;
        long subtractValue = (long)Math.Pow(4,9);

        for(int i = 0; i < s.Length; i++)
        {

            rollingHash = rollingHash * 4 + (valueMap[s[i]]);

            if(i>=9)
            {
                if(!rollingHashSet.Contains(rollingHash))
                {
                    rollingHashSet.Add(rollingHash);
                }

                else
                {
                    result.Add(s.Substring(i-9, 10));
                }

                rollingHash -= subtractValue * valueMap[s[i-9]];
            }

            
        }

        return result.ToList();
    }
}