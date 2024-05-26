import { useState } from "react";
import Comentario from "./Comentario";

const comentarioModelo = {
	conteudoComentario: "",
	dataPublicacao: new Date(),
	idUsuarioComentario: localStorage.getItem("id_usuario"),
    idTicketComentario: 0
};

function ContainerComentarios({comentarios, estado_ticket, id_ticket}) {
    const [respostaEscrita, setRespostaEscrita] = useState(comentarioModelo);

    const criarInputReposta = () => {
        if (estado_ticket == "Aberto") {
            return (<div className="d-flex justify-content-center">
                        <div className="flex-column">
                            <p>Escreva sua resposta:</p>
                            <form>
                                <textarea name="conteudoComentario" style={{width: "45rem", height: "10rem"}} onChange={eventoAtualizarEscrevendoResposta}></textarea>
                                <input className="row ms-auto" type="button" onClick={eventoEnviarResposta} value="enviar" />
                            </form>
                        </div>
                    </div>);
        }

        return null;
    }

    const eventoAtualizarEscrevendoResposta = (evento) => {
        const temp = {...respostaEscrita};
        temp.dataPublicacao = new Date();
        temp.idTicketComentario = id_ticket;
        setRespostaEscrita({...temp, [evento.target.name]:evento.target.value})
    }

    const eventoEnviarResposta = (evento) => {
        fetch("http://localhost:8080/comentarios", {
            method: "post",
            body: JSON.stringify(respostaEscrita),
            headers: {
                'Content-type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(retorno => retorno.json())
        .then(retorno => {
            console.log(retorno);
            location.reload();
        })
    }

    return (
        <div className="container border">
            <div className="m-5">
                <h3>Respostas</h3>
                <hr />
                <div>
                    {
                        comentarios.map( c => <Comentario key={c.id_comentario} comentario={c} />)
                    }
                </div>
                {criarInputReposta()}
            </div>
        </div>
    );
}

export default ContainerComentarios;