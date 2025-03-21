import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import FormularioLoginUsuario from "./FormularioLoginUsuario";
import UsuarioServico from '../../../servicos/UsuarioServico';

const modeloLoginFormulario = {
    email: "",
    senha: ""
}

let usuarioServico: UsuarioServico = new UsuarioServico();

function Login() {
    const [informacoesFormulario, setInformacoesFormulario] = useState(modeloLoginFormulario);
    const mudarPagina = useNavigate();

    const eventoAtualizarAoDigitar = (evento:any) => {
        setInformacoesFormulario({...informacoesFormulario, [evento.target.name]:evento.target.value})
        console.log(informacoesFormulario)
    }

    const eventoLogar = async () => {
        usuarioServico.logar(informacoesFormulario, true);
    }

    useEffect(() => {
        if (usuarioServico.validarLogin()) {
            mudarPagina("../../centrodechamados");
        }
    })

    return (
        <div className='d-flex justify-content-center'>
            <FormularioLoginUsuario evento_atualizar={eventoAtualizarAoDigitar} evento_logar={eventoLogar} />
        </div>
    );
}

export default Login;