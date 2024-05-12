import { formatadorDataHora } from "../../util/formatadores";

function InformacoesTicket({conteudo}) {
    return (
        <div className="container mb-2">
            <div>
                <h1 id="titulo">{conteudo.titulo}</h1>
                <div className="d-flex">
                    <p>usuário de abertura: {conteudo.nome_usuario_abertura}</p>
                    <p className="ms-auto">abertura: {formatadorDataHora.format(conteudo.data_abertura)}</p>
                </div>
                <p>Descrição do problema:</p>
                <div className="container">
                    <p>{conteudo.descricao}</p>
                </div>
                <hr />
            </div>
        </div>
    );
}

export default InformacoesTicket