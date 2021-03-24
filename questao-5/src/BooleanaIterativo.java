public class BooleanaIterativo {
    public static boolean Booleana(String s){
        return Booleana(s,0,true);
    }

    private static boolean Booleana(String s, int i,boolean resp){
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

        resp = RealizaOperacao(s,i,resp,a,b,c);

        return resp;
    }

    private static boolean RealizaOperacao(String s, int i, boolean resp, boolean a, boolean b, boolean c){
        char op;

        op = VerificaOperacao(s, i);
        i = ProcuraOperacao(s,i);

        if (op=='e'){
            resp = OpAnd(s,i,resp,a,b,c);
            i = ContaOp(s,i);
        }
        else if (op=='o'){
            resp = OpOr(s,i,resp,a,b,c);
            i = ContaOp(s,i);
        }
        else if (op=='n'){
            resp = OpNot(s,i,resp,a,b,c);
            i = ContaOpNot(s,i);
        }
        return resp;
    }
    private static boolean OpAnd(String s, int i, boolean resp, boolean a, boolean b, boolean c) {
        char op;
        boolean primeiroT = true;
        boolean segundoT = true;
        boolean terceiroT = true;
        op = VerificaOperacao(s, i);
        i = ProcuraOperacao(s, i);

        if (s.charAt(6) == '0' || s.charAt(6) == '1') {
            if (op == 'a') {
                primeiroT = a;
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                primeiroT = b;
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                primeiroT = c;
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                primeiroT = OpAnd(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'o') {
                primeiroT = OpOr(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'n') {
                primeiroT = OpNot(s,i,resp,a,b,c);
                i = ContaOpNot(s, i);
            }
            i++;
            op = VerificaOperacao(s, i);
            i = ProcuraOperacao(s, i);

            if (op == 'a') {
                segundoT = a;
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                segundoT = b;
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                segundoT = c;
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                segundoT = OpAnd(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'o') {
                segundoT = OpOr(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'n') {
                segundoT = OpNot(s,i,resp,a,b,c);
                i = ContaOpNot(s, i);
            }
            i++;
            op = VerificaOperacao(s, i);
            i = ProcuraOperacao(s, i);

            if (op == 'a') {
                terceiroT = a;
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                terceiroT = b;
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                terceiroT = c;
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                terceiroT = OpAnd(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'o') {
                terceiroT = OpOr(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'n') {
                terceiroT = OpNot(s,i,resp,a,b,c);
                i = ContaOpNot(s, i);
            }

        } else {
                if (op == 'a') {
                    primeiroT = a;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'b') {
                    primeiroT = b;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'c') {
                    primeiroT = c;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'e') {
                    primeiroT = OpAnd(s,i,resp,a,b,c);
                    i = ContaOp(s, i);
                } else if (op == 'o') {
                    primeiroT = OpOr(s,i,resp,a,b,c);
                    i = ContaOp(s, i);
                } else if (op == 'n') {
                    primeiroT = OpNot(s,i,resp,a,b,c);
                    i = ContaOpNot(s, i);
                }

            i++;
            op = VerificaOperacao(s, i);
            i = ProcuraOperacao(s, i);

                if (op == 'a') {
                    segundoT = a;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'b') {
                    segundoT = b;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'c') {
                    segundoT = c;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'e') {
                    segundoT = OpAnd(s,i,resp,a,b,c);
                    i = ContaOp(s, i);
                } else if (op == 'o') {
                    segundoT = OpOr(s,i,resp,a,b,c);
                    i = ContaOp(s, i);
                } else if (op == 'n') {
                    segundoT = OpNot(s,i,resp,a,b,c);
                    i = ContaOpNot(s, i);
                }
            }
        if (s.charAt(6) == '0' || s.charAt(6) == '1') {
            return (primeiroT && segundoT && terceiroT);
        }
        else return (primeiroT && segundoT);


    }

    private static boolean OpOr(String s, int i, boolean resp, boolean a, boolean b, boolean c) {
        char op;
        boolean primeiroT = true;
        boolean segundoT = true;
        boolean terceiroT = true;
        op = VerificaOperacao(s, i);
        i = ProcuraOperacao(s, i);
        if (s.charAt(6) == '0' || s.charAt(6) == '1') {
            if (op == 'a') {
                primeiroT = a;
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                primeiroT = b;
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                primeiroT = c;
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                primeiroT = OpAnd(s,i,resp,a,b,c);
                i = ContaOp(s,i);
            } else if (op == 'o') {
                primeiroT = OpOr(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'n') {
                primeiroT = OpNot(s,i,resp,a,b,c);
                i = ContaOpNot(s, i);
            }
            i++;
            op = VerificaOperacao(s, i);
            i = ProcuraOperacao(s, i);

            if (op == 'a') {
                segundoT = a;
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                segundoT = b;
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                segundoT = c;
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                segundoT = OpAnd(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'o') {
                segundoT = OpOr(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'n') {
                segundoT = OpNot(s,i,resp,a,b,c);
                i = ContaOpNot(s, i);
            }
            i++;
            op = VerificaOperacao(s, i);
            i = ProcuraOperacao(s, i);

            if (op == 'a') {
                terceiroT = a;
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                terceiroT = b;
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                terceiroT = c;
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                terceiroT = OpAnd(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'o') {
                terceiroT = OpOr(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'n') {
                terceiroT = OpNot(s,i,resp,a,b,c);
                i = ContaOpNot(s, i);
            }

        } else {
            if (s.charAt(6) == '0' || s.charAt(6) == '1') {
                if (op == 'a') {
                    primeiroT = a;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'b') {
                    primeiroT = b;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'c') {
                    primeiroT = c;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'e') {
                    primeiroT = OpAnd(s,i,resp,a,b,c);
                    i = ContaOp(s, i);
                } else if (op == 'o') {
                    primeiroT = OpOr(s,i,resp,a,b,c);
                    i = ContaOp(s, i);
                } else if (op == 'n') {
                    primeiroT = OpNot(s,i,resp,a,b,c);
                    i = ContaOpNot(s, i);
                }

                i++;
                op = VerificaOperacao(s, i);
                i = ProcuraOperacao(s, i);

                if (op == 'a') {
                    segundoT = a;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'b') {
                    segundoT = b;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'c') {
                    segundoT = c;
                    i = ProcuraOperacao(s, i);
                } else if (op == 'e') {
                    segundoT = OpAnd(s,i,resp,a,b,c);
                    i = ContaOp(s, i);
                } else if (op == 'o') {
                    segundoT = OpOr(s,i,resp,a,b,c);
                    i = ContaOp(s, i);
                } else if (op == 'n') {
                    segundoT = OpNot(s,i,resp,a,b,c);
                    i = ContaOpNot(s, i);
                }

            }
        }
        if (s.charAt(6) == '0' || s.charAt(6) == '1') {
            return (primeiroT || segundoT || terceiroT);
        }
        else return (primeiroT || segundoT);
    }

    private static boolean OpNot(String s, int i, boolean resp, boolean a, boolean b, boolean c) {
        char op;
        boolean termo = true;
        op = VerificaOperacao(s, i);
        i = ProcuraOperacao(s, i);
            if (op == 'a') {
                termo = !a;
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                termo = !b;
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                termo = !c;
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                termo = OpAnd(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'o') {
                termo = OpOr(s,i,resp,a,b,c);
                i = ContaOp(s, i);
            } else if (op == 'n') {
                termo = OpNot(s,i,resp,a,b,c);
                i = ContaOpNot(s, i);
            }


                return termo;

    }

    private static int ContaOp(String s, int i){
        char op;
        op = VerificaOperacao(s, i);
        i = ProcuraOperacao(s, i);
        if (s.charAt(6) == '0' || s.charAt(6) == '1') {
            if (op == 'a') {
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                i = ContaOp(s, i);
            } else if (op == 'o') {
                i = ContaOp(s, i);
            } else if (op == 'n') {
                i = ContaOp(s, i);
            }

            i++;
            op = VerificaOperacao(s, i);
            i = ProcuraOperacao(s, i);

            if (op == 'a') {
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                i = ContaOp(s, i);
            } else if (op == 'o') {
                i = ContaOp(s, i);
            } else if (op == 'n') {
                i = ContaOp(s, i);
            }
            i++;
            op = VerificaOperacao(s, i);
            i = ProcuraOperacao(s, i);

            if (op == 'a') {
                i = ProcuraOperacao(s, i);
            } else if (op == 'b') {
                i = ProcuraOperacao(s, i);
            } else if (op == 'c') {
                i = ProcuraOperacao(s, i);
            } else if (op == 'e') {
                i = ContaOp(s, i);
            } else if (op == 'o') {
                i = ContaOp(s, i);
            } else if (op == 'n') {
                i = ContaOp(s, i);
            }

        } else {
            if (s.charAt(6) == '0' || s.charAt(6) == '1') {
                if (op == 'a') {
                    i = ProcuraOperacao(s, i);
                } else if (op == 'b') {
                    i = ProcuraOperacao(s, i);
                } else if (op == 'c') {
                    i = ProcuraOperacao(s, i);
                } else if (op == 'e') {
                    i = ContaOp(s, i);
                } else if (op == 'o') {
                    i = ContaOp(s, i);
                } else if (op == 'n') {
                    i = ContaOp(s, i);
                }

                i++;
                op = VerificaOperacao(s, i);
                i = ProcuraOperacao(s, i);

                if (op == 'a') {
                    i = ProcuraOperacao(s, i);
                } else if (op == 'b') {
                    i = ProcuraOperacao(s, i);
                } else if (op == 'c') {
                    i = ProcuraOperacao(s, i);
                } else if (op == 'e') {
                    i = ContaOp(s, i);
                } else if (op == 'o') {
                    i = ContaOp(s, i);
                } else if (op == 'n') {
                    i = ContaOp(s, i);
                }


            }
        }
        return i;
    }

    private static int ContaOpNot(String s, int i) {
        char op;
        op = VerificaOperacao(s, i);
        i = ProcuraOperacao(s, i);
        if (op == 'a') {
            i = ProcuraOperacao(s, i);
        } else if (op == 'b') {
            i = ProcuraOperacao(s, i);
        } else if (op == 'c') {
            i = ProcuraOperacao(s, i);
        } else if (op == 'e') {
            i = ContaOp(s, i);
        } else if (op == 'o') {
            i = ContaOp(s, i);
        } else if (op == 'n') {
            i = ContaOpNot(s, i);
        }

        return i;

    }

    private static char VerificaOperacao(String s, int i){
        char op = 'x';
        while (op == 'x' && i<s.length()){
            if (s.charAt(i) == 'a' && s.charAt(i+1) == 'n') {
                op = 'e';
                i += 4;
            }
            else if (s.charAt(i) == 'n' && s.charAt(i+1) == 'o') {
                op = 'n';
                i += 4;
            }
            else if (s.charAt(i) == 'o' && s.charAt(i+1) == 'r') {
                op = 'o';
                i += 3;
            }
            else if (s.charAt(i) == 'A')
                op = 'a';
            else if (s.charAt(i) == 'B')
                op = 'b';
            else if (s.charAt(i) == 'C')
                op = 'c';
            else i++;
        }
        return op;
    }

    private static int ProcuraOperacao(String s, int i){
        char op = 'x';
        while (op == 'x' && i<s.length()){
            if (s.charAt(i) == 'a' && s.charAt(i+1) == 'n') {
                op = 'a';
                i += 4;
            }
            else if (s.charAt(i) == 'n' && s.charAt(i+1) == 'o') {
                op = 'n';
                i += 4;
            }
            else if (s.charAt(i) == 'o' && s.charAt(i+1) == 'r') {
                op = 'o';
                i += 3;
            }
            else if (s.charAt(i) == 'A')
                op = 'a';
            else if (s.charAt(i) == 'B')
                op = 'b';
            else if (s.charAt(i) == 'C')
                op = 'c';
            else i++;
        }
        return i;
    }

    public static void main(String[] args){

        String s;
        s = MyIO.readLine();

        while (!(s.charAt(0)=='0')) {
            if (Booleana(s))
                System.out.println('1');
            else
                System.out.println('0');
            s = MyIO.readLine();
        }

    }
}
