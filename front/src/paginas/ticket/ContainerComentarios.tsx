import Comentario from "./Comentario";

const comentarioModelo = {
	conteudo_comentario: "",
	data_publicacao: "",
	usuario_publicacao: ""
};

function ContainerComentarios({comentarios}) {

    return (
        <div className="container">
            <div className="m-5">
                <h2>Comentários</h2>
                <hr />
                <div>
                    {
                        comentarios.map( c => <Comentario key={c.id_comentario} comentario={c} />)
                    }
                </div>
            </div>
        </div>
    );
}

export default ContainerComentarios;