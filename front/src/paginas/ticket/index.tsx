import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ContainerComentarios from "./ContainerComentarios";
import InformacoesTicket from "./InformacoesTicket";
import "./Ticket.css"

const modeloComentario = {
    id_comentario: 0,
    conteudo_comentario: "",
    data_publicacao: new Date(),
    usuario_publicacao: "",
    permissao: 0
}

const modeloInformacoesTicket = {
    id_ticket: 0,
    titulo: "",
    descricao: "",
    id_usuario_abertura: 0,
    nome_usuario_abertura: "",
    email_usuario_abertura: "",
    permissao_usuario_abertura: 1,
    data_abertura: new Date(),
    data_fechamento: new Date(),
    estado_ticket: "",
    patrimonio: {}
}

function Ticket() {
    const [informacoesTicket, setInformacoesTicket] = useState({});
    const [comentarioTicket, setComentariosTicket] = useState([]);
    let { id_ticket } = useParams();

    // busca as informações do cabeçalho do chamado
    useEffect(() => {
        fetch(`http://localhost:8080/tickets/${id_ticket}`)
        .then(retorno_para_json => retorno_para_json.json())
        .then(info_ticket => {
            const temp = { ...modeloInformacoesTicket };
            temp.id_ticket = info_ticket.idTicket;
            temp.titulo = info_ticket.titulo;
            temp.descricao = info_ticket.descricao;
            temp.id_usuario_abertura = info_ticket.usuarioAbertura.idUsuario;
            temp.nome_usuario_abertura = info_ticket.usuarioAbertura.nome;
            temp.email_usuario_abertura = info_ticket.usuarioAbertura.email;
            temp.permissao_usuario_abertura = info_ticket.usuarioAbertura.nivelPermissao;
            temp.data_abertura = new Date(info_ticket.dataAbertura);
            temp.data_fechamento = new Date(info_ticket.dataFechamento);
            temp.estado_ticket = info_ticket.estadoTicket.descricao;
            temp.patrimonio = info_ticket.patrimonioTicket
            setInformacoesTicket(temp);
        })

        fetch(`http://localhost:8080/comentarios/ticket/${id_ticket}`)
        .then(retorno_para_json => retorno_para_json.json())
        .then(info_ticket => {
            const salvar = [];

            info_ticket.map(el => {
                const temp = {...modeloComentario};
                temp.id_comentario = el.idComentario;
                temp.conteudo_comentario = el.conteudoComentario;
                temp.data_publicacao = new Date(el.dataPublicacao);
                temp.usuario_publicacao = el.usuarioComentario.nome;
                temp.permissao = el.usuarioComentario.nivelPermissao;
                salvar.push(temp);
            })

            setComentariosTicket(salvar);
        })
    }, [])

    return (
        <div id="conteudo-ticket">
            <InformacoesTicket conteudo={informacoesTicket} />
            <ContainerComentarios id_ticket={id_ticket} estado_ticket={informacoesTicket.estado_ticket} comentarios={comentarioTicket} />
        </div>
    )
}
export default Ticket;