package org.example.noteMagazine;
/**
 Given two strings, a "note" and a "magazine".
 Return true if the note can be constructed using the letters from the magazine. Else return false

 Example:

 Input:
 Note: [a]
 Magazine: [bcd]

 Op - False

 Input:
 Note: [aa]
 Magazine: [abc]

 Op - False


 Input:
 Note: [aa]
 Magazine: [abca]

 Op - True
 */
public class NoteMagazine {
    public static boolean checkIfConstructionPossible(String note, String magazine) {
        if(note.equals("") || magazine.equals("")) {
            return false;
        }
        String magazineCopy = new String(magazine);

        for (char letter : note.toCharArray()) {
            int index = magazineCopy.indexOf(letter);
            if(index == -1) {
                return false;
            }
            magazineCopy = magazineCopy.replace(Character.toString(letter), "");
        }
        return true;
    }

}
