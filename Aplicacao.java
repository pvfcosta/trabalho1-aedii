public class Aplicacao {

    public static boolean somenteVogais(String entrada){
        int num = 0;
        boolean resp;

        for (int i = 0; i < entrada.length(); i++) {

            if (((entrada.charAt(i)) != 'A') && (entrada.charAt(i)) != 'a')
                if (((entrada.charAt(i)) != 'E') && (entrada.charAt(i)) != 'e')
                    if (((entrada.charAt(i)) != 'I') && (entrada.charAt(i)) != 'i')
                        if (((entrada.charAt(i)) != 'O') && (entrada.charAt(i)) != 'o')
                            if (((entrada.charAt(i)) != 'U') && (entrada.charAt(i)) != 'u')
                                num++;
        }

        if (num == 0)
            resp=true;
        else
            resp=false;

        return resp;
    }

    public static boolean somenteConsoantes(String entrada){
        int num = 0;
        boolean resp;

        for (int i = 0; i < entrada.length(); i++) {

            if (((entrada.charAt(i)) != 'A') && (entrada.charAt(i)) != 'a')
                if (((entrada.charAt(i)) != 'E') && (entrada.charAt(i)) != 'e')
                    if (((entrada.charAt(i)) != 'I') && (entrada.charAt(i)) != 'i')
                        if (((entrada.charAt(i)) != 'O') && (entrada.charAt(i)) != 'o')
                            if (((entrada.charAt(i)) != 'U') && (entrada.charAt(i)) != 'u')
                                num++;
                                if((((entrada.charAt(i)) < 'A') || (entrada.charAt(i) > 'Z' && entrada.charAt(i) < 'a') || (entrada.charAt(i)) > 'z'))
                                    num--;
        }

        if (num == entrada.length())
            resp=true;
        else
            resp=false;

        return resp;
    }

    public static boolean nInteiro(String entrada){
        int num = 0;
        boolean resp;

        for (int i = 0; i < entrada.length(); i++) {

            if ((entrada.charAt(i) >= '0') && (entrada.charAt(i) <= '9'))
                num++;
            else
                if(entrada.charAt(i) == '-')
                    num++;

        }

        if (num == entrada.length())
            resp=true;
        else
            resp=false;

        return resp;
    }

    public static boolean nReal(String entrada){
        int num = 0;
        int virg = 0;
        boolean resp;

        for (int i = 0; i < entrada.length(); i++) {

            if ((entrada.charAt(i) >= '0') && (entrada.charAt(i) <= '9'))
                num++;
            else
                if (entrada.charAt(i) == '-')
                    num++;
                else
                    if (entrada.charAt(i) == ',' || entrada.charAt(i) == '.') {
                        num++;
                        virg++;
                    }
        }

        if (num == entrada.length() && virg<=1)
            resp=true;
        else
            resp=false;

        return resp;
    }

    public static void main(String[] args){

        String entrada;
        entrada = MyIO.readLine();

        while (!(entrada.equals("FIM"))) {
            if (somenteVogais(entrada))
                System.out.print("SIM ");
            else
                System.out.print("NAO ");

            if (somenteConsoantes(entrada))
                System.out.print("SIM ");
            else
                System.out.print("NAO ");

            if (nInteiro(entrada))
                System.out.print("SIM ");
            else
                System.out.print("NAO ");

            if (nReal(entrada))
                System.out.print("SIM\n");
            else
                System.out.print("NAO\n");

            entrada = MyIO.readLine();
        }

    }
}

