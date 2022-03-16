package Recursion.SubsetStringSubsiquence;

public class RemoveAs {
    public static void main(String[] args) {
        System.out.println(removeAs("aabbbaadab"));
        System.out.println(skipString("apleaplsih","ap"));
    }

    static String removeAs(String input){
        if(input.length() == 0)
            return "";

        char ch = input.charAt(0);
        if(ch == 'a'){
            return removeAs(input.substring(1));
        }else{
            return ch+removeAs(input.substring(1));
        }
    }

    static String skipString(String input, String skip){
        if(input.length() == 0)
            return "";

        if(input.startsWith(skip)){
            return skipString(input.substring(skip.length()),skip);
        }else{
            return input.charAt(0)+skipString(input.substring(1),skip);
        }
    }
}
