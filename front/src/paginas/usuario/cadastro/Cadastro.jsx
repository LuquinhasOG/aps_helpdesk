import { useState } from 'react';
import FormularioCadastroUsuario from './FormularioCadastroUsuario';
import UsuarioServico from "../../../servicos/UsuarioServico";

const usuarioServico = new UsuarioServico();

const modeloInformacoesFormulario = {
    nome: "",
    senha: "",
    email: "",
    dataNascimento: "",
    nivelPermissao: 1
}

function Cadastro() {
    const [informacoesFormulario, setInformacoesFormulario] = useState(modeloInformacoesFormulario);

    const eventoAtualizarAoDigitar = (evento) => {
        setInformacoesFormulario({...informacoesFormulario, [evento.target.name]:evento.target.value})
        console.log(informacoesFormulario)
    }

    const eventoCadastrarUsuario = (evento) => {
        // atualizando novamente para evitar erro nas informações enviadas
        eventoAtualizarAoDigitar(evento)
        usuarioServico.cadastrar(informacoesFormulario);
    }

    return (
        <div className='d-flex justify-content-center'>
            <FormularioCadastroUsuario evento_atualizar={eventoAtualizarAoDigitar} evento_cadastrar_usuario={eventoCadastrarUsuario} />
                   
        </div>
    );
}

export default Cadastro;