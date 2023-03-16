package model;


import java.util.List;

public record Empresa(String uf,
                      String cep,
                      List<Object> qsa,
                      String cnpj,
                      String pais,
                      String email,
                      String porte,
                      String bairro,
                      String numero,
                      String ddd_fax,
                      String municipio,
                      String logradouro,
                      float cnae_fiscal,
                      String codigo_pais,
                      String complemento,
                      float codigo_porte,
                      String razao_social,
                      String nome_fantasia,
                      float capital_social,
                      String ddd_telefone_1,
                      String ddd_telefone_2,
                      String opcao_pelo_mei,
                      String descricao_porte,
                      float codigo_municipio,
                      List<Object> cnaes_secundarios,
                      String natureza_juridica,
                      String situacao_especial,
                      String opcao_pelo_simples,
                      float situacao_cadastral,
                      String data_opcao_pelo_mei,
                      String data_exclusao_do_mei,
                      String cnae_fiscal_descricao,
                      float codigo_municipio_ibge,
                      String data_inicio_atividade,
                      String data_situacao_especial,
                      String data_opcao_pelo_simples,
                      String data_situacao_cadastral,
                      String nome_cidade_no_exterior,
                      float codigo_natureza_juridica,
                      String data_exclusao_do_simples,
                      float motivo_situacao_cadastral,
                      String ente_federativo_responsavel,
                      float identificador_matriz_filial,
                      float qualificacao_do_responsavel,
                      String descricao_situacao_cadastral,
                      String descricao_tipo_de_logradouro,
                      String descricao_motivo_situacao_cadastral,
                      String descricao_identificador_matriz_filial) {
}