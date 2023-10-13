package com.company;

/**
 * Created by newma on 07/07/2017.
 */
public class Peca {

    ////////////////////////////////
    /// Atributos e propriedades ///
    ////////////////////////////////

    private char Cor = ' ';           // Aspeto da peça

    //////////////
    // Métodos  //
    //////////////

    /////////////////////////
    /// Getters & Setters ///
    /////////////////////////

    public void setCor(char simbolo)
    {
        this.Cor = simbolo;
    }

    public char getCor()
    {
        return Cor;
    }
}
