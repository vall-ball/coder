package correcter;
@Deprecated
public class TrippleCoder {
    MessageUtils utils = new MessageUtils();

    public String trippleCoding(String str) {
        StringBuilder builder = new StringBuilder();
        char[] mass = str.toCharArray();
        for (char c : mass) {
            for (int i = 0; i < 3; i++) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String trippleDecoding(String str) {
        char[][] mass = utils.splitMass(str.toCharArray());
        StringBuilder builder = new StringBuilder();
        for (char[] m : mass) {
            builder.append(choiseSimbol(m));
        }
        return builder.toString();
    }

    public char choiseSimbol(char[] mass) {
        if (mass[0] == mass[1] || mass[0] == mass[2]) {
            return mass[0];
        } else {
            return mass[1];
        }
    }

}
