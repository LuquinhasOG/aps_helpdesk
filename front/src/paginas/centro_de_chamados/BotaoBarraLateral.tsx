function BotaoBarraLateral({ativo, texto, evento_clique}) {
    return (
        <p className={(ativo) ? "btn btn-primary" : "btn"} onClick={evento_clique}>{texto}</p>
    );
}

export default BotaoBarraLateral