import { formatadorDataHora } from "../../util/formatadores";

function Comentario({comentario}:any) {
    return (
        <div className="container bg-light mb-3 rounded">
            <p>{comentario.conteudo_comentario}</p>
            <div className="d-flex">
                <p>{ (comentario.permissao > 1) ? "equipe de atendimento" : "usuário" }: {comentario.usuario_publicacao}</p>
                { (comentario.data_publicacao != undefined) ?
                    <p className="ms-auto">{formatadorDataHora.format(comentario.data_publicacao)}</p> : null
                }
            </div>
        </div>
    );
}

export default Comentario;