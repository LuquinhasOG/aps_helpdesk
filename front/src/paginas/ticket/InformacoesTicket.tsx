import { formatadorDataHora } from "../../util/formatadores";
import InformacoesPatrimonio from "./InformacoesPatrimonio";

const modeloAtualizarTicket = {
    usuarioAbertura: 0,
    estadoTicket: 0,
    dataAbertura: "2000-01-01",
    dataFechamento: new Date(),
    titulo: "",
    descricao: "",
    idPatrimonio: ""
}

function InformacoesTicket({conteudo}) {
    const criarBotoesAtualizar = () => {
        let usuarioAtivo = localStorage.getItem("id_usuario");
        let texto = "teste";
        
        if ((usuarioAtivo == conteudo.id_usuario_abertura) && (conteudo.estado_ticket == "Aberto"))
            return (
                <div className="ms-auto">
                    <button id="btn_cancelar" onClick={atualizarEstadoTicket} className="btn btn-light me-4">Cancelar chamado</button>
                    <button id="btn_resolvido" onClick={atualizarEstadoTicket} className="btn btn-light">Problema Resolvido</button>
                </div>
            );
        
        return null;
    }

    const atualizarEstadoTicket = (evento) => {
        let atualizar = {...modeloAtualizarTicket};

        if (evento.target.id == "btn_cancelar") {
            atualizar.estadoTicket = 2;
        } else if (evento.target.id == "btn_resolvido") {
            atualizar.estadoTicket = 3;
        }

        atualizar.titulo = conteudo.titulo;
        atualizar.descricao = conteudo.descricao;
        atualizar.idPatrimonio = conteudo.patrimonio.idPatrimonio;

        fetch(`http://localhost:8080/tickets/${conteudo.id_ticket}`, {
            method: "put",
            body: JSON.stringify(atualizar),
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json",
            }
        })
        .then(retorno => location.reload())
    }

    return (
        <div className="container mb-2">
            <div className="d-flex">
                <h2 id="titulo">{conteudo.titulo}</h2>
                <p>({conteudo.estado_ticket})</p>
            </div>
            <div className="d-flex">
                <p>usuário de abertura: {conteudo.nome_usuario_abertura}</p>
                <p className="ms-auto">abertura: {formatadorDataHora.format(conteudo.data_abertura)}</p>
            </div>
            <div className="border">
                <h5>Descrição do problema:</h5>
                <div className="container">
                    <p>{conteudo.descricao}</p>
                </div>
            </div>
            <InformacoesPatrimonio conteudo={conteudo.patrimonio} />
            <div className="d-flex">
                {criarBotoesAtualizar()}
            </div>
            <hr />
        </div>
    );
}

export default InformacoesTicket