public class AlgBooleana {
    public static boolean AlgBooleana (String s){
        return AlgBooleana(s,0,true);
    }
    private static boolean AlgBooleana(String s, int i, boolean resp) {
        boolean a;
        boolean b;
        boolean c = true;

        if (s.charAt(2) == '1')
            a = true;
        else a = false;
        if (s.charAt(4) == '1')
            b = true;
        else b = false;
        if (s.charAt(0) == '3') {
            if (s.charAt(6) != '1')
                c = false;
            i += 8;
        }
        else i += 6;

        resp = VerificaOperacao(s,i,resp,a,b,c);

        return resp;
    }
    private static boolean VerificaOperacao(String s, int i, boolean resp, boolean a, boolean b, boolean c){
        boolean primeirot;
        boolean segundot;

            if (i==s.length())
                return resp;
            else if (s.charAt(i) == 'a' && s.charAt(i+1) == 'n') {
                i+=4;
                primeirot = VerificaLetra(s, i, resp, a, b, c);
                i+=4;
                segundot = VerificaLetra(s, i, resp, a, b, c);

                resp = primeirot && segundot;
            }
            else if (s.charAt(i) == 'n' && s.charAt(i+1) == 'o') {
                i += 4;
                resp = !VerificaLetra(s, i, resp, a, b, c);
            }
            else if (s.charAt(i) == 'o' && s.charAt(i+1) == 'r') {
                i+=3;
                primeirot = VerificaLetra(s, i, resp, a, b, c);
                i++;
                segundot = VerificaLetra(s, i, resp, a, b, c);

                resp = primeirot || segundot;
            }
            else{
                i++;
                resp = VerificaLetra(s, i, resp, a, b, c);
            }

        return resp;
    }

    private static boolean VerificaLetra(String s, int i, boolean resp, boolean a, boolean b, boolean c){
            if (i==s.length())
                return resp;
            else if (s.charAt(i) == 'A') {
                resp = a;
            }
            else if (s.charAt(i) == 'B') {
                resp = b;
            }
            else if (s.charAt(i) == 'C') {
                resp = c;
            }
            else resp = VerificaOperacao(s, i, resp, a, b, c);

        return resp;
    }

    public static void main(String[] args){

        String s;
        s = MyIO.readLine();

        while (!(s.charAt(0)=='0')) {
            if (AlgBooleana(s))
                System.out.println('1');
            else
                System.out.println('0');
            s = MyIO.readLine();
        }

    }



}
