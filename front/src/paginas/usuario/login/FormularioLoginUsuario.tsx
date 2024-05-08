function FormularioLoginUsuario({evento_atualizar, evento_logar}) {
    return (
        <form className="d-flex flex-column">
            <div className="d-flex flex-column">
                <label>Email</label>
                <input type="email" name="email" onChange={evento_atualizar} />
            </div>
            <div className="d-flex flex-column">
                <label>Senha</label>
                <input type="password" name="senha" onChange={evento_atualizar} />
            </div>

            <input className="mt-4" type="button" onClick={evento_logar} value="Entrar" />
        </form>
    );
}

export default FormularioLoginUsuario;