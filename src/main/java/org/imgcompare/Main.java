package org.imgcompare;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            // Vérifier qu'on a bien 2 paramètres
            if (args.length < 2) {
                System.out.println("Il faut 2 fichiers en paramètre");
                return;
            }

            String pathA = args[0];
            String pathB = args[1];

            // Lecture des images
            BufferedImage imgA = ImageIO.read(new File(pathA));
            BufferedImage imgB = ImageIO.read(new File(pathB));

            if (imgA == null || imgB == null) {
                System.out.println("Une image n'est pas valide");
                return;
            }

            if (imgA.getWidth() != imgB.getWidth() ||
                    imgA.getHeight() != imgB.getHeight()) {
                System.out.println("Les images ne sont pas de la même taille");
                return;
            }

            // Créer le comparateur
            ImageComparator comparator = new ImageComparator();

            // Comparaison pixel par pixel
            int diffPixels = comparator.countDifferentPixels(imgA, imgB);

            // Affichage OK / KO selon le sujet
            if (diffPixels < 1000) {
                System.out.println("OK");
            } else {
                System.out.println("KO");
            }

            System.out.println("Les deux images diffèrent de " + diffPixels + " pixels.");

            // Génération de l'image différentielle
            BufferedImage diff = comparator.generateDiffImage(imgA, imgB);

            if (diff == null) {
                System.out.println("Erreur : échec de la génération de l'image différentielle.");
                return;
            }

            // Écriture du fichier PNG (diff.png)
            ImageIO.write(diff, "png", new File("./images/diff.png"));

            System.out.println("Image différentielle générée dans le dossier images : diff.png");

        } catch (IOException ex) {
            System.out.println("ioeXCEPTION : " + ex.getMessage());
            IO.print("fff");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
