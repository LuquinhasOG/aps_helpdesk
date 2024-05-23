import { useState } from "react";
import Comentario from "./Comentario";

const comentarioModelo = {
	conteudo_comentario: "",
	data_publicacao: new Date(),
	id_usuario_publicacao: localStorage.getItem("id_usuario")
};

function ContainerComentarios({comentarios, estado_ticket}) {
    const [respostaEscrita, setRespostaEscrita] = useState(comentarioModelo);

    const criarInputReposta = () => {
        if (estado_ticket == "Aberto") {
            return (<div className="d-flex justify-content-center">
                        <div className="flex-column">
                            <p>Escreva sua resposta:</p>
                            <form>
                                <textarea name="conteudo_comentario" style={{width: "45rem", height: "10rem"}} onChange={eventoAtualizarEscrevendoResposta}></textarea>
                                <input className="row ms-auto" type="button" onClick={eventoEnviarResposta} value="enviar" />
                            </form>
                        </div>
                    </div>);
        }

        return null;
    }

    const eventoAtualizarEscrevendoResposta = (evento) => {
        setRespostaEscrita({...respostaEscrita, [evento.target.name]:evento.target.value})
    }

    const eventoEnviarResposta = (evento) => {
        const temp = {...respostaEscrita};
        temp.data_publicacao = new Date();
        setRespostaEscrita(temp)
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