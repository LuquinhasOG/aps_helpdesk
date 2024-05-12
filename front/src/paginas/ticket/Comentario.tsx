function Comentario({comentario}) {
    return (
        <div className="container bg-light mb-3 rounded">
            <p>{comentario.conteudo_comentario}</p>
            <div className="d-flex">
                <p>usuário de publicação: {comentario.usuario_publicacao}</p>
                <p className="ms-auto">{comentario.data_publicacao}</p>
            </div>
        </div>
    );
}

export default Comentario;