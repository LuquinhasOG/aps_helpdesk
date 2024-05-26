import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function CardChamado({conteudo}) {
    const [idTicket, setIdTicket] = useState(0);
    const mudarPagina = useNavigate();

    useEffect(() => {
        setIdTicket(conteudo.idTicket);
    }, [])

    const eventoClique = () => {
        mudarPagina(`../chamado/${idTicket}`);
    }

    return (
        <div className="container bg-light rounded p-4 m-1 col-3" onClick={eventoClique}>
            <p>Título: {conteudo.titulo}</p>
            <p>Usuário: {conteudo.usuarioAbertura.nome}</p>
            <p>Estado: {conteudo.estadoTicket.descricao}</p>
        </div>
    );
}

export default CardChamado;