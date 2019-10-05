package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {

    private String myS;
    @Override
    public String getString() {
        if (myS != null){
                return myS;}
        return null;
    }

    @Override
    public void setString(String string) throws NullPointerException {
        this.myS = string;

    }

    @Override
    public int countNumbers() throws NullPointerException, IllegalArgumentException {
        int count = 0;
        if (this.myS == null) {
            throw new NullPointerException("gives null exception");
        } else {
            for (int i = 0; i < myS.length() - 1; i++) {
                if (Character.isDigit(myS.charAt(i)) && !Character.isDigit(myS.charAt(i+1))) {
                    count++;
                }
            }
        }

        return count;

    }

    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) throws IllegalArgumentException, NullPointerException {

        String newS = "";

        if (this.myS != null){
            if ( n <= 0){
                throw new IllegalArgumentException();
            }
            if ( myS == null && n > 0){

                throw new NullPointerException();

            }
            if (startFromEnd == true){
                for (int i = myS.length()-n; i >=0 ; i-=n){
                    newS = myS.charAt(i) + newS;
                }

            }
            else {
                for (int i = n - 1; i<myS.length(); i+=n){
                    newS = newS + myS.charAt(i);

                }
            }
        }
        else if (myS.length() < n) {
            return "";
        }
        else return "";


        return newS;
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition)
        throws MyIndexOutOfBoundsException, IllegalArgumentException, NullPointerException {

            if (startPosition > endPosition){
                throw new IllegalArgumentException();
            }
            if (startPosition <= endPosition && (startPosition > myS.length() || endPosition > myS.length())) {
                throw new MyIndexOutOfBoundsException();
            }
            if (startPosition <= endPosition && (startPosition > 0 && endPosition > 0 ) && myS == null){
                throw new NullPointerException();

            }




            String myString = myS.substring(startPosition-1, endPosition);

            myString = myString.replaceAll("10", "Ten");
            myString = myString.replaceAll("0", "Zero");
            myString = myString.replaceAll("1", "One");
            myString = myString.replaceAll("2", "Two");
            myString = myString.replaceAll("3", "Three");
            myString = myString.replaceAll("4", "Four");
            myString = myString.replaceAll("5", "Five");
            myString = myString.replaceAll("6", "Six");
            myString = myString.replaceAll("7", "Seven");
            myString = myString.replaceAll("8", "Eight");
            myString = myString.replaceAll("9", "Nine");


            this.myS = myS.substring(0, startPosition-1) + myString
                    + myS.substring(endPosition, myS.length());

    }
}
