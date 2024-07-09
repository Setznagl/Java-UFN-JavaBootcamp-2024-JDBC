package Jdbc.services;

import Jdbc.daos.DAO_ator;
import Jdbc.daos.DAO_categoria;
import Jdbc.daos.DAO_genero;
import Jdbc.models.ator;
import Jdbc.models.categoria;
import Jdbc.models.genero;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Menu {

    public static int selectTable() {
        System.out.println("Selecione a planilha para interação!");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1 - Ator\n" + " 2 - Categoria\n" + " 3 - Genero\n");
        try {
            int choice = sc.nextInt();
            if (choice > 3 || choice < 1) {
                throw new InputMismatchException();
            }
            return choice;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return 0;
    }

    public static int selectFunction() {
        System.out.println("Selecione a planilha para interação!");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1 - Inserir\n" + " 2 - Ler um\n" + " 3 - Ler todos\n"
                + " 4 - Atualizar um registro\n" + " 5 - Excluir um registro\n");
        try {
            int choice = sc.nextInt();
            if (choice > 5 || choice < 1) {
                throw new InputMismatchException();
            }
            return choice;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return 0;
    }

    public static void flowTree(int choiceTable, int choiceFunction) {
        Scanner sc = new Scanner(System.in);
        switch (choiceTable) {
            //Tabela Ator
            case 1: {
                switch (choiceFunction) {
                    //Insert
                    case 1: {
                        DAO_ator a = DAO_Factory.create_DAO_ator();
                        System.out.println("Insira um nome para o ator!");
                        String tmp_nome = scannerString();
                        // Instanciando um ator para inserir no banco
                        ator tmp_ator = new ator();
                        // Setando apenas o nome, uma vez que o ID é Serial
                        tmp_ator.setNome(tmp_nome);
                        // Passando o ator temporário como parametro pro insert
                        DAO_ator.insertAtor(tmp_ator);
                        break;
                    }
                    //Read by id
                    case 2: {
                        DAO_ator a = DAO_Factory.create_DAO_ator();
                        System.out.println("Insira um ID de registro para busca!");
                        int tmp_id = scannerInt();
                        // chamando a instância única do DAO para invocar o método de CRUD
                        DAO_ator.readAtor(tmp_id);
                        break;
                    }
                    //Read all
                    case 3: {
                        DAO_ator a = DAO_Factory.create_DAO_ator();
                        System.out.println("Buscando Registros...");
                        DAO_ator.readAllAtor();
                        break;
                    }
                    //Update
                    case 4: {
                        DAO_ator a = DAO_Factory.create_DAO_ator();
                        System.out.println("Insira o ID do registro que será alterado.");
                        int tmp_id = scannerInt();
                        System.out.println("Insira o novo nome.");
                        String tmp_nome = scannerString();
                        // montando objeto ator para envio
                        ator tmp_ator = new ator();
                        tmp_ator.setNome(tmp_nome);
                        tmp_ator.setCod_ator(tmp_id);
                        // Chamando o método update
                        DAO_ator.updateAtor(tmp_ator);
                        break;
                    }
                    //Delete by ID
                    case 5: {
                        DAO_ator a = DAO_Factory.create_DAO_ator();
                        System.out.println("Insira o ID do registro que será deletado.");
                        //Criando objeto parâmetro
                        int tbm_id = scannerInt();
                        ator tmp_ator = new ator();
                        tmp_ator.setCod_ator(tbm_id);
                        //Enviando objeto como parâmetro
                        DAO_ator.deleteAtor(tmp_ator);
                        break;
                    }
                    default:
                        break;
                }break;
            }
            //Tabela Categoria
            case 2: {
                switch (choiceFunction) {
                    //Insert
                    case 1: {
                        // Valores temporários
                        DAO_categoria a = DAO_Factory.create_DAO_categoria();
                        System.out.println("Insira um nome para a categoria!");
                        String tmp_nome = scannerString();
                        System.out.println("Insira um preco para essa categoria!");
                        float tmp_valor = scannerFloat();

                        // Criando objeto com os valores temporários
                        categoria tmp_categoria = new categoria();
                        tmp_categoria.setNome(tmp_nome);
                        tmp_categoria.setValor(tmp_valor);

                        // Chamar o método passando o objeto
                        DAO_categoria.insertCategoria(tmp_categoria);
                        break;
                    }
                    //Read by id
                    case 2: {
                        DAO_categoria a = DAO_Factory.create_DAO_categoria();
                        System.out.println("Insira um ID de registro para busca!");
                        int tmp_id = scannerInt();
                        // chamando a instância única do DAO para invocar o método de CRUD
                        DAO_categoria.readCategoria(tmp_id);
                        break;
                    }
                    //Read all
                    case 3: {
                        DAO_categoria a = DAO_Factory.create_DAO_categoria();
                        System.out.println("Buscando Registros...");
                        DAO_categoria.readAllCategoria();
                        break;
                    }
                    //Update
                    case 4: {
                        DAO_categoria a = DAO_Factory.create_DAO_categoria();
                        System.out.println("Insira o ID do registro que será alterado.");

                        //valores temporários
                        int tmp_id = scannerInt();
                        System.out.println("Insira o novo nome.");
                        String tmp_nome = scannerString();
                        System.out.println("Insira um novo valor");
                        float tmp_valor = scannerFloat();

                        // Criando objeto com os valores temporários
                        categoria tmp_categoria = new categoria();
                        tmp_categoria.setNome(tmp_nome);
                        tmp_categoria.setCod_cat(tmp_id);
                        tmp_categoria.setValor(tmp_valor);

                        // Chamar o método passando o objeto
                        DAO_categoria.updateCategoria(tmp_categoria);
                        break;
                    }
                    //Delete by ID
                    case 5: {
                        DAO_categoria a = DAO_Factory.create_DAO_categoria();
                        System.out.println("Insira o ID do registro que será deletado.");
                        //Criando objeto parâmetro
                        int tmp_id = scannerInt();
                        categoria tmp_categoria = new categoria();
                        tmp_categoria.setCod_cat(tmp_id);
                        //Enviando objeto como parâmetro
                        DAO_categoria.deleteCategoria(tmp_categoria);
                        break;
                    }
                    default:
                        break;
                }break;
            }
            //Tabela Genero
            case 3: {
                switch (choiceFunction) {
                    //Insert
                    case 1: {
                        DAO_genero a = DAO_Factory.create_DAO_genero();
                        System.out.println("Insira um nome para o genero!");
                        String tmp_nome = scannerString();
                        // Instanciando um ator para inserir no banco
                        genero tmp_genero = new genero();
                        // Setando apenas o nome, uma vez que o ID é Serial
                        tmp_genero.setNome(tmp_nome);
                        // Passando o valor temporário como parametro pro insert
                        DAO_genero.insertGenero(tmp_genero);
                        break;
                    }
                    //Read by id
                    case 2: {
                        DAO_ator a = DAO_Factory.create_DAO_ator();
                        System.out.println("Insira um ID de registro para busca!");
                        int tmp_id = scannerInt();
                        // chamando a instância única do DAO para invocar o método de CRUD
                        DAO_ator.readAtor(tmp_id);
                        break;
                    }
                    //Read all
                    case 3: {
                        DAO_genero a = DAO_Factory.create_DAO_genero();
                        System.out.println("Buscando Registros...");
                        DAO_genero.readAllgenero();
                        break;
                    }
                    //Update
                    case 4: {
                        DAO_genero a = DAO_Factory.create_DAO_genero();
                        System.out.println("Insira o ID do registro que será alterado.");
                        int tmp_id = scannerInt();
                        System.out.println("Insira o novo nome.");
                        String tmp_nome = scannerString();
                        // montando objeto ator para envio
                        genero tmp_genero = new genero();
                        tmp_genero.setNome(tmp_nome);
                        tmp_genero.setCod_gen(tmp_id);
                        // Chamando o método update
                        DAO_genero.updateAtor(tmp_genero);
                        break;
                    }
                    //Delete by ID
                    case 5: {
                        DAO_genero a = DAO_Factory.create_DAO_genero();
                        System.out.println("Insira o ID do registro que será deletado.");
                        //Criando objeto parâmetro
                        int tbm_id = scannerInt();
                        genero tmp_genero = new genero();
                        tmp_genero.setCod_gen(tbm_id);
                        //Enviando objeto como parâmetro
                        DAO_genero.deleteAtor(tmp_genero);
                        break;
                    }
                    default:
                        break;
                }break;
            }
            default:
                break;
        }
    }

    public static int scannerInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String scannerString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static float scannerFloat() {
        Scanner sc = new Scanner(System.in);
        return sc.nextFloat();
    }

}

