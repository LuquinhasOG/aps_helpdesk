import Comentario from "./Comentario";

const comentarioModelo = {
	conteudo_comentario: "",
	data_publicacao: "",
	usuario_publicacao: ""
};

function ContainerComentarios({comentarios, estado_ticket}) {

    const criarInputReposta = () => {
        if (estado_ticket == "Aberto") {
            return (<div className="d-flex justify-content-center">
                        <div className="flex-column">
                            <p>Escreva sua resposta:</p>
                            <form>
                                <textarea style={{width: "45rem", height: "10rem"}}></textarea>
                                <button className="row ms-auto">Enviar</button>
                            </form>
                        </div>
                    </div>);
        }

        return null;
    }

    return (
        <div className="container">
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