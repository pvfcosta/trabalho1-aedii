public class IsRecursivo {

    public static boolean SomenteVogais(String s){
        return SomenteVogais(true,s,0);
    }

    public static boolean SomenteConsoantes(String s){
        return SomenteConsoantes(true,s,0);
    }

    public static boolean NInteiro(String s){
        return NInteiro(true,s,0);
    }

    public static boolean NReal(String s){
        return NReal(true,s,0,0);
    }

    private static boolean SomenteVogais(boolean resp, String s, int i){
        if (i == s.length())
            resp = true;
        else if (((s.charAt(i)) != 'A') && ((s.charAt(i)) != 'a'))
            if (((s.charAt(i)) != 'E') && ((s.charAt(i)) != 'e'))
                if (((s.charAt(i)) != 'I') && ((s.charAt(i)) != 'i'))
                    if (((s.charAt(i)) != 'O') && ((s.charAt(i)) != 'o'))
                        if (((s.charAt(i)) != 'U') && ((s.charAt(i)) != 'u'))
                            resp = false;
                        else resp = SomenteVogais(resp,s,i+1);
                    else resp = SomenteVogais(resp,s,i+1);
                else resp = SomenteVogais(resp,s,i+1);
            else resp = SomenteVogais(resp,s,i+1);
        else resp = SomenteVogais(resp,s,i+1);

        return resp;
    }
    private static boolean SomenteConsoantes(boolean resp, String s, int i) {
        if (i == s.length())
            resp = true;
        else if (((s.charAt(i)) != 'A') && ((s.charAt(i)) != 'a'))
            if (((s.charAt(i)) != 'E') && ((s.charAt(i)) != 'e'))
                if (((s.charAt(i)) != 'I') && ((s.charAt(i)) != 'i'))
                    if (((s.charAt(i)) != 'O') && ((s.charAt(i)) != 'o'))
                        if (((s.charAt(i)) != 'U') && ((s.charAt(i)) != 'u'))
                            if ((s.charAt(i) > 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) > 'a' && s.charAt(i) <= 'z')) {
                                resp = SomenteConsoantes(resp, s, i + 1);
                            }
                            else resp = false;
                        else resp = false;
                    else resp = false;
                else resp = false;
            else resp = false;
        else resp = false;

        return resp;
    }
    private static boolean NInteiro (boolean resp, String s,int i){
        if (i == s.length())
            resp = true;
        else if (((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) || (s.charAt(i) == '-'))
            resp = NInteiro(resp,s, i + 1);
        else resp = false;

        return resp;
    }
    private static boolean NReal (boolean resp, String s, int i, int virgula){
        if (i == s.length())
            resp = true;
        else if (((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) || (s.charAt(i) == '-'))
            resp = NReal(resp,s, i + 1,virgula);
        else if ((s.charAt(i) == ',' || s.charAt(i) == '.') && virgula==0){
            resp = NReal(resp,s, i + 1,virgula + 1);
        }
        else resp = false;

        return resp;
    }

    public static void main(String[] args){

        String s;
        s = MyIO.readLine();

        while (!(s.equals("FIM"))) {
            if (SomenteVogais(s))
                System.out.print("SIM ");
            else
                System.out.print("NAO ");

            if (SomenteConsoantes(s))
                System.out.print("SIM ");
            else
                System.out.print("NAO ");

            if (NInteiro(s))
                System.out.print("SIM ");
            else
                System.out.print("NAO ");

            if (NReal(s))
                System.out.print("SIM\n");
            else
                System.out.print("NAO\n");

            s = MyIO.readLine();
        }

    }

}
