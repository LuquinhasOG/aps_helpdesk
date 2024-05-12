import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ContainerComentarios from "./ContainerComentarios";
import InformacoesTicket from "./InformacoesTicket";

const comentarios_teste = [
    {
        id_comentario: 1,
        conteudo_comentario: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque rutrum vel elit in faucibus. Sed elit lacus, aliquet sed mi vitae, iaculis aliquam dolor. Donec elementum, sapien non consequat ullamcorper, turpis lorem elementum dui, ac sollicitudin lectus turpis sed augue. Aenean molestie sed nisl cursus elementum. Sed condimentum metus et erat tincidunt, ut accumsan libero mollis. Quisque eu efficitur erat, eu venenatis erat. Sed molestie nunc urna, quis pretium purus euismod non. Donec pulvinar eros et nunc vulputate consectetur. Integer at lectus lacinia, consectetur justo id, cursus dolor.",
        data_publicacao: "2024-05-08",
        usuario_publicacao: "usuário"
    },
    {
        id_comentario: 2,
        conteudo_comentario: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque rutrum vel elit in faucibus. Sed elit lacus, aliquet sed mi vitae, iaculis aliquam dolor. Donec elementum, sapien non consequat ullamcorper, turpis lorem elementum dui, ac sollicitudin lectus turpis sed augue. Aenean molestie sed nisl cursus elementum. Sed condimentum metus et erat tincidunt, ut accumsan libero mollis. Quisque eu efficitur erat, eu venenatis erat. Sed molestie nunc urna, quis pretium purus euismod non. Donec pulvinar eros et nunc vulputate consectetur. Integer at lectus lacinia, consectetur justo id, cursus dolor.",
        data_publicacao: "2024-05-08",
        usuario_publicacao: "equipe de ajuda"
    },
    {
        id_comentario: 3,
        conteudo_comentario: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque rutrum vel elit in faucibus. Sed elit lacus, aliquet sed mi vitae, iaculis aliquam dolor. Donec elementum, sapien non consequat ullamcorper, turpis lorem elementum dui, ac sollicitudin lectus turpis sed augue. Aenean molestie sed nisl cursus elementum. Sed condimentum metus et erat tincidunt, ut accumsan libero mollis. Quisque eu efficitur erat, eu venenatis erat. Sed molestie nunc urna, quis pretium purus euismod non. Donec pulvinar eros et nunc vulputate consectetur. Integer at lectus lacinia, consectetur justo id, cursus dolor.",
        data_publicacao: "2024-05-08",
        usuario_publicacao: "usuário 1"
    },
    {
        id_comentario: 4,
        conteudo_comentario: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque rutrum vel elit in faucibus. Sed elit lacus, aliquet sed mi vitae, iaculis aliquam dolor. Donec elementum, sapien non consequat ullamcorper, turpis lorem elementum dui, ac sollicitudin lectus turpis sed augue. Aenean molestie sed nisl cursus elementum. Sed condimentum metus et erat tincidunt, ut accumsan libero mollis. Quisque eu efficitur erat, eu venenatis erat. Sed molestie nunc urna, quis pretium purus euismod non. Donec pulvinar eros et nunc vulputate consectetur. Integer at lectus lacinia, consectetur justo id, cursus dolor.",
        data_publicacao: "2024-05-08",
        usuario_publicacao: "equipe de ajuda"
    }
];

const modeloInformacoesTicket = {
    titulo: "",
    descricao: "",
    nome_usuario_abertura: "",
    email_usuario_abertura: "",
    permissao_usuario_abertura: 1,
    data_abertura: new Date(),
    data_fechamento: new Date(),
    estado_ticket: ""
}

function Ticket() {
    const [informacoesTicket, setInformacoesTicket] = useState({});
    let { id_ticket } = useParams();

    // busca as informações do cabeçalho do chamado
    useEffect(() => {
        fetch(`http://localhost:8080/tickets/${id_ticket}`)
        .then(retorno_para_json => retorno_para_json.json())
        .then(info_ticket => {
            const temp = { ...modeloInformacoesTicket };
            temp.titulo = info_ticket.titulo;
            temp.descricao = info_ticket.descricao;
            temp.nome_usuario_abertura = info_ticket.usuarioAbertura.nome;
            temp.email_usuario_abertura = info_ticket.usuarioAbertura.email;
            temp.permissao_usuario_abertura = info_ticket.usuarioAbertura.nivelPermissao;
            temp.data_abertura = new Date(info_ticket.dataAbertura);
            temp.data_fechamento = new Date(info_ticket.dataFechamento);
            temp.estado_ticket = info_ticket.estadoTicket.descricao;
            setInformacoesTicket(temp);
        })
    }, [])

    return (
        <div>
            <InformacoesTicket conteudo={informacoesTicket} />
            <ContainerComentarios comentarios={comentarios_teste} />
        </div>
    )
}
export default Ticket;