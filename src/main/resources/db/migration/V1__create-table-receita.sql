CREATE TABLE receita(
    rec_id SERIAL PRIMARY KEY,
    rec_nome TEXT,
    rec_tempo_de_preparo TEXT,
    rec_imagem TEXT,
    rec_passo_a_passo TEXT,
    rec_quantidade_diversa_de_itens INTEGER,
    usu_nome_de_conta TEXT,
    ava_id INTEGER
);