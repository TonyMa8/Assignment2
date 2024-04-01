package assignment2;

public class ActionQueue extends MyQueue<Direction> {
    private MyStack<String> stack;

    Direction North = Direction.NORTH;
    Direction South = Direction.SOUTH;
    Direction East = Direction.EAST;
    Direction West = Direction.WEST;


    public ActionQueue() {
        super();
        this.stack = new MyStack<String>();
    }

    public void clear() {
        this.stack.clear();
        super.clear();
    }

    public void loadFromEncodedString(String str) {
        int bracket_count = 0;
        String num = "";
        String str1="";
        String str2="";
        String strFinal="";

        for (int i = 0; i < str.length(); i++) {


            if (str.charAt(i) == '[') {
                if (num.equals("")) {
                    throw new IllegalArgumentException("Syntax Error: Missing K");
                }
                this.stack.push(num);
                bracket_count = bracket_count + 1;
                num = "";
            }

            else if (Character.isDigit(str.charAt(i))) {
                num += str.charAt(i);
            }

            else if (str.charAt(i) == 'N' || str.charAt(i) == 'S' || str.charAt(i) == 'E' || str.charAt(i) == 'W') {
                if (bracket_count == 1) {
                    str1 += str.charAt(i);
                } else if (bracket_count > 1) {
                    str2 += str.charAt(i);
                }else if(bracket_count == 0){
                    if (num != ""){
                        throw new IllegalArgumentException("Number used with no brackets");
                    }
                    strFinal += str.charAt(i);
                }else {
                    throw new IllegalArgumentException("Syntax Error: No brackets used");
                }
            }

            else if (str.charAt(i) == ']' && bracket_count == 1) {
                if (str1 == ""){
                    throw new IllegalArgumentException("No direction between brackets");
                }
                int times = Integer.parseInt(this.stack.pop());
                for (int x = 0; x < times; x++) {
                    strFinal += str1;
                }
                str1 = "";
                bracket_count--;
            }

            else if (str.charAt(i) == ']' && bracket_count > 1) {
                int times = Integer.parseInt(this.stack.pop());
                for (int x = 0; x < times; x++) {
                    str1 += str2;
                }
                str2 = "";
                bracket_count--;
            }

            else{
                throw new IllegalArgumentException("Inavalid input");
            }

        }


        for (int i = 0; i < strFinal.length(); i++) {
            Character temp = strFinal.charAt(i);
            switch (temp) {
                case 'N':
                    super.enqueue(North);
                    break;
                case 'S':
                    super.enqueue(South);
                    break;
                case 'E':
                    super.enqueue(East);
                    break;
                case 'W':
                    super.enqueue(West);
                    break;
            }
        }
    }
}

