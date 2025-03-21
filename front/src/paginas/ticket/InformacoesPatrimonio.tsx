function InformacoesPatrimonio({conteudo}:any) {
    return (
        <div>
            { (conteudo != undefined) ?
            <div className="container border">
                <h5>Patrimonio:</h5>
                <div className="row">
                    <div className="col">
                        <p>{conteudo.nomePatrimonio}</p>
                        <p>{conteudo.descricao}</p>
                    </div>
                    <div className="col">
                        <p>preço: {conteudo.preco}</p>
                        <p>quantidade: {conteudo.quantidade}</p>
                    </div>
                </div>
            </div>: null
            }
        </div>
    );
}

export default InformacoesPatrimonio;