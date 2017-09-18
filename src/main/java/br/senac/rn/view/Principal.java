package br.senac.rn.view;

import br.senac.rn.dao.CategoriaDAO;
import br.senac.rn.dao.ClienteDAO;
import br.senac.rn.dao.ProdutoDAO;
import br.senac.rn.dao.SexoDAO;
import br.senac.rn.model.Categoria;
import br.senac.rn.model.Cliente;
import br.senac.rn.model.Produto;

public class Principal {

    public static void main(String[] args) {

        SexoDAO dao = new SexoDAO();

        CategoriaDAO daoC = new CategoriaDAO();

        daoC.inserir(new Categoria(0, "ESporte", "tenis"));

        ProdutoDAO daoP = new ProdutoDAO();

        daoP.inserir(new Produto(0, "tenis", "para corrida", (float) 15.00, daoC.buscarPorId(0)));

        new ClienteDAO().inserir(new Cliente("arthur", "046.678.985-87", new SexoDAO().buscarPorId(3)));

        System.exit(0);

    }

}
