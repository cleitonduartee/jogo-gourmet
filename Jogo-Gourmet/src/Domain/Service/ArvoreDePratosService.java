package Domain.Service;

import Domain.Model.Node;

public class ArvoreDePratosService {

    private Node node;


    public void adicionar (Node nodePai, String novoPrato, boolean eEsquerdo){
        node = criaNovoNode(nodePai,novoPrato,eEsquerdo);
    }
    private Node criaNovoNode(Node nodePai, String novoPrato, boolean eEsquerdo){
        if(nodePai == null){
            nodePai = new Node(novoPrato);
            return  nodePai;
        }else if(eEsquerdo){
           nodePai.setEsquerdo(criaNovoNode(nodePai.getEsquerdo(), novoPrato,eEsquerdo));
        }else{
            nodePai.setDireito(criaNovoNode(nodePai.getDireito(), novoPrato, eEsquerdo));
        }
        return  nodePai;
    }

    public boolean estaVazia(){
        return getNode() == null;
    }

    public Node getNode() {
        return node;
    }
}
