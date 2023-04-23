package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados {
    private Integer tabela[];
    private Integer porao[];

    public EstruturaHashTable() {
        tabela = new Integer[1000];
        porao = new Integer[100];
    }

    @Override
    public boolean insert(int chave) {
        int indice = Hash(chave);
        if (tabela[indice] == null) {
            tabela[indice] = chave;
            return true;
        } else {            
            while(indice <= porao.length){
                if(porao[indice] == null){
                   porao[indice] = chave;
                   return true;
                }
                indice++;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int chave) {
        int indice = Hash(chave);

        // Verifica se a chave está na posição da tabela
        if (tabela[indice] != null && tabela[indice] == chave) {
            tabela[indice] = null;
            return true;
        } else {
            // Verifica se a chave está no porão
            for (int i = 0; i < porao.length; i++) {
                if (porao[i] != null && porao[i] == chave) {
                    porao[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int search(int chave) {
        int indice = Hash(chave);

        // Verifica se a chave está na posição da tabela
        if (tabela[indice] != null && tabela[indice] == chave) {
            return indice;
        } else {
            // Verifica se a chave está no porão
            for (int i = 0; i < porao.length; i++) {
                if (porao[i] != null && porao[i] == chave) {
                    return i + tabela.length;
                }
            }
        }
        return -1;
    }

    // Função de hash simples
    private int Hash(int chave) {
        int retornoHash = chave % tabela.length;
        return retornoHash;
    }
}
