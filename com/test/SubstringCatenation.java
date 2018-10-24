package com.test;

import java.util.*;

public class SubstringCatenation {

    public static void main(String[] args) {
        String[] d = {"a", "a"};
        List<Integer> aaabbbaaa = new SubstringCatenation().findSubstring("a", d);
        int a = 1;

    }

    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0) {
            return Arrays.asList();
        } else {
            List<Integer> l = new ArrayList<>();
            Map<Integer,MultiSetAux> map = new HashMap<>();
            MultiSetAux multiDic = new MultiSetAux();
            for(String w : words) {
                multiDic.add(w);
            }

            int len = words[0].length();
            for(int i = 0; i <= s.length() - len; i++) {
                String currStr = s.substring(i, i + len);
                if(multiDic.keys().contains(currStr)) {
                    MultiSetAux currSet = new MultiSetAux();
                    currSet.add(currStr);
                    map.put(i, currSet);

                    //case for singleton
                    if(currSet.equals(multiDic)) {
                        l.add(i);
                    }

                    for(int j = i - len; j >= 0; j -= len) {
                        MultiSetAux s1 =  map.get(j);
                        if(s1 != null) {
                            if(s1.get(currStr) >= multiDic.get(currStr)) {
                                map.put(j, null);
                                break;
                            } else {
                                s1.add(currStr);
                                if(s1.equals(multiDic)) {
                                    l.add(j);
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            return l;
        }
    }


//    public List<Integer> findSubstring(String s, String[] words) {
//        if(words.length == 0) {
//            return Arrays.asList();
//        } else {
//            List<Integer> l = new ArrayList<>();
//            Map<Integer, Set<String>> map = new HashMap<>();
//            Set<String> dic = new MyHashSet<>();
//            Set<String> multiDic = new MyHashSet<>();
//            for(String w : words) {
//                multiDic.add(w);
//            }
//
//            int len = words[0].length();
//            for(int i = 0; i <= s.length() - len; i++) {
//                String currStr = s.substring(i, i + len);
//                if(dic.contains(currStr)) {
//                    Set<String> currSet = new MyHashSet<>();
//                    currSet.add(currStr);
//                    map.put(i, currSet);
//
//                    for(int j = i - len; j >= 0; j -= len) {
//                        Set<String> s1 = map.get(j);
//                        if(s1 != null) {
//                            if(s1.contains(currStr)) {
//                                map.put(j, null);
//                            } else {
//                                s1.add(currStr);
//                                if(s1.size() == dic.size()) {
//                                    l.add(j);
//                                }
//                            }
//                        } else {
//                            break;
//                        }
//                    }
//                }
//            }
//            return l;
//        }
//    }

   static class MultiSetAux {
        private Map<String, Integer> integerMap = new HashMap<>();

        private void add(String k) {
            integerMap.compute(k ,(k1, o) -> (o == null ? 1 : o + 1));
        }

        private int get(String k) {
            return integerMap.get(k) == null ? 0 : integerMap.get(k);
        }

        private Set<String> keys(){
            return integerMap.keySet();
        }

       @Override
       public boolean equals(Object o) {
           if (this == o) return true;
           if (o == null || getClass() != o.getClass()) return false;
           MultiSetAux that = (MultiSetAux) o;
           return Objects.equals(integerMap, that.integerMap);
       }

       @Override
       public int hashCode() {
           return Objects.hash(integerMap);
       }
   }
}
