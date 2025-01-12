package fr.diginamic.immobilier.entites;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaisonTest {
    
    private Maison maison;
    
    @Before
    public void setUp() {
        maison = new Maison();
    }

    @Test
    public void testAjouterPiece() {
        Piece salon = new Salon(0, 15);
        Piece wc = new WC(1, 10);
        
        maison.ajouterPiece(salon);
        maison.ajouterPiece(wc);
        
        Piece[] pieces = maison.getPieces();
        assertEquals(2, pieces.length);
        assertEquals(salon, pieces[0]);
        assertEquals(wc, pieces[1]);
    }
    
    @Test
    public void testAjouterPieceNull() {
        
        maison.ajouterPiece(null);
        
        Piece[] pieces = maison.getPieces();
        assertEquals(0, pieces.length);
    }
    
    @Test
    public void testNbPieces() {
    	 Piece salon = new Salon(0, 15);
         Piece wc = new WC(1, 10);
        
         maison.ajouterPiece(salon);
         maison.ajouterPiece(wc);
        
        assertEquals(2, maison.nbPieces());
    }
    
    @Test
    public void testSuperficieEtage() {
    	Piece salon = new Salon(0, 15);
        Piece wc = new WC(1, 10);
        Piece chambre = new Chambre(0, 12);
        
        maison.ajouterPiece(salon);
        maison.ajouterPiece(wc);
        maison.ajouterPiece(chambre);
        
        assertEquals(27, maison.superficieEtage(0));
        assertEquals(10, maison.superficieEtage(1));
    }
    
    
    @Test
    public void testSuperficieTypePiece() {
        	Piece salon = new Salon(0, 15);
            Piece wc = new WC(1, 10);
            Piece chambre = new Chambre(0, 12);
            
            maison.ajouterPiece(salon);
            maison.ajouterPiece(wc);
            maison.ajouterPiece(chambre);
        
        assertEquals(15, maison.superficieTypePiece("Salon"));
        assertEquals(12, maison.superficieTypePiece("Chambre"));
        assertEquals(10, maison.superficieTypePiece("WC"));
    }
    
    @Test
    public void testCalculerSurface() {
    	Piece salon = new Salon(0, 15);
        Piece wc = new WC(1, 10);
        
        maison.ajouterPiece(salon);
        maison.ajouterPiece(wc);
        
        assertEquals(25.0, maison.calculerSurface());
    }
}