package com.programming.leetcode.Easy;

/***
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.
 *
 * The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
 *
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
 *
 * Note:
 *
 * words has length in range [0, 50].
 * words[i] has length in range [1, 10].
 * S has length in range [0, 500].
 * All characters in words[i] and S are lowercase letters.
 */
public class BoldWordString {

    public String boldWords(String[] words, String input){
        //Alternative to boolean array we can use HashSet and HashMap
        boolean[] boldTags = new boolean[input.length()];
        for(String word: words){
            for (int i = -1; (i = input.indexOf(word, i + 1)) != -1; i++) {
                //System.out.println(i);
                int index = i;
                while(index < i + word.length())
                    boldTags[index++] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < boldTags.length; i++){
            if(boldTags[i]){
                if(i==0 || !boldTags[i-1])
                    sb.append("<b>");
                sb.append(input.charAt(i));
                if(i == (boldTags.length-1) || !boldTags[i+1])
                    sb.append("</b>");
            }else{
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BoldWordString obj = new BoldWordString();
        System.out.println(obj.boldWords(new String[]{"ab","bc"},"abbcabcacdefcabc"));
    }
}
