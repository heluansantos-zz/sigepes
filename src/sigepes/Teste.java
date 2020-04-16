package sigepes;

import DAO.PessoaDao;
import JDBC.ConnectionFactory;
import Model.Pessoa;
import java.util.List;


public class Teste {

    
    public static void main(String[] args) {
        
       PessoaDao dao = new PessoaDao();
       List<Pessoa> pessoas = dao.getList();
       
       
       if( pessoas != null){
           for(int x=0; x<pessoas.size(); x++){
               pessoas.get(x).mostraPessoa();
               System.out.println("_________________________________");
           }
       }else{
           System.out.println("Lista Nula");
       }
    }
}
