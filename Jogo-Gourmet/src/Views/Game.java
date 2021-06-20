package Views;

import Domain.Model.Node;
import Domain.Service.ArvoreDePratosService;

import javax.swing.*;

public class Game {
    ArvoreDePratosService arvorePratos;

    public Game() {
        this.arvorePratos = new ArvoreDePratosService();
    }
    private void configInicialGame(){
        arvorePratos.adicionar(null,"Massa",true);
        arvorePratos.adicionar(arvorePratos.getNode(),"Lasanha", true);
        arvorePratos.adicionar(arvorePratos.getNode(), "Bolo de chocolate", false);
    }

    public void IniciaJogo(){
        if(arvorePratos.estaVazia()){
            configInicialGame();
        }

        int respostaInicial = telaInicialJogo();

        if(respostaInicial == JOptionPane.CLOSED_OPTION){
            finalizaJogo();
        }

        while (true){
            adivinhaPrato(arvorePratos.getNode());
        }

    }

    private int telaInicialJogo() {
        String[] opt = {"OK"};
        return JOptionPane.showOptionDialog(null,"     Pense em um prato que gosta.","Jogo Gourmet",1, -1, null,opt , opt[0]);
    }

    private void adivinhaPrato(Node node) {
        int resposta = perguntaPrato(node.getPrato());

        if(resposta == JOptionPane.CLOSED_OPTION) {
            finalizaJogo();
        }else if (resposta == 0) {
            if(node.eFolha()){
                acertei();
            }else{
                adivinhaPrato(node.getEsquerdo());
            }
        }else {
            if(node.getDireito() == null){
                montaNovoPrato(node);
                IniciaJogo();
            }else{
                adivinhaPrato(node.getDireito());
            }
        }
    }
    private  int perguntaPrato(String prato) {
        return JOptionPane.showConfirmDialog(null, "O prato que você pensou é "+prato+"? ", "Confirm",0);
    }

    private void montaNovoPrato(Node node) {
        String novoPrato = JOptionPane.showInputDialog("Qual prato você pensou?");
        String dica = JOptionPane.showInputDialog(novoPrato+" é __________mas "+node.getPrato()+" não.");

        criaNovoNode(node, novoPrato, dica);
    }

    private void criaNovoNode(Node node, String novoPrato, String dica){
        String pratoAtual = node.getPrato();
        node.setPrato(dica);
        node.setEsquerdo(new Node(novoPrato));
        node.setDireito(new Node(pratoAtual));
    }

    private  void  acertei() {
        JOptionPane.showMessageDialog(null, "Acertei de novo!", "Jogo Gourmet",1);
        IniciaJogo();
    }
    private void finalizaJogo() {
        System.exit(0);
    }

}

