package br.senac.rn.principal;

import br.senac.rn.dao.SexoDAO;
import br.senac.rn.model.Sexo;

public class Principal {
    
    public static void main(String[] args) {
        
        SexoDAO dao = new SexoDAO();
        
        dao.excluir(dao.buscarPorId(3));
        
        System.exit(0);
        
    }
    
}
