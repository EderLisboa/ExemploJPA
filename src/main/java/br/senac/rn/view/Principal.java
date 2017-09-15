package br.senac.rn.view;

import br.senac.rn.dao.CategoriaDAO;
import br.senac.rn.dao.ProdutoDAO;
import br.senac.rn.dao.SexoDAO;
import br.senac.rn.model.Categoria;

public class Principal {

    public static void main(String[] args) {

        SexoDAO dao = new SexoDAO();

        CategoriaDAO daoC = new CategoriaDAO();

        daoC.inserir(new Categoria(0, "ESporte", "tenis"));

        ProdutoDAO daoP = new ProdutoDAO();

        System.exit(0);

    }

}
