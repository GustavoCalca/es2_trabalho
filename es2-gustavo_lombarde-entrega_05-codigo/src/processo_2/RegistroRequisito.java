package processo_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RegistroRequisito {
        
	/* Cria uma tabela em um arquivo */
	public boolean criarArquivo( String nomeTabela, String [] nomesColunas) throws IOException
	{
		boolean resultadoCriacao = false;
		File arquivoTabela = new File(nomeTabela);
		FileWriter fw = new FileWriter(arquivoTabela.getName());
		arquivoTabela.createNewFile();
		for (int i=0; i < nomesColunas.length; ++i)
		{
			fw.write(nomesColunas[i]);
			if (i!= (nomesColunas.length-1) ) 
				fw.write(";");
		}
		fw.write("\n");
		fw.close();
		resultadoCriacao = true;
		return resultadoCriacao;
	}
	
	/* Remove uma tabela associada a um arquivo. */
	public boolean removerArquivo(String nomeTabela) throws IOException
	{
		boolean resultadoRemocao = false;
		File arquivoTabela = new File(nomeTabela);
		if (arquivoTabela.exists())
			resultadoRemocao = arquivoTabela.delete();
		return resultadoRemocao;
	}
	
	/* Insere valores no arquivo da tabela*/
	public boolean inserirArquivo( String nomeTabela, String[] valoresColunas) throws IOException
	{
		boolean resultadoInsercao = false;
		File arquivoTabela = new File(nomeTabela);
		//Verificando se a tabela existe e se � poss�vel ler dele
		if (arquivoTabela.exists()  && arquivoTabela.canRead())
		{
			//System.out.println("Posso escrever na tabela..");
		    // Leitor de arquivo referenciando o arquivo da tabela.
			FileReader fr = new FileReader(arquivoTabela);
			// Buffer de leitura referenciando o leitor de arquivo
			BufferedReader br = new BufferedReader(fr);
			//Array list que armazena as linhas a serem escritas 
			ArrayList<String> linhas = new ArrayList<String>();
			// Linha atual
			String linhaAtual = "";		
                        //Efetua-se a leitura das linhas at� que n�o haja mais linhas para ler	
                        while ( (linhaAtual = br.readLine()) != null)
                            linhas.add(linhaAtual);
			linhaAtual = "";
                        for (int i = 0; i< valoresColunas.length; ++i)
                            {
                                linhaAtual = linhaAtual + valoresColunas[i];
                                if (i != (valoresColunas.length-1) )
                                    linhaAtual = linhaAtual +";";
                            }
			linhas.add(linhaAtual);
			/* Fechamento do buffer de leitura e do leitor de arquivo*/
			br.close();
			fr.close();
			FileWriter fw = new FileWriter(arquivoTabela);
			BufferedWriter bw = new BufferedWriter(fw);
                            for(String linha: linhas)
                            {
                                bw.write(linha);
                                bw.newLine();
                            }			
			bw.close();
			fw.close();
			resultadoInsercao = true;
		}
		return resultadoInsercao;		
	}
        
        /* Método que retorna uma lista de elementos presentes na 
	 * tabela que satisfazem determinado critério. Retorna uma
	 * lista vazia caso nenhum elemento satisfaça o critério ou
	 * a tabela não exista. */
	public boolean lerArquivo(String nomeTabela, String usuario, String senha) throws IOException
	{int cont = 0;
		String cabecalhoTabela = "";
		String linhaCorrente = "";
                String[][] valoresEncontradosArr;
		ArrayList<ArrayList<String>> valoresEncontrados = new ArrayList<ArrayList<String>>();
		File arquivoTabela = new File(nomeTabela);
		
		//Verificando se a tabela existe e se é possível ler dela
		if (arquivoTabela.exists()  && arquivoTabela.canRead())
		{
		    try {
				// Leitor de arquivo referenciando o arquivo da tabela.
				FileReader fr = new FileReader(arquivoTabela);
				// Buffer de leitura referenciando o leitor de arquivo
				BufferedReader br = new BufferedReader(fr);
				//Array list que armazena as linhas a serem escritas 
				cabecalhoTabela = br.readLine();
				String [] nomeColunas = cabecalhoTabela.split(";");
				int indiceColuna = 0;//Coluna do USUARIO
				/*for (int i=0; i< nomeColunas.length; ++ i)
				{
					if (nomeColunas[i].equals(nomeColuna))
					{
						indiceColuna = i;
						break;
					}
				}*/
				if (indiceColuna == 0) //Coluna encontrada
				{
					while ( (linhaCorrente = br.readLine())!= null)
					{
						String [] colunaCorrente = linhaCorrente.split(";");
						if ( colunaCorrente[indiceColuna].equals(usuario)) //Achada uma ocorrência 
						{
							/*ArrayList<String> linhaEncontrada = new ArrayList<String>();
							for (int i=0; i< colunaCorrente.length; ++i)
							{
								linhaEncontrada.add(colunaCorrente[i]);
							}
							valoresEncontrados.add(linhaEncontrada);*/
                                                        if( colunaCorrente[indiceColuna+1].equals(senha))
                                                            cont = 1;
						}
					}
				}
				br.close();
				fr.close();
		    } 
		    catch (Exception e) {return false;} //Não faz nada em caso de exceção
		}	
	
                if (!valoresEncontrados.isEmpty())
                {
                    valoresEncontradosArr = new String[valoresEncontrados.size()][valoresEncontrados.get(0).size()];
                    for(int i=0; i< valoresEncontrados.size(); ++i)
                    {   
                       ArrayList<String> lin = valoresEncontrados.get(i);
                       valoresEncontradosArr[i] =  lin.toArray(valoresEncontradosArr[i]); 
                    }                           
                } 
                else
                    valoresEncontradosArr = new String[0][0];                
		//return valoresEncontradosArr;
                if (cont == 0)
                    return false;
                else
                    return true;
	}
        
}