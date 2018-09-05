
/**
 * Implementação de Lista Sequencial de forma orientada a objetos.
 *
 */
public class Lista {

    /**
     * Tamanho máximo da lista.
     */
    private static final int TAMANHO_LISTA = 100;
    /**
     * Tamanho atual da lista.
     */
    private int n;
    /**
     * Vetor que armazena os nós.
     */
    private No lista[] = new No[TAMANHO_LISTA];

    public Lista() {
        //Inicializa a lista o 0 nós
        n = 0;
    }

    /**
     * Recuporador de N.
     *
     * @return Um inteiro com a quantidade de nós da lista.
     */
    public int getN() {
        return n;
    }

    /**
     * Modificador de N.
     *
     * @param n Um valor inteiro a ser atribuído para a N.
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * Insere um nó em uma posição especifica da lista.
     *
     * @param novo Novo nó a ser inserido.
     * @param k Posição a ser inserida o valor.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirPosicao(No novo, int k) {
        if (n < TAMANHO_LISTA) {
            //Verifica se a posição está no intervalo de valores da lista.
            if ((k >= 0) && (k <= getN())) {
                //Desloca os nós do fim até a posição k
                for (int i = n - 1; i >= k; i--) {
                    lista[i + 1] = lista[i];
                }
                //Insere o novo valor na posição k.
                lista[k] = novo;
                //Incrementa a quantidade de nós.
                setN(getN() + 1);
                return true;
            } else {
                System.out.print("Posição inválida!\n");
                return false;
            }
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
    }

    /**
     * Insere um nó no início da lista.
     *
     * @param novo Novo nó a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirInicio(No novo) {
        return inserirPosicao(novo, 0);
    }

    /**
     * Insere um nó no final da lista.
     *
     * @param novo Novo nó a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirFim(No novo) {
        return inserirPosicao(novo, getN());
    }

    /**
     * Inclui de forma ordenado um nó na lista levando em consideração o
     * seu valor.
     *
     * @param novo Novo nó ser inserido.
     *
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirOrdenado(No novo) {
        if (n < TAMANHO_LISTA) {
            int i = 0;
            while ((i < getN()) && (novo.getDado() > lista[i].getDado())) {
                i = i + 1;
            }
            if (i <= n) {
                return inserirPosicao(novo, i);
            } else {
                System.out.print("Posição Inválida!");
                return false;
            }
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
    }

    /**
     * Excluir um Nó da lista pela posição.
     *
     * @param k Posição do nó a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor da posição.
     */
    public boolean excluirPosicao(int k) {
        if (n != 0) {
            //Verifica se a posição está no intervalo de nós da lista.
            if ((k >= 0) && (k < getN())) {
                //Desloca os nós do fim até a posição k da lista.
                for (int i = k; i < getN(); i++) {
                    lista[i] = lista[i + 1];
                }
                //Decrementa a quantidade de nós da lista.
                setN(getN() - 1);
                return true;
            } else {
                System.out.print("Posicao invalida!\n");
                return false;
            }
        } else {
            System.out.print("A lista está vazia!\n");
            return false;
        }
    }

    /**
     * Excluir um nó do final da lista.
     *
     * @return Verdadeiro ou falso se excluiu o valor do final.
     */
    public boolean excluirFim() {
        return excluirPosicao(getN() - 1);
    }

    /**
     * Excluir um nó do início da lista.
     *
     * @return Verdadeiro ou falso se excluiu o valor do início.
     */
    public boolean excluirInicio() {
        return excluirPosicao(0);
    }

    /**
     * Excluir um nó da lista pelo valor.
     *
     * @param chave Nó a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor.
     */
    public boolean excluirValor(No chave) {
        if (getN() != 0) {
            int i = 0;
            //Procura a posição do nó na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((i < getN()) && (chave.getDado() != lista[i].getDado())) {
                i = i + 1;
            }
            //Verifica se a posição esta dentro do intervalo da lista
            if (i < n) {
                //Chama o método excluir para a posição i
                excluirPosicao(i);
                return true;
            } else {
                System.out.print("Valor nao existe na lista!\n");
                return false;
            }
        } else {
            System.out.print("Lista Vazia!");
            return false;
        }
    }

    /**
     * Retorna a posição de um nó na lista.
     *
     * @param chave Nó a ser procurado na lista.
     * @return A posição de valor na lsita.
     */
    public int posicaoValor(No chave) {
        if (getN() != 0) {
            int i = 0;
            //Procura a posição do nó na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((i < getN()) && (chave.getDado() != lista[i].getDado())) {
                i = i + 1;
            }
            //Verifica se a posição esta dentro do intervalo da lista
            if (i < getN()) {
                return i;
            } else {
                return -1;
            }
        } else {
            System.out.print("Lista Vazia!");
            return -1;
        }
    }

    /**
     * Lista os dados da lista.
     *
     * @return Uma String com os dados da lista.
     */
    public String listar() {
        String temp = "";
        for (int i = 0; i < getN(); i++) {
            temp = temp + (i) + "-" + lista[i] + "\n";
        }
        return temp;
    }

    /**
     * Retorna se a lista está cheia.
     *
     * @return Verdadeiro ou falso se a lista está cheia.
     */
    public boolean estaCheia() {
        return getN() == TAMANHO_LISTA;
    }

    /**
     * Retorna se a lista esta vazia.
     *
     * @return Verdadeiro ou falso se a lista está vazia.
     */
    public boolean estaVazia() {
        return getN() == 0;
    }
}