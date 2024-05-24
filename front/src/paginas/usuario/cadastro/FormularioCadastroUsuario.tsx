function FormularioCadastroUsuario({evento_atualizar, evento_cadastrar_usuario}) {
    return (
        <form className="d-flex flex-column">
            <div className="d-flex flex-column">
                <label>Nome do usuário</label>
                <input type="text" name="nome" onChange={evento_atualizar} />
            </div>
            <div className="d-flex flex-column">
                <label>E-mail</label>
                <input type="email" name="email" onChange={evento_atualizar} />
            </div>
            <div className="d-flex flex-column">
                <label>Senha</label>
                <input type="password" name="senha" onChange={evento_atualizar} />
            </div>
            <div className="d-flex flex-column">
                <label>Data de nascimento</label>
                <input type="date" name="dataNascimento" onChange={evento_atualizar} />
            </div>

            <input className="mt-4" type="button" value="Cadastrar" onClick={evento_cadastrar_usuario} />
        </form>
    );
}

export default FormularioCadastroUsuario;