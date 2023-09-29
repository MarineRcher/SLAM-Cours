package Exercies;


public class Exercice1 {
    public static void main(String[] args) {
        // tableau de 10 chaines
        String[] tableauChar = new String[10];
        tableauChar[0] = "sdd@gmail.com";
        tableauChar[1] = "a@outlook.fr";
        tableauChar[2] = "s@outlook.fr";
        tableauChar[3] = "e@gmail.com";
        tableauChar[4] = "h@gmail.com";
        tableauChar[5] = "y@outlook.fr";
        tableauChar[6] = "h@laposte.fr";
        tableauChar[7] = "v@gmail.com";
        tableauChar[8] = "o@gmail.com";
        tableauChar[9] = "m@gmail.com";

        String fournisseurGmail = "@gmail.com";
        String fournisseurLaposte = "@laposte.fr";
        String fournisseurOutlook = "@outlook.fr";

        fournisseurLaposte = fournisseurLaposte.intern();
        fournisseurGmail = fournisseurGmail.intern();
        fournisseurOutlook = fournisseurOutlook.intern();
        int gmail = 0 ;
        int laposte = 0;
        int outlook = 0;

        for(int i=0; i < tableauChar.length; i++) {
            int indexChar = tableauChar[i].indexOf('@');
            String fournisseur = tableauChar[i].substring(indexChar);
            if (fournisseur.equals(fournisseurGmail)) {
                ++gmail;
            } else if (fournisseur.equals(fournisseurLaposte) ) {
                ++laposte;
            } else if (fournisseur.equals(fournisseurOutlook) ) {
                ++outlook;
            }
        }
        System.out.println(gmail);
        System.out.println(laposte);
        System.out.println(outlook);
    }
}