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
            int indicePorao = indice;
            while(indicePorao < porao.length){
                if(porao[indicePorao] == null){
                   porao[indicePorao] = chave;
                   return true;
                }
                indicePorao++;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int chave) {
        int indice = Hash(chave);
        if (tabela[indice] != null && tabela[indice] == chave) {
            tabela[indice] = null;
            return true;
        } else{
            int indicePorao = indice;
            while(indicePorao < porao.length){
                if(porao[indicePorao] != null && porao[indicePorao] == chave){
                   porao[indicePorao] = null;
                   return true;
                }
                indicePorao++;
            }
        }
        return false;
    }

    @Override
    public int search(int chave) {
        int indice = Hash(chave);
        if (tabela[indice] != null && tabela[indice] == chave) {
            return indice;
        } else{
            int indicePorao = 0;
            while(indicePorao < porao.length){
                if(porao[indicePorao] != null && porao[indicePorao] == chave){
                    return indicePorao + tabela.length;
                }
                indicePorao++;
            }
        }        
        return -1;
    }

    public int Hash(int chave) {
        int retornoHash = chave % tabela.length;
        return retornoHash;
    }
}