import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Main
{

    public static void main(String[] args)
    {
        try {
            File katalog = new File("Wideokursy" + File.separator + "php" + File.separator + "mysql");
            katalog.mkdirs();
            File plik2 = new File("Wideokursy" + File.separator + "php" + File.separator + "mysql", "lekcja1.txt");
            if(!plik2.exists())
                plik2.createNewFile();


        File plik = new File("test.txt");
        if(!plik.exists())
            {
            plik.createNewFile();
            }
        System.out.println("Czy moge pisac? "+plik.canWrite());
        System.out.println("Czy moge odpalic? "+plik.canExecute());
        System.out.println("Czy moge czytac? "+plik.canRead());
        System.out.println("Czy jest ukryty? "+plik.isHidden());
        System.out.println("Czy jest plikiem? "+plik.isFile());
        System.out.println("Kiedy edytowane? "+new Date(plik.lastModified()));
        System.out.println("Długośc pliku w bajtach: "+plik.length());

        Main.wypiszSciezki(new File(System.getProperty("user.dir")));
            }
        catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }

        System.out.println(System.getProperty("java.home"));


    }
    public static void wypiszSciezki(File nazwaSciezki)
    {

        String[] nazwyPlikowIKatalogow = nazwaSciezki.list();



        for(int i = 0; i < nazwyPlikowIKatalogow.length; i++)
        {
        File p = new File(nazwaSciezki.getPath(), nazwyPlikowIKatalogow[i]);

        if(p.isFile())
        System.out.println(p.getPath());

        if (p.isDirectory())
            wypiszSciezki(new File(p.getPath()));
        }
    }
}
