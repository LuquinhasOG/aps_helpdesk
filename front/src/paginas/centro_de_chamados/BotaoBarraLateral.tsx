function BotaoBarraLateral({ativo, id_botao, texto, evento_clique}) {
    return (
        <p className={(ativo == id_botao) ? "btn btn-primary" : "btn"} onClick={evento_clique}>{texto}</p>
    );
}

export default BotaoBarraLateral